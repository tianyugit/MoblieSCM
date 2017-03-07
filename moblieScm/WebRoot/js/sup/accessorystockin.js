  $().ready(function(){
    
    $("#buypriceID").bind("propertychange input", function(){
    //alert("");
        $("#totalmoneyID").val(this.value * $("#amountID").val());
    });

});
    var sns = [];
    function addSn(){

    var sn1 = $("input[name=sn1]").val().trim();
   //alert("dsdd");
     
    if (sn1.length == 0) {
        $("input[name=sn1]").focus();
        return;
    } 
    
    var sn = {
        sn1: sn1,
    };
    
    $("input[name=sn1]").val("");
    $("input[name=sn1]").focus();
    
    for (var i = 0; i < sns.length; i++) {
        if (sns[i].sn1 == sn1) {
            sn.status = "已输入";
            return;
        }
    }
    
    //加入表格行
    var tr = $("<tr></tr>");
    $("<td></td>").appendTo(tr);
    $("<td>" + sn1 + "</td>").appendTo(tr);
    $("<td><a href='#' onclick='return delSn(\"" + sn1 + "\")'>删除</a></td>").appendTo(tr);
    $("<td></td>").appendTo(tr);
    
    $("#tblSns").append(tr);
    
    
    
    setSerial();
    
    sns.push(sn);
    
    if (i == sns.length - 1) {
        sn.method = $("input:radio[name=setSn][checked]").val();
        //alert("sdsafaf");
         $.post("accessoryStockIn_dupSn.do", sn, function(data){
            if (data == "dup") {
                sn.status = "库中已存在";
               // $("td:last", tr).html("库中已存在");
            }
            else if (data == "succ") {
                sn.status = "OK";
               // $("td:last", tr).html("OK");
            }
            else {
                sn.status = "请求发生错误";
               // $("td:last", tr).html("请求发生错误");
            }
            //setStatus(sn);
            $("td:last", tr).html(sn.status);
            
            //数量
            var amount = 0;
            for (var j = 0; j < sns.length; j++) {
                if (sns[i].status == "OK") {
                    amount++;
                }
            }
            $("input[name=amount]").val(amount);
            
            //总价格
            var buyprice = $("input[name=buyprice]").val();
            if (buyprice.trim().length > 0) {
                $("input[name=totalmoney]").val(buyprice * amount);
            }
            else {
                $("input[name=totalmoney]").val("NaN");
            }
        }) 
    }
}

function setSerial(){
    var s = 0;
    $("tr", $("#tblSns")).each(function(){
        $("td:first", $(this)).html(s++);
    })
}

function delSn(sn1){
    $("tr", $("#tblSns")).each(function(){
        if ($("td:eq(1)", $(this)).html() == sn1) {
            $(this).remove();
        }
    })
    
    for (var i = 0; i < sns.length; i++) {
        if (sns[i].sn1 == sn1) {
            sns.splice(i, 1);
            break;
        }
    }
	setSerial();
    return false;
}

function brandreq(o){
	   // alert("ccccccc");
	        var accTypeElement = document.getElementById("accTypeID");
	        accTypeElement.options.length = 1;
	    	 $.post("accessoryStockIn_findAccType.do?time="+new Date().getTime(), {
	              'asi.brand': o[o.selectedIndex].value
	            }, function(data,textStatus){
	            //alert("cccccffcc");
	            //alert(data);
	            var jsonJS = eval(data);
				 $.each(jsonJS,function(idx,item){
					var typename = item.typename;
					//alert(mobtypename);
					var option = document.createElement("option");
					option.setAttribute('value',item.accessorytypeid);
					option.innerHTML = typename;
					accTypeElement.appendChild(option);
	               /*  if (data.length == 0) {
	                    $("#refPrice").html("参考值未设置");
	                }
	                else {
	                    $("#refPrice").html(parseFloat(data).toFixed(2));
	                } */
	                }); 
	            });  
	    }

