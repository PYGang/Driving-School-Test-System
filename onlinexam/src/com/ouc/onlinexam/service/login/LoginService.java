package com.ouc.onlinexam.service.login;

import com.ouc.onlinexam.dao.login.ILoginDao;
import com.ouc.onlinexam.dao.login.LoginDao;
import com.ouc.onlinexam.po.Student;
import com.ouc.onlinexam.po.Teacher;

public class LoginService implements ILoginService{
	private ILoginDao id = new LoginDao();
	@Override
	public Teacher canLogin(Teacher t) {
		// TODO Auto-generated method stub
		return id.canLogin(t);
	}
	@Override
	public Student canLogin(Student s) {
		// TODO Auto-generated method stub
		return id.canLogin(s);
	}
	
}
