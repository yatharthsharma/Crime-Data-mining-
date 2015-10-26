/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author yatharth
 */

import java.io.*;
import java.util.*;

class p
    {
        String ccode,date,addres,crime,crimed,area,arrest,domes,beat;
                int x,y,year;
    float lat;
    float lon;

        public p() {
            this.ccode = "";
            this.date = "";
            this.addres = "";
            this.crime ="";
            this.crimed = "";
            this.area = "";
            this.arrest = "";
            this.domes = "";
            this.beat = "";
            this.x = 0;
            this.y = 0;
            this.year = 0;
            this.lat = (float)0.0;
            this.lon = (float)0.0;
        }

    }




public class hdgh 
{
     class cen
    {
    float cx,cy;
    int size;
    String initial;
    }
    public  void db(){
    
        
        
        
     try{
        
       
      FileInputStream fstream = new FileInputStream("e:/fclean2.csv");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      FileWriter fw = new FileWriter("e:/test/cen.csv");
     FileWriter fwinner = new FileWriter("e:/test/core.csv");
      
         
      int minpnts=50,x,y;
      String []temp;
    
      String input;
      int i=0,k=0,flag=0,ctr=0;
      float rad = (float) 0.14;
      String str;
      List inner=new LinkedList();
      List outer=new LinkedList();
      p p5=new p();
     
    p p2=new p();
    while ((str = br.readLine()) != null) 
    {
       
     try
     { p p1=new p();
        int innerctr=0;
        ctr++;
             //  System.out.println(ctr);
        temp=str.split(",");
              
   p1.ccode=temp[0];
 
   p1.date =temp[1];

   p1.addres= temp[2];
      
   p1.beat =temp[3];
   p1.crime= temp[4];
   p1.crimed= temp[5];
   p1.area= temp[6];
   p1.arrest=temp[7];
  
   p1.domes=temp[8];
    
   p1.x=Integer.parseInt(temp[9]);
   p1.y=Integer.parseInt(temp[10]);
   
   p1.year= Integer.parseInt(temp[11]);
  
  String lat =temp[12];
  String lon =temp[13];
  //System.out.println(temp[13]);
              
                p1.lat=Float.parseFloat(lat);
                p1.lon=Float.parseFloat(lon);
   //    System.out.println("new value is : "+p1.lat+p1.lon);
   
    int size=inner.size();
  
    /*for(k=0;k<size;k++)
    {
        p p2=new p();
    p2 = (p)inner.get(k);
      
       System.out.println("values"+k+" ,"+p2.lat+p2.lon);
    
    }*/
   
    
    if(i>0)
    {       flag=0;
                     for(int q=0;q<outer.size();q++)
                     {
                      inner=(List)outer.get(q);
                      innerctr=0;
                   for(int e=0;e<inner.size();e++)
                   {
                       p2=(p)inner.get(e);
                   
               //  System.out.println("lat"+p1.lat+p2.lat);
                    float diff= (float) Math.sqrt(Math.pow((p1.lat-p2.lat),2)+Math.pow((p1.lon-p2.lon),2));
                  //  System.out.println("diff"+diff);
                        if(diff<.3)
                         { 
                             innerctr++;
                         }
                      else{
                       break;
                          }
                  }
                   if(innerctr==inner.size())
                   {
                   inner.add(p1);
                outer.remove(q);
                outer.add(inner);
                flag=1;
                break;
             //   fwinner.write(temp[0]+",");
                   }
                           
                    }
                     if(flag==0)
                     {System.out.println("f0");
                     inner=new LinkedList();
                     inner.add(p1);
                     outer.add(inner);
                     
                     }
    }
    else
    {
        inner.add(p1);
        outer.add(inner);
     //   fwinner.write(temp[0]+",");
      //  p5.lon=p1.lon;
       // p5.lat=p1.lat;
        i++;
    }
          
                   
                   }
                     
           
catch(Exception e)
    {System.out.println(e);
    
    }
    
    }
     for(int q=0;q<outer.size();q++)
         
     {
     inner=(List)outer.get(q);
     for(int e=0;e<inner.size();e++)
     {
     p2=(p)inner.get(e);
     fwinner.write(p2.ccode+",");
          
     }
     
     fwinner.write("\n");

     }
     
     }  
     
catch(Exception e)
{
System.out.println(e);

}
     
 
   System.out.println("dbover");
   
    }
    
    
    
    public static void main(String[] args) throws IOException {
       hdgh db1 =new hdgh();
      db1.db();
  // db1.finalcluster();
 // db1.read();
    //   db1.readout();
  //   db1.plotl();
       //db1.plotvialink();
    }
}


