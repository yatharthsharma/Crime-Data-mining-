<%-- 
    Document   : CrimeTypeClustering
    Created on : May 8, 2012, 5:07:58 PM
    Author     : compaq
--%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%!
String loc="D:/a1.txt"; //location
String type="D:/a2.txt"; // type

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <link rel="stylesheet" href="css1.css" type="text/css"/>
    </head>
       <body width="100%" height="100%" background="images/bg.jpg"/>
     <p align="right"><a href="index.jsp">HOME</a> <a href="contact.jsp">CONTACT US</a>
   <u><b><font size="30px" face="courier" color="darkred" style="font-size: 30px" ><center>CRIME INVESTIGATION</center></font></u></b>
 </p>       <img height="250" width="100%" src="images/1.jpg"/>

           <table width="100%">
            <tr>
                <td><img width="100" height="100" src="images/criminal.jpg"/></td>
                <td><center><a href="">INFORMATION RETRIEVAL</a></center></td>

                <td><img width="100" height="100" src="images/GRAPH.gif"/></td>
                <td><center><a href="">TIME SERIES ANALYSIS</a></center></td>

                <td> <img width="100" height="100" src="images/Burglar.gif"/></td>
                <td><center><a href="crime.jsp">CRIME ANALYSIS</a></center></td>

                <td><img width="100" height="100" src="images/CRIMINAL1.jpg"/></td>
                <td><center><a href="criminal.jsp">CRIMINAL ANALYSIS</a></center></td>

                <td><img width="100" height="100" src="images/crim.jpg"/></td>

                <td><a href="view">VIEW CRIMINALS</a></td>

            </tr>

            </table>


        Select Cluster : <select name="clus">
            <option value="">Cluster 1 </option>
            <option value="">Cluster 2 </option>
            <option value="">Cluster 3 </option>
            <option value="">Cluster 4 </option>
            <option value="">Cluster 5 </option>
            <option value="">Cluster 6 </option>

        </select>
            <br><br>


                        Select Crime Type : <select name="type">
                        <%
                        BufferedReader L = new BufferedReader(new FileReader(type));
                        String dataRowV = L.readLine();
                        while(dataRowV!=null)

                        {
                        %>
                        <option value="<%= dataRowV  %>"><% out.println(dataRowV); %></option>

                        <%

                        dataRowV=L.readLine();
                        }
                        L.close();
                        %>
                        </select>
                        <br><br>



                        <input type="submit" value="Find">
            






    </body>
</html>
