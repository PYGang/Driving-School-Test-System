package com.ouc.onlinexam.dao.login;

import com.ouc.onlinexam.po.Student;
import com.ouc.onlinexam.po.Teacher;
import com.ouc.onlinexam.util.DBUtil;

public class LoginDao implements ILoginDao{
	private DBUtil db= new DBUtil();
	@Override
	public Teacher canLogin(Teacher t) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher where name =? and pwd = ?";
		Teacher t2 = new Teacher();
		try {
			t2= (Teacher) db.getObject(Teacher.class, sql, new Object[]{t.getName(),t.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t2;
	}
	
	

	@Override
	public Student canLogin(Student s) {
		// TODO Auto-generated method stub
		String sql = "select * from student where name = ? and pwd =?";
		Student s2 = new Student();
		try {
			s2 = (Student) db.getObject(Student.class, sql, new Object[]{s.getName(),s.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s2;
	}
	
	public static void main(String[] args) {
		ILoginDao id = new LoginDao();
		Student s1 = new Student();
		s1.setName("小明");
		s1.setPwd("123");
		Student s2 = new Student();
		s2=id.canLogin(s1);
		System.out.println(s2.getName());
	}
}
