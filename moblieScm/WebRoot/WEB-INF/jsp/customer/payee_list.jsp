<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <%@ include file="/WEB-INF/jsp/include/datepicker.jsp" %>
    
     <script type="text/javascript">
    //创建AJAX异步对象，即XMLHttpRequest
	function createAJAX(){
		var ajax = null;
		try{
			ajax = new ActiveXObject("microsoft.xmlhttp");
		}catch(e1){
			try{
				ajax = new XMLHttpRequest();
			}catch(e2){
				alert("你的浏览器不支持ajax，请更换浏览器");
			}
		}
		return ajax;
	};
    	function find(o){
    	
    		//清空城市下拉框
			var supplierElement = document.getElementById("supplierID");
			supplierElement.options.length = 1;
			
			var suptypeid = o[o.selectedIndex].value;
			
			if("--不限--" != suptypeid){
			//alert(suptypeid);
				//NO1)
				var ajax = createAJAX();
				//NO2)
				var method = "POST";
				var url = "mobStockIn_findSupplier.do?time="+new Date().getTime();
				ajax.open(method,url);
				//NO3)
				ajax.setRequestHeader("content-type","application/x-www-form-urlencoded")
				//NO4)
				var content = "supplierType.suptypeid=" + suptypeid;
				ajax.send(content);
				
				//-------------------------------------------等待
				
				//NO5
				ajax.onreadystatechange = function(){
					if(ajax.readyState == 4){
						if(ajax.status == 200){
							//NO6)返回JAVA格式的JSON文本
							var jsonJAVA = ajax.responseText;
							//alert(jsonJAVA);
							//p所代表的是java格式的json文本，是不能直接被js执行的
							//解决方案：将java格式的json文本，转成js格式的json文本
							//如何做：用js提供的一个函数搞定
							var jsonJS = eval(jsonJAVA);
							 $.each(jsonJS,function(idx,item){
								var supplier = item.supname;
								var option = document.createElement("option");
								option.setAttribute('value',item.supid);
								option.innerHTML = supplier;
								supplierElement.appendChild(option);
								//alert(item.supname);
							
							}); 
						}
					}			
				}
			} 
    	};
		
	</script>
  </head>
 
  <body>
    <my:navigation text="客户业务 >>　收款 >> 收款单列表" percent="90"/>
    <form action="pay_findPaymentByCust.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px"><tr>
      <%-- <td>客户类别</td>
          <td>
          <select name="supTypeId" class="text" style="width:80px" onchange="find(this)">
             <option value="">--全部类别--</option>
                <c:forEach items="${customertypeList}" var="ctype">
                    <option value="${ctype.custtypeid}" >${ctype.custtypename}</option>
                </c:forEach>
          </select>
          </td> --%>
         <td>客户</td>
          <td>
           <%--  <input class="text" name="customer.custname" value="${custPayee.custname}"/> --%>
          </td>
          <td align="right">
            <input type="submit" class="btn find" value="查询" />      
            <input type="button" class="btn ok" style="width:90px" value="收款"
             onclick="location='payee_toAdd.do'"/>
          </td>
       </tr>
       </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>单据号码</th>
        <th>客户</th>
        <th>收款帐户</th>
        <th>收款金额</th>        
        <th>录入人</th>
        <th>审核人</th>
        <th>状态</th>
        <th>备注</th>
        <!-- <th>机构</th> -->
        <th>操作</th>
      </tr>
      <c:forEach items="${custPayeeList}" var="cp">
        <tr>
          <td>${cp.invoiceid}</td>
          <td><%--  ${cp.custid }  --%>
           <c:forEach items="${customerList}" var="cust">
          	<c:if test="${cust.custid == cp.custid}">${cust.custname}</c:if>           
          </c:forEach>
          
          </td>
          <td>${cp.payaccount}</td>                   
          <td>${cp.incomemoney}</td>
          <td><%-- ${mr.inputuserid} --%>
          <c:forEach items="${userList}" var="user">
          <c:if test="${user.userid == cp.inputuserid}">${user.account}</c:if>           
            </c:forEach>
          </td>
          <td><%-- ${cp.checkuserid} --%>
           <c:forEach items="${userList}" var="user">
          <c:if test="${user.userid == cp.checkuserid}">${user.account}</c:if>           
            </c:forEach>
          </td>
          <td>
          <c:if test="${cp.status == 0}">未审核</c:if>
          <c:if test="${cp.status == 1}">已审核</c:if>
          </td>
          <td>${cp.remark}</td>
         <%-- <td> ${mr.orgid} </td>--%>
          <td>          
              <!-- <a href="#">详情</a> -->
              <c:choose>
                  <c:when test="${cp.status eq 0}">
                      <a href="payee_toEdit.do?custPayee.invoiceid=${cp.invoiceid}">修改</a>              
                      <a href="payee_delete.do?custPayee.invoiceid=${cp.invoiceid}">删除</a>
                      <c:if test="${loginUser.role == 'admin'}">
                        <a href="payee_check.do?custPayee.invoiceid=${cp.invoiceid}">审核</a>
                      </c:if>
                  </c:when>
                  <c:otherwise>
                     <span style="color:gray">修改</span>
                     <span style="color:gray">删除</span>
                     <span style="color:gray">审核</span>
                  </c:otherwise>
              </c:choose>   
              
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
