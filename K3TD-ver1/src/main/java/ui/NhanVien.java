/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import components.ResizeContent;
import dao.NhanVien_DAO;
import entities.ChucVuNhanVien;
import entities.TrangThaiNhanVien;

/**
 *
 * @author Admin
 */
public class NhanVien extends javax.swing.JPanel {

    private NhanVien_DAO NV_dao;
	private DefaultTableModel model_NV;
	private JTable tbl_NV;
	private NhanVien_DAO nv_DAO = new NhanVien_DAO();
	/**
     * Creates new form NhanVien_httk
     */
    public NhanVien() {
        initComponents();
        ResizeContent.resizeContent(this);
        pnl_left.setVisible(false);
        addTableNV();
        loadDataNV();
    }
    private void loadDataNV() {
		// TODO Auto-generated method stub
    	int stt = 1;
		model_NV.setNumRows(0);
		
		NV_dao = new NhanVien_DAO();
		List<entities.NhanVien> dsNV = NV_dao.docTuBang();
		for (entities.NhanVien nv : dsNV) {
			model_NV.addRow(new Object[] {stt, nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getChucVu().equals(ChucVuNhanVien.NHAN_VIEN) ? "Nhân Viên" : "Quản Lý", nv.getSoDienThoai(),
					nv.getGhiChu(), nv.getTrangThaiNhanVien().equals(TrangThaiNhanVien.DANG_HOAT_DONG)?"Đang hoạt động":"Ngưng hoạt động"});
			
			stt++;
		}
	}

	private void addTableNV() {
		// TODO Auto-generated method stub
    	String[] colNames = {"STT","Mã Nhân Viên", "Họ và Tên", "Chức Vụ",  "Số điện thoại","Ghi chú","Trạng thái"};
        
        model_NV = new DefaultTableModel(colNames, 0);
        tbl_NV = new JTable(model_NV);
        JScrollPane js_tableNhanVien = new JScrollPane(tbl_NV);
        
        if (tbl_NV.getColumnModel().getColumnCount() > 0) {
        	tbl_NV.getColumnModel().getColumn(0).setResizable(false);
        	tbl_NV.getColumnModel().getColumn(1).setResizable(false);
        	tbl_NV.getColumnModel().getColumn(2).setResizable(false);
        	tbl_NV.getColumnModel().getColumn(3).setResizable(false);
        	tbl_NV.getColumnModel().getColumn(4).setResizable(false);
        	tbl_NV.getColumnModel().getColumn(5).setResizable(false);
        	tbl_NV.getColumnModel().getColumn(6).setResizable(false);
            
        }
        
        JTableHeader headerTable =  tbl_NV.getTableHeader();
		headerTable.setPreferredSize(new Dimension(headerTable.getPreferredSize().width, 40));
		tbl_NV.setRowHeight(40);
//		setCellEditable();
        pnlCenter.add(js_tableNhanVien, BorderLayout.CENTER);
        
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

        btn_Group_gioiTinh = new javax.swing.ButtonGroup();
        pnl_left = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlForm = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        datengaySinh = new com.github.lgooddatepicker.components.DatePicker();
        dateNgayTao = new com.github.lgooddatepicker.components.DatePicker();
        txtSoDienThoai = new javax.swing.JTextField();
        pnlFooter = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_maNhanVien = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ratiobtn_Nu = new javax.swing.JRadioButton();
        ratiobtn_Nam = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbo_TrangThai = new javax.swing.JComboBox<>();
        cbo_ChucVu = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        btn_Dong = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_GhiChu = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        btn_Tim = new javax.swing.JButton();
        cbo_tim_ChucVu = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbo_tim_TrangThai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_Tim1 = new javax.swing.JButton();
        txt_tim = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        txtTenNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenNhanVien.setPreferredSize(new java.awt.Dimension(64, 35));
        txtTenNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNhanVienActionPerformed(evt);
            }
        });

        txtSoDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSoDienThoai.setPreferredSize(new java.awt.Dimension(64, 35));

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

        jLabel9.setText("Mã nhân viên");
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setText("Thông tin nhân viên");
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        jLabel10.setText("Họ và tên");
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txt_maNhanVien.setEditable(false);
        txt_maNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_maNhanVien.setPreferredSize(new java.awt.Dimension(64, 35));
        txt_maNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maNhanVienActionPerformed(evt);
            }
        });

        jLabel11.setText("Giới tính");
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel12.setText("Ngày tạo");
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btn_Group_gioiTinh.add(ratiobtn_Nu);
        ratiobtn_Nu.setText("Nữ");
        ratiobtn_Nu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ratiobtn_Nu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratiobtn_NuActionPerformed(evt);
            }
        });

        btn_Group_gioiTinh.add(ratiobtn_Nam);
        ratiobtn_Nam.setText("Nam");
        ratiobtn_Nam.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ratiobtn_Nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratiobtn_NamActionPerformed(evt);
            }
        });

        jLabel13.setText("Ngày sinh");
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel14.setText("Ghi chú");
        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel15.setText("Số điện thoại");
        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        cbo_TrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Ngừng hoạt động" }));
        cbo_TrangThai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbo_TrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_TrangThaiActionPerformed(evt);
            }
        });

        cbo_ChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));
        cbo_ChucVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbo_ChucVu.setPreferredSize(new java.awt.Dimension(113, 35));
        cbo_ChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_ChucVuActionPerformed(evt);
            }
        });

        jLabel16.setText("Chức vụ");
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

        txtarea_GhiChu.setColumns(20);
        txtarea_GhiChu.setRows(5);
        txtarea_GhiChu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(txtarea_GhiChu);

        jLabel17.setText("Trạng thái");
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

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
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlFormLayout.createSequentialGroup()
                                .addComponent(ratiobtn_Nam)
                                .addGap(33, 33, 33)
                                .addComponent(ratiobtn_Nu)))
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormLayout.createSequentialGroup()
                                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datengaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_maNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbo_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(txt_maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ratiobtn_Nam)
                        .addComponent(ratiobtn_Nu))
                    .addComponent(cbo_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datengaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel4))
                    .addGroup(pnlFormLayout.createSequentialGroup()
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

        btn_Tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-16.png"))); // NOI18N
        btn_Tim.setText("Tìm");
        btn_Tim.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimActionPerformed(evt);
            }
        });

        cbo_tim_ChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý", "Tất cả" }));
        cbo_tim_ChucVu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbo_tim_ChucVu.setPreferredSize(new java.awt.Dimension(113, 35));

        jLabel1.setText("Danh sách nhân viên (24)");
        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N

        cbo_tim_TrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Ngừng hoạt động", "Tất cả" }));
        cbo_tim_TrangThai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbo_tim_TrangThai.setPreferredSize(new java.awt.Dimension(163, 35));

        jLabel3.setText("Tìm kiếm theo từ khóa (F4)");
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel5.setText("Trạng thái");
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel6.setText("Chức vụ");
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btn_Tim1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image 15.png"))); // NOI18N
        btn_Tim1.setText("Thêm nhân viên");
        btn_Tim1.setPreferredSize(new java.awt.Dimension(72, 35));
        btn_Tim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Tim1ActionPerformed(evt);
            }
        });

        txt_tim.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_tim_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_tim_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNorthLayout.createSequentialGroup()
                        .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btn_Tim1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(389, Short.MAX_VALUE))
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNorthLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(pnlNorthLayout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_tim_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_tim_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Tim1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1))
        );

        pnlCenter.add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Họ và tên", "Chức vụ", "Số điện thoại", "Ghi chú", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(pnlCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        // TODO add your handling code here:
        luu();
    }//GEN-LAST:event_btn_LuuActionPerformed

    private void txtTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNhanVienActionPerformed

    private void btn_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimActionPerformed
        // TODO add your handling code here:
        timTheoTuKhoa_TrangThai_ChucVu();
    }//GEN-LAST:event_btn_TimActionPerformed

    private void btn_DongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DongActionPerformed
        // TODO add your handling code here:
        pnl_left.setVisible(false);
    }//GEN-LAST:event_btn_DongActionPerformed

    private void txt_maNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maNhanVienActionPerformed

    private void ratiobtn_NuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratiobtn_NuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ratiobtn_NuActionPerformed

    private void ratiobtn_NamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratiobtn_NamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ratiobtn_NamActionPerformed

    private void cbo_TrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_TrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_TrangThaiActionPerformed

    private void cbo_ChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_ChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_ChucVuActionPerformed

    private void btn_Tim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Tim1ActionPerformed
        // TODO add your handling code here:
        pnl_left.setVisible(true);
    }//GEN-LAST:event_btn_Tim1ActionPerformed

    private void txt_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Dong;
    private javax.swing.ButtonGroup btn_Group_gioiTinh;
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_Tim;
    private javax.swing.JButton btn_Tim1;
    private javax.swing.JComboBox<String> cbo_ChucVu;
    private javax.swing.JComboBox<String> cbo_TrangThai;
    private javax.swing.JComboBox<String> cbo_tim_ChucVu;
    private javax.swing.JComboBox<String> cbo_tim_TrangThai;
    private com.github.lgooddatepicker.components.DatePicker dateNgayTao;
    private com.github.lgooddatepicker.components.DatePicker datengaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnl_left;
    private javax.swing.JRadioButton ratiobtn_Nam;
    private javax.swing.JRadioButton ratiobtn_Nu;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txt_maNhanVien;
    private javax.swing.JTextField txt_tim;
    private javax.swing.JTextArea txtarea_GhiChu;
    // End of variables declaration//GEN-END:variables
	private entities.NhanVien nV;
    
    private void revert_NhanVien() {
    	String ma = txt_maNhanVien.getText();
    	String ten = txtTenNhanVien.getText();
    	LocalDate ngaySinh = datengaySinh.getDate();
    	boolean gioiTInh = btn_Group_gioiTinh.getSelection().toString().equals("Nam") ? true : false ;
    	String soDienThoai = txtSoDienThoai.getText();
    	String matKhau = "123456";
    	LocalDate ngayTao = dateNgayTao.getDate();
    	String ghiChu = txtarea_GhiChu.getText();
    	ChucVuNhanVien cvNhanVien = cbo_ChucVu.getSelectedItem().toString().equals("Nhân Viên") ? ChucVuNhanVien.NHAN_VIEN : ChucVuNhanVien.QUAN_LY;
    	TrangThaiNhanVien ttNhanVien = cbo_TrangThai.getSelectedItem().toString().equals("Đang hoạt động") ? TrangThaiNhanVien.DANG_HOAT_DONG : TrangThaiNhanVien.NGUNG_HOAT_DONG;
    	nV = new entities.NhanVien(ma, ten, ngaySinh, gioiTInh, soDienThoai, matKhau, ngayTao, ghiChu, cvNhanVien, ttNhanVien);
    }
    private void luu() {
    	revert_NhanVien();
    	int n =0;
    	if (nv_DAO.create(nV)) {
			model_NV.addRow( new Object [] {
					n + "",
					txt_maNhanVien.getText(),
					txtTenNhanVien.getText(),
					cbo_ChucVu.getSelectedItem().toString(),
					txtSoDienThoai.getText(),
					txtarea_GhiChu.getText(),
					cbo_TrangThai.getSelectedItem().toString()
			});
		}
    }
    private void timTheoTuKhoa_TrangThai_ChucVu() {
    	NhanVien_DAO ds = new NhanVien_DAO();
    	int n=1;
    	String tukhoa = txt_tim.getText();
        String tt = cbo_tim_TrangThai.getSelectedItem().toString();
        String cv = cbo_tim_ChucVu.getSelectedItem().toString();
        List<entities.NhanVien> list = ds.timkiem_TuKhoa_TrangThai(tukhoa, cv, tt);
        int stt = tbl_NV.getSelectedRow() +1;
        model_NV.setRowCount(0);
        for (entities.NhanVien s : list) {
			model_NV.addRow( new Object [] {
					n + "",
					txt_maNhanVien.getText(),
					txtTenNhanVien.getText(),
					cbo_ChucVu.getSelectedItem().toString(),
					txtSoDienThoai.getText(),
					txtarea_GhiChu.getText(),
					cbo_TrangThai.getSelectedItem().toString()
			});
			n++;
		}
    }
}
