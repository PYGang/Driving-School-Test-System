package com.ouc.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.Question;
import com.ouc.onlinexam.po.Test;

/**
 * 根据查找的信息查询符合条件的试题，模糊查询
 * @param key 课程科目或试题题目
 * @param value 要搜索的关键信息
 * @return 查询的试题的集合
 */
public interface IQuestionService {
	public List<Map<String,Object>> findAll(String key, String value,int id);
	/**
	 * 增加试题
	 * @param q 试题对象
	 */
	public void addQuestion(Question q);
	/**
	 * 根据id查询试题信息
	 * @param id 试题id号
	 * @return 返回map，字段和对应的值键值对
	 */
	public Map<String, Object> findQuestionById(int id);
	
	/**
	 * 修改试题
	 * @param q 试题对象
	 */
	public void updateQuestion(Question q);
	
	/**
	 * 根据课程名称和试题数量获得所需试题
	 * @param courseId 课程名称
	 * @param num 试题数量
	 * @return 返回试题的集合
	 */
	public List<Map<String, Object>> collectQuestions(int courseId,int num);

	/**
	 * 通过给定的question的集合获得集合里的question的id号
	 * 组成一个string类型的字符串，并且id之间以逗号隔开
	 * @param list
	 * @return
	 */
	public String testQuestionIds(List<Map<String, Object>> list);

	/**
	 * 根据给定的试题id号组成的字符串查询id号对应的试题
	 * 返回的是查询到的试题的集合
	 * @param ids 由试题id号组成的字符串
	 * @return 返回试题集合
	 */
	public List<Question> findQuestionByIds(String ids) ;
	
	public void deleteQuestion(int id);


}
