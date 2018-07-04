package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.service.admin.CourseService;
import com.ouc.onlinexam.service.admin.ICourseService;

@WebServlet("/courseAddServlet")
public class CourseAddServlet extends HttpServlet{
	private ICourseService ics = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("manager/courseadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("courname");
		ics.addCourse(name);
		resp.sendRedirect(req.getContextPath()+"/courseQueryServlet");
	}
	
}
