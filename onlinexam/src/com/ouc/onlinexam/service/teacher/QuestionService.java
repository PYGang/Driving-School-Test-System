package com.ouc.onlinexam.service.teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.dao.teacher.IQuestionDao;
import com.ouc.onlinexam.dao.teacher.QuestionDao;
import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.Question;
import com.ouc.onlinexam.po.Test;

public class QuestionService implements IQuestionService {
	private IQuestionDao qd = new QuestionDao();

	@Override
	public List<Map<String, Object>> findAll(String key, String value,int id) {
		// TODO Auto-generated method stub

		return qd.findAllQuestionInfo(key, value,id);
	}

	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		qd.addQuestion(q);
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		return qd.findQuestionById(id);
	}

	@Override
	public void updateQuestion(Question q) {
		// TODO Auto-generated method stub
		qd.updateQuestion(q);
	}

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num) {
		// TODO Auto-generated method stub
		List questionList = qd.findQuestionsByCourseId(courseId);
		if (null == questionList) {
			return new ArrayList<Map<String, Object>>();
		}
		Collections.shuffle(questionList);
		if (questionList.size() <= num) {
			return questionList;
		}
		List newQuesList = new ArrayList();
		for (int i = 0; i < num; i++) {
			newQuesList.add(questionList.get(i));
		}
		return newQuesList;
	}

	@Override
	public String testQuestionIds(List<Map<String, Object>> list) {
		if (null == list || list.size() < 1)
			return "";
		// 拼接字符串
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			// 如果是循环的最后一个元素，则最后一个逗号不加
			if (i == list.size() - 1)
				sb.append(list.get(i).get("id"));
			else
				sb.append(list.get(i).get("id")).append(",");

		}
		return sb.toString();
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		return qd.findQuestionByIds(ids);
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		qd.deleteQuestion(id);
	}

	

}
