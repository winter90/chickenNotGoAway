/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chickengoaway;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author huy.vu
 */
public class ChickenGoAway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test connect dataBase
//        helpper helpper = new helpper();
//         ResultSet rs = helpper.queryData("SELECT * FROM FOODS");
//         try{
//            while (rs.next())
//               {
//                   System.out.print("Mã:\t" + rs.getString(1) + "\t");
//                   System.out.println("Mã sản phẩm:\t" + rs.getString(2));
//               }
//         }
//         catch(SQLException ex){
//            System.out.println(ex.getMessage());
//        }

        new mainForm().setVisible(true);
        
    }
    
}
