/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgfinal;
import java.io.*;

import java.util.*;


/**
 *
 * @author yatharth
 */
public class finalcen {
    
  void map1(){
   
        int ctr=0;
        try{
            String []temp;
        

        
        String input;
    int i=0,flag=0;
      FileInputStream fstream = new FileInputStream("e:/crimeL.csv");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      FileWriter fw = new FileWriter("e:/fclean2.csv");
      String str;
       float  x;
     float y;
     
      
      while ((str = br.readLine()) != null) {
       
          try{
              ctr++;
              temp=str.split(",");
       String lat =temp[12];
        String lon =temp[13];
      // x=Integer.parseInt(lat);
     // y=Integer.parseInt(lon);
      x=Float.parseFloat(lat);
       y=Float.parseFloat(lon);
   if(x==(float)0||y==(float)0)
    {
   System.out.println(x+","+y);
    }
  else
    {
  fw.write(temp[0]+",");
    fw.write(temp[1]+",");
    fw.write(temp[2]+",");
    fw.write(temp[3]+",");
    fw.write(temp[4]+",");
    fw.write(temp[5]+",");
    fw.write(temp[6]+",");
    fw.write(temp[7]+",");
    fw.write(temp[8]+","); 
     fw.write(temp[9]+",");
      fw.write(temp[10]+",");
       fw.write(temp[11]+",");
        fw.write(temp[12]+",");
   fw.write(temp[13]);
     
     
     
     
     fw.write("\n");
    }
      
    
          }
catch(Exception e)
    {System.out.println(e);}
      }
  
}catch(Exception e)
{
System.out.println(e);
}
    System.out.println(ctr);
    }
  
  
  void maxmin()
  {
  try{
  String []temp;
        

        
        String input;
    int i=0,flag=0;
      FileInputStream fstream = new FileInputStream("e:/fclean2.csv");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
     // FileWriter fw = new FileWriter("e:/fclean2.csv");
      String str;
       float  x;
     float y;
     float maxx,maxy;
     double avgx=0,avgy=0;
     double sumx=0,sumy=0;
     int ctr=0;
     // str=br.readLine();
   //   temp=str.split(",");
  //    maxx=Float.parseFloat(temp[12]);
    //  maxy=Float.parseFloat(temp[13]);
      int cx=0;
      int cy=0;
    while ((str = br.readLine()) != null)
    {
       
     try{
     ctr++;
     temp=str.split(",");
     String lat =temp[12];
     String lon =temp[13];
     x=Float.parseFloat(lat);
     y=Float.parseFloat(lon);
     //System.out.println("x is : "+x+" absolute value is : "+Math.abs(x));
     sumx=sumx+Math.abs(x);
 //   System.out.println("sum is : "+sumx);
     sumy=sumy+Math.abs(y);
     //System.out.println(avgx);
     }
    catch(Exception e)
    {System.out.println("assa");
        System.out.println(e);}
      
      }
     System.out.println("ctr "+ctr);
    System.out.println("x sum is : "+sumx);
    System.out.println("y sum is : "+sumy);
    avgx=(float)(sumx/ctr);
    avgy=(float)(sumy/ctr);
    fstream = new FileInputStream("e:/fclean2.csv");
    in = new DataInputStream(fstream);
    br = new BufferedReader(new InputStreamReader(in));
      while ((str = br.readLine()) != null)
    {
       
     try{
     ctr++;
     temp=str.split(",");
     String lat =temp[12];
     String lon =temp[13];
     x=Float.parseFloat(lat);
     y=Float.parseFloat(lon);
     if(Math.abs(x-y)<Math.abs(avgx-avgy))
     {
         cx++;
     }
     else{cy++;}
     avgx=avgx+x;
     avgy=avgy+y;
     }
    catch(Exception e)
    {System.out.println(e);}
      
      }
    
    
    
    
    System.out.println("avgx"+avgx/ctr);
        System.out.println("avgy"+avgy/ctr);
          System.out.println("cx"+cx);
          System.out.println("cy"+cy);
}catch(Exception e)
{
System.out.println(e);
}
  
  }
    
    public static void main(String args[])
    {
    
    finalcen db1 =new finalcen();
    //db1.map1();
    db1.maxmin();
    }
}