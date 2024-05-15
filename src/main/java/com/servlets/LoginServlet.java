package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Student;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(email + "  " + password);
		
		HttpSession session = request.getSession();
		
		if(email.equals("admin@mail.com") && password.equals("admin@pwd"))
		{
			session.setAttribute("admin", email);
			response.sendRedirect("reportView.jsp");
		}
		else
		{
			session.setAttribute("invalid", "Invalid email or password! Please try again!");
			response.sendRedirect("index.jsp");
//			request.setAttribute("invalid", "Invalid email or password! Please try again!");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//			dispatcher.forward( request, response );
//			StudentService ss = new StudentService();
//			Student std = ss.UserCheck(email, password);
//			if(std!=null)
//			{
//				session.setAttribute("rno", std.getRollno());
//				session.setAttribute("sname", std.getSname());
//				response.sendRedirect("StudentHome.jsp");
//			}
//			else
//			{
//				response.sendRedirect("Error.jsp");
//			}
		}
	}

}
