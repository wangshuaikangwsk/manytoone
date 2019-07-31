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
        $(function () {
            var id = '${id}';
            $.post("getStudentById.do",{id:id},function (obj) {
                $("[name='name']").val(obj.name);
                $("[name='age']").val(obj.age);
                $("[name='address']").val(obj.address);
                $.post("getClazzList.do",function (array) {
                for (var i=0;i< array.length;i++){
                    if (obj.cid==array[i].cid){
                        $("select").append("<option selected value='"+array[i].cid+"'>"+array[i].cname+"</option>");
                    }else{
                        $("select").append("<option value='"+array[i].cid+"'>"+array[i].cname+"</option>");
                    }

                }
            },"json");
                },"json");
        })

        function aa() {
            alert("修改成功")
        }
    </script>
</head>
<body>
<form action="/updateStudentList.do" method="post">
    <table>
        <tr>
            <td colspan="11">修改页面</td>
        </tr>

        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="name">
                <input type="hidden" name="id" value="${id}">
            </td>
        </tr>

        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"></td>
        </tr>

        <tr>
            <td>班级</td>
            <td>
                <select name="cid">
                    <option >-请选择-</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>地址</td>
            <td><input type="text" name="address" onblur="aa()"></td>
        </tr>


        <tr>
            <td><button>修改</button></td>
        </tr>


    </table>
</form>
</body>
</html>