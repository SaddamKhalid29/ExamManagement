/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "CourseRegistrationEntity.findByCourseRegistrationID", query = "SELECT c FROM CourseRegistrationEntity c WHERE c.courseRegistrationID = :courseRegistrationID"),
    @NamedQuery(name = "CourseRegistrationEntity.findByCourseRegYear", query = "SELECT c FROM CourseRegistrationEntity c WHERE c.courseRegYear = :courseRegYear")})
public class CourseRegistrationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CourseRegistration_ID")
    private Integer courseRegistrationID;
    @Size(max = 255)
    @Column(name = "CourseReg_Year")
    private String courseRegYear;
    @JoinColumn(name = "CourseReg_Course_ID", referencedColumnName = "Course_ID")
    @ManyToOne
    private CourseEntity courseRegCourseID;
    @JoinColumn(name = "CourseReg_Student_ID", referencedColumnName = "Student_ID")
    @ManyToOne
    private StudentEntity courseRegStudentID;

    public CourseRegistrationEntity() {
    }

    public CourseRegistrationEntity(Integer courseRegistrationID) {
        this.courseRegistrationID = courseRegistrationID;
    }

    public Integer getCourseRegistrationID() {
        return courseRegistrationID;
    }

    public void setCourseRegistrationID(Integer courseRegistrationID) {
        this.courseRegistrationID = courseRegistrationID;
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

    public StudentEntity getCourseRegStudentID() {
        return courseRegStudentID;
    }

    public void setCourseRegStudentID(StudentEntity courseRegStudentID) {
        this.courseRegStudentID = courseRegStudentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseRegistrationID != null ? courseRegistrationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseRegistrationEntity)) {
            return false;
        }
        CourseRegistrationEntity other = (CourseRegistrationEntity) object;
        if ((this.courseRegistrationID == null && other.courseRegistrationID != null) || (this.courseRegistrationID != null && !this.courseRegistrationID.equals(other.courseRegistrationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.entity.CourseRegistrationEntity[ courseRegistrationID=" + courseRegistrationID + " ]";
    }
    
}
