package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.RoomStatus;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number", nullable = false, length = 15, unique = true)
    private String number;
    @Column(nullable = false, length = 10)
    private Integer floor;
    @Column
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;
    @Column
    private Double price;
    @Column
    private Double area;

    @Override
    public String toString() {
        return "RoomEntity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", floor=" + floor +
                ", roomStatus=" + roomStatus +
                ", price=" + price +
                ", area=" + area +
                '}';
    }
}
