package org.example.repository;

import org.example.entity.ConvenientEntity;
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
public class EmployeeTypeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(EmployeeTypeEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public EmployeeTypeEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        EmployeeTypeEntity c = session.find(EmployeeTypeEntity.class, id);
        session.close();
        return c;
    }

    public EmployeeTypeEntity getByName(String type) {
        Session session = sessionFactory.openSession();
        Query<EmployeeTypeEntity> query = session.createQuery("FROM EmployeeTypeEntity where type = :n", EmployeeTypeEntity.class);
        query.setParameter("n", type);
        EmployeeTypeEntity employeeType = null;
        try {
            employeeType = query.getSingleResult();
        } catch (NoResultException e) {

        }
        session.close();
        return employeeType;

    }

    public List<EmployeeTypeEntity> getEmployeeTypeList() {
        Session session = sessionFactory.openSession();
        Query<EmployeeTypeEntity> query = session.createQuery("FROM EmployeeTypeEntity ", EmployeeTypeEntity.class);
        List<EmployeeTypeEntity> employeeTypeEntities = query.getResultList();
        session.close();
        return employeeTypeEntities;

    }

    public void deleteConvenient(int id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from EmployeeTypeEntity where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();

        transaction.commit();
        session.close();

    }

}
