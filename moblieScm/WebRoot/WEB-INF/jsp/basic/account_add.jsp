<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="js/basic/supType.js"></script>
  </head>
  
  <body>
    <my:navigation text="基础设置 >>　账户管理 >> 添加账户" percent="90"/>
    <form action="account_addAcc.do" method="post" >
      <table width="500" align="center" style="margin-top:30px" class="inputTable">       
        <tr>
          <th>帐号编码：</th>
          <td><input class="text" name="account.accountid"  value="${account.accountid}"/></td>
        </tr>   
        <tr>
          <th>帐号名：</th>
          <td><input class="text" name="account.name"  value="${account.name}"/></td>
        </tr>   
        <tr>
          <th>余额：</th>
          <td><input class="text" name="account.balance"  value="${account.balance}"/></td>
        </tr>   
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="account.remark" style="width:300px;height:46px">${account.remark}</textarea></td>
        </tr>       
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='account_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
