package com.ouc.onlinexam.service.admin;

import java.util.List;

import com.ouc.onlinexam.po.StuClass;

/**
 * 班级管理业务层借口
 * @author Moons
 *
 */
public interface IStuClassService {
	/**
	 * 查询所有班级信息
	 * @return 班级的List
	 */
	public List findAll(String name);
	public StuClass findStuClassById(int classId);
	/**
	 * 
	 * @param classId int 类型，班级的id号是惟一的
	 */
	public void addStuClass(StuClass sc);
	public void updateStuClass(StuClass sc);
	
	/**
	 * 根据当前的教师id查询属于这个教师的班级
	 * @param teaId
	 * @return
	 */
	public List<StuClass> findStuClassesByTeacherId(int teaId);
	/**
	 * 查询指定的多个班级id号的班级名称
	 * @param ids
	 * @return 返回的是班级名称的字符串，多个班级之间以空格隔开
	 */
	public String findClassNamesByIds(String ids);

	public void StuClassDelete(int id);
}
