$().ready(function(){
	 $("select[name=mobtypeid]").change(function(){
	    	
	       $("#refPrice").empty().append("<img src='images/loading.gif'></img>");
	        
	         var mobTypeId = this.value;
	        if (mobTypeId.length == 1) {
	            $("#refPrice").html("未选机型");
	        } 
	        else {
	             $.post("mobStockIn_findRefPrice.do?time="+new Date().getTime(), {
	               'msi.mobtypeid': mobTypeId
	            }, function(data){
	                if (data.length == 0) {
	                    $("#refPrice").html("参考值未设置");
	                }
	                else {
	                    $("#refPrice").html(parseFloat(data).toFixed(2));
	                }
	            }); 
	        } 
	    });
	    
	     $("select[name=mobtypeid]").change();
    
  
    
    $("input[name=buyprice]").bind("propertychange input", function(){
    
        $("input[name=totalmoney]").val(this.value * $("input[name=amount]").val());
    })
    
    $("input[name=sn1]").keypress(function(event){
        if (event.keyCode == 13) {
            if ($("input:radio[name=setSn][checked]").val() == "single") {
                addSn();
            }
            else {
                $("input[name=sn2]").focus();
            }
        }
    })
    
    $("input[name=sn2]").keypress(function(event){
        if (event.keyCode == 13) {
            addSn();
        }
    })
});

var sns = [];

function addSn(){

    var sn1 = $("input[name=sn1]").val().trim();
    var sn2 = $("input[name=sn2]").val().trim();
    
    if (sn1.length == 0) {
        $("input[name=sn1]").focus();
        return;
    }
    
    if ($("input:radio[name=setSn][checked]").val() == "double" && sn2.length == 0) {
        $("input[name=sn2]").focus();
        return;
    }
    
    var sn = {
        sn1: sn1,
        sn2: sn2
    };
    
    $("input[name=sn1]").val("");
    $("input[name=sn2]").val("");
    $("input[name=sn1]").focus();
    
    for (var i = 0; i < sns.length; i++) {
        if (sns[i].sn1 == sn1 || (($("input:radio[name=setSn][checked]").val() == "double") && sns[i].sn2 == sn2)) {
            sn.status = "已输入";
            return;
        }
    }
    
    //加入表格行
    var tr = $("<tr></tr>");
    $("<td></td>").appendTo(tr);
    $("<td>" + sn1 + "</td>").appendTo(tr);
    $("<td>" + sn2 + "</td>").appendTo(tr);
    $("<td><a href='#' onclick='return delSn(\"" + sn1 + "\")'>删除</a></td>").appendTo(tr);
    $("<td></td>").appendTo(tr);
    
    $("#tblSns").append(tr);
    
    
    
    setSerial();
    
    sns.push(sn);
    
    if (i == sns.length - 1) {
        sn.method = $("input:radio[name=setSn][checked]").val();
        $.post("mobStockIn_dupSn.do", sn, function(data){
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
           // var num = $("#amount").val();
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
/*function setStatus(sn){
	
	 $("tr", $("#tblSns")).each(function(){
		 $("td:last", $(this)).html("");
	    })
}*/

function submitFrm(frm){
    var strSns = [];
    for (var i = 0; i < sns.length; i++) {
        var sn = sns[i];
        if (sn.status == "OK") {
            strSns.push(sn.sn1 + "," + sn.sn2);
        }
    }
    //验证
    //.....
    ajaxSubmit(frm, {
        sns: strSns
    });
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

//单双串号
function single1(){
  var sn2 = $("input[name=sn2]");
 sn2.val("");
 sn2.attr("disabled", true);
 sn2.css("background-color", "gray"); 
 //alert("dfdf");
};
 function double1(){
 //alert("dfdf2323");
 var sn2 = $("input[name=sn2]");
 sn2.removeAttr("disabled");
 sn2.css("background-color", "white");
};

function brandreq(o){
	   // alert("ccccccc");
	        var mobTypeElement = document.getElementById("mobTypeID");
	        mobTypeElement.options.length = 1;
	    	 $.post("mobStockIn_findMobType.do?time="+new Date().getTime(), {
	              'msi.brand': o[o.selectedIndex].value
	            }, function(data,textStatus){
	            //alert("cccccffcc");
	            //alert(data);
	            var jsonJS = eval(data);
				 $.each(jsonJS,function(idx,item){
					var mobtypename = item.mobtypename;
					//alert(mobtypename);
					var option = document.createElement("option");
					option.setAttribute('value',item.mobtypeid);
					option.innerHTML = mobtypename;
					mobTypeElement.appendChild(option);
	               /*  if (data.length == 0) {
	                    $("#refPrice").html("参考值未设置");
	                }
	                else {
	                    $("#refPrice").html(parseFloat(data).toFixed(2));
	                } */
	                }); 
	            });  
	    }
