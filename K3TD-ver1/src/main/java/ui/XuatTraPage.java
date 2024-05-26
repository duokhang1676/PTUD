/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import components.AddContent;
import components.ResizeContent;
import dao.ChiTietPhieuXuatTraDao;
import dao.PhieuNhapHangDao;
import dao.PhieuXuatTraDao;
import entities.ChiTietPhieuXuatTra;
import entities.PhieuNhapHang;
import entities.PhieuXuatTra;
import entities.TrangThaiPhieuNhapHang;
import entities.TrangThaiPhieuXuatTra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.EventObject;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author LENOVO
 */
public class XuatTraPage extends javax.swing.JPanel {

	protected static DefaultTableModel model_phieuNhap;
	protected static JTable tbl_phieuNhap;
	private PhieuXuatTraDao phieuXT_dao = new PhieuXuatTraDao();
	private ChiTietPhieuXuatTraDao chiTietPXT_dao = new ChiTietPhieuXuatTraDao();
	/**
     * Creates new form XuatTra
     */
    public XuatTraPage() {
        initComponents();
        ResizeContent.resizeContent(this);
        addTablePhieuNH();
        loadDataXT();
        
    }
    private void loadDataXT() {
		// TODO Auto-generated method stub
    	int stt = 1;
		
		model_phieuNhap.setRowCount(0);
		List<PhieuXuatTra> dsPXT = phieuXT_dao.getAllDataPXT();
		for (PhieuXuatTra p : dsPXT) {
			model_phieuNhap.addRow(new Object[] {stt, p.getMaPhieuXuatTra(), p.getThoiGianTao(), p.getNhaCungCap().getTenNhaCungCap(),
					10000, p.getGhiChu(), p.getTrangThai().equals(TrangThaiPhieuXuatTra.HOAN_THANH)?"Hoàn thành":"Đã hủy"});
			
			stt++;
		}
	}
	private void addTablePhieuNH() {
		// TODO Auto-generated method stub
    	String[] colNames = {"STT","Mã phiếu xuất trả", "Ngày nhập", "Nhà cung cấp", "Tổng tiền", "Ghi chú", "Trạng thái" };
        model_phieuNhap = new DefaultTableModel(colNames, 0);
        tbl_phieuNhap = new JTable(model_phieuNhap);
        JScrollPane js_tableHangHoa = new JScrollPane(tbl_phieuNhap);
        
        if (tbl_phieuNhap.getColumnModel().getColumnCount() > 0) {
            tbl_phieuNhap.getColumnModel().getColumn(0).setResizable(false);
            tbl_phieuNhap.getColumnModel().getColumn(1).setResizable(false);
            tbl_phieuNhap.getColumnModel().getColumn(2).setResizable(false);
            tbl_phieuNhap.getColumnModel().getColumn(3).setResizable(false);
            tbl_phieuNhap.getColumnModel().getColumn(4).setResizable(false);
            tbl_phieuNhap.getColumnModel().getColumn(5).setResizable(false);
            tbl_phieuNhap.getColumnModel().getColumn(6).setResizable(false);
            
        }
        
        JTableHeader headerTable =  tbl_phieuNhap.getTableHeader();
		headerTable.setPreferredSize(new Dimension(headerTable.getPreferredSize().width, 40));
		tbl_phieuNhap.setRowHeight(40);
		TableColumnModel tb_col = tbl_phieuNhap.getColumnModel();
		tb_col.getColumn(0).setPreferredWidth(50);
		setCellEditable();
        jPanel1.add(js_tableHangHoa, BorderLayout.CENTER);
        
        tbl_phieuNhap.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) {
					AddContent.addContent(new XemPhieuXuatTraPage());
					int selectedRow = tbl_phieuNhap.getSelectedRow();
					String ma = model_phieuNhap.getValueAt(selectedRow, 1).toString();
					PhieuXuatTra pnh = phieuXT_dao.getPXTTheoMa(ma);
			    	List<ChiTietPhieuXuatTra> dsChiTiet= chiTietPXT_dao.getChiTietPXT(ma);
			    	
			    	XemPhieuXuatTraPage.txt_maPhieuNhap.setText(pnh.getMaPhieuXuatTra());
			    	XemPhieuXuatTraPage.dTP_phieuNhap.setDateTimePermissive(pnh.getThoiGianTao());
			    	XemPhieuXuatTraPage.txt_maHoaDon.setText(pnh.getMaHoaDonNCC());
			    	XemPhieuXuatTraPage.cb_NCC.setSelectedItem(pnh.getNhaCungCap().getTenNhaCungCap());
			    	XemPhieuXuatTraPage.txt_ghiChu.setText(pnh.getGhiChu());
			    	XemPhieuXuatTraPage.model_HH.setRowCount(0);
			    	int stt = 1;
			    	
			    	for (ChiTietPhieuXuatTra ct : dsChiTiet) {
			    		double giaChietKhau = (((ct.getChietKhau()*ct.getLoHang().getGiaNhap())/100)*ct.getSoLuong());
			            double giaBan = (ct.getSoLuong()*ct.getLoHang().getGiaNhap())-giaChietKhau;
			            
			            
			            XemPhieuXuatTraPage.model_HH.addRow(new Object[] {stt, ct.getDonViTinh().getHangHoa().getMaHangHoa(),ct.getDonViTinh().getHangHoa().getTenHangHoa() ,ct.getLoHang().getSoLo(), ct.getLoHang().getNgaySanXuat(),
								ct.getLoHang().getHanSuDung(), ct.getDonViTinh().getTenDonViTinh(), ct.getSoLuong(), ct.getLoHang().getGiaNhap(),ct.getLoHang().getHangHoa().getThue(), ct.getChietKhau(), giaBan});
					}
			    	
			    	double tongGiamGia = 0;
			        double tongTienHang = 0;
			        double tongThanhTien = 0;
			        double tienNhap = 0;
			        double soLuong = 0;
			        for (int i = 0; i < XemPhieuXuatTraPage.model_HH.getRowCount(); i++) {
			            tienNhap = Double.parseDouble(XemPhieuXuatTraPage.model_HH.getValueAt(i, 8).toString());
			            soLuong = Double.parseDouble(XemPhieuXuatTraPage.model_HH.getValueAt(i, 7).toString());
			            
			            tongTienHang += tienNhap*soLuong;
			            tongThanhTien += Double.parseDouble(XemPhieuXuatTraPage.model_HH.getValueAt(i, 11).toString());
			            tongGiamGia =  tongTienHang - tongThanhTien;
			            
			        }
			        XemPhieuXuatTraPage.txt_tongTienNhap.setText(Double.toString(tongTienHang));
			        XemPhieuXuatTraPage.txt_tongThanhTien.setText(Double.toString(tongThanhTien));
			        XemPhieuXuatTraPage.txt_chietKhau.setText(Double.toString(tongGiamGia));
				}
			}
		});
	}
    public void setCellEditable() {
		for (int i = 0; i < tbl_phieuNhap.getColumnCount(); i++) {
			tbl_phieuNhap.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()) {
					@Override
					public boolean isCellEditable(EventObject e) {
						// Trả về false để ngăn chặn chỉnh sửa trực tiếp
						return false;
					}
				});
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

        jPanel2 = new javax.swing.JPanel();
        txt_timKiemTheoNCC = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dp_dateFrom = new com.github.lgooddatepicker.components.DatePicker();
        dp_dateTo = new com.github.lgooddatepicker.components.DatePicker();
        txt_timKiemTheoMa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(2013, 130));

        txt_timKiemTheoNCC.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_timKiemTheoNCC.setText("Tìm kiếm theo nhà cung cấp");
        txt_timKiemTheoNCC.setForeground(new java.awt.Color(204, 204, 204));
        txt_timKiemTheoNCC.setPreferredSize(new java.awt.Dimension(200, 26));
        txt_timKiemTheoNCC.setToolTipText("");
        txt_timKiemTheoNCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_timKiemTheoNCCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_timKiemTheoNCCFocusLost(evt);
            }
        });
        txt_timKiemTheoNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemTheoNCCActionPerformed(evt);
            }
        });

        btn_timKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-16.png"))); // NOI18N
        btn_timKiem.setText("Tìm kiếm");
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        jLabel1.setText("Từ ngày");
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel2.setText("Đến ngày");
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel3.setText("Tìm kiếm theo mã phiếu");
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel6.setText("Tìm kiếm theo nhà cung cấp");
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        dp_dateFrom.setMinimumSize(new java.awt.Dimension(200, 21));

        dp_dateTo.setMinimumSize(new java.awt.Dimension(200, 21));

        txt_timKiemTheoMa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_timKiemTheoMa.setText("Tìm kiếm theo mã phiếu");
        txt_timKiemTheoMa.setForeground(new java.awt.Color(204, 204, 204));
        txt_timKiemTheoMa.setPreferredSize(new java.awt.Dimension(200, 26));
        txt_timKiemTheoMa.setToolTipText("");
        txt_timKiemTheoMa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_timKiemTheoMaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_timKiemTheoMaFocusLost(evt);
            }
        });
        txt_timKiemTheoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemTheoMaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-16.png"))); // NOI18N
        jButton2.setText("Tạo phiếu xuất trả");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Xuất trả nhà cung cấp");
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(409, 409, 409))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dp_dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dp_dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_timKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_timKiemTheoNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timKiem)))
                .addGap(409, 409, 409))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dp_dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dp_dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_timKiemTheoMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_timKiemTheoNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_timKiem))
                .addGap(1325, 1325, 1325))
        );

        LocalDate currentDate = LocalDate.now();
        dp_dateFrom.setDate(currentDate);
        dp_dateTo.setDate(currentDate);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel1.setBackground(new java.awt.Color(193, 219, 208));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(193, 219, 208));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setText("Danh sách phiếu xuất trả");
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel4.add(jLabel5);

        jPanel1.add(jPanel4, java.awt.BorderLayout.NORTH);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        // TODO add your handling code here:
    	String ma = txt_timKiemTheoNCC.getText();
    	LocalDate dateFrom = dp_dateFrom.getDate();
    	LocalDate dateTo = dp_dateTo.getDate();
    	
    	System.out.println(dateFrom);
    	if (dateFrom == null && dateTo == null) {
        	dateFrom = LocalDate.now();
        	dateTo = LocalDate.now();
		}else if(dateTo == null){
			dateTo = dateFrom;
		}
    	else {
    		dateFrom = dateTo;
    	}
    	
    	if (ma.isEmpty()) {
    		loadDataXT();
			showMessage("Nhập thông tin cần tìm!");
		}else {
			List<PhieuXuatTra> dsPXT = phieuXT_dao.getPXTTheoTenNCCVaTheoNgay(ma, dateFrom, dateTo);
			int stt = 1;
			model_phieuNhap.setRowCount(0);
			for (PhieuXuatTra p : dsPXT) {
				
	    		model_phieuNhap.addRow(new Object[] {stt, p.getMaPhieuXuatTra(), p.getThoiGianTao(), p.getNhaCungCap().getTenNhaCungCap(),
	    				10000, p.getGhiChu(), p.getTrangThai().equals(TrangThaiPhieuXuatTra.HOAN_THANH)?"Hoàn thành":"Đã hủy"});
	    		
	    		stt++;
			}
		}
    	
    	
    	
    	txt_timKiemTheoNCC.selectAll();
    	txt_timKiemTheoNCC.requestFocus();
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void txt_timKiemTheoNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemTheoNCCActionPerformed
        // TODO add your handling code here:
    	String ma = txt_timKiemTheoNCC.getText();
    	LocalDate dateFrom = dp_dateFrom.getDate();
    	LocalDate dateTo = dp_dateTo.getDate();
    	
    	System.out.println(dateFrom);
    	if (dateFrom == null && dateTo == null) {
        	dateFrom = LocalDate.now();
        	dateTo = LocalDate.now();
		}else if(dateTo == null){
			dateTo = dateFrom;
		}
    	else {
    		dateFrom = dateTo;
    	}
    	
    	if (ma.isEmpty()) {
    		loadDataXT();
			showMessage("Nhập thông tin cần tìm!");
		}else {
			List<PhieuXuatTra> dsPXT = phieuXT_dao.getPXTTheoTenNCCVaTheoNgay(ma, dateFrom, dateTo);
			int stt = 1;
			model_phieuNhap.setRowCount(0);
			for (PhieuXuatTra p : dsPXT) {
				
	    		model_phieuNhap.addRow(new Object[] {stt, p.getMaPhieuXuatTra(), p.getThoiGianTao(), p.getNhaCungCap().getTenNhaCungCap(),
	    				10000, p.getGhiChu(), p.getTrangThai().equals(TrangThaiPhieuXuatTra.HOAN_THANH)?"Hoàn thành":"Đã hủy"});
	    		
	    		stt++;
			}
		}
    	
    	
    	
    	txt_timKiemTheoNCC.selectAll();
    	txt_timKiemTheoNCC.requestFocus();
    }//GEN-LAST:event_txt_timKiemTheoNCCActionPerformed

    
	private void txt_timKiemTheoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemTheoMaActionPerformed
        // TODO add your handling code here:
		if (txt_timKiemTheoMa.getText().isEmpty()) {
			showMessage("Nhập thông tin cần tìm!");
		}else {
			PhieuXuatTra p = phieuXT_dao.getPXTTheoMa(txt_timKiemTheoMa.getText());
			
	    	if (p != null) {
	    		model_phieuNhap.setRowCount(0);
	    		model_phieuNhap.addRow(new Object[] {1, p.getMaPhieuXuatTra(), p.getThoiGianTao(), p.getNhaCungCap().getTenNhaCungCap(),
	    				10000, p.getGhiChu(), p.getTrangThai().equals(TrangThaiPhieuXuatTra.HOAN_THANH)?"Hoàn thành":"Đã hủy"});
			}else {
				showMessage("Không tìm thấy!");
			}
		}
    	
    	
    	
    	txt_timKiemTheoMa.selectAll();
    	txt_timKiemTheoMa.requestFocus();
    	
    }//GEN-LAST:event_txt_timKiemTheoMaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AddContent.addContent(new TaoPhieuXuatTraPage());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_timKiemTheoMaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timKiemTheoMaFocusGained
        // TODO add your handling code here:
    	txt_timKiemTheoMa.setText("");
    	txt_timKiemTheoMa.setForeground(Color.black);
    }//GEN-LAST:event_txt_timKiemTheoMaFocusGained

    private void txt_timKiemTheoNCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timKiemTheoNCCFocusGained
        // TODO add your handling code here:
    	txt_timKiemTheoNCC.setText("");
    	txt_timKiemTheoNCC.setForeground(Color.black);
    }//GEN-LAST:event_txt_timKiemTheoNCCFocusGained

    private void txt_timKiemTheoMaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timKiemTheoMaFocusLost
        // TODO add your handling code here:
    	txt_timKiemTheoMa.setText("Tìm kiếm theo mã phiếu");
    	txt_timKiemTheoMa.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_txt_timKiemTheoMaFocusLost

    private void txt_timKiemTheoNCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timKiemTheoNCCFocusLost
        // TODO add your handling code here:
    	txt_timKiemTheoNCC.setText("Tìm kiếm theo nhà cung cấp");
    	txt_timKiemTheoNCC.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_txt_timKiemTheoNCCFocusLost
    private void showMessage(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string);
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
            java.util.logging.Logger.getLogger(XuatTraPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XuatTraPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XuatTraPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XuatTraPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XuatTraPage().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_timKiem;
    private com.github.lgooddatepicker.components.DatePicker dp_dateFrom;
    private com.github.lgooddatepicker.components.DatePicker dp_dateTo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txt_timKiemTheoMa;
    private javax.swing.JTextField txt_timKiemTheoNCC;
    // End of variables declaration//GEN-END:variables
}
