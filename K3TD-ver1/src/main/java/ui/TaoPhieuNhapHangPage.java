/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import components.AddContent;
import components.DatePickerEditor;
import components.DatePickerRenderer;
import components.ResizeContent;
import dao.ChiTietPhieuNhapHangDao;
import dao.DonViTinhDao;
import dao.HangHoaDao;
import dao.LoHangDao;
import dao.NhaCungCap_DAO;
import dao.PhieuNhapHangDao;
import entities.ChiTietPhieuNhapHang;
import entities.DonViTinh;
import entities.HangHoa;
import entities.LoHang;
import entities.NhaCungCap;
import entities.PhieuNhapHang;
import entities.TrangThaiPhieuNhapHang;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.github.lgooddatepicker.components.DatePicker;

/**
 *
 * @author ACER
 */
public class TaoPhieuNhapHangPage extends javax.swing.JPanel {

    private NhaCungCap_DAO nhaCungCap_dao = new NhaCungCap_DAO();
	private PhieuNhapHangDao phieuNhapHang_dao = new PhieuNhapHangDao();
	private HangHoaDao hangHoa_dao = new HangHoaDao();
	private DonViTinhDao donViTinh_dao = new DonViTinhDao();
	private ChiTietPhieuNhapHangDao chiTietPNH_dao = new ChiTietPhieuNhapHangDao();
	private LoHangDao loHang_dao = new LoHangDao();
	protected static JTable tbl_HH;
	protected static DefaultTableModel model_HH;
	private DatePicker datePicker;
	private JComboBox<Object> cb_tenDVT;
	/**
     * Creates new form NhapHang
     */
    public TaoPhieuNhapHangPage() {
        initComponents();
        new ResizeContent().resizeContent(this);
        addNhapHangTable();
        loadDataNCC();
        loadPhieuNhapHang();
        
        
    }
//    public void setTable() {
//    	TableColumn column1 = tbl_HH.getColumnModel().getColumn(0);
//        column1.setPreferredWidth(10);
//        TableColumn column5 = tbl_HH.getColumnModel().getColumn(2);
//        column5.setPreferredWidth(200);
//    	TableColumn column = tbl_HH.getColumnModel().getColumn(6);
//        column.setCellEditor(new SpinnerEditor());
//        TableActionEvent event = new TableActionEvent() {
//			
//			@Override
//			public void onDelete(int row) {
//				if(tbl_HH.isEditing()) {
//					tbl_HH.getCellEditor().stopCellEditing();
//				}
//				DefaultTableModel model = (DefaultTableModel)table.getModel();
//				model.removeRow(row);
//				dsDVT.remove(row);
//				reload();
//				
//			}
//		};
//        table.getColumnModel().getColumn(10).setCellEditor(new TableActionCellEditor(event));
//        table.getColumnModel().getColumn(10).setCellRenderer(new ButtonRender());
//        
//        model.addTableModelListener(new TableModelListener() {
//            @Override
//            public void tableChanged(TableModelEvent e) {//Bắt sự kiện thay đổi số lượng trên jtable
//                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 6) {
//                	int row = table.getSelectedRow();
//                	if(row==-1)return; //Trường hợp sl thay đổi khi thêm mới 
//                	int soLuong = Integer.parseInt(table.getValueAt(row, 6).toString());
//                   if(soLuong>dsSoLuong.get(row)) {//Kiểm tra số lượng
//                	   JOptionPane.showMessageDialog(null,"Số lượng trả không hợp lệ!","Cảnh báo", JOptionPane.WARNING_MESSAGE);
//                	   table.setValueAt(dsSoLuong.get(row), row,6);//Cập nhật số lượng = sl định mức
//                   }
//                   reload();
//                }
//            }	
//        });
//    }


    private void addNhapHangTable() {
		// TODO Auto-generated method stub
    	
    	String[] colNames = {"STT", "Mã HH", "Tên HH", "Số lô","Ngày sản xuất", "Hạn sử dụng", "DVT", "Số lượng", "Giá nhập", "VAT (%)", "Chiết khấu", "Thành tiền", "Xóa"};
        
        model_HH = new DefaultTableModel(colNames, 0);
        tbl_HH = new JTable(model_HH);
        JScrollPane js_tableHangHoa = new JScrollPane(tbl_HH);
        
        if (tbl_HH.getColumnModel().getColumnCount() > 0) {
        	tbl_HH.getColumnModel().getColumn(0).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(1).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(2).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(3).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(4).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(5).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(6).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(7).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(8).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(9).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(10).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(11).setResizable(false);
        	tbl_HH.getColumnModel().getColumn(12).setResizable(false);
        }
        
        tbl_HH.getColumnModel().getColumn(0).setPreferredWidth(50);
//        datePicker = new DatePicker();
//        tbl_HH.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(datePicker));
//        Object[] emptyRow = {1, null, null, 0,"MV*****" ,"Đang bán"};
//        model_HH.addRow(emptyRow);
        JTableHeader headerTable =  tbl_HH.getTableHeader();
		headerTable.setPreferredSize(new Dimension(headerTable.getPreferredSize().width, 40));
		headerTable.setBackground(Color.white);
		tbl_HH.setRowHeight(40);
		
//		setCellEditable();
        jP_tableContent.add(js_tableHangHoa, BorderLayout.CENTER);
        
//        tbl_DVT.addMouseListener(this);
	}

	private void loadPhieuNhapHang() {
		// TODO Auto-generated method stub
		
		List<PhieuNhapHang> dsPNH = phieuNhapHang_dao.getAllDataPNH();
		dsPNH.forEach(pnh->cb_maPhieuNhapMau.addItem(pnh.getMaPhieu()));
	}

	private void loadDataNCC() {
		// TODO Auto-generated method stub
		
		List<NhaCungCap> dsNCC = nhaCungCap_dao.docTuBang();
		dsNCC.forEach(ncc->cb_NCC.addItem(ncc.getTenNhaCungCap()));
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
        cb_NCC = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ghiChu = new javax.swing.JTextArea();
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

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1860, 700));
        setLayout(new java.awt.BorderLayout());

        jP_header.setBackground(new java.awt.Color(255, 255, 255));
        jP_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_maPhieuNhap.setText("Mã phiếu nhập:");
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
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        dTP_phieuNhap.setDateTimePermissive(currentDateTime);

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

        cb_NCC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cb_NCC.setPreferredSize(new java.awt.Dimension(250, 35));
        jP_header.add(cb_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 200, -1));

        txt_ghiChu.setColumns(20);
        txt_ghiChu.setRows(5);
        jScrollPane2.setViewportView(txt_ghiChu);

        jP_header.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 40, 380, 35));

        add(jP_header, java.awt.BorderLayout.PAGE_START);

        jP_body.setBackground(new java.awt.Color(255, 255, 255));
        jP_body.setLayout(new java.awt.BorderLayout(0, 10));

        jP_bodyHeader.setBackground(new java.awt.Color(255, 255, 255));
        jP_bodyHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_maPhieuNhapMau.setText("Phiếu nhập mẫu:");
        jL_maPhieuNhapMau.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_bodyHeader.add(jL_maPhieuNhapMau, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        cb_maPhieuNhapMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn phiếu nhập mẫu --" }));
        cb_maPhieuNhapMau.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cb_maPhieuNhapMau.setPreferredSize(new java.awt.Dimension(400, 35));
        cb_maPhieuNhapMau.setToolTipText("");
        cb_maPhieuNhapMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_maPhieuNhapMauActionPerformed(evt);
            }
        });
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
        txt_chietKhau.setEditable(false);

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
        txt_tongTienNhap.setEditable(false);

        jL_tongTienNhap.setText("Tổng tiền hàng:");
        jL_tongTienNhap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jP_bodyHeader.add(jL_tongTienNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 100, -1));

        txt_tongThanhTien.setEditable(false);
        txt_tongThanhTien.setBackground(new java.awt.Color(255, 255, 255));
        txt_tongThanhTien.setPreferredSize(new java.awt.Dimension(150, 35));
        txt_tongThanhTien.setToolTipText("");
        jP_bodyHeader.add(txt_tongThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 40, 200, 35));
        txt_tongThanhTien.setEditable(false);

        jL_tongThanhTien.setText("Tổng thành tiền");
        jL_tongThanhTien.setBackground(new java.awt.Color(255, 255, 255));
        jL_tongThanhTien.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jL_tongThanhTien.setForeground(new java.awt.Color(255, 102, 102));
        jP_bodyHeader.add(jL_tongThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 180, 30));

        btn_taoPhieuNhap1.setText("Tạo phiếu nhập");
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
        jP_tableContent.add(jL_chiTietPhieuGhi, java.awt.BorderLayout.NORTH);

        jP_body.add(jP_tableContent, java.awt.BorderLayout.CENTER);

        add(jP_body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timHangHoaActionPerformed
        // TODO add your handling code here:
    	int rowCount = model_HH.getRowCount();
    	int soLuong  = 1;
    	if (txt_timHangHoa.getText().isEmpty()) {
			showMessage("Nhập thông tin cần tìm!");
		}
    	HangHoa hh = hangHoa_dao.timHangHoaTheoMaTheoTen(txt_timHangHoa.getText());
    	if (hh == null) {
    		DonViTinh dvt = donViTinh_dao.timDVTTheoMaVach(txt_timHangHoa.getText());
    		if (dvt != null) {
    			String tenDVT = "";
    			boolean dataExist = false;
//    			double giaNhap = model_HH.getValueAt(rowCount, soLuong)
//    			double thanhTien = hh.getThue()*
    			
    			for(int i = 0; i < model_HH.getRowCount(); i++) {
    				if(model_HH.getValueAt(i, 1).toString().equalsIgnoreCase(dvt.getHangHoa().getMaHangHoa())) {
    					String soLuongStr = model_HH.getValueAt(i, 7).toString();
    			        if (!soLuongStr.isEmpty()) {
    			        	soLuong = Integer.parseInt(soLuongStr) + 1;
    			            model_HH.setValueAt(soLuong, i, 7);
    			        }
    	    			
    	    			txt_timHangHoa.setText("");
    	    			txt_timHangHoa.requestFocus();
    	    			
    	    			dataExist = true;
    	    		}
    			}
    			if (!dataExist) {
    				//"STT", "Mã HH", "Tên HH", "Số lô", "Hạn sử dụng", "DVT", "Số lượng", "Giá nhập", "VAT (%)", "Chiết khấu", "Thành tiền"
    				
    				model_HH.addRow(new Object[] {rowCount+1,dvt.getHangHoa().getMaHangHoa(), dvt.getHangHoa().getTenHangHoa(),"","","",dvt.getTenDonViTinh(), 1,0, dvt.getHangHoa().getThue(), 0, 0, ""});
    				txt_timHangHoa.setText("");
        			txt_timHangHoa.requestFocus();
    			}
			}else {
				showMessage("Không tìm thấy sản phẩm!");
				txt_timHangHoa.selectAll();
    			txt_timHangHoa.requestFocus();
			}
		}else {
			List<DonViTinh> dsDVT = donViTinh_dao.timDVTTheoMaHH(hh.getMaHangHoa());
			String tenDVT = "";
			boolean dataExist = false;
//			double giaNhap = model_HH.getValueAt(rowCount, soLuong)
//			double thanhTien = hh.getThue()*
			for (DonViTinh donViTinh : dsDVT) {
				if (donViTinh.getQuyDoi() == 1) {
					tenDVT = donViTinh.getTenDonViTinh();
				}
			}
			
			for(int i = 0; i < model_HH.getRowCount(); i++) {
				if(model_HH.getValueAt(i, 1).toString().equalsIgnoreCase(hh.getMaHangHoa())) {
					String soLuongStr = model_HH.getValueAt(i, 7).toString();
			        if (!soLuongStr.isEmpty()) {
			        	soLuong = Integer.parseInt(soLuongStr) + 1;
			            model_HH.setValueAt(soLuong, i, 7);
			        }
	    			
	    			txt_timHangHoa.setText("");
	    			txt_timHangHoa.requestFocus();
	    			
	    			dataExist = true;
	    		}
			}
			if (!dataExist) {
				//"STT", "Mã HH", "Tên HH", "Số lô", "Hạn sử dụng", "DVT", "Số lượng", "Giá nhập", "VAT (%)", "Chiết khấu", "Thành tiền"
				cb_tenDVT = new JComboBox<>();
				List<DonViTinh> dsTenDVT = donViTinh_dao.timDVTTheoMaHH(hh.getMaHangHoa());
				for (DonViTinh d : dsTenDVT) {
					cb_tenDVT.addItem(d.getTenDonViTinh());
				}
				cb_tenDVT.setSelectedItem(tenDVT);
				tbl_HH.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(cb_tenDVT));
				model_HH.addRow(new Object[] {rowCount+1,hh.getMaHangHoa(), hh.getTenHangHoa(),"","","",tenDVT, 1,0, hh.getThue(), 0, 0,""});
				
//				tbl_HH.getColumnModel().getColumn(4).setCellRenderer(new DatePickerRenderer());
//				tbl_HH.getColumnModel().getColumn(4).setCellEditor(new DatePickerEditor());
//				tbl_HH.getColumnModel().getColumn(5).setCellRenderer(new DatePickerRenderer());
//				tbl_HH.getColumnModel().getColumn(5).setCellEditor(new DatePickerEditor());
				txt_timHangHoa.setText("");
    			txt_timHangHoa.requestFocus();
			}
			
			
			//su kien thay doi data table
			model_HH.addTableModelListener(new TableModelListener() {
				
				@Override
				public void tableChanged(TableModelEvent e) {
					// TODO Auto-generated method stub
					if (e.getType() == TableModelEvent.UPDATE || e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
	                    int row = e.getFirstRow();
	                    int col = e.getColumn();
	                    if (col == 7 || col == 8 || col == 10) { // Kiểm tra nếu cột "Số lượng" hoặc "Giá nhập" đã được thay đổi
	                        String soLuongStr = model_HH.getValueAt(row, 7).toString();
	                    	String giaNhapStr = model_HH.getValueAt(row, 8).toString();
	                    	String chietKhauStr = model_HH.getValueAt(row, 10).toString();
	                    	int soLuong = 0;
	                        double giaNhap = 0;
	                        double chietKhau = 0;
	                    	try {
								int sl = Integer.parseInt(soLuongStr);
								if (sl < 0) {
									showMessage("Số lượng phải lớn hơn 0!");
								}else {
									soLuong = sl;
								}
							} catch (Exception e2) {
								// TODO: handle exception
								showMessage("Số lượng phải nhập số!");
							}
	                        
	                        try {
								double gn = Double.parseDouble(giaNhapStr);
								if (gn < 0) {
									showMessage("Giá nhập phải lớn hơn 0!");
								}else {
									giaNhap = gn;
								}
							} catch (Exception e2) {
								// TODO: handle exception
								showMessage("Giá nhập phải nhập số!");
							}
	                        
	                        try {
								double ck = Double.parseDouble(chietKhauStr);
								if (ck < 0 || ck > 100) {
									showMessage("Chiết khấu phải từ 0% đến 100%!");
								}else {
									chietKhau = ck;
								}
							} catch (Exception e2) {
								// TODO: handle exception
								showMessage("Chiết khấu phải nhập số!");
							}
	                    	
	                        // Tính toán giá bán
	                        double giaChietKhau = (((chietKhau*giaNhap)/100)*soLuong);
	                        double giaBan = (soLuong*giaNhap)-giaChietKhau;
	                        // Cập nhật giá bán trong cột "Giá bán"
	                        model_HH.setValueAt(giaBan, row, 11);
	                        
	                        
	                    }
	                    
	                    double tongGiamGia = 0;
	                    double tongTienHang = 0;
	                    double tongThanhTien = 0;
	                    double tienNhap = 0;
	                    double soLuong = 0;
	                    for (int i = 0; i < model_HH.getRowCount(); i++) {
	                        tienNhap = Double.parseDouble(model_HH.getValueAt(i, 8).toString());
	                        soLuong = Double.parseDouble(model_HH.getValueAt(i, 7).toString());
	                        
	                        tongTienHang += tienNhap*soLuong;
	                        tongThanhTien += Double.parseDouble(model_HH.getValueAt(i, 11).toString());
	                        tongGiamGia =  tongTienHang - tongThanhTien;
	                        
	                    }
	                    txt_tongTienNhap.setText(Double.toString(tongTienHang));
	                    txt_tongThanhTien.setText(Double.toString(tongThanhTien));
	                    txt_chietKhau.setText(Double.toString(tongGiamGia));
	                }
				}
			});
		}
    }//GEN-LAST:event_txt_timHangHoaActionPerformed

    private void showMessage(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string);
	}

	private void txt_chietKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chietKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chietKhauActionPerformed

    private void txt_tongTienNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tongTienNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tongTienNhapActionPerformed

    private void btn_taoPhieuNhap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoPhieuNhap1ActionPerformed
        // TODO add your handling code here:
    	if (validData()) {
    		//tao lo hang
        	
        	NhaCungCap ncc = nhaCungCap_dao.timNhaCCTheoTen(cb_NCC.getSelectedItem().toString());
        	for(int i = 0; i < model_HH.getRowCount(); i++) {
        		//"STT", "Mã HH", "Tên HH", "Số lô", "Hạn sử dụng", "DVT", "Số lượng", "Giá nhập", "VAT (%)", "Chiết khấu", "Thành tiền"
    			String soLo = model_HH.getValueAt(i, 3).toString();
    			System.out.println(soLo);
    			String maHH = model_HH.getValueAt(i, 1).toString();
    			int soLuong = Integer.parseInt(model_HH.getValueAt(i, 7).toString());
    			LocalDate ngaySX = LocalDate.parse(model_HH.getValueAt(i, 4).toString());
    			LocalDate hanSD = LocalDate.parse(model_HH.getValueAt(i, 5).toString());
    			double giaNhap = Double.parseDouble(model_HH.getValueAt(i, 8).toString());
    			
    			HangHoa hh = hangHoa_dao.timHangHoaTheoMa(maHH);
    			LoHang loHangTim = loHang_dao.timLoHangTheoMa(soLo);
    			if (loHangTim == null) {
    				LoHang lo = new LoHang(soLo, hh, soLuong, ngaySX, hanSD, giaNhap, ncc);
    				loHang_dao.createLoHang(lo);
    			}else {
    				int soLuongThem = soLuong + loHangTim.getSoLuong();
    				model_HH.setValueAt(soLuongThem, i, 7);
    				
    			}
        	}
        	
        	//tao phieu nhap hang
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        	String dateTimePicked = dTP_phieuNhap.getDateTimePermissive().toString();
        	System.out.println(dateTimePicked);
        	LocalDateTime tgTao = LocalDateTime.parse(dateTimePicked, formatter);
        	String ghiChu = txt_ghiChu.getText();
        	String maHDNCC = txt_maHoaDon.getText();
        	
        	Double tongGiamGia = Double.parseDouble(txt_chietKhau.getText());
        	Double tongTienHang = Double.parseDouble(txt_tongTienNhap.getText());
        	Double thanhTien = Double.parseDouble(txt_tongThanhTien.getText());
        	TrangThaiPhieuNhapHang trangThai = TrangThaiPhieuNhapHang.HOAN_THANH;
        	
        	PhieuNhapHang pnh = new PhieuNhapHang("null", tgTao, ghiChu, maHDNCC, ncc, tongGiamGia, tongTienHang, trangThai);
        	System.out.println(pnh.toString());
        	PhieuNhapHang pnHang = phieuNhapHang_dao.createPNH(pnh, thanhTien);
        	
        	if (pnHang != null) {
        		//tao chi tiet pnh
        		for (int i = 0; i < tbl_HH.getRowCount(); i++) {
        			String soLo = model_HH.getValueAt(i, 3).toString();
        			LoHang loHH = loHang_dao.timLoHangTheoMa(soLo);
        			
        			String maHH = model_HH.getValueAt(i, 1).toString();
        			String tenDVT = model_HH.getValueAt(i, 6).toString();
        			DonViTinh dvtCT = donViTinh_dao.timDVTTheoMaHHVaTen(maHH, tenDVT);
        			
        			int soLuong = Integer.parseInt(model_HH.getValueAt(i, 7).toString());
        			double chietKhau =Double.parseDouble(model_HH.getValueAt(i, 10).toString());
        			double thanhTienCT = Double.parseDouble(model_HH.getValueAt(i, 11).toString());
        			
        			ChiTietPhieuNhapHang ctPNHang = new ChiTietPhieuNhapHang(pnh, loHH, dvtCT, soLuong, chietKhau);
        			
        			chiTietPNH_dao.addChiTietPNH(ctPNHang, thanhTienCT);
        			
        		}
        		showMessage("Thêm thành công!");
    		}else {
    			showMessage("Thêm không thành công!");
    		}
		}
    }//GEN-LAST:event_btn_taoPhieuNhap1ActionPerformed

    private boolean validData() {
		// TODO Auto-generated method stub
		String maHD = txt_maHoaDon.getText();
		if (maHD.length() > 0) {
			if (!(maHD.matches("^[a-zA-Z0-9-]+"))) {
				showMessage("Mã hóa đơn không được chưa kí tự đặc biệt!");
				return false;
			}
		}else {
			showMessage("Mã hóa đơn không được để trống!");
			return false;
		}
    	return true;
	}

	private void txt_maHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maHoaDonActionPerformed

    private void txt_maPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maPhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maPhieuNhapActionPerformed

    private void btn_thoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoat1ActionPerformed
        // TODO add your handling code here:
    	AddContent.addContent(new NhapHangPage());
    }//GEN-LAST:event_btn_thoat1ActionPerformed

    private void cb_maPhieuNhapMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_maPhieuNhapMauActionPerformed
        // TODO add your handling code here:
    	
    	String ma = cb_maPhieuNhapMau.getSelectedItem().toString();
    	PhieuNhapHang pnh = phieuNhapHang_dao.getPNHTheoMa(ma);
    	List<ChiTietPhieuNhapHang> dsChiTiet= chiTietPNH_dao.getChiTietPNH(ma);
    	
    	txt_maPhieuNhap.setText(pnh.getMaPhieu());
    	dTP_phieuNhap.setDateTimePermissive(pnh.getThoiGianTao());
    	txt_maHoaDon.setText(pnh.getMaHoaDonNCC());
    	cb_NCC.setSelectedItem(pnh.getNhaCungCap().getTenNhaCungCap());
    	txt_ghiChu.setText(pnh.getGhiChu());
    	model_HH.setRowCount(0);
    	int stt = 1;
    	
    	for (ChiTietPhieuNhapHang ct : dsChiTiet) {
    		double giaChietKhau = (((ct.getChietKhau()*ct.getLoHang().getGiaNhap())/100)*ct.getSoLuong());
            double giaBan = (ct.getSoLuong()*ct.getLoHang().getGiaNhap())-giaChietKhau;
            
            
			model_HH.addRow(new Object[] {stt, ct.getDonViTinh().getHangHoa().getMaHangHoa(),ct.getDonViTinh().getHangHoa().getTenHangHoa() ,ct.getLoHang().getSoLo(), ct.getLoHang().getNgaySanXuat(),
					ct.getLoHang().getHanSuDung(), ct.getDonViTinh().getTenDonViTinh(), ct.getSoLuong(), ct.getLoHang().getGiaNhap(),ct.getLoHang().getHangHoa().getThue(), ct.getChietKhau(), giaBan});
		}
    	
    	double tongGiamGia = 0;
        double tongTienHang = 0;
        double tongThanhTien = 0;
        double tienNhap = 0;
        double soLuong = 0;
        for (int i = 0; i < model_HH.getRowCount(); i++) {
            tienNhap = Double.parseDouble(model_HH.getValueAt(i, 8).toString());
            soLuong = Double.parseDouble(model_HH.getValueAt(i, 7).toString());
            
            tongTienHang += tienNhap*soLuong;
            tongThanhTien += Double.parseDouble(model_HH.getValueAt(i, 11).toString());
            tongGiamGia =  tongTienHang - tongThanhTien;
            
        }
        txt_tongTienNhap.setText(Double.toString(tongTienHang));
        txt_tongThanhTien.setText(Double.toString(tongThanhTien));
        txt_chietKhau.setText(Double.toString(tongGiamGia));
    	
    }//GEN-LAST:event_cb_maPhieuNhapMauActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_taoPhieuNhap1;
    private javax.swing.JButton btn_thoat1;
    protected static javax.swing.JComboBox<String> cb_NCC;
    private javax.swing.JComboBox<String> cb_maPhieuNhapMau;
    protected static com.github.lgooddatepicker.components.DateTimePicker dTP_phieuNhap;
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
    private javax.swing.JScrollPane jScrollPane2;
    protected static javax.swing.JTextField txt_chietKhau;
    protected static javax.swing.JTextArea txt_ghiChu;
    protected static javax.swing.JTextField txt_maHoaDon;
    protected static javax.swing.JTextField txt_maPhieuNhap;
    private javax.swing.JTextField txt_timHangHoa;
    protected static javax.swing.JTextField txt_tongThanhTien;
    protected static javax.swing.JTextField txt_tongTienNhap;
    // End of variables declaration//GEN-END:variables
}
