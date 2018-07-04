package com.ouc.onlinexam.servlet.student;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ouc.onlinexam.po.Paper;
import com.ouc.onlinexam.po.Question;
import com.ouc.onlinexam.po.Student;
import com.ouc.onlinexam.service.student.IPaperService;
import com.ouc.onlinexam.service.student.PaperService;
import com.ouc.onlinexam.service.teacher.IQuestionService;
import com.ouc.onlinexam.service.teacher.ITestService;
import com.ouc.onlinexam.service.teacher.QuestionService;
import com.ouc.onlinexam.service.teacher.TestService;
import com.ouc.onlinexam.util.ToolUtil;

@WebServlet("/studentTestServlet")
public class StudentTestServlet extends HttpServlet {
	ITestService ts = new TestService();
	IQuestionService qs = new QuestionService();
	IPaperService ps = new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student s = (Student) req.getSession().getAttribute("user");
		String testId = req.getParameter("testId");
		Map testMap = ts.findStudentTestsById(s.getId(), Integer.parseInt(testId));
		List<Question> questionList = qs.findQuestionByIds((String) testMap.get("questions"));
		/**
		 * 1.testMap.get("scores")取出来是一个object类型的对象，需要强制转换成String (String)
		 * (testMap.get("scores")) 2.需要把String类型的转换成int类型的，所以使用Integer.parseInt
		 * 3.因为试题的总分和试题数量不一定能整除，因此可能会有小数出现。 在java里面，/是取整
		 */
		req.setAttribute("scoreperques",
				1.0 * Integer.parseInt((String) (testMap.get("scores"))) / questionList.size());
		/**
		 * 需要在多个request和response之间传递试卷信息和试题信息 因此需要把这些信息保存到session中
		 */
		req.getSession().setAttribute("test", testMap);
		req.getSession().setAttribute("quesList", questionList);
		req.getRequestDispatcher("/student/exam.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 从页面上获取答题时间信息
		String time = req.getParameter("hidden1");
		// 从session中获取试题信息
		List quesList = (List) req.getSession().getAttribute("quesList");
		// 从session中获取试卷信息
		Map testMap = (Map) req.getSession().getAttribute("test");

		/**
		 * 从session中能够获取试题集合 试题集合中有试题的id号和答案 页面上展示了试题信息，能够提供每道题的答案
		 * 页面上的试题和我们保存到session中的试题是一样的 通过迭代session中的试题，我们能够获得具体的每一道试题
		 * 通过当前试题的id号能够获取页面上这道题的答案。 通过页面上针对选项的标识--ques_+试题id号能够获得本道题的答案
		 * 试题答案和正确答案做对比，如果不一致，则记录试题的id号和错误答案 然后需要对wrongQueId和wrongAns
		 * 两个stringbuffer做处理 如果试卷全对，则这两个都是“”，否则会多一个逗号 需要把多余的逗号去掉
		 * 另外还需要记录错误题目的数量，用来计算分值 分值的计算方式为：试卷总分/试题数量*正确的题目数量
		 * 把以上信息封装成paper对象，持久化到数据库
		 */
		if (null == quesList || quesList.size() < 1)
			return;
		StringBuffer wrongQueId = new StringBuffer();
		StringBuffer wrongAns = new StringBuffer();
		// 目的是遍历试卷中的试题的集合
		int wrongQueNum = 0;
		for (int i = 0; i < quesList.size(); i++) {
			Question q = (Question) quesList.get(i);
			// 页面接收的答案
			String ans = req.getParameter("ques_" + q.getId()).toUpperCase();
			// 如果和标准答案不匹配，则记录错误的题号和错误答案
			if (!q.getAns().equals(ans)) {
				wrongQueId.append(q.getId()).append(",");
				wrongAns.append(ans).append(",");
				wrongQueNum++;
			}
		}
		// System.out.println(wrongQueId.toString());
		// System.out.println(wrongAns.toString());

		Paper p = new Paper();
		p.setTestId((int) testMap.get("id"));
		p.setCourseId((int) testMap.get("courseId"));
		p.setTime(time);
		// 获得试题的总分和错误试题的数量
		if (quesList.size() > wrongQueNum)
			p.setScore(1.0 * Integer.parseInt((String) (testMap.get("scores"))) / quesList.size()
					* (quesList.size() - wrongQueNum));
		else
			p.setScore(0);
		/**
		 * 如果做的全对，那么wrongQueId和wrongAns，都是空 如果有错题，那么多带了一个逗号
		 */
		String wrongQueIdString = wrongQueId.toString();
		String wrongAnsString = wrongAns.toString();
		if (wrongQueIdString.endsWith(",")) {
			wrongQueIdString = wrongQueIdString.substring(0, wrongQueIdString.length() - 1);
			wrongAnsString = wrongAnsString.substring(0, wrongAnsString.length() - 1);
		}
		p.setWrongQueId(wrongQueIdString);
		p.setWrongAns(wrongAnsString);
		Student s = (Student) req.getSession().getAttribute("user");
		p.setStudentId(s.getId());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();

		try {
			date = formatter.parse(ToolUtil.getCurrentTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		p.setCreatDate(date);
		ps.save(p);
		/**
		 * 开始考试的时候，在页面的超链接上，使用了target="_parent" 跳出了frame框架，因此，重定向的时候需要再定向到frame里
		 */
		resp.sendRedirect(req.getContextPath() + "/student/index.jsp");

	}

}
