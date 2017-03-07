<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${sysname}</title>
<link href="css/cb.css" rel="stylesheet" type="text/css" />
<link href="css/n.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.STYLE1 {
	color: #ffffff;
	font-size: 12px;
}
.STYLE4 {
	color: #8da8c3;
	font-size: 12px;
}
.STYLE6 {
	font-size: 12px;
	color: #5593ce;
}
-->
</style>
<link  href="css/layout.css" rel="stylesheet" type="text/css" />
 <%@ include file="/WEB-INF/jsp/include/css.jsp" %>
 <%@ include file="/WEB-INF/jsp/include/js.jsp" %>  
<script type="text/javascript">
  function changeImg(img){
  		img.src = img.src+"?time="+new Date().getTime();
  	}
  	function checkForm(){
  			var canSub = true;
  			//1.非空校验
  			canSub = checkNull("account","用户名不能为空!") && canSub;
  			canSub = checkNull("passwd","密码不能为空!") && canSub;
  			canSub = checkNull("cvode","验证码不能为空!") && canSub;
  	}
  	
  	function checkNull(name,msg){
  			document.getElementById(name+"_msg").innerHTML = "";
  			var objValue = document.getElementsByName(name)[0].value;
  			if(objValue == null || objValue == ""){
				document.getElementById(name+"_msg").innerHTML = "<font color='red'>"+msg+"</font>";
  				return false;
  			}
  			return true;
  		}

</script>
<script type="text/JavaScript">   
	
	     if(top!=self){  
	          if(top.location != self.location)  
	               top.location=self.location;   
	     }  
</script> 

</head>

<body>

<table width="100%" height="594" border="0" align="center" cellpadding="0" cellspacing="0"  style="margin:0px; padding:0px">
  <tr>
    <td height="594"  align="center" valign="top" background="images/bj.gif">
	<table width="465" height="414" border="0" align="center" cellpadding="0" cellspacing="0" >
      <tr>
        <td  height="152" colspan="3" valign="bottom">
        <img src="Picture/toplogin.png" width="460" height="152" />
        </td>
      </tr>
      <tr>
						<td width="15" height="262" background="images/bj1.gif">&nbsp;</td>
						<td width="420" valign="middle" background="images/bj2.gif">
		<form id="form1"  method="post" action="userLogin.do" onsubmit="return checkForm()">
		<table width="100%" height="170" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="31%" align="right"><span class="STYLE1">用户名：</span></td>
              <td colspan="2" align="left"><label>
                <input name="user.account" class="easyui-textbox" data-options="iconCls:'icon-man'" type="text" id="username" value="admin" />
              </label></td>
              <td id="account_msg"> ${amsg}</td>
            </tr>
            <tr>
              <td align="right"><span class="STYLE1">密码：</span></td>
              <td colspan="2" align="left"><label>
                <input name="user.passwd" prompt="请输入密码" class="easyui-passwordbox" value="admin"/>
              </label></td>
              <td id="password_msg"></td>
            </tr>
            
            <tr>
              <td align="right"><span class="STYLE1">验证码：</span></td>
              <td align="left" colspan="2"><label>
                <input name="user.cvode" type="text" style="" height="35px"/>
              </label>
              </td>
            
              <td id="cvode_msg">${msg}</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td width="15%" valign="top"><p class="STYLE4">
               <table>
              <tr>
              <td>
              <img src="ValiImg"  onclick="changeImg(this)" style="cursor: pointer;" />
              </td>
              </tr>
              <tr>
               <td align="center" valign="middle" height="20" class="STYLE4">看不清，点图片换一张</td>
              </tr>
              
              </table></p>          
               </td>
              <td width="20%" align="right" valign="middle"><a href="regist.do"   ><span class="STYLE4">注册新用户</span></a><br />
                  <br />
<span class="STYLE4">找回密码</span></td>
              <td width="34%" height="55" align="left"> 
			  <input type="image"  style="width:60px; height:55px;" src="images/login2.png" />			  </td>
            </tr>
        </table>
		 </form>		</td>
        <td width="13" background="images/bj3.gif">&nbsp;</td>
      </tr>
    </table>

	<table width="465" height="76" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="76">&nbsp;</td>
      </tr>
    </table>
	<br />
	<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="64" align="center" valign="middle"><span class="STYLE6">版权所有：广州大学华软软件学院 <br /><figure> 电话：020－87818918<figcaption>网站公安备案编号：4401840100050</figcaption></figure>
              <br />
       地址： 广东省广州市广东从化经济开发区高技术产业园广从南路548号   广州大学华软软件学院    邮编:510990</span></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
