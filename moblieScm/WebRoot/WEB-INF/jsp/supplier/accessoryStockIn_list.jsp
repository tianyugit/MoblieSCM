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
        $().ready(function() {
            $("input[name=startDate]").datepicker();
            $("input[name=endDate]").datepicker();
            
          /*   $("select[name=supTypeId]").relate($("select[name=supplierid]"));
            $("select[name=brand]").relate($("select[name=mobtypeid]")); */
            
        });
    </script>
    
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
    	
		function brandreq(o){
	   // alert("ccccccc");
	        var mobTypeElement = document.getElementById("accTypeID");
	        mobTypeElement.options.length = 1;
	    	 $.post("accessoryStockIn_findaccType.do?time="+new Date().getTime(), {
	              'asi.brand': o[o.selectedIndex].value
	            }, function(data,textStatus){
	            //alert("cccccffcc");
	            //alert(data);
	            var jsonJS = eval(data);
				 $.each(jsonJS,function(idx,item){
					var mobtypename = item.typename;
					//alert(mobtypename);
					var option = document.createElement("option");
					option.setAttribute('value',item.accessorytypeid);
					option.innerHTML = mobtypename;
					mobTypeElement.appendChild(option);
	               /*  if (data.length == 0) {
	                    $("#refPrice").html("参考值未设置");
	                }
	                else {
	                    $("#refPrice").html(parseFloat(data).toFixed(2));
	                } */
	                }); 
	            });  
	    }
	</script>
  </head>
 
  <body>
    <my:navigation text="供应商业务 >>　配件入库 >> 入库单列表" percent="90"/>
    <form action="accessoryStockIn_findaccTypeByselected.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
         <%--  <td>开始时间</td>
          <td><input class="text" style="width:80px" name="startDate" value="${my:fmtDate(startDate)}" readonly/></td>
          <td>结束时间</td>
          <td><input class="text" style="width:80px" name="endDate" value="${my:fmtDate(endDate)}" readonly/></td> --%>
          
          
       </tr>
       <tr>
          <td>品牌:</td>
          <td>
          <select name="brand" class="text" style="width:80px" onchange="brandreq(this)">
            <option value="">--不限--</option>
            <c:forEach items="${brandList}" var="brand">
                <option value="${brand.brand}">${brand.brand}</option>
            </c:forEach>
          </select>
          </td>
          <td> 配件型号:</td>
          <td>
           <select name="acctypeid" class="text" style="width:80px" id="accTypeID">
            <option value="">--不限--</option>
            <c:forEach items="${mobTypeList}" var="mobType">
                <option value=""></option>
            </c:forEach>
          </select>    
          </td>
          <td rowspan="1" align="right">
            <input type="submit" class="btn find" value="查询" />      
            <input type="button" class="btn ok" style="width:90px" value="添加入库"
             onclick="location='accessoryStockIn_toAdd.do'"/>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>单据号码</th>
        <th>供应商</th>
        <th>配件类型</th>
        <th>品牌</th>
        <th>进价</th>
        <th>数量</th>
        <th>总金额</th>
        <th>录入人</th>
        <th>审核人</th>
        <th>状态</th>
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${accStockInList}" var="msi">
        <tr>
          <td>${msi.invoiceid}</td>
          <td>
 			<c:forEach items="${supList}" var="sup">
          <c:if test="${msi.supplierid ==sup.supid}">${sup.supname}</c:if>           
            </c:forEach>
		  </td>
		   <td>
		   
          <c:forEach items="${accessorytypeList}" var="accType">
          <c:if test="${msi.accessorytypeid == accType.accessorytypeid}">${accType.typename}</c:if>           
            </c:forEach>
          </td> 
		  <td>${msi.brand}</td>
		  <td>${msi.buyprice}</td>
		   <td>${msi.amount}</td>
          <td>${msi.totalmoney}</td>
          <td>
          <c:forEach items="${userList}" var="user">
          <c:if test="${user.userid == msi.inputuserid}">${user.account}</c:if>           
            </c:forEach>
          </td>
          <td><%-- ${msi.checkUserName} --%>
           <c:forEach items="${userList}" var="user">
          <c:if test="${user.userid == msi.checkuserid}">${user.account}</c:if>           
            </c:forEach>
          </td>
          <td>
          <c:if test="${msi.status == 0}">未审核</c:if>
          <c:if test="${msi.status == 1}">已审核</c:if>
          </td>
          <td>${msi.remark}</td>
          <td>          
              <a href="accessoryStockIn_showDetail.do?asi.invoiceid=${msi.invoiceid}">详情</a>
              <c:choose>
              <c:when test="${msi.status eq 0}">
                  <a href="#">修改</a>              
                  <a href="accessoryStockIn_delete.do?asi.invoiceid=${msi.invoiceid}">删除</a>
                  
          <c:if test="${loginUser.role == 'admin'}">
          <a href="accessoryStockIn_check.do?asi.invoiceid=${msi.invoiceid}">审核</a>
          </c:if>                     
                 <%--  <my:privShow action="mobStockIn_check.do">
                    <a href="mobStockIn_check.do?invoiceid=${msi.invoiceid}">审核</a>
                  </my:privShow> --%>
              </c:when>
              <c:otherwise>
                 <span style="color:gray">修改</span>
                 <span style="color:gray">删除</span>
                <%--  <my:privShow action="mobStockIn_check.do">
                    <span style="color:gray">审核</span>
                  </my:privShow> --%>
              </c:otherwise>
              </c:choose>   
              
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
