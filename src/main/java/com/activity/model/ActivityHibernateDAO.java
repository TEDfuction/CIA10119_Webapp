package com.activity.model;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class ActivityHibernateDAO implements ActivityDAO_interface {
	private SessionFactory factory;	
	
	public ActivityHibernateDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
		
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
		// 以避免請求執行緒共用了同個 Session
		private Session getSession() {
			return factory.getCurrentSession();
		}
		
		
	@Override
	public void insert(ActivityVO activityVo) {
		getSession().save(activityVo);
	}

	
	
	@Override
	public void update(ActivityVO activityVo) {
		getSession().update(activityVo);
	
	}
    
	@Override
	public ActivityVO findByPrimaryKey(Integer activityCategoryid) {
		//查詢ActivityVO類別中PK activityCategoryid 
		return getSession().get(ActivityVO.class, activityCategoryid);
	}

	@Override
	public List<ActivityVO> getAll() {
		//createQuery()從資料庫中查詢所有 ActivityVO list清單並返回結果
		return getSession().createQuery("from ActivityVO", ActivityVO.class).list();
	}

	@Override
	public void delete(Integer activityCategoryid) {
		// TODO Auto-generated method stub
		getSession().get(ActivityVO.class, activityCategoryid);
		
		ActivityVO actVo = getSession().get(ActivityVO.class, activityCategoryid);
		if (actVo != null)
			getSession().delete(actVo);
	}
	
//	public static void main(String[] args) {
//		MemberDAO_interface dao = new MemberHibernateDAO();
//
//		List<MemberVO> list = dao.getAll();
//		for (MemberVO memVO : list) {
//			System.out.print(memVO.getMemberId() + ",");
//			System.out.print(memVO.getEmail() + ",");
//			System.out.print(memVO.getMemberName() + ",");
//			System.out.print(memVO.getPassword() + ",");
//			System.out.print(memVO.getBirthday() + ",");
//			System.out.print(memVO.getGender() + ",");
//			System.out.print(memVO.getPhone());
//			System.out.print(memVO.getAddress());
//			System.out.print(memVO.getMemberPic());
//			System.out.println();
//		}
//
//	}
	
	
//	@Override
//	public List<MemberVO> findByName(Map<String, String> map) {
//		if (map.size() == 0) {
//			return getAll();
//		}
//		CriteriaBuilder builder = getSession().getCriteriaBuilder();
//		CriteriaQuery<MemberVO> criteria = builder.createQuery(MemberVO.class);
//		Root<MemberVO> root = criteria.from(MemberVO.class);
//
//		List<Predicate> predicates = new ArrayList<>();
//		
//		for (Map.Entry<String, String> row : map.entrySet()) {
//			if ("memberName".equals(row.getKey())) {
//				predicates.add(builder.like(root.get("memberName"), "%" + row.getValue() + "%"));
//			}
//		}
//		
//		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
//		criteria.orderBy(builder.asc(root.get("memberId")));
//		TypedQuery<MemberVO> query = getSession().createQuery(criteria);
//
//		return query.getResultList();
//	}
}
