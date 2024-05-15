package com.dao;

import com.entities.Student;
import com.util.HibernateUtil;

import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {
	
	public void addStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<Student>  getAllStudents()
	{
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TypedQuery<Student> query = session.createQuery("FROM Student", Student.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
    
    public Student getStudentByID(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
    		Student student = session.get(Student.class, id);
    		return student;
        	
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

