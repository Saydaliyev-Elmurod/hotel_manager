package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.EmployeeStatus;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column

    private String surname;
    @Column

    private String phone;
    @Column(name = "status", columnDefinition = " varchar default 'ACTIVE' ")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus = EmployeeStatus.ACTIVE;
    @Column
    private LocalDate dateOfBirth;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private EmployeeTypeEntity employeeTypeEntity;
}
