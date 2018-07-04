package com.ouc.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Test;
import com.ouc.onlinexam.util.DBUtil;

public class TestDao implements ITestDao {
	private DBUtil db = new DBUtil();

	/**
	 * 添加考试
	 */
	@Override
	public void addTest(Test t) {
		// TODO Auto-generated method stub
		String sql = "insert into test (name,courseId,endDate,questions,teacherId,classIds,testTime,scores) values (?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { t.getName(), t.getCourseId(), t.getEndDate(), t.getQuestions(),
					t.getTeacherId(), t.getClassIds(), t.getTestTime(), t.getScores() });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		// TODO Auto-generated method stub
		/**
		 * 查询近期要考试的信息
		 * 查询的表为：Test,Course,Student,Paper
		 * Test,Course表关系，test.courseId = course.id
		 * Test,Student 表关系，学生所在班级要在试卷针对的班级内，例如试卷针对一班和二班出题，学生
		 * Student ,Paper表的关系，学生如果做过试卷，肯定在paper表里有记录，否则灭有记录
		 * 别的学生做过试卷，和这个学生没有关系
		 * s.id =? and t.id not in (select papers.setId = from papers)
		 * s.id = p.sutdentId
		 */
		String sql = "SELECT DISTINCT t.id,c.name as courseName ,t.name as testName,t.endDate from test t,student s , course c , papers p  WHERE t.courseId = c.id and FIND_IN_SET(s.classId,t.classIds) and s.id = ? and t.endDate >? and t.id not in (SELECT papers.testId from papers where papers.studentId = ?)  ORDER BY s.id";
		List recentTestList = new ArrayList();
		
		try {
		recentTestList = db.getQueryList(sql, new Object[]{id,currData,id});
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return recentTestList;
	}

	@Override
	public List<Map<String, Object>> getTestByTeaId(int id) {
		// TODO Auto-generated method stub
		String sql = "select t.id,c.name as courseName,t.name,t.endDate,t.testTime,t.scores,(SELECT DISTINCT GROUP_CONCAT(sc1.name) FROM stuclass sc1,test t1 where FIND_IN_SET(sc1.id,t1.classIds) and t1.id = t.id) as classNames  from test t,course c where t.courseId = c.id and teacherId = ?";
		List testList = new ArrayList();
		try {
			testList = db.getQueryList(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testList;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		String sql = "SELECT t.id,t.name as testName, c.name as courseName, t.endDate,t.questions,t.testTime,t.scores, sc.name as className ,c.id as courseId from test t,student s , course c, stuclass as sc where t.id = ? and FIND_IN_SET(s.classId,t.classIds) and s.id=? and t.courseId = c.id and s.classId = sc.id";
		Map testMap = new HashMap();
		try {
		testMap = db.getObject(sql, new Object[]{testid, studentid});
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		if (null == testMap)
		return new HashMap();
		return testMap;
		}


}
