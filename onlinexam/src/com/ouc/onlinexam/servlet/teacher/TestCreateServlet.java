package com.ouc.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Test;
import com.ouc.onlinexam.service.teacher.IQuestionService;
import com.ouc.onlinexam.service.teacher.ITestService;
import com.ouc.onlinexam.service.teacher.QuestionService;
import com.ouc.onlinexam.service.teacher.TestService;

@WebServlet("/testCreateServlet")
public class TestCreateServlet extends HttpServlet{
	ITestService ts = new TestService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 之前的准备工作已做好
		 * 试卷对象已有，获取试卷对象后，调用业务层的方法保存试卷信息即可
		 * 怎么获得试卷对象
		 * 因为在上一个servlet中使用了request.getSession.getAttrubute()
		 * 把试卷对象放到了session里，所以这个可以用getAttribute方法得到
		 */
		Test t = (Test) req.getSession().getAttribute("testInfo");
		ts.addTest(t);
		resp.sendRedirect(req.getContextPath()+"/testQueryServlet");
	}
	
	
}
