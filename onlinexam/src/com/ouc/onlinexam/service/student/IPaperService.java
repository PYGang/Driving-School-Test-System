package com.ouc.onlinexam.service.student;

import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.po.Paper;

public interface IPaperService {
	/**
	 * 将p中的做的卷子的信息保存
	 * @param p
	 */
	public void save(Paper p);
	
	public List<Map<String,Object>> findPapersByInfo(int stuId,String name);
	
	public List<Map<String,Object>> paperCompareInfo(int teaId);
}
