package com.ouc.onlinexam.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Student;
import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.service.login.ILoginService;
import com.ouc.onlinexam.service.login.LoginService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private ILoginService ls = new LoginService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = req.getParameter("username");
		String pwd = req.getParameter("password");
		String role = req.getParameter("role");
		if ("admin".equals(role)) {
			if ("admin".equals(userName) && "123".equals(pwd)) {
				req.getRequestDispatcher("manager/mindex.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("login.jsp");
			}
		} else if ("teacher".equals(role)) {
			Teacher t = new Teacher();
			t.setName(userName);
			t.setPwd(pwd);
			Teacher t2 = ls.canLogin(t);
			if (null != t2) {
				req.getSession().setAttribute("user", t2);
				req.getRequestDispatcher("teacher/tindex.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("login.jsp");

			}
		} else {
			Student s = new Student();
			s.setName(userName);
			s.setPwd(pwd);
			Student s2 = ls.canLogin(s);
			if(null!=s2){
				req.getSession().setAttribute("user", s2);
				req.getRequestDispatcher("student/index.jsp").forward(req, resp);
			}else{
				resp.sendRedirect("login.jsp");
			}
		}
	}

}
