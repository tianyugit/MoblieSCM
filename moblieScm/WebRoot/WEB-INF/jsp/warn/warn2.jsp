<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>警告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 引入css文件，不限顺序 -->
    <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
    <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
  
  	<!-- 引入js文件，有顺序限制 -->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  </head>
  
  <body>
    <div id="w" class="easyui-window" title="警告" style="width:500px;height:200px;top:20%;padding:10px;"
    data-options="iconCls:'icon-save',collapsible:false,minimizable:false,maximizable:false,closable:false,draggable:false,resizable:false" >
		<font size="5">很抱歉,您的账户已停用,请联系管理员!!</font>
	</div>
  </body>
</html>
