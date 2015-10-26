<%--
    Document   : nn1
    Created on : May 6, 2012, 11:33:50 AM
    Author     : Nikita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*;" %>
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
        <table border="1">
            <tr><td>SID</td><td>WEIGHT</td><td>RACE</td><td>HEIGHT</td><td>ACTUAL GENDER</td><td>PREDICTED GENDER</td><td>ERRROR</td><td>ERRROR %</td></tr>


        <%!

        class Main {

double err1=0,err2=0,err3=0,err11=0,err22=0,err33=0;
    double[] inputlayer = new double[3];
    double[] hiddenlayer = new double[3];
    double outputlayer;
    double output;
    double inputweights[][] = new double[hiddenlayer.length][inputlayer.length];
    double hiddenweights[] = new double[hiddenlayer.length];
    double hiddenoutput[] = new double[hiddenlayer.length];


    void disp()
    {
        System.out.println("input weights:");
        for(int i=0;i<3;i++)
{
    for(int j=0;j<3;j++)
    {
        System.out.println(inputweights[i][j]);
    }
}
                System.out.println("hidden weights weights:");
for(int i=0;i<3;i++)
{
    System.out.println(hiddenweights[i]);
}
    }

    void getInputValues(double wt,double r,double g) {
   inputlayer[0]=wt;
   inputlayer[1]=r;
   inputlayer[2]=g;
        }


    void getHiddenWeights() {
        System.out.println("enter the values of weights of HIDDEN LAYER to OUTPUT LAYER");

        for (int i = 0; i < hiddenlayer.length; i++) {
            hiddenweights[i]=Math.random() * 1;
            System.out.println(hiddenweights[i]);

        }
    }

    double activationFunction(final double d) {
  // return 1.0 / (1 + Math.exp(-1.0 * d));
  return((1-Math.exp(-d))/(1+Math.exp(-d)));
    }
double activationFunctionDiff(final double d)
    {
return((2*Math.exp(-d))/(Math.pow(1+Math.exp(-d),2)));
//    return (Math.exp(-1.0*d)) / Math.pow((1 + Math.exp(-1.0 * d)),2);

}
    void getInputWeights() {
        System.out.println("enter the values of weights of INPUT LAYER to HIDDEN LAYER");
        for (int i = 0; i < inputlayer.length; i++) {
            for (int j = 0; j < hiddenlayer.length; j++) {
                   inputweights[j][i]=Math.random()*1;
                        System.out.println(inputweights[j][i]);
            }
        }
    }

    void calculateHiddenNodes() {
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
            hiddenoutput[i] = activationFunction(hiddenlayer[i]);

        }

    }


    void setNewWeights(double err)
    {

        err1=hiddenweights[0]*err;
        err2=hiddenweights[1]*err;
        err3=hiddenweights[2]*err;
        err11=inputweights[0][0]*err1+inputweights[0][1]*err2+inputweights[0][2]*err3;
        err22=inputweights[1][0]*err1+inputweights[1][1]*err2+inputweights[1][2]*err3;
        err33=inputweights[2][0]*err1+inputweights[2][1]*err2+inputweights[2][2]*err3;

        inputweights[0][0]+= err1*activationFunctionDiff(hiddenlayer[0])*inputlayer[0];
        inputweights[1][0]+= err1*activationFunctionDiff(hiddenlayer[0])*inputlayer[1];
        inputweights[2][0]+= err1*activationFunctionDiff(hiddenlayer[0])*inputlayer[2];

        inputweights[0][1]+= err2*activationFunctionDiff(hiddenlayer[1])*inputlayer[0];
        inputweights[1][1]+= err2*activationFunctionDiff(hiddenlayer[1])*inputlayer[1];
        inputweights[2][1]+= err2*activationFunctionDiff(hiddenlayer[1])*inputlayer[2];

        inputweights[0][2]+= err3*activationFunctionDiff(hiddenlayer[2])*inputlayer[0];
        inputweights[1][2]+= err3*activationFunctionDiff(hiddenlayer[2])*inputlayer[1];
        inputweights[2][2]+= err3*activationFunctionDiff(hiddenlayer[2])*inputlayer[2];

        hiddenweights[0]+= err*activationFunctionDiff(outputlayer)*hiddenlayer[0];
        hiddenweights[1]+= err*activationFunctionDiff(outputlayer)*hiddenlayer[1];
        hiddenweights[2]+= err*activationFunctionDiff(outputlayer)*hiddenlayer[2];
    }

    double calculateOutput() {
        outputlayer=0;
        for (int i = 0; i < hiddenweights.length; i++)
        {
            outputlayer += hiddenoutput[i] * hiddenweights[i];
        }


        output = activationFunction(outputlayer);

        return output;

    }
     double calculateNewOutput()
    {



       return 1;
     }

}


        %>

     <%

FileInputStream fstream = new FileInputStream("c:/murderers.csv");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));



        Main n = new Main();
       double ht=1;

        String []temp;
        double height;
        double weight;
        String race;
        String gender;
        String type;
        double h=0;
        double wt = 0;
        double err;
        double r = 0;
        double g = 0;
        double o=0;
        double t=0;
        String ch;

        String str;


int count=0;
int first=1;
int i=0;
double errp=0;
str = br.readLine();

for(i=0;i<1000;i++)
    {
    str=br.readLine();
           System.out.println(i);
               str = br.readLine();
           temp=str.split(",");
    height=Double.parseDouble(temp[7]);
    if(height<=500)
    {
        h=0.1;

    }
 else if(height>=501 && height<=503)
    {
     h=0.2;
 }
    else if(height>=504 && height<=506)
    {
     h=0.3;
 }
    else if(height>=507 && height<=509)
    {
     h=0.4;
 }
    else if(height>=510 && height<=600)
    {
     h=0.5;
 }
    else if(height>=601 && height<=603)
    {
     h=0.6;
 }
    else if(height>=604)
    {
     h=0.7;
 }

   weight =Double.parseDouble(temp[8]);
   if(weight<=150)
    {
        wt=0.1;
    }
 if(weight>=151 && weight<=170)
    {
     wt=0.2;
 }
    if(weight>=171 && weight<=190)
    {
     wt=0.3;
 }
    if(weight>=191 && weight<=210)
    {
     wt=0.4;
 }
    if(weight>=211 && weight<=230)
    {
     wt=0.5;
 }
    if(weight>=231)
    {
     wt=0.6;
 }

   race= temp[9];

   if(race.equals("B"))
   {
       r=0.1;

   }
 if(race.equals("W"))
   {
     r=0.2;
 }
   if(race.equals("U"))
   {
     r=0.3;
 }


   gender= temp[10];
   if(gender.equals("M"))
   {
       g=0.1;

   }
 if(gender.equals("F"))
   {
     g=0.5;
 }




n.getInputValues(wt,r,h);
if(first==1)
{first=0;
 n.getInputWeights();
 n.getHiddenWeights();
}

n.calculateHiddenNodes();
o= n.calculateOutput();




//backpropagation

/*err=(g-o);
errp=Math.abs(err)*100;
*/
double prob=0;
if(Math.abs(0.1-o)<Math.abs(0.5-o))

    {ch="m";}
else
    {//o=0.5;
    //prob=(0.5-o)/4;
    ch="f";}

//double prob=

err=(g-o);
errp=Math.abs(err)*100;
out.println("<tr><td>"+i+"</td><td>"+wt+"</td><td>"+r+"</td><td>"+h+"</td><td>"+gender+"</td><td>"+ch+"</td><td>"+err+"</td><td>"+errp+"</td></tr>");

//out.println("<tr><td>"+(i+1)+"</td><td>"+wt+"</td><td>"+r+"</td><td>"+h+"</td><td>"+g+"</td><td>"+o+"</td><td>"+err+"</td><td>"+errp+"</td></tr>");

;

count=0;
while(Math.abs(err)>0.1 && count!=20)
{
        count=count+1;
      n.setNewWeights(err);
      n.calculateHiddenNodes();
      o= n.calculateOutput();
     err=(g-o);
 }

}



i=1000;
while ((str = br.readLine()) != null)
{i++;
    str = br.readLine();
    temp=str.split(",");
    height=Double.parseDouble(temp[7]);
    if(height<=500)
    {
        h=0.1;

    }
 else if(height>=501 && height<=503)
    {
     h=0.2;
 }
    else if(height>=504 && height<=506)
    {
     h=0.3;
 }
    else if(height>=507 && height<=509)
    {
     h=0.4;
 }
    else if(height>=510 && height<=600)
    {
     h=0.5;
 }
    else if(height>=601 && height<=603)
    {
     h=0.6;
 }
    else if(height>=604)
    {
     h=0.7;
 }

    System.out.println("<br/>"+height);
   weight =Double.parseDouble(temp[8]);
   if(weight<=150)
    {
        wt=0.1;
    }
 if(weight>=151 && weight<=170)
    {
     wt=0.2;
 }
    if(weight>=171 && weight<=190)
    {
     wt=0.3;
 }
    if(weight>=191 && weight<=210)
    {
     wt=0.4;
 }
    if(weight>=211 && weight<=230)
    {
     wt=0.5;
 }
    if(weight>=231)
    {
     wt=0.6;
 }

   race= temp[9];

   if(race.equals("B"))
   {
       r=0.1;

   }
 if(race.equals("W"))
   {
     r=0.2;
 }
   if(race.equals("U"))
   {
     r=0.3;
 }


   gender= temp[10];
   if(gender.equals("M"))
   {
       g=0.1;

   }
 if(gender.equals("F"))
   {
     g=0.5;
 }

   n.getInputValues(wt,g,r);
   n.calculateHiddenNodes();
o= n.calculateOutput();
if(Math.abs(0.1-o)<Math.abs(0.5-o))
//if(o==0.1)
    {
   // o=0.1;
    ch="m";}
else
    {//o=0.5;
    ch="f";}



err=(g-o);
errp=Math.abs(err)*100;
out.println("<tr><td>"+i+"</td><td>"+wt+"</td><td>"+r+"</td><td>"+h+"</td><td>"+gender+"</td><td>"+ch+"</td><td>"+err+"</td><td>");%><font color="red"><%out.println(errp);%></font><%out.println("</td></tr>");
i++;
          }
%>

       </table>




</body>
</html>
