/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edoctor;

import java.sql.*;

/**
 *
 * @author OLUWAGBEMI
 */
import java.awt.*;
import javax.swing.*;
import static edoctor.MyResources.getResources;
import javax.swing.JOptionPane;
public class SearchDialog extends javax.swing.JDialog {

    /**
     * Creates new form SearchDialog
     */
    public SearchDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/banner.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Patient's ID");

        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        

        String uname = jTextField1.getText();
        Connection con;
        PreparedStatement pst;
        //SearchStudent st;

        Dimension size;
        SearchPatientIntFrame sint;

        String query = "SELECT * FROM patienttb";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vda", "root", "");
            System.out.println(" Connected to database:");
            pst = con.prepareStatement(query);

            byte[] bytes = null;
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString(2).equals(uname)) {

                    super.dispose();

                    Homepage.jDesktopPane1.removeAll();
                    size = Homepage.jDesktopPane1.getSize();
                    sint = new SearchPatientIntFrame();
                    sint.setBounds(0, 0, size.width, size.height);
                    displaySearchedPatientLabels();
                    sint.setVisible(true);
                    Homepage.jDesktopPane1.add(sint);
                    //HMIS_View.statusLabel.setText("Student Record: "+ file_no);

                    SearchPatientIntFrame.t1.setText(rs.getString(2));
                    SearchPatientIntFrame.t2.setText(rs.getString(3));
                    SearchPatientIntFrame.t3.setText(rs.getString(4));
                    if (rs.getString(7).equals("Male")) {
                        SearchPatientIntFrame.rb1.setSelected(true);
                    } else if (rs.getString(7).equals("Female")) {
                        SearchPatientIntFrame.rb2.setSelected(true);
                    }

                    SearchPatientIntFrame.t4.setText(rs.getString(6));

                    if (rs.getString(5).equals("Married")) {
                        SearchPatientIntFrame.cb1.setSelectedIndex(0);

                    } else if (rs.getString(5).equals("Single")) {
                        SearchPatientIntFrame.cb1.setSelectedIndex(1);
                    }

                    if (rs.getString(8).equals("Christianity")) {
                        SearchPatientIntFrame.cb2.setSelectedIndex(0);

                    } else if (rs.getString(8).equals("Islam")) {
                        SearchPatientIntFrame.cb2.setSelectedIndex(1);
                        
                    }

                    SearchPatientIntFrame.t5.setText(rs.getString(9));
                    SearchPatientIntFrame.t6.setText(rs.getString(10));
                    SearchPatientIntFrame.t7.setText(rs.getString(13));
                    SearchPatientIntFrame.t8.setText(rs.getString(12));
                    SearchPatientIntFrame.t9.setText(rs.getString(14));
                    SearchPatientIntFrame.t10.setText(rs.getString(15));
                    SearchPatientIntFrame.t11.setText(rs.getString(16));
                    SearchPatientIntFrame.t12.setText(rs.getString(17));
                    SearchPatientIntFrame.t13.setText(rs.getString(18));
                    SearchPatientIntFrame.t14.setText(rs.getString(19));
                    SearchPatientIntFrame.t15.setText(rs.getString(20));
                    SearchPatientIntFrame.t16.setText(rs.getString(21));
                    bytes = rs.getBytes(22);
                } else {
                    System.out.println("patient's file number not found");
                }

            }
            if (bytes != null) {
                Image img = super.getToolkit().createImage(bytes);
                img = img.getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                SearchPatientIntFrame.pictureLabel.setIcon(new ImageIcon(img));
            }

            rs.close();
            pst.close();
            con.close();

            //memory clean up
            rs = null;
            sint = null;
            size = null;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO MESSAGE: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
public void displaySearchedPatientLabels()
    {
        SearchPatientIntFrame.jLabel1.setText(getResources().getString("patientsbiodata"));
        SearchPatientIntFrame.l1.setText(getResources().getString("patid"));
        SearchPatientIntFrame.l2.setText(getResources().getString("sname"));
        SearchPatientIntFrame.l3.setText(getResources().getString("oname"));
        SearchPatientIntFrame.l4.setText(getResources().getString("gender"));
        SearchPatientIntFrame.l5.setText(getResources().getString("dob"));
        SearchPatientIntFrame.l6.setText(getResources().getString("status"));
        SearchPatientIntFrame.l7.setText(getResources().getString("religion"));
        SearchPatientIntFrame.l8.setText(getResources().getString("origin"));
        SearchPatientIntFrame.l9.setText(getResources().getString("nation"));
        SearchPatientIntFrame.l10.setText(getResources().getString("date"));
        SearchPatientIntFrame.l11.setText(getResources().getString("email"));
        SearchPatientIntFrame.l12.setText(getResources().getString("addr1"));
        SearchPatientIntFrame.l13.setText(getResources().getString("addr2"));
        SearchPatientIntFrame.l14.setText(getResources().getString("phone"));
        SearchPatientIntFrame.l15.setText(getResources().getString("occupation"));
        SearchPatientIntFrame.l16.setText(getResources().getString("height"));
        SearchPatientIntFrame.l17.setText(getResources().getString("blood"));
        SearchPatientIntFrame.l18.setText(getResources().getString("age"));
        SearchPatientIntFrame.l19.setText(getResources().getString("medhist"));
        SearchPatientIntFrame.rb1.setText(getResources().getString("male"));
        SearchPatientIntFrame.rb2.setText(getResources().getString("female"));

        
        SearchPatientIntFrame.jLabel19.setText(getResources().getString("photo"));
        SearchPatientIntFrame.jButton4.setText(getResources().getString("cancel"));

    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                SearchDialog dialog = new SearchDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
