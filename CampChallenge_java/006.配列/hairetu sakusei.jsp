<%-- 
    Document   : hairetu sakusei
    Created on : 2017/05/25, 13:16:25
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

<%@page import = "java.util.ArrayList" %>
<%
    ArrayList<String> data1 = new ArrayList<String>();
    data1.add("10");
    data1.add("100");
    data1.add("soeda");
    data1.add("hayasi");
    data1.add("-20");
    data1.add("118");
    data1.add("END");
    out.print(data1.get(4));
%>    