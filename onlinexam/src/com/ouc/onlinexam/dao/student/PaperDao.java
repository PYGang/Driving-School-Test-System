package com.ouc.onlinexam.dao.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Paper;
import com.ouc.onlinexam.util.DBUtil;

public class PaperDao implements IPaperDao{
	private DBUtil db = new DBUtil();
	@Override
	public void savePaper(Paper p) {
		// TODO Auto-generated method stub
		String sql = "insert into papers(testId,courseId,time,score,wrongQueId,wrongAns,studentId,createDate) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{p.getTestId(),p.getCourseId(),p.getTime(),p.getScore(),p.getWrongQueId(),p.getWrongAns(),p.getStudentId(),p.getCreatDate()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Map<String, Object>> findPapersByInfo(int stuId,String name) {
		// TODO Auto-generated method stub
		String sql = "select c.name as courseName,t.name as testName,p.time,p.createDate,p.score from course c,test t,papers p where c.id = p.courseId and t.id = p.testId and p.studentId = ?";
		if(null!=name){
			sql = sql+" and c.name like '%"+name+"%'";
		}
		List paperList = new ArrayList();
		try {
			paperList = db.getQueryList(sql,new Object[]{stuId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paperList;
	}
	@Override
	public List<Map<String, Object>> paperCompareInfo(int teaId) {
		// TODO Auto-generated method stub
		String sql = "select DISTINCT sc.name as className,c.name as courseName,t.name testName,t.endDate,avg(p.score) as avgScore from student s,stuclass sc,course c,test t,papers p,teacher te,teachercourse tc where tc.classId = sc.id and tc.teaId = te.id and tc.courseId = c.id and t.teacherId = te.id and p.testId = t.id and p.courseId=c.id and s.classId = sc.id and find_in_set(s.id,t.classIds) and te.id="+teaId;
		List paperList = new ArrayList();
		try {
			paperList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paperList;
	}

}
