<%@page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tree</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrapStyle.css" type="text/css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ztree.exedit.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
    <SCRIPT type="text/javascript">
        <!--
        var setting = {
            view: {
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false
            },
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: true
            }
        };

        var zNodes =[
            {id:1, pId:0, name:"[core] 基本功能 演示", open:true},
            {id:101, pId:1, name:"最简单的树 --  标准 JSON 数据"},
            {id:10101, pId:1, name:"最简单的树 --  标准 JSON 数据"},
            {id:102, pId:1, name:"最简单的树 --  简单 JSON 数据"},
            {id:103, pId:1, name:"不显示 连接线"},
            {id:104, pId:1, name:"不显示 节点 图标"},
            {id:108, pId:1, name:"异步加载 节点数据"},
            {id:109, pId:1, name:"用 zTree 方法 异步加载 节点数据"},
            {id:110, pId:1, name:"用 zTree 方法 更新 节点数据"},
            {id:111, pId:1, name:"单击 节点 控制"},
            {id:112, pId:1, name:"展开 / 折叠 父节点 控制"},
            {id:113, pId:1, name:"根据 参数 查找 节点"},
            {id:114, pId:1, name:"其他 鼠标 事件监听"}
        ];

        $(document).ready(function(){
            initProjectManage();
        });


        function initProjectManage() {
            var param = {
              "userId":"5b4831c9997c3412f0de8521",
               "accountType":"1"
            };
            ajaxJsonCallGet("/v1/tcl/projectmanageMenu",param, function (data) {
                $.fn.zTree.init($("#treeDemo"), setting, data);
            });
        }


        var newCount = 1;
        //鼠标事件
        function addHoverDom(treeId, treeNode) {
            var sObj = $("#" + treeNode.tId + "_span");
            if (!treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
            // 显示修改删除增加图标
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='add node' onfocus='this.blur();'></span>";

            var editStr = "<span class='button edit' id='editBtn_" + treeNode.tId
                + "' title='edit node' onfocus='this.blur();'></span>";
            var removeStr = "<span class='button remove' id='removeBtn_" + treeNode.tId
                + "' title='remove node' onfocus='this.blur();'></span>";

            sObj.after(addStr+editStr+removeStr);
            var btn = $("#addBtn_"+treeNode.tId);
            //click事件
            if (btn) btn.bind("click", function(){
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
                return false;
            });
        };
        function removeHoverDom(treeId, treeNode) {
            $("#addBtn_"+treeNode.tId).unbind().remove();
        };
    </SCRIPT>
</head>
<body>
    <div class="" id="projectManage">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
</body>
</html>
