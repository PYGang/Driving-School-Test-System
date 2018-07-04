package com.ouc.onlinexam.service.admin;

import java.util.List;

import com.ouc.onlinexam.dao.admin.CourseDao;
import com.ouc.onlinexam.dao.admin.ICourseDao;
import com.ouc.onlinexam.po.Course;

public class CourseService implements ICourseService{
	private ICourseDao icd= new CourseDao();
	@Override
	public List<Course> findCourses(String name) {
		// TODO Auto-generated method stub
		return icd.findAllCourseByInfo(name);
	}

	@Override
	public void addCourse(String name) {
		// TODO Auto-generated method stub
		icd.addCourse(name);
	}

	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		return icd.findCourseById(id);
	}

	@Override
	public void updateCourseByInfo(Course course) {
		// TODO Auto-generated method stub
		icd.updateCourseById(course);
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		return icd.findCoursesByTeacherId(teaId);
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		icd.deleteCourse(id);
	}

}
