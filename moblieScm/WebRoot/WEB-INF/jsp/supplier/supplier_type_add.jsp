<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加供应商类别</title>
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
   <my:navigation text="基础管理 >>　供应商类别管理 >> 添加供应商类别" percent="90"/>
    <form action="supplierType_addType.do" method="post" onsubmit="return checkFrm();">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>类别编号：</th>
          <td><input class="easyui-validatebox text" name="supplierType.suptypeid" value="${supplierType.suptypeid}" 
            data-options="required:true,missingMessage:'类别编号不能为空'"/><my:errInfo key="typeId"/></td>
        </tr>
        <tr>
          <th>类别名称：</th>
          <td><input class="easyui-validatebox text" name="supplierType.suptypename" value="${supplierType.suptypename}" 
          data-options="required:true,missingMessage:'类别名称不能为空'"/></td>
        </tr>        
        <tr>
          <th>备注：</th>
          <td><textarea class="easyui-validatebox text" name="supplierType.remark" style="width:300px;height:46px">${supplierType.remark}</textarea></td>
        </tr>
      
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='supplierType_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
