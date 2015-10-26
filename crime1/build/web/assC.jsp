<%-- 
    Document   : assC
    Created on : May 8, 2012, 5:52:43 AM
    Author     : compaq
--%>
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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


        <%

        String clus=request.getParameter("clus");
        String loc=request.getParameter("loc");
        String type=request.getParameter("type");
        String time=request.getParameter("time");

        %>
        <table width="100%" border="1">
            <tr>
                <td>Cluster Selected</td>
                <td><%out.println(clus);%></td>
            </tr>

            <tr>
                <td>Location</td>
                <td><%out.println(loc);%></td>
            </tr>

            <tr>
                <td>Crime type</td>
                <td><%out.println(type);%></td>
            </tr>

            <tr>
                <td>Time </td>
                <td><%out.println(time);%></td>
            </tr>
            <tr>
                <td> Percentage Possibility </td>
        <%


        String confidence="D:/minor-both/minorDM/minor2/PROJECTCSV/FinalConfidence"+clus+".csv";
        String supPrune="D:/minor-both/minorDM/minor2/PROJECTCSV/support-prune"+clus+".csv";
        int flag=0;

        BufferedReader C = new BufferedReader(new FileReader(confidence));
        BufferedReader L = new BufferedReader(new FileReader(supPrune));

        String d,g;
        while((d=C.readLine())!=null)
        {
        String[] h = d.split(",");
        if(h[0].equals(loc) && h[1].equals(type))
        {
            while((g=L.readLine())!=null)
            {
            String[] l = g.split(",");
            if(l[0].equals(h[0]) && l[1].equals(h[1]))
            {
                double conf=Double.parseDouble(h[2]);
                double percent=conf*100;
                flag=1;
            %>

                <td><% out.println(percent);%></td>
            </tr>
            <%
            //break;
            }

            }
            //break;
        }
       

        }
        C.close();
         L.close();
        if(flag==0)
        {%>
           <td><% out.println("not a high density!! Pruned out");%></td>
            </tr>
        <%

        }



        %>
        </table>
    </body>
</html>
