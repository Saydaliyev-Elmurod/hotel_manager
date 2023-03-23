package org.example.service;

import org.example.entity.EmployeeEntity;
import org.example.entity.EmployeeTypeEntity;
import org.example.enums.EmployeeStatus;
import org.example.repository.EmployeeRepository;
import org.example.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public void add(String name, String surname, String phone, String birthday, Integer id) {
        EmployeeTypeEntity employeeType = employeeTypeRepository.getById(id);
        if (employeeType == null) {
            System.out.println("Employee type not found");
            return;
        }
        LocalDate dateOfBirthday = LocalDate.parse(birthday);
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(name);
        entity.setSurname(surname);
        entity.setPhone(phone);
        entity.setDateOfBirth(dateOfBirthday);
        entity.setEmployeeTypeEntity(employeeType);
        employeeRepository.save(entity);
    }

    public List<EmployeeEntity> list() {
        return employeeRepository.getEmployeeList();
    }

    public void delete(Integer id) {
        EmployeeEntity entity = employeeRepository.getById(id);
        if (entity == null) {
            System.out.println("Employee not found");
            return;
        }
        entity.setEmployeeStatus(EmployeeStatus.NOT_ACTIVE);
        employeeRepository.update(entity);
    }
}
