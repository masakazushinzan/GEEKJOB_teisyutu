<%-- 
    Document   : whi
    Created on : 2017/05/29, 11:30:12
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
    </body>
</html>

<%
    int num =1000;
    int count = 0;
    while(num<100 == false){
    num = num /2;
    count++;
    }
    out.print(count+"回目のループで終了");
    %>