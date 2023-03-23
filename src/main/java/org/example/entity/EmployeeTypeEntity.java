package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Setter
@Getter
@Entity
@Table(name = "employee_type")
public class EmployeeTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type")
    private String type;

}
