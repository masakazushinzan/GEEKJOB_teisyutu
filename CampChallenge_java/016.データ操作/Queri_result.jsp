<%-- 
    Document   : Queri_result
    Created on : 2017/06/07, 11:13:28
    Author     : rui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    request.setCharacterEncoding("UTF-8");
    int t = Integer.parseInt(request.getParameter("total"));
    int c = Integer.parseInt(request.getParameter("count"));
    int ty = Integer.parseInt(request.getParameter("type"));

    out.print("総額" + request.getParameter("total") + "円<br>");
    if(ty ==1){
    out.print("購入する商品：雑貨<br>");
    }
    else if(ty ==2){
    out.print("購入する商品：生鮮食品<br>");
    }
    else if(ty ==3){
    out.print("購入する商品：その他<br>");
    }
    out.print("個数" + request.getParameter("count") + "個(１個あたり" + t / c + "円）<br><br>");
    if (t > 4999) {
        double p = t * 0.05;
        out.print("5000円以上購入されたため、5％のポイント(" + ((int) p) + ")が付きました。");
    } else if (t > 2999) {
        double p = t * 0.04;
        out.print("3000円以上購入されたため、4％のポイント(" + ((int) p) + ")が付きました。");
    }
%>
<body>
    <br><br><br>
    <a href="./Queri.jsp"><input type="button" name="modoru" value="戻る"></a><br>
</body>