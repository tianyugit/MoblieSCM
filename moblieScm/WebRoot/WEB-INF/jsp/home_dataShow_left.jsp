<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'home_dataShow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	--> 
	<script type="text/javascript" src="js/jquery.min.js"></script>
   <script type="text/javascript" src="js/jscharts.js"></script>	
   <style>
		body,div{ margin:0; padding:0;}
		div{ height:500px; width:auto; color:#F00;}
		.left{ float:left;  _margin-right:-3px;}
		
		.center{ margin-left:500px; _margin:0 97px;}
</style>
  </head>
  
  <body>
  <div class="left">
    <div id="chartcontainer" style="margin-top: 100px;margin-left: 100px;"><!-- 这里将用来显示图形报表 --></div>
   
 	<script type="text/javascript">
 	
		 	 $(function(){
		    // alert("dfdf2323");
		    $.post("home_getMobStockData.do?time="+new Date().getTime(), {
		              'aa':'dsadas'
		           }, function(data){
		           		//var jsonJS = eval(data);
		           		//var myData = new Array();
		           		//myData[0]=jsonJS[0];
		           		// var colors = ['#00ccff', '#ffb400', '#ff5c6f'];
		               //第二个参数值有：line,bar,pie分别表示用线形图、柱状图、饼图来展示报表
						var myChart = new JSChart('chartcontainer', 'pie');
						//myChart.setDataArray(jsonJS);
						//数据源处理方式二：setDataJSON使用json格式数据
						myChart.setDataJSON("data.json");
						//数据源处理方式三：setDataXML使用xml格式数据
						//myChart.setDataXML("data.xml");
						myChart.setAxisNameX('商品名称',true);
						myChart.setAxisNameY('销量',true);
						myChart.setTitle("手机库存");
						myChart.setTitleColor('#6079ff');
						//myChart.colorizePie(colors);//设置pie颜色
						//myChart.setBarValuesColor('#9C1919');
						//myChart.colorizeBars(colors);
						//myChart.setPieUnitsColor(colors);
						myChart.draw(); 
		           });
		 
		}); 
   </script>
  </div>
    <div class="center">
     <iframe name="frame" width="100%" height="100%" style="border:0px;" src="home_dataShow_right.do"></iframe>
    </div>
  </body>
  
  
</html>
