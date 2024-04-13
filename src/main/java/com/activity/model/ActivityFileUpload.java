package com.activity.model;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/ActivityFileUpload.do")
@MultipartConfig(fileSizeThreshold = 1980 * 1980, maxFileSize = 5 * 1980 * 1980, maxRequestSize = 5 * 5 * 1980 * 1980)

public class ActivityFileUpload extends HttpServlet{
	
	String saveDirectory = "/images_uploaded";
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("Big5");
		res.setContentType("text/html; charset=Big5");
		
		
		PrintWriter out = res.getWriter();
		
		System.out.println("ContentType="+req.getContentType());
		
		
		//上傳資料夾之路徑
		String realPath = getServletContext().getRealPath(saveDirectory);
		
		System.out.println("realPath="+realPath);
		
		File fsaveDirectory = new File(realPath);
		if (!fsaveDirectory.exists())
			 fsaveDirectory.mkdirs(); // 自動建立上傳資料夾
		
		
		
		//使用Part物件
		Collection<Part> parts = req.getParts();
		out.write("<h2> Total parts : " + parts.size() + "</h2>");

		
		for(Part part : parts) {
			String filename = part.getSubmittedFileName();
			if (filename!= null && filename.length()!=0 && part.getContentType()!=null) {
				out.println("<PRE>");
				
				out.println("name: " + part.getName());
				out.println("上傳檔案名稱:" + filename);
				out.println("檔案類型" + part.getContentType());
				out.println("檔案大小" + part.getSize());
				
				File f = new File(fsaveDirectory, filename);
				out.println("File: " + f);

				// 寫入資料夾,上傳成功
				part.write(f.toString());
				
				// 上傳圖顯示
				out.println("<br><img src=\""+req.getContextPath()+saveDirectory+"/"+filename+"\">");

				out.println();
				out.println("</PRE>");
			}

					
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
}