/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yatharth
 */

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class chk2 {
     class cen
    {
    float cx,cy;
    int size;
    String initial;
    }
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
    
   void chka()
   {
   try{
   FileInputStream fstream = new FileInputStream("D:/minor-both/minorDM/minor2/PROJECTCSV/c1.csv");
       DataInputStream in = new DataInputStream(fstream);
       BufferedReader br = new BufferedReader(new InputStreamReader(in));
     
 String []temp;
String []temp2;
String str,str2;
 
    while ((str = br.readLine()) != null) 
         {
       temp=str.split(",");
       String a= temp[0];
          FileInputStream fstream2 = new FileInputStream("D:/minor-both/minorDM/minor2/PROJECTCSV/c2.csv");
       DataInputStream in2 = new DataInputStream(fstream2);
       BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
       
        while ((str2 = br2.readLine()) != null) 
         {
       temp2=str.split(",");
        if(a.equals(temp2[0]))
        {
      //  System.out.println("oh no");
      //  System.out.println(a+"."+temp2[0]);
                
        }
         
         }
       //  System.out.println("yeah");
         
         }
   }catch(Exception e)
   {
   System.out.println(e);
   }
   
   
   }
    
  
    void plotl()
    {
   try{ 
   
       FileInputStream fstream = new FileInputStream("D:/minor-both/minorDM/clustf.csv");
       DataInputStream in = new DataInputStream(fstream);
       BufferedReader br = new BufferedReader(new InputStreamReader(in));
      
      
      
   FileWriter fw[]=new FileWriter[8];
//  fw[0]=new FileWriter("e:/chk2/c1.csv");
   fw[1]=new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/c2.csv");
   fw[2]=new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/c3.csv");
   fw[3]=new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/c4.csv");
  /* fw[4]=new FileWriter("e:/c5.csv");
   fw[5]=new FileWriter("e:/c6.csv");
   fw[6]=new FileWriter("e:/c7.csv");
   fw[7]=new FileWriter("e:/c8.csv");
   */
   
   String []temp;
     String str;
      String []temp2;
     String str2;
   int flag=0,flag2=0;
    // cen c1 =new cen();
     String str3;
     List inner=new LinkedList();
     List outer=new LinkedList();
     int ctr=0;
     int cnt=0;
     int sizearr;
     int wctr=0;
     int j=0,k=0;
      int len;
     int fctr=0;
     while ((str = br.readLine()) != null) 
         {System.out.println(fctr);
        j=0;
        temp=str.split(",");
        ctr=0;
               if(fctr==1)
        {
        //System.out.println("temp"+temp.length);
        while(j<temp.length)
              {
                  
              //System.out.println("----------");
              FileInputStream fstream1 = new FileInputStream("D:/minor-both/minorDM/fclean2.csv");
              DataInputStream in1 = new DataInputStream(fstream1); 
              BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
               
              
               String a=temp[j];
              
                        while ((str2 = br1.readLine()) != null) 
                         { 
                         k=0;
                     
                            temp2=str2.split(",");
     //    System.out.println("das"+temp2[0]+","+a);
                                if(a.equals(temp2[0]))
                                   {
                                       
                                       while(k<temp2.length)
                                            {
                                                 
                                              fw[fctr].write(temp2[k]+",");
                                                
                                              
                                             k++;
                                           }
                                       ctr++;
                                   
                                       fw[fctr].write("\n");
                                                                          
                                     int r=1;
                                     while(r>0)
                                     {
                                         str3=br1.readLine();
                                       temp2=str3.split(",");
                                       if(temp[j+r].equals(temp2[0]))
                                       {int z=0;
                                            while(z<temp2.length)
                                            {
                                                 
                                              fw[fctr].write(temp2[z]+",");
                                                
                                              
                                             z++;
                                           }
                                             fw[fctr].write("\n");
                                       ctr++;
                                       }
                                       else{
                                           j=j+r;
                                           break;}
                                       r++;
                                     } 
                                       
                                   } 
        
                                
                         }
                        System.out.println(ctr);
                        br1.close();
                j++;
             
      //  fw.write("\n");
        
    } }
 
   
         
    fctr++;     
         }
   
   }
    
    



catch(Exception e)
    {
    System.out.println(e);
    }
    
   
   }
   
   
      
    
   
 
   
  
    
    




  
    
    
    
    
  
    
    void plot()
    {
   try{ 
   
       FileInputStream fstream = new FileInputStream("D:/minor-both/minorDM/outf.csv");
       DataInputStream in = new DataInputStream(fstream);
       BufferedReader br = new BufferedReader(new InputStreamReader(in));
      
      
      
   FileWriter fw[]=new FileWriter[8];
   fw[0]=new FileWriter("D:/minor-both/minorDM/outclus.csv");
   fw[1]=new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/c2.csv");
   fw[2]=new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/c3.csv");
   fw[3]=new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/c4.csv");
   fw[4]=new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/c5.csv");
   fw[5]=new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/c6.csv");
   fw[6]=new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/c7.csv");
   fw[7]=new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/c8.csv");
   
   
   String []temp;
     String str;
      String []temp2;
     String str2;
   int flag=0,flag2=0;
    // cen c1 =new cen();
     
     List inner=new LinkedList();
     List outer=new LinkedList();
     int ctr=0;
     int cnt=0;
     int sizearr;
     int wctr=0;
     int j=0,k=0;
      int len;
     int fctr=0;
     while ((str = br.readLine()) != null) 
         {
             //System.out.println("f"+fctr);
        j=0;
        temp=str.split(",");
        ctr=0;
               if(fctr==0)
        {
        //System.out.println("temp"+temp.length);
        while(j<temp.length)
              {
                  
              //System.out.println("----------");
              FileInputStream fstream1 = new FileInputStream("D:/minor-both/minorDM/fclean2.csv");
              DataInputStream in1 = new DataInputStream(fstream1); 
              BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
               
              
               String a=temp[j];
              
                        while ((str2 = br1.readLine()) != null) 
                         { 
                         k=0;
                     
                            temp2=str2.split(",");
     //    System.out.println("das"+temp2[0]+","+a);
                                if(a.equals(temp2[0]))
                                   {
                                       
                                       while(k<temp2.length)
                                            {
                                                 
                                              fw[fctr].write(temp2[k]+",");
                                                
                                              
                                             k++;
                                           }
                                       ctr++;
                                   
                                       fw[fctr].write("\n");
                                                                          
                                      break;
                                   } 
        
                                
                         }
                   //     System.out.println(ctr);
                        br1.close();
                j++;
             
      //  fw.write("\n");
        
    } }
 
   
         
    fctr++;     
         }
   
   }
    
    



catch(Exception e)
    {
    System.out.println(e);
    }
    
   
   }
   
   
        
  

    
    
     void readout()
    {
    try{
     FileInputStream fstream = new FileInputStream("D:/minor-both/minorDM/outlier.csv");
     DataInputStream in = new DataInputStream(fstream);
     BufferedReader br = new BufferedReader(new InputStreamReader(in));
       
      FileWriter fw = new FileWriter("D:/minor-both/minorDM/outf.csv");
     
               
     
   
    String []temp;
     String str;
      String []temp2;
     String str2;
   int flag=0,flag2=0;
    // cen c1 =new cen();
     cen c2=new cen();
     cen c3=new cen();
     cen c4=new cen();
     List inner=new LinkedList();
     List outer=new LinkedList();
     int ctr=0;
     int cnt=0;
     int sizearr;
     int wctr=0;
     int j=0,k=0;
      int len;
     while ((str = br.readLine()) != null) 
         {
        j=0;
        temp=str.split(",");
        //System.out.println("temp"+temp.length);
        while(j<temp.length)
              {
                  
              //System.out.println("----------");
              FileInputStream fstream1 = new FileInputStream("D:/minor-both/minorDM/core.csv");
              DataInputStream in1 = new DataInputStream(fstream1); 
              BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
               
               if(br1==null)
               {
               System.out.println("acb");
               }
               if(br1!=null)
               {
              // System.out.println("acb");
               }
            //  System.out.println(j);
               String a=temp[j];
              //  in1.reset();
                //fstream1.reset();
                        while ((str2 = br1.readLine()) != null) 
                         { cnt=0;
                         k=0;
                     
                            temp2=str2.split(",");
          //  System.out.println("temp2"+temp2.length);
                                if(a.equals(temp2[0]))
                                   {
                                       while(k<temp2.length)
                                            {
                                                 //System.out.println(k);
                                          fw.write(temp2[k]+",");
                                         
                                             cnt++;
                                             k++;
                                            
                                           }
                                       
                                     System.out.println("cnt"+cnt);
                                      
                                      break;
                                   } 
        
                         }
                        br1.close();
                j++;
             }  
        fw.write("\n");
       
    } 
 
    System.out.println("outlier outer"+outer.size());
    for(int y=0;y<outer.size();y++)
    { List a=(List)outer.get(y);
        
        System.out.println("outlie inner"+a.size());
   
    }}
    
    



catch(Exception e)
    {
    System.out.println(e);
    }
    
    }
    
    void read()
    {
    try{
     FileInputStream fstream = new FileInputStream("D:/minor-both/minorDM/finalcluster.csv");
     DataInputStream in = new DataInputStream(fstream);
     BufferedReader br = new BufferedReader(new InputStreamReader(in));
       
      FileInputStream fstream3 = new FileInputStream("D:/minor-both/minorDM/outlier.csv");
     DataInputStream in3 = new DataInputStream(fstream3);
     BufferedReader br3 = new BufferedReader(new InputStreamReader(in3));
     
      FileWriter fw = new FileWriter("D:/minor-both/minorDM/clustf.csv");
               
     
   
    String []temp;
     String str;
      String []temp2;
     String str2;
   int flag=0,flag2=0;
    // cen c1 =new cen();
     cen c2=new cen();
     cen c3=new cen();
     cen c4=new cen();
     List inner=new LinkedList();
     List outer=new LinkedList();
     int ctr=0;
     int cnt=0;
     int sizearr;
     int wctr=0;
     int j=0,k=0;
      int len;
     while ((str = br.readLine()) != null) 
         {
        j=0;
        temp=str.split(",");
        //System.out.println("temp"+temp.length);
        while(j<temp.length)
              {
                  
              //System.out.println("----------");
              FileInputStream fstream1 = new FileInputStream("D:/minor-both/minorDM/core.csv");
              DataInputStream in1 = new DataInputStream(fstream1); 
              BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
               
               if(br1==null)
               {
               System.out.println("acb");
               }
               if(br1!=null)
               {
              // System.out.println("acb");
               }
            //  System.out.println(j);
               String a=temp[j];
              //  in1.reset();
                //fstream1.reset();
                        while ((str2 = br1.readLine()) != null) 
                         { cnt=0;
                         k=0;
                     
                            temp2=str2.split(",");
          //  System.out.println("temp2"+temp2.length);
                                if(a.equals(temp2[0]))
                                   {
                                       while(k<temp2.length)
                                            {
                                                 //System.out.println(k);
                                                fw.write(temp2[k]+",");
                                          inner.add(temp2[k]);
                                             cnt++;
                                             k++;
                                           }
                                   // System.out.println("cnt"+cnt);
                                      
                                      break;
                                   } 
        
                         }
                        br1.close();
                j++;
             }
        fw.write("\n");
        outer.add(inner);
        inner= new LinkedList();
    } 
 
    System.out.println("outer"+outer.size());
    for(int y=0;y<outer.size();y++)
    { List a=(List)outer.get(y);
        
        System.out.println("inner"+a.size());
   
    }}
    
    



catch(Exception e)
    {
    System.out.println(e);
    }
    
    }
    void finalcluster() 
    {
         
           
     try{
         List plz=new LinkedList(); 
         
          List cluster=new LinkedList();
     int i=0;
     
     FileInputStream fstream = new FileInputStream("D:/minor-both/minorDM/cen.csv");
     DataInputStream in = new DataInputStream(fstream);
     BufferedReader br = new BufferedReader(new InputStreamReader(in));   
 
     FileInputStream fstream1 = new FileInputStream("D:/minor-both/minorDM/core.csv");
     DataInputStream in1 = new DataInputStream(fstream1);
     BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
     
     FileWriter fwout = new FileWriter("D:/minor-both/minorDM/outlier.csv");
 
    FileWriter fw = new FileWriter("D:/minor-both/minorDM/finalcluster.csv");
     String []temp;
     String str;
   int flag=0,flag2=0;
    // cen c1 =new cen();
     cen c2=new cen();
     cen c3=new cen();
     cen c4=new cen();
     List inner=new LinkedList();
     List outer=new LinkedList();
     int ctr=0;
     int sizearr;
     int wctr=0;
     int j=0;
        List out=new LinkedList();
     while ((str = br.readLine()) != null) 
    {   wctr++;
      //  System.out.println(str);
   try
     {   cen c1 =new cen();        
        temp=str.split(",");
        c1.cx=Float.parseFloat(temp[0]);
        c1.cy=Float.parseFloat(temp[1]);
        c1.size=Integer.parseInt(temp[2]);
        c1.initial=temp[3];
    // System.out.println("hjgjj"+c1.size);
        if(c1.size<500)
        {
        out.add(c1);
        fwout.write(c1.initial+",");
        }
        else
        {
  cluster.add(c1);
        }
      //c3=(cen)cluster.get(i);
      //System.out.println("hjgjj"+c3.cx+c3.cy+c3.size);
      //  i++;
    }
    
   catch(Exception e)
    {
        System.out.println("yatharth");
      //  System.out.println(e);
    }
    // c3=(cen)plz.get(i);
   //  System.out.println("hjgjj"+c3.cx+c3.cy+c3.size);  
    //System.out.println(i);
    }
       
     
//          int csize=cluster.size();
         System.out.println("size is"+wctr); 
//          for(j=0;j<csize;j++)
//           {
//           c2=(cen)cluster.get(j);    
//           System.out.println("c9cx abc "+c2.cx+c2.cy);
//           }
//         
           
           List inner2=new LinkedList();  
                       cen c5=new cen();
           for( i=0;i<cluster.size();i++)
           {  flag2=0;
               if(i==0)
               {   
                  
                   c2=(cen)cluster.get(i);
               
                   inner.add(c2);
              //     System.out.println("i==0");
                   outer.add(inner);
               }
               else
               {
                    //System.out.println("i2");
                    c2=(cen)cluster.get(i);
                   
                   // System.out.println("c2cx"+c2.cx);
                    //c3=(cen)cluster.get(i+1);
            /*   if(outer.size()==0)
               {// System.out.println("out==0");
                   
               for(int k=0;k<inner.size();k++)
               {
               c4=(cen)inner.get(k);
          //     System.out.println("c4cx"+c4.cx+c4.cy);
           //   System.out.println("value"+c2.cx+","+c2.cy);
                 float diff= (float) Math.sqrt(Math.pow((c4.cx-c2.cx),2)+Math.pow((c4.cx-c2.cx),2));
               //  fwout.write(diff+"\n");
                 System.out.println("diff"+diff);
                 
               if(diff<0.5)
               {
               inner.add(c2);
              flag=1;
              break;
               }
               }
               if(flag==0)
               {
                   outer.add(inner);
                   inner=new LinkedList();
                   inner.add(c2);
                     outer.add(inner);  
               }
           
               }
               }*/
                       
             //  if(outer.size()!=0)
              // {
                  // System.out.println(outer.size());
                    //System.out.println("out!=0");
                    
               for(int q=0;q<outer.size();q++)
               {
                  // System.out.println("q-->"+q);
                  inner2 =(List)outer.get(q);
                   for(int w=0;w<inner2.size();w++)
                   { 
                       c5=(cen)inner2.get(w);
                       float diff2= (float) Math.sqrt(Math.pow((c5.cx-c2.cx),2)+Math.pow((c5.cx-c2.cx),2));
                       //fwout.write(diff2+"\n");
                     // System.out.println(diff2);
                   if(diff2<(float)0.047)
                   {
                   inner2.add(c2);
                       outer.remove(q);
                    outer.add(inner2);
                  //System.out.println(outer.size());
                    
                  // System.out.println("inneradd");
                   flag2=1;
                   break;
                   }
                   }
//            if(flag2==1)
//                { inner2.add(c2);
//                    outer.remove(q);
//                outer.add(inner2);
//                //System.out.println(outer.size());
//                break;
//                }                 
                   if(flag2==1)
                   {break;}
               }
                
                    if(flag2==0)
                   {
                       
                       //if(outer.size()>5)
                      // {
                      // fwout.write(c2.cx+","+c2.cy+",");
                    //   System.out.println("out");
                       //}
                      // else{
                       inner=new LinkedList();
                       inner.add(c2);
                      // System.out.println("outeradd");
                       outer.add(inner); 
                   //}                  
                   }
                   
             //  }
           
//             /*  for(int j=i+1;j<cluster.size();j++)
//             {
//                 c3=(cen)cluster.get(j);
//              float diff= (float) Math.sqrt(Math.pow((c2.cx-c3.cx),2)+Math.pow((c2.cy-c3.cy),2));
//             if(diff<.5)
//                {
//                   inner.add(c3);
//                }
//             
             }
           }
           
          //System.out.println(outer.size());
            for(int q=0;q<outer.size();q++)
               { 
         
                  inner2 =(List)outer.get(q);
                //  System.out.println(inner.size());
                   for(int w=0;w<inner2.size();w++)
                   { 
                     c5=(cen)inner2.get(w);
                 //    System.out.println(c5.cx);
                   fw.write(c5.initial+",");
                   }
                   fw.write("\n");
               }
           fwout.close();
     fw.close(); 
     } 
     catch(Exception e)
      {  System.out.println("yatharth2");
          System.out.println(e);
          
      }
System.out.println("fcover");
   
    }
    
    void db(){
    
        
        
        
     try{
        
       
      FileInputStream fstream = new FileInputStream("D:/minor-both/minorDM/fclean2.csv");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      FileWriter fw = new FileWriter("D:/minor-both/minorDM/cen.csv");
     FileWriter fwinner = new FileWriter("D:/minor-both/minorDM/core.csv");
      
         
      int minpnts=50,x,y;
      String []temp;
    
      String input;
      int i=0,k=0,flag=0,ctr=0;
      float rad = (float) 0.14;
      String str;
      List inner=new LinkedList();
      List outer=new LinkedList();
      p p5=new p();
      p p1=new p();
    
    while ((str = br.readLine()) != null) 
    {
       
     try
     {
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
    {       
                     
            float diff= (float) Math.sqrt(Math.pow((p1.lat-p5.lat),2)+Math.pow((p1.lon-p5.lon),2));
           if(diff<.41)
            {   innerctr++;
                p5.lat=(float)((p5.lat*(innerctr-1)+p1.lat))/innerctr;
                p5.lon=(float)((p5.lon*(innerctr-1)+p1.lon))/innerctr;
                inner.add(p1);
                fwinner.write(temp[0]+",");
            }
   
            
            else
            { 
                int insize= inner.size();
                
                fw.write(p5.lat+","+p5.lon+","+insize);
                fw.write("\n"); 
                outer.add(inner);                         
                inner=new LinkedList();
                inner.add(p1);
                fwinner.write("\n");
                fwinner.write(temp[0]+",");
                i=0;
                innerctr=1;       
                p5.lat=p1.lat;
                p5.lon=p1.lon;
            }
    }
    
    else
    {
        inner.add(p1);
        fwinner.write(temp[0]+",");
        p5.lon=p1.lon;
        p5.lat=p1.lat;
        i++;
    }
          
          
   }
         
catch(Exception e)
    {System.out.println(e);
    
    }
    
      
         }
    fw.write(p5.lat+","+p5.lon+","+inner.size());
                fw.write("\n"); 
    System.out.println("outer size"+outer.size());
 
fw.close();
   fwinner.close();   
}catch(Exception e)
{
System.out.println(e);

}
     
 
   System.out.println("dbover");
   
    }
    
    
    
    public static void main(String[] args) throws IOException {
    chk2 db1 =new chk2();
       db1.db();
       db1.finalcluster();
  db1.read();
       db1.readout();
   db1.plotl();
    db1.chka();
    //db1.plotvialink();
    }
}
