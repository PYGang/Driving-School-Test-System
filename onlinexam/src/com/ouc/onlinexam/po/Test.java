package com.ouc.onlinexam.po;

import java.util.Date;

public class Test {
	private int id;//试卷编号
	private String name;//试卷名称
	private int courseId;//所属课程科目
	//private int depId;//
	private Date endDate;//考试结束时间
	private String questions;//题库编号集合
	private int teacherId;//教师工号
	private String classIds;//班级关联集合
	private int testTime;//考试时长
	private String scores;//成绩
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getClassIds() {
		return classIds;
	}
	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}
	public int getTestTime() {
		return testTime;
	}
	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
}
