package org.example.repository;

import org.example.entity.ConvenientEntity;
import org.example.entity.EmployeeEntity;
import org.example.entity.EmployeeTypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(EmployeeEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public EmployeeEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        EmployeeEntity c = session.find(EmployeeEntity.class, id);
        session.close();
        return c;
    }



    public List<EmployeeEntity> getEmployeeList() {
        Session session = sessionFactory.openSession();
        Query<EmployeeEntity> query = session.createQuery("FROM EmployeeEntity ", EmployeeEntity.class);
        List<EmployeeEntity> employeeEntities = query.getResultList();
        session.close();
        return employeeEntities;

    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from EmployeeEntity where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void update(EmployeeEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }
}
