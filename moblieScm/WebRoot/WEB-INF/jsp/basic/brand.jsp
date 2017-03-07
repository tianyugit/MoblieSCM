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
    <my:navigation text="基础设置 >>　品牌管理" percent="90"/>
    <form action="brand_addBrand.do" method="post">
      <table border="0" width="500" align="center" style="margin-top:10px">
        <tr>
          <td width="60" align="left">品牌:</td>
          <td width="180" align="left"><input name="brand.brand" class="text"/></td>
          <td align="left" width="80">
            <input type="submit" value="添加" class="btn ok" />
          </td>
          <td align="left"><my:errInfo key="dupBrand"/></td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="500" align="center" >
      <tr>
        <th>品牌</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${brandList}" var="brand">
        <tr>
          <td>${brand.brand}</td>
          <td>
              <c:url value="brand_delBrand.do" var="delUrl">
                <c:param name="brand" value="${brand.brand}"></c:param>
              </c:url>
              <a href="brand_delBrand.do?brand.brand=${brand.brand}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
