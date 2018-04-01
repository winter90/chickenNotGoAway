/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chickengoaway;

/**
 *
 * @author huy.vu
 */
public class ChickenGoAway {
    
    public static helpper _helpper = new helpper();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create connection
        _helpper.createConnection();
        
        //Start Interface: main form
        new mainForm().setVisible(true);
        
    }
    
}
