/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uog.exam.department;

import com.uog.exam.entity.DepartmentEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author User
 */
@Remote
public interface DepartmentManagerRemote {
    
    public DepartmentEntity addDepartment(String departmentName) throws WrongParameterException;
    
    public DepartmentEntity getDepartmentById(int id) throws DepartmentNotFoundException;
    
    public DepartmentEntity getDepartmentByName(String departmentName) throws DepartmentNotFoundException;
    
    public DepartmentEntity updateDepartmentName(int deptId, String departmentName) throws WrongParameterException;
    
    public void deleteDepartmentById(int departmentId) throws DepartmentNotFoundException;
    
    public List<DepartmentEntity> getAllDepartments() throws DepartmentNotFoundException;
}
