package org.example.repository;

import org.example.entity.EmployeeEntity;
import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class GuestRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public PassportEntity getPassport(String passNum) {
        Session session = sessionFactory.openSession();
        Query<PassportEntity> query = session.createQuery("FROM PassportEntity where number = :num", PassportEntity.class);
        query.setParameter("num", passNum);
        PassportEntity entity = null;
        try {
            entity = query.getSingleResult();
        } catch (NoResultException e) {

        }
        session.close();
        return entity;
    }


    public <T> void save(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public GuestEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        GuestEntity guest = session.find(GuestEntity.class, id);
        session.close();
        return guest;
    }


    public List<GuestEntity> getGuestList() {
        Session session = sessionFactory.openSession();
        Query<GuestEntity> query = session.createQuery("FROM GuestEntity ", GuestEntity.class);
        List<GuestEntity> guestEntities = query.getResultList();
        session.close();
        return guestEntities;
    }
}
