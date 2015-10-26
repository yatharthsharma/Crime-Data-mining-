<%-- 
    Document   : AssociationCrime
    Created on : May 7, 2012, 3:11:09 PM
    Author     : compaq
--%>

<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%!
String loc="D:/minor-both/minorDM/a1.txt"; //location
String type="D:/minor-both/minorDM/a2.txt"; // type

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRIME ANALYSIS</title>
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

 <center><h2>ASSOCIATION ANALYSIS OVER CRIME HOT SPOTS</h2></center>
 <br><br><br>
 <center>

     <table>
         <tr><td>
                    <form action="assC.jsp" method="get">


                        <h2>Select cluster </h2>
                        <select name="clus">
                            <option value="1"> Cluster 1 </option>
                            <option value="2"> Cluster 2 </option>
                            <option value="3"> Cluster 3 </option>
                            <option value="4"> Cluster 4 </option>
                            <option value="5"> Cluster 5 </option>
                            <option value="6"> Cluster 6 </option>
                            <option value="7"> Cluster 7 </option>
                            <option value="8"> Cluster 8 </option>
                        </select>

                        <br><br>
                        <h2> Select Location : </h2><select name="loc">
                        <%
                        BufferedReader LOC = new BufferedReader(new FileReader(loc));
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

                        <h2>  Select Crime Type :</h2> <select name="type">
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

                        <h2>Select time : </h2><select name="time">
                            <option value="6pm to 8pm">6pm to 8pm</option>
                            <option value="8pm to 10pm">8pm to 10pm</option>
                            <option value="10pm to 12pm">10pm to 12pm</option>
                        </select>
                        <br><br>

                        <input type="submit" value="Find">

                    </form>
             </td><td><img src="images/AssociationCrime.JPG"/></td></tr>
     </table>




     </center>



        
    </body>
</html>
