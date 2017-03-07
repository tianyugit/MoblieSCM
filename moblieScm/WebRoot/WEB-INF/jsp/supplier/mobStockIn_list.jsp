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
				/*			var array = jsonJS.supList;
							
							var size = array.length;
							for(var i=0;i<size;i++){
								var supplier = array[i];
								var option = document.createElement("option");
								option.innerHTML = supplier;
								supplierElement.appendChild(option);
							}
							*/
						}
					}			
				}
			} 
    	};
		//document.getElementById(elementId) // getElementById("supTypeID").onchange = function(){
		//alert("dffdfdff");
		//};
		/* */
		function brandreq(o){
	   // alert("ccccccc");
	        var mobTypeElement = document.getElementById("mobTypeID");
	        mobTypeElement.options.length = 1;
	    	 $.post("mobStockIn_findMobType.do?time="+new Date().getTime(), {
	              'msi.brand': o[o.selectedIndex].value
	            }, function(data,textStatus){
	            //alert("cccccffcc");
	            //alert(data);
	            var jsonJS = eval(data);
				 $.each(jsonJS,function(idx,item){
					var mobtypename = item.mobtypename;
					//alert(mobtypename);
					var option = document.createElement("option");
					option.setAttribute('value',item.mobtypeid);
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
    <my:navigation text="供应商业务 >>　手机入库 >> 入库单列表" percent="90"/>
    <form action="mobStockIn_findMobStockIn.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
         <%--  <td>开始时间</td>
          <td><input class="text" style="width:80px" name="startDate" value="${my:fmtDate(startDate)}" readonly/></td>
          <td>结束时间</td>
          <td><input class="text" style="width:80px" name="endDate" value="${my:fmtDate(endDate)}" readonly/></td> --%>
          <td colspan="7"></td>
          <td rowspan="1" align="right">
            <input type="submit" class="btn find" value="查询" />      
            <input type="button" class="btn ok" style="width:90px" value="添加入库"
             onclick="location='mobStockIn_toAdd.do'"/>
          </td>
       </tr>
       <tr>
          <td>供应商类别</td>
          <td>
          <select id="supTypeID" name="supTypeId" class="text" style="width:80px" onchange="find(this)">
            <option value="">--不限--</option>
            <c:forEach items="${supTypeList}" var="supType">
                <option value="${supType.suptypeid}">${supType.suptypename}</option>
            </c:forEach>
          </select>
          </td>
          <td>供应商</td>
          <td>
            <select id="supplierID" name="supplierid" class="text" style="width:80px">
            <option value="">--不限--</option>
           <%--  <c:forEach items="${supList}" var="sup">
                <option value="${sup.supplierType.suptypeid}.${sup.supid}" >${sup.supname}</option>
            </c:forEach> --%>
          </select>
          </td>
          <td>品牌</td>
          <td>
          <select name="brand" class="text" style="width:80px" onchange="brandreq(this)">
            <option value="">--不限--</option>
            <c:forEach items="${brandList}" var="brand">
                <option value="${brand.brand}">${brand.brand}</option>
            </c:forEach>
          </select>
          </td>
          <td>手机型号</td>
          <td>
           <select name="mobtypeid" class="text" style="width:80px" id="mobTypeID">
            <option value="">--不限--</option>
            <%-- <c:forEach items="${mobTypeList}" var="mobType">
                <option value=""></option>
            </c:forEach> --%>
          </select>     
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>单据号码</th>
        <th>供应商</th>
        <th>机型</th>
        <th>颜色</th>
        <th>进价</th>
        <th>数量</th>
        <th>总金额</th>
        <th>录入人</th>
        <th>审核人</th>
        <th>状态</th>
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${mobStockInList}" var="msi">
        <tr>
          <td>${msi.invoiceid}</td>
          <td>
 			<c:forEach items="${supList}" var="sup">
          <c:if test="${msi.supplierid ==sup.supid}">${sup.supname}</c:if>           
            </c:forEach>
		  </td>
          <td><%-- ${msi.supTypeId} --%>
          <c:forEach items="${mobTypeList}" var="mobType">
          <c:if test="${msi.mobtypeid == mobType.mobtypeid}">${mobType.mobtypename}</c:if>           
            </c:forEach>
          </td>                   
          <td>${msi.color}</td>
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
          <td>${msi.statName}</td>
          <td>${msi.remark}</td>
          <td>          
              <a href="mobStockIn_showDetail.do?msi.invoiceid=${msi.invoiceid}">详情</a>
              <c:choose>
              <c:when test="${msi.status eq 0}">
                  <a href="mobStockIn_toEdit.do?msi.invoiceid=${msi.invoiceid}">修改</a>              
                  <a href="mobStockIn_delete.do?msi.invoiceid=${msi.invoiceid}">删除</a>
                  
          <c:if test="${loginUser.role == 'admin'}">
          <a href="mobStockIn_check.do?msi.invoiceid=${msi.invoiceid}">审核</a>
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
