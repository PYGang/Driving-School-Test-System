package com.ouc.onlinexam.service.student;

import java.util.List;
import java.util.Map;

import com.ouc.onlinexam.dao.student.IPaperDao;
import com.ouc.onlinexam.dao.student.PaperDao;
import com.ouc.onlinexam.po.Paper;

public class PaperService implements IPaperService{

	private IPaperDao pd = new PaperDao();
	@Override
	public void save(Paper p) {
		// TODO Auto-generated method stub
		pd.savePaper(p);
	}
	@Override
	public List<Map<String, Object>> findPapersByInfo(int stuId,String name) {
		// TODO Auto-generated method stub
		return pd.findPapersByInfo(stuId,name);
	}
	@Override
	public List<Map<String, Object>> paperCompareInfo(int teaId) {
		// TODO Auto-generated method stub
		return pd.paperCompareInfo(teaId);
	}

}
