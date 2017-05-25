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
    String word_b = "A";
    String word_a = "A";
    out.println("開始<br>" );
    for(int i=0; i< 30; i ++ ){
    out.print(word_a);
       out.print ("<br>");
    word_a = word_a + word_b;
    }
    %>