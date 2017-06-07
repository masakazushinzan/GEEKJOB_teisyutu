<%-- 
    Document   : innsuubunkai_risult
    Created on : 2017/06/07, 13:45:23
    Author     : rui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("UTF-8");
    int num = Integer.parseInt(request.getParameter("num"));
    int num2 = num;
    int two = 0;
    int three = 0;
    int five = 0;
    int seventh = 0;
    int eleven = 0;
    for (int i = 0; i < 100; i++) {
        if (num == 2) {
        } else if (num == 3) {
        } else if (num == 5) {
        } else if (num == 7) {
        } else if (num == 11) {
        } else if (num % 2 == 0) {
            num = num / 2;
            two++;
        } else if (num % 3 == 0) {
            num = num / 3;
            three++;
        } else if (num % 5 == 0) {
            num = num / 5;
            five++;
        } else if (num % 7 == 0) {
            num = num / 7;
            seventh++;
        }
    }
    if (num < 10) {//１ケタの因数のみで分解できた場合
        out.print(num2 + "を因数分解すると<br>");
        for (int i = 0; two > i; i++) {
            out.print("2×");
        }
        for (int i = 0; three > i; i++) {
            out.print("3×");
        }
        for (int i = 0; five > i; i++) {
            out.print("5×");
        }
        for (int i = 0; seventh > i; i++) {
            out.print("7×");
        }
        out.print(num);
    }

    if (num > 10) {//２ケタ以上の因数がある場合
        out.print("２ケタ以上の因数が含まれました。<br>元の値："+num2+"<br>１ケタの素因数:");
    if(two>0){
        out.println(2);
    }
    if(three>0){
        out.println(3);
    }
    if(five>0){
        out.println(5);
    }
    if(eleven>0){
        out.println(11);
    }
    out.print("<br>余った値"+num);
    }

%>
<body>
    <br><br><br>
    <a href="./innsuubunkai.jsp"><input type="button" name="modoru" value="戻る"></a><br>
</body>