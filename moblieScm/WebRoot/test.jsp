<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">   
    <link rel="stylesheet" type="text/css" href="themes/icon.css">   
    <script type="text/javascript" src="js/jquery.min.js"></script>   
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script> 
    <script type="text/javascript">
    	$(function(){
 	    // alert("dfdf2323");
 	    $.post("home_getMobStockData.do?time="+new Date().getTime(), {
	               'aa':'dsadas'
	            }, function(data){
	                alert("fdf");
	            });  
 	 
 	});
    </script>
  </head>
  
  <body>
   <!--  <select id="cc"  name="dept" style="width:200px;">   
    <option value="aa">aitem1</option>   
    <option>bitem2</option>   
    <option>bitem3</option>   
    <option>ditem4</option>   
    <option>eitem5</option>   
</select>  -->

    <script type="text/javascript">
    // Firefox, Google Chrome, Opera, Safari, Internet Explorer from version 9
        function OnInput (event) {
            alert ("The new content: " + event.target.value);
        }
    // Internet Explorer
        function OnPropChanged (event) {
            if (event.propertyName.toLowerCase () == "value") {
                alert ("The new content: " + event.srcElement.value);
            }
        }
    </script>
  
    <input type="text" class="easyui-combobox"  oninput="OnInput(event)" onpropertychange="OnPropChanged(event)" value="Text field" />
<br>
<input id="cc" name="dept" value="aa"> 
<script type="text/javascript">
/* 	$('#cc').combobox({
	mode: 'remote',   
    url:'custSale_findCust.do',    
    valueField:'id',    
    textField:'text'   
}); */
</script>


  </body>
</html>
