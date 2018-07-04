package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.service.admin.IStudentService;
import com.ouc.onlinexam.service.admin.StudentService;

@WebServlet("/studentQueryServlet")
public class StudentQueryServlet extends HttpServlet{
	private IStudentService ss = new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameSearch = req.getParameter("nameSearch");
		if (null != nameSearch)
			nameSearch = new String(nameSearch.getBytes("ISO-8859-1"), "utf-8");
		List ssList = ss.findAll(nameSearch);
		req.setAttribute("studentList", ssList);
		req.getRequestDispatcher("manager/studentmanage.jsp").forward(req, resp);
	}


	
}
