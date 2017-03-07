<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="js/sup/mobstockin.js"> </script>
     <script type="text/javascript">
        //初始化返利价格数组
        <c:forEach items="${mobBonusList}" var="bonus">
            parameter["mobType.bonusList"].push({
                bonusTypeId:'${bonus.bonusTypeId}',
                bonusTypeName:'${bonus.typename}',
                bonusPrice:${bonus.money}
            });
        </c:forEach>
    </script>
    <script type="text/javascript">  
    function getData() { 
   
        var array1 =  new Array();
        var i = 0;  
        $('.table').find('tr').each(function () { 
         
           array1[i] =  new Array();
           var j = 0;
          $(this).find('td').each(function () {  
          
                array1[i][j]= $(this).text();  
              
            	 j++;
           })  ;
          
           // html += '|';  
      
         i++;
     
        });
        
        var form = document.myform;
      for(var k = 1 ; k < array1.length;k++){
      
      //	alert(array1[k][1] + "   "+array1[k][2]);
        //    alert(html);  
        
        var input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "sns");
        input.setAttribute("type", "hidden");
        
        input.setAttribute("value", array1[k][1] + ","+array1[k][2]);
      	form.append(input);
      }
        
        return true;
    }

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
    </script>
  </head>
  
	<body>
        <my:navigation text="供应商业务 >>　手机入库  >> 新增入库" percent="90"/>		
		<form action="mobStockIn_edit.do" method="post" name="myform" onsubmit="getData()">
			<table class="inputTable" width="90%" align="center" style="margin-top:10px">
				<tr>
					<th colspan="4">
						增加手机入库信息
					</th>
                    <th>数量</th>
                    <th>
                    <input type="hidden" name="msi.invoiceid" value="${ msi.invoiceid}">
                    <input id="amount" type="text" name="amount" value="${msi.amount}" class="text" style="width:100;border:none;background:none;font-weight:bold"
                            maxlength="6" readonly />
                    </th>
                    <th>总价</th>
                    <th><input name="totalmoney" readonly class="text" style="width:80px;border:none;background:none;font-weight:bold" value="${msi.totalmoney}"/>
				</tr>
				<tr>
					<th>供应商类别</th>
					<td>
						<select name="msi.supTypeId" class="text" style="width:100" onchange="find(this)">
						<option>选择类别</option>
							<c:forEach items="${supTypeList }" var="st">
								<option value="${st.suptypeid}">${st.suptypename}</option>
								
							</c:forEach>
						</select>
					</td>
					<th>供应商</th>
					<td>
						<select name="msi.supplierid" class="text" style="width:100" id="supplierID">
						<option value="">选择供应商</option>
							<c:forEach items="${supList}" var="sup">
								<%-- <option value="${sup.supid}">${sup.supname}</option> --%>
								 <option value="${sup.supid}"
                        <c:if test="${sup.supid eq msi.supplierid}">selected</c:if>
                    >${sup.supname}</option>
							</c:forEach>
						</select>
					</td>
					<th>品牌名称</th>
					<td>
						<select name="msi.brand" class="text" style="width:100" onchange="brandreq(this)" >
						<option>请选择品牌</option>
							<c:forEach items="${brandList}" var="brand">
								<option value="${brand.brand}">${brand.brand}</option>
							</c:forEach>
						</select>
					</td>	
					<th>机型</th>
					<td>
						<select name="mobtypeid" class="text"  style="width:100" id="mobTypeID">
						<option>选择机型</option>
							 <c:forEach items="${mobTypeList }" var="mobType">
								<%-- <option value="${mobType.brand}.${mobType.mobtypeid }">${mobType.mobtypename}</option> --%>
									 <option value="${mobType.mobtypeid}"
                        <c:if test="${mobType.mobtypeid eq msi.mobtypeid}">selected</c:if>
                    >${mobType.mobtypename}</option>
							</c:forEach>
						</select>
					</td>
				</tr>

				<tr>
					<th>配置</th>
					<td>
						<select name="msi.config" class="text" style="width:100">
							<c:forEach items="${configList}" var="con">
								<option value="${con.config}"
								<c:if test="${con.config eq msi.config}">selected</c:if>
								>${con.config}</option>
							</c:forEach>
						</select>
					</td>
					<th>进价(单价)</th>
					<td>
						<input type="text" name="buyprice" class="text" style="width:100"
							maxlength="8" value="${msi.buyprice}"/>
					</td>
                    <th>参考价</th>
                    <td>
                        <span id="refPrice"></span>
                    </td>
					<th>
						颜色
					</th>
					<td>
						<select name="msi.color" class="text" style="width:100">
							<c:forEach items="${colorList }" var="color">
								<option value="${color.color}"
								<c:if test="${color.color eq msi.color}">selected</c:if>
								>${color.color}</option>
							</c:forEach>
						</select>
					</td>
					
				</tr>
				<tr>
					<th>
						备注
					</th>
					<td colspan="7">
						<textarea rows="2" cols="82" name="msi.remark">${msi.remark}</textarea>
					</td>
				</tr>
			</table>
			<table id="tblSns"  class="table" width="90%" align="center" style="margin-top:10px">
				<tr>
						<th align="center" width="50">
							序号
						</th>
						<th width="250">
							串号一
						</th>
						<th width="250">
							串号二
						</th>
						<th>
							操作
						</th>
						<th>
							状态

						</th>
				</tr>
				 <script type="text/javascript">
			    function delPrice2(id){
			    //alert(id);
				//删除表格行
			    $("tr[lineId=" + id + "]").remove();
				
			}
   		 </script>
				<c:forEach items="${detailList}" var="sn" varStatus="i">
                <tr lineId="${sn.id}">
                <td >${i.count}</td>
                <td>${sn.sn1}</td>
                <td>${sn.sn2}</td>
                <td><a href="#" onclick="delPrice2('${sn.id}')">删除</a></td>
                <td>OK</td>
            </tr>
        </c:forEach>
			</table>
			<table align="center" width="90%" class="inputTable" style="border-top:none">
				<tr>
					<th width="245">
						<input type="radio" name="setSn" checked value="single" onclick="single1();"/>
							单串号

						<input type="radio" name="setSn" value="double" onclick="double1();"/>
							双串号

					</th>
					<th width="50">
						串号一
					</th>
					<th width="220">
						<input type="text" name="sn1" value="" class="text" maxlength="30"/>
					</th>
					<th width="50">
						串号二
					</th>
					<th>
						<input type="text" name="sn2" value="" class="text" maxlength="30" disabled style="background-color:gray"/>						
					</th>
                    <th align="center">
                        <input type="button" value="添加" class="btn ok" onclick="addSn();"> 
                    </th>
				</tr>
			</table>
			<br />
			<div align="center">
				<input type="submit" name="but1" value="保存" class="btn ok" onclick="" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" name="but2" value="返回" class="btn cancel" onclick="location='mobStockIn_list.do'"/>
			</div>
		</form>

	</body>
</html>
