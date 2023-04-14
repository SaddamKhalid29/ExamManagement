/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.faculty;

import com.uog.exam.entity.FacultyEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class FacultyManager implements FacultyManagerRemote {

    @PersistenceContext(unitName = "ExamPU")
    EntityManager entityManager;

    @Override
    public FacultyEntity addNewFaculty(String facultyName, String facultyEmail, String facultyContactNo, String facultyDesignation, boolean isVisiting) throws WrongParameterException {

        FacultyEntity facultyEntity = new FacultyEntity();
        if (facultyName == null || facultyName.isEmpty()) {
            System.out.println("Faculty name is not a valid.");
        } else {
            facultyEntity.setFacultyName(facultyName);
        }
        if (facultyEmail == null || facultyEmail.isEmpty()) {
            System.out.println("Faculty email is not a valid.");
        } else {
            facultyEntity.setFacultyEmail(facultyEmail);
        }
        if (facultyContactNo == null || facultyContactNo.isEmpty()) {
            System.out.println("Faculty contact no. is not a valid.");
        } else {
            facultyEntity.setFacultyContactNo(facultyContactNo);
        }
        if (facultyDesignation == null || facultyDesignation.isEmpty()) {
            System.out.println("Faculty designation is not a valid.");
        } else {
            facultyEntity.setFacultyDesignation(facultyDesignation);
        }
        facultyEntity.setFacultyVisitingStatus(isVisiting);

        entityManager.persist(facultyEntity);

        return facultyEntity;

    }

    @Override
    public FacultyEntity getFacultyId(int facultyId) throws FacultyNotFoundException {
        //Find out the faculty id from FacultyEntity class and store it in facultyEntity variable
        FacultyEntity facultyEntity = entityManager.find(FacultyEntity.class, facultyId);
        //checking if facultyEntity is null or not...
        if (facultyEntity == null) {
            throw new FacultyNotFoundException("The faculty with the required id is not found." + facultyId);
        } else {
            return facultyEntity;
        }
    }

    //Method to get faculty by  Faculty_Name
    @Override
    public FacultyEntity getFacultyByName(String facultyName) throws FacultyNotFoundException, DatabaseInconsistentStateException {
        Query qry = entityManager.createNamedQuery("FacultyEntity.findByFacultyName");
        qry.setParameter("facultyName", facultyName);

        FacultyEntity facultyEntity = null;
        try {
            facultyEntity = (FacultyEntity) qry.getSingleResult();

        } catch (NoResultException ne) {
            throw new FacultyNotFoundException("Faculty with this Faculty_Name is not found : " + facultyName);
        } catch (NonUniqueResultException nue) {
            throw new FacultyNotFoundException("Multiple records found for the Faculty_Name : " + facultyName + " . Please checl DB for consistency.");

        }
        return facultyEntity;
    }

    //Method to update faculty Faculty_Name
    @Override
    public FacultyEntity updateFacultyName(int facultyID, String newFacultyName, String newFaculyDesignation, String newFacultyEmail, String newFacultyContact, boolean isVisiting) throws FacultyNotFoundException, WrongParameterException {

        FacultyEntity facultyEntity = getFacultyId(facultyID);
        if (newFacultyName == null || newFacultyName.isEmpty()) {
            System.out.println("Faculty name is not a valid.");
        } else {
            facultyEntity.setFacultyName(newFacultyName);
        }
        if (newFacultyEmail == null || newFacultyEmail.isEmpty()) {
            System.out.println("Faculty email is not a valid.");
        } else {
            facultyEntity.setFacultyEmail(newFacultyEmail);
        }
        if (newFacultyContact == null || newFacultyContact.isEmpty()) {
            System.out.println("Faculty contact no. is not a valid.");
        } else {
            facultyEntity.setFacultyContactNo(newFacultyContact);
        }
        if (newFaculyDesignation == null || newFaculyDesignation.isEmpty()) {
            System.out.println("Faculty designation is not a valid.");
        } else {
            facultyEntity.setFacultyDesignation(newFaculyDesignation);
        }
        facultyEntity.setFacultyVisitingStatus(isVisiting);

        entityManager.persist(facultyEntity);

        return facultyEntity;
    }

    @Override
    public void deleteFacultyById(int facultyId) throws FacultyNotFoundException {
        FacultyEntity facultyEntity;
        facultyEntity = getFacultyId(facultyId);
        entityManager.remove(facultyEntity);
        System.out.println("Faculty with the id : " + facultyId + " is removed");
    }

    @Override
    public List<FacultyEntity> getAllFaculty() throws FacultyNotFoundException {
        Query qry = entityManager.createNamedQuery("FacultyEntity.findAll");
        List<FacultyEntity> allFaculty = qry.getResultList();
        if (allFaculty == null || allFaculty.isEmpty()) {
            throw new FacultyNotFoundException("No faculty found in database");
        }
        return qry.getResultList();
    }

    @Override
    public String textMessage(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
