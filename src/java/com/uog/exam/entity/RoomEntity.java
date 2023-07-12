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
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomEntity.findAll", query = "SELECT r FROM RoomEntity r"),
    @NamedQuery(name = "RoomEntity.findByRoomID", query = "SELECT r FROM RoomEntity r WHERE r.roomID = :roomID"),
    @NamedQuery(name = "RoomEntity.findByRoomNo", query = "SELECT r FROM RoomEntity r WHERE r.roomNo = :roomNo"),
    @NamedQuery(name = "RoomEntity.findByRoomCapacity", query = "SELECT r FROM RoomEntity r WHERE r.roomCapacity = :roomCapacity")})
public class RoomEntity implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomID")
    private Collection<ExamEntity> examEntityCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
    @Column(name = "Room_ID")
    private Integer roomID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Room_No")
    private String roomNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Room_Capacity")
    private int roomCapacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seatingPlanRoomID")
    private Collection<SeatingPlanEntity> seatingPlanEntityCollection;

    public RoomEntity() {
    }

    public RoomEntity(Integer roomID) {
        this.roomID = roomID;
    }

    public RoomEntity(Integer roomID, String roomNo, int roomCapacity) {
        this.roomID = roomID;
        this.roomNo = roomNo;
        this.roomCapacity = roomCapacity;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    @XmlTransient
    public Collection<SeatingPlanEntity> getSeatingPlanEntityCollection() {
        return seatingPlanEntityCollection;
    }

    public void setSeatingPlanEntityCollection(Collection<SeatingPlanEntity> seatingPlanEntityCollection) {
        this.seatingPlanEntityCollection = seatingPlanEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomID != null ? roomID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomEntity)) {
            return false;
        }
        RoomEntity other = (RoomEntity) object;
        if ((this.roomID == null && other.roomID != null) || (this.roomID != null && !this.roomID.equals(other.roomID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uog.exam.course.RoomEntity[ roomID=" + roomID + " ]";
    }

    @XmlTransient
    public Collection<ExamEntity> getExamEntityCollection() {
        return examEntityCollection;
    }

    public void setExamEntityCollection(Collection<ExamEntity> examEntityCollection) {
        this.examEntityCollection = examEntityCollection;
    }
    
}
