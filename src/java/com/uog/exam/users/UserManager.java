/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.users;

import com.uog.exam.entity.StudentEntity;
import com.uog.exam.entity.UserEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class UserManager implements UserMangerRemote {

    @PersistenceContext(unitName = "ExamPU")
    EntityManager entityManager;

    @Override
    public UserEntity addUser(String userName, String userPassword, String userEmail, String userType) throws WrongParameterException {
        UserEntity userEntity = new UserEntity();
        if (userName == null || userName.isEmpty()) {
            throw new WrongParameterException("The username is not valid");
        }
        if (userPassword == null || userPassword.isEmpty() || userPassword.length() < 5) {
            throw new WrongParameterException("This password is not valid");
        }
        if (userEmail == null || userEmail.isEmpty()) {
            throw new WrongParameterException("This email is not valid");
        }
        if (userType == null || userType.isEmpty()) {
            throw new WrongParameterException("The usertype is not valid");
        } else {
            userEntity.setUserName(userName);
            userEntity.setUserPassword(userPassword);
            userEntity.setUserEmail(userEmail);
            userEntity.setUserType(userType);
        }
        entityManager.persist(userEntity);
        System.out.println("New User for login is added!");
        return userEntity;
    }

    @Override
    public UserEntity login(String userName, String Password, String email) throws WrongParameterException {

        try {
            UserEntity user = null;
            user = findUserByUserName(userName);
            if (user.getUserName() == userName && user.getUserEmail() == email && user.getUserPassword() == Password) {

                System.out.println("The user is valid.");
            }
        } catch (UserNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public void deleteUser(int userID) throws UserNotFoundException {
        UserEntity userEntity = entityManager.find(UserEntity.class, userID);
        if (userEntity == null) {
            throw new UserNotFoundException("This user does not exist.");
        } else {
            entityManager.remove(userEntity);
            System.out.println("User with this id : " + userID + " is removed.");
        }
    }

    @Override
    public UserEntity updatePassword(int userID, String newPassword) throws WrongParameterException {
        UserEntity userEntity = entityManager.find(UserEntity.class, userID);
        if (newPassword == null || newPassword.isEmpty() || newPassword.length() < 5) {
            throw new WrongParameterException("This password is not valid");
        } else {
            userEntity.setUserPassword(newPassword);
            entityManager.persist(userEntity);
        }
        return userEntity;
    }

    @Override
    public UserEntity findUserByUserName(String userName) throws UserNotFoundException {

        UserEntity userEntity;
        Query qry = entityManager.createNamedQuery("UserEntity.findByUserName");
        qry.setParameter("userName", userName);
        userEntity = (UserEntity) qry.getSingleResult();
        if (userEntity == null) {
            throw new UserNotFoundException("No user exist with this usernname : " + userName);
        }
        return userEntity;

    }

    public UserEntity findPassword(String userPass) throws UserNotFoundException {

        UserEntity userEntity;
        Query qry = entityManager.createNamedQuery("UserEntity.findByUserPassword");
        qry.setParameter("userPassword", userPass);
        userEntity = (UserEntity) qry.getSingleResult();
        if (userEntity == null) {
            throw new UserNotFoundException("No such passkey exist.");
        }
        return userEntity;
    }

    @Override
    public UserEntity loginUser(String userName, String userPassword) throws WrongParameterException {
        try {
            UserEntity userEntity = findUserByUserName(userName);
            if (userEntity.getUserName().equals(userName) && userEntity.getUserPassword().equals(userPassword)) {
                System.out.println("Login Successfully!");
            } else {
                System.out.println("Username or password is incorrect!");
                throw new WrongParameterException("Username or password is incorrect!");
            }
        } catch (UserNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
