package com.ouc.onlinexam.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Student;
import com.ouc.onlinexam.service.student.IPaperService;
import com.ouc.onlinexam.service.student.PaperService;

@WebServlet("/pastTestServlet")
public class PastTestServlet extends HttpServlet{
	IPaperService ps = new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student s = (Student) req.getSession().getAttribute("user");
		String name = req.getParameter("courseSearch");
		List paperList = new ArrayList();
		paperList = ps.findPapersByInfo(s.getId(), name);
		req.setAttribute("paperList", paperList);
		req.getRequestDispatcher("/student/history.jsp").forward(req, resp);
	}
	
}
