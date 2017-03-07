<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
     <script type="text/javascript">
		//定位所有的button按钮，同时提供单击事件
		$(function(){
			//获取value属性值
			var tip ='${message}';
			//alert(tip);
			//去空格
			//tip = $.trim(tip);
			//如果警告框的话
			if(tip == "OK"){
				$.messager.alert("警告框","您不能删除,该类别下有客户!!","warning",function(){
					<%  session.removeAttribute("message");  %>
				});
			}
		});	
	</script>
  </head>
 
  <body>
    <my:navigation text="基础设置 >>　客户类别管理 >> 类别列表" percent="90"/>    
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr> 
          <td align="right">            
            <input type="button" class="btn ok" style="width:90px" value="添加类别"
             onclick="location='custType_toAdd.do'"/>
          </td>
        </tr>
      </table>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>类别编号</th>        
        <th>类别名称</th>        
        <th>类别折算</th>        
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${customerTypeList}" var="custType">
        <tr>
          <td>${custType.custtypeid}</td>
          <td>${custType.custtypename}</td>          
          <td>${custType.discount * 10}折</td>          
          <td>${custType.remark}</td>          
          <td>
              <a href="custType_toEdit.do?custType.custtypeid=${custType.custtypeid}">编辑</a>
              <a href="custType_delType.do?custType.custtypeid=${custType.custtypeid}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
