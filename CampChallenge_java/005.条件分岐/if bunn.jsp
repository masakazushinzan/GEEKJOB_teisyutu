<%-- 
    Document   : if bunn
    Created on : 2017/05/25, 11:09:48
    Author     : rui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE h9tml>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
    </body>
</html>
<%
int num = 3;
 if(num == 1){
     out.print("1です");
 }
 else if(num == 2){
     out.print("プログラムキャンプ");
 }
 else{
     out.print("その他です！");
 }
 %>
 