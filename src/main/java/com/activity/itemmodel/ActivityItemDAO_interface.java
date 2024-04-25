package com.activity.itemmodel;
import java.util.List;

public interface ActivityItemDAO_interface {
	public void insert(ActivityItemVO activityitemVo);//新增
	public void update(ActivityItemVO activityitemVo);//修改
	public void delete(Integer activityItemid);//刪除
	public ActivityItemVO findByPrimaryKey(Integer activityItemid);//尋找PK
    public List<ActivityItemVO> getAll();//尋找activityItemid所有表格
    
}
