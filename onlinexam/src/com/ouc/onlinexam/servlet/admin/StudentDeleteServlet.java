package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ouc.onlinexam.service.admin.IScheduleService;
import com.ouc.onlinexam.service.admin.IStuClassService;
import com.ouc.onlinexam.service.admin.IStudentService;
import com.ouc.onlinexam.service.admin.ITeacherService;
import com.ouc.onlinexam.service.admin.ScheduleService;
import com.ouc.onlinexam.service.admin.StuClassService;
import com.ouc.onlinexam.service.admin.StudentService;
import com.ouc.onlinexam.service.admin.TeacherService;

@WebServlet("/studentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet{
	private IStudentService ics = new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		ics.studentDelete(id);
		resp.sendRedirect(req.getContextPath()+"/studentQueryServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
