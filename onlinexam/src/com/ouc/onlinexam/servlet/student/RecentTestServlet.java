package com.ouc.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Student;
import com.ouc.onlinexam.service.teacher.ITestService;
import com.ouc.onlinexam.service.teacher.TestService;
import com.ouc.onlinexam.util.ToolUtil;

/**
 * 查询这个学生近期考试的试卷列表
 * 
 * @author Moons
 *
 */
@WebServlet("/recentTestServlet")
public class RecentTestServlet extends HttpServlet {
	ITestService ts = new  TestService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 在学生登录的时候，把学生信息保存到了session中
		 * 在这里使用getAttribute获取
		 */
		Student s = (Student)req.getSession().getAttribute("user");
		//获取当前学生的近期试卷列表	
		/**
		 * 学生的id号可以通过getId获取
		 */
		List testList = ts.getTestByStudent(s.getId(), ToolUtil.getCurrentTime());
		//把试卷结果放到request里，通过页面跳转，把数据放到页面上
		req.setAttribute("testsList", testList);
		req.getRequestDispatcher("student/main.jsp").forward(req, resp);
	}
	
}
