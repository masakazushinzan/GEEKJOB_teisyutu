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
public class DBsousa9 extends HttpServlet {

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
        PreparedStatement db_ins = null;
        ResultSet db_date = null;
        ResultSet db_dateins = null;
        request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver").newInstance();            
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            db_ins = db_con.prepareStatement("insert into profiles (profilesID,name,tell,age) values(?,?,?,?)");
            db_sel = db_con.prepareStatement("select * from profiles");
            
            System.out.print(request.getParameter("ID"));
            
            if (request.getParameter("ID") != null){
                int ID = Integer.valueOf(request.getParameter("ID"));//ここをintに変換
                String tell = request.getParameter("tellT");
                int age = Integer.valueOf(request.getParameter("ageT"));//ここも変換
                String name = request.getParameter("nameT");
//                String birth = request.getParameter("birthdayT");                
            db_ins.setInt(1,ID);//１個めの？に入れる値の指定
            db_ins.setString(2,name);//２個めの？に入れる値の指定
            db_ins.setString(3,tell);//３個めの？に入れる値の指定
            db_ins.setInt(4,age);//４個めの？に入れる値の指定
//            db_ins.setString(5,birth);//５個めの？に入れる値の指定
            db_ins.executeUpdate();
            db_dateins=db_ins.executeQuery();
            db_date = db_sel.executeQuery();            
            while (db_date.next()) {
                out.println("ID:"+ db_date.getString("profilesID")+"　　" );
                out.println("名前:"+ db_date.getString("name")+"　　" );
                out.println("電話番号:"+ db_date.getString("tell")+"　　" );
                out.println("年齢:"+ db_date.getString("age")+"　　" );
//                out.println("生年月日:"+ db_date.getString("birthday") + "<br>");
            }
            }
            else{
            db_date = db_sel.executeQuery();            
            while (db_date.next()) {
                out.println("ID:"+ db_date.getString("profilesID")+"　　" );
                out.println("名前:"+ db_date.getString("name")+"　　" );
                out.println("電話番号:"+ db_date.getString("tell")+"　　" );
                out.println("年齢:"+ db_date.getString("age")+"　　" );
                out.println("生年月日:"+ db_date.getString("birthday") + "<br>");
            }
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
