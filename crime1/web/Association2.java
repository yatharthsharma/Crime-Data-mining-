
import java.io.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author compaq
 */
public class Association2
{
    public static void main(String[] args)
    {
        String f="D:/minor-both/minorDM/PROJECTCSV/c3.csv";
        String f1="D:/minor-both/minorDM/PROJECTCSV/count3.csv";
        double d;


        try
        {
        BufferedReader CSVFile = new BufferedReader(new FileReader(f));
        String dataRow = CSVFile.readLine();

        FileWriter fw= new FileWriter("D:/minor2/PROJECTCSV/support3.csv");
        BufferedWriter o = new BufferedWriter(fw);

        int count=0;

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
            int i = Integer.parseInt(k[2]);
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

}
