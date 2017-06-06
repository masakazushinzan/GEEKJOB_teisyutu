<%-- 
    Document   : test
    Created on : 2017/06/06, 13:38:03
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
        
</html>
<%
//    String ss = (String) request.getParameter("rdoSample1");
    request.setCharacterEncoding("UTF-8");
//    out.print(ss);

    out.print("名前:"+request.getParameter("txtName")+"<br>");
    if(request.getParameter("rdoSample1").equals("1")){
        out.print("性別:男<br>");
    }
    else if(request.getParameter("rdoSample1").equals("0")){
        out.print("性別:女<br>");

    }
//    out.print("性別:"+request.getParameter("rdoSample1")+"<br>");
    out.print("趣味:"+request.getParameter("mulText"));

%>