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
@Table(name = "faculty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacultyEntity.findAll", query = "SELECT f FROM FacultyEntity f"),
    @NamedQuery(name = "FacultyEntity.findByFacultyID", query = "SELECT f FROM FacultyEntity f WHERE f.facultyID = :facultyID"),
    @NamedQuery(name = "FacultyEntity.findByFacultyName", query = "SELECT f FROM FacultyEntity f WHERE f.facultyName = :facultyName"),
    @NamedQuery(name = "FacultyEntity.findByFacultyEmail", query = "SELECT f FROM FacultyEntity f WHERE f.facultyEmail = :facultyEmail"),
    @NamedQuery(name = "FacultyEntity.findByFacultyContactNo", query = "SELECT f FROM FacultyEntity f WHERE f.facultyContactNo = :facultyContactNo"),
    @NamedQuery(name = "FacultyEntity.findByFacultyDesignation", query = "SELECT f FROM FacultyEntity f WHERE f.facultyDesignation = :facultyDesignation"),
    @NamedQuery(name = "FacultyEntity.findByFacultyVisitingStatus", query = "SELECT f FROM FacultyEntity f WHERE f.facultyVisitingStatus = :facultyVisitingStatus")})
public class FacultyEntity implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Faculty_Visiting_Status")
    private boolean facultyVisitingStatus;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Faculty_ID")
    private Integer facultyID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Faculty_Name")
    private String facultyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Faculty_Email")
    private String facultyEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Faculty_Contact_No")
    private String facultyContactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Faculty_Designation")
    private String facultyDesignation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dutyRoasterFacultyID")
    private Collection<DutyRoasterEntity> dutyRoasterEntityCollection;

    public FacultyEntity() {
    }

    public FacultyEntity(Integer facultyID) {
        this.facultyID = facultyID;
    }

    public FacultyEntity(Integer facultyID, String facultyName, String facultyEmail, String facultyContactNo, String facultyDesignation, boolean facultyVisitingStatus) {
        this.facultyID = facultyID;
        this.facultyName = facultyName;
        this.facultyEmail = facultyEmail;
        this.facultyContactNo = facultyContactNo;
        this.facultyDesignation = facultyDesignation;
        this.facultyVisitingStatus = facultyVisitingStatus;
    }

    public Integer getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Integer facultyID) {
        this.facultyID = facultyID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyEmail() {
        return facultyEmail;
    }

    public void setFacultyEmail(String facultyEmail) {
        this.facultyEmail = facultyEmail;
    }

    public String getFacultyContactNo() {
        return facultyContactNo;
    }

    public void setFacultyContactNo(String facultyContactNo) {
        this.facultyContactNo = facultyContactNo;
    }

    public String getFacultyDesignation() {
        return facultyDesignation;
    }

    public void setFacultyDesignation(String facultyDesignation) {
        this.facultyDesignation = facultyDesignation;
    }

    public boolean getFacultyVisitingStatus() {
        return facultyVisitingStatus;
    }

    public void setFacultyVisitingStatus(boolean facultyVisitingStatus) {
        this.facultyVisitingStatus = facultyVisitingStatus;
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
        hash += (facultyID != null ? facultyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacultyEntity)) {
            return false;
        }
        FacultyEntity other = (FacultyEntity) object;
        if ((this.facultyID == null && other.facultyID != null) || (this.facultyID != null && !this.facultyID.equals(other.facultyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.course.FacultyEntity[ facultyID=" + facultyID + " ]";
    }    

}
