package com.ouc.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.service.admin.IScheduleService;
import com.ouc.onlinexam.service.admin.ScheduleService;

@WebServlet("/scheduleQueryServlet")
public class ScheduleQueryServlet extends HttpServlet{
	private IScheduleService ss = new ScheduleService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//把方法返回的结果赋给一个集合
		String name = req.getParameter("courseSearch");
		if (null != name)
			name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		List scheduleList = ss.findAll(name);
		req.setAttribute("tcList", scheduleList);
		//因为有数据要传递到页面，因此只能使用getRequestDispatcher
		req.getRequestDispatcher("manager/schedulemanage.jsp").forward(req, resp);
	}
		
}
