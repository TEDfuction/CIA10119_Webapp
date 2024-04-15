package com.activity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//public class ActivityVO implements java.io.Serializable{
//	private Integer activity_category_id;
//	private String  activity_category_name;
//	private String  activity_category_info;
//	
//	public Integer getActivity_category_id() {
//		return activity_category_id;
//	}
//	public void setActivity_category_id(Integer activity_category_id) {
//		this.activity_category_id = activity_category_id;
//	}
//	public String getActivity_category_name() {
//		return activity_category_name;
//	}
//	public void setActivity_category_name(String activity_category_name) {
//		this.activity_category_name = activity_category_name;
//	}
//	public String getActivity_category_info() {
//		return activity_category_info;
//	}
//	public void setActivity_category_info(String activity_category_info) {
//		this.activity_category_info = activity_category_info;
//	}
//	
	

@Entity
@Table(name = "activity_category")
public class ActivityVO implements java.io.Serializable{
	@Id
	@Column(name = "activity_category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activityCategoryid;
	
	@Column(name = "activity_category_name")
	private String activityCategoryname;
	
	@Column(name = "activity_category_info")
	private String activityCategoryinfo;
	
	@Column(name = "activity_category_pic",columnDefinition = "longblob")
	private byte[] activityCategorypic;
	
	
	


	public ActivityVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getActivityCategoryid() {
		return activityCategoryid;
	}

	public void setActivityCategoryid(Integer activityCategoryid) {
		this.activityCategoryid = activityCategoryid;
	}

	public String getActivityCategoryname() {
		return activityCategoryname;
	}

	public void setActivityCategoryname(String activityCategoryname) {
		this.activityCategoryname = activityCategoryname;
	}

	public String getActivityCategoryinfo() {
		return activityCategoryinfo;
	}

	public void setActivityCategoryinfo(String activityCategoryinfo) {
		this.activityCategoryinfo = activityCategoryinfo;
	}
	
	public byte[] getActivityCategorypic() {
		return activityCategorypic;
	}


	public void setActivityCategorypic(byte[] activityCategorypic) {
		this.activityCategorypic = activityCategorypic;
	}

	
	
	
	

}