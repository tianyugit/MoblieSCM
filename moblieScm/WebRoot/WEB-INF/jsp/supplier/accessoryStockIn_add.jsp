<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="js/sup/accessorystockin.js"> </script>
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
      
      	//alert(array1[k][1]);
        //    alert(html);  
        
        var input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "sns");
        input.setAttribute("type", "hidden");
        
        input.setAttribute("value", array1[k][1]);
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
		//alert(suptypeid);
		if("--请选择--" != suptypeid){
		//alert(suptypeid);
			//NO1)
			var ajax = createAJAX();
			//NO2)
			var method = "POST";
			var url = "accessoryStockIn_findSupplier.do?time="+new Date().getTime();
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
							option.setAttribute("value", item.supid);
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
        <my:navigation text="供应商业务 >>　配件入库  >> 新增入库单" percent="90"/>		
		<form action="accessoryStockIn_add.do" method="post" name="myform" onsubmit="getData()">
			<table class="inputTable" width="90%" align="center" style="margin-top:10px">
				<tr>
					<th colspan="2">
						增加配件入库信息
					</th>
                    <th>数量</th>
                    <th><input type="text" id="amountID" name="amount" value="0" class="text" style="width:100;border:none;background:none;font-weight:bold"
                            maxlength="6" readonly />
                    </th>
                    <th>总价</th>
                    <th><input id="totalmoneyID" name="totalmoney" readonly class="text" style="width:80px;border:none;background:none;font-weight:bold" value="0"/>
				</tr>
				<tr>
				<th>品牌名称</th>
					<td>
						<select name="asi.brand" class="text" style="width:100" onchange="brandreq(this)" >
							<option>请选择品牌</option>
							<c:forEach items="${brandList}" var="brand">
								<option value="${brand.brand}">${brand.brand}</option>
							</c:forEach>
						</select>
					</td>
					<th>配件类别</th>
					<td>
						<select name="asi.accessorytypeid" class="text" style="width:100" id="accTypeID">
							<option>请选择类型</option>
						</select>
					</td>
					<th>进价(单价)</th>
					<td>
						<input id="buypriceID" type="text" name="buyprice" value="" class="text" style="width:100"
							maxlength="8"/>
					</td>
					
					<!-- EB-BN916BBC -->
				</tr>

				<tr>
					<th>供应商类别</th>
					<td>
						  <select id="supTypeID" name="supTypeId" class="text" style="width:100px" onchange="find(this)">
            <option value="">--请选择--</option>
            <c:forEach items="${supTypeList}" var="supType">
                <option value="${supType.suptypeid}">${supType.suptypename}</option>
            </c:forEach>
          </select>
					</td>
					<th>供应商</th>
					<td>
						<select name="asi.supplierid" class="text" style="width:100" id="supplierID">
							<option value="">--请选择--</option>
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>
						备注
					</th>
					<td colspan="5">
						<textarea rows="2" cols="82" name="asi.remark"></textarea>
					</td>
				</tr>
			</table>
			<table id="tblSns"  class="table" width="90%" align="center" style="margin-top:10px">
				<tr>
						<th align="center" >
							序号
						</th>
						<th >
							SN码
						</th>
						
						<th>
							操作
						</th>
						<th>
							状态
						</th>
						
				</tr>
			</table>
			<table align="center" width="90%" class="inputTable" style="border-top:none">
				<tr>
					
					<th align="center">
						SN码</th>
					<th align="center">
						<input type="text" name="sn1" value="" class="text" maxlength="30"/>
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
				<input type="button" name="but2" value="返回" class="btn cancel" onclick="location='accessoryStockIn_list.do'"/>
			</div>
		</form>

	</body>
</html>
