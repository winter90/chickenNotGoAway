/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chickengoaway;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author huy.vu
 */
public class helpper {
    public String databaseURI = getConfig("dbURL") ;
    public Statement st = null;
    
    
    /**
     * @param ConfigureName get data from configure
     * For now, We hard code the data in .../src/data/dataFinial.accdb
     */
    private String getConfig(String configName){
        
        String stringReturn = null;
        if (configName.equals("dbURL"))
            stringReturn = "data/dataFinial.accdb";
        
        return stringReturn;
       
    }
    
    
    /**
     * Create new Connection
     */
    public void createConnection(){
        System.out.println("Create connection");
        try{
            String dbURL = "jdbc:ucanaccess://" + databaseURI;
            //String dbURL = "jdbc:ucanaccess://dataFinial.accdb";
            Connection conn = DriverManager.getConnection(dbURL,"","");
            st = conn.createStatement();
            System.out.println("Create connection ------> Done");
        }
        catch(SQLException ex){
            String strErr = ex.getMessage();
            JOptionPane.showMessageDialog(null, "Error: " + strErr);
        } 
    }
    
   /**
     * @param strQuerry the query
     * @return rs as result set
     */
   public ResultSet queryData(String strQuerry){
        if(st == null)
            createConnection();
            
        ResultSet rs = null;
        try{
           rs = st.executeQuery(strQuerry);
        }
        catch(Exception ex){
            String strErr = ex.getMessage();
            JOptionPane.showMessageDialog(null, strErr);
        }    
        return rs;
   }
   public void closeConnection(){
       if(st!= null)
        try {
            System.out.println("closing connection");
            st.close();
       } catch (SQLException ex) {
           Logger.getLogger(helpper.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
    
}
