/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author crYptONE
 */
public class baru extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form baru
     */
    public baru() {
        initComponents();
        this.setLocationRelativeTo(null);
        conn = db.koneksi.koneksi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nik = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jenkel = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        kembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(470, 650));
        setSize(new java.awt.Dimension(470, 650));
        getContentPane().setLayout(null);

        nik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nikActionPerformed(evt);
            }
        });
        nik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nikKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nikKeyTyped(evt);
            }
        });
        getContentPane().add(nik);
        nik.setBounds(190, 120, 230, 40);

        nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namaKeyTyped(evt);
            }
        });
        getContentPane().add(nama);
        nama.setBounds(190, 170, 230, 40);

        jenkel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - Laki", "Perempuan" }));
        getContentPane().add(jenkel);
        jenkel.setBounds(250, 390, 150, 40);

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane1.setViewportView(alamat);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 220, 230, 150);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/7.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 470, 650);

        simpan.setText("jButton1");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan);
        simpan.setBounds(230, 560, 90, 60);

        kembali.setText("jButton1");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali);
        kembali.setBounds(340, 560, 90, 60);

        setBounds(0, 0, 470, 650);
    }// </editor-fold>//GEN-END:initComponents

    private void nikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nikActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        
        String nk=nik.getText();
        String n=nama.getText();
        String a=alamat.getText();
        String jk=jenkel.getSelectedItem().toString(); 
        
        if((nk.isEmpty())|(n.isEmpty())|(a.isEmpty())|(jk.isEmpty())) {
            JOptionPane .showMessageDialog(null,"Masih Ada nilai yang kosong,silahkan dilengkapi!");
            nik.requestFocus();
        }
        else {
            Object[]options = {"YA","TIDAK"};
            int Konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda Yakin Ingin Menyimpan Data??","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            
            if(Konfirmasi==JOptionPane.YES_OPTION) {   
            }
                    
        try{
            String SQL = "insert into tb_pengguna values('"+nik.getText()+"','"+nama.getText()+"','"+alamat.getText()+"','"+jenkel.getSelectedItem()+"')";
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
            hub(SQL);
            
        }catch(Exception exc){
            System.err.println(exc.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!");
            }
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        login inf = new login();
        inf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void nikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nikKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_nikKeyPressed

    private void namaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKeyPressed

    private void nikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nikKeyTyped
        // TODO add your handling code here:
        if (nik.getText().length() == 16 ) { //filter batas
            evt.consume();
            JOptionPane.showMessageDialog(null, "Batas Karakater 16");
        }
        filterhuruf(evt);
    }//GEN-LAST:event_nikKeyTyped

    private void namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyTyped
        // TODO add your handling code here:
        filterangka(evt);
    }//GEN-LAST:event_namaKeyTyped

        private void hub(String sql){
        try {
            String hubung="jdbc:mysql://localhost:3306/cttjalan";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon=DriverManager.getConnection(hubung,"root","");
            Statement stt=kon.createStatement();
            stt.executeUpdate(sql);
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
        
                }
    
    private void bersih() {
        nik.setText("");
        nama.setText("");
        alamat.setText("");
        jenkel.setSelectedItem("");
        nik.requestFocus();
    }
            
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
            java.util.logging.Logger.getLogger(baru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(baru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(baru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(baru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new baru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenkel;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nik;
    private javax.swing.JButton simpan;
    // End of variables declaration//GEN-END:variables
}
