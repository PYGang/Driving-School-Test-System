package com.ouc.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Student;
import com.ouc.onlinexam.util.DBUtil;

public class StudentDao implements IStudentDao{
	DBUtil db = new DBUtil();

	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "insert into student values(?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{s.getId(),s.getName(),s.getPwd(),s.getSex(),s.getBorn(),s.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from student where id="+id;
		Student s = new Student();
		try {
			s = (Student) db.getObject(Student.class, sql, new Object[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
		
	}

	@Override
	public List<Map<String, Object>> findAll(String name) {
		// TODO Auto-generated method stub
		String sql ="select s.*,sc.name as className from student s,stuclass sc where s.classId = sc.id";
		List<Map<String,Object>> studentList = new ArrayList();
		if(null!= name){
			sql = sql+" and s.name like '%"+name+"%'";
			
		}
		try {
			studentList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentList;
	}
	

	@Override
	public void updateStudentByInfo(Student s) {
		// TODO Auto-generated method stub
		String sql = "update student set name=?,pwd=?,sex=?,born=?,classId=? where id ="+s.getId();
		try {
			db.execute(sql, new Object[]{s.getName(),s.getPwd(),s.getSex(),s.getBorn(),s.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		IStudentDao sd = new StudentDao();
		List<Map<String,Object>> sl = new ArrayList();
		sl = sd.findAll("月");
		System.out.println(sl.size());
		Student s = new Student();
		s=sd.findStudentById(1);
		System.out.println(s.getName());
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		String sql="delete from student where id = "+id;
		try {
			db.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
