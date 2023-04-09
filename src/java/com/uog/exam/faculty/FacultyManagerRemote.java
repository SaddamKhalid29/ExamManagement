/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uog.exam.faculty;

import com.uog.exam.entity.FacultyEntity;
import javax.ejb.Remote;

/**
 *
 * @author User
 */
@Remote
public interface FacultyManagerRemote {
    
    public FacultyEntity addNewFaculty(String facultyName,String facultyEmail,String facultyContactNo,String facultyDesignation, boolean isVisiting) throws WrongParameterException;
    
}
