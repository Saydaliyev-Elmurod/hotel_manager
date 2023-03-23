package org.example.service;

import org.example.entity.EmployeeTypeEntity;
import org.example.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;


    public void add(String type) {
        EmployeeTypeEntity employeeType = employeeTypeRepository.getByName(type);
        if (employeeType != null) {
            System.out.println("This convenient already exists");
        } else {
            EmployeeTypeEntity entity = new EmployeeTypeEntity();
            entity.setType(type);
            employeeTypeRepository.save(entity);
        }

    }

    public List<EmployeeTypeEntity> list() {
        return employeeTypeRepository.getEmployeeTypeList();
    }

    public void delete(int id) {
        employeeTypeRepository.deleteConvenient(id);
    }

}
