<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("UDB");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
        <form action="insertconfirm" method="POST">
            名前:
            <input type="text" name="name" value="<%if(udb.getName()!=null){out.print(udb.getName());} %>">
            <br><br>

            生年月日:　
            <select name="year">
                <option value="">----</option>
                <%
                for (int i = 1950; i <= 2010; i++) {
                String ye = String.valueOf(i);
                %>
                <option value="<%=i%>" <%if(udb.getYear()!=null && udb.getYear().equals(ye)){out.print("selected");}%>> <%=i%> </option>
                <% } %>
            </select>年
            <select name="month">
                <option value="">--</option>
                <%
                for (int i = 1; i <= 12; i++) {
                String mo = String.valueOf(i);
                %>
                <option value="<%=i%>" <%if(udb.getMonth()!=null && udb.getMonth().equals(mo)){out.print("selected");}%> ><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value="">--</option>
                <%
                for (int i = 1; i <= 31; i++) {
                String da = String.valueOf(i);
                %>
                <option value="<%=i%>" <%if(udb.getDay()!=null && udb.getDay().equals(da)){out.print("selected");}%> ><%=i%></option>
                <% }%>
            </select>日
            <br><br>

            種別:
            <br>
            <input type="radio" name="type" <%if(udb.getType()!=null && udb.getType().equals("1")){out.print("checked=checked");} %> value="1">エンジニア<br>
            <input type="radio" name="type" <%if(udb.getType()!=null && udb.getType().equals("2")){out.print("checked=checked");} %> value="2">営業<br>
            <input type="radio" name="type" <%if(udb.getType()!=null && udb.getType().equals("3")){out.print("checked=checked");} %> value="3">その他<br>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%if(udb.getTell()!=null){out.print(udb.getTell());}%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" ><%if(udb.getTell()!=null){out.print(udb.getComment());}%></textarea><br><br>

            <input type="hidden" name="ac"  value="<%= udb.getIsAccess()%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
