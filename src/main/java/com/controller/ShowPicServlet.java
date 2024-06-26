package com.controller;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ShowPicServlet.do")
public class ShowPicServlet extends HttpServlet{
	
	Connection con;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("image/gif");
		ServletOutputStream sout = res.getOutputStream();
		
		
		try {
			Statement stmt = con.createStatement();
			String activityCategoryid = req.getParameter("activityCategoryid").trim();
			
			ResultSet rs = stmt.executeQuery(
					"SELECT activity_category_pic from activity_category where activity_category_id =" + activityCategoryid);
					
			if(rs.next()) {
				BufferedInputStream bis = new BufferedInputStream(rs.getBinaryStream("activity_category_pic"));
				byte[] b = new byte[4 * 1024]; // 4K buffer
				int len;
				while ((len = bis.read(b)) != -1) {
					sout.write(b, 0, len);
				}
				bis.close();
			}else {
				//res.sendError(HttpServletResponse.SC_NOT_FOUND);
				InputStream is = getServletContext().getResourceAsStream("/NoData/none2.jpg");
				byte[] b = new byte[is.available()];
				is.read(b);
				sout.write(b);
				is.close();
			}
			
			rs.close();
			stmt.close();
			
		}catch(Exception e){
			InputStream in = getServletContext().getResourceAsStream("/NoData/null.jpg");
			byte[] b = new byte[in.available()];
			in.read(b);
//			byte[] b = in.readAllBytes();  Java 9 的新方法
			sout.write(b);
			in.close();
		}
		
		

	}
	
	
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cactus?serverTimezone=Asia/Taipei", "root", "root");
		} catch (ClassNotFoundException e) {
			throw new UnavailableException("Couldn't load JdbcOdbcDriver");
		} catch (SQLException e) {
			throw new UnavailableException("Couldn't get db connection");
		}
	}

	public void destroy() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
