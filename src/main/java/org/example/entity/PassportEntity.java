package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "passport")
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer employee_id;
    @Column
    private String number;
    @Column
    private LocalDate given_date;
    @Column
    private LocalDate exp_date;
    @Column
    private String givenBy;
}
