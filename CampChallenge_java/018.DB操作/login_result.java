/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBsousa;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author rui
 */
public class login_result extends HttpServlet {

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
        Connection db_con = null;
        PreparedStatement db_sel = null;
        PreparedStatement pr_sel = null;
        PreparedStatement db_ins = null;
        ResultSet db_date = null;
        ResultSet db_dateins = null;
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver").newInstance();            
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zaiko_db", "root", "");
            if (request.getParameter("username") != null) {
            db_sel = db_con.prepareStatement("select * from user where userNAME = ?");
                String ID = request.getParameter("username");
                String pass = request.getParameter("password");
                db_sel.setString(1, ID);
                db_date = db_sel.executeQuery();
                while (db_date.next()) {
                    if (ID.equals(db_date.getString("userNAME"))) {
                        if (pass.equals(db_date.getString("password"))) {
                            String url = "./loginsucces.jsp";
                            response.sendRedirect(url);
                        }
                    }
                }
            }
            
            if (request.getParameter("productname") != null) {
            db_ins = db_con.prepareStatement("insert into product(productNAME,stock) values(?,?)");
                String prod = request.getParameter("productname");
                int stoc =Integer.valueOf(request.getParameter("stock"));
                db_ins.setString(1, prod);
                db_ins.setInt(2, stoc);
                db_ins.executeUpdate();
//                db_date = db_ins.executeQuery();
                out.print("商品名:"+prod+"　在庫数:"+stoc+"<br>登録しました");
            out.print("<br><button type=button onclick= location.href='./tourokuform.jsp'>商品登録フォームへ戻る</button>");
            out.print("<br><button type=button onclick= location.href='./loginsucces.jsp'>ログイン後の画面へ戻る</button>");
            }
            else{
                   pr_sel = db_con.prepareStatement("select * from product ");
                db_date = pr_sel.executeQuery();
                        while (db_date.next()) {
                out.println("商品名:"+ db_date.getString("productNAME")+"　　" );
                out.println("在庫数:"+ db_date.getString("stock")+"　　<br>" );

            }
                        out.print("<br><button type=button onclick= location.href='./loginsucces.jsp'>戻る</button>");

            }
            
            
            
            
            db_date.close();
            db_ins.close();
            db_sel.close();
            db_con.close();
            
        } catch (SQLException e_sql) {
            System.out.print("接続時にエラーが発生しました：" + e_sql.toString());            
        } catch (Exception e) {
        } finally {
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e_con) {
                    System.out.print(e_con.getMessage());
                }
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
