<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <!--  <base target="frame"> -->
    
    <title>主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<!-- 引入css文件，不限顺序 -->
    <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
    <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
  
  	<!-- 引入js文件，有顺序限制 -->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	
	<script type="text/javascript" src="style/js/page_common.js"></script>
    <link href="css/common_style_blue.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	<!--
body {
margin: 0;
}
#Head_1 {
    background: url("images/img/top_head1_bg.gif") repeat-x scroll 0 0 transparent;
    height: 64px;
    margin: 0 auto;
    width: 100%;
}
#Head_1 #Head_1_Logo {
	float: left;
    left: 20px;
    position: absolute;
    top: 12px;
	color: #F1F9FE;
    font-family: Arial Black,Arial;
    font-size: 28px;
}
#Head_1 #Head_1_UserWelcome {
    float: right;
    color: #B3E1FF;
    font-family: "宋体";
    font-size: 12px;
    height: 25px;
	padding-top: 11px;
	margin-right: 20px;
}
#Head_1 #Head_1_FunctionButton {
    float: left;
    position: absolute;
    right: 5px;
    top: 35px;
	margin-right: 15px;
}
#Head_1 #Head_1_FunctionButton img {
margin-left: 10px;
}
-->
	</style>
	<script type="text/JavaScript">   
	
	     if(top!=self){  
	          if(top.location != self.location)  
	               top.location=self.location;   
	     }  
	</script> 
  </head>
  
  <body class="easyui-layout">
   <!-- 区域面板--北边 -->
			<div data-options="region:'north',split:false,border:true,iconCls:'icon-remove',collapsible:true" style="height:67px;">
				<!-- 上部 -->
	<div id="Head_1">
		<!-- 标题 -->
		<div id="Head_1_Logo">
			<img border="0" style="margin-top:0px;" src="Picture/tb.png" />
        </div>
		<!-- 欢迎用户的文字 -->
		<div id="Head_1_UserWelcome">
			<img border="0" width="13" height="14" src="images/user.gif" /> 
			您好，<b>${loginUser.account}</b>
		</div>
		<!-- 一些链接按钮 -->
		<div id="Head_1_FunctionButton">
			<a  href="home.do">
				<img width="78" height="20" src="images/home.png" />
			</a>
			<a target="_parent" href="logout.do">
				<img width="78" height="20" alt="退出系统" src="images/logout.gif" />
			</a>
		</div>
	</div>
			</div>   
			
			<!-- 区域面板--南边 -->
			<div data-options="region:'south',split:false" style="height:30px; text-align: center;">
			
			<span style="margin-top: 10px">地址： 广东省广州市广东从化经济开发区高技术产业园广从南路548号 广州大学华软软件学院  邮编:510990</span>
			</div>   
			
			
			
			<!-- 区域面板--西边 -->
			<div data-options="region:'west',title:'导航菜单',split:true" style="width:180px;">
				<div id="aa" class="easyui-accordion" style="width:auto;height:auto;" data-options="fit:true,selected:false">   
				       
				    <div title="供应商业务" >   
				 <ul id="tt" class="easyui-tree">   
				    <li>   
				       <span><a href="mobStockIn_list.do" target="frame">手机入库</a></span>
				    </li>   
				    <li>   
				        <span><a href="accessoryStockIn_list.do" target="frame">配件入库</a></span> 
				    </li>   
				    <li>   
				        <span><a href="mobReturn_list.do" target="frame">手机退货</a></span> 
				    </li>   
				    <!-- <li>   
				        <span>配件退货</span> 
				    </li> -->   
				    <li>   
				        <span><a href="pay_list.do" target="frame">付款</a></span> 
				    </li>   
				      
				    <li>   
				        <span><a href="tradeDetail_list.do" target="frame">供应商交易明细</a></span> 
				    </li>   

				</ul> 
				    </div>   
				    <div title="客户业务">   
				         <ul id="tt" class="easyui-tree">   
				    <li>   
				       <span><a href="custSale_list.do" target="frame">手机销售</a></span>
				    </li>   
				      
				    <!-- <li>   
				        <span>配件销售</span> 
				    </li>  -->  
				   <!--  <li>   
				        <span>下家手机退货</span> 
				    </li>   
				    <li>   
				        <span>下家配件退货</span> 
				    </li>  -->  
				      
				    <li>   
				        <span><a href="payee_list.do"  target="frame">收款</a></span> 
				    </li>  
				    <li>   
				        <span><a href="custTradeDetail_list.do" target="frame">客户交易明细</a></span> 
				    </li>   
				</ul>  
				    </div>   
				     <div title="库存业务" >   
				       <ul id="tt" class="easyui-tree">   
				    <li>   
				       <span><a href="mobStock_list.do" target="frame">手机库存</a></span>
				    </li>   
				    <li>   
				        <span><a href="accStock_list.do" target="frame">配件库存</a></span> 
				    </li>   
				   	      
				</ul>    
				    </div>   
				   <!--  <div title="修改业务">   
				         <ul id="tt" class="easyui-tree">   
				    <li>   
				       <span>单据时间修改</span>
				    </li>   
				    <li>   
				        <span>手机库存成本修改及库存报废</span> 
				    </li>   
				    <li>   
				        <span>配件库存成本修改及报废</span> 
				    </li>   
				    <li>   
				        <span>内配库存成本修改及报废</span> 
				    </li>   
				</ul>    
				    </div>   -->
				    <!-- <div title="报表业务">   
				        content3    
				    </div> -->
				    <div title="基础管理" >   
				        <ul id="tt" class="easyui-tree">   
						    <li>   
						        <span>用户管理</span>   
						        <ul>   
						           <li>   
									 <span><a href="user_toAddUser.do" target="frame">添加用户</a></span>
								 </li>     
								  <li>   
									 <span><a href="user_list.do?offSet=1" target="frame">查找用户</a></span>
								 </li>     
						        </ul>   
						    </li>   
						    <li>   
						        <span>客户管理</span>   
						        <ul>   
								  <li>   
									 <span><a href="custType_list.do" target="frame">查找客户类别</a></span>
								 </li>     
						           <li>   
									 <span><a href="cust_list.do" target="frame">查找客户</a></span>
								 </li>     
						        </ul>   
						    </li>   
						    <li>   
						        <span>配件管理</span>   
						        <ul>   
								  <li>   
									 <span><a href="accessoryType_list.do" target="frame">配件型号</a></span>
								 </li>     
						        </ul>   
						    </li>   
						    <li>   
						        <span>供应商类别管理</span>   
						        <ul>   
						            <li>   
									 <span><a href="supplierType_toAdd.do" target="frame">添加供应商类别</a></span>
								 </li>     
								  <li>   
									 <span><a href="supplierType_list.do" target="frame">查找供应商类别</a></span>
								 </li>    
						        </ul>   
						    </li>   
						    <li>   
						        <span>供应商管理</span>   
						        <ul>   
						            <li>   
									 <span><a href="supplier_toAdd.do" target="frame">添加供应商</a></span>
								 </li>     
								  <li>   
									 <span><a href="supplier_list.do" target="frame">查找供应商</a></span>
								 </li>    
						        </ul>   
						    </li>   
						    <li>   
						        <span>手机型号类别</span>   
						        <ul>   
						            <li>   
									 <span><a href="mobType_toAdd.do" target="frame">手机型号类别</a></span>
								 </li>     
								  <li>   
									 <span><a href="mobType_list.do" target="frame">查找手机型号类别</a></span>
								 </li>    
						        </ul>   
						    </li>   
						    <li>   
						        <span>其他</span>   
						        <ul>   
						            <li>   
									 <span><a href="color_list.do" target="frame">颜色管理</a></span>
								 </li>     
								  <li>   
									 <span><a href="brand_list.do" target="frame">品牌管理</a></span>
								 </li>    
								  <li>   
									 <span><a href="config_list.do" target="frame">配置管理</a></span>
								 </li>    
								  <li>   
									 <span><a href="bonusType_list.do" target="frame">返利类型设定</a></span>
								 </li>    
								  <li>   
									 <span><a href="account_list.do" target="frame">账户管理</a></span>
								 </li>    
						        </ul>   
						    </li>   
						</ul> 
				    </div>  
				</div>
			</div>   
				
			<!-- 区域面板--中间 -->
			<div data-options="region:'center'" style="padding:5px;">
				<iframe name="frame" width="100%" height="100%" style="border:0px;" src="home_dataShow.do"></iframe>
			</div>   	
  </body>
</html>
