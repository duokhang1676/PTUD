/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JList.DropLocation;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.json.simple.parser.ParseException;

import com.itextpdf.text.pdf.fonts.otf.TableHeader;

import components.AddContent;
import components.ButtonRender;
import components.FormatJtable;
import components.Formater;
import components.GeneratePK;
import components.LoginInfo;
import components.SpinnerEditor;
import components.TableActionCellEditor;
import components.TableActionEvent;
import dao.Ca_DAO;
import dao.ChiTietHoaDonDao;
import dao.ChiTietPhieuTraHangDao;
import dao.HoaDonDao;
import dao.PhieuTraHangDao;
import entities.Ca;
import entities.ChiTietHoaDon;
import entities.ChiTietPhieuTraHang;
import entities.DonViTinh;
import entities.HangHoa;
import entities.HoaDon;
import entities.LoHang;
import entities.NhanVien;
import entities.PhieuTraHang;
import entities.TrangThaiPhieuTraHang;

import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public class ChiTietPhieuTraHangPage extends javax.swing.JPanel {

    /**
     * Creates new form TaoPhieuTraHangPage
     */
    public ChiTietPhieuTraHangPage() {
        initComponents();
        config();
    }

    private void config() {
		// TODO Auto-generated method stub
//		pnlHeader.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu trả hàng"));
    	dpNgayLap.setEnabled(false);
    	String[] colNames = {"STT","Mã hàng hóa", "Tên hàng hóa", "Số lô",  "Hạn sử dụng","Đơn vị tính", "Số lượng trả", "Đơn giá", "Thành tiền","Lý do trả"};
        model = new DefaultTableModel(colNames, 0);
        table.setModel(model);
        FormatJtable.setFontJtable(table);
        table.setRowHeight(35);
        FormatJtable.setCellEditable(table);
        txtGhiChu.setEditable(false);
        phieuTraHang = PhieuTraHangPage.phieuTraHang;
        txtMaHD.setText(phieuTraHang.getHoaDon().getMaHoaDon());
        txtNhanVien.setText(phieuTraHang.getNhanVien().getTenNhanVien());
        txtTenKH.setText(phieuTraHang.getHoaDon().getKhachHang()==null?"":phieuTraHang.getHoaDon().getKhachHang().getTenKhachHang());
        txtSDT.setText(phieuTraHang.getHoaDon().getKhachHang()==null?"":phieuTraHang.getHoaDon().getKhachHang().getSoDienThoai());
        dpNgayLap.setDate(phieuTraHang.getThoiGianTao().toLocalDate());
        txtGioLap.setText(phieuTraHang.getThoiGianTao().getHour()+":"+phieuTraHang.getThoiGianTao().getMinute()+":"+phieuTraHang.getThoiGianTao().getSecond());
        txtTongTien.setText(Formater.decimalFormat(phieuTraHang.getTongTien()));
        txtGhiChu.setText(phieuTraHang.getGhiChu());
        if(phieuTraHang.getTrangThai().equals(TrangThaiPhieuTraHang.DA_HUY)) {
        	btn_Huy.setVisible(false);
        	txtTrangThai.setText("Đã hủy");
        }else
        	txtTrangThai.setText("Hoành thành");
        loadChiTiet();
	}
    
	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBody = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        pnlHeader = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblMaHD = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JTextField();
        lblNhanVien = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblKhachHang = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        lblSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblNgayLap = new javax.swing.JLabel();
        lblGioLap = new javax.swing.JLabel();
        txtGioLap = new javax.swing.JTextField();
        dpNgayLap = new com.github.lgooddatepicker.components.DatePicker();
        jPanel2 = new javax.swing.JPanel();
        lblTongTien = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        lblGhiChu = new javax.swing.JLabel();
        spGhiChu = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();
        pnlFooter = new javax.swing.JPanel();
        btn_Huy = new javax.swing.JButton();
        btn_Dong = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        pnlBody.setLayout(new java.awt.BorderLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hàng hóa", "Tên hàng hóa", "Số lô", "Hạn sử dụng", "Đơn vị tính", "Số lượng trả", "Đơn giá", "Thành tiền", "Lý do trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setPreferredSize(new java.awt.Dimension(300, 500));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        pnlBody.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlHeader.setPreferredSize(new java.awt.Dimension(1377, 140));

        jPanel1.setBackground(new java.awt.Color(193, 219, 208));

        lblMaHD.setText("Mã hóa đơn");
        lblMaHD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtNhanVien.setEditable(false);
        txtNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        /*
        txtNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanVienActionPerformed(evt);
            }
        });
        */

        lblNhanVien.setText("Nhân viên");
        lblNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtMaHD.setEditable(false);
        txtMaHD.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtMaHD.setBackground(new java.awt.Color(255, 255, 255));
        /*
        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });
        */

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblMaHD, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHeader.add(jPanel1);

        jPanel3.setBackground(new java.awt.Color(193, 219, 208));

        lblKhachHang.setText("Khách hàng");
        lblKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtTenKH.setEditable(false);
        txtTenKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        /*
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });
        */

        lblSDT.setText("SDT khách hàng");
        lblSDT.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtSDT.setEditable(false);
        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        /*
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        */

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKhachHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSDT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHeader.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(193, 219, 208));

        lblNgayLap.setText("Ngày lập phiếu");
        lblNgayLap.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblGioLap.setText("Giờ lập phiếu");
        lblGioLap.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtGioLap.setEditable(false);
        txtGioLap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        /*
        txtGioLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGioLapActionPerformed(evt);
            }
        });
        */

        dpNgayLap.setPreferredSize(new java.awt.Dimension(143, 25));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGioLap, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGioLap, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(dpNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNgayLap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblGioLap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGioLap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHeader.add(jPanel4);

        jPanel2.setBackground(new java.awt.Color(193, 219, 208));

        lblTongTien.setText("Tổng tiền");
        lblTongTien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        lblGhiChu.setText("Ghi chú");
        lblGhiChu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        txtGhiChu.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtGhiChuAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        spGhiChu.setViewportView(txtGhiChu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(spGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtTongTien)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGhiChu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongTien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGhiChu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlHeader.add(jPanel2);

        jPanel5.setBackground(new java.awt.Color(193, 219, 208));
        jPanel5.setPreferredSize(new java.awt.Dimension(150, 133));

        jLabel1.setText("Trạng thái");
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtTrangThai.setEditable(false);
        txtTrangThai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTrangThai)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pnlHeader.add(jPanel5);

        pnlBody.add(pnlHeader, java.awt.BorderLayout.NORTH);

        add(pnlBody, java.awt.BorderLayout.CENTER);

        pnlFooter.setBackground(new java.awt.Color(193, 219, 208));
        pnlFooter.setPreferredSize(new java.awt.Dimension(1594, 60));

        btn_Huy.setText("Hủy phiếu");
        btn_Huy.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_Huy.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HuyActionPerformed(evt);
            }
        });

        btn_Dong.setText("Trở về");
        btn_Dong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_Dong.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap(1270, Short.MAX_VALUE)
                .addComponent(btn_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        add(pnlFooter, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents



    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void txtTongTien2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTien2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTien2ActionPerformed

    private void txtTongTien5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTien5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTien5ActionPerformed

    private void txtTongTien6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTien6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTien6ActionPerformed

    private void txtTongTien8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTien8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTien8ActionPerformed

    private void txtGhiChuAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtGhiChuAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuAncestorAdded

    private void btn_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HuyActionPerformed
        // TODO add your handling code here:
    	int response = JOptionPane.showConfirmDialog(null, "Xác nhận hủy!", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if(response==JOptionPane.YES_OPTION) {
    		new PhieuTraHangDao().huyPhieuTraHang(phieuTraHang.getMaPhieu());
    		txtTrangThai.setText("Đã hủy");
    		btn_Huy.setVisible(false);
    	}
    	
    }//GEN-LAST:event_btn_HuyActionPerformed

  

	private void btn_DongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DongActionPerformed
        // TODO add your handling code here:
        AddContent.addContent(new PhieuTraHangPage());
        
    }//GEN-LAST:event_btn_DongActionPerformed

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void txtTimHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timMaSP4ActionPerformed
    	

    }//GEN-LAST:event_timMaSP4ActionPerformed

    private void loadChiTiet() {
		// TODO Auto-generated method stub
    	model.setRowCount(0);
        List<ChiTietPhieuTraHang> dsCTTH = new ChiTietPhieuTraHangDao().getDSCTTHbyMaPhieuTH(phieuTraHang.getMaPhieu());
		if(dsCTTH!=null) {
			int stt = 1;
			for (ChiTietPhieuTraHang ct : dsCTTH) {
				model.addRow(new Object[] {stt,ct.getDonViTinh().getHangHoa().getMaHangHoa(),ct.getDonViTinh().getHangHoa().getTenHangHoa(),
						ct.getLoHang().getSoLo(),ct.getLoHang().getHanSuDung(),ct.getDonViTinh().getTenDonViTinh(),
						ct.getSoLuongTra(),ct.getDonGia(),ct.tinhThanhTien(),ct.getLyDoTra()});
			}
		}
	}
    
    

	
	private PhieuTraHang phieuTraHang;
    private DefaultTableModel model;
	private HoaDon hd;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Dong;
    private javax.swing.JButton btn_Huy;
    private com.github.lgooddatepicker.components.DatePicker dpNgayLap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblGioLap;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JScrollPane spGhiChu;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGioLap;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
