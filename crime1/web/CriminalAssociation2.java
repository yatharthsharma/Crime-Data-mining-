/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author compaq
 */


import java.io.*;
public class CriminalAssociation2

{

    //String file2="D:/minor2/PROJECTCSV/criminalStreet.txt";
    //String file1="D:/minor2/PROJECTCSV/criminalCountGreat18TempF.csv";
    public void Str()
    {
        String f="D:/minor-both/minorDM/PROJECTCSV/murderersClean.csv";
        String f1="D:/minor-both/minorDM/PROJECTCSV/criminalCountGreat18Count.csv";
        double d;


        try
        {
        BufferedReader CSVFile = new BufferedReader(new FileReader(f));
        String dataRow = CSVFile.readLine();

        FileWriter fw= new FileWriter("D:/minor-both/minorDM/PROJECTCSV/CriminalSupport.csv");
        BufferedWriter o = new BufferedWriter(fw);

        double count=0;

        while(dataRow !=null)
        {
        count++;
        dataRow = CSVFile.readLine();
        }

        CSVFile.close();
//        BufferedReader CSVFile1 = new BufferedReader(new FileReader(f));
//        dataRow = CSVFile1.readLine();
        BufferedReader CountFile = new BufferedReader(new FileReader(f1));
        String dataRow1 = CountFile.readLine();

        int sum=0;

        while(dataRow1!=null)
        {
            String[] k = dataRow1.split(",");
            double i = Double.parseDouble(k[3]);
            d=(double)i/count;
            //sum=sum+d;
            o.write(k[0]);
            o.write(",");
            o.write(k[1]);
            o.write(",");
            o.write(k[2]);
            o.write(",");
            String h=new Double(d).toString();
            o.write(h);
            o.write("\n");
            dataRow1=CountFile.readLine();

        }


        //int avg=(int)sum/count;
        //threshold for pruning is avg

        }
        catch(Exception e)
        {System.out.println(e);}

    }



    public static void main(String[] args)
    {
    CriminalAssociation2 c = new CriminalAssociation2();
    c.Str();

    }

}
