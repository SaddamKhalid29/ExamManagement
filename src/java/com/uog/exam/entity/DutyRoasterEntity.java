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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "duty_roaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DutyRoasterEntity.findAll", query = "SELECT d FROM DutyRoasterEntity d"),
    @NamedQuery(name = "DutyRoasterEntity.findByDutyRoasterID", query = "SELECT d FROM DutyRoasterEntity d WHERE d.dutyRoasterID = :dutyRoasterID")})
public class DutyRoasterEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Duty_Roaster_ID")
    private Integer dutyRoasterID;
    @JoinColumn(name = "DutyRoaster_Faculty_ID", referencedColumnName = "Faculty_ID")
    @ManyToOne(optional = false)
    private FacultyEntity dutyRoasterFacultyID;
    @JoinColumn(name = "DutyRoaster_Plan_ID", referencedColumnName = "Std_Plan_ID")
    @ManyToOne(optional = false)
    private StudentSeatingEntity dutyRoasterPlanID;

    public DutyRoasterEntity() {
    }

    public DutyRoasterEntity(Integer dutyRoasterID) {
        this.dutyRoasterID = dutyRoasterID;
    }

    public Integer getDutyRoasterID() {
        return dutyRoasterID;
    }

    public void setDutyRoasterID(Integer dutyRoasterID) {
        this.dutyRoasterID = dutyRoasterID;
    }

    public FacultyEntity getDutyRoasterFacultyID() {
        return dutyRoasterFacultyID;
    }

    public void setDutyRoasterFacultyID(FacultyEntity dutyRoasterFacultyID) {
        this.dutyRoasterFacultyID = dutyRoasterFacultyID;
    }

    public StudentSeatingEntity getDutyRoasterPlanID() {
        return dutyRoasterPlanID;
    }

    public void setDutyRoasterPlanID(StudentSeatingEntity dutyRoasterPlanID) {
        this.dutyRoasterPlanID = dutyRoasterPlanID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dutyRoasterID != null ? dutyRoasterID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DutyRoasterEntity)) {
            return false;
        }
        DutyRoasterEntity other = (DutyRoasterEntity) object;
        if ((this.dutyRoasterID == null && other.dutyRoasterID != null) || (this.dutyRoasterID != null && !this.dutyRoasterID.equals(other.dutyRoasterID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.course.DutyRoasterEntity[ dutyRoasterID=" + dutyRoasterID + " ]";
    }
    
}
