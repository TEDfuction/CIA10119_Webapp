package com.activity.model;

import java.util.*;

public interface ActivityDAO_interface {
	public void insert(ActivityVO activityVo);//新增
	public void update(ActivityVO activityVo);//修改
	public void delete(Integer activityCategoryid);//刪除
	public ActivityVO findByPrimaryKey(Integer activityCategoryid);//尋找PK
	public List<ActivityVO> getAll();//尋找activityCategoryid所有表格
	
	//public Set<ActivityVO> getActivityByActivity(Integer actid);
	

	
	
    
}
