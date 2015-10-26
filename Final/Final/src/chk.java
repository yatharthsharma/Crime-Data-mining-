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

public class chk {
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
    float cenx1,cenx2;

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
             this.cenx1 = (float)0.0;
            this.cenx2 = (float)0.0;
        }

    }
    
   
    void plzz()
    
    {        
     try{
        
       
      FileInputStream fstream = new FileInputStream("e:/fclean2.csv");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
       
   
      FileInputStream fstream2 = new FileInputStream("e:/apriori.csv");
      DataInputStream in2 = new DataInputStream(fstream2);
      BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
      
      FileWriter fw = new FileWriter("e:/test/cen.csv");
      FileWriter fwinner = new FileWriter("e:/test/core.csv");
      int minpnts=50,x,y;
      String []temp;
      String []temp2;
      String input;
      int i=0,k=0,flag=0,ctr=0;
      float rad = (float) 0.14;
      String str,str2;
      List inner=new LinkedList();
      List outer=new LinkedList();
      p p5=new p();
    //  p p1=new p();
    p p2=new p();
      p p3=new p();
       List chk2 =new LinkedList();
   // List chk=new LinkedList(); 
    while ((str = br.readLine()) != null) 
    {
       flag=0;
     try
     {
        int innerctr=0;
        ctr++;
        temp=str.split(",");  
        p p1 =new p();
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
       p1.lat=Float.parseFloat(lat);
       p1.lon=Float.parseFloat(lon);
   //   int size=inner.size();
      int size2=outer.size();
  int w=0;
 // System.out.println("crimef"+flag);
   
       if(i>0)
             {    
                 for(w=0;w<size2;w++)
                 { 
                
                  chk2=(List)outer.get(w);
                  int sizechk=chk2.size();
                 // System.out.println("chk2size"+chk2.size());
                  p2=(p)chk2.get((sizechk-1));
             //  System.out.println(w+p1.crime+","+p2.crime);
                  //if(p2.crime.equals(p1.crime))
                         //System.out.println(p2.ccode);
               //  System.out.println("yeah equeal");
                   // System.out.println("values"+p2.cenx1+","+p2.cenx2);
                  float diff= (float) Math.sqrt(Math.pow((p1.lat-p2.cenx1),2)+Math.pow((p1.lon-p2.cenx2),2));
                  //System.out.println(p1.lat+","+p2.cenx1);
           //     System.out.println("diff"+diff);
                //   System.out.println(p2.cenx1);   
                  if(diff<.37)
                         {
                             innerctr++;
                //p5.lat=(float)((p5.lat*(innerctr-1)+p1.lat))/innerctr;
               // p5.lon=(float)((p5.lon*(innerctr-1)+p1.lon))/innerctr;
                  // System.out.println(chk2.size()+"<---size");
                       p1.cenx1=(float)((p1.lat+(chk2.size())*p2.cenx1)/(chk2.size()+1));
                       p1.cenx2=(float)((p1.lon+(chk2.size())*p2.cenx2)/(chk2.size()+1));
                      // System.out.println("values"+p1.cenx1+","+p1.cenx2);
                     // System.out.println("as"+p1.cenx1);   
                             chk2.add(p1);
              // System.out.println(chk2.size()+"<---size");
                       //    System.out.println("bef"+outer.size());
                             outer.remove(w);
                          //     System.out.println("af"+outer.size());
                             outer.add(chk2);
                         //     System.out.println("fin"+outer.size());
               // fwinner.write(temp[0]+",");
                               flag=1;
                                break;
                        }
                       else
                        {             
                
                        }
          //   System.out.println("flaag1");
                       
 
                 }
                 if(flag==0)
                 {
                     //System.out.println("flaag0");
                 List inner2=new LinkedList();
                 p1.cenx1=p1.lat;
                 p1.cenx2=p1.lon;
                 inner2.add(p1);
                  //System.out.println("values"+p1.cenx1+","+p1.cenx2);
                // outer = new LinkedList();
                 outer.add(inner2);
             //  System.out.println(outer.size());
                 }
          
    }
    
    else
    {
        inner = new LinkedList();
       //   System.out.println("i==0"+p1.crime+","+p2.crime);
    p1.cenx1=p1.lat;
            p1.cenx2=p1.lon;
         //    System.out.println("values"+p1.cenx1+","+p1.cenx2);
           //  System.out.println(p1.cenx1);
        inner.add(p1);
        outer.add(inner);
      //  fwinner.write(temp[0]+",");
   //     p5.lon=p1.lon;
   //     p5.lat=p1.lat;
        i++;
    }
    
       
   }
         
catch(Exception e)
    {System.out.println(e);
    
    }
    
      
         }
    System.out.println("outer.size"+outer.size());
       
    
 for(i=0;i<outer.size();i++)
 {
    List chk = (List)outer.get(i);
     System.out.println("chk.size"+chk.size()); 
for(int j=0;j<chk.size();j++)
{
      p3  = (p)chk.get(j);
 //  System.out.println("s"+chk.size());
fw.write(p3.ccode+",");

}
 fw.write("\n");
 }
 
fw.close();
   fwinner.close();   
}catch(Exception e)
{
System.out.println(e);

}
     
 
   System.out.println("dbover");
   
    
    
    }
  
    void plotl()
    {
   try{ 
   
       FileInputStream fstream = new FileInputStream("e:/test/cen.csv");
       DataInputStream in = new DataInputStream(fstream);
       BufferedReader br = new BufferedReader(new InputStreamReader(in));
      
      
      
   FileWriter fw[]=new FileWriter[5];
   fw[0]=new FileWriter("e:/test/c1.csv");
   fw[1]=new FileWriter("e:/test/c2.csv");
  fw[2]=new FileWriter("e:/test/c3.csv");
  // fw[3]=new FileWriter("e:/test/c4.csv");
  // fw[4]=new FileWriter("e:/test/c5.csv");
  // fw[5]=new FileWriter("e:/test/c6.csv");
  // fw[6]=new FileWriter("e:/test/c7.csv");
   //fw[7]=new FileWriter("e:/test/c8.csv");
   
   
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
     try{
     while ((str = br.readLine()) != null) 
         {System.out.println(fctr);
        j=0;
        temp=str.split(",");
        ctr=0;
             if(fctr==0)
        {
        //System.out.println("temp"+temp.length);
        while(j<temp.length)
              {
                  //try{
                  
             // System.out.println("----------");
              FileInputStream fstream1 = new FileInputStream("e:/fclean2.csv");
              DataInputStream in1 = new DataInputStream(fstream1); 
              BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
               
              
               String a=temp[j];
              
                        while ((str2 = br1.readLine()) != null) 
                         { 
                         k=0;
                     
                            temp2=str2.split(",");
     //  System.out.println("das"+temp2[0]+","+a);
                                if(a.equals(temp2[0]))
                                   {
                                       
                                       while(k<temp2.length)
                                            {
                                              // 
                                              fw[fctr].write(temp2[k]+",");
                                                
                                              
                                             k++;
                                           }
                                       ctr++;
                                   System.out.println("aa");
                                       fw[fctr].write("\n");
                                                                          
                                     int r=1;
                                     while(r>0)
                                     { System.out.println("r"+r);
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
              }
//catch(Exception ed)  
  //            {
    //          System.out.println(ed);}
      //            }
         }
 
   
         
    fctr++;     
         }}catch(Exception e)
         {System.out.println(e);}
   
   }
    
    



catch(Exception e)
    {
    System.out.println(e);
    }
    
   
   }
   
   
      
    
   
 
   
  
    
    




  
    
    
    
    
   
   
        
  

    
    
     void readout()
    {
    try{
     FileInputStream fstream = new FileInputStream("e:/test/outlier.csv");
     DataInputStream in = new DataInputStream(fstream);
     BufferedReader br = new BufferedReader(new InputStreamReader(in));
       
      FileWriter fw = new FileWriter("e:/test/outf.csv");
     
               
     
   
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
              FileInputStream fstream1 = new FileInputStream("e:/test/core.csv");
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
     FileInputStream fstream = new FileInputStream("e:/test/finalcluster.csv");
     DataInputStream in = new DataInputStream(fstream);
     BufferedReader br = new BufferedReader(new InputStreamReader(in));
       
      FileInputStream fstream3 = new FileInputStream("e:/test/outlier.csv");
     DataInputStream in3 = new DataInputStream(fstream3);
     BufferedReader br3 = new BufferedReader(new InputStreamReader(in3));
     
      FileWriter fw = new FileWriter("e:/test/clustf.csv");
               
     
   
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
              FileInputStream fstream1 = new FileInputStream("e:/test/core.csv");
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
     
     FileInputStream fstream = new FileInputStream("e:/test/cen.csv");
     DataInputStream in = new DataInputStream(fstream);
     BufferedReader br = new BufferedReader(new InputStreamReader(in));   
 
     FileInputStream fstream1 = new FileInputStream("e:/test/core.csv");
     DataInputStream in1 = new DataInputStream(fstream1);
     BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
     
     FileWriter fwout = new FileWriter("e:/test/outlier.csv");
 
    FileWriter fw = new FileWriter("e:/test/finalcluster.csv");
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
       //  System.out.println("size is"+wctr); 
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
                   if(diff2<(float)0.07)                   {
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
           
          System.out.println("out"+outer.size());
            for(int q=0;q<outer.size();q++)
               { 
         
                  inner2 =(List)outer.get(q);
                System.out.println("inner"+inner2.size());
                   for(int w=0;w<inner2.size();w++)
                   { 
                   c5=(cen)inner2.get(w);
                     
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
           if(diff<.45)
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
     for(i=0;i<outer.size();i++)
 {
    List chk = (List)outer.get(i);
     System.out.println("chk.size"+chk.size()); 
 }
 
fw.close();
   fwinner.close();   
}catch(Exception e)
{
System.out.println(e);

}
     
 
   System.out.println("dbover");
   
    }
    
    
    
    public static void main(String[] args) throws IOException {
      chk db1 =new chk();
    //  db1.db();
// db1.finalcluster();
// db1.read();
  //   db1.readout();
// db1.plzz();
    db1.plotl();
     
    }
}
