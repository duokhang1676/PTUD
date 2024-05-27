/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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


import dao.HoaDonDao;
import entities.TrangThaiHoaDon;

/**
 *
 * @author LENOVO
 */
public class HoaDonPage extends javax.swing.JPanel {

    private DefaultTableModel model_hoaDon;
	private JTable tbl_hoaDon;
	private HoaDonDao hoaDon_dao;
	/**
     * Creates new form NewJPanel
     */
    public HoaDonPage() {
        initComponents();
        addTableHoaDon();
        loadDataTableHD();
    }

    private void loadDataTableHD() {
		// TODO Auto-generated method stub
    	int stt = 1;
    	int count = 0;
		hoaDon_dao = new HoaDonDao();
		List<entities.HoaDon> dsHoaDon = hoaDon_dao.getAllHoaDon();
		model_hoaDon.setNumRows(0);
		for (entities.HoaDon hd : dsHoaDon) {
			model_hoaDon.addRow(new Object[] {stt, hd.getMaHoaDon(), hd.getKhachHang().getTenKhachHang(), hd.getNhanVien().getTenNhanVien(),
					hd.getThoiGianLapHoaDon(), 1000, hd.getTrangThaiHoaDon().equals(TrangThaiHoaDon.HOAN_THANH)?"Hoàn thành":"Đã hủy", hd.getGhiChu()});
			
			stt++;
		}
		txtTongSoHoaDon.setText("("+String.valueOf(count)+")");
	}

	private void addTableHoaDon() {
		// TODO Auto-generated method stub
		String[] colNames = {"STT","Mã hóa đơn", "Khách hàng", "Nhân viên bán hàng",  "Thời gian bán hàng","Tổng tiền", "Trạng thái", "Ghi chú"};
        
        model_hoaDon = new DefaultTableModel(colNames, 0);
        tbl_hoaDon = new JTable(model_hoaDon);
        JScrollPane js_tableHangHoa = new JScrollPane(tbl_hoaDon);
        
        if (tbl_hoaDon.getColumnModel().getColumnCount() > 0) {
        	tbl_hoaDon.getColumnModel().getColumn(0).setResizable(false);
        	tbl_hoaDon.getColumnModel().getColumn(1).setResizable(false);
        	tbl_hoaDon.getColumnModel().getColumn(2).setResizable(false);
        	tbl_hoaDon.getColumnModel().getColumn(3).setResizable(false);
        	tbl_hoaDon.getColumnModel().getColumn(4).setResizable(false);
        	tbl_hoaDon.getColumnModel().getColumn(5).setResizable(false);
        	tbl_hoaDon.getColumnModel().getColumn(6).setResizable(false);
        	tbl_hoaDon.getColumnModel().getColumn(7).setResizable(false);
        }
        
        JTableHeader headerTable =  tbl_hoaDon.getTableHeader();
		headerTable.setPreferredSize(new Dimension(headerTable.getPreferredSize().width, 40));
		tbl_hoaDon.setRowHeight(40);
		setCellEditable();
        pnlContain.add(js_tableHangHoa, BorderLayout.CENTER);
        
        
	}
    public void setCellEditable() {
		for (int i = 0; i < tbl_hoaDon.getColumnCount(); i++) {
			tbl_hoaDon.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()) {
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
        dbDenNgay = new com.github.lgooddatepicker.components.DatePicker();
        jPanel5 = new javax.swing.JPanel();
        lblTimTheoHangHoa = new javax.swing.JLabel();
        timTheoHangHoa1 = new sampleUi.TimTheoHangHoa();
        jPanel6 = new javax.swing.JPanel();
        lblTuKhoa = new javax.swing.JLabel();
        timTheoTuKhoa1 = new sampleUi.TimTheoTuKhoa();
        jPanel7 = new javax.swing.JPanel();
        lblTrangThai = new javax.swing.JLabel();
        cbTrangThai = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        lblComboBoxHoaDon = new javax.swing.JLabel();
        cbHoaDon = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        pnlContain = new javax.swing.JPanel();
        pnlPage = new javax.swing.JPanel();
        pagination1 = new sampleUi.paginationStyle.Pagination();
        pnlContainHeader = new javax.swing.JPanel();
        lblTongHoaDon = new javax.swing.JLabel();
        txtTongSoHoaDon = new javax.swing.JTextField();
        lblChonSoHDHienThi = new javax.swing.JLabel();
        cbChonHoaDonHienThi = new javax.swing.JComboBox<>();

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

        dbDenNgay.setPreferredSize(new java.awt.Dimension(143, 25));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDenNgay)
                    .addComponent(dbDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(lblDenNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dbDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pnlHeader.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(210, 100));

        lblTimTheoHangHoa.setText("Tìm kiếm theo hàng hoá");
        lblTimTheoHangHoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        timTheoHangHoa1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timTheoHangHoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblTimTheoHangHoa)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(lblTimTheoHangHoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timTheoHangHoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pnlHeader.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(255, 100));

        lblTuKhoa.setText("Từ khoá tìm kiếm");
        lblTuKhoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        timTheoTuKhoa1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timTheoTuKhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTuKhoa))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTuKhoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timTheoTuKhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlHeader.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        lblTrangThai.setText("Trạng thái");
        lblTrangThai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoàn thành", "Thêm tạm", "Đã huỷ" }));
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

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(149, 100));

        lblComboBoxHoaDon.setText("Hoá đơn");
        lblComboBoxHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        cbHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Theo đơn", "Không theo đơn", " " }));
        cbHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblComboBoxHoaDon)
                    .addComponent(cbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblComboBoxHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlHeader.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-find-24.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

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
                .addGap(22, 22, 22))
        );

        pnlHeader.add(jPanel9);

        add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));

        pnlContain.setBackground(new java.awt.Color(255, 255, 255));
        pnlContain.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hoá đơn  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        pnlContain.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pnlContain.setPreferredSize(new java.awt.Dimension(1920, 651));
        pnlContain.setLayout(new java.awt.BorderLayout());

        pnlPage.setBackground(new java.awt.Color(193, 219, 208));
        pnlPage.setPreferredSize(new java.awt.Dimension(1920, 60));

        javax.swing.GroupLayout pnlPageLayout = new javax.swing.GroupLayout(pnlPage);
        pnlPage.setLayout(pnlPageLayout);
        pnlPageLayout.setHorizontalGroup(
            pnlPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPageLayout.createSequentialGroup()
                .addContainerGap(1281, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1282, Short.MAX_VALUE))
        );
        pnlPageLayout.setVerticalGroup(
            pnlPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPageLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlContain.add(pnlPage, java.awt.BorderLayout.SOUTH);

        pnlContainHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlContainHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        lblTongHoaDon.setText("Tổng số hoá đơn:");
        lblTongHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pnlContainHeader.add(lblTongHoaDon);

        txtTongSoHoaDon.setEditable(false);
        txtTongSoHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTongSoHoaDon.setEnabled(false);
        txtTongSoHoaDon.setPreferredSize(new java.awt.Dimension(100, 23));
        pnlContainHeader.add(txtTongSoHoaDon);

        lblChonSoHDHienThi.setText("Chọn số hoá đơn hiển thị:");
        lblChonSoHDHienThi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pnlContainHeader.add(lblChonSoHDHienThi);

        cbChonHoaDonHienThi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "20", "50", "100" }));
        cbChonHoaDonHienThi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbChonHoaDonHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChonHoaDonHienThiActionPerformed(evt);
            }
        });
        pnlContainHeader.add(cbChonHoaDonHienThi);

        pnlContain.add(pnlContainHeader, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContain, javax.swing.GroupLayout.DEFAULT_SIZE, 2768, Short.MAX_VALUE)
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

    private void cbHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHoaDonActionPerformed

    private void cbChonHoaDonHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChonHoaDonHienThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbChonHoaDonHienThiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbChonHoaDonHienThi;
    private javax.swing.JComboBox<String> cbHoaDon;
    private javax.swing.JComboBox<String> cbLocTheoThoiGian;
    private javax.swing.JComboBox<String> cbTrangThai;
    private com.github.lgooddatepicker.components.DatePicker dbDenNgay;
    private com.github.lgooddatepicker.components.DatePicker dpTuNgay;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblChonSoHDHienThi;
    private javax.swing.JLabel lblComboBoxHoaDon;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblLocTheoThoiGian;
    private javax.swing.JLabel lblTimTheoHangHoa;
    private javax.swing.JLabel lblTongHoaDon;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblTuKhoa;
    private javax.swing.JLabel lblTuNgay;
    private sampleUi.paginationStyle.Pagination pagination1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlContain;
    private javax.swing.JPanel pnlContainHeader;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlPage;
    private sampleUi.TimTheoHangHoa timTheoHangHoa1;
    private sampleUi.TimTheoTuKhoa timTheoTuKhoa1;
    private javax.swing.JTextField txtTongSoHoaDon;
    // End of variables declaration//GEN-END:variables
}
