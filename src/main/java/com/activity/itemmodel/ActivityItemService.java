package com.activity.itemmodel;

import java.util.List;

import com.activity.model.ActivityVO;

public class ActivityItemService {
    private ActivityItemDAO_interface dao;
    
    public ActivityItemService() {
		//dao = new ActivityJDBCDAO();
		dao = new ActivityItemHibernateDAO();
    }
		public ActivityItemVO addActivityItem(String activityItemname, String activityItemdescription,String activityIteminfo ,Integer activityItemprice, Boolean activityItemstate, Integer activityCategoryid) {

			ActivityItemVO aitVO = new ActivityItemVO();

			
			aitVO.setActivityItemname(activityItemname);
			aitVO.setActivityItemdescription(activityItemdescription);
			aitVO.setActivityIteminfo(activityIteminfo);
			aitVO.setActivityItemprice(activityItemprice);
			aitVO.setActivityItemstate(activityItemstate);
			ActivityVO actVO = new ActivityVO ();
			actVO.setActivityCategoryid(activityCategoryid);
			aitVO.setActivityCategory(actVO);
//			aitVO.setActivityCategory(activityCategoryid);
			
			
			dao.insert(aitVO);
			return aitVO;
		}
		public ActivityItemVO updateActivityItem(Integer activityItemid,String activityItemname, String activityItemdescription,String activityIteminfo ,Integer activityItemprice, Boolean activityItemstate, Integer activityCategoryid) {

			ActivityItemVO aitVO = new ActivityItemVO();

			aitVO.setActivityItemid(activityItemid);
			aitVO.setActivityItemname(activityItemname);
			aitVO.setActivityItemdescription(activityItemdescription);
			aitVO.setActivityIteminfo(activityIteminfo);
			aitVO.setActivityItemprice(activityItemprice);
			aitVO.setActivityItemstate(activityItemstate);
			ActivityVO actVO = new ActivityVO ();
			actVO.setActivityCategoryid(activityCategoryid);
			aitVO.setActivityCategory(actVO);
//			aitVO.setActivityCategory(activityCategory);
			
			dao.update(aitVO);
			return aitVO;
		}
		public void deleteActivityItem(Integer activityItemid) {
			dao.delete(activityItemid);
		}
		public List<ActivityItemVO> getAll(){
			return dao.getAll();
		}
		public ActivityItemVO findByPrimaryKey(Integer activityItemid) {
			return dao.findByPrimaryKey(activityItemid);
		}
		
	}


