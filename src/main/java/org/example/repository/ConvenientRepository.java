package org.example.repository;

import org.example.entity.ConvenientEntity;
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
public class ConvenientRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(ConvenientEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public ConvenientEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        ConvenientEntity c = session.find(ConvenientEntity.class, id);
        session.close();
        return c;
    }

    public ConvenientEntity getByName(String name) {
        Session session = sessionFactory.openSession();
        Query<ConvenientEntity> query = session.createQuery("FROM ConvenientEntity where name = :n", ConvenientEntity.class);
        query.setParameter("n", name);
        ConvenientEntity convenient = null;
        try {
            convenient = query.getSingleResult();
        } catch (NoResultException e) {

        }
        session.close();
        return convenient;

    }

    public List<ConvenientEntity> getConvenientList() {
        Session session = sessionFactory.openSession();
        Query<ConvenientEntity> query = session.createQuery("FROM ConvenientEntity ", ConvenientEntity.class);
        List<ConvenientEntity> convenientEntityList = query.getResultList();
        session.close();
        return convenientEntityList;

    }

    public void deleteConvenient(int id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from ConvenientEntity where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();

        transaction.commit();
        session.close();

    }

    public void update(ConvenientEntity convenient) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(convenient);
        transaction.commit();
        session.close();
    }

}
