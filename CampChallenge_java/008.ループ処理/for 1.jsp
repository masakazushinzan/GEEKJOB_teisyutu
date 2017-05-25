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
     long eight = 8 ;
    for(int i=1; i< 21; i ++ ){
           out.println(eight * 8);
    eight = eight * 8;         
    }
    %>