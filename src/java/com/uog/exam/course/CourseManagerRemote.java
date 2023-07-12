/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uog.exam.course;

import com.uog.exam.entity.CourseEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author User
 */
@Remote
public interface CourseManagerRemote {

    public CourseEntity addCourse(String courseTitle, String courseCode, int courseCreditHours) throws WrongParameterException;

    public CourseEntity getCourseById(int courseId) throws CourseNotFoundException;

    public CourseEntity getCourseByTitle(String courseTitle) throws CourseNotFoundException, DatabaseInconsistentStateException;
    
    public CourseEntity getCourseByCourseCode(String courseCode) throws CourseNotFoundException;
    
    public void deleteCourseByCourseCode(String courseCode) throws CourseNotFoundException,DatabaseInconsistentStateException;
    
    public CourseEntity updateCourseTitle(int courseId, String newCoursedTitle,String courseCode, int creditHours) throws CourseNotFoundException, WrongParameterException;
    
    public List<CourseEntity> getAllCourses() throws CourseNotFoundException;
    
    public void deleteCourse(int courseId) throws CourseNotFoundException;
}
