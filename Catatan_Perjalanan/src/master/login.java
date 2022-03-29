package master;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crYptONE
 */
public class login extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        conn = db.koneksi.koneksi();
        bersih();
        
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassword = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        background = new javax.swing.JLabel();
        masuk = new javax.swing.JButton();
        daftar = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(824, 534));
        getContentPane().setLayout(null);

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setToolTipText("");
        txtPassword.setBorder(null);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(170, 290, 490, 70);

        txtLogin.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(0, 0, 0));
        txtLogin.setBorder(null);
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLoginKeyTyped(evt);
            }
        });
        getContentPane().add(txtLogin);
        txtLogin.setBounds(170, 165, 490, 70);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 820, 530);

        masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukActionPerformed(evt);
            }
        });
        getContentPane().add(masuk);
        masuk.setBounds(190, 380, 450, 40);

        daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarActionPerformed(evt);
            }
        });
        getContentPane().add(daftar);
        daftar.setBounds(290, 440, 250, 20);

        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(771, 10, 40, 40);

        setBounds(0, 0, 820, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukActionPerformed
        // TODO add your handling code here:
        String nik = null , nama = null;
        String query = "SELECT * FROM tb_pengguna WHERE nik=? AND nama=? ";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, txtLogin.getText());
            pst.setString(2, txtPassword.getText());
            rs = pst.executeQuery();
            while (rs.next()){
                nik = rs.getString("nik");
                nama = rs.getString("nama");
            }
            rs.last();
            if (rs.getRow() == 1){
                db.javasession.set_Nik(nik);
                db.javasession.set_Nama(nama);
                JOptionPane.showMessageDialog(null, "Berhasil login dengan id "+txtLogin.getText());
                menu inf = new menu();
                inf.setVisible(true);
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Username dan Password tidak cocok ");
//                txtLogin.setText("");
//                txtPassword.setText("");
//                txtLogin.requestFocus();
                bersih();
            }
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null, "Gagal pada database : "+e);
            System.out.println(e);
//            txtLogin.setText("");
//            txtPassword.setText("");
//            txtLogin.requestFocus();
        }
    }//GEN-LAST:event_masukActionPerformed

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        // TODO add your handling code here:
        filterangka(evt);
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyTyped
        // TODO add your handling code here:
        if (txtLogin.getText().length() == 16 ) { //filter batas
            evt.consume();
            JOptionPane.showMessageDialog(null, "Batas Karakater 16");
        }
        filterhuruf(evt);
    }//GEN-LAST:event_txtLoginKeyTyped

    private void daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarActionPerformed
        // TODO add your handling code here:
        baru inf = new baru();
        inf.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_daftarActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    void filterhuruf (KeyEvent a) {
        if(Character.isAlphabetic(a.getKeyChar())) {
            a.consume();
        JOptionPane.showMessageDialog(null, "Hanya Di Isi Angka");
        }
    }
    
    void filterangka (KeyEvent b) {
        if(Character.isDigit(b.getKeyChar())) {
            b.consume();
        JOptionPane.showMessageDialog(null, "Hanya Di Isi Huruf");
        }
    }
    
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    private void bersih() {
        txtLogin.setText("");
        txtPassword.setText("");
        txtLogin.requestFocus();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton daftar;
    private javax.swing.JButton exit;
    private javax.swing.JButton masuk;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
