<%--
  Created by IntelliJ IDEA.
  User: CaihuA
  Date: 2019/3/18
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        <!--上传文件-->
        $(function () {
            $("#upload").click(function () {
                var formdata = new FormData($("#imageupload")[0]);
                $.ajax({
                    url: "${pageContext.request.contextPath}/image/addImage",
                    type: "POST",
                    data: formdata,
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (msg) {
                        alert(msg);
                    }
                })
            })
        })
        <!--下载文件-->
        $(function () {
            $("#download").click(function () {
                $.ajax({
                   url:"${pageContext.request.contextPath}/image/getImage",
                    data:{id:$("input[name='id']").val()},
                    success:function(data){
                       alert(data);
                    }
                });
            })
        })

        $(function(){
            $("#show").click(function(){
               $("#images").append("<img src='${pageContext.request.contextPath}/image/showImage?gid="
                   + $("input[name='gid']").val()+"'>")
            })
        })
    </script>
</head>
<body>
<form id="imageupload" enctype="multipart/form-data">
    <input type="file" name="file" multiple="multiple">
    <p/>
</form>
<input id="upload" type="button" value="上传">
<form action="${pageContext.request.contextPath}/image/getImage" method="get">
    <input type="text" name="id">
    <p/>
    <input id="download" type="button" value="下载">
</form>
<input type="text" name="gid">
<p/>
<input type="button" id="show" value="展示图片">
图片显示区：<span id="images"></span>
</body>
</html>
