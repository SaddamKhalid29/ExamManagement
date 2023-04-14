/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uog.exam.faculty;

import com.uog.exam.entity.FacultyEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author User
 */
@Remote
public interface FacultyManagerRemote {

    public FacultyEntity addNewFaculty(String facultyName, String facultyEmail, String facultyContactNo, String facultyDesignation, boolean isVisiting) throws WrongParameterException;

    public FacultyEntity getFacultyId(int facultyId) throws FacultyNotFoundException;

    public FacultyEntity getFacultyByName(String facultyName) throws FacultyNotFoundException, DatabaseInconsistentStateException;

    public FacultyEntity updateFacultyName(int facultyID, String newStdName, String newFaculyDesignation, String newFacultyEmail, String newFacultyContact, boolean isVisiting) throws FacultyNotFoundException, WrongParameterException;

    public void deleteFacultyById(int facultyId) throws FacultyNotFoundException;

    public List<FacultyEntity> getAllFaculty() throws FacultyNotFoundException;

    public String textMessage(String str);
}
