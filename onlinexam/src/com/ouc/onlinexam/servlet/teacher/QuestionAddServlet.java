package com.ouc.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.Question;
import com.ouc.onlinexam.service.admin.CourseService;
import com.ouc.onlinexam.service.admin.ICourseService;
import com.ouc.onlinexam.service.teacher.IQuestionService;
import com.ouc.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionAddServlet")
public class QuestionAddServlet extends HttpServlet{
	private IQuestionService qs = new QuestionService();
	private ICourseService cs = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List courseList = cs.findCourses(null);
		req.setAttribute("courseList", courseList);
		req.getRequestDispatcher("teacher/quesadd.jsp").forward(req, resp);;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int courseId  = Integer.valueOf(req.getParameter("courseId"));
		int queType  =Integer.valueOf(req.getParameter("queType"));
		String queTitle = req.getParameter("queTitle");
		String choiceA = req.getParameter("choiceA");
		String choiceB = req.getParameter("choiceB");
		String choiceC = req.getParameter("choiceC");
		String choiceD = req.getParameter("choiceD");
		String ans = req.getParameter("ans");
		Question q = new Question(courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans);
		qs.addQuestion(q);
		resp.sendRedirect("questionQueryServlet");
	}
	
}
