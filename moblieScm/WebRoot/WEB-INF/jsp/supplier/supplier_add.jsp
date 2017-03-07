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
    <my:navigation text="基础设置 >>　供应商管理 >> 添加供应商" percent="90"/>
    <form action="supplier_addSupplier.do" method="post" onsubmit="return checkFrm();">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>供应商编号：</th>
          <td><input class="easyui-validatebox text" name="supplier.supid" 
          data-options="required:true,missingMessage:'供应商编号不能为空'" value="${supplier.supid}"/><my:errInfo key="supplierId"/></td>
        </tr>
        <tr>
          <th>供应商名称：</th>
          <td><input class="easyui-validatebox text" name="supplier.supname"
          data-options="required:true,missingMessage:'供应商名称不能为空'" value="${supplier.supname}"/></td>
        </tr> 
        <tr>
          <th>类别：</th>
          <td>
            <select name="supplier.supplierType.suptypeid">               
                <c:forEach items="${supplierTypeList}" var="stype">
                    <option value="${stype.suptypeid}"
                        <c:if test="${supplier.supplierType.suptypeid eq stype.suptypeid}">selected</c:if>
                    >${stype.suptypename}</option>
                </c:forEach>
            </select>
          </td>
        </tr> 
        <tr>
            <th>联系人：</th>
            <td><input class="easyui-validatebox text" name="supplier.linkman"
               data-options="required:true,missingMessage:'联系人不能为空'" value="${supplier.linkman}"/></td>
        </tr>      
        <tr>
            <th>电话：</th>
            <td><input class="easyui-validatebox text" name="supplier.tel"
             data-options="required:true,missingMessage:'电话不能为空'" value="${supplier.tel}"/></td>
        </tr>      
        <tr>
            <th>EMAIL：</th>
            <td><input class="easyui-validatebox text" name="supplier.email"
            data-options="required:true,validType:['email','length[0,100]'],missingMessage:'邮箱不能为空'" value="${supplier.email}"/></td>
        </tr>      
        <tr>
          <th>地址：</th>
          <td><textarea class="easyui-validatebox text" name="supplier.address"
           data-options="required:true,missingMessage:'地址不能为空'" style="width:300px;height:46px">${supplier.address}</textarea></td>
        </tr>
        <tr>
          <th>备注：</th>
          <td><textarea class="easyui-validatebox text" name="supplier.remark" style="width:300px;height:46px">${supplier.remark}</textarea></td>
        </tr>
      
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='supplier_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
