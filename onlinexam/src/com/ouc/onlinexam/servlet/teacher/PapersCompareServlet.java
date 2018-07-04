package com.ouc.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.service.student.IPaperService;
import com.ouc.onlinexam.service.student.PaperService;

@WebServlet("/papersCompareServlet")
public class PapersCompareServlet extends HttpServlet{
	IPaperService ps = new PaperService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher t = (Teacher) req.getSession().getAttribute("user");
		List paperList = ps.paperCompareInfo(t.getId());
		req.setAttribute("paperList", paperList);
		req.getRequestDispatcher("teacher/classpapers.jsp").forward(req, resp);
	}
	
}
