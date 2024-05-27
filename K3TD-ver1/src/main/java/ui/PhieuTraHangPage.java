/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.EventObject;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import components.AddContent;
import components.FormatJtable;
import components.Formater;
import components.PnlBanHang;
import dao.HoaDonDao;
import dao.PhieuTraHangDao;
import entities.PhieuTraHang;
import entities.TrangThaiHoaDon;
import entities.TrangThaiPhieuTraHang;

/**
 *
 * @author LENOVO
 */
public class PhieuTraHangPage extends javax.swing.JPanel {

    private DefaultTableModel model;
	private JTable table;
	private HoaDonDao hoaDon_dao;
	/**
     * Creates new form NewJPanel
     */
    public PhieuTraHangPage() {
        initComponents();
        config();
        addTableHoaDon();
        loadDataTablePTH(false);
    }

    private void config() {
		// TODO Auto-generated method stub
    	dpTuNgay.setDate(LocalDate.now());
		dpDenNgay.setDate(LocalDate.now());
	}

	private void loadDataTablePTH(boolean byMa) {
		// TODO Auto-generated method stub
		model.setRowCount(0);
    	if(byMa) {
    		dsPhieuTraHang = new PhieuTraHangDao().getPhieuTraHangByMa(txtTimTheoMa.getText());
    	}else {
    		LocalDate tuNgay = LocalDate.of(2024, 1, 1);
        	LocalDate denNgay = LocalDate.now();
        	try {
    			dpTuNgay.getDate();
    			dpDenNgay.getDate();
    		} catch (Exception e) {
    			// TODO: handle exception
    			return;
    		}
        	if(dpTuNgay.getDate()!=null)
        		tuNgay = dpTuNgay.getDate();
        	if(dpDenNgay.getDate()!=null)
        		denNgay = dpDenNgay.getDate();
        	dsPhieuTraHang = new PhieuTraHangDao().getDSPhieuTraHangFromTo(tuNgay, denNgay, cbTrangThai.getSelectedIndex()==0?TrangThaiPhieuTraHang.HOAN_THANH:TrangThaiPhieuTraHang.DA_HUY);
    	}
    	
    	if(dsPhieuTraHang!=null) {
    		int stt = 1;
    		for (PhieuTraHang phieuTraHang : dsPhieuTraHang) {
    			model.addRow(new Object[] {stt++,phieuTraHang.getMaPhieu(),phieuTraHang.getHoaDon().getMaHoaDon(),
    					phieuTraHang.getNhanVien().getMaNhanVien(),phieuTraHang.getHoaDon().getKhachHang().getTenKhachHang(),
    					Formater.dateTimeFormater(phieuTraHang.getThoiGianTao()),phieuTraHang.getTongTien(),phieuTraHang.getGhiChu(),phieuTraHang.getTrangThai()==TrangThaiPhieuTraHang.HOAN_THANH?"Hoàn thành":"Đã hủy"});
    		}
    		
    		if(byMa) {
    			txtTimTheoMa.setText("");
        		txtTimTheoMa.requestFocus();
    			}
    		}else {
    			if(byMa) {
    				txtTimTheoMa.selectAll();
    				txtTimTheoMa.requestFocus();
    			}
    	}
    	txtTongSoHoaDonTra.setText(model.getRowCount()+"");
    	
	}

	private void addTableHoaDon() {
		// TODO Auto-generated method stub
		String[] colNames = {"STT","Mã phiếu trả", "Mã hóa đơn", "Nhân viên",  "Khách hàng","Thời gian tạo", "Tổng tiền", "Ghi chú","Trạng thái"};
        
        model = new DefaultTableModel(colNames, 0);
        table = new JTable(model);
        JScrollPane js_tableHangHoa = new JScrollPane(table);
        
        if (table.getColumnModel().getColumnCount() > 0) {
        	table.getColumnModel().getColumn(0).setResizable(false);
        	table.getColumnModel().getColumn(0).setPreferredWidth(5);
        	table.getColumnModel().getColumn(1).setResizable(false);
        	table.getColumnModel().getColumn(2).setResizable(false);
        	table.getColumnModel().getColumn(3).setResizable(false);
        	table.getColumnModel().getColumn(4).setResizable(false);
        	table.getColumnModel().getColumn(5).setResizable(false);
        	table.getColumnModel().getColumn(6).setResizable(false);
        	table.getColumnModel().getColumn(7).setResizable(false);
        	table.getColumnModel().getColumn(8).setResizable(false);
        }
        
        JTableHeader headerTable =  table.getTableHeader();
		headerTable.setPreferredSize(new Dimension(headerTable.getPreferredSize().width, 40));
		table.setRowHeight(40);
		setCellEditable();
		FormatJtable.setFontJtable(table);
        pnlContain.add(js_tableHangHoa, BorderLayout.CENTER);
        
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub
        		super.mouseClicked(e);
        		if(e.getClickCount()>=2) {
        			phieuTraHang = dsPhieuTraHang.get(table.getSelectedRow());
        			AddContent.addContent(new ChiTietPhieuTraHangPage());
        		}
        		
        	}
		});
        
	}
    public void setCellEditable() {
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()) {
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

        pnlHeader = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLocTheoThoiGian = new javax.swing.JLabel();
        cbLocTheoThoiGian = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        dpTuNgay = new com.github.lgooddatepicker.components.DatePicker();
        lblTuNgay = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblDenNgay = new javax.swing.JLabel();
        dpDenNgay = new com.github.lgooddatepicker.components.DatePicker();
        jPanel6 = new javax.swing.JPanel();
        lblTuKhoa = new javax.swing.JLabel();
        txtTimTheoMa = new sampleUi.TimTheoTuKhoa();
        jPanel7 = new javax.swing.JPanel();
        lblTrangThai = new javax.swing.JLabel();
        cbTrangThai = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnTaoPhieuTraHang = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        pnlContain = new javax.swing.JPanel();
        pnlContainHeader = new javax.swing.JPanel();
        lblTongHoaDonTra = new javax.swing.JLabel();
        txtTongSoHoaDonTra = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setPreferredSize(new java.awt.Dimension(1920, 100));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(145, 100));

        lblLocTheoThoiGian.setText("Lọc theo thời gian");
        lblLocTheoThoiGian.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        cbLocTheoThoiGian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hôm nay", "Hôm qua", "7 ngày trước", "Tháng này", "Tháng trước", "Năm này", "Năm trước", "Tất cả" }));
        cbLocTheoThoiGian.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbLocTheoThoiGian.setPreferredSize(new java.awt.Dimension(115, 25));
        cbLocTheoThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocTheoThoiGianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLocTheoThoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cbLocTheoThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLocTheoThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLocTheoThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pnlHeader.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(195, 100));

        dpTuNgay.setPreferredSize(new java.awt.Dimension(143, 25));

        lblTuNgay.setText("Từ ngày");
        lblTuNgay.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTuNgay))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTuNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlHeader.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(195, 100));

        lblDenNgay.setText("Đến ngày");
        lblDenNgay.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        dpDenNgay.setPreferredSize(new java.awt.Dimension(143, 25));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDenNgay)
                    .addComponent(dpDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(lblDenNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pnlHeader.add(jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(255, 100));

        lblTuKhoa.setText("Từ khoá tìm kiếm");
        lblTuKhoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTimTheoMa.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtTimTheoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimTheoMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTuKhoa))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTuKhoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlHeader.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        lblTrangThai.setText("Trạng thái");
        lblTrangThai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoàn thành", "Đã huỷ" }));
        cbTrangThai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbTrangThai.setPreferredSize(new java.awt.Dimension(64, 23));
        cbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTrangThai)
                    .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTrangThai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlHeader.add(jPanel7);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-find-24.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(btnTimKiem)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(btnTimKiem)
                .addGap(19, 19, 19))
        );

        pnlHeader.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        btnTaoPhieuTraHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image 15.png"))); // NOI18N
        btnTaoPhieuTraHang.setText("Tạo phiếu trả hàng");
        btnTaoPhieuTraHang.setPreferredSize(new java.awt.Dimension(72, 35));
        btnTaoPhieuTraHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuTraHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnTaoPhieuTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(btnTaoPhieuTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pnlHeader.add(jPanel10);

        add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));

        pnlContain.setBackground(new java.awt.Color(255, 255, 255));
        pnlContain.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phiếu trả hàng  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18)));
        pnlContain.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pnlContain.setPreferredSize(new java.awt.Dimension(1920, 651));
        pnlContain.setLayout(new java.awt.BorderLayout());

        pnlContainHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlContainHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        lblTongHoaDonTra.setText("Tổng số hóa đơn trả:");
        lblTongHoaDonTra.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pnlContainHeader.add(lblTongHoaDonTra);

        txtTongSoHoaDonTra.setEditable(false);
        txtTongSoHoaDonTra.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTongSoHoaDonTra.setEnabled(false);
        txtTongSoHoaDonTra.setPreferredSize(new java.awt.Dimension(100, 23));
        pnlContainHeader.add(txtTongSoHoaDonTra);

        pnlContain.add(pnlContainHeader, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContain, javax.swing.GroupLayout.DEFAULT_SIZE, 2756, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContain, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        add(pnlCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    //Ham tao cac item cho combo box
    public static class tuyChon extends JComboBox{
		public tuyChon() {
			addItem("Xem chi tiết hóa đơn");
			addItem("Tạo phiếu trả hàng");
		}
	}

                                             
    
    /**
     * @param args the command line arguments
     */
    private void cbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTrangThaiActionPerformed

    private void btnTaoPhieuTraHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuTraHangActionPerformed
        // TODO add your handling code here:
        AddContent.addContent(PnlBanHang.th);
    }//GEN-LAST:event_btnTaoPhieuTraHangActionPerformed

    private void cbLocTheoThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocTheoThoiGianActionPerformed
        // TODO add your handling code here:
    	int i = cbLocTheoThoiGian.getSelectedIndex();
    	LocalDate now = LocalDate.now();
    	// Lấy ngày đầu tháng
        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        // Lấy ngày bắt đầu của tháng trước
        LocalDate firstDayOfLastMonth = now.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        // Lấy ngày kết thúc của tháng trước
        LocalDate lastDayOfLastMonth = now.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
     // Lấy ngày bắt đầu của năm trước
        LocalDate firstDayOfLastYear = now.minusYears(1).with(TemporalAdjusters.firstDayOfYear());
        // Lấy ngày kết thúc của năm trước
        LocalDate lastDayOfLastYear = now.minusYears(1).with(TemporalAdjusters.lastDayOfYear());
     // Lấy ngày bắt đầu của năm nay
        LocalDate firstDayOfYear = now.with(TemporalAdjusters.firstDayOfYear());
        
    	if(i==0) {
    		dpTuNgay.setDate(now);
    		dpDenNgay.setDate(now);
    	}else if(i==1) {
    		dpTuNgay.setDate(now.minusDays(1));
    		dpDenNgay.setDate(now.minusDays(1));
    	}else if(i==2) {
    		dpTuNgay.setDate(now.minusDays(7));
    		dpDenNgay.setDate(now);
    	}else if(i==3) {
    		dpTuNgay.setDate(firstDayOfMonth);
    		dpDenNgay.setDate(now);
    	}else if(i==4) {
    		dpTuNgay.setDate(firstDayOfLastMonth);
    		dpDenNgay.setDate(lastDayOfLastMonth);
    	}else if(i==5) {
    		dpTuNgay.setDate(firstDayOfYear);
    		dpDenNgay.setDate(now);
    	}else if(i==6) {
    		dpTuNgay.setDate(firstDayOfLastYear);
    		dpDenNgay.setDate(lastDayOfLastYear);
    	}else {
    		dpTuNgay.setText("");
    		dpDenNgay.setText("");
    	}
    }//GEN-LAST:event_cbLocTheoThoiGianActionPerformed
    
    private void txtTimTheoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimTheoMaActionPerformed
        // TODO add your handling code here:
    	if(txtTimTheoMa.getText().isEmpty())
    		return;
    	else {
    		loadDataTablePTH(true);
    			
    	}
    }//GEN-LAST:event_txtTimTheoMaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    	if(txtTimTheoMa.getText().isEmpty())
    		loadDataTablePTH(false);
    	else {
    		loadDataTablePTH(true);
    	}
    }//GEN-LAST:event_btnTimKiemActionPerformed
  
	public static PhieuTraHang phieuTraHang;
    private List<PhieuTraHang> dsPhieuTraHang;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoPhieuTraHang;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbLocTheoThoiGian;
    private javax.swing.JComboBox<String> cbTrangThai;
    private com.github.lgooddatepicker.components.DatePicker dpDenNgay;
    private com.github.lgooddatepicker.components.DatePicker dpTuNgay;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblLocTheoThoiGian;
    private javax.swing.JLabel lblTongHoaDonTra;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblTuKhoa;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlContain;
    private javax.swing.JPanel pnlContainHeader;
    private javax.swing.JPanel pnlHeader;
    private sampleUi.TimTheoTuKhoa txtTimTheoMa;
    private javax.swing.JTextField txtTongSoHoaDonTra;
    // End of variables declaration//GEN-END:variables
}
