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

@WebServlet("/scheduleAddServlet")
public class ScheduleAddServlet extends HttpServlet{
	private ICourseService cs = new CourseService();
	private ITeacherService ts = new TeacherService();
	private IStuClassService scs = new StuClassService();
	private IScheduleService ss = new ScheduleService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List csList = cs.findCourses(null);
		List tsList = ts.findTeachers(null);
		List scsList = scs.findAll(null);
		req.setAttribute("courseList", csList);
		req.setAttribute("teaList", tsList);
		req.setAttribute("stuclList", scsList);
		req.getRequestDispatcher("manager/scheduleadd.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid = Integer.valueOf(req.getParameter("course"));
		int tid = Integer.valueOf(req.getParameter("teacher"));
		int scid = Integer.valueOf(req.getParameter("stuclass"));
		TeacherCourse tc = new TeacherCourse();
		tc.setClassId(scid);
		tc.setTeaId(tid);
		tc.setCourseId(cid);
		ss.addSchedule(tc);
		resp.sendRedirect("scheduleQueryServlet");
	}
	
}
