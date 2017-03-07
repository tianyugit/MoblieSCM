<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@include file="/WEB-INF/jsp/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改用户</title>
    
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
    <form id="myForm" method="post">
      <table width="500" align="center" style="margin-top:30px">
      	<tr align="center"><td>${msg}</td></tr>
      </table>
      <table width="500" align="center"  class="inputTable">
      
        <tr>
          <th>用户名：</th>
          <td>
          <input type="hidden" name="user.userid" value="${user.userid}">
          <input  class="easyui-validatebox text" name="user.account" value="${user.account}" 
          data-options="required:true,missingMessage:'用户名不能为空'"/></td>
        </tr>
        <tr>
          <th>密码：</th>
          <td><input id="pwd" type="password" class="easyui-validatebox text" 
          name="user.passwd" value="${user.passwd}" data-options="required:true,missingMessage:'密码不能为空',validType:['wordOrFigure','lengthCheck']" /></td>
        </tr>
        <tr>
          <th>角色：</th>
          <td><%-- <input id="pwd" type="text" value="${user.role}" class="easyui-validatebox text" 
          name="user.role" data-options="required:true,missingMessage:'角色不能为空'" /> --%>
          <c:if test="${user.role=='user'}">
          <input name="user.role" type="radio"  value="admin">管理员
          <input name="user.role" type="radio" checked="checked" value="user">用户
          </c:if>
          <c:if test="${user.role=='admin'}">
          <input name="user.role" type="radio" checked="checked" value="admin">管理员
          <input name="user.role" type="radio"  value="user">用户
          </c:if>
          </td>
        </tr>
        <tr>
          <th>状况：</th>
          <td>
          
          <c:if test="${user.status==1}">
          <input name="user.status" type="radio" checked="checked" value="1">启用
           <input name="user.status" type="radio" value="0">停用</td>
          </c:if>
          <c:if test="${user.status==0}">
          <input name="user.status" type="radio" value="1">启用
          <input  name="user.status" type="radio" checked="checked" value="0">停用</td>
          </c:if>
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
          <input type="button" class="btn cancel" value="取消" onclick="location='user_list.do'"/>
        </td></tr>
      </table>
    </form>
    <script type="text/javascript">
   		 $('#myForm').form({    
		    url:"user_updateUser.do",    
		    onSubmit: function(){    
		        return $(this).form('validate');   
		    },    
		    success:function(data){    
		        window.location.href='user_list.do';   
		    }    
		});
    </script>
  </body>
</html>
