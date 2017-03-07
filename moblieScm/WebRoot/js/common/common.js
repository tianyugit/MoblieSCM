//=========================================================================
// DOM�����������
//=========================================================================
function getAbsPosition(o){

    o = $(o);
    if (o.length == 0) {
        return false;
    }
    
    o = o[0];
    
    var left, top;
    left = o.offsetLeft;
    top = o.offsetTop;
    
    while (o = o.offsetParent) {
        left += o.offsetLeft;
        top += o.offsetTop;
    }
    
    return {
        left: left,
        top: top
    };
}

//=========================================================================
// STRING��������
//=========================================================================
String.prototype.trim = function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
};
String.prototype.startWith = function(str){
    if (typeof(str) === "undefined") {
        return false;
    }
    str = str.toString();
    if (this.substr(0, str.length) == str) {
        return true;
    }
    else {
        return false;
    }
}

String.prototype.endWith = function(otherStr){
    if (typeof(otherStr) === "undefined") {
        return false;
    }
    otherStr = otherStr.toString();
    var startPos = this.length - otherStr.length;
    if (startPos >= 0) {
        var tmp = this.substr(startPos);
        if (tmp === otherStr) {
            return true;
        }
        else {
            return false;
        }
    }
    else {
        return false;
    }
}

String.prototype.contains = function(otherStr){
    if (typeof(otherStr) === "undefined") {
        return false;
    }
    if (this.indexOf(otherStr.toString()) == -1) {
        return false;
    }
    else {
        return true;
    }
}
//=========================================================================
// FORM��������
//=========================================================================
/**
 * �����и����ֵ�Զ���װ�ɲ�������
 * @param {Object} oFrm ������
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
    return ret;
}

/**
 * ajax�ύ��
 * @param {Object} version
 */
function ajaxSubmit(frm, parameter, afterSubmit){

    if (!(rets = ValidateFrm.submitValidate(frm))) {
        return false;
    }
    
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
            window.alert("���ύʧ��");
        }
    });
}

/**
 * ����֤ - ��
 * @param {Object} version
 */
function validateFrm(){

    //��ʾ������Ϣ
    function showInfo(o, defaultInfo){
        validateRun = false;
        o.css("background-color", "red");
        
        var info = o.attr("info");
        if (!info) {
            info = defaultInfo;
        }
        
        var errDivId = o.attr("errDivId");
        $("div#" + errDivId).html(info);
        validateRun = true;
    }
    
    //ȡ��������ʾ
    function restore(o){
        validateRun = false;
        o.css("background-color", "");
        var errDivId = o.attr("errDivId");
        $("div#" + errDivId).html("");
        validateRun = true;
    }
    
    function validate(o){
    
        var val = o.val();
        
        //����
        if (typeof(o.attr("required")) == "string") {
            if (val.trim().length == 0) {
                showInfo(o, "����Ϊ�գ�");
                return false;
            }
            else {
                restore(o);
            }
        }
        
        //��󳤶�
        var len = o.attr("maxlength");
        if (len && len > 0) {
            while (getStrByteLen(o.val()) > len) {
                o.val(o.val().substr(0, o.val().length - 1));
            }
        }
        
        
        //��С����
        len = o.attr("minlength");
        if (len && len > 0) {
            if (getStrByteLen(val) < len) {
                showInfo(o, "���Ȳ���С��" + len);
                return false;
            }
            else {
                restore(o);
            }
        }
        
        //Ԥ������
        var valType = o.attr("valType");
        if (valType) {
            var ret = FrmCheck[valType](val, o);
            if (ret == "pass" || val.trim().length == 0) {
                restore(o);
            }
            else {
                showInfo(o, ret);
                return false;
            }
        }
        
        //ģʽƥ��
        var pattern = o.attr("pattern");
        if (pattern) {
            if (val.match(eval(pattern)) || val.trim().length == 0) {
                restore(o);
            }
            else {
                showInfo(o, "��ʽ������Ҫ��");
                return false;
            }
        }
        
        //�Զ�����֤
        var ret = true;
        var validate = o.attr("validate");
        if (validate) {
            eval(validate)(function(data){
                if (data == "pass" || val.trim().length == 0) {
                    restore(o);
                }
                else {
                    showInfo(o, data);
                    data = false;
                }
            });
        }
        return ret;
    }
    
    /**
     * �ύ��ʱ��֤
     * @param {Object} frm
     */
    this.submitValidate = function(frm){
        frm = $(frm)[0];
        
        $.ajaxSetup({
            async: false
        });
        
        var ret = true;
        
        var len = frm.elements.length;
        for (var i = 0; i < len; i++) {
            var ele = frm.elements[i];
            if (ele.type == "text" || ele.type == "password" || ele.tagName.toLowerCase() == "textarea") {
                if (!validate($(ele))) {
                    ret = false;
                    break;
                }
            }
        }
        $.ajaxSetup({
            async: true
        });
        
        return ret;
    }
    
    /**
     * ��ʼ��ʱ���¼�
     * @param {Object} frm
     */
    this.bindValidate = function(frm){
        frm = $(frm)[0];
        var len = frm.elements.length;
        for (var i = 0; i < len; i++) {
            var ele = frm.elements[i];
            if (ele.type == "text" || ele.type == "password" || ele.tagName.toLowerCase() == "textarea") {
                $(ele).bind("input propertychange", function(){
                    validateRun && validate($(this));
                })
            }
        }
    }
}

//����ֽڳ���
function getStrByteLen(str){
    var len = 0;
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) < 128) {
            len++;
        }
        else {
            len += 2;
        }
    }
    return len;
}

var validateRun = true;
var ValidateFrm = new validateFrm();

/**
 * ���ñ���֤����
 * @param {Object} version
 */
FrmCheck = {
    //Email��ʽ��֤
    email: function(str){
        if (str.match(/^\w+@\w+(\.\w+)+$/ig)) {
            return "pass";
        }
        return "��Ч�ĵ����ʼ���ʽ��";
    },
    //����������֤
    integer: function(str, o){
        if (str.match(/^[+-]?\d+$/)) {
            if (o && o.attr("range")) {
                var val = str - 0;
                
                var range = o.attr("range");
                var start = range.substring(0, range.indexOf('-'));
                var end = range.substring(range.indexOf('-') + 1);
                if (start && end) {
                    if (val >= start && val <= end) {
                        return "pass";
                    }
                    else {
                        return "����ֵ�������" + start + "��" + end + "֮�䣡";
                    }
                }
                else if (start) {
                    if (val >= start) {
                        return "pass";
                    }
                    else {
                        return "����ֵ������ڵ���" + start;
                    }
                }
                else if (end) {
                    if (val <= end) {
                        return "pass";
                    }
                    else {
                        return "����ֵ����С�ڵ���" + end;
                    }
                }
            }
            return "pass";
        }
        return "�����ֵ����������!";
    },
    //ʵ�����͵���֤
    number: function(str, o){
        if (str.match(/^[+-]?\d+(\.\d+)?$/)) {
            if (o && o.attr("range")) {
                var val = str - 0;
                
                var range = o.attr("range");
                var start = range.substring(0, range.indexOf('-'));
                var end = range.substring(range.indexOf('-') + 1);
                if (start && end) {
                    if (val >= start && val <= end) {
                        return "pass";
                    }
                    else {
                        return "����ֵ�������" + start + "����С��" + end + "��";
                    }
                }
                else if (start) {
                    if (val >= start) {
                        return "pass";
                    }
                    else {
                        return "����ֵ�������" + start;
                    }
                }
                else if (end) {
                    if (val <= end) {
                        return "pass";
                    }
                    else {
                        return "����ֵ����С��" + end;
                    }
                }
            }
            return "pass";
        }
        return "�����ֵ����������!";
    }
}
//=========================================================================
// Browser��������
//=========================================================================
var Browser = {
    isIE: function(version){
    
        if (navigator.userAgent.toLowerCase().indexOf("msie") == -1) {
            return false;
        }
        else {
            if (version) {
                var regexpr = new RegExp("msie\\s*" + version, "g");
                if (navigator.userAgent.toLowerCase().match(regexpr)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
    }
    
};

//=========================================================================
// COOKIE��������
//=========================================================================
var Cookie = {
    /**
     * ����cookie
     * @param {Object} cname ����
     * @param {Object} cvalue ֵ
     * @param {Object} expires ����ʱ�䣬��������ֵ����ʾ���ʱ�䣬���������ڶ��󣬱�ʾ��������
     */
    set: function(cname, cvalue, expires){
        var expiresString;
        if (expires) {
            if (expires instanceof Date) {
                expiresString = ";expires=" + expires.toGMTString();
            }
            else {
                var d = parseInt(expires);
                if (!isNaN(d)) {
                    var t = new Date();
                    t = new Date(t.getTime() + d);
                    expiresString = ";expires=" + t.toGMTString();
                }
            }
        }
        
        var tmp = cname + "=" + escape(cvalue);
        if (expiresString) {
            tmp += expiresString;
        }
        document.cookie = tmp;
    },
    
    /**
     * �����Ʋ���cookie
     * @param {Object} cname
     */
    find: function(cname){
        var cookies = document.cookie;
        var regexpr = new RegExp(cname + "\\s*=[^;]*(;|$)", "g");
        var ret = cookies.match(regexpr);
        if (ret) {
            var val = ret[0].replace(new RegExp(cname + "\\s*="), "").replace(";", "");
            return unescape(val);
        }
    },
    
    /**
     * ������ɾ��cookie
     * @param {Object} cname
     */
    remove: function(cname){
        document.cookie = cname + "=no;expires=" + new Date(1970, 0, 0).toGMTString();
    }
};

//=========================================================================
// Object��������
//=========================================================================
var ObjUtils = {
    /**
     * ֵ�ֶ���ȸ���
     */
    deepClone: function(o){
        var isSimpleVal = function(val){
            if (typeof(val) === "string" || typeof(val) === "number" || typeof(val) == "boolean") {
                return true;
            }
            else {
                return false;
            }
        };
        
        var isArray = function(o){
            if (o instanceof Array) {
                return true;
            }
            else {
                return false;
            }
        };
        
        var isObject = function(o){
            if (typeof(o) === "object") {
                return true;
            }
            else {
                return false;
            }
        };
        
        var cloneArray = function(o){
            if (!o) {
                return null;
            }
            
            var ret = [];
            for (var i = 0; i < o.length; i++) {
                if (isSimpleVal(o[i])) {
                    ret.push(o[i]);
                }
                else if (isObject(o[i])) {
                    ret.push(cloneObj(o[i]));
                }
            }
            return ret;
        };
        
        var cloneObj = function(o){
            if (!o) {
                return null;
            }
            
            var ret = {};
            for (var prop in o) {
                var val = o[prop];
                if (isArray(val)) {
                    ret[prop] = cloneArray(val);
                }
                else if (isSimpleVal(val)) {
                    ret[prop] = val;
                }
                else if (isObject(val)) {
                    ret[prop] = cloneObj(val);
                }
            }
            return ret;
        };
        
        if (isArray(o)) {
            return cloneArray(o);
        }
        else {
            return cloneObj(o);
        }
    }
    
}
