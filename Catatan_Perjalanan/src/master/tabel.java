/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author crYptONE
 */
public class tabel extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    String nik = db.javasession.get_Nik();
    String nama = db.javasession.get_Nama();

    private int row;
    
    /**
     * Creates new form tabel
     */
    public tabel() {
        initComponents();
        conn = db.koneksi.koneksi();
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
        
        tabel.setModel(tblModel);
        setDefaultTable();
        
        this.setLocationRelativeTo(null);
    }
    
    private void hub(String sql){
        try {
            String hubung="jdbc:mysql://localhost:3306/pjj";
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
    
    private javax.swing.table.DefaultTableModel tblModel = getDefaultTabelModel();
    
    private void Tabel(javax.swing.JTable tb, int lebar[]) {
        tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int kolom=tb.getColumnCount();
        for(int i=0;i<kolom;i++) {
            javax.swing.table.TableColumn tbc = tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
            tb.setRowHeight(17);
        }
    }
    
    private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
        return new javax.swing.table.DefaultTableModel(
                new Object [][]{},
                new String []{"NIK","TANGGAL","JAM","LOKASI","SUHU"}
        ){
        boolean[] canEdit = new boolean []{
            false,false,false
        };
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
            }
        };
    }
    
    String data[]=new String[5];
    public void setDefaultTable() {
        try{
            String hubung = "jdbc:mysql://localhost:3306/cttjalan";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stt = kon.createStatement();
            String nik = nika.getText();
            String SQL = "select * from tb_catatan where nik like'"+nik+"'";
            ResultSet res = stt.executeQuery(SQL);
            tblModel.setRowCount(0);
        while(res.next()){
            data[0] = res.getString(1);
            data[1] = res.getString(2);
            data[2] = res.getString(3);
            data[3] = res.getString(4);
            data[4] = res.getString(5);
            tblModel.addRow(data);
        }
            res.close();
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
            JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        nika = new javax.swing.JLabel();
        namaa = new javax.swing.JLabel();
        tg1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tambah = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        urut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(885, 560));
        getContentPane().setLayout(null);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(300, 110, 560, 300);

        nika.setText("\n");
        getContentPane().add(nika);
        nika.setBounds(50, 70, 141, 52);

        namaa.setText("\n");
        getContentPane().add(namaa);
        namaa.setBounds(40, 120, 141, 52);

        tg1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tg Catatan", "Suhu Tubuh" }));
        getContentPane().add(tg1);
        tg1.setBounds(610, 50, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/8.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 885, 560);

        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        getContentPane().add(tambah);
        tambah.setBounds(811, 416, 50, 50);

        kembali.setText("jButton2");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali);
        kembali.setBounds(750, 490, 110, 50);

        urut.setText("jButton1");
        urut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urutActionPerformed(evt);
            }
        });
        getContentPane().add(urut);
        urut.setBounds(771, 40, 90, 50);

        setBounds(0, 0, 885, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        menu inf = new menu();
        inf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        isi inf = new isi();
        inf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tambahActionPerformed

    private void urutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urutActionPerformed
        // TODO add your handling code here:
        String pilih=tg1.getSelectedItem().toString();
                if (pilih.equals("Suhu Tubuh")) {
                    String hubung = "jdbc:mysql://localhost:3306/cttjalan";
                    try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stt = kon.createStatement();
            
            String SQL = "Select * from tb_catatan where nik = '"+nik+"' order by suhu_tubuh asc";
            ResultSet res = stt.executeQuery(SQL);
            
            while(res.next()){
            data[0] = res.getString(1);
            data[1] = res.getString(2);
            data[2] = res.getString(3);
            data[3] = res.getString(4);
            data[4] = res.getString(5);
            tblModel.removeRow(row);
            tblModel.addRow(data);
        }
            res.close();
            stt.close();
            kon.close();
            
                    } catch (Exception exc) {
                        System.err.println(exc.getMessage()); }
                    
                    } else if (pilih.equals("Tg Catatan")){
                        String hubung = "jdbc:mysql://localhost:3306/cttjalan";
                        try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection con=DriverManager.getConnection(hubung,"root","");
                        Statement stt=con.createStatement();

               String SQL = "Select * from tb_catatan where nik = '"+nik+"' order by tgl_catatan asc";
                ResultSet res = stt.executeQuery(SQL);
                
                while(res.next()){
            data[0] = res.getString(1);
            data[1] = res.getString(2);
            data[2] = res.getString(3);
            data[3] = res.getString(4);
            data[4] = res.getString(5);
            tblModel.removeRow(row);
            tblModel.addRow(data);
        }
                    res.close();
                    stt.close();
                    con.close();

                        
                    } catch (Exception exc) {
                        System.err.println(exc.getMessage()); }
                        {
                    }
                }
    }//GEN-LAST:event_urutActionPerformed

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
            java.util.logging.Logger.getLogger(tabel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JLabel namaa;
    private javax.swing.JLabel nika;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JComboBox<String> tg1;
    private javax.swing.JButton urut;
    // End of variables declaration//GEN-END:variables
}
