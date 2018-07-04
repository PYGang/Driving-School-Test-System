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

@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet{
	
	private IStuClassService scs = new StuClassService();
	/**
	 * 当页面上点击“增加班级”时，访问的方法
	 *获取页面需要提供的方向名称，并且把数据传递到页面上
	 *页面跳转
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 把servlet中的信息传递到页面上
		 * Department.values()可以获得所属方向的集合
		 * 页面上，遍历这个集合的时候起的名字是depList
		 */
		//req.setAttribute("depList", Department.values());
		req.getRequestDispatcher("manager/stuclassadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 以下三行是从页面上获取输入的信息
		 * 参数名是页面上的控件name
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
		//调用业务层的接口方法，增加课程信息
		scs.addStuClass(sc);
		/**
		 * 添加完后要跳转页面，一般要跳转到查询所有的班级页面
		 * 之前查询的班级信息里不包括新增加的班级
		 * 如果想把新增的班级显示出来，必须要再次查询一边数据库
		 * 而stuClassQueryServlet实现了查询功能，因此可以直接跳转
		 * 这里添加完成，不需要再往页面上添加信息，因此可以用resp.sendRedirect()
		 */
		resp.sendRedirect(req.getContextPath()+"/stuClassQueryServlet");
		//req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);;
	}
	
	
	
}
