package com.ouc.onlinexam.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ouc.onlinexam.po.Test;

public class TestDBUtil {
	public static void main(String[] args) throws Exception {
		DBUtil db = new DBUtil();
		String sql ="select * from course";
		List<Map<String,Object>> courseList =db.getQueryList(sql);
		System.out.println(courseList.size());
		for(int i=0;i<courseList.size();i++){
			Map<String,Object> map = courseList.get(i);
			Iterator it =map.entrySet().iterator();
			while(it.hasNext()){
				Entry courseEntry =(Entry)it.next();
				System.out.println("key是"+courseEntry.getKey()+"  value值为"+courseEntry.getValue());
			}
		}
		DBUtil db1 = new DBUtil();
		String sql1 ="select s.*,c.name as classname from student s,stuclass c where s.name like '%张%' and c.id = s.classId";
		List<Map<String,Object>> stulist = db1.getQueryList(sql1);
		System.out.println(stulist.size());
		//一个循环，stulist.size()表示循环的大小
		for(int i=0;i<stulist.size();i++){
			Map<String,Object> m = stulist.get(i);
			Iterator it = m.entrySet().iterator();
			while(it.hasNext()){
				Entry stuEntry =(Entry)it.next();
				System.out.println("key值为"+stuEntry.getKey()+"  value值为"+stuEntry.getValue());
			}
		}
		List<Map<String,Object>> courseList2 = db.getQueryList("select * from student where deptName =? and sex =?", new Object[]{"开发","男"});
		System.out.println(courseList2.size());
		for(int i=0;i<stulist.size();i++){
			Map<String,Object> m = courseList2.get(i);
			/**
			 * Map里面迭代的是entry，entry就是键值对
			 * key-value
			 * key在这里就是字段名，所以是String类型
			 * value数据类型不确定，因此使用所有类型的父--Object
			 */
			Iterator it = m.entrySet().iterator();
			/**
			 * it1开始指向的位置是第一条记录前，因为第一条记录不一定存在
			 * 因此it.hasNext()能够判断是否有下一条记录
			 * 如果有，it.next()能指向下一条记录
			 */
			while(it.hasNext()){
				Entry stuEntry =(Entry)it.next();
				System.out.println("key值为"+stuEntry.getKey()+"  value值为"+stuEntry.getValue());
			}
		}
		
		List<Map<String,Object>> testList = db.getQueryList("SELECT t.* from test t,course c,teacher tc where t.courseId =c.id and tc.id = t.teacherId and c.name =? and tc.name=? ",new Object[]{"java","甜甜"});
		System.out.println(testList.size());
		for(int i=0;i<testList.size();i++){
			Map<String,Object> m = testList.get(i);
			Iterator it = m.entrySet().iterator();
			while(it.hasNext()){
				Entry testEntry = (Entry) it.next();
				System.out.println("key值为"+testEntry.getKey()+"  value值为"+testEntry.getValue());
			}
		}
		
		String sql3 = "select * from test where courseId= ? and teacherId = ?";
		/**
		 * 这个方法，第一个参数表示我查询的结果要封装成的类Test.class
		 * 这个类要和数据库中的表要对应。这个类中的字段要和数据库表的字段对应
		 * 查询的时候是单表查询
		 * 类中的数据烈性和数据库字段的数据类型要一致
		 * 查询的结果自动封装成所指定的类
		 */
		List testList2 = db.getQueryList(Test.class, sql3, new Object[]{1,1});
		for (int i = 0 ; i < testList2.size();i++){
			Test t = (Test) testList2.get(i);

			System.out.println(t.getClassIds());
			System.out.println(t.getCourseId());
			System.out.println(t.getName());
			System.out.println(t.getQuestions());
			System.out.println(t.getScores());
			System.out.println(t.getTeacherId());
			System.out.println(t.getTestTime());

		}

	}
}
