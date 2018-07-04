package com.ouc.onlinexam.po;

import java.util.Date;

public class Paper {
	int id;//学生试卷编号
	int testId;//对应试卷编号
	int courseId;//考试科目
	String time;//考试时间
	double score;//考试成绩
	String wrongQueId;//错题的题库编号集合
	String wrongAns;//学生对于该错题的答案集合
	int studentId;//学生编号
	Date creatDate;//提交时间
	
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getWrongQueId() {
		return wrongQueId;
	}
	public void setWrongQueId(String wrongQueId) {
		this.wrongQueId = wrongQueId;
	}
	public String getWrongAns() {
		return wrongAns;
	}
	public void setWrongAns(String wrongAns) {
		this.wrongAns = wrongAns;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

}
