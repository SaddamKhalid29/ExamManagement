/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.student;

import com.uog.exam.entity.CourseEntity;
import com.uog.exam.entity.CourseRegistrationEntity;
import com.uog.exam.entity.StudentEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class CourseRegisterManager implements CourseRegisterManagerRemote {

    @PersistenceContext(unitName = "ExamPU")
            
    EntityManager entityManager;
    
    @Override
    public CourseRegistrationEntity registerStudentInCourse(StudentEntity stdID, CourseEntity courseID, String registrationYear) throws WrongParameterException {
        CourseRegistrationEntity registrationEntity = new CourseRegistrationEntity();

        if (registrationYear == null || registrationYear.isEmpty()) {
            throw new WrongParameterException("Registration Year can't be empty.");
        } else {
            registrationEntity.setCourseRegStudentID(stdID);
            
            registrationEntity.setCourseRegCourseID(courseID);
            
            registrationEntity.setCourseRegYear(registrationYear);

            entityManager.persist(registrationEntity);
            
            entityManager.flush();

            System.out.println("Course is assigned to this student.");
        }

        return registrationEntity;
    }

    @Override
    public List<CourseRegistrationEntity> getAllRegisteredCourse() throws StudentNotFoundException {
        Query qry = entityManager.createNamedQuery("CourseRegistrationEntity.findAll");
        List<CourseRegistrationEntity> allRegistered = qry.getResultList();

        if (allRegistered == null || allRegistered.isEmpty()) {
            throw new StudentNotFoundException("No course is registered to any student found in the database");
        }

        return allRegistered;
    }

}
