package com.activity.model;

import java.util.List;

public class ActivityService {
	private ActivityDAO_interface dao;

	public ActivityService() {
		dao = new ActivityJDBCDAO();
	}

	public ActivityVO addActivity(String activityCategoryname,String activityCategoryinfo, byte[] activityCategorypic) {

		ActivityVO actVO = new ActivityVO();

		actVO.setActivityCategoryname(activityCategoryname);
		actVO.setActivityCategoryinfo(activityCategoryinfo);
		actVO.setActivityCategorypic(activityCategorypic);

		dao.insert(actVO);
		return actVO;
	}

	public ActivityVO updateActivity(Integer activityCategoryid, String activityCategoryname,String activityCategoryinfo, byte[] activityCategorypic) {

		ActivityVO actVO = new ActivityVO();

		actVO.setActivityCategoryid(activityCategoryid);
		actVO.setActivityCategoryname(activityCategoryname);
		actVO.setActivityCategoryinfo(activityCategoryinfo);
		actVO.setActivityCategorypic(activityCategorypic);

		dao.update(actVO);
		return actVO;
	}

	public void deleteActivity(Integer activityCategoryid) {
		dao.delete(activityCategoryid);
	}
	
	public List<ActivityVO> getAll() {
		return dao.getAll();
	}

	public ActivityVO findByPrimaryKey(Integer activityCategoryid) {
		return dao.findByPrimaryKey(activityCategoryid);
	}
	
	

//	public ActivityVO findByPK(Integer memberId) {
//		return dao.findByPK(memberId);
//	}
}
