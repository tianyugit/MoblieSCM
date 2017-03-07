<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script language="javascript"> 

   function test(id,value){
   	  $("#"+id).html(value.toFixed(2));
   }
</script> 
  </head>
 
  <body>
    <my:navigation text="配件库存 >>　汇总信息" percent="90"/>
    
    <table class="table" rowNum="15" width="500" align="center" >
      <tr>
        <th>机型编号</th>
        <th>总数量</th>
        <th>平均入库价</th>
        <th>平均成本价</th>
        <th>平均报损金额</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${countList}" var="c">
        <tr>
          <td >${c.accessorytypeid}
          	<%-- <c:forEach items="${accessorytypeList}" var="accType">
          		<c:if test="${c.accessorytypeid == accType.accessorytypeid}">${accType.typename}</c:if>           
            </c:forEach> --%>
          </td>
          <td>${c.amount}</td>
          
          <td id="b${c.accessorytypeid}"><%-- ${c.buyprice} --%>
           <script type="text/javascript">
           	 test('b${c.accessorytypeid}',${c.buyprice});
           </script>
          </td>
          
          <td id="a${c.accessorytypeid}"><%-- ${c.cost} --%>
           <script type="text/javascript">
           	 test('a${c.accessorytypeid}',${c.cost});
           </script>
        </td>
        
          <td id="c${c.accessorytypeid}"><%-- ${c.lossamount} --%>
          <script type="text/javascript">
           	 test('c${c.accessorytypeid}',${c.lossamount});
           </script>
          </td>
          
          <td><a href="accStock_showDetail.do?accessorytypeid=${c.accessorytypeid}">明细</a></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
