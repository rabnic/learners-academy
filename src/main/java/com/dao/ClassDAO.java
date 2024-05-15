package com.dao;

import com.entities.LAClass;
import com.entities.Student;
import com.util.HibernateUtil;

import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClassDAO {
    public void addClass(LAClass classObj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(classObj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<LAClass>  getAllClasses()
	{
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<LAClass> query = session.createQuery("FROM LAClass", LAClass.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
    
    public LAClass getClassByID(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
        	LAClass classObj = session.get(LAClass.class, id);
    		return classObj;
        	
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}

