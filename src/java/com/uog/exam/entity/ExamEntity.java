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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "exam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamEntity.findAll", query = "SELECT e FROM ExamEntity e"),
    @NamedQuery(name = "ExamEntity.findByExamId", query = "SELECT e FROM ExamEntity e WHERE e.examId = :examId"),
    @NamedQuery(name = "ExamEntity.findByExamDate", query = "SELECT e FROM ExamEntity e WHERE e.examDate = :examDate"),
    @NamedQuery(name = "ExamEntity.findByExamTime", query = "SELECT e FROM ExamEntity e WHERE e.examTime = :examTime")})
public class ExamEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Exam_Id")
    private Integer examId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Exam_Date")
    @Temporal(TemporalType.DATE)
    private Date examDate;
    @Column(name = "Exam_Time")
    @Temporal(TemporalType.TIME)
    private Date examTime;
    @JoinColumn(name = "Course_ID", referencedColumnName = "Course_ID")
    @ManyToOne(optional = false)
    private CourseEntity courseID;
    @JoinColumn(name = "Date_Sheet_ID", referencedColumnName = "Date_Sheet_ID")
    @ManyToOne(optional = false)
    private DateSheetEntity dateSheetID;
    @JoinColumn(name = "Room_ID", referencedColumnName = "Room_ID")
    @ManyToOne(optional = false)
    private RoomEntity roomID;

    public ExamEntity() {
    }

    public ExamEntity(Integer examId) {
        this.examId = examId;
    }

    public ExamEntity(Integer examId, Date examDate) {
        this.examId = examId;
        this.examDate = examDate;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public CourseEntity getCourseID() {
        return courseID;
    }

    public void setCourseID(CourseEntity courseID) {
        this.courseID = courseID;
    }

    public DateSheetEntity getDateSheetID() {
        return dateSheetID;
    }

    public void setDateSheetID(DateSheetEntity dateSheetID) {
        this.dateSheetID = dateSheetID;
    }

    public RoomEntity getRoomID() {
        return roomID;
    }

    public void setRoomID(RoomEntity roomID) {
        this.roomID = roomID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examId != null ? examId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamEntity)) {
            return false;
        }
        ExamEntity other = (ExamEntity) object;
        if ((this.examId == null && other.examId != null) || (this.examId != null && !this.examId.equals(other.examId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.entity.ExamEntity[ examId=" + examId + " ]";
    }
    
}
