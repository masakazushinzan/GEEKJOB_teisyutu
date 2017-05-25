<%-- 
    Document   : sisoku
    Created on : 2017/05/25, 10:32:32
    Author     : rui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

<%
    final int BASE  = 200;
    byte num = 16;
    int tasu = BASE + num;
    int hiku = BASE - num;
    int kake = BASE * num;
    int waru = BASE / num;
    int amari = BASE % num;
out.print("足し算" + tasu );
out.print("引き算" + hiku );
out.print("掛け算" + kake );
out.print("割り算" + waru );
out.print("剰余算" + amari );

%>