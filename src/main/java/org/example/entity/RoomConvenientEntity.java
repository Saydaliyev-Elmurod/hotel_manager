package org.example.entity;

import lombok.Setter;

import javax.persistence.*;
@Setter
@Entity
@Table(name = "room_convenient")
public class RoomConvenientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomEntity room;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "convenient_id")
    private ConvenientEntity convenient;

}
