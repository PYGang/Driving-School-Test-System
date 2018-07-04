package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.service.admin.ITeacherService;
import com.ouc.onlinexam.service.admin.TeacherService;

@WebServlet("/teacherQueryServlet")
public class TeacherQueryServlet extends HttpServlet{
	
	private ITeacherService ts = new TeacherService();
	/**
	 * doGet方法用于处理查询教师信息请求
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchKey = req.getParameter("searchkey");
		if (null != searchKey)
			searchKey = new String(searchKey.getBytes("ISO-8859-1"), "utf-8");
		//先接收页面的查询参数，如果查询参数是null表示查询所有
		//通过调用业务层的方法获得符合条件的教师信息
		List list = ts.findTeachers(searchKey);
		//把教师信息返回到客户端，客户端引用的变量名是teacherList
		req.setAttribute("teacherList", list);
		//返回信息到客户端的同时，返回的地址也得正确
		//因为我们要把一些数据传递到页面，所以使用getRequestDispather
		req.getRequestDispatcher("manager/teachermanage.jsp").forward(req, resp);
		
	}

	
}
