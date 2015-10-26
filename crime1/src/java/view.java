import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class view extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<body width=\"100%\" height=\"100%\" background=\"images/bg.jpg\"/><p align=\"right\"><a href=\"index.jsp\">HOME</a> <a href=\"contact.jsp\">CONTACT US</a></p><h1 width=\"100%\"><u><font size=\"12px\" face=\"courier\" color=\"red\" ><center>CRIME INVESTIGATION</center></font></u></h1><img height=\"150\" width=\"100%\" src=\"images/1.jpg\"/><table width=\"100%\"><tr><td><img width=\"50\" height=\"50\" src=\"images/criminal.jpg\"/></td><td><center><a href=\"\">INFORMATION RETRIEVAL</a></center></td><td><img width=\"50\" height=\"50\" src=\"images/GRAPH.gif\"/></td><td><center><a href=\"\">TIME SERIES ANALYSIS</a></center></td><td> <img width=\"50\" height=\"50\" src=\"images/Burglar.gif\"/></td><td><center><a href=\"crime.jsp\">CRIME ANALYSIS</a></center></td><td><img width=\"50\" height=\"50\" src=\"images/CRIMINAL1.jpg\"/></td><td><center><a href=\"criminal.jsp\">CRIMINAL ANALYSIS</a></center></td><td ><img width=\"50\" height=\"50\" src=\"images/crim.jpg\"/></td><td><a href=\"view\">VIEW CRIMINALS</a></td></tr></table>");
            Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://localhost:3306/pim";
        Connection conn;
        Statement stmt;
        ResultSet rs;
        conn = DriverManager.getConnection (connectionURL,"root","root");
        stmt = conn.createStatement();
        rs=stmt.executeQuery("select * from criminals");
        

        out.println("<table border=\"2\">");
        while(rs.next())
        {
            //http://localhost:8080/crime1/crime1/view1?n=nikita
            out.println("<tr><td><font size=\"5px\"><br/>"+rs.getString("id")+"</font></td>");
            //out.println("<tr><td><img width=\"100\" height=\"100\" src=\""+rs.getString("link")+"\"/></td></tr>");
            out.println("<td><font size=\"5px\"> <a href=\"view1?n="+rs.getString("name")+"\">"+rs.getString("name")+"</font></a></td></tr>");

 


        }
        } 
        catch(Exception exc)
        {
        out.println(exc);
        }
finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
