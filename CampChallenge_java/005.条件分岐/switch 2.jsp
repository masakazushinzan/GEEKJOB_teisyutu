<%-- 
    Document   : switch 2
    Created on : 2017/05/25, 11:37:22
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
    String word = "A";
    switch(word){
            case "A":
            out.print("英語");
            break;
            case"あ":
                out.print("日本語");
                break;
    }
    %>