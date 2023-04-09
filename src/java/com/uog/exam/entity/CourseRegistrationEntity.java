/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "course_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseRegistrationEntity.findAll", query = "SELECT c FROM CourseRegistrationEntity c"),
    @NamedQuery(name = "CourseRegistrationEntity.findByCourseRegStudentID", query = "SELECT c FROM CourseRegistrationEntity c WHERE c.courseRegStudentID = :courseRegStudentID"),
    @NamedQuery(name = "CourseRegistrationEntity.findByCourseRegYear", query = "SELECT c FROM CourseRegistrationEntity c WHERE c.courseRegYear = :courseRegYear")})
public class CourseRegistrationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CourseReg_Student_ID")
    private Integer courseRegStudentID;
    @Size(max = 45)
    @Column(name = "CourseReg_Year")
    private String courseRegYear;
    @JoinColumn(name = "CourseReg_Course_ID", referencedColumnName = "Course_ID")
    @ManyToOne
    private CourseEntity courseRegCourseID;
    @JoinColumn(name = "CourseReg_Student_ID", referencedColumnName = "Student_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private StudentEntity studentEntity;

    public CourseRegistrationEntity() {
    }

    public CourseRegistrationEntity(Integer courseRegStudentID) {
        this.courseRegStudentID = courseRegStudentID;
    }

    public Integer getCourseRegStudentID() {
        return courseRegStudentID;
    }

    public void setCourseRegStudentID(Integer courseRegStudentID) {
        this.courseRegStudentID = courseRegStudentID;
    }

    public String getCourseRegYear() {
        return courseRegYear;
    }

    public void setCourseRegYear(String courseRegYear) {
        this.courseRegYear = courseRegYear;
    }

    public CourseEntity getCourseRegCourseID() {
        return courseRegCourseID;
    }

    public void setCourseRegCourseID(CourseEntity courseRegCourseID) {
        this.courseRegCourseID = courseRegCourseID;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseRegStudentID != null ? courseRegStudentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseRegistrationEntity)) {
            return false;
        }
        CourseRegistrationEntity other = (CourseRegistrationEntity) object;
        if ((this.courseRegStudentID == null && other.courseRegStudentID != null) || (this.courseRegStudentID != null && !this.courseRegStudentID.equals(other.courseRegStudentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.course.CourseRegistrationEntity[ courseRegStudentID=" + courseRegStudentID + " ]";
    }
    
}
