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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "student_seating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentSeatingEntity.findAll", query = "SELECT s FROM StudentSeatingEntity s"),
    @NamedQuery(name = "StudentSeatingEntity.findByStudentSeatingID", query = "SELECT s FROM StudentSeatingEntity s WHERE s.studentSeatingID = :studentSeatingID")})
public class StudentSeatingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "studentSeating_ID")
    private Integer studentSeatingID;
    @JoinColumn(name = "Std_Plan_ID", referencedColumnName = "SeatingPlan_ID")
    @ManyToOne(optional = false)
    private SeatingPlanEntity stdPlanID;
    @JoinColumn(name = "StudentSeating_Student_ID", referencedColumnName = "Student_ID")
    @ManyToOne(optional = false)
    private StudentEntity studentSeatingStudentID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dutyRoasterPlanID")
    private Collection<DutyRoasterEntity> dutyRoasterEntityCollection;

    public StudentSeatingEntity() {
    }

    public StudentSeatingEntity(Integer studentSeatingID) {
        this.studentSeatingID = studentSeatingID;
    }

    public Integer getStudentSeatingID() {
        return studentSeatingID;
    }

    public void setStudentSeatingID(Integer studentSeatingID) {
        this.studentSeatingID = studentSeatingID;
    }

    public SeatingPlanEntity getStdPlanID() {
        return stdPlanID;
    }

    public void setStdPlanID(SeatingPlanEntity stdPlanID) {
        this.stdPlanID = stdPlanID;
    }

    public StudentEntity getStudentSeatingStudentID() {
        return studentSeatingStudentID;
    }

    public void setStudentSeatingStudentID(StudentEntity studentSeatingStudentID) {
        this.studentSeatingStudentID = studentSeatingStudentID;
    }

    @XmlTransient
    public Collection<DutyRoasterEntity> getDutyRoasterEntityCollection() {
        return dutyRoasterEntityCollection;
    }

    public void setDutyRoasterEntityCollection(Collection<DutyRoasterEntity> dutyRoasterEntityCollection) {
        this.dutyRoasterEntityCollection = dutyRoasterEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentSeatingID != null ? studentSeatingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentSeatingEntity)) {
            return false;
        }
        StudentSeatingEntity other = (StudentSeatingEntity) object;
        if ((this.studentSeatingID == null && other.studentSeatingID != null) || (this.studentSeatingID != null && !this.studentSeatingID.equals(other.studentSeatingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.course.StudentSeatingEntity[ studentSeatingID=" + studentSeatingID + " ]";
    }
    
}
