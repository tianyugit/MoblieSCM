<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
  </head>
 
  <body>
    <my:navigation text="基础设置 >>　供应商管理 >> 供应商列表" percent="90"/>
    <form action="supplier_findSupplier.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td width="70px">供应商类别:</td>
          <td width="130px">
            <select name="supplier.supplierType.suptypeid">
                <option value="">--全部类别--</option>
                <c:forEach items="${supplierTypeList}" var="supplierType">
                    <option  value="${supplierType.suptypeid}"
                        <c:if test="${supplier.supplierType.suptypeid eq supplierType.suptypeid}">selected</c:if>
                    >${supplierType.suptypename}</option>
                </c:forEach>
            </select>
          </td>
          <td width="70px">供应商名称:</td>
          <td><input class="text" name="supplier.supname" value="${supplier.supname}"/><input type="submit" class="btn find" value="查询" style="margin-left: 20px"></td>
          <td align="right">   
                  
            <input type="button" class="btn ok" style="width:90px" value="添加供应商"
             onclick="location='supplier_toAdd.do'"/>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>供应商编号</th>
        <th>供应商名称</th>
        <th>类别</th>
        <th>联系人</th>
        <th>电话</th>
        <th>EMAIL</th>
        <th>地址</th>
        <th>备注</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${supplierList}" var="supplier">
        <tr>
          <td>${supplier.supid}</td>
          <td>${supplier.supname}</td>
          <td>
         
           <c:forEach items="${supplierTypeList}" var="stype">        
         	 <c:if test="${supplier.supplierType.suptypeid eq stype.suptypeid}">
          		${stype.suptypename}
         	 </c:if>
           </c:forEach>
          </td>
          <td>${supplier.linkman}</td>
          <td>${supplier.tel}</td>
          <td>${supplier.email}</td>
          <td>${supplier.address}</td>
          <td>${supplier.remark}</td>
          <td>          
              <a href="supplier_toEdit.do?supplier.supid=${supplier.supid}">编辑</a>
              <a href="supplier_delSupplier.do?supplier.supid=${supplier.supid}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    ${pagination.naviHtml}
  </body>
</html>
