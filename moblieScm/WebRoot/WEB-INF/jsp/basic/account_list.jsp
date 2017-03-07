<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
  </head>
 
  <body>
    <my:navigation text="基础设置 >>　帐号管理 >> 帐号列表" percent="90"/>    
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr> 
          <td align="right">            
            <input type="button" class="btn ok" style="width:90px" value="添加帐号"
             onclick="location='account_toAdd.do'"/>
          </td>
        </tr>
      </table>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>       
        <th>帐号编码</th>
        <th>名称</th>        
        <th>余额</th>        
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${accountList}" var="account">
        <tr>          
          <td>${account.accountid}</td>          
          <td>${account.name}</td>          
          <td>${account.balance}</td>          
          <td>${account.remark}</td>          
          <td>
          <c:if test="${loginUser.role == 'admin'}">
              <a href="account_toEdit.do?account.accountid=${account.accountid}">编辑</a>
              <a href="account_delAcc.do?account.accountid=${account.accountid}" onclick="return confirm('确定要删除吗？');">删除</a>
         </c:if>
         <c:if test="${loginUser.role == 'user'}">
          <span style="color:gray">编辑</span>
          <span style="color:gray">删除</span>
         </c:if>
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
