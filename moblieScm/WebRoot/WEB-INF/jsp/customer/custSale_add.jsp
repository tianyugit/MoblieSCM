<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="js/sup/mobreturn.js"> </script>
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
      
      	//alert(array1[k][1] + "   "+array1[k][2]);
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
  </head>
  
	<body>
        <my:navigation text="客户业务 >>　手机销售  >> 新建销售单" percent="90"/>		
		<form action="custSale_add.do" method="post" name="myform"  onsubmit="getData()">
			<table class="inputTable" width="90%" align="center" style="margin-top:10px">
				<tr>
					<th colspan="2">
						新建手机销售单
					</th>
                    
                    
                    <th>客户:</th>
                    <th>
                    <input id="cc" name="custName">
                    <script type="text/javascript">
						$('#cc').combobox({
						mode: 'remote',   
					    url:'custSale_findCust.do',    
					    valueField:'id',    
					    textField:'text'   
					});
					</script>
                    </th>
                    <th>售价</th>
                    <th><input type="text" name="returnprice"  class="text" style="width:100;"
                            maxlength="6" />
                    </th>
                   <%--  <th>品牌名称</th>
                    <td>
						<select name="brand" class="easyui-combobox" style="width:100" >
							<c:forEach items="${brandList}" var="brand">
								<option value="${brand.brand}">${brand.brand}</option>
							</c:forEach>
						</select>
					</td> --%>
                    </tr>
				<%-- <tr>
					<th>供应商类别</th>
					<td>
						<select name="supTypeId" class="easyui-combobox" style="width:100">
							<c:forEach items="${supTypeList }" var="st">
								<option value="${st.suptypeid}">${st.suptypename}</option>
							</c:forEach>
						</select>
					</td>
					<th>供应商</th>
					<td>
						<select name="mobreturn.supplierid" class="easyui-combobox" style="width:100">
							<c:forEach items="${supList}" var="sup">
								<option value="${sup.supid }">${sup.supname}</option>
							</c:forEach>
						</select>
					</td>
					
						
					<th>机型</th>
					<td>
						<select name="mobreturn.mobtypeid" class="easyui-combobox"  style="width:100">
							<c:forEach items="${mobTypeList }" var="mobType">
								<option value="${mobType.mobtypeid }">${mobType.mobtypename}</option>
							</c:forEach>
						</select>
					</td>
				</tr> --%>
				<tr>
				
				<th>数量</th>
				<td>
				<input type="text" name="amount" value="0" class="text" style="width:100;border:none;background:none;font-weight:bold"
                            maxlength="6" readonly />
                            
                </td>
                
                    <th>总价</th>
                    <th><input name="totalmoney" readonly class="text" style="width:80px;border:none;background:none;font-weight:bold" value="0"/>
					<th></th>
					<th></th>
										
				</tr>
				
				<tr>
					<th>
						备注
					</th>
					<td colspan="7">
						<textarea rows="2" cols="82" name="mobreturn.remark"></textarea>
					</td>
				</tr>
			</table>
			<table id="tblSns"  class="table" width="90%" align="center" style="margin-top:10px">
				<tr>
						<th align="center" width="50">
							序号
						</th>
						<th >
							串号一
						</th>
						<th >
							串号二
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
					
					<th width="50">
						串号
					</th>
					<th width="220">
						<input type="text" name="sn1" value="" class="text" maxlength="30"/>
					</th>
					
                    <th align="left">
                        <input type="button" value="添加" class="btn ok" onclick="addSn();"> 
                    </th>
				</tr>
			</table>
			<br />
			<div align="center">
				<input type="submit" name="but1" value="保存" class="btn ok" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" name="but2" value="返回" class="btn cancel" onclick="location='custSale_list.do'"/>
			</div>
		</form>

	</body>
</html>
