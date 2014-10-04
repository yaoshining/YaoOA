<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <base href="<%=request.getContextPath()+"/"%>" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="resources/scripts/jquery.min.js"></script>
        <script type="text/javascript">
            $(function(){
                $("#detailBtn").on("click",function(){
                    var url = "users/"+$("#inputName").val();
                    $.getJSON(url,function(data){
                        $.each(data,function(i,e){
                            $("#"+i).text(e);
                        });
                    });
                });
            })
        </script>
    </head>
    <body>
        <input id="inputName" type="text" /><button id="detailBtn">详情</button>
        <table>
            <tr>
                <td>用户名：</td>
                <td id="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td id="password"></td>
            </tr>
            <tr>
                <td>是否启用：</td>
                <td id="enabled"></td>
            </tr>
        </table>
    </body>
</html>
