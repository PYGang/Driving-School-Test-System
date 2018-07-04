package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Student;
import com.ouc.onlinexam.service.admin.IStuClassService;
import com.ouc.onlinexam.service.admin.IStudentService;
import com.ouc.onlinexam.service.admin.StuClassService;
import com.ouc.onlinexam.service.admin.StudentService;
import com.ouc.onlinexam.util.Department;

@WebServlet("/studentModifyServlet")
public class StudentModifyServlet extends HttpServlet{
	private IStudentService ss = new StudentService();
	private IStuClassService scs = new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int studentId = Integer.valueOf(req.getParameter("id"));
		//Student s 存放要修改的类
		Student s = ss.findStudentById(studentId);
		List stuClassList = scs.findAll(null); 
		
		req.setAttribute("student", s);
		//req.setAttribute("deptList", Department.values());
		req.setAttribute("classList", stuClassList);
		
		req.getRequestDispatcher("manager/studentmodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String born = req.getParameter("born");
		//String school = req.getParameter("school");
		//String deptName = req.getParameter("deptId");
		int classId = Integer.valueOf(req.getParameter("classId"));
		//建一个类存放接受的信息
		Student recieveStudent = new Student(id,name ,pwd,sex,born,classId);
		ss.updateStudentByInfo(recieveStudent);
		resp.sendRedirect("studentQueryServlet");
	}
	
}
