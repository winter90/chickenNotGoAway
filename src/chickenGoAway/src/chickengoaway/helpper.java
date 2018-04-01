/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chickengoaway;

import java.sql.*;
import java.util.ArrayList;
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
    public Connection conn;
    
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
       
        try{
            String dbURL = "jdbc:ucanaccess://" + databaseURI;
            //String dbURL = "jdbc:ucanaccess://dataFinial.accdb";
            conn = DriverManager.getConnection(dbURL,"","");
            st = conn.createStatement();
            
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
   public ResultSet executeQuerry(String strQuerry){
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
   
   /**
    * Insert data to table order
    * @param strQuerry
    * @param date 
    */
   public void insertDataIntoOrder(String strQuerry, String date){
       if(st == null)
            createConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(strQuerry);
            pst.setDate(1, java.sql.Date.valueOf(date));
            pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(helpper.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
   public void insertDataToOrrderDetails(ArrayList<String> strQuerrys){

       if(st == null)
            createConnection();
       String querry;
       try {
           for (int i =0; i < strQuerrys.size(); i++){
                querry = strQuerrys.get(i);
                PreparedStatement pst = conn.prepareStatement(querry);
                pst.execute();
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(helpper.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   /**
    * Close connection
    */
   public void closeConnection(){
       if(st!= null)
        try {
            
            st.close();
       } catch (SQLException ex) {
           Logger.getLogger(helpper.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
    
}
