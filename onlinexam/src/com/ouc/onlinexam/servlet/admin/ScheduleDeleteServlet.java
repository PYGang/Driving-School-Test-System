package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ouc.onlinexam.service.admin.IScheduleService;
import com.ouc.onlinexam.service.admin.ScheduleService;

@WebServlet("/scheduleDeleteServlet")
public class ScheduleDeleteServlet extends HttpServlet{
	private IScheduleService ics = new ScheduleService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("info"));
		ics.deleteSchedule(id);
		resp.sendRedirect(req.getContextPath()+"/scheduleQueryServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
