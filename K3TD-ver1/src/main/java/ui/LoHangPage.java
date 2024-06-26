/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import components.AddContent;
import components.FormatJtable;
import components.PnlHangHoaInfo;
import components.ResizeContent;
import dao.LoHangDao;
import dao.NhaCungCap_DAO;
import db.ConnectDB;
import entities.*;
/**
 *
 * @author Admin
 */
public class LoHangPage extends javax.swing.JPanel {

    
	private DefaultTableModel model_NCC;
	private JTable tbl_NCC;
	private NhaCungCap_DAO nhaCC_dao;
	private LoHangDao loHang_dao = new LoHangDao();
    private entities.NhaCungCap nCC;
	
	/**
     * Creates new form NhanVien_httk
     */
    public LoHangPage()  {
        initComponents();
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ResizeContent.resizeContent(this);
        pnl_left.setVisible(false);
        addTableNCC();
        loadDataLoHang();
//        loadDataNCC();
    }



	private void loadDataLoHang() {
		// TODO Auto-generated method stub
		int stt = 1;
		
		List<LoHang> dsLoHang = loHang_dao.getLoHangTheoMaHH(XemThongTinHangHoaPage.txt_maHangHoa.getText());
		for (LoHang l : dsLoHang) {
			//"STT","Số lô", "Mã hàng hóa", "Số lượng",  "Ngày sản xuất","Hạn sử dụng","Giá nhập", "Mã nhà cung cấp"
			model_NCC.addRow(new Object[] {stt, l.getSoLo(), l.getHangHoa().getMaHangHoa(), l.getSoLuong(),
					l.getNgaySanXuat(), l.getHanSuDung(), l.getGiaNhap(), l.getNhaCungCap().getMaNhaCungCap()});
			
			stt++;
			
		}
	}



	private void addTableNCC() {
		// TODO Auto-generated method stub
    	String[] colNames = {"STT","Số lô", "Mã hàng hóa", "Số lượng",  "Ngày sản xuất","Hạn sử dụng","Giá nhập", "Mã nhà cung cấp"};
        
        model_NCC = new DefaultTableModel(colNames, 0);
        tbl_NCC = new JTable(model_NCC);
        FormatJtable.setFontJtable(tbl_NCC);
        JScrollPane js_tableHangHoa = new JScrollPane(tbl_NCC);
        
        if (tbl_NCC.getColumnModel().getColumnCount() > 0) {
        	tbl_NCC.getColumnModel().getColumn(0).setResizable(false);
        	tbl_NCC.getColumnModel().getColumn(1).setResizable(false);
        	tbl_NCC.getColumnModel().getColumn(2).setResizable(false);
        	tbl_NCC.getColumnModel().getColumn(3).setResizable(false);
        	tbl_NCC.getColumnModel().getColumn(4).setResizable(false);
        	tbl_NCC.getColumnModel().getColumn(5).setResizable(false);
        	tbl_NCC.getColumnModel().getColumn(6).setResizable(false);
        	tbl_NCC.getColumnModel().getColumn(7).setResizable(false);
            
        }
        
        JTableHeader headerTable =  tbl_NCC.getTableHeader();
		headerTable.setPreferredSize(new Dimension(headerTable.getPreferredSize().width, 40));
		tbl_NCC.setRowHeight(40);
//		setCellEditable();
        pnlCenter.add(js_tableHangHoa, BorderLayout.CENTER);
        
//        tbl_hangHoa.addMouseListener(this);
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_left = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlForm = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTenNhaCungCap = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        pnlFooter = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_maNhaCungCap = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbo_TrangThai = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        btn_Dong = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_ghiChu = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        txtDiaChi1 = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        pnlCenter = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_thoat = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1920, 840));
        setLayout(new java.awt.BorderLayout());

        pnl_left.setPreferredSize(new java.awt.Dimension(470, 840));
        pnl_left.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlHeader.setPreferredSize(new java.awt.Dimension(470, 840));

        pnlForm.setBackground(new java.awt.Color(255, 255, 255));
        pnlForm.setPreferredSize(new java.awt.Dimension(470, 840));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txtTenNhaCungCap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenNhaCungCap.setPreferredSize(new java.awt.Dimension(64, 35));
        txtTenNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNhaCungCapActionPerformed(evt);
            }
        });

        txtSoDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSoDienThoai.setPreferredSize(new java.awt.Dimension(64, 35));
        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        pnlFooter.setBackground(new java.awt.Color(255, 255, 255));
        pnlFooter.setPreferredSize(new java.awt.Dimension(470, 50));

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Mã nhà cung cấp");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setText("Thông tin nhà cung cấp");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Tên nhà cung cấp");

        txt_maNhaCungCap.setEditable(false);
        txt_maNhaCungCap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_maNhaCungCap.setPreferredSize(new java.awt.Dimension(64, 35));
        txt_maNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maNhaCungCapActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Email");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Ghi chú");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Số điện thoại");

        cbo_TrangThai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbo_TrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Ngừng hoạt động" }));
        cbo_TrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_TrangThaiActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Địa chỉ");

        btn_Dong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_Dong.setText("Đóng");
        btn_Dong.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DongActionPerformed(evt);
            }
        });

        btn_Luu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_Luu.setText("Lưu ");
        btn_Luu.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuActionPerformed(evt);
            }
        });

        txtArea_ghiChu.setColumns(20);
        txtArea_ghiChu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtArea_ghiChu.setRows(5);
        jScrollPane2.setViewportView(txtArea_ghiChu);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Trạng thái");

        txtDiaChi1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDiaChi1.setPreferredSize(new java.awt.Dimension(64, 35));

        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(64, 35));

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(144, 144, 144))
            .addComponent(pnlFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(311, Short.MAX_VALUE))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiaChi1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlFormLayout.createSequentialGroup()
                                    .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(38, 38, 38)
                                    .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbo_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_maNhaCungCap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTenNhaCungCap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlFormLayout.createSequentialGroup()
                                    .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlFormLayout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(277, 277, 277)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_maNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel4))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51)
                .addComponent(pnlFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pnlHeader.add(pnlForm);

        pnl_left.add(pnlHeader, java.awt.BorderLayout.CENTER);

        add(pnl_left, java.awt.BorderLayout.EAST);

        pnlCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlNorth.setBackground(new java.awt.Color(255, 255, 255));
        pnlNorth.setPreferredSize(new java.awt.Dimension(1450, 100));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel1.setText("Danh sách:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Danh sách lô hàng");

        btn_thoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_thoat.setText("Thoát");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 1390, Short.MAX_VALUE))
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btn_thoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pnlCenter.add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        add(pnlCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        // TODO add your handling code here:
    	luu();
    }//GEN-LAST:event_btn_LuuActionPerformed

    private void txtTenNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNhaCungCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNhaCungCapActionPerformed

    private void btn_DongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DongActionPerformed
        // TODO add your handling code here:
        pnl_left.setVisible(false);
        
    }//GEN-LAST:event_btn_DongActionPerformed

    private void txt_maNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maNhaCungCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maNhaCungCapActionPerformed

    private void cbo_TrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_TrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_TrangThaiActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
    	AddContent.addContent(PnlHangHoaInfo.hangHoaInfo);
    }//GEN-LAST:event_btn_thoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Dong;
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JComboBox<String> cbo_TrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnl_left;
    private javax.swing.JTextArea txtArea_ghiChu;
    private javax.swing.JTextField txtDiaChi1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenNhaCungCap;
    private javax.swing.JTextField txt_maNhaCungCap;
    // End of variables declaration//GEN-END:variables
    
   
    private entities.NhaCungCap revert_NhaCungCap() {
    	String ma = txt_maNhaCungCap.getText();
    	String ten  = txtTenNhaCungCap.getText();
    	String diaCHi = txtDiaChi1.getText();
    	String Email = txtEmail.getText();
    	String soDienThoai = txtSoDienThoai.getText();
    	String ghiChu = txtArea_ghiChu.getText();
    	TrangThaiNCC trangThai = cbo_TrangThai.getSelectedItem().toString() == "Đang hoạt động" ? TrangThaiNCC.DANG_HOAT_DONG : TrangThaiNCC.NGUNG_HOAT_DONG ;
        entities.NhaCungCap ncc2 = new entities.NhaCungCap("NCC0001", ten, soDienThoai, diaCHi, Email, ghiChu, trangThai);
        return ncc2;
    }
    private void luu() {
        entities.NhaCungCap ncc2 = revert_NhaCungCap();
    	nhaCC_dao.create(ncc2);
    }
//    private void timTheoTuKhoa_TrangThai() {
//    	NhaCungCap_DAO ds = new NhaCungCap_DAO();
//    	String tukhoa = txt_tim.getText();
//    	String trangthai = jComboBox4.getSelectedItem().toString();
//        System.out.println(trangthai);
//    	List<entities.NhaCungCap> list1 = ds.timkiem_TuKhoa_TrangThai(tukhoa,trangthai);
//    	if (list1.size() ==0 ) {
//			JOptionPane.showMessageDialog(this, "Khong tim thay");
//		}
//    	else {
//    		model_NCC.setRowCount(0);
//                int a = 0;
//    		for (entities.NhaCungCap ncc : list1) {
//                     a ++;
//				model_NCC.addRow(new Object [] {
//						a + "",
//						ncc.getMaNhaCungCap(),
//						ncc.getTenNhaCungCap(),
//						ncc.getEmail(),
//						ncc.getSoDienThoai(),
//						ncc.getGhiChu(),
//						ncc.getTrangThaiNCC().equals(ncc.getTrangThaiNCC().DANG_HOAT_DONG) ? "Đang hoạt động" : "Ngừng hoạt động",
//						
//				});
//			}
//    	}
//    }
    
    
        private void loadDataNCC() {
		// TODO Auto-generated method stub
    	int stt = 1;
		model_NCC.setNumRows(0);
		
		nhaCC_dao = new NhaCungCap_DAO();
		List<entities.NhaCungCap> dsNCC = nhaCC_dao.docTuBang();
		for (entities.NhaCungCap ncc : dsNCC) {
			model_NCC.addRow(new Object[] {stt, ncc.getMaNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getEmail(), ncc.getSoDienThoai(),
					ncc.getGhiChu(), ncc.getTrangThaiNCC().equals(TrangThaiNCC.DANG_HOAT_DONG)?"Đang hoạt động":"Ngưng hoạt động"});
			
			stt++;
		}
	}
        public static void main(String[] args) {
        	  JFrame rs = new JFrame();
        	  rs.add(new LoHangPage());
        	  rs.setVisible(true);
		}
}
