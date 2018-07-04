package com.ouc.onlinexam.dao.admin;

import java.util.List;

import com.ouc.onlinexam.po.Course;
import com.ouc.onlinexam.po.StuClass;

/**
 * 班级管理中的dao接口
 * dao专门用于访问数据库
 * @author Moons
 *
 */
public interface IStuClassDao {
	/**
	 * 查询所有班级信息
	 * @return
	 */
	public List findAllStuClassInfo(String name);
	
	/**
	 * 查询某个指定的id的班级信息
	 * @param classId
	 * @return
	 */

	public StuClass findStuClassById(int classId) ;
	public void addStuClassById(StuClass sc);
	public void updateStuClassByid(StuClass sc);
	/**
	 * 根据当前的教师id查询属于这个教师的班级
	 * @param teaId
	 * @return
	 */
	public List<StuClass> findStuClassesByTeacherId(int teaId);
	public String findClassNamesByIds(String ids);
	public void StuClassDelete(int id);


}
