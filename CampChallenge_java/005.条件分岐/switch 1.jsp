<%-- 
    Document   : switch 1
    Created on : 2017/05/25, 11:28:53
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
    int num = 4;
    switch(num){
        case 1:
        out.print("one");
        break;
        case 2:
        out.print("two");
        break;
        default:
            out.print("想定外");
           
                
    }            
    %>