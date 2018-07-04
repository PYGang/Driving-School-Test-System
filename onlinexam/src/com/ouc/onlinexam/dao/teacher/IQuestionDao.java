package com.ouc.onlinexam.dao.teacher;

import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.Question;
import com.ouc.onlinexam.po.Test;

public interface IQuestionDao {
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value,int id);

	public void addQuestion(Question q);

	public Map<String, Object> findQuestionById(int id);
	
	public void updateQuestion(Question q);
	
	/**
	 * 根据课程名称提取试题ID
	 * 
	 * @param courseId
	 * @return
	 */
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId);
	
	/**
	 * 根据给定的试题id号组成的字符串查询id号对应的试题
	 * 返回的是查询到的试题的集合
	 * @param ids 由试题id号组成的字符串
	 * @return 返回试题集合
	 */
	public List<Question> findQuestionByIds(String ids) ;
	
	public void deleteQuestion(int id);
}
