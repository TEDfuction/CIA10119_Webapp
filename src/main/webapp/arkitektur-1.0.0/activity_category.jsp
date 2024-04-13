<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.activity.model.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Cactus Activity Category HTML</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <!-- Noto+Sans+TC -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@100..900&family=Pridi:wght@600&display=swap" rel="stylesheet">
    
    <!-- Pridi -->
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
    <!-- Spinner Start  Lodding畫面-->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border position-relative text-primary" style="width: 6rem; height: 6rem;" role="status"></div>
        <img class="position-absolute top-50 start-50 translate-middle" src="img/icons/icon-12.png" alt="Icon">
    </div>
    <!-- Spinner End -->


    <!-- Topbar Start -->
    <div class="container-fluid green-bg p-0 wow fadeIn" data-wow-delay="0.1s">
        <div class="row gx-0 d-none d-lg-flex">
            <div class="col-lg-7 px-5 text-start">
                <!-- <div class="h-100 d-inline-flex align-items-center py-3 me-3"> -->
                    <!-- <a class="text-body px-2" href="tel:+0123456789"><i class="fa fa-phone-alt text-white me-2"></i>+012 345 6789</a>
                    <a class="text-body px-2" href="mailto:info@example.com"><i class="fa fa-envelope-open text-gold me-2"></i>info@example.com</a> -->
                <!-- </div> -->
            </div>
            <div class="col-lg-5 px-5 text-end">
                <div class="h-100 d-inline-flex align-items-center py-3 me-2">
                    <a class="text-white px-2" href="">回到首頁 ｜</a>
                    <a class="text-white px-2" href="">English ｜</a>
                    <a class="text-white px-2" href="">日本語 ｜</a>
                    <a class="text-white px-2" href="">加入會員</a>

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

    <!-- 輪播圖 -->

    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="img/carousel-1.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="img/carousel-1.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="img/carousel-1.jpg" class="d-block w-100" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>

      <!-- 輪播圖結束 -->

      <!-- 活動搜尋 -->
      <nav class="navbar2 navbar-expand-lg navbar-light ">
        <div class="container-fluid">
          <!-- <a class="navbar-brand" href="#">Navbar scroll</a> -->
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
              <li class="nav-item">
                <a class="nav-link3 active" aria-current="page" href="#">活動類別：</a>
              </li>
              <!-- 
              <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
              </li> -->
              
              <li class="nav-item dropdown">
                <a class="nav-link2 dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  全部
                </a>
                <ul class="nav-link2 dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                  <li><a class="dropdown-item" href="#">全部</a></li>
                  <li><a class="dropdown-item" href="#">水上活動</a></li>
                  <li><a class="dropdown-item" href="#">陸上活動</a></li>
                  <li><a class="dropdown-item" href="#">花火節期間活動</a></li>
                  
                </ul>
              </li>
              
            </ul>
            <form class="d-flex">
              <input class="form-control me-2" type="search" placeholder="搜尋" aria-label="Search">
              <button class="btn btn-outline-success2" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav>
      <!-- 活動搜尋結束 -->

      <!-- 活動項目介紹 -->

      <div class="text-center mx-auto mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 600px;">
        <h5 class="section-title">Feature Activity</h5>
        <h4 class="display-5 mb-4">特色活動</h4>
    </div>

    <div class="row2 row-cols-1 row-cols-md-3 g-4">
        <div class="col">
          <div class="card h-100 space">
          
            <td><img src="<%=request.getContextPath()%>/ShowPicServlet.do?activityCategoryid=7"></td>
          
            <div class="card-body">
              <h4 class="card-title2">潛水體驗｜海洋教育</h4>
              <p class="card-text">透過教練一對一或一對二的安全帶領，整個過程由教練抓著氣瓶或手勾手在海底游動，讓無潛水證照但想一探海底的旅人所提供的專業體驗活動。</p>
            </div>
            <div class="card-footer2">
                <span class="nt">NT$</span><span class="money">2,400</span></span> 起</span>
              <!-- <small class="text-muted">Last updated 3 mins ago</small> -->
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card h-100 space">
          
            <td><img src="<%=request.getContextPath()%>/ShowPicServlet.do?activityCategoryid=8"></td>
     
            <div class="card-body">
              <h5 class="card-title2">Card title</h5>
              <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
            </div>
            <div class="card-footer2">
              <span class="nt">NT$</span><span class="money">2,400</span></span> 起</span>
            <!-- <small class="text-muted">Last updated 3 mins ago</small> -->
          </div>
          </div>
        </div>
        <div class="col">
          <div class="card h-100 space">
            <td><img src="<%=request.getContextPath()%>/ShowPicServlet.do?activityCategoryid=10"></td>
            <div class="card-body">
              <h5 class="card-title2">Card title</h5>
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
            </div>
            <div class="card-footer2">
              <span class="nt">NT$</span><span class="money">2,400</span></span> 起</span>
            <!-- <small class="text-muted">Last updated 3 mins ago</small> -->
          </div>
          </div>
        </div>
        
        <div class="col">
            <div class="card h-100 space2">
              <img src="..." class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title2">Card title</h5>
                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
              </div>
              <div class="card-footer2">
                <span class="nt">NT$</span><span class="money">2,400</span></span> 起</span>
              <!-- <small class="text-muted">Last updated 3 mins ago</small> -->
            </div>
            </div>
        </div>
        <div class="col">
          <div class="card h-100 space2">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title2">Card title</h5>
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            </div>
            <div class="card-footer2">
              <span class="nt">NT$</span><span class="money">2,400</span></span> 起</span>
            <!-- <small class="text-muted">Last updated 3 mins ago</small> -->
          </div>
          </div>
        </div>
        <div class="col">
          <div class="card h-100 space2">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title2">Card title</h5>
              <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            </div>
            <div class="card-footer2">
              <span class="nt">NT$</span><span class="money">2,400</span></span> 起</span>
            <!-- <small class="text-muted">Last updated 3 mins ago</small> -->
          </div>
          </div>
        </div>
    </div>
    
    
        
      <!-- 活動項目介紹結束 -->

      <!-- 分頁按鈕 -->
      <nav aria-label="Page navigation example">
        <ul class="pagination2 justify-content-center">
          <li class="page-item disabled">
            <a class="page-link">Previous</a>
          </li>
          <li class="page-item2"><a class="page-link" href="#">1</a></li>
          <li class="page-item2"><a class="page-link" href="#">2</a></li>
          <li class="page-item2"><a class="page-link" href="#">3</a></li>
          <li class="page-item disabled">
            <a class="page-link" href="#">Next</a>
          </li>
        </ul>
      </nav>

    
    <!-- Footer Start -->
    <div>
      
    <script
        src="https://unpkg.com/@dotlottie/player-component@latest/dist/dotlottie-player.mjs"
        type="module"
      ></script>
      <dotlottie-player
        src="https://lottie.host/d5c4ce3c-dc9c-4472-a042-082ebdf05872/kzl7Q2a4za.json"
        background="transparent"
        speed="0.4"
        style="max-width: 100%; margin-bottom: -1px"
        direction="1"
        playMode="normal"
        loop
        autoplay
      ></dotlottie-player>

    
    </div>
    
    <div class="container-fluid text-body footer pt-5 px-0 wow fadeIn" data-wow-delay="0.1s">
        
        

        
        <div class="container py-5">
            <div class="row g-5">
                
                <div class="col-lg-3 col-md-6">
                    <h3 class="text-darkblue mb-4">最新消息</h3>
                    <a class="btn btn-link text-primary5" href="">所有公告</a>
                    <a class="btn btn-link text-primary5" href="">住宿優惠</a>
                    <a class="btn btn-link text-primary5" href="">商城優惠</a>
                    <a class="btn btn-link text-primary5" href="">活動優惠</a>
                    <!-- <a class="btn btn-link" href="">Construction</a> -->
                </div>
                <div class="col-lg-3 col-md-6">
                    <h3 class="text-darkblue mb-4">房型介紹</h3>
                    <a class="btn btn-link text-primary5" href="">AAA套房</a>
                    <a class="btn btn-link text-primary5" href="">BBB套房</a>
                    <a class="btn btn-link text-primary5" href="">CCC套房</a>
                    <a class="btn btn-link text-primary5" href="">DDD套房</a>
                    <!-- <a class="btn btn-link" href="">Support</a> -->
                </div>
                <div class="col-lg-3 col-md-6">
                    <h3 class="text-darkblue mb-4">特色活動</h3>
                    <a class="btn btn-link text-primary5" href="">浮潛</a>
                    <a class="btn btn-link text-primary5" href="">SUP立槳衝浪</a>
                    <a class="btn btn-link text-primary5" href="">寬板滑水</a>
                    <a class="btn btn-link text-primary5" href="">淺灘衝浪</a>
                    <a class="btn btn-link text-primary5" href="">仙人掌園區參觀</a>
                </div>
                <!-- <div class="col-lg-3 col-md-6">
                    <h3 class="text-light mb-4">Newsletter</h3>
                    <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
                    <div class="position-relative mx-auto" style="max-width: 400px;">
                        <input class="form-control bg-transparent w-100 py-3 ps-4 pe-5" type="text" placeholder="Your email">
                        <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
                    </div>
                </div> -->

                <div class="col-lg-3 col-md-6">
                    <h3 class="text-darkblue mb-4">聯絡我們</h3>
                    <p class="mb-2"><i class="fa fa-map-marker-alt text-primary5 me-2"></i>地址：澎湖縣馬公市時裡200號</p>
                    <p class="mb-2"><i class="fa fa-phone-alt text-primary5 me-2"></i>訂房專線：06-2345678 #888</p>
                    <p class="mb-2"><i class="fa fa-envelope text-primary5 me-2"></i>cactus@gmail.com</p>
                    <!-- <div class="d-flex pt-2">
                        <a class="btn btn-square btn-outline-body me-1" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-square btn-outline-body me-1" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-square btn-outline-body me-1" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-square btn-outline-body me-0" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div> -->
                </div>

            </div>
        </div>
        <div class="container-fluid copyright">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        &copy; <a href="#">2024 Cactus Resort Hotel 凱克特司渡假村</a>, All Right Reserved.
                    </div>
                    <div class="col-md-6 text-center text-md-end">
                        <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                        <!-- Designed By <a href="https://htmlcodex.com">HTML Codex</a>
                        <br> Distributed By: <a class="border-bottom" href="https://themewagon.com" target="_blank">ThemeWagon</a> -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


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
</body>

</html>