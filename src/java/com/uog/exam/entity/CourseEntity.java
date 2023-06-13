/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseEntity.findAll", query = "SELECT c FROM CourseEntity c"),
    @NamedQuery(name = "CourseEntity.findByCourseID", query = "SELECT c FROM CourseEntity c WHERE c.courseID = :courseID"),
    @NamedQuery(name = "CourseEntity.findByCourseTitle", query = "SELECT c FROM CourseEntity c WHERE c.courseTitle = :courseTitle"),
    @NamedQuery(name = "CourseEntity.findByCourseCode", query = "SELECT c FROM CourseEntity c WHERE c.courseCode = :courseCode"),
    @NamedQuery(name = "CourseEntity.findByCourseCredithrs", query = "SELECT c FROM CourseEntity c WHERE c.courseCredithrs = :courseCredithrs")})
public class CourseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Course_ID")
    private Integer courseID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Course_Title")
    private String courseTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Course_Code")
    private String courseCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Course_Credit_hrs")
    private int courseCredithrs;
    @OneToMany(mappedBy = "courseRegCourseID")
    private Collection<CourseRegistrationEntity> courseRegistrationEntityCollection;

    public CourseEntity() {
    }

    public CourseEntity(Integer courseID) {
        this.courseID = courseID;
    }

    public CourseEntity(Integer courseID, String courseTitle, String courseCode, int courseCredithrs) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.courseCredithrs = courseCredithrs;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseCredithrs() {
        return courseCredithrs;
    }

    public void setCourseCredithrs(int courseCredithrs) {
        this.courseCredithrs = courseCredithrs;
    }

    @XmlTransient
    public Collection<CourseRegistrationEntity> getCourseRegistrationEntityCollection() {
        return courseRegistrationEntityCollection;
    }

    public void setCourseRegistrationEntityCollection(Collection<CourseRegistrationEntity> courseRegistrationEntityCollection) {
        this.courseRegistrationEntityCollection = courseRegistrationEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseID != null ? courseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseEntity)) {
            return false;
        }
        CourseEntity other = (CourseEntity) object;
        if ((this.courseID == null && other.courseID != null) || (this.courseID != null && !this.courseID.equals(other.courseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.entity.CourseEntity[ courseID=" + courseID + " ]";
    }
    
}
