package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.service.admin.IStuClassService;
import com.ouc.onlinexam.service.admin.StuClassService;

/**
 * StruClassQueryServlet专门用于处理班级查询班级信息
 * 这个类必须继承HttpServlet
 * 通过WebSevlet来定义这个类处理的请求地址
 * @author Moons
 *
 */
@WebServlet("/stuClassQueryServlet")
public class StuClassQueryServlet extends HttpServlet{
	private IStuClassService scs = new StuClassService();
	/**
	 * 一般get方式用于查询
	 * 适用场景:1.form表单提交<form action ="" method ="get">
	 * 2.页面上直接使用一个超链接查询
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("Submit");
		List stuClassList =  scs.findAll(name);
		/**
		 * 如何把结果放到页面上
		 * 通过req.setAtribute方法
		 * 第一个参数表示key，通过key能够引用到值
		 * 第二个参数是具体地值
		 * 页面上迭代这个集合，通过c:foreach迭代
		 * 迭代的对象是scList，所以key设置为scList
		 * 和页面上要对应，必须完全一致
		 * 
		 */
		req.setAttribute("scList", stuClassList);
		req.getRequestDispatcher("/manager/stuclassmanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
