package com.ouc.onlinexam.servlet.teacher;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.StuClass;
import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.po.Test;
import com.ouc.onlinexam.service.admin.CourseService;
import com.ouc.onlinexam.service.admin.ICourseService;
import com.ouc.onlinexam.service.admin.IStuClassService;
import com.ouc.onlinexam.service.admin.StuClassService;
import com.ouc.onlinexam.service.teacher.IQuestionService;
import com.ouc.onlinexam.service.teacher.QuestionService;
import com.ouc.onlinexam.util.ToolUtil;

@WebServlet("/testAddServlet")
public class TestAddServlet extends HttpServlet{

	ICourseService cs = new CourseService();
	IStuClassService scc = new StuClassService();
	IQuestionService qs = new QuestionService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//teacherId从哪里来？从session中来
	Teacher loginTeacher = (Teacher) req.getSession().getAttribute("user");
	List<Course> courseList = cs.findCoursesByTeacherId(loginTeacher.getId());
	List<StuClass> stuClassList = scc.findStuClassesByTeacherId(loginTeacher.getId());
	//把业务层的结果放到request里，能够传递到页面上
	req.setAttribute("courseList", courseList);
	req.setAttribute("classesList", stuClassList);
	req.getRequestDispatcher("/teacher/testadd.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courseId = req.getParameter("courseid");
		String testName = req.getParameter("testname");
		String endDate = req.getParameter("enddate");
		String score = req.getParameter("sinscores");
		String queNum = req.getParameter("sinnum");
		String testTime = req.getParameter("testtime");
		//复选框的值如何接收？接收到的是id号
		String [] classIds = req.getParameterValues("classCheck");
		/**
		 * static类型的方法可以直接调用，不用new对象
		 * arraytoString方法可以直接使用，功能是把一个数组转换成一个字符串
		 */
		String  classIds2 = ToolUtil.arraytoString(classIds);
		String  classNames = scc.findClassNamesByIds(classIds2);
		Course c = cs.findCourseById(Integer.valueOf(courseId));
		/**
		 * 日期格式转换
		 * 把给定的字符串转换成日期格式
		 */
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		
		try {
			date = formatter.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Teacher loginTeacher = (Teacher) req.getSession().getAttribute("user");
		/**
		 * 把试卷信息封装到Test类里
		 * 冲页面获取的courseId是String类型的，Test类中是int类型，因此需要转换
		 * Integer.valueOf提供了转换的方法
		 * date中存了符合日期格式的截止日期
		 * teacherId从当前登录用户中获取
		 * 
		 */
		Test t = new Test();
		t.setCourseId(Integer.valueOf(courseId));
		t.setName(testName);
		t.setEndDate(date);
		t.setTeacherId(loginTeacher.getId());
		t.setClassIds(classIds2);
		t.setTestTime(Integer.valueOf(testTime));
		t.setScores(score);
		

		List questionList = qs.collectQuestions(Integer.valueOf(courseId),Integer.valueOf(queNum));
		t.setQuestions(qs.testQuestionIds(questionList));
		
		req.getSession().setAttribute("testInfo", t);
		req.setAttribute("quesList", questionList);
		req.setAttribute("c", c);
		req.setAttribute("classNames", classNames);
		req.setAttribute("test", t);
		req.getRequestDispatcher("teacher/test.jsp").forward(req, resp);
	}
	
	
}
