/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uog.exam.room;

import com.uog.exam.entity.RoomEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author User
 */
@Remote
public interface RoomManagerRemote {

    public RoomEntity addRoom(String roomNo, int roomCapacity) throws WrongParameterException;

    public RoomEntity getRoomId(int roomId) throws RoomNotFoundException;

    public RoomEntity getRoomByNumber(String roomNumber) throws RoomNotFoundException;

    public RoomEntity getRoomByCapacity(int capacity) throws RoomNotFoundException, DatabaseInconsistentStateException;
    
    public RoomEntity updateRoomCapacity(int stdID, int newCapacity) throws RoomNotFoundException, WrongParameterException;
    
    public void deleteRoomById(int roomId) throws RoomNotFoundException;
    
    public List<RoomEntity> allRoomsList() throws RoomNotFoundException;
    
     public RoomEntity updateRoom(int id, String roomNo, int capacity) throws RoomNotFoundException;
    

}
