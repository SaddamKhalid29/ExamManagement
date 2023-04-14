/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.room;

import com.uog.exam.entity.RoomEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class RoomManager implements RoomManagerRemote {

    @PersistenceContext(unitName = "ExamPU")
    EntityManager entityManager;

    @Override
    public RoomEntity addRoom(String roomNo, int roomCapacity) {
        RoomEntity roomEntity = new RoomEntity();
        if (roomNo == null || roomNo.isEmpty()) {
            System.out.println("Room no is not valid.");
        } else {
            roomEntity.setRoomNo(roomNo);
        }
        if (roomCapacity <= 0) {
            System.out.println("Room capacity  must be greater than zero.");
        } else {
            roomEntity.setRoomCapacity(roomCapacity);
        }

        entityManager.persist(roomEntity);

        return roomEntity;

    }

    @Override
    public RoomEntity getRoomId(int roomId) throws RoomNotFoundException {
        RoomEntity roomEntity = entityManager.find(RoomEntity.class, roomId);
        //checking if roomEntity is null or not...
        if (roomEntity == null) {
            throw new RoomNotFoundException("The room with the required id is not found." + roomId);
        } else {
            return roomEntity;
        }
    }

    @Override
    public RoomEntity getRoomByNumber(String roomNumber) throws RoomNotFoundException {
        Query qry = entityManager.createNamedQuery("RoomEntity.findByRoomNo");
        qry.setParameter("roomNo", roomNumber);

        RoomEntity roomEntity = null;
        try {
            roomEntity = (RoomEntity) qry.getSingleResult();

        } catch (NoResultException ne) {
            throw new RoomNotFoundException("Room with this Room_Name is not found : " + roomNumber);
        }
        return roomEntity;
    }

    @Override
    public RoomEntity getRoomByCapacity(int capacity) throws RoomNotFoundException, DatabaseInconsistentStateException {
        Query qry = entityManager.createNamedQuery("RoomEntity.findByRoomCapacity");
        qry.setParameter("roomCapacity", capacity);
        RoomEntity roomEntity = null;
        try {
            roomEntity = (RoomEntity) qry.getSingleResult();

        } catch (NoResultException ne) {
            throw new RoomNotFoundException("Room with this capacity is not found : " + capacity);
        } catch (NonUniqueResultException nue) {
            throw new RoomNotFoundException("Multiple records found for the Room_Capacity : " + capacity + " . ");

        }
        return roomEntity;

    }

    @Override
    public RoomEntity updateRoomCapacity(int roomID, int newCapacity) throws RoomNotFoundException, WrongParameterException {
        if (newCapacity < 1) {
            throw new WrongParameterException("Room can't be less than 1.");
        }
        RoomEntity roomEntity = getRoomId(roomID);
        roomEntity.setRoomCapacity(newCapacity);
        entityManager.persist(roomEntity);

        return roomEntity;

    }

    @Override
    public void deleteRoomById(int roomID) throws RoomNotFoundException {
        RoomEntity roomEntity;
        roomEntity = getRoomId(roomID);
        entityManager.remove(roomEntity);
        System.out.println("Room with the id : " + roomID + " is removed");

    }

    @Override
    
    public List<RoomEntity> allRoomsList() throws RoomNotFoundException {
        Query qry = entityManager.createNamedQuery("RoomEntity.findAll");
        List<RoomEntity> allRooms = qry.getResultList();
        if (allRooms == null || allRooms.isEmpty()) {
            throw new RoomNotFoundException("No room found in database");
        }
        return qry.getResultList();
    }

    @Override
    public RoomEntity updateRoom(int id, String roomNo, int capacity) throws RoomNotFoundException {
        RoomEntity roomEntity;
        roomEntity = getRoomId(id);
        roomEntity.setRoomNo(roomNo);
        roomEntity.setRoomCapacity(capacity);
        entityManager.persist(roomEntity);
        return roomEntity;
    }
}
