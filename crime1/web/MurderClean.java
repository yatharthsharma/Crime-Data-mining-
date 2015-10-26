/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author compaq
 */

import java.io.*;




public class MurderClean
{
   void map1()
   {

        int ctr=0;
        try
       {
       String []temp;
       String input;
       int i=0,flag=0;
       FileInputStream fstream = new FileInputStream("D:/minor-both/minorDM/PROJECTCSV/murderers.csv");
       DataInputStream in = new DataInputStream(fstream);
       BufferedReader br = new BufferedReader(new InputStreamReader(in));
       FileWriter fw = new FileWriter("D:/minor-both/minorDM/PROJECTCSV/murderersClean.csv");
       String str;



       while ((str = br.readLine()) != null)
       {

       try
       {
                ctr++;
                int j=0,flagS=0;
                temp=str.split(",");
                int len=temp.length;
                System.out.println(len);
                while(j<len)
                {

                    String h= temp[j];
                    if(h.equals("0"))
                    {
                        System.out.println("aayyaaa");
                        flagS=1;
                    }

                j++;
                }

                if(flagS!=1)
                {
                int p=0;
                while(p<len)
                {

                    fw.write(temp[p]);
                    fw.write(",");
                    p++;
                }

                fw.write("\n");
                }
    }



        catch(Exception e)
        {
            System.out.println(e);
        }
        }

}

        catch(Exception e)
        {
            System.out.println(e);
        }

        //System.out.println(ctr);
    }



    public static void main(String args[])
    {

    MurderClean db1 =new MurderClean();
    db1.map1();
    }
}
