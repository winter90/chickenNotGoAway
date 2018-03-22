/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chickengoaway;

import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.table.TableColumn;

/**
 *
 * @author huy.vu
 */
public class mainForm extends javax.swing.JFrame {

    /**
     * Creates new form mainForm
     */
    public mainForm() {
        initComponents();
        // Setdate
        SimpleDateFormat dFormat =  new SimpleDateFormat("dd-MM-yyyy");

//        dateTimepicker.setDate();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_HeaderName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateTimepicker = new org.jdesktop.swingx.JXDatePicker();
        lbl_doanhSo = new javax.swing.JLabel();
        btn_AddOrder = new javax.swing.JButton();
        btn_orderDetails = new javax.swing.JButton();
        btn_check = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bills = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        setForeground(java.awt.Color.black);
        setName("Frame_main"); // NOI18N
        setResizable(false);

        lbl_HeaderName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_HeaderName.setText("ĐẶT HÀNG GÀ KHÔNG LỐI THOÁT");
        lbl_HeaderName.setToolTipText("");
        lbl_HeaderName.setName("lbl_appName"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Doanh thu ngày: ");
        jLabel2.setToolTipText("");
        jLabel2.setName("lbl_doanhThuNgay"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Doanh số:");
        jLabel3.setName("lbl_doanhthu"); // NOI18N

        dateTimepicker.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbl_doanhSo.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lbl_doanhSo.setText("0.00");

        btn_AddOrder.setBackground(new java.awt.Color(0, 255, 51));
        btn_AddOrder.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_AddOrder.setText("Thêm đơn");
        btn_AddOrder.setName(""); // NOI18N
        btn_AddOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addOrder(evt);
            }
        });
        btn_AddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddOrderActionPerformed(evt);
            }
        });

        btn_orderDetails.setBackground(new java.awt.Color(0, 102, 153));
        btn_orderDetails.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_orderDetails.setText("Kiểm tra đơn hàng");

        btn_check.setBackground(new java.awt.Color(102, 102, 255));
        btn_check.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_check.setText("Kiểm tra doanh thu");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Đơn gần đây:");

        tbl_bills.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        tbl_bills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Địa chỉ", "Số điện thoại", "Giá (+ Ship)", "Tình trạng", "Shipper"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_bills.setRowHeight(19);
        jScrollPane1.setViewportView(tbl_bills);
        if (tbl_bills.getColumnModel().getColumnCount() > 0) {
            tbl_bills.getColumnModel().getColumn(0).setResizable(false);
            tbl_bills.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_bills.getColumnModel().getColumn(1).setResizable(false);
            tbl_bills.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl_bills.getColumnModel().getColumn(2).setResizable(false);
            tbl_bills.getColumnModel().getColumn(2).setPreferredWidth(20);
            tbl_bills.getColumnModel().getColumn(3).setResizable(false);
            tbl_bills.getColumnModel().getColumn(3).setPreferredWidth(20);
            tbl_bills.getColumnModel().getColumn(4).setResizable(false);
            tbl_bills.getColumnModel().getColumn(4).setPreferredWidth(20);
            tbl_bills.getColumnModel().getColumn(5).setResizable(false);
            tbl_bills.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(lbl_HeaderName))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateTimepicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_doanhSo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btn_AddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btn_orderDetails)
                                .addGap(18, 18, 18)
                                .addComponent(btn_check))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_HeaderName)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(dateTimepicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_doanhSo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_AddOrder)
                    .addComponent(btn_orderDetails)
                    .addComponent(btn_check))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addOrder(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addOrder
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_addOrder

    private void btn_AddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddOrderActionPerformed

        new form_order().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AddOrderActionPerformed

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
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddOrder;
    private javax.swing.JButton btn_check;
    private javax.swing.JButton btn_orderDetails;
    private org.jdesktop.swingx.JXDatePicker dateTimepicker;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_HeaderName;
    private javax.swing.JLabel lbl_doanhSo;
    private javax.swing.JTable tbl_bills;
    // End of variables declaration//GEN-END:variables
}
