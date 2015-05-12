package qosserver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author ZSJ
 */
public class ConnectWindow extends javax.swing.JFrame {
    
    File file;
    GUIController gui;
    public ConnectWindow() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPort = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();
        btnChooseFile = new javax.swing.JButton();
        lblFilePath = new javax.swing.JLabel();
        lblServerHeading = new javax.swing.JLabel();
        lblServerStatus = new javax.swing.JLabel();
        lblPortNumber = new javax.swing.JLabel();
        lblChooseQuestion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".: QoS Server :."); // NOI18N
        setLocationByPlatform(true);
        setName("server_window"); // NOI18N
        setResizable(false);

        txtPort.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPort.setPreferredSize(new java.awt.Dimension(100, 20));

        btnStart.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnStart.setText("Start Server");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnChooseFile.setText("Choose File");
        btnChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseFileActionPerformed(evt);
            }
        });

        lblFilePath.setText("No File Chosen..");

        lblServerHeading.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblServerHeading.setText("Server");

        lblServerStatus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblServerStatus.setForeground(new java.awt.Color(255, 0, 0));
        lblServerStatus.setText("Server is OFF");

        lblPortNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPortNumber.setText("Port Number:");

        lblChooseQuestion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblChooseQuestion.setText("Choose Question File:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblServerStatus)
                            .addComponent(lblServerHeading)
                            .addComponent(lblPortNumber)
                            .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChooseQuestion)
                            .addComponent(lblFilePath)
                            .addComponent(btnChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnStart)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblServerHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblServerStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPortNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblChooseQuestion)
                .addGap(3, 3, 3)
                .addComponent(btnChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFilePath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStart)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if( txtPort.getText().isEmpty() && lblFilePath.getText().equals("No File Chosen..") ){
            JOptionPane.showMessageDialog(rootPane, "Port and File is empty!", "ERROR",JOptionPane.ERROR_MESSAGE);
        }else if( txtPort.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "Port is empty!", "ERROR",JOptionPane.ERROR_MESSAGE);
        }else if( lblFilePath.getText().equals("No File Chosen..") ){
            JOptionPane.showMessageDialog(rootPane, "File is empty!", "ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
            if( btnStart.getText().equals("Start Server") ){
                lblServerStatus.setText("Server is ON");
                lblServerStatus.setForeground( new Color(0, 153, 0) );
                btnStart.setText("Stop Server");
                btnChooseFile.setEnabled(false);
                txtPort.setEnabled(false);
                int port = Integer.valueOf(txtPort.getText());
                gui = new GUIController();
                gui.connect(port, file);
            }else if( btnStart.getText().equals("Stop Server") ){
                lblServerStatus.setText("Server is OFF");
                lblServerStatus.setForeground( new Color(255, 0, 0) );
                btnStart.setText("Start Server");
                btnChooseFile.setEnabled(true);
                txtPort.setEnabled(true);
                gui.socketClose();
            }
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseFileActionPerformed
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if( returnVal == JFileChooser.OPEN_DIALOG ){
            lblFilePath.setText(fc.getSelectedFile().getAbsolutePath());
        }
        file = fc.getSelectedFile();
    }//GEN-LAST:event_btnChooseFileActionPerformed

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
            java.util.logging.Logger.getLogger(ConnectWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel lblChooseQuestion;
    private javax.swing.JLabel lblFilePath;
    private javax.swing.JLabel lblPortNumber;
    private javax.swing.JLabel lblServerHeading;
    private javax.swing.JLabel lblServerStatus;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
}
