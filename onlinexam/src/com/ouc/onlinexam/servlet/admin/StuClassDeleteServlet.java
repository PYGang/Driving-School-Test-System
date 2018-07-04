package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ouc.onlinexam.service.admin.IScheduleService;
import com.ouc.onlinexam.service.admin.IStuClassService;
import com.ouc.onlinexam.service.admin.ScheduleService;
import com.ouc.onlinexam.service.admin.StuClassService;

@WebServlet("/stuClassDeleteServlet")
public class StuClassDeleteServlet extends HttpServlet{
	private IStuClassService ics = new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("info"));
		ics.StuClassDelete(id);
		resp.sendRedirect(req.getContextPath()+"/stuClassQueryServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
