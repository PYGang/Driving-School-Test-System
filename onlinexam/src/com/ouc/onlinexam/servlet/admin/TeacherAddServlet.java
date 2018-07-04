package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.service.admin.ITeacherService;
import com.ouc.onlinexam.service.admin.TeacherService;
import com.ouc.onlinexam.util.Department;

@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet{
	private ITeacherService its = new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/teacheradd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("num");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//String deptName = req.getParameter("dep");
		Teacher t = new Teacher();
		t.setId(Integer.valueOf(id));
		t.setName(username);
		t.setPwd(password);
		//t.setDeptName(deptName);
		its.addTeacher(t);
		resp.sendRedirect(req.getContextPath()+"/teacherQueryServlet");
	}
	
}
