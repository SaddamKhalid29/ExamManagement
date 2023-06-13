/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uog.exam.users;

import com.uog.exam.entity.UserEntity;
import javax.ejb.Remote;

/**
 *
 * @author User
 */
@Remote
public interface UserMangerRemote {

    public UserEntity addUser(String userName, String userPassword, String userEmail, String userType) throws WrongParameterException;

    public void deleteUser(int userID) throws UserNotFoundException;

    public UserEntity updatePassword(int userID, String newPassword) throws WrongParameterException;

    public UserEntity loginUser(String userName, String userPassword) throws WrongParameterException;

    public UserEntity findUserByUserName(String userName) throws UserNotFoundException;

    public UserEntity login(String userName, String Password, String email) throws WrongParameterException;
}
