package com.activity.itemmodel;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class ActivityItemHibernateDAO implements ActivityItemDAO_interface {
private SessionFactory factory;	
	
	public ActivityItemHibernateDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
		
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
		// 以避免請求執行緒共用了同個 Session
		private Session getSession() {
			return factory.getCurrentSession();
		}
		
		
	@Override
	public void insert(ActivityItemVO activityItemVo) {
		getSession().save(activityItemVo);
	}

	
	
	@Override
	public void update(ActivityItemVO activityItemVo) {
		getSession().update(activityItemVo);
	
	}
    
	@Override
	public ActivityItemVO findByPrimaryKey(Integer activityItemid) {
		//查詢ActivityVO類別中PK activityCategoryid 
		return getSession().get(ActivityItemVO.class, activityItemid);
	}

	@Override
	public List<ActivityItemVO> getAll() {
		//createQuery()從資料庫中查詢所有 ActivityVO list清單並返回結果
		return getSession().createQuery("from ActivityItemVO", ActivityItemVO.class).list();
	}

	@Override
	public void delete(Integer activityItemid) {
		getSession().get(ActivityItemVO.class, activityItemid);
		
		ActivityItemVO aitVo = getSession().get(ActivityItemVO.class, activityItemid);
		if (aitVo != null)
			getSession().delete(aitVo);
	}
	
	

	

}
