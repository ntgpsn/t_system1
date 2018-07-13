
function dataUri(data){
    var uri = "";
    for (var i in data) { //用javascript的for/in循环遍历对象的属性
        uri += "&"+i+"="+data[i];
    }
    return uri.substring(0, uri.length -1);
}

function ajaxJsonCallGet(url, data, callback) {
    var urlVal = dataUri(data); // 将参数拼接到url后边
    url = url + "?" + urlVal;

    $.ajax({
        url: '/t_system/' + url,
        contentType:"application/json;charset=UTF-8",

        type: "GET",
        dataType: "json",
        success: callback,
        error:function(XMLHttpRequest ,state,err){
            var data = JSON.parse(XMLHttpRequest.responseText);
            var rtnMsg = data.rtnMsg;
            if (XMLHttpRequest.status == 0) {
                rtnMsg = "网络异常";
            }
            alert(rtnMsg);
        }
    });
}

