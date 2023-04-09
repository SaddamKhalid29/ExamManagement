/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.course;

import com.uog.exam.entity.CourseEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class CourseManager implements CourseManagerRemote {
    
    @PersistenceContext(unitName = "ExamPU")
    EntityManager EntityManager;
    
    @Override
    public CourseEntity addCourse(String courseTitle, String courseCode, int courseCreditHours) throws WrongParameterException {
        CourseEntity courseEntity = new CourseEntity();
        if (courseTitle == null || courseTitle.isEmpty()) {
            System.out.println("Course Title is not valid");
        } else {
            courseEntity.setCourseTitle(courseTitle);
        }
        if (courseCode == null || courseCode.isEmpty()) {
            System.out.println("Course Code is not valid");
        } else {
            courseEntity.setCourseCode(courseCode);
        }
        if (courseCreditHours < 1 || courseCreditHours > 4) {
            System.out.println("Credit hours are not valid. It should be in between 1 and 4.");
        } else {
            courseEntity.setCourseCredithrs(courseCreditHours);
        }
        EntityManager.persist(courseEntity);
        
        return courseEntity;
        
    }
    
}

