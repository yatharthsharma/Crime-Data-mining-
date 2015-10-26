/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author compaq
 */


import java.io.*;

public class AssociationConfidence
{

    public void fn()
    {
    try
    {
        String f="D:/minor-both/minorDM/PROJECTCSV/c4.csv";
        String loc="D:/minor-both/minorDM/a1.txt"; //location
        String type="D:/minor-both/minorDM/a2.txt"; // type

        BufferedReader LOC = new BufferedReader(new FileReader(loc));
        String dataRowL = LOC.readLine();

        FileWriter fw= new FileWriter("D:/minor2/PROJECTCSV/confidence4.csv");
        BufferedWriter o = new BufferedWriter(fw);

        int count=0;
        while(dataRowL!=null)
        {
            BufferedReader C = new BufferedReader(new FileReader(type));
            String dataRowV = C.readLine();

            //count=0;
            while(dataRowV!=null)
            {

           BufferedReader L = new BufferedReader(new FileReader(f));
            String dataRow = L.readLine();



            count=0;
            while(dataRow!=null)
            {
            String dataArray[]=dataRow.split(",");
            if (dataArray[6].equals(dataRowL) && dataArray[4].equals(dataRowV))
                count++;
            dataRow=L.readLine();
            }

            L.close();
            o.write(dataRowL); // location
            o.write(",");
            o.write(dataRowV); //type
            o.write(",");
            String s= new Integer(count).toString();
            o.write(s);
            o.write("\n");

        dataRowV=C.readLine();
        //L.close();
        }
       dataRowL=LOC.readLine();
       C.close();
        }
        LOC.close();
    o.close();
    }

    catch(Exception e)
            {System.out.println(e);}
    }


 ////--------------------------------------------------------------------------------------

 public void g()
 {

     try
     {
     String type="D:/minor2/PROJECTCSV/CriminalConfidenceCount.csv";
     BufferedReader C = new BufferedReader(new FileReader(type));
     String dataRow = C.readLine();
     double confidence=0;
     String suppCount="D:/minor2/PROJECTCSV/support4.csv";

     FileWriter fw=new FileWriter("D:/minor2/PROJECTCSV/FinalConfidence4.csv");
     BufferedWriter o=new BufferedWriter(fw);

     while(dataRow!=null)
     {
     String g[]=dataRow.split(",");
     BufferedReader L = new BufferedReader(new FileReader(suppCount));
     String d=L.readLine();
        while(d!=null)
        {
        String h[]=d.split(",");
        if(g[0].equals(h[0]) && g[1].equals(h[1]))
        {
                        double i= Double.parseDouble(g[2]);
        double l=Double.parseDouble(h[2]);
        //System.out.println("l is : "+ l + " i is : "+i);
        if(i!=0)
        {
            confidence =(l / i);
            //System.out.println("confidence is : "+confidence);
        o.write(g[0]);
       o.write(",");
        o.write(g[1]);
        o.write(",");
        String p=new Float(confidence).toString();
        o.write(p);
        o.write("\n");
            }
        }
        d=L.readLine();
        }
    L.close();
    dataRow=C.readLine();

     }

     C.close();
     //o.close();

     }
     catch(Exception e)
     {System.out.println(e);}




 }







//------------------------------------------------------------------------------------------------
    public static void main(String[] args)
    {

    AssociationConfidence ac=new AssociationConfidence();
    ac.g();

    }




}
