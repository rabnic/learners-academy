package com.dao;

import com.entities.LAClass;
import com.entities.Subject_Class;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import com.util.HibernateUtil;

import jakarta.persistence.TypedQuery;

public class ClassSubjectDAO {

    // Method to add a new Subject_Class entry
    public void addSubjectClass(Subject_Class subjectClass) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(subjectClass);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
    }

    // Method to get all Subject_Class entries
    public List<Subject_Class> getAllSubjectClasses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	TypedQuery<Subject_Class> query = session.createQuery("FROM Subject_Class", Subject_Class.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}

