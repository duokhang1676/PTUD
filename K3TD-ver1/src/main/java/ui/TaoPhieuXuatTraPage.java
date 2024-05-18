/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import components.ResizeContents;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class TaoPhieuXuatTraPage extends javax.swing.JPanel {

    /**
     * Creates new form NhapHang
     */
    public TaoPhieuXuatTraPage() {
        initComponents();
        new ResizeContents().resizeContent(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_header = new javax.swing.JPanel();
        jL_maPhieuNhap = new javax.swing.JLabel();
        txt_maPhieuNhap = new javax.swing.JTextField();
        dTP_phieuNhap = new com.github.lgooddatepicker.components.DateTimePicker();
        jL_ngayLap = new javax.swing.JLabel();
        jL_gioNhap = new javax.swing.JLabel();
        jL_maHoaDonNCC = new javax.swing.JLabel();
        txt_maHoaDon = new javax.swing.JTextField();
        jL_ghiChu = new javax.swing.JLabel();
        jL_maNCC = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jP_body = new javax.swing.JPanel();
        jP_bodyHeader = new javax.swing.JPanel();
        jL_maPhieuNhapMau = new javax.swing.JLabel();
        cb_maPhieuNhapMau = new javax.swing.JComboBox<>();
        jL_timHangHoa = new javax.swing.JLabel();
        txt_timHangHoa = new javax.swing.JTextField();
        txt_chietKhau = new javax.swing.JTextField();
        jL_chietKhau = new javax.swing.JLabel();
        jL_iconTimKiem = new javax.swing.JLabel();
        txt_tongTienNhap = new javax.swing.JTextField();
        jL_tongTienNhap = new javax.swing.JLabel();
        txt_tongThanhTien = new javax.swing.JTextField();
        jL_tongThanhTien = new javax.swing.JLabel();
        btn_taoPhieuNhap1 = new javax.swing.JButton();
        btn_thoat1 = new javax.swing.JButton();
        jP_tableContent = new javax.swing.JPanel();
        jL_chiTietPhieuGhi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_content = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1860, 700));
        setLayout(new java.awt.BorderLayout());

        jP_header.setBackground(new java.awt.Color(255, 255, 255));
        jP_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_maPhieuNhap.setText("Mã phiếu xuất:");
        jL_maPhieuNhap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_header.add(jL_maPhieuNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        txt_maPhieuNhap.setEditable(false);
        txt_maPhieuNhap.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_maPhieuNhap.setPreferredSize(new java.awt.Dimension(400, 35));
        txt_maPhieuNhap.setToolTipText("Mã tự phát sinh");
        txt_maPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maPhieuNhapActionPerformed(evt);
            }
        });
        jP_header.add(txt_maPhieuNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 200, -1));

        dTP_phieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        dTP_phieuNhap.setPreferredSize(new java.awt.Dimension(400, 35));
        jP_header.add(dTP_phieuNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 300, -1));

        jL_ngayLap.setText("Ngày lập phiếu:");
        jL_ngayLap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_header.add(jL_ngayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jL_gioNhap.setText("Giờ nhập phiếu:");
        jL_gioNhap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_header.add(jL_gioNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        jL_maHoaDonNCC.setText("Mã hóa đơn nhà cung cấp:");
        jL_maHoaDonNCC.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_header.add(jL_maHoaDonNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 180, -1));

        txt_maHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_maHoaDon.setPreferredSize(new java.awt.Dimension(350, 35));
        txt_maHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maHoaDonActionPerformed(evt);
            }
        });
        jP_header.add(txt_maHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 200, -1));

        jL_ghiChu.setText("Ghi chú:");
        jL_ghiChu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_header.add(jL_ghiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, -1, -1));

        jL_maNCC.setText("Nhà cung cấp:");
        jL_maNCC.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_header.add(jL_maNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 180, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox1.setPreferredSize(new java.awt.Dimension(250, 35));
        jP_header.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 200, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jP_header.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 40, 380, 35));

        add(jP_header, java.awt.BorderLayout.PAGE_START);

        jP_body.setBackground(new java.awt.Color(255, 255, 255));
        jP_body.setLayout(new java.awt.BorderLayout(0, 10));

        jP_bodyHeader.setBackground(new java.awt.Color(255, 255, 255));
        jP_bodyHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_maPhieuNhapMau.setText("Phiếu xuất mẫu:");
        jL_maPhieuNhapMau.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_bodyHeader.add(jL_maPhieuNhapMau, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        cb_maPhieuNhapMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn phiếu xuất mẫu --", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_maPhieuNhapMau.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cb_maPhieuNhapMau.setPreferredSize(new java.awt.Dimension(400, 35));
        cb_maPhieuNhapMau.setToolTipText("");
        jP_bodyHeader.add(cb_maPhieuNhapMau, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 200, -1));

        jL_timHangHoa.setText("Tìm hàng hóa:");
        jL_timHangHoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_bodyHeader.add(jL_timHangHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        txt_timHangHoa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_timHangHoa.setPreferredSize(new java.awt.Dimension(400, 35));
        txt_timHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timHangHoaActionPerformed(evt);
            }
        });
        jP_bodyHeader.add(txt_timHangHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 270, -1));

        txt_chietKhau.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_chietKhau.setPreferredSize(new java.awt.Dimension(100, 35));
        txt_chietKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chietKhauActionPerformed(evt);
            }
        });
        jP_bodyHeader.add(txt_chietKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 200, -1));

        jL_chietKhau.setText("Tổng giảm giá:");
        jL_chietKhau.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_bodyHeader.add(jL_chietKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));

        jL_iconTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-32.png"))); // NOI18N
        jP_bodyHeader.add(jL_iconTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        txt_tongTienNhap.setEditable(false);
        txt_tongTienNhap.setBackground(new java.awt.Color(255, 255, 255));
        txt_tongTienNhap.setPreferredSize(new java.awt.Dimension(150, 35));
        txt_tongTienNhap.setToolTipText("");
        txt_tongTienNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tongTienNhapActionPerformed(evt);
            }
        });
        jP_bodyHeader.add(txt_tongTienNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 200, -1));

        jL_tongTienNhap.setText("Tổng tiền hàng:");
        jL_tongTienNhap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_bodyHeader.add(jL_tongTienNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 100, -1));

        txt_tongThanhTien.setEditable(false);
        txt_tongThanhTien.setBackground(new java.awt.Color(255, 255, 255));
        txt_tongThanhTien.setPreferredSize(new java.awt.Dimension(150, 35));
        txt_tongThanhTien.setToolTipText("");
        jP_bodyHeader.add(txt_tongThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 40, 200, 35));

        jL_tongThanhTien.setText("Tổng thành tiền");
        jL_tongThanhTien.setBackground(new java.awt.Color(255, 255, 255));
        jL_tongThanhTien.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jL_tongThanhTien.setForeground(new java.awt.Color(255, 102, 102));
        jP_bodyHeader.add(jL_tongThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 180, 30));

        btn_taoPhieuNhap1.setText("Tạo phiếu xuất");
        btn_taoPhieuNhap1.setBackground(new java.awt.Color(193, 219, 208));
        btn_taoPhieuNhap1.setBorderPainted(false);
        btn_taoPhieuNhap1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_taoPhieuNhap1.setForeground(new java.awt.Color(218, 80, 90));
        btn_taoPhieuNhap1.setPreferredSize(new java.awt.Dimension(150, 45));
        btn_taoPhieuNhap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoPhieuNhap1ActionPerformed(evt);
            }
        });
        jP_bodyHeader.add(btn_taoPhieuNhap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 10, 130, 35));

        btn_thoat1.setText("Thoát");
        btn_thoat1.setBackground(new java.awt.Color(193, 219, 208));
        btn_thoat1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_thoat1.setForeground(new java.awt.Color(218, 80, 90));
        btn_thoat1.setPreferredSize(new java.awt.Dimension(100, 45));
        btn_thoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoat1ActionPerformed(evt);
            }
        });
        jP_bodyHeader.add(btn_thoat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 50, 130, 35));

        jP_body.add(jP_bodyHeader, java.awt.BorderLayout.PAGE_START);

        jP_tableContent.setLayout(new java.awt.BorderLayout(0, 10));

        jL_chiTietPhieuGhi.setText("Chi tiết phiếu ghi");
        jL_chiTietPhieuGhi.setBackground(new java.awt.Color(255, 255, 255));
        jL_chiTietPhieuGhi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_tableContent.add(jL_chiTietPhieuGhi, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_content.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HH", "Tên HH", "Số lô", "Hạn sử dụng", "DVT", "Số lượng", "Giá nhập", "VAT (%)", "Chiết khấu", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_content.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_content.setRowHeight(50);
        jScrollPane1.setViewportView(tbl_content);
        if (tbl_content.getColumnModel().getColumnCount() > 0) {
            tbl_content.getColumnModel().getColumn(0).setResizable(false);
            tbl_content.getColumnModel().getColumn(1).setResizable(false);
            tbl_content.getColumnModel().getColumn(2).setResizable(false);
            tbl_content.getColumnModel().getColumn(3).setResizable(false);
            tbl_content.getColumnModel().getColumn(4).setResizable(false);
            tbl_content.getColumnModel().getColumn(5).setResizable(false);
            tbl_content.getColumnModel().getColumn(6).setResizable(false);
            tbl_content.getColumnModel().getColumn(7).setResizable(false);
            tbl_content.getColumnModel().getColumn(8).setResizable(false);
            tbl_content.getColumnModel().getColumn(9).setResizable(false);
            tbl_content.getColumnModel().getColumn(10).setResizable(false);
        }

        jP_tableContent.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jP_body.add(jP_tableContent, java.awt.BorderLayout.CENTER);

        add(jP_body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timHangHoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timHangHoaActionPerformed

    private void txt_chietKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chietKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chietKhauActionPerformed

    private void txt_tongTienNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tongTienNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tongTienNhapActionPerformed

    private void btn_taoPhieuNhap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoPhieuNhap1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taoPhieuNhap1ActionPerformed

    private void txt_maHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maHoaDonActionPerformed

    private void txt_maPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maPhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maPhieuNhapActionPerformed

    private void btn_thoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_thoat1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_taoPhieuNhap1;
    private javax.swing.JButton btn_thoat1;
    private javax.swing.JComboBox<String> cb_maPhieuNhapMau;
    private com.github.lgooddatepicker.components.DateTimePicker dTP_phieuNhap;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jL_chiTietPhieuGhi;
    private javax.swing.JLabel jL_chietKhau;
    private javax.swing.JLabel jL_ghiChu;
    private javax.swing.JLabel jL_gioNhap;
    private javax.swing.JLabel jL_iconTimKiem;
    private javax.swing.JLabel jL_maHoaDonNCC;
    private javax.swing.JLabel jL_maNCC;
    private javax.swing.JLabel jL_maPhieuNhap;
    private javax.swing.JLabel jL_maPhieuNhapMau;
    private javax.swing.JLabel jL_ngayLap;
    private javax.swing.JLabel jL_timHangHoa;
    private javax.swing.JLabel jL_tongThanhTien;
    private javax.swing.JLabel jL_tongTienNhap;
    private javax.swing.JPanel jP_body;
    private javax.swing.JPanel jP_bodyHeader;
    private javax.swing.JPanel jP_header;
    private javax.swing.JPanel jP_tableContent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tbl_content;
    private javax.swing.JTextField txt_chietKhau;
    private javax.swing.JTextField txt_maHoaDon;
    private javax.swing.JTextField txt_maPhieuNhap;
    private javax.swing.JTextField txt_timHangHoa;
    private javax.swing.JTextField txt_tongThanhTien;
    private javax.swing.JTextField txt_tongTienNhap;
    // End of variables declaration//GEN-END:variables
}
