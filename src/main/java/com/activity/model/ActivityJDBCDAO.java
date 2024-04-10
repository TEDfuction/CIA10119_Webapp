package com.activity.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ActivityJDBCDAO implements ActivityDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cactus?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "root";

	private static final String INSERT_STMT = "INSERT INTO activity_category(activity_category_name,activity_category_info) VALUES(?, ?)";
	private static final String GET_ALL_STMT = "SELECT activity_category_id , activity_category_name, activity_category_info FROM  activity_category";
	private static final String GET_ONE_STMT = "SELECT activity_category_id , activity_category_name, activity_category_info FROM  activity_category where activity_category_id = ?";

	private static final String DELETE_ACTIVITY_CATEGORY = "DELETE FROM activity_category where activity_category_id = ?";

	private static final String UPDATE = "UPDATE activity_category set activity_category_name=? ,activity_category_info= ? where activity_category_id = ?";

	// =================1.insert=================//
	@Override
	public void insert(ActivityVO activityVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, activityVo.getActivityCategoryname());
			pstmt.setString(2, activityVo.getActivityCategoryinfo());

			pstmt.executeUpdate("set auto_increment_offset=1;");
			pstmt.executeUpdate("set auto_increment_increment=1;");
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	// =================2.update=================//
	@Override
	public void update(ActivityVO activityVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, activityVo.getActivityCategoryname());
			pstmt.setString(2, activityVo.getActivityCategoryinfo());
			pstmt.setInt(3, activityVo.getActivityCategoryid());

			pstmt.executeUpdate("set auto_increment_offset=1;");
			pstmt.executeUpdate("set auto_increment_increment=1;");
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	// =================3.delete=================//
	@Override
	public void delete(Integer activity_category_id) {
		int updateCount_actcate = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			// 1●設定於 pstm.executeUpdate()之前
			con.setAutoCommit(false);

			// 先刪除活動類別編號
			pstmt = con.prepareStatement(DELETE_ACTIVITY_CATEGORY);
			pstmt.setInt(1, activity_category_id);
			// 刪除的動作
			updateCount_actcate = pstmt.executeUpdate();
			// 再刪除部門
//			pstmt = con.prepareStatement(DELETE_ACTIVITY_CATEGORY);
//			pstmt.setInt(1, activity_category_id);
//			pstmt.executeUpdate();

			// 2●設定於 pstm.executeUpdate()之後
			con.commit();
			con.setAutoCommit(true);
			System.out.println("刪除活動類別編號" + activity_category_id );
//			System.out.println("刪除部門編號" + activity_category_id + "時,共有員工" + updateCount_actcate
//					+ "人同時被刪除");
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	// =================4.查詢PK=================//
	@Override
	public ActivityVO findByPrimaryKey(Integer activity_category_id) {

		ActivityVO activityVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, activity_category_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// deptVO 也稱為 Domain objects
				activityVo = new ActivityVO ();
				activityVo.setActivityCategoryid(rs.getInt("activity_category_id"));
				activityVo.setActivityCategoryname(rs.getString("activity_category_name"));
				activityVo.setActivityCategoryinfo(rs.getString("activity_category_info"));
				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return activityVo;
	}
	// =================5.查詢全部=================//
	@Override
	public List<ActivityVO> getAll() {
		List<ActivityVO> list = new ArrayList<ActivityVO>();
		ActivityVO activityVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
			    activityVO = new ActivityVO();
			    activityVO.setActivityCategoryid(rs.getInt("activity_category_id"));
			    activityVO.setActivityCategoryname(rs.getString("activity_category_name"));
			    activityVO.setActivityCategoryinfo(rs.getString("activity_category_info"));
				list.add(activityVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	// =================Test=================//
	public static void main(String[] args) {
		ActivityJDBCDAO dao = new ActivityJDBCDAO ();
		//新增
//		ActivityVO actVO1 = new ActivityVO();
//		actVO1.setActivity_category_name("衝浪");
//	    actVO1.setActivity_category_info("今天天氣真好");
//	    dao.insert(actVO1);
//	    System.out.println("insert新增成功");
		
		//修改
//		ActivityVO actVO2 = new ActivityVO ();
//		actVO2.setActivity_category_name("不衝浪");
//		actVO2.setActivity_category_info("今天天氣不好");
//		actVO2.setActivity_category_id(1);
//	    dao.update(actVO2);
//	    System.out.println("update新增成功");
		
		//刪除
//		dao.delete(3);
//		//System.out.println("delete 刪除成功");
		
		//查詢PK
//		ActivityVO actVO3 = dao.findByPrimaryKey(4);
//		System.out.print(actVO3.getActivity_category_id()+",");
//		System.out.print(actVO3.getActivity_category_name()+",");
//		System.out.println(actVO3.getActivity_category_info());
//		System.out.println("-------------------------");
		
		// 查詢活動類別
		List<ActivityVO> list = dao.getAll();
		for(ActivityVO aActcat:list) {
			System.out.print(aActcat.getActivityCategoryid()+",");
			System.out.print(aActcat.getActivityCategoryname()+",");
			System.out.print(aActcat.getActivityCategoryinfo());
			System.out.println();
			
		} 
		
		
	}

}
