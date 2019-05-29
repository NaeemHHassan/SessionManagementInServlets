package com.softechsol.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SourceServlet
 */
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Source Servlet");
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		System.out.println(session.getAttribute("userName"));
		System.out.println(userName);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<a href='targetServlet'> Hit to get userName </a>");
		session.setMaxInactiveInterval(300);

		Cookie c = new Cookie("userName", userName);
		response.addCookie(c);

		Cookie cookies[] = request.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
			System.out.println("Cookie Name"+cookies[i].getName() + " Value : "+cookies[i].getValue());
		}
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
