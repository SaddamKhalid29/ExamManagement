/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.department;

import com.uog.exam.entity.DepartmentEntity;
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
public class DepartmentManager implements DepartmentManagerRemote {

    @PersistenceContext(unitName = "ExamPU")

    EntityManager entityManager;

    @Override
    public DepartmentEntity addDepartment(String departmentName) {

        DepartmentEntity departmentEntity = new DepartmentEntity();
        if (departmentName == null || departmentName.isEmpty()) {
            try {
                throw new WrongParameterException("Department name can't be empty.");
            } catch (WrongParameterException ex) {
                Logger.getLogger(DepartmentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        departmentEntity.setDepartmentName(departmentName);
        entityManager.persist(departmentEntity);
        return departmentEntity;
    }

    @Override
    public DepartmentEntity getDepartmentById(int deptID) throws DepartmentNotFoundException {

        DepartmentEntity departmentEntity = entityManager.find(DepartmentEntity.class, deptID);
        if (departmentEntity == null) {
            throw new DepartmentNotFoundException("The department with this id does not exist.");
        } else {
            return departmentEntity;
        }
    }

    @Override
    public DepartmentEntity getDepartmentByName(String deptName) throws DepartmentNotFoundException {

        Query qry = entityManager.createNamedQuery("DepartmentEntity.findByDepartmentName");
        qry.setParameter("departmentName", deptName);
        DepartmentEntity departmentEntity = null;
        try {
            departmentEntity = (DepartmentEntity) qry.getSingleResult();
        } catch (NoResultException ne) {
            throw new DepartmentNotFoundException("Deepartment with this name is not found : " + deptName);
        } catch (NonUniqueResultException nue) {
            throw new DepartmentNotFoundException("Multiple records found for the department name : " + deptName + " . Please check DB for consistency.");
        }
        return departmentEntity;
    }

    @Override
    public DepartmentEntity updateDepartmentName(int deptId,String departmentName) throws WrongParameterException {

        DepartmentEntity departmentEntity = null;
        try {
            departmentEntity = getDepartmentById(deptId);
        } catch (DepartmentNotFoundException ex) {
            Logger.getLogger(DepartmentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        if (departmentName == null || departmentName.isEmpty()) {
            throw new WrongParameterException("The department name is not valid");
        } else {
            departmentEntity.setDepartmentName(departmentName);
            entityManager.persist(departmentEntity);
        }

        return departmentEntity;
    }

    @Override
    public void deleteDepartmentById(int departmentId) throws DepartmentNotFoundException {
        DepartmentEntity departmentEntity;
        departmentEntity = getDepartmentById(departmentId);
        entityManager.remove(departmentEntity);
        System.out.println("Department with the id : " + departmentId + " is removed");
    }

    @Override
    public List<DepartmentEntity> getAllDepartments() throws DepartmentNotFoundException {
        Query qry = entityManager.createNamedQuery("DepartmentEntity.findAll");
        List<DepartmentEntity> allDepartments = qry.getResultList();
        if (allDepartments == null || allDepartments.isEmpty()) {
            throw new DepartmentNotFoundException("No department found in database");
        }
        return allDepartments;
    }

}
