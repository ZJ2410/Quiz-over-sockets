package qos;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author ZSJ
 */
public class MainWindow extends javax.swing.JFrame {
    
    public MainWindow() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        btn_connect = new javax.swing.JButton();
        txthostIp = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        lblPort = new javax.swing.JLabel();
        lblHostIp = new javax.swing.JLabel();
        txtRollNumber = new javax.swing.JTextField();
        lblLoginHeading = new javax.swing.JLabel();
        lblRollNumber = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".: Login to QoS :."); // NOI18N
        setBackground(new java.awt.Color(153, 153, 255));
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        setLocationByPlatform(true);
        setResizable(false);

        btn_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qos/gnome_media_playback_start.png"))); // NOI18N
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        txthostIp.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txthostIp.setText("127.0.0.1");
        txthostIp.setPreferredSize(new java.awt.Dimension(100, 20));

        txtPort.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPort.setText("4444");
        txtPort.setPreferredSize(new java.awt.Dimension(100, 20));

        lblPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPort.setText("Port:");

        lblHostIp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHostIp.setText("Hostname:");

        txtRollNumber.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtRollNumber.setText("K122173");
        txtRollNumber.setPreferredSize(new java.awt.Dimension(100, 20));

        lblLoginHeading.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblLoginHeading.setText("Login");

        lblRollNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRollNumber.setText("Roll Number:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblHostIp)
                            .addComponent(lblLoginHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPort)
                            .addComponent(lblRollNumber)
                            .addComponent(txthostIp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRollNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btn_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoginHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHostIp)
                .addGap(5, 5, 5)
                .addComponent(txthostIp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRollNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRollNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        String host = this.txthostIp.getText();
        int port = Integer.valueOf(this.txtPort.getText());
        String rollNumber = txtRollNumber.getText();
        try {
            Socket socket = new Socket(host, port);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            dos.writeUTF(rollNumber);
            String response = dis.readUTF();
            if(response.equals("Successful.")){
                QuizWindow qw = new QuizWindow(socket, dis, dos, rollNumber);
                qw.setVisible(true);
                this.dispose();
            }
        } catch (UnknownHostException uhe) {
            showMessageDialog(null, "Connection failed!\n\nPlease make sure that server info is correct.");
        } catch (IOException ex) {
            showMessageDialog(null, "An error occured while sending message.");
        }
    }//GEN-LAST:event_btn_connectActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel lblHostIp;
    private javax.swing.JLabel lblLoginHeading;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblRollNumber;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtRollNumber;
    private javax.swing.JTextField txthostIp;
    // End of variables declaration//GEN-END:variables
}
