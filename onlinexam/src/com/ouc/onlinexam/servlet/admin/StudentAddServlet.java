package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.StuClass;
import com.ouc.onlinexam.po.Student;
import com.ouc.onlinexam.service.admin.CourseService;
import com.ouc.onlinexam.service.admin.ICourseService;
import com.ouc.onlinexam.service.admin.IStuClassService;
import com.ouc.onlinexam.service.admin.IStudentService;
import com.ouc.onlinexam.service.admin.StuClassService;
import com.ouc.onlinexam.service.admin.StudentService;
import com.ouc.onlinexam.util.Department;

@WebServlet("/studentAddServlet")
public class StudentAddServlet extends HttpServlet{
	private ICourseService cs = new CourseService();
	private IStuClassService scs = new StuClassService();
	private IStudentService ss = new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List stuClassList = scs.findAll(null);
		//req.setAttribute("deptList", Department.values());
		req.setAttribute("classList", stuClassList);
		req.getRequestDispatcher("manager/studentadd.jsp").forward(req, resp);
		
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
		//String deptName = req.getParameter("deptName");
		int classId = Integer.valueOf(req.getParameter("classId"));
		Student s = new Student(id,name,pwd,sex,born,classId);
		ss.addStudent(s);
		resp.sendRedirect("studentQueryServlet");
		
	}
	
	
}
