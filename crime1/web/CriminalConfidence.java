/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author compaq
 */


import java.io.*;
public class CriminalConfidence
{
    
    public void mn ()
    {
     
     try
     {
     
         String f="D:/minor-both/minorDM/PROJECTCSV/murderersClean.csv"; // used
         String city="D:/minor-both/minorDM/PROJECTCSV/criminalAdd.txt"; //city
         String type="D:/minor-both/minorDM/PROJECTCSV/criminalClassification.txt";//type
      
      
     FileWriter fw= new FileWriter("D:/minor2/PROJECTCSV/CriminalConfidenceCount.csv");
     BufferedWriter o = new BufferedWriter(fw); 
     
     BufferedReader LOC = new BufferedReader(new FileReader(city));
     String dataRowL = LOC.readLine();
     
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
            //int t=Integer.parseInt(dataArray[15]);
            if (dataArray[4].equals(dataRowL) && dataArray[13].equals(dataRowV))
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



     public void g()
    {

     try
     {
     String type="D:/minor2/PROJECTCSV/CriminalConfidenceCount.csv";
     BufferedReader C = new BufferedReader(new FileReader(type));
     String dataRow = C.readLine();
     double confidence=0;
     String suppCount="D:/minor2/PROJECTCSV/CriminalSupport.csv";

     //FileWriter fw=new FileWriter("D:/minor2/PROJECTCSV/FinalCriminalConfidence1.csv");
     //BufferedWriter o=new BufferedWriter(fw);

     while(dataRow!=null)
     {
     String g[]=dataRow.split(",");
     BufferedReader L = new BufferedReader(new FileReader(suppCount));
     String d=L.readLine();
        while(d!=null)
        {
        String h[]=d.split(",");
        if(g[0].equals(h[1]) && g[1].equals(h[0]))
        {
        double i= Double.parseDouble(g[2]);
        double l=Double.parseDouble(h[3]);
        //System.out.println("l is : "+ l + " i is : "+i);
        if(i!=0)
        {
            confidence =(l / i);
            System.out.println("l is : "+l+" --- i is : ------"+i+" ---confidence is : ----"+confidence);
            //System.out.println("i is : "+i);
            //System.out.println("confidence is : "+confidence);
       // o.write(g[0]);
        //o.write(",");
        //o.write(g[1]);
        //o.write(",");
        //o.write(h[2]);
        //o.write(",");
        //String p=new Float(confidence).toString();
        //o.write(p);
        //o.write("\n");
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









    
    
    public static void main(String[] args)
    {
    CriminalConfidence cc = new CriminalConfidence();
    cc.g();
    
    }

}
