<%-- 
    Document   : for 1
    Created on : 2017/05/25, 14:36:29
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
    int num = 0;
    out.println("開始<br>" );
    for(int i=0; i< 101; i ++ ){
    out.print(num+i);
    out.print("（" + num + "+" + i +"）" );
       out.print ("<br>");
    num =num + i;
    }
    %>