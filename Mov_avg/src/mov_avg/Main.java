/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mov_avg;
import java.sql.*;
//import java.util.*;
import java.io.*;

/**
 *
 * @author compaq
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public float moving(Statement stmt, int yr) throws SQLException
    {
            int[] arr= new int[100000];
            float[] ll = new float[100000];
            int len2=0,y_crime=0;
            ResultSet rs;
            float avg = 0,v=0;
            String sql = "Select year,violent from time_series";
            rs=stmt.executeQuery(sql);
            System.out.println("aayayya!!");
//            if(yr>2011)
//            {
//            float f= moving(stmt,yr-1);
//
//            }

           
            {
            System.out.println("else me aayayya!!");
            int i=0;
            if(rs==null)
            {
            System.out.println("rs null hai yaar");}
            while(rs.next())
            {
                   int p=rs.getInt("violent");
                   arr[i]=p;
                   System.out.println(arr[i]);
                   if(i==5)
                   { y_crime=rs.getInt("year");}
                   if(i<5)
                  {
                       System.out.println("if me bhi aayayya!!");
//                       String sql3="Truncate table crime2";
//                       stmt.execute(sql3);
//                       if(rs1==null)
//                       {System.out.println("paplu ban gaya :P !!");}
//                       String sql2="Insert into crime2 values("+rs.getInt("violent")+","+rs.getInt("year")+")";
//                       stmt.execute(sql2);
//                       if(rs2==null)
//                       {System.out.println("paplu 2 ban gaya :P !!");}
                   }
                   i++;
            }


            //calculation//


        
           int k=0;
           i=0;
           int len= arr.length;
           while(y_crime<=yr)
           {
            System.out.println(" ghusa aayayya!!");
            avg= (arr[i]+arr[i+1]+arr[i+2]+arr[i+3]+arr[i+4])/5;
            i=i+1;
            ll[k]=avg;
            String sql4="Insert into crime2 values("+avg+","+y_crime+")";
            stmt.execute(sql4);
            y_crime++;
            k++;
           }

            String sql5="Select violent from crime2 where year="+yr;
            ResultSet rss=stmt.executeQuery(sql5);
            System.out.println(rss.getInt("violent"));
            v=rss.getFloat("violent");
          }
            String s="insert into crime2 values("+v+","+(y_crime-1)+")";
            stmt.execute(s);
            


 return v;
 }

    




    public static void main(String[] args) throws IOException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime", "root", "");
            Statement stmt=conn.createStatement();
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (Exception ex)
            {
                System.out.println("class not found yaar");
            }

            //5 years moving average//
            //prediction from 5th year onwards only//
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the year you want your prediction : ");
            String y=br.readLine();
            int yr= Integer.parseInt(y);
            Main mn=new Main();
            float some=mn.moving(stmt, yr);
            System.out.println(some);
            int yy=yr-2011;
            int x=2012;
            for(int p=0;p<yy;p++)
            {
            mn.moving(stmt,x++);
            }
            }

            catch(Exception e)
            {
                System.out.println(e);
            }

    }

}
