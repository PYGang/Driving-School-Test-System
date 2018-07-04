package com.ouc.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Test;

public interface ITestService {
	/**
	 * 根据存储页面接受的试卷信息的t添加考试
	 * @param t
	 */
	public void addTest(Test t);
	/**
	 * 根据学生id号查询即将考试的试卷（test表）
	 * @param id 学生的id号
	 * @param currData 当前的日期时间
	 * @return 返回的是test集合
	 */
	public List<Map<String, Object>> getTestByStudent(int id, String currData);
	
	/**
	 * 根据学生id号和试卷编号查询试卷信息
	 * @param studentid
	 * @param testid
	 * @return 返回试卷信息的map
	 */
	public Map<String, Object> findStudentTestsById(int studentid,int testid);
	
	public List<Map<String, Object>> getRencentTestByTeaId(int id);
	
	
}
