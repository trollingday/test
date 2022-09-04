<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/manager/common/setting.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>결산 차트</title>

<link rel="stylesheet" href="${path}/resources/css/commonCss/header.css">
<link rel="stylesheet" href="${path}/resources/css/commonCss/footer.css">
<link rel="stylesheet" href="${path}/resources/css/managerCss/table.css">

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>

var array=[]

<c:forEach items="${totalPrice}" var="row">
	array.push(${row});
</c:forEach>

//차트 정보 설정
function drawVisualization() {
	
	//차트 데이터
	var data = google.visualization.arrayToDataTable([
		[' ','1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		[' ',array[0],array[1],array[2],array[3],array[4],array[5],array[6],array[7],array[8],array[9],array[10],array[11]]
	]);
	
	//차트디자인
	var options = {
			title : '월별 판매금액',
			vAxis : {title: '매출액'},
			hAxis : {title: '월별'},
			width : 1000,
			height : 600,
			seriesType : 'bars',
			series : {12: {type:'line'}}
	};
	
	var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
	chart.draw(data,options);
	
}

//차트 불러오기
function loadChart(){
	google.charts.load('current',{'packages':['corechart']});
	google.charts.setOnLoadCallback(drawVisualization);
}

$(function(){
	loadChart();
})

</script>

</head>
<body>

	<%@ include file="/WEB-INF/views/manager/common/header.jsp" %>
  
    <!-- 컨텐츠 시작 -->
	<div id="container">
   		<div id="contents">
   		
   			<div id="section1">
   				<h1 align="center">
   				ADMIN PAGE
   				<hr>
   				</h1>
   			</div>
   			
			<!-- section2 시작 -->
			<div id="section2">
				<!-- 왼쪽내용 시작 -->
				<%@ include file="/WEB-INF/views/manager/common/leftMenu.jsp" %> 
				
				<!-- 구글차트 -->
				<div id="chart_box" style="height:100%;">
					<div id="chart_div" style="padding-left:40px;"></div>
				</div>
   				
   			</div>
   				
   		</div>
   	</div>
   	<!-- 컨텐츠 종료 -->

	<%@ include file="/WEB-INF/views/manager/common/footer.jsp" %>
   
</body>
</html>