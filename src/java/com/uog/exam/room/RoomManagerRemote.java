/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uog.exam.room;

import com.uog.exam.entity.RoomEntity;
import javax.ejb.Remote;

/**
 *
 * @author User
 */
@Remote
public interface RoomManagerRemote {

    public RoomEntity addRoom(String roomNo, int roomCapacity) throws WrongParameterException;
}
