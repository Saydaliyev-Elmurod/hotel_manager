package org.example.entity;

import java.time.LocalDate;

public class BookingEntity {
    private Integer id;
    private GuestEntity guess;
    private RoomEntity room;
    private LocalDate fromDate;
    private Integer day;

    private Double amount = getAmount();

    private Double getAmount() {
        return room.getPrice() * day;
    }


}
