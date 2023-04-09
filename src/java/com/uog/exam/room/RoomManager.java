/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uog.exam.room;

import com.uog.exam.entity.RoomEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
