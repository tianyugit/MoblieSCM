var parameter = {
    "mobType.bonusList": []
};//对象

/**
 * 动态填加返利价
 */
function addBonus(){
    //从表单获得原始数据
    var bonusType = $("#bonusType").val();
    var bonustypeid = bonusType.substring(0, bonusType.indexOf(":"));
    var tyoename = bonusType.substring(bonusType.indexOf(":") + 1);
    var bonusPrice = $("#bonusPrice").val();
    
    //校验
    for (var i = 0; i < parameter["mobType.bonusList"].length; i++) {
        if (parameter["mobType.bonusList"][i].bonustypeid == bonustypeid) {
            window.alert("这个类别已经填加！");
            return false;
        }
    }
    
    var price = bonusPrice - 0;
    if (isNaN(price) || price <= 0) {
        window.alert("价格只能为正数！");
        return;
    }
    
    //完成填加
    var bonus = {
    	bonustypeid: bonustypeid,
    	tyoename: tyoename,
        bonusPrice: bonusPrice
    }
    //加入数组
    parameter["mobType.bonusList"].push(bonus);
    //生成新行
    drawNewLine(bonus);
}

function drawNewLine(bonus){
    var tr = $("<tr></tr>").attr("lineId", bonus.bonustypeid);
    tr.append($("<td></td>").html(bonus.tyoename));
    tr.append($("<td></td>").html((parseFloat(bonus.bonusPrice)).toFixed(2)));
    tr.append($("<td></td>").html("<a href='#' onclick='return delPrice(\"" + bonus.bonustypeid + "\")'>删除</a>"));
    tr.appendTo($("#tblPrice"));
}

function delPrice(typeId){
    //删除数组中值
    for (var i = 0; i < parameter["mobType.bonusList"].length; i++) {
        if (parameter["mobType.bonusList"][i].bonustypeid == typeId) {
            break;
        }
    }
    parameter["mobType.bonusList"].splice(i, 1);
    
    //删除表格行
    $("tr[lineId=" + typeId + "]", $("#tblPrice")).remove();
	
	return false;
}

//提交表单
function submitType(frm){
    for (var i = 0; i < parameter["mobType.bonusList"].length; i++) {
        parameter["mobType.bonusList"][i] = JSON.stringify(parameter["mobType.bonusList"][i]);//转json
    	//parameter["mobType.bonusList"][i] = "{'fdf','sddssd','ssd'}";
    }
    //这里可以加入原始的手动验证方式
 //  alert(parameter["mobType.bonusList"]);
    ajaxSubmit(frm, parameter);
}


/**
 * ajax提交表单
 * @param {Object} version
 */
function ajaxSubmit(frm, parameter, afterSubmit){

  // alert("ddd");
    
    frm = $(frm)[0];
    var action = frm.action;
    var method = frm.method ? frm.method : "post";
    
    var paraObj = {};
    if (parameter) {
        paraObj = parameter;
    }
    paraObj = getFormPara(frm, paraObj);

    $.ajax({
        url: action,
        data: paraObj,
        type: method,
        success: function(data){
            if (afterSubmit && afterSubmit instanceof Function) {
                afterSubmit(data);
            }
            else {
                location = data; //"mobType_list.do"
            }
        },
        error: function(){
            window.alert("表单提交失败");
        }
    });
}

/**
 * 将表单中各域的值自动封装成参数对象
 * @param {Object} oFrm 表单对象
 */
function getFormPara(oFrm, obj){
    oFrm = $(oFrm)[0];
    var len = oFrm.elements.length;
    
    var ret;
    if (obj && obj instanceof Object) {
        ret = obj;
    }
    else {
        ret = {};
    }
    
    for (var i = 0; i < len; i++) {
    
        var oEle = oFrm.elements[i];
        
        if (oEle.type === "radio") {
            if (oEle.checked) {
                ret[oEle.name] = oEle.value.trim();
            }
        }
        else if (oEle.type === "checkbox") {
            var curVal = ret[oEle.name];
            if (curVal === undefined) {
                ret[oEle.name] = [];
            }
            if (oEle.checked) {
                ret[oEle.name].push(oEle.value.trim());
            }
        }
        else {
            ret[oEle.name] = oEle.value.trim();
        }
    }
    var t = "";
   for(var gg in ret){
	   t+=gg+"  ";
   }
   alert(t);
    return ret;
}

function repass(callback){
    if ($("textarea[name=mobType.remark]").val() == $("input[name=mobType.buyprice]").val()) {
        callback("pass");
    }
    else {
        callback("密码不一致");
    }
}
