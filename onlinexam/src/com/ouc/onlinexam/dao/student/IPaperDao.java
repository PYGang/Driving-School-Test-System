package com.ouc.onlinexam.dao.student;

import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Paper;

public interface IPaperDao {
	public void savePaper(Paper p);
	public List<Map<String,Object>> findPapersByInfo(int stuId,String name);
	
	public List<Map<String,Object>> paperCompareInfo(int teaId);
}
