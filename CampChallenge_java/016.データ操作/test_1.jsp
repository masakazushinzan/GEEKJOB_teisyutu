<%-- 
    Document   : test
    Created on : 2017/06/09, 16:43:18
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
        <form action="./test_result.jsp" method=get>

            <%  request.setCharacterEncoding("UTF-8");
                HttpSession hs = request.getSession();
    int intervalTime = session.getMaxInactiveInterval();

//                hs.setAttribute("name", request.getParameter("namae"));
//                hs.setAttribute("sei", request.getParameter("seibetu"));
//                hs.setAttribute("syumi", request.getParameter("mulText"));
            %>
            名前:<input type=text name=namae size=7 
                      <%  Object d_name = hs.getAttribute("name");
                  if (hs.getAttribute("name") != null) {
                      out.print("value=" + d_name);
                  }%>>

            性別:男<input type=radio name=seibetu value=0 
                       <%  Object d_sei = hs.getAttribute("sei");
                  if (hs.getAttribute("sei") !=null){
                          if(hs.getAttribute("sei").equals("0")){
                      out.print("checked=checked");
                  }}%>> 
            女<input type=radio name=seibetu value=1
                    <% if(hs.getAttribute("sei") !=null){
                        if ((d_sei).equals("1")) {
                      out.print("checked=checked");
                  }}%>><br>
            趣味:<textarea name="mulText" ><%
                if(hs.getAttribute("sei") !=null){
                    out.print(hs.getAttribute("syumi"));
                }
                %></textarea><br>
            <input type=submit value=送信>

            <%

                hs.setAttribute("name", request.getParameter("namae"));
                hs.setAttribute("sei", request.getParameter("seibetu"));
                hs.setAttribute("syumi", request.getParameter("mulText"));

            %>

        </form>

    </body>
</html>
