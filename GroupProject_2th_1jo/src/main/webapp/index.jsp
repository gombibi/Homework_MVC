<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!Doctype html>
<html class="no-js"  lang="en">

	<head>
		<!-- META DATA -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<!--font-family-->
		<link href="https://fonts.googleapis.com/css?family=Rufina:400,700" rel="stylesheet" />

		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet" />

		<!-- TITLE OF SITE -->
		
		<title>돌봐줄개냥</title>
		

		<!-- favicon img -->
		<link rel="shortcut icon" type="image/icon" href="logo/favicon.png"/>

		<!--font-awesome.min.css-->
		<link rel="stylesheet" href="css/font-awesome.min.css" />

		<!--animate.css-->
		<link rel="stylesheet" href="css/animate.css" />

		<!--hover.css-->
		<link rel="stylesheet" href="css/hover-min.css">

		<!--datepicker.css-->
		<link rel="stylesheet"  href="css/datepicker.css" >

		<!--owl.carousel.css-->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
		<link rel="stylesheet" href="css/owl.theme.default.min.css"/>

		<!-- range css-->
        <link rel="stylesheet" href="css/jquery-ui.min.css" />

		<!--bootstrap.min.css-->
		<link rel="stylesheet" href="css/bootstrap.min.css" />

		<!-- bootsnav -->
		<link rel="stylesheet" href="css/bootsnav.css"/>

		<!--style.css-->
		<link rel="stylesheet" href="css/style.css" />

		<!--responsive.css-->
		<link rel="stylesheet" href="css/responsive.css" />

	
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
		
		<link
		    rel="stylesheet"
		    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
		  />

		<script type="text/javascript">
			function showfield(name){
			  if(name=='Other')document.getElementById('div1').innerHTML='Address: <input type="text" name="other" />';
			  else document.getElementById('div1').innerHTML='';
			}
		</script>





	</head>

	<body>







		<!--[if lte IE 9]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade
			your browser</a> to improve your experience and security.</p>
		<![endif]-->

		<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		
		<!--about-us start -->
		<section id="home" class="about-us">
			<div class="container">
				<div class="about-us-content">
					<div class="row">
						<div class="col-sm-12">
							<div class="single-about-us">
								<div class="about-us-txt">
									<h2>
										Not Null One hae
									</h2>
								</div><!--/.about-us-txt-->
							</div><!--/.single-about-us-->
						</div><!--/.col-->

					</div><!--/.row-->
				</div><!--/.about-us-content-->
			</div><!--/.container-->

		</section><!--/.about-us-->
		<!-- 메인 페이지 대문사진 end -->


		<!-- 고양이 방문돌봄 예약메뉴 -->
			
		<section  class="travel-box">
        	<div class="container">
        		<div class="row">
        			<div class="col-md-12">
        				<div class="single-travel-boxes">
        					<div id="desc-tabs" class="desc-tabs">

								<ul class="nav nav-tabs" role="tablist">

									<li role="presentation" class="active">
									 	<a href="#tours" aria-controls="tours" role="tab" data-toggle="tab">
									 		<i class="fas fa-cat"></i>
									 		cat
									 	</a>
									</li>

									<li role="presentation">
									 	<a href="#flights" aria-controls="flights" role="tab" data-toggle="tab">
									 		<i class="fas fa-dog"></i>
									 		dog
									 	</a>
									</li>
								</ul>

								<!-- Tab panes -->
								<div class="tab-content">

									<div role="tabpanel" class="tab-pane active fade in" id="tours">
										<div class="tab-para">

											<div class="row">
												<div class="col-lg-4 col-md-4 col-sm-12">
													<div class="single-tab-select-box">
														<h2 class="servicebox"><br>주소 입력</h2>

														<div class="travel-select-icon">
															<select class="form-control" onchange="showfield(this.options[this.selectedIndex].value)">
															
															  	<option value="default">enter your address</option><!-- /.option-->
															
															  	<option value="Other" id="">주소입력하기</option><!-- /.option-->
															 
															</select><!-- /.select-->
															
														</div><!-- /.travel-select-icon -->
													</div><!--/.single-tab-select-box-->
												</div><!--/.col-->
												

												<div class="col-lg-2 col-md-3 col-sm-4">
													
												
													<div class="single-tab-select-box">
														<h2>Start Date</h2>
														<div class="travel-check-icon">
															<form action="#">
																<input type="text" name="check_in" class="form-control" data-toggle="datepicker" placeholder="12 -01 - 2017 ">
															</form>
														</div><!-- /.travel-check-icon -->
													</div><!--/.single-tab-select-box-->
												</div><!--/.col-->

												<div class="col-lg-2 col-md-3 col-sm-4">
													<div class="single-tab-select-box">
														<h2>End Date</h2>
														<div class="travel-check-icon">
															<form action="#">
																<input type="text" name="check_out" class="form-control"  data-toggle="datepicker" placeholder="22 -01 - 2017 ">
															</form>
														</div><!-- /.travel-check-icon -->
													</div><!--/.single-tab-select-box-->
												</div><!--/.col-->

												<div>
													<div class="single-tab-select-box">
														<h2>총 견적 : </h2>
														
													</div><!--/.single-tab-select-box-->
												</div><!--/.col-->

											</div><!--/.row-->

											<div class="row">
												<div class="clo-sm-7">
													<div class="about-btn travel-mrt-0 pull-right">
														<button  class="about-view travel-btn">
															search	
														</button><!--/.travel-btn-->
													</div><!--/.about-btn-->
												</div><!--/.col-->

											</div><!--/.row-->

										</div><!--/.tab-para-->

									</div><!--/.tabpannel-->

				
				
				
				<!-- 강아지 산책 및 방문돌봄 예약메뉴 -->

									<div role="tabpanel" class="tab-pane fade in" id="flights">
										<div class="tab-para">
											<div class="trip-circle">
												<div class="single-trip-circle">
													<input type="radio" id="radio01" name="radio" />
  													<label for="radio01">
  														<span class="round-boarder">
  															<span class="round-boarder1"></span>
  														</span>산책 
  													</label>
												</div><!--/.single-trip-circle-->
												<div class="single-trip-circle">
													<input type="radio" id="radio02" name="radio" />
  													<label for="radio02">
  														<span class="round-boarder">
  															<span class="round-boarder1"></span>
  														</span>방문돌봄
  													</label>
												</div><!--/.single-trip-circle-->
											</div><!--/.trip-circle-->
											<div class="row">
												<div class="col-lg-4 col-md-4 col-sm-12">
													<div class="single-tab-select-box">

														<h2>주소 입력</h2>

														<div class="travel-select-icon">
															<select class="form-control ">

															  	<option value="default">enter your address</option><!-- /.option-->

															  	<option value="turkey">주소 직접입력하기</option><!-- /.option-->

															</select><!-- /.select-->
														</div><!-- /.travel-select-icon -->
													</div><!--/.single-tab-select-box-->
												</div><!--/.col-->

												<div class="col-lg-2 col-md-3 col-sm-4">
													<div class="single-tab-select-box">
														<h2>Start Date</h2>
														<div class="travel-check-icon">
															<form action="#">
																<input type="text" name="departure" class="form-control" data-toggle="datepicker"
																placeholder="12 -03 - 2021 ">
															</form>
														</div><!-- /.travel-check-icon -->
													</div><!--/.single-tab-select-box-->
												</div><!--/.col-->
												
												<div class="col-lg-2 col-md-3 col-sm-4">
													<div class="single-tab-select-box">
														<h2>End Date</h2>
														<div class="travel-check-icon">
															<form action="#">
																<input type="text" name="check_out" class="form-control"  data-toggle="datepicker" placeholder="22 -01 - 2017 ">
															</form>
														</div><!-- /.travel-check-icon -->
													</div><!--/.single-tab-select-box-->
												</div><!--/.col-->


												

											</div><!--/.row-->

											<div class="row">
												<div class="col-lg-4 col-md-4 col-sm-12">
													<div class="single-tab-select-box">

														

													</div><!--/.single-tab-select-box-->
												</div><!--/.col-->
												<div class="col-lg-3 col-md-3 col-sm-4">
													<div class="single-tab-select-box">

														<h2>원하는 시간(n시간)</h2>
														<div class="travel-select-icon">
															<select class="form-control ">

															  	<option value="default">시간을 선택해 주세요.</option><!-- /.option-->

															  	<option value="A">09:00-10:00</option><!-- /.option-->
															  	<option value="B">14:00-16:00</option><!-- /.option-->
															  	<option value="C">16:00-18:00</option><!-- /.option-->
															  	<option value="D">20:00-22:00</option>

															</select><!-- /.select-->
														</div><!-- /.travel-select-icon -->
													</div><!--/.single-tab-select-box-->
												</div><!--/.col-->
												
												<div>
													<div class="single-tab-select-box">
														<h2>총 견적 : </h2>
														
													</div><!--/.single-tab-select-box-->
												</div><!--/.col-->
												
												<div class="clo-sm-5">
													<div class="about-btn pull-right">
														<button  class="about-view travel-btn">
															search	
														</button><!--/.travel-btn-->
													</div><!--/.about-btn-->
												</div><!--/.col-->
												
											</div><!--/.row-->

										</div>

									</div><!--/.tabpannel-->

								</div><!--/.tab content-->
							</div><!--/.desc-tabs-->
        				</div><!--/.single-travel-box-->
        			</div><!--/.col-->
        		</div><!--/.row-->
        	</div><!--/.container-->
 	</section><!--/.travel-box-->
 	
 	
        <!-- 돌봐줄개냥이 제공하는 서비스 설명 -->
		<section id="service" class="service">
			<div class="container">

				<div class="service-counter text-center">

					<div class="col-md-4 col-sm-4">
						<div class="single-service-box">
							<div class="service-img">
								<img src="images/service/s1.png" alt="service-icon" />
							</div><!--/.service-img-->
							<div class="service-content">
								<h2>
									<a href="#">
									엄선된 펫시터 고용
									</a>
								</h2>
								<p>강형욱 훈련사님의 전문 교육을 수료한 엄선된 펫시터가 방문합니다!</p>
							</div><!--/.service-content-->
						</div><!--/.single-service-box-->
					</div><!--/.col-->

					<div class="col-md-4 col-sm-4">
						<div class="single-service-box">
							<div class="service-img">
								<img src="images/service/s2.png" alt="service-icon" />
							</div><!--/.service-img-->
							<div class="service-content">
								<h2>
									<a href="#">
										실시간 돌봄 영상
									</a>
								</h2>
								<p>모든 팻시터는 바디캠을 착용하여<br>
									모든 돌봄과정을 실시간 영상으로 <br>
									확인하실 수 있습니다.
									!</p>
							</div><!--/.service-content-->
						</div><!--/.single-service-box-->
					</div><!--/.col-->

					<div class="col-md-4 col-sm-4">
						<div class="single-service-box">
							<div class="statistics-img">
								<img src="images/service/s3.png" alt="service-icon" />
							</div><!--/.service-img-->
							<div class="service-content">

								<h2>
									<a href="#">
										체계적이고 안전한 프로그램
									</a>
								</h2>
								<p>예상치 못한 사건 또는 사고 발생시<br>
									책임보상제도 등 체계적인 
									안전 프로그램이<br> 적용됩니다.
									!</p>
							</div><!--/.service-content-->
						</div><!--/.single-service-box-->
					</div><!--/.col-->

				</div><!--/.statistics-counter-->	
			</div><!--/.container-->

		</section><!--/.service-->
		<!--돌봐줄개냥 서비스 설명 end-->





		<!-- best 포토 start -->
			
			<section id="pack" class="packages">
			<div class="container">
				<div class="gallary-header text-center">
					<h2>
						Best Photo of Year
					</h2>
					<p>
						포토갤러리에 사진을 업로드하고 Best Photo에 주인공이 되어보세요!  
					</p>
				</div><!--/.gallery-header-->
				<div class="packages-content">
					<div class="row">

						<div class="col-md-4 col-sm-6">
							<div class="single-package-item">
								<img src="images/packages/jung.jpg" alt="package-place">
								<div class="single-package-item-txt">
									<h3> <span class="pull-right"><i class="fas fa-heart"></i> 10k</span></h3>
									<div class="packages-para">
										<p>
											<span>
												<i class="fa fa-angle-right"></i>
												홈페이지에서 답변도 빠르구 정말 친절하셨어요!
											</span>
											
										</p>
										
									</div><!--/.packages-para-->
									
									
									<!--  추후 서비스단 연결 필요 -->
									<div class="about-btn">
										<button type="submit"  class="about-view packages-btn" onclick="location.href = '.bd';">
											더보기 
										</button>
									</div><!--/.about-btn-->
								</div><!--/.single-package-item-txt-->
							</div><!--/.single-package-item-->

						</div><!--/.col-->

						<div class="col-md-4 col-sm-6">
							<div class="single-package-item">
								<img src="images/packages/p2.jpg" alt="package-place">
								<div class="single-package-item-txt">
									<h3> <span class="pull-right"><i class="fas fa-heart"></i> 10k</span></h3>
									<div class="packages-para">
										<p>
											<span>
												<i class="fa fa-angle-right"></i>
												홈페이지에서 답변도 빠르구 정말 친절하셨어요!
											</span>
											
										</p>
										
									</div><!--/.packages-para-->
									
									<div class="about-btn" href="/WEB-INF/view/board/photogallery.jsp">
										<button  class="about-view packages-btn">
											더보기 
										</button>
									</div><!--/.about-btn-->
								</div><!--/.single-package-item-txt-->
							</div><!--/.single-package-item-->

						</div><!--/.col-->
						
						<div class="col-md-4 col-sm-6">
							<div class="single-package-item">
								<img src="images/packages/p3.jpg" alt="package-place">
								<div class="single-package-item-txt">
									<h3> <span class="pull-right"><i class="fas fa-heart"></i> 10k</span></h3>
									<div class="packages-para">
										<p>
											<span>
												<i class="fa fa-angle-right"></i>
												홈페이지에서 답변도 빠르구 정말 친절하셨어요!
											</span>
											
										</p>
										
									</div><!--/.packages-para-->
									
									<div class="about-btn">
										<button  class="about-view packages-btn">
											더보기 
										</button>
									</div><!--/.about-btn-->
								</div><!--/.single-package-item-txt-->
							</div><!--/.single-package-item-->

						</div><!--/.col-->
						
						<!-- <div class="col-md-4 col-sm-6">
							<div class="single-package-item">
								<img src="assets/images/packages/p4.jpg" alt="package-place">
								<div class="single-package-item-txt">
									<h3>india <span class="pull-right">$799</span></h3>
									<div class="packages-para">
										<p>
											<span>
												<i class="fa fa-angle-right"></i> 4 Days 5 nights
											</span>
											<i class="fa fa-angle-right"></i>  5 star accomodation
										</p>
										<p>
											<span>
												<i class="fa fa-angle-right"></i>  transportation
											</span>
											<i class="fa fa-angle-right"></i>  food facilities
										 </p>
									</div>/.packages-para
									<div class="packages-review">
										<p>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<span>625 reviews</span>
										</p>
									</div>/.packages-review
									<div class="about-btn">
										<button  class="about-view packages-btn">
											book now
										</button>
									</div>/.about-btn
								</div>/.single-package-item-txt
							</div>/.single-package-item

						</div>/.col
						
						<div class="col-md-4 col-sm-6">
							<div class="single-package-item">
								<img src="assets/images/packages/p5.jpg" alt="package-place">
								<div class="single-package-item-txt">
									<h3>spain <span class="pull-right">$999</span></h3>
									<div class="packages-para">
										<p>
											<span>
												<i class="fa fa-angle-right"></i> 4 Days 4 nights
											</span>
											<i class="fa fa-angle-right"></i>  5 star accomodation
										</p>
										<p>
											<span>
												<i class="fa fa-angle-right"></i>  transportation
											</span>
											<i class="fa fa-angle-right"></i>  food facilities
										 </p>
									</div>/.packages-para
									<div class="packages-review">
										<p>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<span>379 reviews</span>
										</p>
									</div>/.packages-review
									<div class="about-btn">
										<button  class="about-view packages-btn">
											book now
										</button>
									</div>/.about-btn
								</div>/.single-package-item-txt
							</div>/.single-package-item

						</div>/.col
						
						<div class="col-md-4 col-sm-6">
							<div class="single-package-item">
								<img src="assets/images/packages/p6.jpg" alt="package-place">
								<div class="single-package-item-txt">
									<h3>thailand <span class="pull-right">$799</span></h3>
									<div class="packages-para">
										<p>
											<span>
												<i class="fa fa-angle-right"></i> 5 Days 6 nights
											</span>
											<i class="fa fa-angle-right"></i>  5 star accomodation
										</p>
										<p>
											<span>
												<i class="fa fa-angle-right"></i>  transportation
											</span>
											<i class="fa fa-angle-right"></i>  food facilities
										 </p>
									</div>/.packages-para
									<div class="packages-review">
										<p>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<span>447 reviews</span>
										</p>
									</div>/.packages-review
									<div class="about-btn">
										<button  class="about-view packages-btn">
											book now
										</button>
									</div>/.about-btn
								</div>/.single-package-item-txt
							</div>/.single-package-item

						</div>/.col -->

					</div><!--/.row-->
				</div><!--/.packages-content-->
			</div><!--/.container-->

		</section><!--/.packages-->
			
		<!-- best 포토 end -->


		<!-- 회원가입 권유 (하단) -->
		<section id="spo" class="special-offer">
			<div class="container">
				<div class="special-offer-content">
					<div class="row">
						<div class="col-sm-8">
							<div class="single-special-offer">
							
								<div class="single-special-offer-txt">
									<h2>Join Now!</h2>
									<div class="packages-review special-offer-review">
										<p>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<i class="fa fa-star"></i>
											<span>직접 사용해본 고객님들의 123건의 만족스러운 후기</span>
										</p>
									</div><!--/.packages-review-->
									<div class="packages-para special-offer-para">
										<p>
											<span>
												<i class="fa fa-angle-right"></i> 교육을 받은 훈련사님들이라서 그런지 믿고 맡길 수 있었어요!<br>
											</span>
											<span>
												<i class="fa fa-angle-right"></i> 저희애가 사람을 물어서 걱정했는데 여기는 정말 맘편히 사용합니다<br>
											</span>
											<span>
												<i class="fa fa-angle-right"></i> 저희 냥이가 노묘라서 실수를 많이하는데 다 치워주시고 여긴 최고네요:)<br>
											</span>
											<span>
												<i class="fa fa-angle-right"></i> 처음 반려동물을 맡기시는 분들께 추천합니다. <br>
											</span>
											<span>
												<i class="fa fa-angle-right"></i> 이만한 퀄리티에 이 가격이면 계속 이용할듯 해요^^
											</span>  
										</p>
										<p class="offer-para">
											지금 바로 가입하세요! 
										</p>
									</div><!--/.packages-para-->
									<div class="offer-btn-group">
										<div class="about-btn">
											<button  class="about-view packages-btn offfer-btn" onclick="location.href = 'joinform.jsp';">
												join now
											</button>
										</div>
									</div><!--/.offer-btn-group-->
								</div><!--/.single-special-offer-txt-->
							</div><!--/.single-special-offer-->
						</div><!--/.col-->
						<div class="col-sm-4">
							<div class="single-special-offer">
								<div class="single-special-offer-bg">
									<img src="images/offer/offer-shape.png" alt="offer-shape">
								</div><!--/.single-special-offer-bg-->
								<!-- <div class="single-special-shape-txt">
									<h3>special offer</h3>
									<h4><span>40%</span><br>off</h4>
									<p><span>$999</span><br>reguler $ 1450</p>
								</div>/.single-special-shape-txt -->
							</div><!--/.single-special-offer-->
						</div><!--/.col-->
					</div><!--/.row-->
				</div><!--/.special-offer-content-->
			</div><!--/.container-->

		</section><!--/.special-offer end-->
		<!--special-offer end-->


		<!-- footer-copyright start -->
		<footer  class="footer-copyright">
			<div class="container">
				<hr>
				<div class="foot-icons ">
					<ul class="footer-social-links list-inline list-unstyled">
		                <li><a href="#" target="_blank" class="foot-icon-bg-1"><i class="fa fa-facebook"></i></a></li>
		                <li><a href="#" target="_blank" class="foot-icon-bg-2"><i class="fa fa-twitter"></i></a></li>
		                <li><a href="#" target="_blank" class="foot-icon-bg-3"><i class="fa fa-instagram"></i></a></li>
		        	</ul>
		        	<p>&copy; 2021 <a href="https://www.themesine.com">Not Null ONE Hae</a>. All Right Reserved</p>

		        </div><!--/.foot-icons-->
				<div id="scroll-Top">
					<i class="fa fa-angle-double-up return-to-top" id="scroll-top" data-toggle="tooltip" data-placement="top" title="" data-original-title="Back to Top" aria-hidden="true"></i>
				</div><!--/.scroll-Top-->
			</div><!-- /.container-->

		</footer><!-- /.footer-copyright-->
		<!-- footer-copyright end -->




		<script src="js/jquery.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->

		<!--modernizr.min.js-->
		<script  src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>


		<!--bootstrap.min.js-->
		<script  src="js/bootstrap.min.js"></script>

		<!-- bootsnav js -->
		<script src="js/bootsnav.js"></script>

		<!-- jquery.filterizr.min.js -->
		<script src="js/jquery.filterizr.min.js"></script>

		<script  src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>

		<!--jquery-ui.min.js-->
        <script src="js/jquery-ui.min.js"></script>

        <!-- counter js -->
		<script src="js/jquery.counterup.min.js"></script>
		<script src="js/waypoints.min.js"></script>

		<!--owl.carousel.js-->
        <script  src="js/owl.carousel.min.js"></script>

        <!-- jquery.sticky.js -->
		<script src="js/jquery.sticky.js"></script>

        <!--datepicker.js-->
        <script  src="js/datepicker.js"></script>

		<!--Custom JS-->
		<script src="js/custom.js"></script>


	</body>

</html>