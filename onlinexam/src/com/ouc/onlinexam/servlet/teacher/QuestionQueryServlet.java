package com.ouc.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.service.teacher.IQuestionService;
import com.ouc.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionQueryServlet")
public class QuestionQueryServlet extends HttpServlet{
	private IQuestionService qs = new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 接收页面的请求
		 * 接收页面传递过来的请求，是通过request.getParameter方法
		 * 方法的参数就是页面控件的name。文本框，下拉列表框都是这种方式
		 * 例如<input type = "text" name = "username" >
		 * request.getParameter(username)
		 * 下拉列表框也是同样的方式引用name属性
		 * 下拉列表框<option value = ?>显示的值</option>
		 * 问号的位置是我们获取的值
		 */

		String searchKey = req.getParameter("selectk");
		String searchValue = req.getParameter("searchName");
		if (null != searchValue)
		searchValue = new String(searchValue.getBytes("ISO-8859-1"), "utf-8");
		Teacher t = (Teacher) req.getSession().getAttribute("user");
		List<Map<String,Object>> queList = qs.findAll(searchKey, searchValue,t.getId());
		req.setAttribute("queList", queList);
		req.getRequestDispatcher("/teacher/questionmanage.jsp").forward(req, resp);

	}
	
}
