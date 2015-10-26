/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author compaq
 */

import java.sql.*;
import java.io.*;
public class streetClean
{

    public void street()
    {
        try{

        FileWriter fw= new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/criminalStreet.txt");
        BufferedWriter o= new BufferedWriter(fw);

        FileWriter fw1= new FileWriter("D:/minor-both/minorDM/minor2/PROJECTCSV/criminalAdd.txt");
        BufferedWriter ot= new BufferedWriter(fw1);


        Connection conn=null;
        String url="jdbc:mysql://localhost:3306/crime";
        conn=DriverManager.getConnection(url,"root","");
        Class.forName("com.mysql.jdbc.Driver");
        Statement stmt=conn.createStatement();
        String sql="Select distinct(Street_Add) from murderers";
        ResultSet rs=stmt.executeQuery(sql);
        String sql1="Select distinct(CITY) from murderers";
        Statement st=conn.createStatement();
        ResultSet r=st.executeQuery(sql1);



        while(rs.next())
        {
            String g=rs.getString(1);
            o.write(g);
            o.write("\n");
        }

        o.close();



        while(r.next())
        {
            String h=r.getString(1);
            ot.write(h);
            ot.write("\n");
        }

        }
        catch(Exception e)
        {
        System.out.println(e);

        }
    }



    public static void main(String[] args)
    {
    streetClean sc= new streetClean();
    sc.street();

    }

}
