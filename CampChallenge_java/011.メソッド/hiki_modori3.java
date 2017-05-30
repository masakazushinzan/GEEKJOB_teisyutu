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

/**
 *
 * @author rui
 */
public class hiki_modori3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

String[] mesoddo(int num){
    String[] prTA={"1","タナカ","1991/4/01","北海道<br>"};
    String[] prKI={"2","キムラ","1991/3/01",null};
    String[] prSU={"3","スズキ","1991/9/02","大阪<br>"};
    String[] none={"","そのIDは存在しません。<br>指定したID："+num};
    int NUMT = Integer.parseInt(prTA[0]);
    int NUMK = Integer.parseInt(prKI[0]);
    int NUMS = Integer.parseInt(prSU[0]);
    
    if(num == NUMT){
            return prTA;
            }
    else if (num == NUMK){
            return prKI;
    }
    else if (num == NUMS){
            return prSU;    
    }
    return none;
    
}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int limit = 2;
            for(int i =1;i<4;i++){
            
            String[] prof=mesoddo(i);
            for (String value:prof){
            if(value == prof[0]){
            }
            else if(value == null){
                out.print("<br>");
                continue;
            }
            else if(i > limit){
                break;
            }
            else{
                out.print(value+"<br>");
            }
            }
            }
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet hiki_modori3</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet hiki_modori3 at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
