package org.example.service;

import org.example.container.ComponentContainer;
import org.example.entity.ConvenientEntity;
import org.example.entity.RoomConvenientEntity;
import org.example.entity.RoomEntity;
import org.example.enums.RoomStatus;
import org.example.repository.ConvenientRepository;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ConvenientRepository convenientRepository;

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

    public void deleteRoom(String number) {
        RoomEntity room = roomRepository.getByNumber(number);
        if (room == null) {
            System.out.println("Not found room ");
            return;
        }
        roomRepository.deleteRoom(room);
    }

    public void findRoom(String number) {
        RoomEntity room = roomRepository.getByNumber(number);
        if (room == null) {
            System.out.println("Not found room ");
        } else {
            System.out.println(room);
        }
    }

    public void updateRoom(String number) {
        RoomEntity room = roomRepository.getByNumber(number);
        if (room == null) {
            System.out.println("Room not found");
            return;
        }
        System.out.print("Enter new Number");
        String num = ComponentContainer.StringScanner.next();
        room.setNumber(num);

        System.out.print("Enter floor : ");
        Integer floor = ComponentContainer.IntScanner.nextInt();
        room.setFloor(floor);

        System.out.print("Enter type : ");
        String type = ComponentContainer.StringScanner.next();
        room.setRoomStatus(RoomStatus.valueOf(type));

        System.out.print("Enter price : ");
        Double price = ComponentContainer.doubleScanner.nextDouble();
        room.setPrice(price);

        System.out.print("Enter area : ");
        Double area = ComponentContainer.doubleScanner.nextDouble();
        room.setArea(area);
        roomRepository.update(room);
    }

    public void addConvenient(Integer roomId, Integer conId) {
        RoomEntity room = roomRepository.getById(roomId);
        if (room ==null){
            System.out.println("Room not found");
            return;
        }
        ConvenientEntity convenient = convenientRepository.getById(conId);
        if (convenient ==null){
            System.out.println("Convenient not found");
            return;
        }
        RoomConvenientEntity roomConvenient = new RoomConvenientEntity();
        roomConvenient.setRoom(room);
        roomConvenient.setConvenient(convenient);
        roomRepository.addConvenient(roomConvenient);
    }
}
