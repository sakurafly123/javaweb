<%@ page import="com.sakurafly.pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/21
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询所有人</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script>
    /*Jqury*/
    $(function () {
        //*show.bs.modal当模态框触发show.bs.modal事件时，执行该函数，如果只运行一次可以使.one()
        $('#myModal').on('show.bs.modal', function (event) {

            var button = $(event.relatedTarget) // 找到触发事件的按钮
            console.info(button)
            var num = button.data('info') // 从按钮的data-id 得到需要的属性
            //得到模态框
            var modal = $(this)
            //创建一个ajax请求
            $.ajax({
                type: "POSt",
                url:  "/getUserInfo" ,
                dataType: "json",
                data : {
                    "type": "query",
                    "id": num,
                },
                /*success 回调成功函数*/
                    success: function (data) {
                        $("input[name='Id']").val(data.id);
                        $("input[name='username']").val(data.username);
                        $("input[name='password']").val(data.password);
                        $("input[name='age']").val(data.age);
                },
                error: function () {
                    console.log('fail,');
                }

            })

            // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        })


    })
</script>
<style>
    #add{
        width: 100%;
    }

</style>
<body>

<table class="table table-hover table-bordered" id="show">
    <%List<User> users = (List<User>)request.getAttribute("Users");%>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>age</th>
        <th>disable</th>
    </tr>
    <% for(int i =0;i<users.size();i++){

    %>
    <tr>
        <td><%= users.get(i).getId()%></td>
        <td><%= users.get(i).getUsername()%></td>
        <td><%= users.get(i).getAge()%></td>
        <td><a href="/disabled?id=<%= users.get(i).getId()%>" class="btn btn-danger delet" >删除</a>&nbsp;
            <button id="btn1" class="btn btn-primary "data-toggle="modal" data-target="#myModal" data-info="<%=users.get(i).getId()%>">修改</button>

        </td>
    </tr>


    <%
    }
    %>


</table>
<a id="add" href="/jump/addUser" class="btn btn-info">添加用户</a>


<%--<div class="modal fade" id="#myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">修改信息</h4>
            </div>
            <div class="modal-body">
                <form action="/updateUser" method="post">
                    <div class="form-group">
                        <div class="form-group">
                            <label  class="control-label">id</label>
                            <input type="text" class="form-control"  name="Id" value="">
                        </div>

                        <div class="form-group">
                        <label  class="control-label">用户名</label>
                        <input type="text" class="form-control" name="username" value="">
                        </div>

                        <div class="form-group">
                        <label  class="control-label">密码</label>
                        <input type="text" class="form-control" name="password" value="">
                        </div>

                    <div class="form-group">
                        <label  class="control-label">年龄</label>
                        <input type="text" class="form-control" name="age" value="">
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" id="submit" class="btn btn-primary">修改</button>
                    </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>--%>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">New message</h4>
            </div>
            <div class="modal-body">
                <form action="/updateUser" method="post">
                    <div class="form-group">
                        <label  class="control-label">id</label>
                        <input type="text" class="form-control"  name="Id" value="">
                    </div>

                    <label  class="control-label">用户名</label>
                    <div class="form-group">
                    <input type="text" class="form-control" name="username" value="">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">密码</label>
                        <input type="text" class="form-control" name="password" value="">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">年龄</label>
                        <input type="text" class="form-control" name="age" value="">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" id="submit" class="btn btn-primary">修改</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>

</body>
</html>
