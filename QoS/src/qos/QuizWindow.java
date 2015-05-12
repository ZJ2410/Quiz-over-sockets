package qos;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class QuizWindow extends javax.swing.JFrame {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String quiz;
    private static int questionNo = 0;

    public void getQuestion() {
        try {
            txtAnswer.setText("");
            String responseStatus = dis.readUTF();
            if (!responseStatus.equals("TheEnd")) {
                String question = dis.readUTF();
                txtQuestion.setText(question);
                lblQuestionNo.setText(responseStatus);
            }
            else{
                lblQuestionNo.setVisible(false);
                lblQuizHead.setVisible(false);
                lblQuizID.setVisible(false);
                lblrollNumberHead.setVisible(false);
                jScrollPane1.setVisible(false);
                jScrollPane2.setVisible(false);
                btnSubmitanswer.setVisible(false);
                lblTestComplete.setText("You've completed your Quiz. Good luck for grades!");
                lblTestComplete.setVisible(true);
                btnCloseWindow.setVisible(true);
            }
        } catch (IOException ex) {
            System.out.println("An error occured while getting the question..!!");
        }
    }

    public void sendAnswer() {
        String answer = txtAnswer.getText();
        try {
            dos.writeUTF(answer);
            getQuestion();
        } catch (IOException ex) {
            System.out.println("An error occured while sending message..!!");
        }
    }

    public QuizWindow() {
        initComponents();
    }

    public QuizWindow(Socket socket, DataInputStream dis, DataOutputStream dos, String quiz) {
        this.socket = socket;
        this.dis = dis;
        this.dos = dos;
        this.quiz = quiz;
        initComponents();
        getQuestion();
        lblTestComplete.setVisible(false);
        btnCloseWindow.setVisible(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnswer = new javax.swing.JTextArea();
        btnSubmitanswer = new javax.swing.JButton();
        lblQuizID = new javax.swing.JLabel();
        lblQuestionNo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        lblQuizHead = new javax.swing.JLabel();
        lblrollNumberHead = new javax.swing.JLabel();
        lblTestComplete = new javax.swing.JLabel();
        btnCloseWindow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".: Quiz over Socket :."); // NOI18N
        setLocationByPlatform(true);
        setMinimumSize(null);
        setName("QuizWindow"); // NOI18N
        setResizable(false);

        txtAnswer.setColumns(20);
        txtAnswer.setLineWrap(true);
        txtAnswer.setRows(5);
        txtAnswer.setWrapStyleWord(true);
        txtAnswer.setPreferredSize(new java.awt.Dimension(300, 100));
        jScrollPane2.setViewportView(txtAnswer);
        txtAnswer.getAccessibleContext().setAccessibleName("");
        txtAnswer.getAccessibleContext().setAccessibleDescription("");

        btnSubmitanswer.setText("Submit Answer");
        btnSubmitanswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitanswerActionPerformed(evt);
            }
        });

        lblQuizID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuizID.setText(this.quiz);

        lblQuestionNo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblQuestionNo.setText("QuestionNo");

        txtQuestion.setEditable(false);
        txtQuestion.setColumns(20);
        txtQuestion.setLineWrap(true);
        txtQuestion.setRows(2);
        txtQuestion.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtQuestion);

        lblQuizHead.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblQuizHead.setText("Quiz");

        lblrollNumberHead.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblrollNumberHead.setText("Roll Number:");

        lblTestComplete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTestComplete.setText("jLabel1");

        btnCloseWindow.setText("Close Window");
        btnCloseWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseWindowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblQuestionNo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuizHead)
                                .addGap(28, 28, 28)
                                .addComponent(lblTestComplete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblrollNumberHead)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblQuizID))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSubmitanswer)
                                        .addGap(63, 63, 63)
                                        .addComponent(btnCloseWindow)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(89, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuizID)
                    .addComponent(lblQuizHead)
                    .addComponent(lblrollNumberHead)
                    .addComponent(lblTestComplete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuestionNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmitanswer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCloseWindow))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitanswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitanswerActionPerformed
        // TODO add your handling code here:
        sendAnswer();
    }//GEN-LAST:event_btnSubmitanswerActionPerformed

    private void btnCloseWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseWindowActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseWindowActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(QuizWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseWindow;
    private javax.swing.JButton btnSubmitanswer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblQuestionNo;
    private javax.swing.JLabel lblQuizHead;
    private javax.swing.JLabel lblQuizID;
    private javax.swing.JLabel lblTestComplete;
    private javax.swing.JLabel lblrollNumberHead;
    private javax.swing.JTextArea txtAnswer;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
