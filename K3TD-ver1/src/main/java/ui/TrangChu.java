/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

/**
 *
 * @author ACER
 */
public class TrangChu extends javax.swing.JPanel {

    /**
     * Creates new form TrangChuTest
     */
    public TrangChu() {
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

        jP_thongKe = new javax.swing.JPanel();
        jP_doanhSo = new javax.swing.JPanel();
        jP_doanhSoTieuDe = new javax.swing.JPanel();
        jL_doanhSo = new javax.swing.JLabel();
        jP_doanhSoContent = new javax.swing.JPanel();
        jL_thangTruoc = new javax.swing.JLabel();
        jL_doanhThuThangTruoc = new javax.swing.JLabel();
        jL_thangNay = new javax.swing.JLabel();
        jL_doanhThuThangNay = new javax.swing.JLabel();
        jP_hoaDon = new javax.swing.JPanel();
        jP_hoaDonTieuDe = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jP_hoaDonContent = new javax.swing.JPanel();
        jP_doanhSoContent1 = new javax.swing.JPanel();
        jL_thangTruoc1 = new javax.swing.JLabel();
        jL_hoaDonThangTruoc = new javax.swing.JLabel();
        jL_thangNay1 = new javax.swing.JLabel();
        jL_hoaDonThangNay = new javax.swing.JLabel();
        jP_doanhSoNgay = new javax.swing.JPanel();
        jP_doanhSoNgayTieuDe = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jP_doanhSoNgayContent = new javax.swing.JPanel();
        jP_doanhSoContent2 = new javax.swing.JPanel();
        jL_doanhThuNgay = new javax.swing.JLabel();
        jL_doanhThuThuDuoc = new javax.swing.JLabel();
        jL_soHoaDon = new javax.swing.JLabel();
        jL_soHoaDonNgay = new javax.swing.JLabel();
        jP_main = new javax.swing.JPanel();
        jP_canhBao = new javax.swing.JPanel();
        jL_canhBaoHangHoa = new javax.swing.JLabel();
        jP_canhBaoContent = new javax.swing.JPanel();
        jP_menuCanhBao = new javax.swing.JPanel();
        btn_hangDaHetHan = new javax.swing.JButton();
        btn_hangSapHetHan = new javax.swing.JButton();
        btn_hangSapHet = new javax.swing.JButton();
        jP_table = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_hangHoa = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jP_thongKe.setBackground(new java.awt.Color(248, 245, 245));
        jP_thongKe.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê tổng quan"));
        jP_thongKe.setPreferredSize(new java.awt.Dimension((int) screenSize.getWidth(), 230));
        jP_thongKe.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 150, 10));

        jP_doanhSo.setBackground(new java.awt.Color(255, 255, 255));
        jP_doanhSo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 224, 228)));
        jP_doanhSo.setPreferredSize(new java.awt.Dimension((int) screenSize.getWidth()/5, 170));
        jP_doanhSo.setLayout(new java.awt.BorderLayout());

        jP_doanhSoTieuDe.setBackground(new java.awt.Color(193,219,208));
        jP_doanhSoTieuDe.setPreferredSize(new java.awt.Dimension(398, 50));

        jL_doanhSo.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jL_doanhSo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-coin-32 - Copy.png"))); // NOI18N
        jL_doanhSo.setText("Doanh số:");

        javax.swing.GroupLayout jP_doanhSoTieuDeLayout = new javax.swing.GroupLayout(jP_doanhSoTieuDe);
        jP_doanhSoTieuDe.setLayout(jP_doanhSoTieuDeLayout);
        jP_doanhSoTieuDeLayout.setHorizontalGroup(
            jP_doanhSoTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_doanhSoTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_doanhSo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_doanhSoTieuDeLayout.setVerticalGroup(
            jP_doanhSoTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_doanhSoTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_doanhSo, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jP_doanhSo.add(jP_doanhSoTieuDe, java.awt.BorderLayout.PAGE_START);

        jP_doanhSoContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_thangTruoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jL_thangTruoc.setText("Tháng trước: ");
        jP_doanhSoContent.add(jL_thangTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jL_doanhThuThangTruoc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jL_doanhThuThangTruoc.setText("0.0");
        jP_doanhSoContent.add(jL_doanhThuThangTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jL_thangNay.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jL_thangNay.setText("Tháng này: ");
        jP_doanhSoContent.add(jL_thangNay, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jL_doanhThuThangNay.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jL_doanhThuThangNay.setText("0.0");
        jP_doanhSoContent.add(jL_doanhThuThangNay, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        jP_doanhSo.add(jP_doanhSoContent, java.awt.BorderLayout.CENTER);

        jP_thongKe.add(jP_doanhSo);

        jP_hoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 224, 228)));
        jP_hoaDon.setPreferredSize(new java.awt.Dimension((int) screenSize.getWidth()/5, 170));
        jP_hoaDon.setLayout(new java.awt.BorderLayout());

        jP_hoaDonTieuDe.setBackground(new java.awt.Color(193,219,208));
        jP_hoaDonTieuDe.setPreferredSize(new java.awt.Dimension(398, 50));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-bill-32.png"))); // NOI18N
        jLabel2.setText("Hóa đơn:");

        javax.swing.GroupLayout jP_hoaDonTieuDeLayout = new javax.swing.GroupLayout(jP_hoaDonTieuDe);
        jP_hoaDonTieuDe.setLayout(jP_hoaDonTieuDeLayout);
        jP_hoaDonTieuDeLayout.setHorizontalGroup(
            jP_hoaDonTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_hoaDonTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_hoaDonTieuDeLayout.setVerticalGroup(
            jP_hoaDonTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_hoaDonTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jP_hoaDon.add(jP_hoaDonTieuDe, java.awt.BorderLayout.PAGE_START);

        jP_hoaDonContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jP_doanhSoContent1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_thangTruoc1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jL_thangTruoc1.setText("Tháng trước: ");
        jP_doanhSoContent1.add(jL_thangTruoc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jL_hoaDonThangTruoc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jL_hoaDonThangTruoc.setText("0.0");
        jP_doanhSoContent1.add(jL_hoaDonThangTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jL_thangNay1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jL_thangNay1.setText("Tháng này: ");
        jP_doanhSoContent1.add(jL_thangNay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jL_hoaDonThangNay.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jL_hoaDonThangNay.setText("0.0");
        jP_doanhSoContent1.add(jL_hoaDonThangNay, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        jP_hoaDonContent.add(jP_doanhSoContent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jP_hoaDon.add(jP_hoaDonContent, java.awt.BorderLayout.CENTER);

        jP_thongKe.add(jP_hoaDon);

        jP_doanhSoNgay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 224, 228)));
        jP_doanhSoNgay.setPreferredSize(new java.awt.Dimension((int) screenSize.getWidth()/5, 170));
        jP_doanhSoNgay.setLayout(new java.awt.BorderLayout());

        jP_doanhSoNgayTieuDe.setBackground(new java.awt.Color(193,219,208));
        jP_doanhSoNgayTieuDe.setPreferredSize(new java.awt.Dimension(398, 50));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-increase-32.png"))); // NOI18N
        jLabel3.setText("Báo cáo trong ngày:");

        javax.swing.GroupLayout jP_doanhSoNgayTieuDeLayout = new javax.swing.GroupLayout(jP_doanhSoNgayTieuDe);
        jP_doanhSoNgayTieuDe.setLayout(jP_doanhSoNgayTieuDeLayout);
        jP_doanhSoNgayTieuDeLayout.setHorizontalGroup(
            jP_doanhSoNgayTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_doanhSoNgayTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_doanhSoNgayTieuDeLayout.setVerticalGroup(
            jP_doanhSoNgayTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_doanhSoNgayTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jP_doanhSoNgay.add(jP_doanhSoNgayTieuDe, java.awt.BorderLayout.PAGE_START);

        jP_doanhSoNgayContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jP_doanhSoContent2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_doanhThuNgay.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jL_doanhThuNgay.setText("Doanh thu: ");
        jP_doanhSoContent2.add(jL_doanhThuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jL_doanhThuThuDuoc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jL_doanhThuThuDuoc.setText("0.0");
        jP_doanhSoContent2.add(jL_doanhThuThuDuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jL_soHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jL_soHoaDon.setText("Số hóa đơn: ");
        jP_doanhSoContent2.add(jL_soHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jL_soHoaDonNgay.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jL_soHoaDonNgay.setText("0.0");
        jP_doanhSoContent2.add(jL_soHoaDonNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        jP_doanhSoNgayContent.add(jP_doanhSoContent2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jP_doanhSoNgay.add(jP_doanhSoNgayContent, java.awt.BorderLayout.CENTER);

        jP_thongKe.add(jP_doanhSoNgay);

        add(jP_thongKe, java.awt.BorderLayout.PAGE_START);

        jP_main.setBackground(new java.awt.Color(255, 255, 255));
        jP_main.setLayout(new java.awt.BorderLayout());

        jP_canhBao.setBackground(new java.awt.Color(193, 219, 208));
        jP_canhBao.setPreferredSize(new Dimension((int) screenSize.getWidth(), 100)
        );
        jP_canhBao.setLayout(new java.awt.BorderLayout());

        jL_canhBaoHangHoa.setBackground(new java.awt.Color(255, 255, 255));
        jL_canhBaoHangHoa.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jL_canhBaoHangHoa.setForeground(new java.awt.Color(255, 169, 169));
        jL_canhBaoHangHoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_canhBaoHangHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-warning-48.png"))); // NOI18N
        jL_canhBaoHangHoa.setText("Cảnh báo hàng hóa!!!");
        jP_canhBao.add(jL_canhBaoHangHoa, java.awt.BorderLayout.PAGE_START);

        jP_canhBaoContent.setBackground(new java.awt.Color(255, 255, 255));
        jP_canhBaoContent.setLayout(new java.awt.BorderLayout());

        jP_menuCanhBao.setBackground(new java.awt.Color(255, 255, 255));
        jP_menuCanhBao.setPreferredSize(new Dimension((int) screenSize.getWidth(), 40));
        jP_menuCanhBao.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 50, 5));

        btn_hangDaHetHan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_hangDaHetHan.setText("Hàng hóa đã hết hạn");
        btn_hangDaHetHan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_hangDaHetHan.setBorderPainted(false);
        btn_hangDaHetHan.setContentAreaFilled(false);
        btn_hangDaHetHan.setPreferredSize(new java.awt.Dimension(190, 30));
        btn_hangDaHetHan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hangDaHetHanMouseClicked(evt);
            }
        });
        btn_hangDaHetHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hangDaHetHanActionPerformed(evt);
            }
        });
        jP_menuCanhBao.add(btn_hangDaHetHan);

        btn_hangSapHetHan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_hangSapHetHan.setText("Hàng hóa sắp hết hạn");
        btn_hangSapHetHan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_hangSapHetHan.setContentAreaFilled(false);
        btn_hangSapHetHan.setPreferredSize(new java.awt.Dimension(190, 30));
        btn_hangSapHetHan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hangSapHetHanMouseClicked(evt);
            }
        });
        jP_menuCanhBao.add(btn_hangSapHetHan);

        btn_hangSapHet.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_hangSapHet.setText("Hàng hóa sắp hết hàng");
        btn_hangSapHet.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_hangSapHet.setBorderPainted(false);
        btn_hangSapHet.setContentAreaFilled(false);
        btn_hangSapHet.setPreferredSize(new java.awt.Dimension(190, 30));
        btn_hangSapHet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hangSapHetMouseClicked(evt);
            }
        });
        jP_menuCanhBao.add(btn_hangSapHet);

        jP_canhBaoContent.add(jP_menuCanhBao, java.awt.BorderLayout.PAGE_START);

        jP_table.setBackground(new java.awt.Color(255, 255, 255));
        jP_table.setLayout(new java.awt.BorderLayout());

        tb_hangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã hàng hóa", "Tên hàng hóa", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_hangHoa.setRowHeight(50);
        jScrollPane2.setViewportView(tb_hangHoa);
        if (tb_hangHoa.getColumnModel().getColumnCount() > 0) {
            tb_hangHoa.getColumnModel().getColumn(0).setResizable(false);
            tb_hangHoa.getColumnModel().getColumn(1).setResizable(false);
            tb_hangHoa.getColumnModel().getColumn(2).setResizable(false);
        }

        jP_table.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jP_canhBaoContent.add(jP_table, java.awt.BorderLayout.CENTER);

        jP_canhBao.add(jP_canhBaoContent, java.awt.BorderLayout.CENTER);

        jP_main.add(jP_canhBao, java.awt.BorderLayout.CENTER);

        add(jP_main, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hangDaHetHanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hangDaHetHanMouseClicked
        // TODO add your handling code here:
        Font selected_font = new Font("Times new roman", Font.BOLD, 18);
        Font unSelected_font = new Font("Times new roman",0, 18);

        btn_hangDaHetHan.setFont(selected_font);
        btn_hangDaHetHan.setForeground(new Color(255,169,169));

        btn_hangSapHetHan.setFont(unSelected_font);
        btn_hangSapHetHan.setForeground(Color.BLACK);

        btn_hangSapHet.setFont(unSelected_font);
        btn_hangSapHet.setForeground(Color.BLACK);

    }//GEN-LAST:event_btn_hangDaHetHanMouseClicked

    private void btn_hangDaHetHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hangDaHetHanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hangDaHetHanActionPerformed

    private void btn_hangSapHetHanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hangSapHetHanMouseClicked
        // TODO add your handling code here:
        Font selected_font = new Font("Times new roman", Font.BOLD, 18);
        Font unSelected_font = new Font("Times new roman",0, 18);

        btn_hangSapHetHan.setFont(selected_font);
        btn_hangSapHetHan.setForeground(new Color(255,169,169));

        btn_hangDaHetHan.setFont(unSelected_font);
        btn_hangDaHetHan.setForeground(Color.BLACK);

        btn_hangSapHet.setFont(unSelected_font);
        btn_hangSapHet.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_hangSapHetHanMouseClicked

    private void btn_hangSapHetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hangSapHetMouseClicked
        // TODO add your handling code here:
        Font selected_font = new Font("Times new roman", Font.BOLD, 18);
        Font unSelected_font = new Font("Times new roman",0, 18);
        btn_hangSapHet.setFont(selected_font);
        btn_hangSapHet.setForeground(new Color(255,169,169));

        btn_hangSapHetHan.setFont(unSelected_font);
        btn_hangSapHetHan.setForeground(Color.BLACK);

        btn_hangDaHetHan.setFont(unSelected_font);
        btn_hangDaHetHan.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_hangSapHetMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hangDaHetHan;
    private javax.swing.JButton btn_hangSapHet;
    private javax.swing.JButton btn_hangSapHetHan;
    private javax.swing.JLabel jL_canhBaoHangHoa;
    private javax.swing.JLabel jL_doanhSo;
    private javax.swing.JLabel jL_doanhThuNgay;
    private javax.swing.JLabel jL_doanhThuThangNay;
    private javax.swing.JLabel jL_doanhThuThangTruoc;
    private javax.swing.JLabel jL_doanhThuThuDuoc;
    private javax.swing.JLabel jL_hoaDonThangNay;
    private javax.swing.JLabel jL_hoaDonThangTruoc;
    private javax.swing.JLabel jL_soHoaDon;
    private javax.swing.JLabel jL_soHoaDonNgay;
    private javax.swing.JLabel jL_thangNay;
    private javax.swing.JLabel jL_thangNay1;
    private javax.swing.JLabel jL_thangTruoc;
    private javax.swing.JLabel jL_thangTruoc1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jP_canhBao;
    private javax.swing.JPanel jP_canhBaoContent;
    private javax.swing.JPanel jP_doanhSo;
    private javax.swing.JPanel jP_doanhSoContent;
    private javax.swing.JPanel jP_doanhSoContent1;
    private javax.swing.JPanel jP_doanhSoContent2;
    private javax.swing.JPanel jP_doanhSoNgay;
    private javax.swing.JPanel jP_doanhSoNgayContent;
    private javax.swing.JPanel jP_doanhSoNgayTieuDe;
    private javax.swing.JPanel jP_doanhSoTieuDe;
    private javax.swing.JPanel jP_hoaDon;
    private javax.swing.JPanel jP_hoaDonContent;
    private javax.swing.JPanel jP_hoaDonTieuDe;
    private javax.swing.JPanel jP_main;
    private javax.swing.JPanel jP_menuCanhBao;
    private javax.swing.JPanel jP_table;
    private javax.swing.JPanel jP_thongKe;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_hangHoa;
    // End of variables declaration//GEN-END:variables
}
