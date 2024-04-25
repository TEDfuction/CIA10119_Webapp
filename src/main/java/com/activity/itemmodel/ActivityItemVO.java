package com.activity.itemmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.activity.model.ActivityVO;

	@Entity
	@Table(name = "activity_item")
	public class ActivityItemVO implements java.io.Serializable{
	
		@Id
		@Column(name = "activity_item_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer activityItemid;
		 
		//fk多對一 referencedColumnName join activity的activity_category_id欄位
		@ManyToOne
		@JoinColumn(name = "activity_category_id", referencedColumnName ="activity_category_id")
		private ActivityVO activityCategory;
		
		@Column(name = "activity_item_name")
		private String activityItemname;
		
		@Column(name = "activity_item_description")
		private String activityItemdescription;
		
		@Column(name = "activity_item_info")
		private String activityIteminfo;
		
		@Column(name = "activity_item_price")
		private Integer activityItemprice;
		
		@Column(name = "activity_item_state")
		private Boolean activityItemstate;
		
		
		

		public Integer getActivityItemid() {
			return activityItemid;
		}

		public void setActivityItemid(Integer activityItemid) {
			this.activityItemid = activityItemid;
		}

		public ActivityVO getActivityCategory() {
			return activityCategory;
		}
		

		public void setActivityCategory(ActivityVO activityCategory) {
			this.activityCategory = activityCategory;
		}

		public String getActivityItemname() {
			return activityItemname;
		}

		public void setActivityItemname(String activityItemname) {
			this.activityItemname = activityItemname;
		}

		public String getActivityItemdescription() {
			return activityItemdescription;
		}

		public void setActivityItemdescription(String activityItemdescription) {
			this.activityItemdescription = activityItemdescription;
		}

		public String getActivityIteminfo() {
			return activityIteminfo;
		}

		public void setActivityIteminfo(String activityIteminfo) {
			this.activityIteminfo = activityIteminfo;
		}

		public Integer getActivityItemprice() {
			return activityItemprice;
		}

		public void setActivityItemprice(Integer activityItemprice) {
			this.activityItemprice = activityItemprice;
		}

		public Boolean getActivityItemstate() {
			return activityItemstate;
		}

		public void setActivityItemstate(Boolean activityItemstate) {
			this.activityItemstate = activityItemstate;
		}
		
		@Override
		public String toString() {
			return "ActivityItemVO [activityItemid=" + activityItemid + ", activityItemname=" + activityItemname + ", activityItemdescription=" + activityItemdescription + ", activityIteminfo=" + activityIteminfo +", activityItemprice=" + activityItemprice + ", activityItemstate=" + activityItemstate+"]";
		}
	
		
		
		
		
		
	
	}
