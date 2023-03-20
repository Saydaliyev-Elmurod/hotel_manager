package org.example.entity;

import java.time.LocalDate;

public class BookingEntity {
    private Integer id;
    private GuessEntity guess;
    private RoomEntity room;
    private LocalDate fromDate;
    private Integer day;

    private Double amount = getAmount();

    private Double getAmount() {
        return room.getCost() * day;
    }


}
