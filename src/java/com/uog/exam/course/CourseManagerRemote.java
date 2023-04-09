/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uog.exam.course;

import com.uog.exam.entity.CourseEntity;
import com.uog.exam.entity.CourseEntity;
import javax.ejb.Remote;

/**
 *
 * @author User
 */
@Remote
public interface CourseManagerRemote {
    public CourseEntity addCourse(String courseTitle, String courseCode,int courseCreditHours) throws WrongParameterException;
}
