package com.ouc.onlinexam.service.admin;

import java.util.List;

import com.ouc.onlinexam.dao.admin.IScheduleDao;
import com.ouc.onlinexam.dao.admin.ScheduleDao;
import com.ouc.onlinexam.po.TeacherCourse;
import com.ouc.onlinexam.vo.TeacherCourseView;

public class ScheduleService implements IScheduleService{
	private IScheduleDao sd = new ScheduleDao();
	@Override
	public List<TeacherCourseView> findAll(String name) {
		// TODO Auto-generated method stub
		return sd.findAll(name);
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		// TODO Auto-generated method stub
		sd.addSchedule(tc);
	}

	@Override
	public TeacherCourse findTeacherCourseById(int tcId) {
		// TODO Auto-generated method stub
		return sd.findTeacherCourseById(tcId);
	}

	@Override
	public void updateTeacherCourseById(TeacherCourse tc) {
		// TODO Auto-generated method stub
		sd.updateTCById(tc);
	}

	@Override
	public void deleteSchedule(int id) {
		// TODO Auto-generated method stub
		sd.deleteSchedule(id);
	}

}
