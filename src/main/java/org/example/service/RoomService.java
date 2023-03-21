package org.example.service;

import org.example.entity.RoomEntity;
import org.example.enums.RoomStatus;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public void addRoom(String number, Integer floor, String type, Double price, Double area) {
        //checking ....
        RoomStatus status = null;
        try {
            status = RoomStatus.valueOf(type);
        } catch (IllegalArgumentException e) {
            System.out.println("Type of room dont find");
            return;
        }


        RoomEntity oldRoom = roomRepository.getByNumber(number);
        if (oldRoom != null) {
            System.out.println("Already exist room this number");
            return;
        }
        RoomEntity room = new RoomEntity();
        room.setNumber(number);
        room.setFloor(floor);
        room.setRoomStatus(status);
        room.setPrice(price);
        room.setArea(area);
        roomRepository.save(room);
    }

    public List<RoomEntity> listRoom() {
        return roomRepository.getRoomLIst();
    }

    public void deleteRoom(String  number) {
        RoomEntity room = roomRepository.getByNumber(number);
        if (room==null){
            System.out.println("Not found room ");
            return;
        }
        roomRepository.deleteRoom(room.getId());
    }

    public void findRoom(String number) {
        RoomEntity room = roomRepository.getByNumber(number);
        if (room==null){
            System.out.println("Not found room ");
        }else {
            System.out.println(room);
        }
    }
}
