package com.ouc.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.util.DBUtil;

public class CourseDao implements ICourseDao {
	DBUtil db = new DBUtil();
	@Override
	public List<Course> findAllCourseByInfo(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from course ";
		List courseList = new ArrayList();
		if(null!=name){
			sql=sql+" where name like '%"+name+"%'";
			try {
				courseList=db.getQueryList(Course.class, sql, new Object[]{});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				courseList = db.getQueryList(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
      return courseList;
				
	}

	@Override
	public void addCourse(String name) {
		// TODO Auto-generated method stub
		String sql = "insert into course(name) values(?)";
		String sql2 = "select * from course where name = ?";
		Course c = new Course();
		try {
			c = (Course) db.getObject(Course.class, sql2, new Object[]{name});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(null==c){
			try {
				db.execute(sql,new Object[]{name});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from course where id ="+id;
		Course c = new Course();
		try {
			c = (Course)db.getObject(Course.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void updateCourseById(Course course) {
		// TODO Auto-generated method stub
		String sql = "update course set id =?,name = ? where id = ?";
		String sql2 = "select * from course where name = ?";
		Course c = new Course();
		try {
			c = (Course) db.getObject(Course.class, sql2, new Object[]{course.getName()});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(null==c)
		try {
			db.execute(sql, new Object[]{course.getId(),course.getName(),course.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from course where id in (SELECT courseId from teachercourse where teaId = "+ teaId+")";
		List courseList = new ArrayList();
		try {
		courseList = db.getQueryList(Course.class, sql, new Object[]{});
		} catch (Exception e) {
		e.printStackTrace();
		}
		if(null == courseList)
			courseList = new ArrayList();
		return courseList;
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		String sql="delete from course where id ="+id;
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
