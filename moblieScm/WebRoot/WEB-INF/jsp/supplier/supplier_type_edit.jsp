<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
    <script type="text/javascript" src="js/basic/supplierType.js"></script>
  </head>
  
  <body>
    <my:navigation text="基础设置 >>　供应商类别管理 >> 编辑类别" percent="90"/>
    <form action="supplierType_editType.do" method="post" onsubmit="return checkFrm();">
      <table width="500" align="center" style="margin-top:30px" class="inputTable">
        <tr>
          <th>类别编号：</th>
          <td><input type="hidden" name="supplierType.suptypeid" value="${supplierType.suptypeid}"/>${supplierType.suptypeid}</td>
        </tr>
        <tr>
          <th>类别名称：</th>
          <td><input class="text" name="supplierType.suptypename" value="${supplierType.suptypename}"/></td>
        </tr>        
        <tr>
          <th>备注：</th>
          <td><textarea class="text" name="supplierType.remark" style="width:300px;height:46px"/>${supplierType.remark}</textarea></td>
        </tr>
      
      </table>
      <table border="0" width="500" align="center" style="margin-top:20px">
        <tr><td align="center">
          <input type="submit" class="btn ok" value="确定" />
          <input type="button" class="btn cancel" value="取消" onclick="location='supplierType_list.do'"/>
        </td></tr>
      </table>
    </form>    
  </body>
</html>
