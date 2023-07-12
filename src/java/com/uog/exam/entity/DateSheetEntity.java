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
@Table(name = "date_sheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DateSheetEntity.findAll", query = "SELECT d FROM DateSheetEntity d"),
    @NamedQuery(name = "DateSheetEntity.findByDateSheetID", query = "SELECT d FROM DateSheetEntity d WHERE d.dateSheetID = :dateSheetID"),
    @NamedQuery(name = "DateSheetEntity.findByDSSemester", query = "SELECT d FROM DateSheetEntity d WHERE d.dSSemester = :dSSemester"),
    @NamedQuery(name = "DateSheetEntity.findByDSYear", query = "SELECT d FROM DateSheetEntity d WHERE d.dSYear = :dSYear"),
    @NamedQuery(name = "DateSheetEntity.findByDSCategory", query = "SELECT d FROM DateSheetEntity d WHERE d.dSCategory = :dSCategory"),
    @NamedQuery(name = "DateSheetEntity.findByDSStartDate", query = "SELECT d FROM DateSheetEntity d WHERE d.dSStartDate = :dSStartDate"),
    @NamedQuery(name = "DateSheetEntity.findByDSEndDate", query = "SELECT d FROM DateSheetEntity d WHERE d.dSEndDate = :dSEndDate")})
public class DateSheetEntity implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DS_Semester")
    private int dSSemester;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Date_Sheet_ID")
    private Integer dateSheetID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DS_Year")
    private int dSYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DS_Category")
    private short dSCategory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DS_Start_Date")
    @Temporal(TemporalType.DATE)
    private Date dSStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DS_End_Date")
    @Temporal(TemporalType.DATE)
    private Date dSEndDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dateSheetID")
    private Collection<ExamEntity> examEntityCollection;

    public DateSheetEntity() {
    }

    public DateSheetEntity(Integer dateSheetID) {
        this.dateSheetID = dateSheetID;
    }

    public DateSheetEntity(Integer dateSheetID, int dSSemester, int dSYear, short dSCategory, Date dSStartDate, Date dSEndDate) {
        this.dateSheetID = dateSheetID;
        this.dSSemester = dSSemester;
        this.dSYear = dSYear;
        this.dSCategory = dSCategory;
        this.dSStartDate = dSStartDate;
        this.dSEndDate = dSEndDate;
    }

    public Integer getDateSheetID() {
        return dateSheetID;
    }

    public void setDateSheetID(Integer dateSheetID) {
        this.dateSheetID = dateSheetID;
    }

    public int getDSSemester() {
        return dSSemester;
    }

    public void setDSSemester(int dSSemester) {
        this.dSSemester = dSSemester;
    }

    public int getDSYear() {
        return dSYear;
    }

    public void setDSYear(int dSYear) {
        this.dSYear = dSYear;
    }

    public short getDSCategory() {
        return dSCategory;
    }

    public void setDSCategory(short dSCategory) {
        this.dSCategory = dSCategory;
    }

    public Date getDSStartDate() {
        return dSStartDate;
    }

    public void setDSStartDate(Date dSStartDate) {
        this.dSStartDate = dSStartDate;
    }

    public Date getDSEndDate() {
        return dSEndDate;
    }

    public void setDSEndDate(Date dSEndDate) {
        this.dSEndDate = dSEndDate;
    }

    @XmlTransient
    public Collection<ExamEntity> getExamEntityCollection() {
        return examEntityCollection;
    }

    public void setExamEntityCollection(Collection<ExamEntity> examEntityCollection) {
        this.examEntityCollection = examEntityCollection;
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
        return "com.uog.exam.entity.DateSheetEntity[ dateSheetID=" + dateSheetID + " ]";
    }
    
}
