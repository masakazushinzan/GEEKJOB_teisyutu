/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_sousa;

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
public class DBsousa12 extends HttpServlet {

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
        PreparedStatement db_ins = null;
        ResultSet db_date = null;
        request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            db_ins = db_con.prepareStatement("select* from profiles where name = ? AND age= ? AND birthday = ?");

            if (request.getParameter("name") != null) {
                int age = Integer.valueOf(request.getParameter("age"));
                String name = request.getParameter("name");
                String birth = request.getParameter("birthday");
                db_ins.setString(1, name);
                db_ins.setInt(2, age);
                db_ins.setString(3, birth);

                db_date = db_ins.executeQuery();
                while (db_date.next()) {
                    out.println("ID:" + db_date.getString("profilesID") + "　　");
                    out.println("名前:" + db_date.getString("name") + "　　");
                    out.println("電話番号:" + db_date.getString("tell") + "　　");
                    out.println("年齢:" + db_date.getString("age") + "　　");
                    out.println("生年月日:" + db_date.getString("birthday") + "<br>");
                }
            }

            db_ins.close();
            db_con.close();

        } catch (SQLException e_sql) {
            System.out.print("接続時にエラーが発生しました：" + e_sql.toString());
        } catch (Exception e) {
            System.out.print("例外的なエラーが発生しました：" + e.toString());
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
