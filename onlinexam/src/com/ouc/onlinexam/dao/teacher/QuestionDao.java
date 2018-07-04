package com.ouc.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.Question;
import com.ouc.onlinexam.po.Test;
import com.ouc.onlinexam.util.DBUtil;

public class QuestionDao implements IQuestionDao {
	private DBUtil db = new DBUtil();

	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value,int id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		String sql = "SELECT que.id ,c.name, que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c,teachercourse tc where que.courseId = c.id and que.courseId=tc.courseId and tc.teaId="+id;
		if (null != value) {
			sql = sql + " and " + key + " like '%" + value + "%'";
		}
		sql = sql + " order by que.id";
		try {
			queList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queList;

	}

	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		String sql = "insert into questions values(?,?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { q.getId(), q.getCourseId(), q.getQueType(), q.getQueTitle(), q.getChoiceA(),
					q.getChoiceB(), q.getChoiceC(), q.getChoiceD(), q.getAns() });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from questions where id =" + id;
		Map<String, Object> quesMap = new HashMap<String, Object>();
		try {
			quesMap = db.getObject(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quesMap;
	}

	@Override
	public void updateQuestion(Question q) {
		// TODO Auto-generated method stub
		String sql = "update questions set courseId=?,queType=?,queTitle=?,choiceA=?,choiceB=?,choiceC=?,choiceD=?,ans=? where id ="
				+ q.getId();
		try {
			db.execute(sql, new Object[] { q.getCourseId(), q.getQueType(), q.getQueTitle(), q.getChoiceA(),
					q.getChoiceB(), q.getChoiceC(), q.getChoiceD(), q.getAns() });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where CourseId = ? order by id desc";
		List<Map<String, Object>> quesList = new ArrayList<Map<String, Object>>();
		try {
			quesList = db.getQueryList(sql, new Object[] { courseId });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quesList;
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where FIND_IN_SET (id,?)";
		List questionList = new ArrayList();
		try {
			questionList = db.getQueryList(Question.class, sql, new Object[]{ids});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null == questionList)
			questionList = new ArrayList();
		return questionList;
	}
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		String sql="delete from questions where id = "+id;
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
