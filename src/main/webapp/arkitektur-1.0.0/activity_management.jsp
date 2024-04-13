<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.activity.model.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Activity_Management HTML</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@100..900&family=Pridi:wght@600&display=swap" rel="stylesheet">
    
    <!-- Tac One -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pridi:wght@600&display=swap" rel="stylesheet">
   

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border position-relative text-primary" style="width: 6rem; height: 6rem;" role="status"></div>
        <img class="position-absolute top-50 start-50 translate-middle" src="img/icons/icon-12.png" alt="Icon">
    </div>
    <!-- Spinner End -->


    <!-- Topbar Start -->
    <div class="container-fluid green-bg p-0 wow fadeIn " data-wow-delay="0.1s">
        <div class="row gx-0 d-none d-lg-flex shadow ">
            <div class="col-lg-7 px-4 text-start">
                <img src="./img/icons/LOGO-7.png">
                <span class="navbar-brand2" href="#">CACTUS</span>
                <!-- <div class="h-100 d-inline-flex align-items-center py-3 me-3"> -->
                    <!-- <a class="text-body px-2" href="tel:+0123456789"><i class="fa fa-phone-alt text-white me-2"></i>+012 345 6789</a>
                    <a class="text-body px-2" href="mailto:info@example.com"><i class="fa fa-envelope-open text-gold me-2"></i>info@example.com</a> -->
                <!-- </div> -->
            </div>
            
            <div class="col-lg-5  text-end">
                
                <!-- <div class="container-fluid2">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <a class="text-white px-2" href="">加入會員</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                </div> -->
                <div class=" d-inline-flex align-items-center   height-1 border-dot">
                    <!-- <a class="text-white px-2" href="">English ｜</a>
                    <a class="text-white px-2" href="">日本語 ｜</a> -->
                    <a class="text-white padding-set " href="">員工姓名</a>
                    

                </div>
                <div class=" d-inline-flex align-items-center  me-2 height-1 border-dot">
                    <!-- <a class="text-white px-2" href="">English ｜</a>
                    <a class="text-white px-2" href="">日本語 ｜</a> -->
                    <a class="text-white px-4 " href="">登出</a>
                    

                </div>
                <!-- <div class="h-100 d-inline-flex align-items-center">
                    <a class="btn btn-sm-square btn-outline-body me-1" href=""><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-sm-square btn-outline-body me-1" href=""><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-sm-square btn-outline-body me-1" href=""><i class="fab fa-linkedin-in"></i></a>
                    <a class="btn btn-sm-square btn-outline-body me-0" href=""><i class="fab fa-instagram"></i></a>
                </div> -->
            </div>
        </div>
    </div>
    <!-- Topbar End -->

    <div class="display-a">
    

    <!-- 側邊欄 -->
    <div class="main-menu">

        <!-- <nav class="main-menu"> -->
            <ul class="list">
  
                <li class="list-set border-dot2">                                   
                <a class="changecolor" href="">
                <i class="fa fa-home fa-lg"></i>
                <span class="nav-text">首頁</span>
                </a>
                </li>   
                   
                <li class="list-set border-dot2">                                 
                <a class="changecolor" href="">
                <i class="fa fa-user fa-lg"></i>
                <span class="nav-text">會員管理</span>
                </a>
                </li>   
                
                    
                <li class="border-dot2">                                 
                <!-- <a  class="accordion" href="">
                <i class="fa fa-envelope-o fa-lg"></i>
                <span class="nav-text ">活動管理</span> -->
                <div class="accordion-item2 ">
                    
                    <h2 class="accordion-header" id="headingOne">
                       
                      <button class="accordion-button2 collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        <i class="fa-solid fa-umbrella-beach padding-set2"></i>
                        &nbsp;活動管理系統
                      </button>
                    </h2>
                    <div id="collapseOne" class="accordion-collapse collapse " aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                      <div class="accordion-body2">
                        <ul class="list2">
                            <li class="list-set2"><a class="changecolor" href="">活動類別管理</a></li>
                            <li class="list-set2"><a class="changecolor" href="">活動管理</a> </li>
                            <li class="list-set2"><a class="changecolor" href="">活動場次</a> </li>
                            <li class="list-set2"><a class="changecolor" href="">活動圖片管理</a> </li>
                            <li class="list-set2"><a class="changecolor" href="">活動訂單管理</a></li>
                            <li class="list-set2"><a class="changecolor" href="">活動促銷管理</a> </li>
                        </ul>
                  
                      </div>
                    </div>
                  </div>
                
                </li>  
                <li class="border-dot2">                                 
                    <!-- <a  class="accordion" href="">
                    <i class="fa fa-envelope-o fa-lg"></i>
                    <span class="nav-text ">活動管理</span> -->
                    <div class="accordion-item2 ">
                        
                        <h2 class="accordion-header" id="headingOne">
                           
                          <button class="accordion-button2 collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            <i class="fa-solid fa-umbrella-beach padding-set2"></i>
                            &nbsp;活動管理系統
                          </button>
                        </h2>
                        <div id="collapseOne" class="accordion-collapse collapse " aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                          <div class="accordion-body2">
                            <ul class="list2">
                                <li class="list-set2"><a class="changecolor" href="">活動類別管理</a></li>
                                <li class="list-set2"><a class="changecolor" href="">活動管理</a> </li>
                                <li class="list-set2"><a class="changecolor" href="">活動場次</a> </li>
                                <li class="list-set2"><a class="changecolor" href="">活動圖片管理</a> </li>
                                <li class="list-set2"><a class="changecolor" href="">活動訂單管理</a></li>
                                <li class="list-set2"><a class="changecolor" href="">活動促銷管理</a> </li>
                            </ul>
                      
                          </div>
                        </div>
                      </div>
                    
                    </li>  
            
                  

        </div>
        <div class="padding-set3">
            <div >
            <h2>活動管理系統—活動類別管理</h2>
            </div>  
            <div class="padding-set4">
                
                <button class="btn btn-primary border-radius" type="submit" value="Submit">+ 新增活動類別</button>
                
                <button class="btn btn-dark margin-set1 border-radius" type="submit" value="Submit"><i class="fa-solid fa-magnifying-glass"></i>&nbsp;活動類別查詢</button>
            </div>
            <div id ="xxx">
            
                
            </div>

        </div>
        
     
    </div>
        
       
    


    <!-- Footer Start -->
  
    
    <!-- <div class="container-fluid text-body footer pt-5 px-0 wow fadeIn" data-wow-delay="0.1s">
        
        

        
        <div class="container py-5">
          
        </div>
       
    </div> -->
    <!-- Footer End -->


    


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>

    <!-- Kit Icon -->
    <script src="https://kit.fontawesome.com/8366d3754a.js" crossorigin="anonymous"></script>
    <script>
    $.ajax({
    	  url:'../selectPage.jsp',
    	  type:'get',
    	  success:function(res){
    	   $('#xxx').html($(res));
    	  }
    	 })
    </script>	 
</body>



</html>
