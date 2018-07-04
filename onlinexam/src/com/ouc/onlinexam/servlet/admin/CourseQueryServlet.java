package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.service.admin.CourseService;
import com.ouc.onlinexam.service.admin.ICourseService;

@WebServlet("/courseQueryServlet")
public class CourseQueryServlet extends HttpServlet{
	private ICourseService ics = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courseSearch = req.getParameter("courseSearch");
		if (null != courseSearch)
			courseSearch = new String(courseSearch.getBytes("ISO-8859-1"), "utf-8");
		List courseList = ics.findCourses(courseSearch);
		req.setAttribute("tcList", courseList);
		req.getRequestDispatcher("manager/coursemanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
}
