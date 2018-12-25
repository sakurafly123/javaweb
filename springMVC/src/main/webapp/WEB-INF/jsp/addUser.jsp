<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/22
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
    #select{
       margin-left:205px;
    }
    form{
        margin-top: 10%;
        margin-left: 20%;
    }
    #user_name{
        display: none;
    }
    #pwd_name{
        display: none;
    }
</style>
<script>
    /*失去焦点后的*/
    $(function () {
        /*检查用户名能否使用*/
        $('#checkuser').blur(function () {

            var reg =/^[A-Za-z0-9]{3,16}$/;
            var flag =reg.test($("input[name='username']").val());
            if (!flag){
                $("#user_name").html("不符合格式");
                $("#user_name").css("color","red");
                $("#user_name").css("display","block");
                return
            }else{
                $("#user_name").html("");
            }
            $.ajax({
                type: "post",
                url:"/user/check.do",
                dataType: "json",
                /*获取输入框的值*/
                data: {username: $("input[name='username']").val()},
                success: function(data){

                    if(!data.result){
                        $("#user_name").html("该用戶已存在");
                        $("#user_name").css("color","red");
                        $("#user_name").css("display","block");

                    }else{
                        $("#user_name").html("可以使用该用户名");
                        $("#user_name").css("color","green");
                        $("#user_name").css("display","block");
                        return
                    }
                },
                error:  function(event, XMLHttpRequest, ajaxOptions, thrownError){
                    alert(event)
                    alert(ajaxOptions)
                    alert(XMLHttpRequest)
                    alert(thrownError)
                    alert("接收失败")
                    //  $("#userinfo").html("");
                    alert("调用异常");
                }
            });


        })
        /*检查密码能否使用*/
        $('#checkpwd').blur(function () {
          var reg =/^[a-zA-Z0-9]{6,16}$/;
          var flag=reg.test($("input[name='pwd']").val());
          if(!flag){
              $('#check_pwd').html("密码格式有误");
             $("#check_pwd").css("color","red");
            $("#check_pwd").css("display","block");
            return
        }else{
            $("#check_pwd").html("密码符合格式，可以使用");
            $("#check_pwd").css("color","green");
        }
        })
        $('#age').blur(function () {
            var reg =/^[0-9]{1,2}$/;
            var flag=reg.test($("input[name='age']").val());
            if(!flag){
                $('#check_age').html("年龄格式有误");
                $("#check_age").css("color","red");
                $("#check_age").css("display","block");
                return
            }else{
                $("#check_age").html("年龄符合，可以使用");
                $("#check_age").css("color","green");

            }
        })
    })


</script>
<body>
<%--添加表格--%>
<form   action="/addUser"  method="post" class="form-horizontal">


    <div class="form-group">
        <%-- control-label在右边有输入框的情况下. label的文字向右靠.--%>
        <label  class="col-sm-2 control-label">username</label>
        <div class="col-sm-3">
            <input id="checkuser"type="text" class="form-control" name="username" value=""  placeholder="username">
        </div>
            <%--当用户已经存在时或者username不符合格式报错，报错--%>
            <div class="col-sm-3">
                <p id="user_name"></p>
            </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">Password</label>
        <div class="col-sm-3">
            <input id="checkpwd"type="password" class="form-control" name="pwd" value="" placeholder="Password">
        </div>
        <%--当用户已经存在时或者pwd不符合格式报错，报错--%>
        <div class="col-sm-3">
            <p id="check_pwd"></p>
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">age</label>
        <div class="col-sm-3">
            <input id="age" type="text" class="form-control" name="age" value="" placeholder="age">
        </div>
        <%--当用户已经存在时或者pwd不符合格式报错，报错--%>
        <div class="col-sm-3">
            <p id="check_age"></p>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success">添加</button>
        </div>
    </div>
    <a id= "select"href="/selectAll" class="btn btn-info" >查询所有用户的信息</a>

</form>

</body>
</html>
