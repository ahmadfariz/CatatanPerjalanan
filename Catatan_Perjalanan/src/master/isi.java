package master;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

    /**
     *
     * @author crYptONE
     */

public class isi extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    String nik = db.javasession.get_Nik();
    String nama = db.javasession.get_Nama();
    
    /**
     * Creates new form isi
     */
    public isi() {
        initComponents();
        setTanggal();
        setJam();
        
        this.setLocationRelativeTo(null);
        conn = db.koneksi.koneksi();
        
        tggl.setEditable(false);
        tggl.setEnabled(false);
        jam.setEditable(false);
        jam.setEnabled(false);
        
        suhu.setText("");
        lok.setText("");
        lok.requestFocus();
        
        String query = "SELECT * FROM tb_pengguna WHERE nik=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, nik);
            rs = pst.executeQuery();
            while (rs.next()){
                nika.setText(nik);
                namaa.setText(nama);
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
             
    }
        
        public void setTanggal(){
    java.util.Date skrg = new java.util.Date();
    java.text.SimpleDateFormat tgl_ok = new java.text.SimpleDateFormat("dd-MM-yyyy");
    tggl.setText(tgl_ok.format(skrg));
    }
        
        public void setJam(){
    ActionListener taskPerformer = new ActionListener() {

    public void actionPerformed(ActionEvent evt) {
    String nol_jam = "", nol_menit = "",nol_detik = "";

    java.util.Date dateTime = new java.util.Date();
    int nilai_jam = dateTime.getHours();
    int nilai_menit = dateTime.getMinutes();
    int nilai_detik = dateTime.getSeconds();

    if(nilai_jam <= 9) nol_jam= "0";
    if(nilai_menit <= 9) nol_menit= "0";
    if(nilai_detik <= 9) nol_detik= "0";

    String waktu = nol_jam + Integer.toString(nilai_jam);
    String menit = nol_menit + Integer.toString(nilai_menit);
    String detik = nol_detik + Integer.toString(nilai_detik);

    jam.setText(waktu+":"+menit+":"+detik+"");
    }
    };
    new Timer(1000, taskPerformer).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nika = new javax.swing.JLabel();
        namaa = new javax.swing.JLabel();
        jam = new javax.swing.JTextField();
        suhu = new javax.swing.JTextField();
        tggl = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lok = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        kembali = new javax.swing.JButton();
        simpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(885, 560));
        getContentPane().setLayout(null);
        getContentPane().add(nika);
        nika.setBounds(40, 70, 170, 70);
        getContentPane().add(namaa);
        namaa.setBounds(50, 170, 160, 70);
        getContentPane().add(jam);
        jam.setBounds(590, 140, 270, 50);

        suhu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                suhuKeyTyped(evt);
            }
        });
        getContentPane().add(suhu);
        suhu.setBounds(590, 310, 270, 50);
        getContentPane().add(tggl);
        tggl.setBounds(590, 80, 270, 50);

        lok.setColumns(20);
        lok.setRows(5);
        lok.setPreferredSize(new java.awt.Dimension(270, 80));
        jScrollPane1.setViewportView(lok);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(590, 200, 270, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 880, 560);

        kembali.setText("jButton1");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali);
        kembali.setBounds(760, 500, 110, 40);

        simpan.setText("jButton1");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan);
        simpan.setBounds(760, 380, 90, 40);

        setBounds(0, 0, 880, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        try{
         String SQL = "insert into tb_catatan values('"+nika.getText()+"','"+tggl.getText()+"','"+jam.getText()+"','"+lok.getText()+"','"+suhu.getText()+"')";
          JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
            hub(SQL);
        }catch(Exception exc){
            System.err.println(exc.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!");
        } 
        lok.setText("");
        suhu.setText("");
    }//GEN-LAST:event_simpanActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        menu inf = new menu();
        inf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void suhuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suhuKeyTyped
        // TODO add your handling code here:
//        if (suhu.getText().length() == 16 ) { //filter batas
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Batas Karakater 16");
//        }
        filterhuruf(evt);
    }//GEN-LAST:event_suhuKeyTyped

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
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new isi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jam;
    private javax.swing.JButton kembali;
    private javax.swing.JTextArea lok;
    private javax.swing.JLabel namaa;
    private javax.swing.JLabel nika;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField suhu;
    private javax.swing.JTextField tggl;
    // End of variables declaration//GEN-END:variables
}
