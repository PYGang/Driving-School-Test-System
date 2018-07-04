package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.StuClass;
import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.service.admin.IStuClassService;
import com.ouc.onlinexam.service.admin.ITeacherService;
import com.ouc.onlinexam.service.admin.StuClassService;
import com.ouc.onlinexam.service.admin.TeacherService;
import com.ouc.onlinexam.util.Department;

@WebServlet("/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet {
	private ITeacherService  scs= new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tId = Integer.valueOf(req.getParameter("id"));
		Teacher teacherMap = scs.findTeacherById(tId);
		req.setAttribute("teacherInfo", teacherMap);
		//req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/teachermodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 把从页面上提交的属性查封装为对象
		 * request.getParameter获取的值是String类型
		 * 而StuClass的id是int类型
		 * 所以需要类型转换
		 * Integer.valueOf()能够把一个String类型的变量转换成int类型
		 */
		
		String id = req.getParameter("num");
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		//String deptName = req.getParameter("dep");
		/**
		 * 把从页面上提交的属性封装为对象
		 * request.getParameter获取的值是String类型
		 * 而Teacher的id是int类型
		 * 所以需要类型转换
		 * Integer.valueOf()能够把一个String类型的变量转换成int类型
		 */
		
		
		Teacher t = new Teacher();
		t.setId(Integer.valueOf(id));
		t.setName(name);
		t.setPwd(password);
		//t.setDeptName(deptName);
		
		scs.updateTeacherById(t);
		resp.sendRedirect(req.getContextPath()+"/teacherQueryServlet");

		
	}
}
