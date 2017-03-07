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
    <my:navigation text="配件库存 >>　明细信息" percent="90"/>
    
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>机型编号</th>
        <th>SN码</th>
       
        <th>进价</th>
      </tr>
      <c:forEach items="${detailList}" var="c">
        <tr>
          <td>${c.accessorytypeid}</td>
          <td>${c.sn}</td>
          
          <td>${c.buyprice}</td>
        </tr>
      </c:forEach>
    </table>
    <button onclick="location='accStock_list.do'">返回</button>
    <button onclick="location='accStock_downloadExcel.do?accessorytypeid=${detailList[0].accessorytypeid}'">导出EXCEL</button>
  </body>
</html>
