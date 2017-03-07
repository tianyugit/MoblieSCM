<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册新用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %> 
    
    <script type="text/javascript">
    	// extend the 'equals' rule    
$.extend($.fn.validatebox.defaults.rules, {    
    equals: {    
        validator: function(value,param){    
            return value == $(param[0]).val();    
        },          
        message: '密码不一致,请重新输入.'   
    } ,
    minLength: {    
        validator: function(value, param){    
            return value.length >= param[0];    
        },    
        message: '请输入至少 {0}个字母或数字.'   
    },
     lengthCheck: {    
        validator: function(value, param){ 
        if(value.length >= 6 && value.length <=12)   
            return true;    
        },    
        message: '请输入6到12个字母或数字.'   
    },
    wordOrFigure: {  
		        validator: function(value){   
		        	if(/^[0-9&&a-zA-Z]*$/.test(value)){
			            return true;    
		        	}
		        }, 
		        message: '密码必须为字母或数字'   
		    },
});  
    	
    </script>
  
  	
  </head>
  
  <body>
    <form id="myForm"  method="post">
      <table width="500" align="center" style="margin-top:30px">
      	<tr align="center"><td>${msg}</td></tr>
      </table>
      <table width="500" align="center"  class="inputTable">
      
        <tr>
          <th>用户名：</th>
          <td><input  class="easyui-validatebox text" name="user.account" value="${user.account}" 
          data-options="required:true,missingMessage:'用户名不能为空',validType:'minLength[6]'"/></td>
        
        </tr>
        
        <tr>
          <th>密码：</th>
          <td><input id="pwd" prompt="请输入密码" class="easyui-passwordbox text"
          name="user.passwd" data-options="required:true,missingMessage:'密码不能为空',validType:['wordOrFigure','lengthCheck']" /></td>
        </tr>
        <tr>
          <th>确认密码：</th>
          <td><input prompt="请再输入密码" class="easyui-passwordbox text"
          data-options="required:true,missingMessage:'密码不能为空'" validType="equals['#pwd']"  /></td>
        </tr>
        <tr>
          <th>邮箱：</th>
          <td><input id="emailID" class="easyui-validatebox text" name="user.email" 
          value="${user.email}" data-options="required:true,validType:['email','length[0,100]']
,missingMessage:'邮箱不能为空'" />  
</td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="user.remark" style="width:200px;height:46px">${user.remark}</textarea></td>
        </tr>
      
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='start.do'"/>
        </td></tr>
      </table>
    </form>
     <script type="text/javascript">
   		/*   $('#myForm').form({    
		        
		    onSubmit: function(){    
		        return $(this).form('validate');   
		    },    
		    success:function(data){    
		       // window.location.href='start.do';   
		    }    action="userManage_addUser.do"
		}); */
		$('#myForm').form('submit', {  
	   url:"userManage_addUser.do",
	   novalidate:true,  
       success: function(data){    
        /* var data = eval('(' + data + ')');  // change the JSON string to javascript object    
        if (data.success){    
            alert(data.message)    
        }   */  
    }    
});  
    </script>
  </body>
</html>
