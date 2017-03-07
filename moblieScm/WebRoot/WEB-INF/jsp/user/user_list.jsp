<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@include file="/WEB-INF/jsp/include/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sysname}</title>
    <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
  </head>
 
  <body>
   
    <form action="user_findUser.do" method="post">
      <table border="0" width="90%" align="center" style="margin-top:10px">
        <tr>
          <td width="60" align="left">用户名:</td>
          <td width="180" align="left"><input name="user.account" class="text" value="${user.account}"/></td>
          <td width="60" align="left">Email:</td>
          <td width="300" align="left"><input name="user.email" class="text" value="${user.email}"/>
          <input type="submit" class="btn find" value="查询" style="margin-left: 20px"></td>
          
          <td align="right">
            
            <input type="button" class="btn ok" style="width:90px" value="添加用户"
             onclick="location='user_toAddUser.do'"/>
          </td>
        </tr>
      </table>
    </form>
    <table class="table" rowNum="15" width="90%" align="center" >
      <tr>
        <th>用户名</th>
        <th>Email</th>
        <th>角色</th>
        <th>状态</th>
        <th>备注</th>
        <th>创建时间</th>
        <th>最后登录时间</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${userList}" var="user">
        <tr>
          <td>${user.account}</td>
          <td>${user.email}</td>
          <td>${user.role}</td>
          <td>
          <c:if test="${user.status==1}">已启用</c:if>
          <c:if test="${user.status==0}">已停用 </c:if>
          </td>
          <td>${user.remark}</td>
          <td>${user.createtime}</td>
          <td>${user.lastlogintime}</td>
          <td>          
              <a href="user_edit.do?user.userid=${user.userid}">编辑</a>
              <a href="user_delete.do?user.userid=${user.userid}" onclick="return confirm('确定要删除吗？');">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
      ${pagination.naviHtml}
    </body>
    <%-- <center>
   <table>
			<font size="3">
			<tr style="text-align:center;"><td>第${pb.pc }页/共${pb.tp }页</td></tr>
				<tr>
				<td>
				<a class='easyui-linkbutton'
					href="<c:url value='user_list.do?offSet=1'/>">首页</a>
				<c:if test="${pb.pc > 1 }">
					<a class='easyui-linkbutton'
						href="<c:url value='user_list.do?offSet=${pb.pc-1 }'/>">上一页</a>
				</c:if>


<!---------------------- 页码设计开始 ----------------------------->
		<c:choose>
			<c:when test="${pb.tp <= 10}">
				<c:set var="begin" value="1" />
				<c:set var="end" value="${pb.tp}" />
			</c:when>

			<c:otherwise>
				<c:set var="begin" value="${pb.pc-5}" />
				<c:set var="end" value="${pb.pc+4}" />

				<c:if test="${begin < 1}">
					<c:set var="begin" value="1" />
					<c:set var="end" value="10" />
				</c:if>

				<c:if test="${end > pb.tp}">
					<c:set var="begin" value="${pb.tp-9}" />
					<c:set var="end" value="${pb.tp}" />
				</c:if>
			</c:otherwise>
		</c:choose>


		<!-- 打出页码 -->
		<c:forEach var="i" begin="${begin}" end="${end}">
			<c:choose>
				<c:when test="${i eq pb.pc}">
					[${i}]
				</c:when>
				<c:otherwise>
					<a  href="<c:url value='user_list.do?offSet=${i}'/>">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

<!---------------------- 页码结束----------------------------->


				<c:if test="${pb.pc < pb.tp }">
					<a class='easyui-linkbutton' style='text-align:center;'
						href="<c:url value='user_list.do?offSet=${pb.pc+1 }'/>">下一页</a>
				</c:if>
				<a class='easyui-linkbutton' style='text-align:center;'
					href="<c:url value='user_list.do?offSet=${pb.tp }'/>">尾页</a>
					
					
					<input class="easyui-validatebox" type="text" style="border: 1px solid ;width: 25px;height: 20px;" id="pagecode"/>
					<button class='easyui-linkbutton' style='width:30px;text-align:center;' onclick="goTo();">GO</button>
					</td>
					</tr>
					</font>
					
					
				</table>
			</center>
			<!-- <script type="text/javascript">
				function goTo(){
					var pc = document.getElementById("pagecode");
					if(pc.value==null||pc.value.trim().isEmpty){
						return false;
					}else if (pc.value>${pb.tp}||pc.value<1){
						return false;
					}else {
						window.location.href="<c:url value='user_list.do?offSet="+pc.value+"'/>";
					}
				}
			</script> --> --%>
	
</html>
