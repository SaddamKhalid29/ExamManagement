/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uog.exam.student;

import com.uog.exam.entity.CourseEntity;
import com.uog.exam.entity.CourseRegistrationEntity;
import com.uog.exam.entity.StudentEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author User
 */
@Remote
public interface CourseRegisterManagerRemote {
    
    public CourseRegistrationEntity registerStudentInCourse( StudentEntity stdID, CourseEntity courseID, String registrationYear) throws WrongParameterException;
    
    public List<CourseRegistrationEntity> getAllRegisteredCourse() throws  StudentNotFoundException;

}