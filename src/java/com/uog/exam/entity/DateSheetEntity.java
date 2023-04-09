/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "date_sheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DateSheetEntity.findAll", query = "SELECT d FROM DateSheetEntity d"),
    @NamedQuery(name = "DateSheetEntity.findByDateSheetID", query = "SELECT d FROM DateSheetEntity d WHERE d.dateSheetID = :dateSheetID"),
    @NamedQuery(name = "DateSheetEntity.findByDateSheetExamDate", query = "SELECT d FROM DateSheetEntity d WHERE d.dateSheetExamDate = :dateSheetExamDate"),
    @NamedQuery(name = "DateSheetEntity.findByDateSheetExamTime", query = "SELECT d FROM DateSheetEntity d WHERE d.dateSheetExamTime = :dateSheetExamTime"),
    @NamedQuery(name = "DateSheetEntity.findByDateSheetSemester", query = "SELECT d FROM DateSheetEntity d WHERE d.dateSheetSemester = :dateSheetSemester")})
public class DateSheetEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Date_Sheet_ID")
    private Integer dateSheetID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateSheet_Exam_Date")
    @Temporal(TemporalType.DATE)
    private Date dateSheetExamDate;
    @Size(max = 45)
    @Column(name = "DateSheet_Exam_Time")
    private String dateSheetExamTime;
    @Column(name = "DateSheet_Semester")
    private Integer dateSheetSemester;
    @JoinColumn(name = "DateSheet_Course_ID", referencedColumnName = "Course_ID")
    @ManyToOne
    private CourseEntity dateSheetCourseID;

    public DateSheetEntity() {
    }

    public DateSheetEntity(Integer dateSheetID) {
        this.dateSheetID = dateSheetID;
    }

    public DateSheetEntity(Integer dateSheetID, Date dateSheetExamDate) {
        this.dateSheetID = dateSheetID;
        this.dateSheetExamDate = dateSheetExamDate;
    }

    public Integer getDateSheetID() {
        return dateSheetID;
    }

    public void setDateSheetID(Integer dateSheetID) {
        this.dateSheetID = dateSheetID;
    }

    public Date getDateSheetExamDate() {
        return dateSheetExamDate;
    }

    public void setDateSheetExamDate(Date dateSheetExamDate) {
        this.dateSheetExamDate = dateSheetExamDate;
    }

    public String getDateSheetExamTime() {
        return dateSheetExamTime;
    }

    public void setDateSheetExamTime(String dateSheetExamTime) {
        this.dateSheetExamTime = dateSheetExamTime;
    }

    public Integer getDateSheetSemester() {
        return dateSheetSemester;
    }

    public void setDateSheetSemester(Integer dateSheetSemester) {
        this.dateSheetSemester = dateSheetSemester;
    }

    public CourseEntity getDateSheetCourseID() {
        return dateSheetCourseID;
    }

    public void setDateSheetCourseID(CourseEntity dateSheetCourseID) {
        this.dateSheetCourseID = dateSheetCourseID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dateSheetID != null ? dateSheetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DateSheetEntity)) {
            return false;
        }
        DateSheetEntity other = (DateSheetEntity) object;
        if ((this.dateSheetID == null && other.dateSheetID != null) || (this.dateSheetID != null && !this.dateSheetID.equals(other.dateSheetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.course.DateSheetEntity[ dateSheetID=" + dateSheetID + " ]";
    }
    
}
