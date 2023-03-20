package org.example.repository;

import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(RoomEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public RoomEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        RoomEntity room = session.find(RoomEntity.class, id);
        session.close();
        return room;
    }
}
