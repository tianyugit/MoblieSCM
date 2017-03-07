<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="js/basic/supplier.js"></script>
  </head>
  
  <body>
    <my:navigation text="基础设置 >>　客户管理  >> 修改客户" percent="90"/>
    <form action="cust_editCustomer.do" method="post" onsubmit="return checkFrm();">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>客户编号：</th>
          <td><input type="hidden" name="customer.custid" value="${customer.custid}"/>${customer.custid}</td>
        </tr>
        <tr>
          <th>客户名称：</th>
          <td><input class="text" name="customer.custname" value="${customer.custname}"/></td>
        </tr> 
        <tr>
          <th>类别：</th>
          <td>
            <select class="text" name="customer.customerType.custtypeid">               
                <c:forEach items="${customerTypeList}" var="ctype">
                    <option value="${ctype.custtypeid}"
                        <c:if test="${customer.customerType.custtypeid eq ctype.custtypeid}">selected</c:if>
                    >${ctype.custtypename}</option>
                </c:forEach>
            </select>
          </td>
        </tr> 
        <tr>
            <th>联系人：</th>
            <td><input class="text" name="customer.linkman" value="${customer.linkman}"/></td>
        </tr>      
        <tr>
            <th>电话：</th>
            <td><input class="text" name="customer.tel" value="${customer.tel}"/></td>
        </tr>      
        <tr>
            <th>传真</th>
            <td><input class="text" name="customer.fax" value="${customer.fax}"/></td>
        </tr>
        <tr>
            <th>EMAIL：</th>
            <td><input class="text" name="customer.email" value="${customer.email}"/></td>
        </tr>      
        <tr>
          <th>地址：</th>
          <td><textarea class="text" name="customer.address" style="width:300px;height:46px">${customer.address}</textarea></td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="customer.remark" style="width:300px;height:46px">${customer.remark}</textarea></td>
        </tr>
      
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='cust_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
