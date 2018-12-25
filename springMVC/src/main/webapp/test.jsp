<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
id：<input type="text" name="id"><br>

<input type="button" id="b1" value="提交"><br>
</body>
<script>
    $(function () {
        $("#b1").click(function () {
            $.ajax({
                url: "/getUserInfo",        //后台url
                data: {                          //数据
                    id:$("input[name='id']").val(),
                },
                type: "POST",                   //类型，POST或者GET
                dataType: 'json',              //数据返回类型，可以是xml、json等
                success: function (data) {      //成功，回调函数
                    alert(data.username);
                    alert(data.age);
                    alert(data.id);
                    alert(data.password);

                },
                error: function (er) {          //失败，回调函数
                    alert(er);
                }
            });

        })

    })
</script>
</html>
