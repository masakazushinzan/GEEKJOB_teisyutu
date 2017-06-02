/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author rui
 */
public class Black_jack extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Dealer_class DEALER = new Dealer_class();
            User_class USER = new User_class();
            DEALER.deal();//ﾃﾞｨｰﾙ側の2枚ドロー
            USER.mycards.add(DEALER.cards.get(0));
            DEALER.cards.remove(0);
            USER.mycards.add(DEALER.cards.get(0));//ユーザ側の2枚ドロー
            DEALER.cards.remove(0);
            USER.checksum();//ユーザーのハンドの合計値をチェック
            DEALER.checksum();//ユーザーのハンドの合計値をチェック
              for(int i =1;i<100;i++){//両者のハンドが14以上になるまでドロー
                    if(USER.result == false){
                    USER.mycards.add(DEALER.cards.get(0));
                    DEALER.cards.remove(0);
                    USER.sum=0;
                    USER.checksum();}
                    else if(DEALER.result == false){
                    DEALER.mycards.add(DEALER.cards.get(0));
                    DEALER.cards.remove(0);
                    DEALER.sum=0;
                    DEALER.checksum();}
                    else if(DEALER.result == true){
                    break;}
            }
                    
            out.print("あなたの合計は" + USER.sum + "<br>" );
            if (USER.sum > 21) {
                out.print("21を超えてしまいました。あなたの負けです。");
            } else if (DEALER.sum > 21) {
                out.print("相手の数は…" + DEALER.sum + "<br>");
                out.print("相手が２１を超えてしまいました。<br>あなたの勝ちです！");
            } else if (USER.sum > DEALER.sum) {
                out.print("相手の数は…" + DEALER.sum + "<br>");
                out.print("相手の数より大きいためあなたの勝ちです！");
            } else if (USER.sum < DEALER.sum) {
                out.print("相手の数は…" + DEALER.sum + "<br>");
                out.print("相手の数より小さいためあなたの負けです…");
            } else {
                out.print("相手の数は…" + DEALER.sum + "<br>");
                out.print("同じ数なので引き分けです。");
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
