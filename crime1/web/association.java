
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class anu
    {
    String location;
    String c_type;
    int count;




    public anu()
    {
    location="null";
    c_type="null";
    count=0;
    }

    }


public class association
{


    public static void main(String[] args) throws FileNotFoundException, IOException
    {
      FileWriter fw= new FileWriter("D:/minor-both/minorDM/PROJECTCSV/count.csv");
      BufferedWriter o = new BufferedWriter(fw);
       List ll=new LinkedList();  // linked list for the time range of 18-20
       int count=0;

        String f="D:/minor-both/minorDM/cnewf.csv";
        String loc="D:/minor-both/minorDM/a1.txt"; //location wala
        String type="D:/minor-both/minorDM/a2.txt";//type


        BufferedReader LOC = new BufferedReader(new FileReader(loc));
        String dataRowL = LOC.readLine();

         while(dataRowL!=null)//location
             {
                String m=dataRowL;
                //System.out.println("Location is "+dataRowL);
                BufferedReader Type = new BufferedReader(new FileReader(type));
                String dataRowT = Type.readLine();
                while(dataRowT!=null)//crime type
                    {
                        String dd=dataRowT;
                       // System.out.println("crime type is "+dataRowT);
                        BufferedReader CSVFile = new BufferedReader(new FileReader(f));
                        //if(CSVFile!=null)
                            //{//System.out.println("arey chal gaya!");}
                        String dataRow = CSVFile.readLine();

                        count=0;
                        while (dataRow != null)
                        {
                         String[] dataArray = dataRow.split(",");
                         String[] h=dataArray[1].split(" ");
                         //System.out.println(g[1]);
                         String l[]=h[1].split(":");
                         //System.out.println(l[0]);
                         if(l[0].equals("18")||l[0].equals("19"))
                         {
                             if(dataArray[4].equals(dd) && dataArray[6].equals(m))
                            {
                                 //System.out.println("loc is "+dd+" type is"+m+"time is"+l[0]);
                                 count++;
                            }
                         }
                        dataRow = CSVFile.readLine();
                        }
                        //p++;
                        anu a = new anu();
                        a.location=m;
                        o.write(m);
                        a.c_type=dd;
                        o.write(",");
                        o.write(dd);
                        o.write(",");
                        a.count=count;
                        String h=new Integer(count).toString();
                        o.write(h);
                        o.write("\n");
                        System.out.println("count is : "+count);
                        ll.add(a);
                        
                        CSVFile.close();
                        dataRowT = Type.readLine();
                }
                //j++;
       Type.close();
       dataRowL = LOC.readLine();
       }
            LOC.close();

        //}

        //anu ap= (anu)ll.get(5);
        //System.out.println("type of crime is : "+ap.c_type);
        //System.out.println("location of crime is :"+ap.location);
        //System.out.println("count of crime is: "+ap.count);
                        
o.close();
    }

}
