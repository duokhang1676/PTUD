/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import components.*;
import dao.DonThuocMauDao;
import dao.DonViTinhDao;
import dao.NhaCungCap_DAO;
import entities.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class DonThuocMauPage extends javax.swing.JPanel implements MouseListener{

    private DefaultTableModel table_model2;
    private JScrollPane pnl_Scroll;
    private JTable jtable_DonThuocMau;
    private DonThuocMauDao dvt_DAO ;
    private DonViTinhDao donViTinh_dao = new DonViTinhDao();
	
	/**
     * Creates new form DonThuocMau_httk
     */
    public DonThuocMauPage() {
        initComponents();
        try {
            db.ConnectDB.getInstance().connect();
        } catch (SQLException ex) {
            Logger.getLogger(DonThuocMauPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResizeContent.resizeContent(this);
      
        jPanel1.add(jscp_donThuocMau(),BorderLayout.CENTER);
        loadDATA_DonThuocMau(table_model2);
        jtable_DonThuocMau.addMouseListener(this);
        
    }





	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCenter = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        btn_Tim = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_tim = new javax.swing.JTextField();
        btn_Them = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1920, 840));
        setLayout(new java.awt.BorderLayout());

        pnlCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlNorth.setBackground(new java.awt.Color(255, 255, 255));
        pnlNorth.setPreferredSize(new java.awt.Dimension(1450, 100));

        btn_Tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-16.png"))); // NOI18N
        btn_Tim.setText("Tìm");
        btn_Tim.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimActionPerformed(evt);
            }
        });

        jLabel3.setText("Tìm kiếm theo mã");
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txt_tim.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btn_Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image 15.png"))); // NOI18N
        btn_Them.setText("Thêm đơn thuốc mẫu");
        btn_Them.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNorthLayout.createSequentialGroup()
                        .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(807, Short.MAX_VALUE))
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tim, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pnlCenter.add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách dữ liệu"));
        jPanel1.setLayout(new java.awt.BorderLayout());
        pnlCenter.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(pnlCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimActionPerformed
        // TODO add your handling code here:
    	
        
    }//GEN-LAST:event_btn_TimActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        AddContent.addContent(new TaoDonThuocMauPage());
    }//GEN-LAST:event_btn_ThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Tim;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JTextField txt_tim;
    // End of variables declaration//GEN-END:variables
    
   
    private JScrollPane jscp_donThuocMau(){
        String[] colNames = {"Ma Don Thuoc ","Tên đơn thuốc","Ngày bắt đầu áp dụng"," Trạng thái"};
     
        table_model2 = new DefaultTableModel(colNames, 0);
        pnl_Scroll = new JScrollPane(jtable_DonThuocMau =new JTable(table_model2));
        setCellEditable();
        FormatJtable.setFontJtable(jtable_DonThuocMau);
        jtable_DonThuocMau.setRowHeight(35);
        return pnl_Scroll;
    }
    public void setCellEditable() {
		for (int i = 0; i < jtable_DonThuocMau.getColumnCount(); i++) {
			jtable_DonThuocMau.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()) {
					@Override
					public boolean isCellEditable(EventObject e) {
						// Trả về false để ngăn chặn chỉnh sửa trực tiếp
						return false;
					}
				});
			}
	}
  private void loadDATA_DonThuocMau( DefaultTableModel model) {
	  model.setRowCount(0);
	  DonThuocMauDao donthuoc_DAO = new DonThuocMauDao();
	  List<DonThuocMau> list = donthuoc_DAO.getDonThuocMau();
	  for (DonThuocMau donThuocMau : list) {
		String [] rowdata = {
			donThuocMau.getMaDonThuocMau(),
			donThuocMau.getTenDonThuocMau(),
			donThuocMau.getNgayBatDauApDung().toString(),
			donThuocMau.getTrangThaiDonThuocMau().toString()
		};
		model.addRow(rowdata);
	}
  }
  

  
private void getDoiTuong() {
    int r = jtable_DonThuocMau.getSelectedRow();
    String ma = jtable_DonThuocMau.getValueAt(r, 0).toString();
    DonThuocMauDao DonThuoc_DAO = new DonThuocMauDao();
   DonThuocMau donthuocMau = DonThuoc_DAO.getDonThuocMau_theoMa(ma);
//    System.out.println(ma);
//    System.out.println(donthuocMau);
    String maDonThuocmau = donthuocMau.getMaDonThuocMau();
    String tenDonThuocMau = donthuocMau.getTenDonThuocMau();
    LocalDate ngayapdung = donthuocMau.getNgayBatDauApDung();
    String ghiChu = donthuocMau.getGhiChu();
    TrangThaiDonThuocMau tt1 = donthuocMau.getTrangThaiDonThuocMau();
    
    String ngayDateString = (String) jtable_DonThuocMau.getValueAt(r, 2);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
    LocalDate ngayDate = LocalDate.parse(ngayDateString, formatter);
    
    
    AddContent.addContent(new ChiTietDonThuocMauPage());
    ChiTietDonThuocMauPage.txt_Ma.setText(maDonThuocmau);
    ChiTietDonThuocMauPage.txt_Ten.setText(tenDonThuocMau);
    ChiTietDonThuocMauPage.txt_ghiChu.setText(ghiChu);
    ChiTietDonThuocMauPage.date_ngayApdung.setDate(ngayapdung);
    ChiTietDonThuocMauPage.cbo_trangThai.setSelectedItem(tt1.equals(TrangThaiDonThuocMau.DANG_BAN ) ? "Đang bán" : "Ngừng bán" );
    
    List<ChiTietDonThuocMau> dsChiTietDonThuocMau = DonThuoc_DAO.getChiTietDonThuocMau(maDonThuocmau);
    ChiTietDonThuocMauPage.table_model2.setRowCount(0);
    int stt = 1;
    for (ChiTietDonThuocMau ct : dsChiTietDonThuocMau) {
//    	//"STT","Mã hàng hoá ","Tên hàng hoá","Liều dùng","Số lượng" , "Đơn vị tính","Huỷ"
    	List<DonViTinh> dsDVT = donViTinh_dao.timDVTTheoMaHH(ct.getDonViTinh().getHangHoa().getMaHangHoa());
//    	System.out.println(ct);
//    	dsDVT.forEach(d->cb_dvt.addItem(d.getTenDonViTinh()));
//    	((TableColumnModel) ChiTietDonThuocMauPage.table_Jtable.getColorModel()).getColumn(5).setCellEditor(new DefaultCellEditor(cb_dvt));
    	ChiTietDonThuocMauPage.table_model2.addRow(new Object[] {stt, ct.getDonViTinh().getHangHoa().getMaHangHoa(), ct.getDonViTinh().getHangHoa().getTenHangHoa(),
    			ct.getLieuDung(), ct.getSoLuong(),ct.getDonViTinh().getTenDonViTinh()});
	}
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if (e.getClickCount() ==1 ) {
//	    int r = jtable_DonThuocMau.getSelectedRow();
//	    String ma = jtable_DonThuocMau.getValueAt(r, 0).toString();
//	    System.out.println("dong thu "+ r +"ma la "+ ma);
	}
	if (e.getClickCount() == 2) { // Kiểm tra nếu là nhấp đúp chuột
		getDoiTuong();
		
        }
}






@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}
