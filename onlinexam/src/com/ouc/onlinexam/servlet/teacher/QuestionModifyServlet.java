package com.ouc.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Question;
import com.ouc.onlinexam.service.admin.CourseService;
import com.ouc.onlinexam.service.admin.ICourseService;
import com.ouc.onlinexam.service.teacher.IQuestionService;
import com.ouc.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionModifyServlet")
public class QuestionModifyServlet extends HttpServlet{
	private IQuestionService qs = new QuestionService();
	private ICourseService cs = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//建一个Map存放要修改的问题的信息
		Map queMap = new HashMap();
		int queId = Integer.valueOf(req.getParameter("id"));
		queMap = qs.findQuestionById(queId);
		//把要修改问题的信息传到页面上
		List courseList = cs.findCourses(null);
		req.setAttribute("courseList", courseList);
		req.setAttribute("questionMap", queMap);
		req.getRequestDispatcher("teacher/quesmodify.jsp").forward(req, resp);;
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id  = Integer.valueOf(req.getParameter("id"));
		int courseId  = Integer.valueOf(req.getParameter("courseId"));
		int queType  =Integer.valueOf(req.getParameter("queType"));
		String queTitle = req.getParameter("queTitle");
		String choiceA = req.getParameter("choiceA");
		String choiceB = req.getParameter("choiceB");
		String choiceC = req.getParameter("choiceC");
		String choiceD = req.getParameter("choiceD");
		String ans = req.getParameter("ans");
		Question q = new Question(courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans);
		q.setId(id);
		qs.updateQuestion(q);
		resp.sendRedirect("questionQueryServlet");
	}
	
	
}
