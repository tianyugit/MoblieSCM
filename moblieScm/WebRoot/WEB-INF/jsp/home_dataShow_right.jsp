<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 's.jsp' starting page</title>
    
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
  </head>
  
  <body>
   <div id="chartcontainer" style="margin-top: 100px;">这里将用来显示图形报表</div>
 	<script type="text/javascript">
 	
		 	 $(function(){
		    // alert("dfdf2323");
		    $.post("home_getMobStockData_right.do?time="+new Date().getTime(), {
		              'aa':'dsadas'
		           }, function(data){
		           		//var jsonJS = eval(data);
		           		//var myData = new Array();
		           		//myData[0]=jsonJS[0];
		               //第二个参数值有：line,bar,pie分别表示用线形图、柱状图、饼图来展示报表
						var myChart = new JSChart('chartcontainer', 'bar');
						//myChart.setDataArray(jsonJS);
						//数据源处理方式二：setDataJSON使用json格式数据
						myChart.setDataJSON("data_right.json");
						//数据源处理方式三：setDataXML使用xml格式数据
						//myChart.setDataXML("data.xml");
						myChart.setAxisNameX('商品名称',true);
						myChart.setAxisNameY('销量',true);
						myChart.setTitle("手机销售");
						myChart.setTitleColor('#6079ff');
						myChart.draw(); 
		           });
		 
		}); 
   </script>
  </body>
</html>
