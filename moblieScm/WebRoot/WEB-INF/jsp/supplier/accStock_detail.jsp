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
    <my:navigation text="配件入库 >>　明细信息" percent="90"/>
    
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>机型编号</th>
        <th>SN码</th>
       
        
      </tr>
      <c:forEach items="${detailList}" var="c">
        <tr>
          <td>${c.id}</td>
          <td>${c.sn}</td>
          
         
        </tr>
      </c:forEach>
    </table>
    <button onclick="location='accessoryStockIn_list.do'">返回</button>
    <%-- <button onclick="location='stoView_showDetail.do?accessorytypeid=${detailList[0].accessorytypeid}&detailType=excel'">导出EXCEL</button> --%>
  </body>
</html>
