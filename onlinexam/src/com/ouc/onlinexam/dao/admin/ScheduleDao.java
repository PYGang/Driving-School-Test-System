package com.ouc.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;

import com.ouc.onlinexam.po.TeacherCourse;
import com.ouc.onlinexam.util.DBUtil;
import com.ouc.onlinexam.vo.TeacherCourseView;

public class ScheduleDao implements IScheduleDao{
	DBUtil db = new DBUtil();
	@Override
	public List<TeacherCourseView> findAll(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT tc.id tcId,tc.teaId tcTeaId,tc.courseId tcCourseId, tc.classId stuclassId, t.name teacherName,c.name courseName,sc.name stuclassName from teachercourse tc,teacher t, course c, stuclass sc where tc.teaId= t.id and tc.courseId=c.id and tc.classId = sc.id";
		List tcList = new ArrayList();
		if(null!= name){
			sql = sql+" and c.name like '%"+name+"%'";
			
		}
			try {
				tcList = db.getQueryList(TeacherCourseView.class, sql, new Object[]{});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return tcList;
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		// TODO Auto-generated method stub
		String sql = "insert into teachercourse(teaId,courseId,classId) values(?,?,?)";
		String sql2 = "select * from teachercourse where teaId=? and courseId=? and classId=?";
		TeacherCourse tc1 = new TeacherCourse();
		try {
			tc1 = (TeacherCourse) db.getObject(TeacherCourse.class, sql2, new Object[]{tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(null == tc1)
		try {
			db.execute(sql,new Object[]{tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		IScheduleDao sd = new ScheduleDao();
		List tcList = sd.findAll(null);
		System.out.println(tcList.size());
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * from teachercourse where id ="+id;
		TeacherCourse tcv = new TeacherCourse();
		try {
			tcv = (TeacherCourse) db.getObject(TeacherCourse.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tcv;
	}

	@Override
	public void updateTCById(TeacherCourse tc) {
		// TODO Auto-generated method stub
		String sql ="update teachercourse set teaId=?,courseId=?,classId=? where id="+tc.getId();
		String sql2 = "select * from teachercourse where teaId=? and courseId=? and classId=?";
		TeacherCourse tc1 = new TeacherCourse();
		try {
			tc1 = (TeacherCourse) db.getObject(TeacherCourse.class, sql2, new Object[]{tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(null == tc1)
		try {
			db.execute(sql,new Object[]{tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteSchedule(int id) {
		// TODO Auto-generated method stub
		String sql="delete from teachercourse where id = "+id;
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
