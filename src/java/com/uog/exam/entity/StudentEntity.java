/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentEntity.findAll", query = "SELECT s FROM StudentEntity s"),
    @NamedQuery(name = "StudentEntity.findByStudentID", query = "SELECT s FROM StudentEntity s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "StudentEntity.findByStudentRollNo", query = "SELECT s FROM StudentEntity s WHERE s.studentRollNo = :studentRollNo"),
    @NamedQuery(name = "StudentEntity.findByStudentName", query = "SELECT s FROM StudentEntity s WHERE s.studentName = :studentName"),
    @NamedQuery(name = "StudentEntity.findByStudentSemester", query = "SELECT s FROM StudentEntity s WHERE s.studentSemester = :studentSemester"),
    @NamedQuery(name = "StudentEntity.findByStudentSection", query = "SELECT s FROM StudentEntity s WHERE s.studentSection = :studentSection"),
    @NamedQuery(name = "StudentEntity.findByStudentEmail", query = "SELECT s FROM StudentEntity s WHERE s.studentEmail = :studentEmail"),
    @NamedQuery(name = "StudentEntity.findByStudentContactNo", query = "SELECT s FROM StudentEntity s WHERE s.studentContactNo = :studentContactNo")})
public class StudentEntity implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seatingPlanStudentID")
    private Collection<SeatingPlanEntity> seatingPlanEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentSeatingStudentID")
    private Collection<StudentSeatingEntity> studentSeatingEntityCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Student_ID")
    private Integer studentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Student_Roll_No")
    private String studentRollNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Student_Name")
    private String studentName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Student_Semester")
    private int studentSemester;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Student_Section")
    private String studentSection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Student_Email")
    private String studentEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Student_Contact_No")
    private String studentContactNo;
    @OneToMany(mappedBy = "courseRegStudentID")
    private Collection<CourseRegistrationEntity> courseRegistrationEntityCollection;

    public StudentEntity() {
    }

    public StudentEntity(Integer studentID) {
        this.studentID = studentID;
    }

    public StudentEntity(Integer studentID, String studentRollNo, String studentName, int studentSemester, String studentSection, String studentEmail, String studentContactNo) {
        this.studentID = studentID;
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.studentSemester = studentSemester;
        this.studentSection = studentSection;
        this.studentEmail = studentEmail;
        this.studentContactNo = studentContactNo;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(String studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(int studentSemester) {
        this.studentSemester = studentSemester;
    }

    public String getStudentSection() {
        return studentSection;
    }

    public void setStudentSection(String studentSection) {
        this.studentSection = studentSection;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentContactNo() {
        return studentContactNo;
    }

    public void setStudentContactNo(String studentContactNo) {
        this.studentContactNo = studentContactNo;
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
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentEntity)) {
            return false;
        }
        StudentEntity other = (StudentEntity) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.entity.StudentEntity[ studentID=" + studentID + " ]";
    }

    @XmlTransient
    public Collection<SeatingPlanEntity> getSeatingPlanEntityCollection() {
        return seatingPlanEntityCollection;
    }

    public void setSeatingPlanEntityCollection(Collection<SeatingPlanEntity> seatingPlanEntityCollection) {
        this.seatingPlanEntityCollection = seatingPlanEntityCollection;
    }

    @XmlTransient
    public Collection<StudentSeatingEntity> getStudentSeatingEntityCollection() {
        return studentSeatingEntityCollection;
    }

    public void setStudentSeatingEntityCollection(Collection<StudentSeatingEntity> studentSeatingEntityCollection) {
        this.studentSeatingEntityCollection = studentSeatingEntityCollection;
    }
    
}
