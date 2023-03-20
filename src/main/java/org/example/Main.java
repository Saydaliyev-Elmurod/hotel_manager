package org.example;

import org.example.config.Config;
import org.example.controller.MainController;
import org.example.repository.RoomRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
//        RoomRepository roomRepository = (RoomRepository) applicationContext.getBean("roomRepository");
////        RoomEntity room = new RoomEntity();
////        room.setNumber("1");
////        room.setFloor(1);
////        room.setArea(56.0);
////        room.setCost(20.5);
////        room.setRoomStatus(RoomStatus.SIMPLE);
////        System.out.println(roomRepository.getById(9));


        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MainController mainController = (MainController) context.getBean("mainController");
        mainController.start();
    }
}