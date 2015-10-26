<%-- 
    Document   : unsolved
    Created on : May 7, 2012, 12:06:17 AM
    Author     : Nikita
--%>

<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileInputStream"%>
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
<center>
    <table>
        <tr><td><font size="6px">
<form>
    Height(if 5 feet 6 inches write it as 506)<input type="text" name="height" /><br/>
    Weight(in pounds)<input type="text" name="weight" /><br/>
    Gender(M-male, F=female)<input type="text" name="gender" /><br/>
    Race(B-black, W-white, U-other or unknown)<input type="text" name="race" /><br/>
    <input type="submit" value="Predict the missing value"/>
                </font></td>
<td>
    <img src="images/nn.jpg"/>


</td>
</tr>
</form></table></center>




<%

String h=request.getParameter("height");

String w=request.getParameter("weight");

String gender=request.getParameter("gender");
String race=request.getParameter("race");
if(h=="")
    out.println("<br/>ufff!!!!!");
try{
    double height=0;
    double weight=0;
    
    if(h!="")
        {
height=Double.parseDouble(request.getParameter("height"));
}
    if(w!="")
        {
  weight=Double.parseDouble(request.getParameter("weight"));
    }
if(h!=""){
if(height<=500)
    {
        height=0.1;

    }
 else if(height>=501 && height<=503)
    {
     height=0.2;
 }
    else if(height>=504 && height<=506)
    {
     height=0.3;
 }
    else if(height>=507 && height<=509)
    {
     height=0.4;
 }
    else if(height>=510 && height<=600)
    {
     height=0.5;
 }
    else if(height>=601 && height<=603)
    {
     height=0.6;
 }
    else if(height>=604)
    {
     height=0.7;
 }
}
    if(w!="")
        {


   if(weight<=150)
    {
        weight=0.1;
    }
 if(weight>=151 && weight<=170)
    {
     weight=0.2;
 }
    if(weight>=171 && weight<=190)
    {
     weight=0.3;
 }
    if(weight>=191 && weight<=210)
    {
     weight=0.4;
 }
    if(weight>=211 && weight<=230)
    {
     weight=0.5;
 }
    if(weight>=231)
    {
     weight=0.6;
 }
}
double r;
   if(race.equals("B"))
   {
       r=0.1;

   }
 if(race.equals("W"))
   {
        r=0.2;
 }
   else//(race.equals("U"))
   {
     r=0.3;
 }

double g;

   if(gender.equals("M"))
   {
       g=0.1;

   }
 else
   {
     g=0.2;
 }



double inputlayer[]=new double[3];
double hiddenlayer[]=new double[3];
double inputweights[][] = new double[hiddenlayer.length][inputlayer.length];
 double hiddenoutput[] = new double[hiddenlayer.length];
  double hiddenweights[] = new double[hiddenlayer.length];
  double outputlayer;
if(h!="" && w!="" && gender!="" && race=="")
    {
inputlayer[0]=weight;
inputlayer[1]=height;
inputlayer[2]=g;

    FileInputStream fstream = new FileInputStream("c:/race.txt");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String str;

for(int t=0;t<inputlayer.length;t++)
    {
    for(int u=0;u<inputlayer.length;u++)
        {str = br.readLine();
        inputweights[t][u]=Double.parseDouble(str);
       
        }
    }

      for(int t=0;t<inputlayer.length;t++)
      {
          str=br.readLine();
          hiddenweights[t]=Double.parseDouble(str);
          
      }
      
        int j = 0;
        int k=0;
        hiddenlayer[0]=0;
        hiddenlayer[1]=0;
        hiddenlayer[2]=0;

            while (j < inputlayer.length)
            {
                for (int i = 0; i < inputweights.length; i++) {
                    hiddenlayer[k] += inputlayer[i] * inputweights[i][j];
                }
                   j = j + 1;


            
             k=k+1;
        }
        for (int i = 0; i < inputweights.length; i++) {
            hiddenoutput[i] = ((1-Math.exp(-(hiddenlayer[i])))/(1+Math.exp(-(hiddenlayer[i]))));
           
        }


         outputlayer=0;
        for (int i = 0; i < hiddenweights.length; i++)
        {
            outputlayer += hiddenoutput[i] * hiddenweights[i];
        }


        double o = ((1-Math.exp(-(outputlayer)))/(1+Math.exp(-(outputlayer))));
       

        String ch;
double s1=Math.abs(0.1-o);
double s2=Math.abs(0.2-o);
double s3=Math.abs(0.3-o);
if(s1<s2 && s1<s3)
{
        ch="B";
}
else if(s2<s1 && s2<s3)
{
    ch="W";
}
else
    ch="U";




out.println("<br/><Font size=24px> Predicted Race =" +ch+"</font>");
 

}

else if(h!="" && w=="" && gender!="" && race!="")
    {
    //out.println("ahhhhhhh");
inputlayer[0]=height;
inputlayer[1]=r;
inputlayer[2]=g;

    FileInputStream fstream = new FileInputStream("c:/weights.txt");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String str;

for(int t=0;t<inputlayer.length;t++)
    {
    for(int u=0;u<inputlayer.length;u++)
        {str = br.readLine();
        inputweights[t][u]=Double.parseDouble(str);

        }
    }

      for(int t=0;t<inputlayer.length;t++)
      {
          str=br.readLine();
          hiddenweights[t]=Double.parseDouble(str);

      }

        int j = 0;
        int k=0;
        hiddenlayer[0]=0;
        hiddenlayer[1]=0;
        hiddenlayer[2]=0;

            while (j < inputlayer.length)
            {
                for (int i = 0; i < inputweights.length; i++) {
                    hiddenlayer[k] += inputlayer[i] * inputweights[i][j];
                }
                   j = j + 1;



             k=k+1;
        }
        for (int i = 0; i < inputweights.length; i++) {
            hiddenoutput[i] = ((1-Math.exp(-(hiddenlayer[i])))/(1+Math.exp(-(hiddenlayer[i]))));

        }


         outputlayer=0;
        for (int i = 0; i < hiddenweights.length; i++)
        {
            outputlayer += hiddenoutput[i] * hiddenweights[i];
        }


        double o = ((1-Math.exp(-(outputlayer)))/(1+Math.exp(-(outputlayer))));


        String ch;
double s[]=new double[6];
s[0]=Math.abs(0.1-o);
s[1]=Math.abs(0.2-o);
s[2]=Math.abs(0.3-o);
s[3]=Math.abs(0.4-o);
s[4]=Math.abs(0.5-o);
s[5]=Math.abs(0.6-o);

double small=s[0];
for(int j1=0;j1<6;j1++)
    {
    if(s[j1]<small)
        small=s[j1];
    }

if(small==s[0])
    {
    ch="less than 150";
}
else if(small==s[1])
    {
    ch="151-170";
}
else if(small==s[2])
    {
    ch="171-190";
}
else if(small==s[3])
    {
    ch="191-210";
}
else if(small==s[4])
    {
    ch="211-230";
}
else
    {
    ch="greater than 231";
}
out.println("<br/><Font size=24px> Predicted weight =" +ch+"</font>");
}

else if(w!="" && h.equals("") && gender!="" && race!="")
    {

    //out.println("ahhhhhhhooooooooooooooo");
inputlayer[0]=weight;
inputlayer[1]=r;
inputlayer[2]=g;

    FileInputStream fstream = new FileInputStream("c:/height.txt");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String str;

for(int t=0;t<inputlayer.length;t++)
    {
    for(int u=0;u<inputlayer.length;u++)
        {str = br.readLine();
        inputweights[t][u]=Double.parseDouble(str);

        }
    }

      for(int t=0;t<inputlayer.length;t++)
      {
          str=br.readLine();
          hiddenweights[t]=Double.parseDouble(str);

      }

        int j = 0;
        int k=0;
        hiddenlayer[0]=0;
        hiddenlayer[1]=0;
        hiddenlayer[2]=0;

            while (j < inputlayer.length)
            {
                for (int i = 0; i < inputweights.length; i++) {
                    hiddenlayer[k] += inputlayer[i] * inputweights[i][j];
                }
                   j = j + 1;



             k=k+1;
        }
        for (int i = 0; i < inputweights.length; i++) {
            hiddenoutput[i] = ((1-Math.exp(-(hiddenlayer[i])))/(1+Math.exp(-(hiddenlayer[i]))));

        }


         outputlayer=0;
        for (int i = 0; i < hiddenweights.length; i++)
        {
            outputlayer += hiddenoutput[i] * hiddenweights[i];
        }


        double o = ((1-Math.exp(-(outputlayer)))/(1+Math.exp(-(outputlayer))));


        String ch;
double s[]=new double[7];
s[0]=Math.abs(0.1-o);
s[1]=Math.abs(0.2-o);
s[2]=Math.abs(0.3-o);
s[3]=Math.abs(0.4-o);
s[4]=Math.abs(0.5-o);
s[5]=Math.abs(0.6-o);
s[6]=Math.abs(0.7-o);

double small=s[0];
for(int j1=0;j1<7;j1++)
    {
    if(s[j1]<small)
        small=s[j1];
    }

if(small==s[0])
    {
    ch="less than 500";
}
else if(small==s[1])
    {
    ch="501-503";
}
else if(small==s[2])
    {
    ch="503-506";
}
else if(small==s[3])
    {
    ch="507-509";
}
else if(small==s[4])
    {
    ch="510-600";
}
else if(small==s[5])
    {
    ch="601-603";
}
else
    {
    ch="greater than 604";
}

out.println("<br/><Font size=24px> Predicted Height =" +ch+"</font>");
}

 else if(h!="" && w!="" && gender=="" && race!="")
    {
inputlayer[0]=weight;
inputlayer[1]=r;
inputlayer[2]=height;

    FileInputStream fstream = new FileInputStream("c:/gender.txt");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String str;

for(int t=0;t<inputlayer.length;t++)
    {
    for(int u=0;u<inputlayer.length;u++)
        {str = br.readLine();
        inputweights[t][u]=Double.parseDouble(str);

        }
    }

      for(int t=0;t<inputlayer.length;t++)
      {
          str=br.readLine();
          hiddenweights[t]=Double.parseDouble(str);

      }

        int j = 0;
        int k=0;
        hiddenlayer[0]=0;
        hiddenlayer[1]=0;
        hiddenlayer[2]=0;

            while (j < inputlayer.length)
            {
                for (int i = 0; i < inputweights.length; i++) {
                    hiddenlayer[k] += inputlayer[i] * inputweights[i][j];
                }
                   j = j + 1;



             k=k+1;
        }
        for (int i = 0; i < inputweights.length; i++) {
            hiddenoutput[i] = ((1-Math.exp(-(hiddenlayer[i])))/(1+Math.exp(-(hiddenlayer[i]))));

        }


         outputlayer=0;
        for (int i = 0; i < hiddenweights.length; i++)
        {
            outputlayer += hiddenoutput[i] * hiddenweights[i];
        }


        double o = ((1-Math.exp(-(outputlayer)))/(1+Math.exp(-(outputlayer))));


        String ch;
if(Math.abs(0.1-o)<Math.abs(0.5-o))

    {ch="M";}
else
    {
    ch="F";
}
out.println("<br/><Font size=24px> Predicted Gender =" +ch+"</font>");
}
//out.println();


}
catch(Exception e)
{
     out.println(e);
 }
        


%>
     
    </body>
</html>
