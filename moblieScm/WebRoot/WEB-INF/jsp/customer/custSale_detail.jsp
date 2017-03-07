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
        <th>串号一</th>
        <th>串号二</th>
        <th>供应商</th>
        <th>颜色</th>
        <th>配置</th>
        <th>进价</th>
       
        
      </tr>
      <c:forEach items="${detailList}" var="c">
        <tr>
          <td>${c.sn1}</td>
          <td>${c.sn2}</td>
          <td>
          <c:forEach items="${supList}" var="sup">
          		<c:if test="${c.fristsupplierid ==sup.supid}">${sup.supname}</c:if>           
          </c:forEach>
          </td>
          <td>${c.color}</td>
          <td>${c.config}</td>
          <td>${c.buyprice}</td>
         
        </tr>
      </c:forEach>
    </table>
    <button onclick="location='custSale_list.do'">返回</button>
    <%-- <button onclick="location='stoView_showDetail.do?accessorytypeid=${detailList[0].accessorytypeid}&detailType=excel'">导出EXCEL</button> --%>
  </body>
</html>
