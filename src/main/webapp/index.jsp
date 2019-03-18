<%--
  Created by IntelliJ IDEA.
  User: CaihuA
  Date: 2019/3/15
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.7.2.js"></script>
    <script>
        $(function(){
            $("#add").click(function(){
                $.ajax({
                    url:"${pageContext.request.contextPath}/user/addUsers",
                    type:"post",
                    success:function(data){
                        alert(data);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/user/translate">将数据库中的数据添加进缓存</a>
    <input type="button" id="add" value="添加">
</body>
</html>
