import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class view1 extends HttpServlet {
   
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name=request.getParameter("n");
        try {
             out.println("<body width=\"100%\" height=\"100%\" background=\"images/bg.jpg\"/><p align=\"right\"><a href=\"index.jsp\">HOME</a> <a href=\"contact.jsp\">CONTACT US</a></p><h1 width=\"100%\"><u><font size=\"12px\" face=\"courier\" color=\"red\" ><center>CRIME INVESTIGATION</center></font></u></h1><img height=\"150\" width=\"100%\" src=\"images/1.jpg\"/><table width=\"100%\"><tr><td><img width=\"50\" height=\"50\" src=\"images/criminal.jpg\"/></td><td><center><a href=\"\">INFORMATION RETRIEVAL</a></center></td><td><img width=\"50\" height=\"50\" src=\"images/GRAPH.gif\"/></td><td><center><a href=\"\">TIME SERIES ANALYSIS</a></center></td><td> <img width=\"50\" height=\"50\" src=\"images/Burglar.gif\"/></td><td><center><a href=\"crime.jsp\">CRIME ANALYSIS</a></center></td><td><img width=\"50\" height=\"50\" src=\"images/CRIMINAL1.jpg\"/></td><td><center><a href=\"criminal.jsp\">CRIMINAL ANALYSIS</a></center></td><td ><img width=\"50\" height=\"50\" src=\"images/crim.jpg\"/></td><td><a href=\"view\">VIEW CRIMINALS</a></td></tr></table>");
            Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://localhost:3306/pim";
        Connection conn;
        Statement stmt;
        ResultSet rs;
        conn = DriverManager.getConnection (connectionURL,"root","root");
        stmt = conn.createStatement();
rs=stmt.executeQuery("select * from criminals where name='"+name+"'");
out.println("<center><table border=\"2\">");
while(rs.next())
{out.println("<tr><td><center><img width=\"200\" height=\"200\" src=\""+rs.getString("link")+"\"/></center></tr></td>");
 out.println("<tr><td><center><font size=\"5px\" color=\"red\">ID: </font><font size=\"5\">"+rs.getString("id")+"</font></center></tr></td>");
 out.println("<tr><td><center><font size=\"5px\" color=\"red\">Name: </font><font size=\"5\">"+rs.getString("name")+"</font></center></tr></td>");
 out.println("<tr><td><center><font size=\"5px\" color=\"red\">Date of Birth: </font><font size=\"5\">"+rs.getString("dob")+"</font></center></tr></td>");
 out.println("<tr><td><center><font size=\"5px\" color=\"red\">Height: </font><font size=\"5\">"+rs.getString("ht_f")+" ft"+rs.getString("ht_i")+" in</font></center></tr></td>");
 out.println("<tr><td><center><font size=\"5px\" color=\"red\">Weight: </font><font size=\"5\">"+rs.getString("wt")+"</font></center></tr></td>");
 out.println("<tr><td><center><font size=\"5px\" color=\"red\">Sex: </font><font size=\"5\">"+rs.getString("sex")+"</font></center></tr></td>");
 out.println("<tr><td><center><font size=\"5px\" color=\"red\">Race: </font><font size=\"5\">"+rs.getString("race")+"</font></center></tr></td>");
 out.println("<tr><td><center><font size=\"5px\" color=\"red\">Crime: </font><font size=\"5\"><b>"+rs.getString("crime")+"</b></font></center></tr></td>");
    
}
           out.println("</center></table>");
           out.println();
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
