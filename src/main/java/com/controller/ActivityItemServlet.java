package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.activity.itemmodel.ActivityItemService;
import com.activity.itemmodel.ActivityItemVO;
import com.activity.model.ActivityVO;


@WebServlet("/activityItem.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class ActivityItemServlet extends HttpServlet{

	
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
			String str = req.getParameter("activityItemid");
			if(str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入活動項目編號");
			}
			
			//若有錯誤訊息，則帶使用者回到頁面
			if(!errorMsgs.isEmpty()) {
				String failUrl = "selectPage.jsp" ;
				RequestDispatcher fail = req.getRequestDispatcher(failUrl);
				fail.forward(req, res);
				return; //中斷程式
			}
			
			
			Integer activityItemid = null;
			try {
				activityItemid = Integer.valueOf(str);
			}catch(Exception e) {
				errorMsgs.add("活動項目號碼格式不正確");
			}
			//若有錯誤訊息，則帶使用者回到頁面
			if(!errorMsgs.isEmpty()) {
				String failUrl = "selectPage.jsp" ;
				RequestDispatcher fail = req.getRequestDispatcher(failUrl);
				fail.forward(req, res);
				return; //中斷程式
			}
			
			
			
			
			/***************************輸入正確，做資料查詢**********************/
			ActivityItemService aitSvc = new ActivityItemService();
			ActivityItemVO aitVO = aitSvc.findByPrimaryKey(activityItemid);
			
			if(aitVO == null) {
				errorMsgs.add("查無編號");
			}
			//若有錯誤訊息，則帶使用者回到頁面
			if(!errorMsgs.isEmpty()) {
				String failUrl = "selectPage.jsp" ;
				RequestDispatcher fail = req.getRequestDispatcher(failUrl);
				fail.forward(req, res);
				return; //中斷程式
			}
			
			
			
			
			/***************************查詢完成，轉交前台**********************/
			req.setAttribute("aitVO",aitVO);
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

					String activityItemname = req.getParameter("activityItemname");
					if(activityItemname == null || activityItemname.trim().length() == 0) {
						errorMsgs.add("活動項目名稱:不得為空!");
					} 
					
				
					
					String activityItemdescription = req.getParameter("activityItemdescription");
					if(activityItemdescription == null || activityItemdescription.trim().length() == 0) {
						errorMsgs.add("活動項目簡述:不得為空!");
					}
					
					String activityIteminfo = req.getParameter("activityIteminfo");
					if(activityIteminfo == null || activityIteminfo.trim().length() == 0) {
						errorMsgs.add("活動項目資訊:不得為空!");
					}
					
	
					String input_activityItemprice = req.getParameter("activityItemprice");
					if(input_activityItemprice == null || input_activityItemprice.trim().length() == 0) {
						errorMsgs.add("活動項目價格:不得為空!");
					}
					Integer activityItemprice = null;
					try {
						activityItemprice = Integer.parseInt(input_activityItemprice);
					}catch(Exception e) {
						errorMsgs.add("活動項目價格:格式不正確!");
					}
					
					
					Boolean activityItemstate = Boolean.parseBoolean(req.getParameter("activityItemstate"));
					
//					Integer activtiyCategoryid = Integer.parseInt(req.getParameter("activityCategoryid").trim());
					String input_activtiyCategoryid = req.getParameter("activityCategoryid");
					if(input_activtiyCategoryid == null || input_activtiyCategoryid.trim().length() == 0) {
						errorMsgs.add("活動類別編號:不得為空!");
					}
					Integer activtiyCategoryid = null;
					try {
						activtiyCategoryid = Integer.parseInt(input_activtiyCategoryid);
					}catch(Exception e) {
						errorMsgs.add("活動類別編號:格式不正確!");
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
					
					
								
					
					ActivityItemVO aitVO = new ActivityItemVO();
//					ActivityVO  actVO = new ActivityVO(); 
					aitVO.setActivityItemname(activityItemname);
					aitVO.setActivityItemdescription(activityItemdescription);
					aitVO.setActivityIteminfo(activityIteminfo);
					aitVO.setActivityItemprice(activityItemprice);
					aitVO.setActivityItemstate(activityItemstate);
//					aitVO.setActivityCategoryid(activtiyCategoryid);
//					actVO.setActivityCategorypic(activityCategorypic);
					
					
					
					//若有錯誤訊息，則帶使用者回到頁面
					if(!errorMsgs.isEmpty()) {
						req.setAttribute("activtiyCategoryid", activtiyCategoryid); // 先前輸入的memVO物件也存入req
						req.setAttribute("aitVO", aitVO); // 先前輸入的memVO物件也存入req
						String failUrl = "addActivity.jsp" ;
						RequestDispatcher fail = req.getRequestDispatcher(failUrl);
						fail.forward(req, res);
						return; //中斷程式
					}
					
					
					/***************************輸入正確，做資料新增**********************/
					ActivityItemService aitSvc = new ActivityItemService();
					aitVO = aitSvc.addActivityItem(activityItemname,activityItemdescription,activityIteminfo,activityItemprice,activityItemstate,activtiyCategoryid);
					
					
					
					
					/***************************新增完成，轉交前台**********************/
					req.setAttribute("aitVO",aitVO);
					String sucessUrl = "selectPage.jsp" ;
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
				
				Integer activityItemid = Integer.valueOf(req.getParameter("activityItemid"));
				
				
				
				
				/***************************輸入正確，做資料查詢**********************/

				ActivityItemService aitSvc = new ActivityItemService();
				ActivityItemVO aitVO = aitSvc.findByPrimaryKey(activityItemid);
									
				
				
				
				/***************************查詢完成，轉交修改jsp**********************/

				req.setAttribute("aitVO",aitVO);
				String successUrl = "updateActivity.jsp" ;
				RequestDispatcher success = req.getRequestDispatcher(successUrl);
				success.forward(req, res);
				
				
				}
			
			
			
			
			if("update".equals(action)) {
				
				//儲存錯誤訊息，並顯示於畫面提醒使用者
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);

				
				
				/***************************接收請求並做錯誤判斷**********************/
				
				Integer activityItemid = Integer.valueOf(req.getParameter("activityItemid").trim());

				String activityItemname = req.getParameter("activityItemname");
				if(activityItemname == null || activityItemname.trim().length() == 0) {
					errorMsgs.add("活動項目名稱:不得為空!");
				} 
				
			
				
				String activityItemdescription = req.getParameter("activityItemdescription");
				if(activityItemdescription == null || activityItemdescription.trim().length() == 0) {
					errorMsgs.add("活動項目簡述:不得為空!");
				}
				
				String activityIteminfo = req.getParameter("activityIteminfo");
				if(activityIteminfo == null || activityIteminfo.trim().length() == 0) {
					errorMsgs.add("活動項目資訊:不得為空!");
				}
				

				String input_activityItemprice = req.getParameter("activityItemprice");
				if(input_activityItemprice == null || input_activityItemprice.trim().length() == 0) {
					errorMsgs.add("活動項目價格:不得為空!");
				}
				Integer activityItemprice = null;
				try {
					activityItemprice = Integer.parseInt(input_activityItemprice);
				}catch(Exception e) {
					errorMsgs.add("活動項目價格:格式不正確!");
				}
				
				
				Boolean activityItemstate = Boolean.parseBoolean(req.getParameter("activityItemstate"));
				
//				Integer activtiyCategoryid = Integer.parseInt(req.getParameter("activityCategoryid").trim());
				String input_activtiyCategoryid = req.getParameter("activityCategoryid");
				if(input_activtiyCategoryid == null || input_activtiyCategoryid.trim().length() == 0) {
					errorMsgs.add("活動類別編號:不得為空!");
				}
				Integer activtiyCategoryid = null;
				try {
					activtiyCategoryid = Integer.parseInt(input_activtiyCategoryid);
				}catch(Exception e) {
					errorMsgs.add("活動類別編號:格式不正確!");
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
						
				ActivityItemVO aitVO = new ActivityItemVO();
				aitVO.setActivityItemid(activityItemid);
				aitVO.setActivityItemname(activityItemname);
				aitVO.setActivityItemdescription(activityItemdescription);
				aitVO.setActivityIteminfo(activityIteminfo);
				aitVO.setActivityItemprice(activityItemprice);
				aitVO.setActivityItemstate(activityItemstate);
				//aitVO.setActivityCategory(activityCategory);
				//actVO.setActivityCategorypic(activityCategorypic);
				
				//若有錯誤訊息，則帶使用者回到頁面
				if(!errorMsgs.isEmpty()) {
					req.setAttribute("activtiyCategoryid", activtiyCategoryid); // 先前輸入的memVO物件也存入req
					req.setAttribute("aitVO", aitVO); // 先前輸入的memVO物件也存入req
					String failUrl = "addActivity.jsp" ;
					RequestDispatcher fail = req.getRequestDispatcher(failUrl);
					fail.forward(req, res);
					return; //中斷程式
				}
				
				/***************************輸入正確，做資料修改**********************/
				ActivityItemService aitSvc = new ActivityItemService();
				aitVO = aitSvc.updateActivityItem(activityItemid ,activityItemname,activityItemdescription,activityIteminfo,activityItemprice,activityItemstate,activtiyCategoryid);
				
				
				
				
				/***************************修改完成，轉交前台**********************/
				
				req.setAttribute("aitVO",aitVO);
				String sucessUrl = "selectPage.jsp" ;
				RequestDispatcher sucess = req.getRequestDispatcher(sucessUrl);
				sucess.forward(req, res);
				out.println("<h3>資料修改成功!!</h3>");
				}
//刪除           
			
			if ("delete".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
		
					/***************************1.接收請求參數***************************************/
					Integer activityItemid = Integer.valueOf(req.getParameter("activityItemid"));
					
					/***************************2.開始刪除資料***************************************/
					ActivityItemService aitSvc = new ActivityItemService();
					aitSvc.deleteActivityItem(activityItemid );
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "listAllActivity.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
			}
		
	}
}
	

