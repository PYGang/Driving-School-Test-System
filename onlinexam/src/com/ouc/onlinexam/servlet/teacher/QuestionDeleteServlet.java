package com.ouc.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.service.teacher.IQuestionService;
import com.ouc.onlinexam.service.teacher.QuestionService;




@WebServlet("/questionDeleteServlet")
public class QuestionDeleteServlet extends HttpServlet{
	private IQuestionService iqs = new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		iqs.deleteQuestion(id);
		resp.sendRedirect(req.getContextPath()+"/questionQueryServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
