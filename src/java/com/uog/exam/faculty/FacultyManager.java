/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.faculty;

import com.uog.exam.entity.FacultyEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
