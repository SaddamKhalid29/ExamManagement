/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "seating_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeatingPlanEntity.findAll", query = "SELECT s FROM SeatingPlanEntity s"),
    @NamedQuery(name = "SeatingPlanEntity.findByTimeSlot", query = "SELECT s FROM SeatingPlanEntity s WHERE s.timeSlot = :timeSlot"),
    @NamedQuery(name = "SeatingPlanEntity.findByPlanID", query = "SELECT s FROM SeatingPlanEntity s WHERE s.planID = :planID"),
    @NamedQuery(name = "SeatingPlanEntity.findBySeatingPlanDate", query = "SELECT s FROM SeatingPlanEntity s WHERE s.seatingPlanDate = :seatingPlanDate"),
    @NamedQuery(name = "SeatingPlanEntity.findBySeatingPlanID", query = "SELECT s FROM SeatingPlanEntity s WHERE s.seatingPlanID = :seatingPlanID")})
public class SeatingPlanEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Time_Slot")
    private String timeSlot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Plan_ID")
    private int planID;
    @Column(name = "SeatingPlan_Date")
    @Temporal(TemporalType.DATE)
    private Date seatingPlanDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SeatingPlan_ID")
    private Integer seatingPlanID;
    @JoinColumn(name = "SeatingPlan_Course_ID", referencedColumnName = "Course_ID")
    @ManyToOne(optional = false)
    private CourseEntity seatingPlanCourseID;
    @JoinColumn(name = "SeatingPlan_Room_ID", referencedColumnName = "Room_ID")
    @ManyToOne(optional = false)
    private RoomEntity seatingPlanRoomID;
    @JoinColumn(name = "SeatingPlan_Student_ID", referencedColumnName = "Student_ID")
    @ManyToOne(optional = false)
    private StudentEntity seatingPlanStudentID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stdPlanID")
    private Collection<StudentSeatingEntity> studentSeatingEntityCollection;

    public SeatingPlanEntity() {
    }

    public SeatingPlanEntity(Integer seatingPlanID) {
        this.seatingPlanID = seatingPlanID;
    }

    public SeatingPlanEntity(Integer seatingPlanID, String timeSlot, int planID) {
        this.seatingPlanID = seatingPlanID;
        this.timeSlot = timeSlot;
        this.planID = planID;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public Date getSeatingPlanDate() {
        return seatingPlanDate;
    }

    public void setSeatingPlanDate(Date seatingPlanDate) {
        this.seatingPlanDate = seatingPlanDate;
    }

    public Integer getSeatingPlanID() {
        return seatingPlanID;
    }

    public void setSeatingPlanID(Integer seatingPlanID) {
        this.seatingPlanID = seatingPlanID;
    }

    public CourseEntity getSeatingPlanCourseID() {
        return seatingPlanCourseID;
    }

    public void setSeatingPlanCourseID(CourseEntity seatingPlanCourseID) {
        this.seatingPlanCourseID = seatingPlanCourseID;
    }

    public RoomEntity getSeatingPlanRoomID() {
        return seatingPlanRoomID;
    }

    public void setSeatingPlanRoomID(RoomEntity seatingPlanRoomID) {
        this.seatingPlanRoomID = seatingPlanRoomID;
    }

    public StudentEntity getSeatingPlanStudentID() {
        return seatingPlanStudentID;
    }

    public void setSeatingPlanStudentID(StudentEntity seatingPlanStudentID) {
        this.seatingPlanStudentID = seatingPlanStudentID;
    }

    @XmlTransient
    public Collection<StudentSeatingEntity> getStudentSeatingEntityCollection() {
        return studentSeatingEntityCollection;
    }

    public void setStudentSeatingEntityCollection(Collection<StudentSeatingEntity> studentSeatingEntityCollection) {
        this.studentSeatingEntityCollection = studentSeatingEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seatingPlanID != null ? seatingPlanID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeatingPlanEntity)) {
            return false;
        }
        SeatingPlanEntity other = (SeatingPlanEntity) object;
        if ((this.seatingPlanID == null && other.seatingPlanID != null) || (this.seatingPlanID != null && !this.seatingPlanID.equals(other.seatingPlanID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.course.SeatingPlanEntity[ seatingPlanID=" + seatingPlanID + " ]";
    }
    
}
