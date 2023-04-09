/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uog.exam.student;

import com.uog.exam.entity.StudentEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author martin
 */
@Stateless
public class StudentManager implements StudentManagerRemote{
    
    @PersistenceContext(unitName = "ExamPU")
    //Persistance Interface to implement methods
    EntityManager entityManager;
  

    //Method to add new Student
    
    @Override
    public StudentEntity addNewStudent(String studentRollNo, String studentName, int studentSemester, 
            String studentSection, String studentEmail, String studentContact) throws WrongParameterException {
        //Creating the object of StudentEntity class
        StudentEntity studentEntity = new StudentEntity();
        //Checking if any of the field is empty or null
        if (studentRollNo == null || studentRollNo.isEmpty()) {
            throw new WrongParameterException("This rollno of student can be add");
        }
        if (studentName == null || studentName.isEmpty()) {
            throw new WrongParameterException("The Student_Name of student is invalid.");
        }
        if (studentSemester <1 || studentSemester>8) {
            throw new WrongParameterException("Semester value can be between 1 and 8");
        }
        if (studentSection == null || studentSection.isEmpty()) {
            throw new WrongParameterException("The Student_Section of student is invalid.");
        }
        if (studentEmail == null || studentEmail.isEmpty()) {
            throw new WrongParameterException("The Student_Email of student is invalid.");
        }
        if (studentContact == null || studentContact.isEmpty()) {
            throw new WrongParameterException("The Student_Contact of student is invalid.");
        }

        //if no entry is empty then set the values in entity class
        studentEntity.setStudentRollNo(studentRollNo);
        studentEntity.setStudentName(studentName);
        studentEntity.setStudentSemester(studentSemester);
        studentEntity.setStudentSection(studentSection);
        studentEntity.setStudentEmail(studentEmail);
        studentEntity.setStudentContactNo(studentContact);

        //Persist method is intended to add new entity instance to the persistence context.
       entityManager.persist(studentEntity);
        
        return studentEntity;
    }

    //Method to find the student by ID
    @Override
    public StudentEntity getStudentId(int stdId) throws StudentNotFoundException {
        //Find out the student id from StudentEntity class and store it in studentEntity variable
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, stdId);
        //checking if studentEntity is null or not...
        if (studentEntity == null) {
            throw new StudentNotFoundException("The student with the required id is not found." + stdId);
        } else {
            return studentEntity;
        }
    }

    //Method to get student by  Student_Name
    @Override
    public StudentEntity getStudentByName(String stdName) throws StudentNotFoundException, DatabaseInconsistentStateException {
        Query qry = entityManager.createNamedQuery("StudentEntity.findByStudentName");
        qry.setParameter("studentName", stdName);

        StudentEntity studentEntity = null;
        try {
            studentEntity = (StudentEntity) qry.getSingleResult();

        } catch (NoResultException ne) {
            throw new StudentNotFoundException("Student with this Student_Name is not found : " + stdName);
        } catch (NonUniqueResultException nue) {
            throw new StudentNotFoundException("Multiple records found for the Student_Name : " + stdName + " . Please checl DB for consistency.");

        }
        return studentEntity;
    }

    //Method to update student Student_Name
    @Override
    public StudentEntity updateStudentName(int stdID, String newStdName) throws StudentNotFoundException, WrongParameterException {

        if (newStdName == null || newStdName.isEmpty()) {
            throw new WrongParameterException("Student Student_Name can't be empty or null.");
        }
        StudentEntity studentEntity = getStudentId(stdID);
        studentEntity.setStudentName(newStdName);
        entityManager.persist(studentEntity);

        return studentEntity;
    }

    @Override
    public StudentEntity getStudentByRollNo(String rollNo) throws StudentNotFoundException, DatabaseInconsistentStateException {
        
        Query qry = entityManager.createNamedQuery("StudentEntity.findByStudentRollNo");
        qry.setParameter("studentRollNo",rollNo);
       
        StudentEntity studentEntity = null;
        try {
            studentEntity = (StudentEntity) qry.getSingleResult();

        } catch (NoResultException ne) {
            throw new StudentNotFoundException("Student with this Student_Roll_No is not found : " + rollNo);
        } catch (NonUniqueResultException nue) {
            throw new StudentNotFoundException("Multiple records found for the Student with Roll_No : " + rollNo + " . Please checl DB for consistency.");

        }
        
       return studentEntity;
    }
    
    @Override
    public void deleteStudentById(int stdId) throws StudentNotFoundException {
        StudentEntity studentEntity;
        studentEntity = getStudentId(stdId);
        entityManager.remove(studentEntity);
        System.out.println("Student with the id : "+stdId+ " is removed");
    }
    
    @Override
    public String textMessage(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StudentEntity> getAllStudents()  throws StudentNotFoundException{
        Query qry=entityManager.createNamedQuery("StudentEntity.findAll");
        List<StudentEntity> allStudents=qry.getResultList();
        if(allStudents==null|| allStudents.isEmpty()){
            throw new StudentNotFoundException("No student found in database");
        }
        return qry.getResultList();
    }
 
}
