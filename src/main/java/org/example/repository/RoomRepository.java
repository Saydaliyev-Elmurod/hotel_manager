package org.example.repository;

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

    public RoomEntity getByNumber(String number) {
        Session session = sessionFactory.openSession();
        Query<RoomEntity> query = session.createQuery("FROM RoomEntity where number = :num", RoomEntity.class);
        query.setParameter("num", number);
        RoomEntity room = null;
        try {
            room = query.getSingleResult();
        } catch (NoResultException e) {

        }
        session.close();
        return room;

    }

    public List<RoomEntity> getRoomLIst() {
        Session session =   sessionFactory.openSession();
        Query<RoomEntity> query = session.createQuery("FROM RoomEntity ", RoomEntity.class);
        List<RoomEntity> roomEntityList = query.getResultList();
        session.close();
        return roomEntityList;

    }

    public void deleteRoom(Integer id) {
        Session session = sessionFactory.openSession();
        session.delete(id);
        session.close();
    }
}
