/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.util.EventObject;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import components.AddContent;
import components.StatusMenu;
import dao.DonViTinhDao;
import dao.HangHoaDao;
import dao.NhomHangDao;
import entities.DonViTinh;
import entities.LoaiHang;
import entities.NhomHang;
import entities.TrangThaiHangHoa;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author LENOVO
 */
public class HangHoa extends javax.swing.JPanel implements MouseListener{

    private NhomHangDao nhomHang_dao;
    private HangHoaDao hangHoa_dao;
    private DefaultTableModel model_hangHoa;
    private JTable tbl_hangHoa;
	/**
     * Creates new form HangHoa
     */
    public HangHoa() {
        initComponents();
        addTableHangHoa();
        loatDataTrangThai();
        loadDataLoaiHang();
        loadDataNhomHang();
        loadDataTable();
    }

    private void loadDataTable() {
		// TODO Auto-generated method stub
    	int count = 0;
    	int stt = 1;
    	String loaiHang = null;
    	model_hangHoa.setNumRows(0);
		hangHoa_dao = new HangHoaDao();
		List<entities.HangHoa> dsHangHoa = hangHoa_dao.getAllDataHangHoa();
		for (entities.HangHoa hh : dsHangHoa) {
			if (hh.getLoaiHang().equals(LoaiHang.DUOC_PHAM)) {
				loaiHang = "Dược phẩm";
			}else if (hh.getLoaiHang().equals(LoaiHang.VAT_TU_YTE)) {
				loaiHang = "Vật tư y tế";
			}else {
				loaiHang = "Khác";
			}
			model_hangHoa.addRow(new Object[] {stt, hh.getMaHangHoa(), hh.getTenHangHoa(),
					loaiHang, hh.getQuyCachDongGoi()});
			
//			if (hh.getTrangThaiHangHoa().equals("NGUNG_BAN")) {
//				model_hangHoa.removeRow(count);
//			}
			
			stt++;
			count++;
		}
		jL_soLuongHH.setText("("+String.valueOf(count)+")");
		
	}

	private void loadDataLoaiHang() {
		// TODO Auto-generated method stub
		String loaiHang = null;
		for(LoaiHang lh : LoaiHang.values()) {
			if (lh.equals(LoaiHang.DUOC_PHAM)) {
				loaiHang = "Dược phẩm";
			}else if (lh.equals(LoaiHang.VAT_TU_YTE)) {
				loaiHang = "Vật tư y tế";
			}else {
				loaiHang = "Khác";
			}
			cb_loaiHang.addItem(loaiHang);
		}
	}

	private void loatDataTrangThai() {
		// TODO Auto-generated method stub
		for(TrangThaiHangHoa tt : TrangThaiHangHoa.values()) {
			cb_trangThai.addItem(tt.equals(TrangThaiHangHoa.DANG_BAN)?"Đang bán":"Ngừng bán");
		}
	}

	private void loadDataNhomHang() {
		// TODO Auto-generated method stub
    	nhomHang_dao = new NhomHangDao();
    	
    	List<NhomHang> dsNhomHang = nhomHang_dao.getAllDataNhomHang();
    	dsNhomHang.forEach(nh -> cb_nhomHang.addItem(nh.getTenNhomHang()));
		
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
        cb_trangThai = new javax.swing.JComboBox<>();
        cb_loaiHang = new javax.swing.JComboBox<>();
        cb_nhomHang = new javax.swing.JComboBox<>();
        txt_timKiem = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_themHH = new javax.swing.JButton();
        jL_soLuongHH = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 70));

        cb_trangThai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_trangThaiActionPerformed(evt);
            }
        });

        cb_loaiHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        cb_nhomHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_nhomHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nhomHangActionPerformed(evt);
            }
        });

        txt_timKiem.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_timKiem.setToolTipText("Tìm kiếm theo mã, tên hàng hóa, hoạt chất");
        txt_timKiem.setPreferredSize(new java.awt.Dimension(200, 26));
        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });

        btn_timKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-16.png"))); // NOI18N
        btn_timKiem.setText("Tìm kiếm");
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("Trạng Thái");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Loại hàng hóa");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Nhóm Hàng");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Từ khóa tìm kiếm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_loaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(125, 125, 125)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cb_nhomHang, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(477, 477, 477))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_loaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_nhomHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(193, 219, 208));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(193, 219, 208));
        jPanel3.setPreferredSize(new java.awt.Dimension(1991, 50));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel5.setText("Danh sách hàng hóa");

        btn_themHH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-16.png"))); // NOI18N
        btn_themHH.setText("Thêm hàng hóa mới");
        btn_themHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themHHActionPerformed(evt);
            }
        });

        jL_soLuongHH.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jL_soLuongHH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1225, Short.MAX_VALUE)
                .addComponent(btn_themHH)
                .addGap(480, 480, 480))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btn_themHH)
                    .addComponent(jL_soLuongHH))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        // TODO add your handling code here:
    	String maTen = txt_timKiem.getText().trim();
    	String trangThaiHH = cb_trangThai.getSelectedItem().toString().trim();
    	String loaiHang = cb_loaiHang.getSelectedItem().toString().trim();
    	String nhomHang = cb_nhomHang.getSelectedItem().toString().trim();
    	System.out.println(maTen + " " + trangThaiHH + " " + loaiHang + " " + nhomHang);
    	if (maTen.isEmpty()) {
			showMessage("Nhập thông tin cần tìm!");
			loadDataTable();
		}else {
//			List<entities.HangHoa> dsHangHoas = hangHoa_dao.timHangHoa(maTen, loaiHang, nhomHang, trangThaiHH);
//			for (entities.HangHoa hh : dsHangHoas) {
//				model_hangHoa.setNumRows(0);
//				model_hangHoa.addRow(new Object[] {hh.getMaHangHoa(), hh.getTenHangHoa()});
//			}
//			if (dsHangHoas.isEmpty()) {
//				showMessage("K thay");
//			}
			entities.HangHoa hh = hangHoa_dao.timHangHoa(maTen, loaiHang, nhomHang, trangThaiHH);
			if (hh == null) {
				showMessage("Khong tim thay");
				txt_timKiem.requestFocus();
		    	txt_timKiem.selectAll();
		    	loadDataTable();
				return;
			}
			model_hangHoa.setNumRows(0);
			model_hangHoa.addRow(new Object[] {hh.getMaHangHoa(), hh.getTenHangHoa(), hh.getLoaiHang(), hh.getNuocSanXuat(),
					hh.getHoatChatChinh(), hh.getQuyCachDongGoi()});
		}
    	txt_timKiem.requestFocus();
    	txt_timKiem.selectAll();
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timKiemActionPerformed


	private void cb_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_trangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_trangThaiActionPerformed

    private void cb_nhomHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nhomHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_nhomHangActionPerformed

    private void btn_themHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themHHActionPerformed
        // TODO add your handling code here:
    	AddContent.addContent(new TaoHangHoa());
    }//GEN-LAST:event_btn_themHHActionPerformed

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
            java.util.logging.Logger.getLogger(HangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HangHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HangHoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_themHH;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JComboBox<String> cb_loaiHang;
    private javax.swing.JComboBox<String> cb_nhomHang;
    private javax.swing.JComboBox<String> cb_trangThai;
    private javax.swing.JLabel jL_soLuongHH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_timKiem;
	private DonViTinhDao donViTinh_dao;
    // End of variables declaration//GEN-END:variables

    private void addTableHangHoa() {
        String[] colNames = {"STT","Mã hàng hóa", "Tên hàng hóa", "Loại hàng",  "Quy cách đóng gói","Số lượng","Thành tiền", "Trạng thái"};
        
        model_hangHoa = new DefaultTableModel(colNames, 0);
        tbl_hangHoa = new JTable(model_hangHoa);
        JScrollPane js_tableHangHoa = new JScrollPane(tbl_hangHoa);
        
        if (tbl_hangHoa.getColumnModel().getColumnCount() > 0) {
            tbl_hangHoa.getColumnModel().getColumn(0).setResizable(false);
            tbl_hangHoa.getColumnModel().getColumn(1).setResizable(false);
            tbl_hangHoa.getColumnModel().getColumn(2).setResizable(false);
            tbl_hangHoa.getColumnModel().getColumn(3).setResizable(false);
            tbl_hangHoa.getColumnModel().getColumn(4).setResizable(false);
            tbl_hangHoa.getColumnModel().getColumn(5).setResizable(false);
            tbl_hangHoa.getColumnModel().getColumn(6).setResizable(false);
            tbl_hangHoa.getColumnModel().getColumn(7).setResizable(false);
        }
        
        JTableHeader headerTable =  tbl_hangHoa.getTableHeader();
		headerTable.setPreferredSize(new Dimension(headerTable.getPreferredSize().width, 40));
		tbl_hangHoa.setRowHeight(40);
		TableColumnModel tb_col = tbl_hangHoa.getColumnModel();
		tb_col.getColumn(0).setPreferredWidth(50);
		setCellEditable();
        jPanel1.add(js_tableHangHoa, BorderLayout.CENTER);
        
        tbl_hangHoa.addMouseListener(this);
    }
    public void setCellEditable() {
		for (int i = 0; i < tbl_hangHoa.getColumnCount(); i++) {
			tbl_hangHoa.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()) {
					@Override
					public boolean isCellEditable(EventObject e) {
						// Trả về false để ngăn chặn chỉnh sửa trực tiếp
						return false;
					}
				});
			}
	}
    
    private void showMessage(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
			AddContent.addContent(new TaoHangHoa());
	    	
			donViTinh_dao = new DonViTinhDao();
	    	int row = tbl_hangHoa.getSelectedRow();
	    	String maHH = tbl_hangHoa.getValueAt(row, 1).toString();
	    	
	    	entities.HangHoa hangHoa = hangHoa_dao.timHangHoaTheoMa(maHH);
	    	List<DonViTinh> dsDVT = donViTinh_dao.timDVTTheoMaHH(maHH);
	    	
	    	TaoHangHoa.txt_maHangHoa.setText(hangHoa.getMaHangHoa());
	    	TaoHangHoa.txt_tenHangHoa1.setText(hangHoa.getTenHangHoa());
	    	TaoHangHoa.txt_maVach.setText(hangHoa.getMaVach());
	    	TaoHangHoa.cb_loaiHangHoa.setSelectedItem(hangHoa.getLoaiHang());
	    	
	    	TaoHangHoa.cb_nhomHangHoa.setSelectedItem(hangHoa.getNhomHang().getTenNhomHang());
	    	
	    	TaoHangHoa.txt_soDangKy.setText(hangHoa.getSoDangKy());
	    	TaoHangHoa.txt_soLuongDinhMuc1.setText(String.valueOf(hangHoa.getSoLuongDinhMuc()));
	    	TaoHangHoa.txt_soLuongCanhBao.setText(String.valueOf(hangHoa.getSoLuongCanhBao()));
	    	TaoHangHoa.txt_HoatChat.setText(hangHoa.getHoatChatChinh());
	    	TaoHangHoa.txt_hamLuong.setText(hangHoa.getHamLuong());
	    	TaoHangHoa.txt_quyCach.setText(hangHoa.getQuyCachDongGoi());
	    	TaoHangHoa.txt_nuocSX.setText(hangHoa.getNuocSanXuat());
	    	TaoHangHoa.txt_hangSanXuat.setText(hangHoa.getHangSanXuat());
	    	TaoHangHoa.txt_moTa.setText(hangHoa.getMoTa());
	    	TaoHangHoa.txt_vat.setText(String.valueOf(hangHoa.getThue()));
	    	TaoHangHoa.cb_trangThai.setSelectedItem(hangHoa.getTrangThaiHangHoa().equals(TrangThaiHangHoa.DANG_BAN)?"Đang bán":"Ngừng bán");
	    	
//	    	for (DonViTinh dvt : dsDVT) {
//	    		int i = 0;
//	    		TaoHangHoa.model_DVT.setValueAt(i+1, i, 0);
//				TaoHangHoa.model_DVT.setValueAt(dvt.getTenDonViTinh(), i, 1);
//				TaoHangHoa.model_DVT.setValueAt(dvt.getQuyDoi(), i, 2);
//				TaoHangHoa.model_DVT.setValueAt(dvt.getGiaBan(), i, 3);
//				
//				
//				i++;
//			}
	    	
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
