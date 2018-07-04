package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.StuClass;
import com.ouc.onlinexam.service.admin.IStuClassService;
import com.ouc.onlinexam.service.admin.StuClassService;
import com.ouc.onlinexam.util.Department;

@WebServlet("/stuClassModifyServlet")
public class StuClassModifyServlet extends HttpServlet{
	private IStuClassService  scs= new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int classId = Integer.valueOf(req.getParameter("info"));
		StuClass stuClassMap = scs.findStuClassById(classId);
		req.setAttribute("stuClassMap", stuClassMap);
		//req.setAttribute("depList", Department.values());
		req.getRequestDispatcher("manager/stuclassmodify.jsp").forward(req, resp);
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
		
		String id = req.getParameter("clanum");
		String name = req.getParameter("claname");
		//String deptName = req.getParameter("depInfo");
		/**
		 * 把从页面上提交的属性封装为对象
		 * request.getParameter获取的值是String类型
		 * 而StuClass的id是int类型
		 * 所以需要类型转换
		 * Integer.valueOf()能够把一个String类型的变量转换成int类型
		 */
		
		
		StuClass sc = new StuClass();
		sc.setId(Integer.valueOf(id));
		sc.setName(name);
		//sc.setDeptName(deptName);
		
		scs.updateStuClass(sc);
		resp.sendRedirect(req.getContextPath()+"/stuClassQueryServlet");
		//调用业务层的接口方法，增加课程信息
		
	}

	
}
