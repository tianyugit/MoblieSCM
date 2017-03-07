<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="js/basic/account.js"></script>
  </head>
  
  <body>
    <my:navigation text="供应商业务 >>　付款 " percent="90"/>
    <form action="pay_add.do" method="post" >
      <table width="500" align="center" style="margin-top:30px" class="inputTable">    
        
        <tr>
          <th>供应商：</th>
          <td>
            <select name="payment.supplierid" class="text">
                <c:forEach items="${supplierList}" var="sup">
                    <option value="${sup.supid}">${sup.supname}</option>
                </c:forEach>
            </select>
          </td>
        </tr>  
        <tr>
          <th>付款帐户：</th>
          <td>
          <select name="payment.accountid" class="text">
                <c:forEach items="${accountList}" var="acc">
                    <option value="${acc.accountid}">${acc.name}</option>
                </c:forEach>
            </select>
          </td>
        </tr>
        <tr>
          <th>金额：</th>
          <td><input class="text" name="payment.paymoney" /></td>
        </tr>    
        <!-- <tr>
            <th>是否计算现金返利</th>
            <td>
                <input type="checkBox" value="1" name="isCashPay" class="text"/>
            </td>
        </tr> --> 
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="payment.remark" style="width:300px;height:46px"/></textarea></td>
        </tr>       
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='pay_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
