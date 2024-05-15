package com.dao;

import com.entities.LAClass;
import com.entities.Subject;
import com.util.HibernateUtil;

import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SubjectDAO {
    public void addSubject(Subject subject) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	System.out.println("before -- session.beginTransaction()");
            transaction = session.beginTransaction();
            System.out.println("before -- session.persist(subject);");
            session.persist(subject);
            System.out.println("before -- transaction.commit();");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<Subject>  getAllSubjects()
	{
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<Subject> query = session.createQuery("FROM Subject", Subject.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
    
    public Subject getSubjectByID(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
        	Subject subject = session.get(Subject.class, id);
    		return subject;
        	
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
