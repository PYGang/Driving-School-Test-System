package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.service.admin.CourseService;
import com.ouc.onlinexam.service.admin.ICourseService;
import com.ouc.onlinexam.util.Department;

@WebServlet("/courseModifyServlet")
public class CourseModifyServlet extends HttpServlet{
	private ICourseService ics = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cId = Integer.valueOf(req.getParameter("info"));
		Course courseList = ics.findCourseById(cId);
		req.setAttribute("course", courseList);
		req.getRequestDispatcher("manager/coursemodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("courname");
		Course course = new Course();
		course.setId(Integer.valueOf(req.getParameter("id")));
		course.setName(name);
		ics.updateCourseByInfo(course);
		resp.sendRedirect(req.getContextPath()+"/courseQueryServlet");
	}
	
}
