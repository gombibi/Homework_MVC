<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<!-- 지도 API -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=349106698fd6134fd9445386774c31cd"></script>
	
	<style type="text/css">
	table {
		border: solid 2px black;
		border-collapse: collapse;
	}
	
	tr {
		border: solid 1px blue;
		background-color: white;
		color: black;
	}
	
	td {
		border: solid 1px red;
	}
	</style>
</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/WEB-INF/commonview/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/WEB-INF/commonview/Left.jsp"></jsp:include>
			</td>

			<td style="width: 700px">
			
			<!-- 지도를 담을 영역 생성 -->
			<div id="map" style="width:500px;height:400px;"></div>
			
			<!-- 지도 띄우기 -->
			<script>
			/*
			//gps 통해 사용자 위치에 접근하고, 허용 시 사용자의 위치를 반환하여 저장
			var gps_use = null; //gps의 사용가능 여부
			var gps_lat = null; // 위도
			var gps_lng = null; // 경도
			var gps_position; // gps 위치 객체

			gps_check();
			// gps가 이용가능한지 체크하는 함수이며, 이용가능하다면 show location 함수를 불러온다.
			// 만약 작동되지 않는다면 경고창을 띄우고, 에러가 있다면 errorHandler 함수를 불러온다.
			// timeout을 통해 시간제한을 둔다.
			function gps_check(){
			    if (navigator.geolocation) {
			        var options = {timeout:60000};
			        navigator.geolocation.getCurrentPosition(showLocation, errorHandler, options);
			    } else {
			        alert("GPS_추적이 불가합니다.");
			        gps_use = false;
			        console.log("gps_use");
			    }
			}

			// gps 이용 가능 시, 위도와 경도를 반환하는 showlocation함수.
			function showLocation(position) {
			    gps_use = true;
			    gps_lat = position.coords.latitude;
			    gps_lng = position.coords.longitude;
			}

			// error발생 시 에러의 종류를 알려주는 함수.
			function errorHandler(error) {
			    if(error.code == 1) {
			        alert("접근차단");
			    } else if( err.code == 2) {
			        alert("위치를 반환할 수 없습니다.");
			    }
			    gps_use = false;
			}
			
			window.onload=function(){
				function gps_tracking(){
				    if (gps_use) {
				        map.panTo(new kakao.maps.LatLng(gps_lat,gps_lng));
				        var gps_content = '<div><img class="pulse" draggable="false" unselectable="on" src="https://ssl.pstatic.net/static/maps/m/pin_rd.png" alt=""></div>';
				        var currentOverlay = new kakao.maps.CustomOverlay({
				            position: new kakao.maps.LatLng(gps_lat,gps_lng),
				            content: gps_content,
				            map: map
				        });
				        currentOverlay.setMap(map);
				    } else {
				      alert("접근차단하신 경우 새로고침, 아닌 경우 잠시만 기다려주세요.");
				      gps_check();
				    }
				}
				gps_tracking();
				
				*/
				
				
				// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
				var infowindow = new kakao.maps.InfoWindow({zIndex:1});
				
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = {
				        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
				        level: 3 // 지도의 확대 레벨
				    };  
				
				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption); 
				
				
			};
			
			</script>
			
										
			</td>
		</tr>
	</table>

</body>
</html>
