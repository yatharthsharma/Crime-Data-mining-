/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author compaq
 */


import java.io.*;
public class CriminalAssociation3 {


    public static void main(String[] args)
    {

        String f1="D:/minor2/PROJECTCSV/CriminalSupport.csv";
    String f="D:/minor2/PROJECTCSV/murderersClean.csv";
    try{
    BufferedReader CSVFile = new BufferedReader(new FileReader(f1));
    String dataRow = CSVFile.readLine();

    BufferedReader CSVFile1 = new BufferedReader(new FileReader(f));
    String dataRow1 = CSVFile1.readLine();

    int count=0;
    while(dataRow1!=null)
    {
    count++;
    dataRow1=CSVFile1.readLine();

    }


    double sum=0;
    while(dataRow!=null)
    {
    String[] p =dataRow.split(",");
    //System.out.println("sum wala "+p[3]);
    double d= Double.parseDouble(p[3]);
    sum=sum+d;
    dataRow=CSVFile.readLine();
    }

    CSVFile.close();
    double avg= (double)sum/count;
    System.out.println("threshold is"+avg);

    BufferedReader CSVFile2 = new BufferedReader(new FileReader(f1));
    String dataRow2 = CSVFile2.readLine();

    FileWriter fw= new FileWriter("D:/minor2/PROJECTCSV/CriminalSupportPrune.csv");
    BufferedWriter o = new BufferedWriter(fw);

    while(dataRow2!=null)
    {
    String[] g=dataRow2.split(",");
    //System.out.println("prune wala "+g[3]);
    double m= Double.parseDouble(g[3]);
    if(m>=avg)
    {
    System.out.println("likhaaaa");
    o.write(g[0]);
    o.write(",");
    o.write(g[1]);
    o.write(",");
    o.write(g[2]);
    o.write(",");
    o.write(g[3]);
    o.write("\n");
    }
    dataRow2=CSVFile2.readLine();

    }


    o.close();
    }
    catch(Exception e)
    {
    System.out.println(e);

    }




    }

}
