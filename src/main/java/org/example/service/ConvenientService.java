package org.example.service;

import org.example.entity.ConvenientEntity;
import org.example.entity.RoomEntity;
import org.example.repository.ConvenientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class ConvenientService {
    @Autowired
    private ConvenientRepository convenientRepository;


    public void add(String name) {
        ConvenientEntity convenient = convenientRepository.getByName(name);
        if (convenient != null) {
            System.out.println("This convenient already exists");
        } else {
            ConvenientEntity entity = new ConvenientEntity();
            entity.setName(name);
            convenientRepository.save(entity);
        }

    }

    public List<ConvenientEntity> list() {
        return convenientRepository.getConvenientList();
    }

    public void delete(int id) {
        convenientRepository.deleteConvenient(id);
    }
}
