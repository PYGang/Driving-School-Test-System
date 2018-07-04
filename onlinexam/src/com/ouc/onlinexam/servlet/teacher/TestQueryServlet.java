package com.ouc.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.service.teacher.ITestService;
import com.ouc.onlinexam.service.teacher.TestService;

@WebServlet("/testQueryServlet")
public class TestQueryServlet extends HttpServlet{
	ITestService ts = new TestService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher t = (Teacher) req.getSession().getAttribute("user");
		List testList = new ArrayList();
		testList = ts.getRencentTestByTeaId(t.getId());
		req.setAttribute("testsList", testList);
		req.getRequestDispatcher("teacher/tmain.jsp").forward(req, resp);
	}
	
}
