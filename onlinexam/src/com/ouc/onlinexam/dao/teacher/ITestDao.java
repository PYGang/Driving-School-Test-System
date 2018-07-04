package com.ouc.onlinexam.dao.teacher;

import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Test;

public interface ITestDao {
	public void addTest(Test t);
	
	public List<Map<String,Object>> getTestByStudent(int id,String currData);

	public List<Map<String,Object>> getTestByTeaId(int id);
	
	/**
	 * 根据学生id号和试卷编号查询试卷信息
	 * @param studentid
	 * @param testid
	 * @return 返回试卷信息的map
	 */
	public Map<String, Object> findStudentTestsById(int studentid,int testid) ;

}
