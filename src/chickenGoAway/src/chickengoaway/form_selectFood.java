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
public class form_selectFood extends javax.swing.JFrame {

    /**
     * Creates new form form_selectFood
     */
    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;
    
    public form_selectFood() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_food1 = new javax.swing.JButton();
        btn_ok = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_countFood1 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_food2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_countFood2 = new javax.swing.JLabel();
        btn_food3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbl_countFood3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_food1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_food1.setText("Món 1");
        btn_food1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_food1MouseClicked(evt);
            }
        });
        btn_food1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_food1ActionPerformed(evt);
            }
        });

        btn_ok.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_ok.setText("Đồng ý");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Số Lượng: ");

        lbl_countFood1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_countFood1.setText("0");

        btn_cancel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_cancel.setText("Hủy");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Chọn món ăn");

        btn_food2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_food2.setText("Món 2");
        btn_food2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_food2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Số Lượng");

        lbl_countFood2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_countFood2.setText("0");

        btn_food3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_food3.setText("Món 3");
        btn_food3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_food3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Số Lượng");

        lbl_countFood3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_countFood3.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_ok, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_food1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_countFood1)))
                                .addGap(3, 3, 3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_food2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_countFood2)
                                        .addGap(12, 12, 12)))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_countFood3))
                                    .addComponent(btn_food3)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cancel)
                                .addGap(62, 62, 62)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_food1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_food2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_food3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lbl_countFood1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lbl_countFood2)
                        .addComponent(jLabel6)
                        .addComponent(lbl_countFood3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ok)
                    .addComponent(btn_cancel))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_food1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_food1ActionPerformed
        // TODO add your handling code here:
        count1 = count1 + 1;
        lbl_countFood1.setText(count1 + "");
        
    }//GEN-LAST:event_btn_food1ActionPerformed

    private void btn_food2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_food2ActionPerformed
        // TODO add your handling code here:
         count2 = count2 + 1;
        lbl_countFood2.setText(count1 + "");
    }//GEN-LAST:event_btn_food2ActionPerformed

    private void btn_food3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_food3ActionPerformed
        // TODO add your handling code here:
         count3 = count3 + 1;
        lbl_countFood3.setText(count3 + "");
    }//GEN-LAST:event_btn_food3ActionPerformed

    private void btn_food1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_food1MouseClicked
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_btn_food1MouseClicked

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
            java.util.logging.Logger.getLogger(form_selectFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_selectFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_selectFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_selectFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_selectFood().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_food1;
    private javax.swing.JButton btn_food2;
    private javax.swing.JButton btn_food3;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbl_countFood1;
    private javax.swing.JLabel lbl_countFood2;
    private javax.swing.JLabel lbl_countFood3;
    // End of variables declaration//GEN-END:variables
}
