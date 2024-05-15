package com.dao;

import com.entities.Teacher;
import com.util.HibernateUtil;

import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeacherDAO {
	
	public void addTeacher(Teacher teacher) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(teacher);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<Teacher>  getAllTeachers()
	{
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<Teacher> query = session.createQuery("FROM Teacher", Teacher.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
}
