/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller.voucher;


import Model.phim.ThucHienBusiness;
import Model.phongchieu.PhongChieuBusiness;
import Model.voucher.ThongTinVoucher;
import Model.voucher.VoucherBusiness;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class HeThongVoucher extends javax.swing.JFrame {

    /**
     * Creates new form HeThongVoucher
     */
    public HeThongVoucher() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Tìm kiếm theo mã và tên khách hàng: ");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jButton1)))
                .addContainerGap(472, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Thêm mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Đóng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jButton2)
                .addGap(72, 72, 72)
                .addComponent(jButton3)
                .addGap(44, 44, 44)
                .addComponent(jButton4)
                .addGap(48, 48, 48)
                .addComponent(jButton5)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        themMoiVoucher frmThemMoi = new themMoiVoucher(); 
        
        frmThemMoi.setVisible(rootPaneCheckingEnabled);        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String maThe="";
        int dongChon=0;
        themMoiVoucher frmSua= new themMoiVoucher();
        
        //Lấy chỉ số dòng chọn trên Main Table
        dongChon= jTable1.getSelectedRow();
        
        //Lấy thông tin mã phim của dòng chọn
        maThe = ""+jTable1.getValueAt(dongChon, 0);
        
        //Truyền mã phim lên giao diện sửa
        frmSua.setMaBoPhim(maThe);
        //Hiện thị thông tin
        frmSua.setVisible(rootPaneCheckingEnabled);        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int ketQua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không?");
        
        if(ketQua == JOptionPane.YES_OPTION){
            String maThe = "";
            int dongChon = 0;
            
            dongChon = jTable1.getSelectedRow();
            
            maThe= "" + jTable1.getValueAt(dongChon, 0);
            
            //Khai báo đối tượng
            VoucherBusiness thuchien = new VoucherBusiness();
            
            //Thực hiện công việc xóa
            boolean XoaP = thuchien.xoaVoucher(maThe);
            
            if(XoaP){
                
                //ReLoad lại danh sách
                hienThiDanhSachVoucher();
                
            }
        }         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        Khai báo biến
        VoucherBusiness thuchienpc = new VoucherBusiness();
        String timTen = "";

        timTen = jTextField1.getText();

        //Lấy danh sách phim từ db
        List<ThongTinVoucher> lstVoucher = thuchienpc.timKiemVoucher(timTen);        
        //Khai báo 1 đối tượng dderr đưa vào jTable\

        //Khai báo các cột tiêu đề trên jTable
        String colTieuDe[] = new String[]{"Mã thẻ", "Loại thẻ", "Tên khách hàng", "Giới tính", "Số CMT", "Số điện thoại", "Địa chỉ", "Số lần tích lũy", "Giảm giá"};

        //Khai báo 1 đối tượng dderr đưa vào jTable
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        model.setRowCount(0);
        Object[] row = {"MaThe", "LoaiThe", "TenKhachHang", "GioiTinh", "SoCMT", "SDT", "DiaChi", "SoLanTichLuy", "Voucher"};
        for (ThongTinVoucher ttt : lstVoucher) {
            row = new Object[9];
            row[0] = ttt.getMaThe();
            row[1] = ttt.getLoaiThe();
            row[2] = ttt.getTenKhachHang();
            row[3] = ttt.getGioiTinh();
            row[4] = ttt.getSoCMT();
            row[5] = ttt.getSDT();
            row[6] = ttt.getDiaChi();
            row[7] = ttt.getSoLanTichLuy();
            row[8] = ttt.getVoucher();
            model.addRow(row);

        }
        //Thêm vào mục model
        jTable1.setModel(model);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        hienThiDanhSachVoucher();
    }//GEN-LAST:event_formWindowOpened
    public static void hienThiDanhSachVoucher() {
        //Khai báo 1 đối tượng thuộc lớp ThucHienBusiness
        VoucherBusiness thuchien = new VoucherBusiness();
        List<ThongTinVoucher> l = thuchien.layDanhSach();

        //Khai báo biến


        //Khai báo các cột tiêu đề trên jTable
        String colTieuDe[] = new String[]{"Mã thẻ", "Loại thẻ", "Tên khách hàng", "Giới tính", "Số CMT", "Số điện thoại", "Địa chỉ", "Số lần tích lũy", "Giảm giá"};

        //Khai báo 1 đối tượng dderr đưa vào jTable
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        model.setRowCount(0);
        Object[] row = {"MaThe", "LoaiThe", "TenKhachHang", "GioiTinh", "SoCMT", "SDT", "DiaChi", "SoLanTichLuy", "Voucher"};
        for (ThongTinVoucher ttt : l) {
            row = new Object[9];
            row[0] = ttt.getMaThe();
            row[1] = ttt.getLoaiThe();
            row[2] = ttt.getTenKhachHang();
            row[3] = ttt.getGioiTinh();
            row[4] = ttt.getSoCMT();
            row[5] = ttt.getSDT();
            row[6] = ttt.getDiaChi();
            row[7] = ttt.getSoLanTichLuy();
            row[8] = ttt.getVoucher();

            model.addRow(row);

        }
        //Thêm vào mục model
        jTable1.setModel(model);

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
            java.util.logging.Logger.getLogger(HeThongVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HeThongVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HeThongVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HeThongVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HeThongVoucher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
