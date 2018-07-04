package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.TeacherCourse;
import com.ouc.onlinexam.service.admin.CourseService;
import com.ouc.onlinexam.service.admin.ICourseService;
import com.ouc.onlinexam.service.admin.IScheduleService;
import com.ouc.onlinexam.service.admin.IStuClassService;
import com.ouc.onlinexam.service.admin.ITeacherService;
import com.ouc.onlinexam.service.admin.ScheduleService;
import com.ouc.onlinexam.service.admin.StuClassService;
import com.ouc.onlinexam.service.admin.TeacherService;


@WebServlet("/scheduleModifyServlet")
public class ScheduleModifyServlet extends HttpServlet{
	private ICourseService cs = new CourseService();
	private ITeacherService ts = new TeacherService();
	private IStuClassService scs = new StuClassService();
	private IScheduleService ss = new ScheduleService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接受要修改的id号
		int tcId = Integer.valueOf(req.getParameter("info"));
		TeacherCourse tc= ss.findTeacherCourseById(tcId);
		List csList = cs.findCourses(null);
		List tsList = ts.findTeachers(null);
		List scsList = scs.findAll(null);
		//把要修改的id号再送到页面上s
		req.setAttribute("teaCourId", tcId);
		req.setAttribute("courList", csList);
		req.setAttribute("teaList", tsList);
		req.setAttribute("stuclList", scsList);
		req.setAttribute("tc", tc);
		req.getRequestDispatcher("manager/schedulemodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int tcId = Integer.valueOf(req.getParameter("teaCourId"));
		 //建一个类接受页面上的各项id
		 TeacherCourse ptc = new TeacherCourse();
		 ptc.setId(tcId);
		 ptc.setTeaId(Integer.valueOf(req.getParameter("teacher")));
		 ptc.setCourseId(Integer.valueOf(req.getParameter("course")));
		 ptc.setClassId(Integer.valueOf(req.getParameter("stuclass")));
		 ss.updateTeacherCourseById(ptc);
		 resp.sendRedirect("scheduleQueryServlet");
	}
	
	

}
