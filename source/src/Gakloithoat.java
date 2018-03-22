/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

public class Gakloithoat {
    public static void main(String[] args) {
//        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            Connection con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver(*.accdb)};DBQ=C:\\Users\\Administrator\\Desktop\\DB.accdb");.

        try{
            String dbURL = "jdbc:ucanaccess://dataFinial.accdb";
            Connection con = DriverManager.getConnection(dbURL,"","");
            Statement st = con.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery("SELECT * FROM FOODS");
            while (rs.next())
            {
                System.out.print("Mã:\t" + rs.getString(1) + "\t");
                System.out.println("Mã sản phẩm:\t" + rs.getString(2));
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
