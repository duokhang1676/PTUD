/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
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
public class TaoDonThuocMauPage extends javax.swing.JPanel implements MouseListener{

    private DefaultTableModel table_model2;
    private JScrollPane pnl_Scroll;
    private JTable jtable_DonThuocMau;
    private DonThuocMauDao dtm_DAO;
    
	
	/**
     * Creates new form DonThuocMau_httk
     */
    public TaoDonThuocMauPage() {
        initComponents();
        try {
            db.ConnectDB.getInstance().connect();
        } catch (SQLException ex) {
            Logger.getLogger(TaoDonThuocMauPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResizeContent.resizeContent(this);
        jPanel1.add(jscp_donThuocMau(),BorderLayout.CENTER);
        setTable();
        
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
        cbo_TrangThai = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btn_Tim = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_tim = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        pnl_left = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlForm = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_Ten = new javax.swing.JTextField();
        pnlFooter = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_Ma = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_Dong = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ghiChu = new javax.swing.JTextArea();
        date_ngayApdung = new com.github.lgooddatepicker.components.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        cbo_trangThai = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1920, 840));
        setLayout(new java.awt.BorderLayout());

        pnlCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlNorth.setBackground(new java.awt.Color(255, 255, 255));
        pnlNorth.setPreferredSize(new java.awt.Dimension(1450, 100));

        cbo_TrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang bán", "Tạm dừng" }));
        cbo_TrangThai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbo_TrangThai.setPreferredSize(new java.awt.Dimension(163, 35));

        jLabel5.setText("Trạng thái");
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btn_Tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-16.png"))); // NOI18N
        btn_Tim.setText("Tìm");
        btn_Tim.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimActionPerformed(evt);
            }
        });

        jLabel3.setText("Tìm kiếm theo từ khóa (F4)");
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txt_tim.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNorthLayout.createSequentialGroup()
                        .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(683, Short.MAX_VALUE))
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tim, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pnlCenter.add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách dữ liệu"));
        jPanel1.setLayout(new java.awt.BorderLayout());
        pnlCenter.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnl_left.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlHeader.setPreferredSize(new java.awt.Dimension(470, 840));

        pnlForm.setBackground(new java.awt.Color(255, 255, 255));
        pnlForm.setPreferredSize(new java.awt.Dimension(470, 840));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        txt_Ten.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_Ten.setPreferredSize(new java.awt.Dimension(64, 35));
        txt_Ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TenActionPerformed(evt);
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

        jLabel9.setText("Mã Đơn thuốc mẫu");
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setText("Thông tin đơn thuốc mẫu");
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        jLabel10.setText("Tên đơn thuốc mẫu ");
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txt_Ma.setEditable(false);
        txt_Ma.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_Ma.setPreferredSize(new java.awt.Dimension(64, 35));
        txt_Ma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaActionPerformed(evt);
            }
        });

        jLabel14.setText("Ghi chú");
        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel16.setText("Ngày bắt đầu áp dụng");
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btn_Dong.setText("Đóng");
        btn_Dong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_Dong.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DongActionPerformed(evt);
            }
        });

        btn_Luu.setText("Lưu ");
        btn_Luu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_Luu.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuActionPerformed(evt);
            }
        });

        txt_ghiChu.setColumns(20);
        txt_ghiChu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_ghiChu.setRows(5);
        jScrollPane2.setViewportView(txt_ghiChu);

        date_ngayApdung.setPreferredSize(new java.awt.Dimension(143, 35));

        jLabel1.setText("Trạng thái");
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        cbo_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang bán", "Ngừng bán" }));

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(144, 144, 144))
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlFormLayout.createSequentialGroup()
                                    .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlFormLayout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(277, 277, 277)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlFormLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1))
                            .addGroup(pnlFormLayout.createSequentialGroup()
                                .addComponent(date_ngayApdung, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(cbo_trangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGap(462, 462, 462)
                        .addComponent(jLabel4))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date_ngayApdung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51)
                .addComponent(pnlFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnlHeader.add(pnlForm);

        pnl_left.add(pnlHeader, java.awt.BorderLayout.CENTER);

        add(pnl_left, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_btn_TimActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txt_TenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TenActionPerformed

    private void txt_MaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaActionPerformed

    private void btn_DongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DongActionPerformed
        // TODO add your handling code here:
        pnl_left.setVisible(false);

    }//GEN-LAST:event_btn_DongActionPerformed

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        // TODO add your handling code here:
    	luu();
    }//GEN-LAST:event_btn_LuuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Dong;
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_Tim;
    private javax.swing.JComboBox<String> cbo_TrangThai;
    protected static javax.swing.JComboBox<String> cbo_trangThai;
    protected static com.github.lgooddatepicker.components.DatePicker date_ngayApdung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnl_left;
    public static javax.swing.JTextField txt_Ma;
    protected static javax.swing.JTextField txt_Ten;
    protected static javax.swing.JTextArea txt_ghiChu;
    private javax.swing.JTextField txt_tim;
    // End of variables declaration//GEN-END:variables
	private JComboBox cb_dvt;
	private DonViTinhDao dvt_DAO;
    
   
    private JScrollPane jscp_donThuocMau(){
        String[] colNames = {"STT ","Mã hàng hoá","Tên hàng hoá ","Đơn vị tính","Số Lượng", "Liều Dùng","Xoá"};
     
        table_model2 = new DefaultTableModel(colNames, 0);
        pnl_Scroll = new JScrollPane(jtable_DonThuocMau =new JTable(table_model2));
        
        if (jtable_DonThuocMau.getColumnModel().getColumnCount() > 0) {
        	jtable_DonThuocMau.getColumnModel().getColumn(0).setResizable(false);
        	jtable_DonThuocMau.getColumnModel().getColumn(1).setResizable(false);
        	jtable_DonThuocMau.getColumnModel().getColumn(2).setResizable(false);
        	jtable_DonThuocMau.getColumnModel().getColumn(3).setResizable(false);
        	jtable_DonThuocMau.getColumnModel().getColumn(4).setResizable(false);
        	jtable_DonThuocMau.getColumnModel().getColumn(5).setResizable(false);
        	jtable_DonThuocMau.getColumnModel().getColumn(6).setResizable(false);
        }
        
        JTableHeader headerTable =  jtable_DonThuocMau.getTableHeader();
		headerTable.setPreferredSize(new Dimension(headerTable.getPreferredSize().width, 40));
		jtable_DonThuocMau.setRowHeight(40);
		TableColumnModel tb_col = jtable_DonThuocMau.getColumnModel();
        
        jtable_DonThuocMau.addMouseListener(this);
//        setCellEditable();
        

        
        
        
        
        
        
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
    
    
    private static int  n = 0;
    
    private  void loadData () {
    	dvt_DAO =new DonViTinhDao();
    	String ma = txt_tim.getText();
    	DonViTinh   hanghoa  =  dvt_DAO.layDVTTheoMa(ma);
    
    	Set<String> GiaTriKhacNhau  = new HashSet<>(); 
    	List<DonViTinh> listDOnViTInh = dvt_DAO.timDVTTheoMaHH(ma);
    	for (DonViTinh donViTinh : listDOnViTInh) {
			GiaTriKhacNhau.add(donViTinh.getTenDonViTinh());
		}
    	DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(GiaTriKhacNhau.toArray(new String [0]));
    	cb_dvt = new JComboBox<>(model);
        jtable_DonThuocMau.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(cb_dvt));
    	if (hanghoa != null ) {
        	n++;
        	table_model2.addRow(new Object [] {
        			n,
        			hanghoa.getHangHoa().getMaHangHoa(),
        			hanghoa.getHangHoa().getTenHangHoa(),
        			hanghoa.getTenDonViTinh(),
        			1
        	});
		}
    	
    	else {
    		JOptionPane.showMessageDialog(null, "Không có giá trị");
    	}
    }
    private DonThuocMau revert_DonThuocMau() {
    	String tenDonThuoc= txt_Ten.getText().trim().equals("") ? "Chưa xác định": txt_Ten.getText();
    	LocalDate ngayBatDauApDung = LocalDate.now();
    	String ghiChu = txt_ghiChu.getText();
    	TrangThaiDonThuocMau tt = cbo_trangThai.getSelectedItem().toString().equals("Đang bán") ? TrangThaiDonThuocMau.DANG_BAN: TrangThaiDonThuocMau.TAM_DUNG;
    	DonThuocMau dtm1 = new DonThuocMau(tenDonThuoc, tenDonThuoc, ngayBatDauApDung, ghiChu, tt);
//    	System.out.println(dtm1);
    	return dtm1;
    }
    private void luu() {
    	dtm_DAO = new DonThuocMauDao();
    	dvt_DAO = new DonViTinhDao();
    	DonThuocMau dtm4 = revert_DonThuocMau();
    	
    	
//    	String ma =	dtm_DAO.getmaDonThuocMauGanDayNhat();
//    	System.out.println(ma);
    	 	
    	if (dtm_DAO.CreateDonThuocMau(dtm4)) {
        	DonThuocMau dtmGanDay = dtm_DAO.getDonThuocMauGanDayNhat();
//        	System.out.println(dtmGanDay);     	
        	int r = jtable_DonThuocMau.getRowCount();
//        	System.out.println(r);     		
        	List<ChiTietDonThuocMau> listChiTietDonThuocMau = new ArrayList<ChiTietDonThuocMau>();
        	for(int i =0;i<r ; i++) {
        		String maHanghoa1 = jtable_DonThuocMau.getValueAt(i, 1).toString();
//        		System.out.println(maHanghoa1);
        		String tenHangHoa1 = jtable_DonThuocMau.getValueAt(i, 2).toString();
//        		System.out.println(tenHangHoa1);
        		String tenDonViTinh = jtable_DonThuocMau.getValueAt(i, 3).toString();
        		DonViTinh dvt = dvt_DAO.layDVTTheoTenVaMaHangHoa(maHanghoa1, tenDonViTinh);
//        		System.out.println(dvt);
        		int soLuong = Integer.parseInt(jtable_DonThuocMau.getValueAt(i, 4).toString());
//        		System.out.println(soLuong);
        		String lieuDung = jtable_DonThuocMau.getValueAt(i, 5) == null ? "Chưa xác định" : jtable_DonThuocMau.getValueAt(i, 5).toString()  ;
//        		System.out.println(lieuDung);
//        		System.out.println(new ChiTietDonThuocMau(dtmGanDay, lieuDung, soLuong, dvt));
        		listChiTietDonThuocMau.add(new ChiTietDonThuocMau(dtmGanDay, lieuDung, soLuong, dvt));
        	}
        	for (ChiTietDonThuocMau chiTietDonThuocMau : listChiTietDonThuocMau) {
    			dtm_DAO.createChiTietDonThuocMau(chiTietDonThuocMau);
    		}
    		JOptionPane.showMessageDialog(null, "Thêm thành công");			
    		refresh();
		}
    	else {
    		JOptionPane.showMessageDialog(null, "Thêm thất bại");			    		
    	}
    }
    
    
    
    
    
  public static void main(String[] args) {
	  JFrame rs = new JFrame();
	  rs.add(new TaoDonThuocMauPage());
	  rs.setVisible(true);
}


@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if (e.getClickCount() == 2) { // Kiểm tra nếu là nhấp đúp chuột
//		AddContent.addContent(new ChiTietDonThuocMauPage());
		
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
private void setTable() {
	TableColumn column = jtable_DonThuocMau.getColumnModel().getColumn(4);
    column.setCellEditor(new SpinnerEditor());
    TableActionEvent event = new TableActionEvent() {
		@Override
		public void onDelete(int row) {
			if(jtable_DonThuocMau.isEditing()) {
				jtable_DonThuocMau.getCellEditor().stopCellEditing();
			}
			DefaultTableModel model = (DefaultTableModel)jtable_DonThuocMau.getModel();
			model.removeRow(row);
			reload();
		}	
	};
	jtable_DonThuocMau.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
	jtable_DonThuocMau.getColumnModel().getColumn(6).setCellRenderer(new ButtonRender());
    
	table_model2.addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {//Bắt sự kiện thay đổi số lượng trên jtable
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 6) {
            	int row = jtable_DonThuocMau.getSelectedRow();
            	if(row==-1)return; //Trường hợp sl thay đổi khi thêm mới 
               reload();
            }
        }	
    });
}

private void reload() {
	// TODO Auto-generated method stub
	
}

private void refresh() {
	txt_ghiChu.setText("");
	txt_Ten.setText("");
	date_ngayApdung.setDate(LocalDate.now());
	cbo_trangThai.setSelectedItem("Đang bán");
	table_model2.setRowCount(0);
	table_model2.fireTableDataChanged();
//	AddContent.addContent(new TaoDonThuocMauPage());
}


}
