<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/css/index2.css">
    <script type="text/javascript" src="/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
    function qx(){
        var flag = $("[name='ch']").attr("checked");
        if (flag){
            $("[name='check']").attr("checked",true);
        } else{
            $("[name='check']").attr("checked",false);
        }
    }

    function fx() {
        $("[name='check']").each(function () {
           $(this).attr("checked",!$(this).attr("checked"));
        })
    }

    function add() {
        location="toAdd.do";
    }

    function plsc() {
        var id = $("[name='check']:checked").map(function () {
            return $(this).val();
        }).get().join();
        alert(id);
        location="deleteplsc.do?id="+id;
    }

    function del(id) {
        alert("删除成功")
        location="deleteStudent.do?id="+id;
    }

    function upd(id) {
        location="toUpdate.do?id="+id;
    }

    function chakan(id) {
        location="chakan.do?id="+id;
    }

    </script>
</head>
<body>
<form action="/getStudentList.do" method="post">
    <input type="text" name="mohu" value="${mohu}">
    <button>模糊查询</button>
</form>
<button onclick="plsc()">批量删除</button>
<table>
    <tr>
        <td>
            <input type="checkbox" name="ch" onclick="qx()">全选
            <input type="checkbox" onclick="fx()">反选
        </td>
        <td>ID</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>班级</td>
        <td>地址</td>
        <td>操作
            <button onclick="add()">添加</button>
        </td>
    </tr>

<#list mapStudentList as m>
    <tr>
        <td>
            <input type="checkbox" name="check" value="${m.id}">
        </td>
        <td>${m.id}</td>
        <td>${m.name}</td>
        <td>${m.age}</td>
        <td>${m.cname}</td>
        <td>${m.address}</td>
        <td>
            <button onclick="upd('${m.id}')">修改</button>
            <button onclick="chakan('${m.id}')">详情</button>
            <button onclick="del('${m.id}')">删除</button>
        </td>
    </tr>
</#list>
    <tr>
        <td colspan="11">${page.page}当前${page.cpage}页/共${page.pagecount}页</td>
    </tr>
</table>
</body>
</html>