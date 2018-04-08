/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chickengoaway;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author huy.vu
 */
public class form_order extends javax.swing.JFrame {
    
    /**
     * 
     */
    private void getFoods(){
        //Query data
        String str_querry = "Select * from foods"; //ID, Name, Prices
        try {
                
                 int row = 0;
                 ResultSet rs = ChickenGoAway._helpper.executeQuerry(str_querry);
                 DefaultTableModel tableFoods = (DefaultTableModel)tbl_orderDetails.getModel();            
                 while (rs.next()){
                    tableFoods.setValueAt(row + 1, row , 0); // #
                    tableFoods.setValueAt(rs.getString("Name"), row , 1); // Tên món ăn
                    tableFoods.setValueAt(0, row , 2); // Số Lượng
                    tableFoods.setValueAt(rs.getString("Prices"), row , 3); // Đơn giá
                    tableFoods.setValueAt(0 , row , 4); // Thành tiền
                    
                    //Update dictionary
                    dicFoods.put(rs.getString("Name"),rs.getString("ID"));
                    row++;

                 }

             } catch (SQLException ex) {
                 Logger.getLogger(form_main.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    
     /**
     * Update table format
     */
    private void updateTableOrders(){
        String[] quantily = {"","0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        JComboBox comboCount = new JComboBox<String>(quantily);
        comboCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                int total = Integer.valueOf(lbl_totalFee.getText());
                int selectedRow = tbl_orderDetails.getSelectedRow();
                int fee, count, after_price, before_price;               
                TableModel tableFood = tbl_orderDetails.getModel();
                
                before_price = Integer.valueOf(tableFood.getValueAt(selectedRow, 4).toString());
                total = total - before_price;
                
                fee = Integer.valueOf(tableFood.getValueAt(selectedRow, 3).toString());
                count = Integer.valueOf(tableFood.getValueAt(selectedRow, 2).toString());
                after_price = fee * count;
                tableFood.setValueAt(after_price, selectedRow, 4);
                
                //Calculator the total price
                total = total + after_price;
                lbl_totalFee.setText(total + "");
            }
        });
                
                
        TableColumn tblCol = tbl_orderDetails.getColumnModel().getColumn(2);
        tblCol.setCellEditor(new DefaultCellEditor(comboCount));
    }
    
    
    /**
     * Creates new form form_order
     */
    public form_order() {
        
        initComponents();
        
        getFoods();
        
        updateTableOrders();
    }
    
    public form_order(String orderID) {
        //define variable:
        currentOrderID = orderID;
        String strQuerryFood = "SELECT OrderDetails.orderId, OrderDetails.Count, foods.Name, foods.Prices "
                + "FROM foods INNER JOIN OrderDetails ON foods.[ID] = OrderDetails.[foods] "
                + "WHERE (((OrderDetails.orderId)=" + orderID + "));";
        String strQuerryCustomer = "SELECT * FROM [order] WHERE (((order.OrderID)=" + orderID + "));" ;
        
        ResultSet customerInfo = ChickenGoAway._helpper.executeQuerry(strQuerryCustomer);
        ResultSet orderInfo = ChickenGoAway._helpper.executeQuerry(strQuerryFood);
        
        // Genarate form
        initComponents();
        getFoods();
        System.out.println("Update data");
        
        //Update form
        lbl_header.setText("Chỉnh sửa đơn hàng:   " + currentOrderID);
        
        try {
            
            int total,fee, foodFee, row;
            String foodName, quantity, price, internalFood;
            row = 0;
            DefaultTableModel tableFoods = (DefaultTableModel)tbl_orderDetails.getModel();
            // Load customize infomation
            while (customerInfo.next()){
                
                total = Integer.valueOf(customerInfo.getString("Ship")) + Integer.valueOf(customerInfo.getString("Fee")) ;
                fee = Integer.valueOf(customerInfo.getString("Ship"));
                txt_Address.setText(customerInfo.getString("Address"));
                txt_numberPhone.setText(customerInfo.getString("PhoneNumber"));
                txt_shipFee.setText(fee +"");
                txt_timeDeliverli.setText(customerInfo.getString("timeDelivery"));
                lbl_totalFee.setText("" + total);   
            }
            // Load details bill
            while (orderInfo.next()){
                
                foodName = orderInfo.getString("Name");
                quantity = orderInfo.getString("Count");
                price = orderInfo.getString("Prices");
                foodFee = Integer.valueOf(quantity) * Integer.valueOf(price);
                 // Update food on table:
                 for(int interanlRow = 0; interanlRow < tableFoods.getRowCount(); interanlRow++){
                     internalFood = tableFoods.getValueAt(interanlRow, 1) + "";
                     if(internalFood == "")
                         break;
                     if(internalFood.equals(foodName)){
                         tableFoods.setValueAt(quantity, interanlRow, 2);
                         tableFoods.setValueAt(price, interanlRow, 4);
                         break;
                     }
                 }
                
//                
            }
        System.out.println("Update data-----> Done");
        } catch (SQLException ex) {
            Logger.getLogger(form_print.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateTableOrders();
    }
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lbl_header = new javax.swing.JLabel();
        lbl_address = new javax.swing.JLabel();
        lbl_phoneNumber = new javax.swing.JLabel();
        lbl_timedeli = new javax.swing.JLabel();
        lbl_shipFee = new javax.swing.JLabel();
        txt_Address = new javax.swing.JTextField();
        txt_numberPhone = new javax.swing.JTextField();
        txt_timeDeliverli = new javax.swing.JTextField();
        txt_shipFee = new javax.swing.JTextField();
        txt_shipper = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_orderDetails = new javax.swing.JTable();
        btn_OK = new javax.swing.JButton();
        btn_calcel = new javax.swing.JButton();
        lbl_total = new javax.swing.JLabel();
        lbl_totalFee = new javax.swing.JLabel();
        lbl_shipFee1 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(500, 300));
        setResizable(false);

        lbl_header.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_header.setText("THÊM ĐƠN HÀNG");

        lbl_address.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_address.setText("Địa chỉ giao hàng:");

        lbl_phoneNumber.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_phoneNumber.setText("Số điện thoại :");

        lbl_timedeli.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_timedeli.setText("Thời gian giao:");

        lbl_shipFee.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_shipFee.setText("Shipper:");

        txt_Address.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AddressActionPerformed(evt);
            }
        });

        txt_numberPhone.setColumns(3);
        txt_numberPhone.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_numberPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numberPhoneActionPerformed(evt);
            }
        });

        txt_timeDeliverli.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_timeDeliverli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timeDeliverliActionPerformed(evt);
            }
        });

        txt_shipFee.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_shipFee.setText("0");
        txt_shipFee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_shipFeeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_shipFeeFocusLost(evt);
            }
        });

        txt_shipper.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_shipper.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_shipperFocusLost(evt);
            }
        });

        tbl_orderDetails.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbl_orderDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "#", "Món Ăn", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_orderDetails.setRowHeight(22);
        jScrollPane1.setViewportView(tbl_orderDetails);
        if (tbl_orderDetails.getColumnModel().getColumnCount() > 0) {
            tbl_orderDetails.getColumnModel().getColumn(0).setResizable(false);
            tbl_orderDetails.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_orderDetails.getColumnModel().getColumn(1).setResizable(false);
            tbl_orderDetails.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbl_orderDetails.getColumnModel().getColumn(2).setResizable(false);
            tbl_orderDetails.getColumnModel().getColumn(2).setPreferredWidth(20);
            tbl_orderDetails.getColumnModel().getColumn(3).setResizable(false);
            tbl_orderDetails.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbl_orderDetails.getColumnModel().getColumn(4).setResizable(false);
            tbl_orderDetails.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btn_OK.setBackground(new java.awt.Color(0, 204, 102));
        btn_OK.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_OK.setText("Đồng ý");
        btn_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OKActionPerformed(evt);
            }
        });

        btn_calcel.setBackground(new java.awt.Color(255, 0, 0));
        btn_calcel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_calcel.setText("Hủy");
        btn_calcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcelActionPerformed(evt);
            }
        });

        lbl_total.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_total.setText("Tổng cộng:");

        lbl_totalFee.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_totalFee.setText("0");

        lbl_shipFee1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_shipFee1.setText("Phí ship:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_OK)
                .addGap(179, 179, 179)
                .addComponent(btn_calcel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_header)
                .addGap(186, 186, 186))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_shipFee1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbl_total)
                                .addGap(37, 37, 37)
                                .addComponent(lbl_totalFee, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_address)
                                    .addComponent(lbl_phoneNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_shipFee, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(101, 101, 101)
                                                .addComponent(txt_shipper, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_shipFee)
                                            .addComponent(txt_numberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_timedeli)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_timeDeliverli))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_header)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_address))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_numberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_phoneNumber)
                    .addComponent(lbl_timedeli)
                    .addComponent(txt_timeDeliverli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_shipFee1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_shipFee)
                        .addComponent(txt_shipper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_shipFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_total)
                    .addComponent(lbl_totalFee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calcel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AddressActionPerformed

    private void txt_numberPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numberPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numberPhoneActionPerformed

    private void txt_timeDeliverliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timeDeliverliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timeDeliverliActionPerformed

    private void btn_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OKActionPerformed
        
        String orderID, dateOrder, address, phoneNumber, timeDeliver, fee, ship, shipper;
        String querry;
        String tempData = "";
        int countOrder = 0;
        
        //Collect data for table order
        dateOrder   = (new SimpleDateFormat("yyyy-MM-dd").format(new Date())).toString();
        address     = txt_Address.getText();
        phoneNumber = txt_numberPhone.getText();
        timeDeliver = txt_timeDeliverli.getText();
        ship        = txt_shipFee.getText();
        fee         = (Integer.valueOf(lbl_totalFee.getText()) - Integer.valueOf(ship)) + "";
        shipper     = txt_shipper.getText();
        //if new: currentOrderID == "";
        if(currentOrderID.equals("")){
            System.out.println("Create new one");
            orderID     = (new SimpleDateFormat("yyMMdd").format(new Date()));
            ResultSet rs = ChickenGoAway._helpper.executeQuerry("Select TOP 1 OrderID from order where dateOder = #" + dateOrder + "# ORDER BY OrderID DESC");
            try {
                while(rs.next())
                    tempData = rs.getString("OrderID"); //example: 17031701

                 if(tempData!="")
                    countOrder = Integer.valueOf(tempData.substring(6, tempData.length()));   
                 }
            catch (SQLException ex) {
                Logger.getLogger(form_order.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            countOrder++;

            if(countOrder <10)
                orderID = orderID + "0" + countOrder;
            else
                orderID = orderID + countOrder;
            querry = "INSERT INTO [order] ( OrderID, dateOder, Address, PhoneNumber, timeDelivery, Fee, Ship, Shipper ) "
                + "VALUES (" + orderID + ", ? ,  '"+ address + "', '" + phoneNumber + "', '" 
                    + timeDeliver + "', "+ fee + ", " + ship + ", '" + shipper + "');";
            
            //Get data for order details
            String food, quantities;
            int rows =  tbl_orderDetails.getRowCount();
            ArrayList<String> strQuerrys = new ArrayList<>();

            DefaultTableModel tableFoods = (DefaultTableModel)tbl_orderDetails.getModel();
            for(int row = 0; row < rows-1; row++){

                quantities = tableFoods.getValueAt(row, 2).toString();
                if(quantities==null )
                    break;
                if(Integer.valueOf(quantities) > 0){
                    food = tableFoods.getValueAt(row, 1).toString();
                    strQuerrys.add("INSERT INTO OrderDetails ( orderId, foods, count) VALUES (" + orderID 
                            + ", '"+ dicFoods.get(food) + "', " + quantities + ");");
                    System.out.println(row);
                }
            }
 
            // show information
             String strMess = "Thêm đơn hàng với ID: " + orderID + "\n Tổng giá trị:              " + lbl_totalFee.getText();
             JOptionPane.showMessageDialog(null, strMess);

            //push data to database
            ChickenGoAway._helpper.insertDataIntoOrder(querry, dateOrder);
            ChickenGoAway._helpper.insertDataToOrrderDetails(strQuerrys);
       
        
        }
        else{
            System.out.println("Update order: " + currentOrderID);
            orderID = currentOrderID;
            //Update customize
            querry = "UPDATE order SET Address='" + address + "', PhoneNumber ='" + phoneNumber  + "', timeDelivery ='" + timeDeliver  + "', Fee ='" + fee + "', Ship ='" + ship 
                    + "' WHERE OrderID LIKE '"+ orderID + "'" ;
            ChickenGoAway._helpper.executeUpdateData(querry);
            
            //Update table
            //Get data for order details
            String food, quantities, updateQuerry;
            int rows =  tbl_orderDetails.getRowCount();
            DefaultTableModel tableFoods = (DefaultTableModel)tbl_orderDetails.getModel();
            for(int row = 0; row < rows-1; row++){

                quantities = (tableFoods.getValueAt(row, 2).toString()) + "";
                food = dicFoods.get(tableFoods.getValueAt(row, 1).toString());
                if(quantities.equals("") )
                    break;
                if(Integer.valueOf(quantities) > 0){
                    food = tableFoods.getValueAt(row, 1).toString();
                    querry = "UPDATE OrderDetails SET count='" + quantities
                    + "' WHERE OrderID LIKE '"+ orderID + "' AND foods LIKE '" + food + "'" ;
                    ChickenGoAway._helpper.executeUpdateData(querry);
                    break;
                }
            }
            
        }
        

        
        this.dispose();
        
    }//GEN-LAST:event_btn_OKActionPerformed

    private void btn_calcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcelActionPerformed
        // confirm that close without save and close form 
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int intResut = JOptionPane.showConfirmDialog (null, "Bạn có muốn hủy đơn hàng này ?","Warning",dialogButton);
        if(intResut == JOptionPane.YES_OPTION){
            this.dispose();       
        }
        
    }//GEN-LAST:event_btn_calcelActionPerformed

    private void txt_shipperFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_shipperFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_shipperFocusLost

    private void txt_shipFeeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_shipFeeFocusLost
        int ship, total;
        total = Integer.valueOf(lbl_totalFee.getText());
        ship = Integer.valueOf(txt_shipFee.getText());
        total = (total + ship) - currentShipFee;
        lbl_totalFee.setText(total + "");
    }//GEN-LAST:event_txt_shipFeeFocusLost
    
    private void txt_shipFeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_shipFeeFocusGained
        // TODO add your handling code here:
       currentShipFee = Integer.valueOf(txt_shipFee.getText());
    }//GEN-LAST:event_txt_shipFeeFocusGained
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_OK;
    private javax.swing.JButton btn_calcel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_header;
    private javax.swing.JLabel lbl_phoneNumber;
    private javax.swing.JLabel lbl_shipFee;
    private javax.swing.JLabel lbl_shipFee1;
    private javax.swing.JLabel lbl_timedeli;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_totalFee;
    private javax.swing.JTable tbl_orderDetails;
    private javax.swing.JTextField txt_Address;
    private javax.swing.JTextField txt_numberPhone;
    private javax.swing.JTextField txt_shipFee;
    private javax.swing.JTextField txt_shipper;
    private javax.swing.JTextField txt_timeDeliverli;
    // End of variables declaration//GEN-END:variables
    
    //my global variable
    private int currentShipFee = 0;
    private  Map<String, String> dicFoods = new HashMap<String, String>(); 
    private String currentOrderID = "";
    
}
