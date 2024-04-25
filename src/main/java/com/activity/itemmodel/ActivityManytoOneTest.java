package com.activity.itemmodel;

import org.hibernate.Session;

import com.activity.model.ActivityVO;

import util.HibernateUtil;

public class ActivityManytoOneTest {

		public static void main(String[] args) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				
				session.beginTransaction();
				// 從員工帶出所屬的部門資料(一筆)
//				Emp emp = session.get(Emp.class, 7001);
//				System.out.println(emp.getDept().getDname());
//				
//				System.out.println("===============");
				
				// 從部門帶出關聯的員工們資料(多筆)
				ActivityVO actvo = session.get(ActivityVO.class, 6);
				for (ActivityItemVO aitvo : actvo.getAits()) {
//					System.out.println(aitvo.getActivityItemid() + " " + aitvo.getActivityItemname());
					System.out.println(aitvo);
					
				}
				
				session.getTransaction().commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				HibernateUtil.shutdown();
			}
	}

}
