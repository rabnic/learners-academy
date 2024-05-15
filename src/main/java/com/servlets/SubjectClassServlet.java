package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClassSubjectDAO;
import com.entities.Subject_Class;

/**
 * Servlet implementation class SubjectClassServlet
 */
public class SubjectClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
int subjectID = Integer.parseInt( request.getParameter("subjectID"));
int classID = Integer.parseInt( request.getParameter("classID"));
		
Subject_Class subjectClass = new Subject_Class(subjectID, classID);
		
		ClassSubjectDAO subjectDAO = new ClassSubjectDAO();
		subjectDAO.addSubjectClass(subjectClass);
		
		response.sendRedirect("subjectClassView.jsp");
	}

}
