<%-- 
    Document   : AssociationCriminal
    Created on : May 8, 2012, 4:18:34 PM
    Author     : compaq
--%>
<%@page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%!
String city="D:/minor-both/minorDM/minor2/PROJECTCSV/criminalAdd.txt"; //city
String type="D:/minor-both/minorDM/minor2/PROJECTCSV/criminalClassification.txt";//type
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

         <center><h2>ASSOCIATION ANALYSIS OVER CRIMINALS</h2></center>
        <center><h3></h3></center>
        <table width="100%">

            <tr>
                <td>

                    <form action="assoCriminal.jsp" method="get">

                     Select City : <select name="city">
                        <%
                        BufferedReader LOC = new BufferedReader(new FileReader(city));
                        String dataRowL = LOC.readLine();
                        while(dataRowL!=null)

                        {
                        %>
                        <option value="<%= dataRowL  %>"><% out.println(dataRowL); %> </option>

                        <%

                        dataRowL=LOC.readLine();
                        }
                        LOC.close();
                        %>
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


                    Select age : <select name="age">
                            <option value="below 18">below 18</option>
                            <option value="18 to 35">18 t0 35</option>
                            <option value="above 35">above 35</option>
                        </select>

                    <br><br>
                        <input type="submit" value="Find">


                    </form>

         </td>
            </tr>
        </table>




    </body>
</html>
