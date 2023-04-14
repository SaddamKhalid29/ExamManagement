/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uog.exam.student;

import com.uog.exam.entity.StudentEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author User
 */

@Remote
public interface StudentManagerRemote {
    
    public StudentEntity addNewStudent(String rollNo, String name, int semester, String section, String email, String contact) throws WrongParameterException;

    public StudentEntity getStudentId(int stdId) throws StudentNotFoundException;

    public StudentEntity getStudentByName(String stdName) throws StudentNotFoundException, DatabaseInconsistentStateException;

    public StudentEntity updateStudent(int stdID, String newStdName,String stdRollNo, String stdEmail, String stdContact,int semester, String section) throws StudentNotFoundException, WrongParameterException;
    
    public StudentEntity getStudentByRollNo(String stdRollNo) throws StudentNotFoundException, DatabaseInconsistentStateException;
    
    public void deleteStudentById(int stdId) throws StudentNotFoundException;

    public String textMessage(String str);
    
    public List<StudentEntity> getAllStudents() throws  StudentNotFoundException;
}
