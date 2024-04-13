package com.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import static java.lang.System.out;

import com.activity.model.*;


@WebServlet("/activity.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class ActivityServlet extends HttpServlet{

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		//從前端抓取action去做後方對應操作判定
		String action = req.getParameter("action");
		
		
//查詢1//		
		if("findByPrimaryKey".equals(action)) {
			
			//儲存錯誤訊息，並顯示於畫面提醒使用者
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			
			
			/***************************接收請求並做錯誤判斷**********************/
			String str = req.getParameter("activityCategoryid");
			if(str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入活動編號");
			}
			
			//若有錯誤訊息，則帶使用者回到頁面
			if(!errorMsgs.isEmpty()) {
				String failUrl = "selectPage.jsp" ;
				RequestDispatcher fail = req.getRequestDispatcher(failUrl);
				fail.forward(req, res);
				return; //中斷程式
			}
			
			
			Integer activityCategoryid = null;
			try {
				activityCategoryid = Integer.valueOf(str);
			}catch(Exception e) {
				errorMsgs.add("活動編號格式不正確");
			}
			//若有錯誤訊息，則帶使用者回到頁面
			if(!errorMsgs.isEmpty()) {
				String failUrl = "selectPage.jsp" ;
				RequestDispatcher fail = req.getRequestDispatcher(failUrl);
				fail.forward(req, res);
				return; //中斷程式
			}
			
			
			
			
			/***************************輸入正確，做資料查詢**********************/
			ActivityService actSvc = new ActivityService();
			ActivityVO actVO = actSvc.findByPrimaryKey(activityCategoryid);
			
			if(actVO == null) {
				errorMsgs.add("查無此人");
			}
			//若有錯誤訊息，則帶使用者回到頁面
			if(!errorMsgs.isEmpty()) {
				String failUrl = "selectPage.jsp" ;
				RequestDispatcher fail = req.getRequestDispatcher(failUrl);
				fail.forward(req, res);
				return; //中斷程式
			}
			
			
			
			
			/***************************查詢完成，轉交前台**********************/
			req.setAttribute("actVO",actVO);
			String successUrl = "listOneActivity.jsp" ;
			RequestDispatcher success = req.getRequestDispatcher(successUrl);
			success.forward(req, res);
		}
		
		
		
		
		//新增
				if("insert".equals(action)) {
					
					//儲存錯誤訊息，並顯示於畫面提醒使用者
					List<String> errorMsgs = new LinkedList<String>();
					req.setAttribute("errorMsgs", errorMsgs);
				
					
					
					/***************************接收請求並做錯誤判斷**********************/

					String activityCategoryname = req.getParameter("activityCategoryname");
					if(activityCategoryname == null || activityCategoryname.trim().length() == 0) {
						errorMsgs.add("活動類別名稱:不得為空!");
					} 
					
					
					
					String activityCategoryinfo = req.getParameter("activityCategoryinfo");
					if(activityCategoryinfo == null || activityCategoryinfo.trim().length() == 0) {
						errorMsgs.add("活動類別資訊:不得為空!");
					}
					
					
					
					//圖片新增
					PrintWriter out = res.getWriter();
					byte[] activityCategorypic = null;

					
					Part part = req.getPart("activityCategorypic");

					if(part != null) {
						
						//上傳資料夾
						String saveDirectory = "/images_uploaded";
						String realPath = getServletContext().getRealPath(saveDirectory);
						File fileSaveDirectory = new File(realPath);
						if (!fileSaveDirectory.exists()) {
							 fileSaveDirectory.mkdirs(); // 自動建立上傳資料夾
						}
						
						
						
						String filename = part.getSubmittedFileName();
						
						
						if (filename!= null && filename.length()!=0 && part.getContentType()!=null) {

							InputStream is = null;

//							out.println("<PRE>");
//							
//							out.println("name: " + part.getName());
//							out.println("filename:" + filename);
//							out.println("ContentType" + part.getContentType());
//							out.println("Size" + part.getSize());
							
							File f = new File(fileSaveDirectory, filename);
//							out.println("File: " + f);

							// 寫入資料夾,上傳成功
							part.write(f.toString());
							
							//InputStream寫入
							is = part.getInputStream();
							
							activityCategorypic = new byte[is.available()];
							is.read(activityCategorypic);
											
							
							// 上傳圖顯示
							out.println();
							out.print("<h4>此為上傳圖片預覽</h4>");
							out.println("<br><img src=\""+req.getContextPath()+saveDirectory+"/"+filename+"\">");
							
//							out.println("</PRE>");
							
							is.close();
						}
					}
					
					
								
					
					ActivityVO actVO = new ActivityVO();
					actVO.setActivityCategoryname(activityCategoryname);
					actVO.setActivityCategoryinfo(activityCategoryinfo);
					actVO.setActivityCategorypic(activityCategorypic);
					
					
					
					//若有錯誤訊息，則帶使用者回到頁面
					if(!errorMsgs.isEmpty()) {
						req.setAttribute("actVO", actVO); // 先前輸入的memVO物件也存入req
						String failUrl = "addActivity.jsp" ;
						RequestDispatcher fail = req.getRequestDispatcher(failUrl);
						fail.forward(req, res);
						return; //中斷程式
					}
					
					
					/***************************輸入正確，做資料新增**********************/
					ActivityService actSvc = new ActivityService();
					actVO = actSvc.addActivity(activityCategoryname,activityCategoryinfo,activityCategorypic);
					
					
					
					
					/***************************新增完成，轉交前台**********************/
					req.setAttribute("actVO",actVO);
					String sucessUrl = "listAllActivity.jsp" ;
					RequestDispatcher sucess = req.getRequestDispatcher(sucessUrl);
					sucess.forward(req, res);
					out.println("<h3>資料新增成功!!</h3>");
				}




		
		
//修改
			if("getOne_For_Update".equals(action)) {
				
				//儲存錯誤訊息，並顯示於畫面提醒使用者
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);

				
				
				/***************************接收請求並做錯誤判斷**********************/
				
				Integer activityCategoryid = Integer.valueOf(req.getParameter("activityCategoryid"));
				
				
				
				
				/***************************輸入正確，做資料查詢**********************/

				ActivityService actSvc = new ActivityService();
				ActivityVO actVO = actSvc.findByPrimaryKey(activityCategoryid);
									
				
				
				
				/***************************查詢完成，轉交修改jsp**********************/

				req.setAttribute("actVO",actVO);
				String successUrl = "updateActivity.jsp" ;
				RequestDispatcher success = req.getRequestDispatcher(successUrl);
				success.forward(req, res);
				
				
				}
			
			
			
			
			if("update".equals(action)) {
				
				//儲存錯誤訊息，並顯示於畫面提醒使用者
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);

				
				
				/***************************接收請求並做錯誤判斷**********************/
				
				Integer activityCategoryid = Integer.valueOf(req.getParameter("activityCategoryid").trim());

				
				String activityCategoryname = req.getParameter("activityCategoryname");
				if(activityCategoryname == null ||activityCategoryname.trim().length() == 0) {
					errorMsgs.add("activityCategoryname Empty!");
				}
				
				
				
				String activityCategoryinfo = req.getParameter("activityCategoryinfo");
				if(activityCategoryinfo == null || activityCategoryinfo.trim().length() == 0) {
					errorMsgs.add("activityCategoryinfo Empty!");
				}
				
				
				
				//圖片新增
				PrintWriter out = res.getWriter();
				byte[] activityCategorypic = null;

				
				Part part = req.getPart("activityCategorypic");

				if(part != null) {
					
					//上傳資料夾
					String saveDirectory = "/images_uploaded";
					String realPath = getServletContext().getRealPath(saveDirectory);
					File fileSaveDirectory = new File(realPath);
					if (!fileSaveDirectory.exists()) {
						 fileSaveDirectory.mkdirs(); // 自動建立上傳資料夾
					}
					
					
					
					String filename = part.getSubmittedFileName();
					
					
					if (filename!= null && filename.length()!=0 && part.getContentType()!=null) {

						InputStream is = null;

//						out.println("<PRE>");
//						
//						out.println("name: " + part.getName());
//						out.println("filename:" + filename);
//						out.println("ContentType" + part.getContentType());
//						out.println("Size" + part.getSize());
						
						File f = new File(fileSaveDirectory, filename);
//						out.println("File: " + f);

						// 寫入資料夾,上傳成功
						part.write(f.toString());
						
						//InputStream寫入
						is = part.getInputStream();
						
						activityCategorypic = new byte[is.available()];
						is.read(activityCategorypic);
										
						
						// 上傳圖顯示
						out.println();
						out.print("<h4>此為上傳圖片預覽</h4>");
						out.println("<br><img src=\""+req.getContextPath()+saveDirectory+"/"+filename+"\">");
						
//						out.println("</PRE>");
						
						is.close();
					}
				}
						
				ActivityVO actVO = new ActivityVO();
				actVO.setActivityCategoryid(activityCategoryid);
				actVO.setActivityCategoryname(activityCategoryname);
				actVO.setActivityCategoryinfo(activityCategoryinfo);
				actVO.setActivityCategorypic(activityCategorypic);
				
				//若有錯誤訊息，則帶使用者回到頁面
				if(!errorMsgs.isEmpty()) {
					req.setAttribute("actVO", actVO); // 先前輸入的memVO物件也存入req
					String failUrl = "addActivity.jsp" ;
					RequestDispatcher fail = req.getRequestDispatcher(failUrl);
					fail.forward(req, res);
					return; //中斷程式
				}
				
				/***************************輸入正確，做資料修改**********************/
				ActivityService actSvc = new ActivityService();
				actVO = actSvc.updateActivity(activityCategoryid,activityCategoryname,activityCategoryinfo,activityCategorypic);
				
				
				
				
				/***************************修改完成，轉交前台**********************/
				
				req.setAttribute("actVO",actVO);
				String sucessUrl = "listAllActivity.jsp" ;
				RequestDispatcher sucess = req.getRequestDispatcher(sucessUrl);
				sucess.forward(req, res);
				out.println("<h3>資料修改成功!!</h3>");
				}
//刪除           
			
			if ("delete".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
		
					/***************************1.接收請求參數***************************************/
					Integer activityCategoryid = Integer.valueOf(req.getParameter("activityCategoryid"));
					
					/***************************2.開始刪除資料***************************************/
					ActivityService actSvc = new ActivityService();
					actSvc.deleteActivity(activityCategoryid);
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "listAllActivity.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
			}
		
	}
}
	
