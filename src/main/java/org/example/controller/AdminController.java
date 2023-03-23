package org.example.controller;

import org.example.container.ComponentContainer;
import org.example.entity.RoomEntity;
import org.example.service.ConvenientService;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private ConvenientService convenientService;

    public void start() {
        boolean isEnd = true;
        while (isEnd) {
            menu();
            int action = ComponentContainer.getAction();
            switch (action) {
                case 1 -> {
                    boolean isEndSub = true;
                    while (isEndSub) {
                        roomMenu();
                        int subAction = ComponentContainer.getAction();
                        switch (subAction) {
                            case 1 -> addRoom();
                            case 2 -> listRoom();
                            case 3 -> deleteRoom();
                            case 4 -> updateRoom();
                            case 5 -> findRoom();
                            case 6 -> convenientRoom();
                            case 0 -> isEndSub = false;
                        }
                    }
                }
                case 2 -> {
                    boolean isEndSub = true;
                    while (isEndSub) {
                        convenientMenu();
                        int subAction = ComponentContainer.getAction();
                        switch (subAction) {
                            case 1 -> addConvenient();
                            case 2 -> listConvenient();
                            case 3 -> deleteConvenient();
                            case 0 -> isEndSub = false;
                        }
                    }
                }

            }
        }

    }

    private void deleteConvenient() {
        System.out.print("Enter id ");
        int id = ComponentContainer.IntScanner.nextInt();
        convenientService.delete(id);
    }

    private void listConvenient() {
        print(convenientService.list());
    }

    private void addConvenient() {
        System.out.print("Enter name");
        String name = ComponentContainer.StringScanner.next();
        convenientService.add(name);
    }

    private void convenientMenu() {
        System.out.print("1.Add\n" +
                "2.List\n" +
                "3.Delete\n" +
                "0.Exit");
    }

    private void convenientRoom() {
        System.out.print("Enter id of room ");
        Integer room_id = ComponentContainer.IntScanner.nextInt();
        System.out.print("Enter id of convenient ");
        Integer con_id = ComponentContainer.IntScanner.nextInt();
        roomService.addConvenient(room_id,con_id);

    }

    private void findRoom() {
        System.out.print("Enter number of room ");
        String number = ComponentContainer.StringScanner.next();
        roomService.findRoom(number);
    }

    private void updateRoom() {
        System.out.print("Enter  number of room : ");
        String number = ComponentContainer.StringScanner.next();
        roomService.updateRoom(number);

    }

    private void deleteRoom() {
        System.out.print("Enter number room's");
        String number = ComponentContainer.StringScanner.next();
        roomService.deleteRoom(number);
    }

    private void listRoom() {
        print(roomService.listRoom());
    }

    private void print(List<?> list) {
        list.forEach(System.out::println);
    }

    private void roomMenu() {
        System.out.println("1.Add\n" +
                "2.List\n" +
                "3.Delete\n" +
                "4.Update\n" +
                "5.Find\n" +
                "6.Convenient\n" +
                "0.Exit");
    }

    private void addRoom() {
        System.out.print("Enter number : ");
        String number = ComponentContainer.StringScanner.next();

        System.out.print("Enter floor : ");
        Integer floor = ComponentContainer.IntScanner.nextInt();

        System.out.print("Enter type : ");
        String type = ComponentContainer.StringScanner.next();

        System.out.print("Enter price : ");
        Double price = ComponentContainer.doubleScanner.nextDouble();

        System.out.print("Enter area : ");
        Double area = ComponentContainer.doubleScanner.nextDouble();
        roomService.addRoom(number, floor, type, price, area);

    }

    private void menu() {
        System.out.print("1.Room\n" +
                "2.Convenient\n" +
                "3.Employee Type\n" +
                "4.Employee\n" +
                "5.Guest\n" +
                "6.Booking\n" +
                "7.OutCome\n" +
                "8.Cleaned Rooms\n" +
                "9.Complain\n" +
                "0.Exit\n");
    }
}
