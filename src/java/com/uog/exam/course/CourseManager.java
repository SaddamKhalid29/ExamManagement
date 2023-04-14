/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.course;

import com.uog.exam.entity.CourseEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CourseManager implements CourseManagerRemote {

    @PersistenceContext(unitName = "ExamPU")
    EntityManager entityManager;

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
        entityManager.persist(courseEntity);

        return courseEntity;

    }

    @Override
    public CourseEntity getCourseById(int courseId) throws CourseNotFoundException {

        CourseEntity courseEntity = entityManager.find(CourseEntity.class, courseId);
        if (courseEntity == null) {
            throw new CourseNotFoundException("The course with the given id " + courseId + " is not found.");
        } else {
            return courseEntity;
        }
    }

    @Override
    public CourseEntity getCourseByTitle(String courseTitle) throws CourseNotFoundException, DatabaseInconsistentStateException {

        Query qry = entityManager.createNamedQuery("CourseEntity.findByCourseTitle");
        qry.setParameter("courseTitle", courseTitle);
        CourseEntity courseEntity = null;
        try {
            courseEntity = (CourseEntity) qry.getSingleResult();

        } catch (NoResultException ne) {
            throw new CourseNotFoundException("Course with this title is not found : " + courseTitle);
        } catch (NonUniqueResultException nue) {
            throw new CourseNotFoundException("Multiple records found for the Course Title : " + courseTitle + " . Please check DB for consistency.");

        }
        return courseEntity;
    }

    @Override
    public void deleteCourse(int courseId) throws CourseNotFoundException {
        CourseEntity courseEntity;
        courseEntity = getCourseById(courseId);
        entityManager.remove(courseEntity);
        System.out.println("Course with id "+ courseId + " is removed successfully");

    }

    @Override
    public CourseEntity getCourseByCourseCode(String courseCode) throws CourseNotFoundException, DatabaseInconsistentStateException {

        Query qry = entityManager.createNamedQuery("findByCourseCode");
        qry.setParameter("courseCode", courseCode);
        CourseEntity courseEntity = null;
        try {
            courseEntity = (CourseEntity) qry.getSingleResult();
        } catch (NoResultException ne) {
            throw new CourseNotFoundException("Course with course code is not found : " + courseCode);
        } catch (NonUniqueResultException nue) {
            throw new DatabaseInconsistentStateException("Multiple records found with this course code : " + courseCode);
        }

        return courseEntity;

    }

    @Override
    public void deleteCourseByCourseCode(String courseCode) throws CourseNotFoundException, DatabaseInconsistentStateException {
        CourseEntity courseEntity = getCourseByCourseCode(courseCode);
        entityManager.remove(courseEntity);
        System.out.println("Course is removed successfully.");

    }

    @Override
    public CourseEntity updateCourseTitle(int courseId, String newCourseTitle,String courseCode, int creditHours) throws CourseNotFoundException, WrongParameterException {
        
        
        CourseEntity courseEntity = getCourseById(courseId);
        if (newCourseTitle == null || newCourseTitle.isEmpty()) {
            System.out.println("Course Title is not valid");
        } else {
            courseEntity.setCourseTitle(newCourseTitle);
        }
        if (courseCode == null || courseCode.isEmpty()) {
            System.out.println("Course Code is not valid");
        } else {
            courseEntity.setCourseCode(courseCode);
        }
        if (creditHours < 1 || creditHours > 4) {
            System.out.println("Credit hours are not valid. It should be in between 1 and 4.");
        } else {
            courseEntity.setCourseCredithrs(creditHours);
        }
        
        entityManager.persist(courseEntity);

        return courseEntity;
    }

    @Override
    public List<CourseEntity> getAllCourses() throws CourseNotFoundException {
        Query qry = entityManager.createNamedQuery("CourseEntity.findAll");
        List<CourseEntity> allCoursesList = qry.getResultList();
        if (allCoursesList == null || allCoursesList.isEmpty()) {
            throw new CourseNotFoundException("No course is found.");
        }
        return allCoursesList;
    }

}
