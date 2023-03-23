package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "guess")
public class GuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column

    private String surname;
    @Column

    private String phone;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_id")
    private PassportEntity passport;
}
