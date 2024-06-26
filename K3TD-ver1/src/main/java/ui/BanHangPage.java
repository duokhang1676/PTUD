/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import dao.Ca_DAO;
import dao.ChiTietDonThuocMau_DAO;
import dao.ChiTietHoaDonDao;
import dao.DonThuocMauDao;
import dao.DonThuocMau_DAO;
import dao.DonThuoc_DAO;
import dao.DonViTinhDao;
import dao.HangHoaDao;
import dao.HoaDonDao;
import dao.KhachHang_DAO;
import dao.LoHangDao;
import entities.Ca;
import entities.ChiTietDonThuocMau;
import entities.ChiTietHoaDon;
import entities.DonThuoc;
import entities.DonThuocMau;
import entities.DonViTinh;
import entities.HangHoa;
import entities.HoaDon;
import entities.KhachHang;
import entities.LoHang;
import entities.NhanVien;
import entities.TrangThaiDonViTinh;
import entities.TrangThaiHoaDon;
import entities.TrangThaiKhachHang;
import printer.PdfWriterExample;
import printer.PrintExample;

import static org.junit.Assert.assertNotNull;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import javax.swing.text.DocumentFilter.FilterBypass;

import org.json.simple.parser.ParseException;

import components.AddContent;
import components.ButtonRender;
import components.FormatJtable;
import components.Formater;
import components.GeneratePK;
import components.LoginInfo;
import components.NumberFilter;
import components.NumericDocumentFilter;
import components.PnlBanHang;
import components.ResizeContent;
import components.SpinnerEditor;
import components.TableActionCellEditor;
import components.TableActionEvent;

/**
 *
 * @author LENOVO
 */
public class BanHangPage extends javax.swing.JPanel {

    /**
     * Creates new form BanHang2
     */
    public BanHangPage() {
    	hangHoaDao = new HangHoaDao();
    	hoaDonDao = new HoaDonDao();
    	khachHangDao = new KhachHang_DAO();   	
    	donThuocMauDao = new DonThuocMauDao();
    	donViTinhDao = new DonViTinhDao();
    	caDao = new Ca_DAO();
    	chiTietHDDao = new ChiTietHoaDonDao();
    	loHangDAO = new LoHangDao();
    	donThuocDao = new DonThuoc_DAO();
    	chiTietDTMDAO = new ChiTietDonThuocMau_DAO();
        initComponents();
        ResizeContent.resizeContent(this);
        setTable();
       
        FormatJtable.setCellEditableForBH(tbChiTietHoaDon);
        phimTat();
        
        updateTime();
        //Do du lieu don thuoc mau vao combobox
        cbChonDonThuocMau.addItem("--Đơn thuốc mẫu--");
        themDonThuocMau();
        config();
        timMaSP1.requestFocus();
    }

    private void config() {
		// TODO Auto-generated method stub
    	setBorderHD(pnl1);
		pnl2.setVisible(false);
		pnl3.setVisible(false);
		pnl4.setVisible(false);
		pnl5.setVisible(false);

		lblSpace.setPreferredSize(new Dimension(lblSpace.getWidth()-60+155*5,lblSpace.getHeight()));
    	
    	txtDiemQuyDoi.setEditable(false);
    	cbChonDonThuocMau.setPreferredSize(new Dimension(180,cbChonDonThuocMau.getHeight()));
    	Font fontB = new Font("Arial", Font.BOLD, 14);
		Font font = new Font("Arial", Font.PLAIN, 14);
		txtTienTra.setFont(fontB);
		txtTenKH.setFont(fontB);
		txtSDTKH.setFont(font);
		txtDiemThuong.setFont(font);
		txtTongTien.setFont(fontB);
		txtDiemQuyDoi.setFont(font);
		txtTienGiam.setFont(font);
		txtTienDua.setFont(font);
		txtTienThua.setFont(fontB);
		txtGhiChu.setFont(font);

		 ((AbstractDocument) txtTienDua.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        ((AbstractDocument) txtDiemQuyDoi.getDocument()).setDocumentFilter(new NumericDocumentFilter());
       ((AbstractDocument) txtDiemThuong.getDocument()).setDocumentFilter(new NumericDocumentFilter());
       // ((AbstractDocument) txtDiemQuyDoi.getDocument()).setDocumentFilter(new NumberFilter());
        //((AbstractDocument) txtTienDua.getDocument()).setDocumentFilter(new NumberFilter());
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
        cbChonDonThuocMau = new javax.swing.JComboBox<>();
        lbLapHD = new javax.swing.JLabel();
        timMaSP1 = new sampleUi.TimMaSP();
        ckBBanTheoDon = new javax.swing.JCheckBox();
        nhapMaDonThuoc1 = new sampleUi.NhapMaDonThuoc();
        txtTimer = new javax.swing.JTextField();
        pnlBody = new javax.swing.JPanel();
        pnlLeft = new javax.swing.JPanel();
        lblPhimTat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChiTietHoaDon = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        pnl1 = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        pnl2 = new javax.swing.JPanel();
        btn2 = new javax.swing.JButton();
        lbl2 = new javax.swing.JLabel();
        pnl3 = new javax.swing.JPanel();
        btn3 = new javax.swing.JButton();
        lbl3 = new javax.swing.JLabel();
        pnl4 = new javax.swing.JPanel();
        btn4 = new javax.swing.JButton();
        lbl4 = new javax.swing.JLabel();
        pnl5 = new javax.swing.JPanel();
        btn5 = new javax.swing.JButton();
        lbl5 = new javax.swing.JLabel();
        lblSpace = new javax.swing.JLabel();
        btnThemHoaDon = new javax.swing.JButton();
        pnlRight = new javax.swing.JPanel();
        pnlKhachHang = new javax.swing.JPanel();
        lblKhachHang = new javax.swing.JLabel();
        btnThemKhachHang = new javax.swing.JButton();
        pnlThongTinKhachHang = new javax.swing.JPanel();
        lblTenKH = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblDiemThuong = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        txtSDTKH = new javax.swing.JTextField();
        txtDiemThuong = new javax.swing.JTextField();
        timSDTKhachHang1 = new sampleUi.TimSDTKhachHang();
        pnlThanhToan = new javax.swing.JPanel();
        lblThanhToan = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblDiemQuyDoi = new javax.swing.JLabel();
        lblTienGiam = new javax.swing.JLabel();
        lblTienTra = new javax.swing.JLabel();
        lblTienDua = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        lblGhiChu = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnLuuTam = new javax.swing.JButton();
        txtTongTien = new javax.swing.JTextField();
        txtDiemQuyDoi = new javax.swing.JTextField();
        txtTienGiam = new javax.swing.JTextField();
        txtTienTra = new javax.swing.JTextField();
        txtTienDua = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        spGhiChu = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setPreferredSize(new java.awt.Dimension(1920, 50));
        pnlHeader.setPreferredSize(new Dimension(ResizeContent.getWidth(),50));

        cbChonDonThuocMau.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbChonDonThuocMau.setToolTipText("");
        cbChonDonThuocMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChonDonThuocMauActionPerformed(evt);
            }
        });

        lbLapHD.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbLapHD.setForeground(new java.awt.Color(51, 51, 255));
        lbLapHD.setText("LẬP HOÁ ĐƠN");

        timMaSP1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        timMaSP1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-find-24.png"))); // NOI18N
        timMaSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timMaSP1ActionPerformed(evt);
            }
        });

        ckBBanTheoDon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ckBBanTheoDon.setText("Bán theo đơn");
        ckBBanTheoDon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckBBanTheoDonItemStateChanged(evt);
            }
        });

        nhapMaDonThuoc1.setEditable(false);
        nhapMaDonThuoc1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nhapMaDonThuoc1.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        nhapMaDonThuoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapMaDonThuoc1ActionPerformed(evt);
            }
        });

        txtTimer.setEditable(false);
        txtTimer.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtTimer.setBorder(null);

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbLapHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(timMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ckBBanTheoDon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nhapMaDonThuoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(cbChonDonThuocMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(375, 375, 375))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbLapHD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(timMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nhapMaDonThuoc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ckBBanTheoDon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChonDonThuocMau)
                    .addComponent(txtTimer))
                .addContainerGap())
        );

        add(pnlHeader, java.awt.BorderLayout.NORTH);

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlBody.setPreferredSize(new java.awt.Dimension(1920, 720));
        pnlBody.setLayout(new java.awt.BorderLayout());

        pnlLeft.setBackground(new java.awt.Color(255, 255, 255));
        pnlLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlLeft.setPreferredSize(new java.awt.Dimension(500, 720));
        pnlLeft.setLayout(new java.awt.BorderLayout());

        lblPhimTat.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblPhimTat.setText("Nhấn F4 để quét mã vạch");
        pnlLeft.add(lblPhimTat, java.awt.BorderLayout.SOUTH);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 500));

        tbChiTietHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Đơn vị tính", "Số lượng", "Giá bán", "Thành tiền", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbChiTietHoaDon.setRequestFocusEnabled(false);
        tbChiTietHoaDon.setRowHeight(40);
        jScrollPane1.setViewportView(tbChiTietHoaDon);

        pnlLeft.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnl1.setBackground(new java.awt.Color(193, 219, 208));
        pnl1.setPreferredSize(new java.awt.Dimension(150, 30));

        lbl1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 0, 0));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("Hoá đơn 1");
        lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl1MouseClicked(evt);
            }
        });

        btn1.setBackground(new java.awt.Color(193, 219, 208));
        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-close-24.png"))); // NOI18N
        btn1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        header.add(pnl1);

        pnl2.setBackground(new java.awt.Color(193, 219, 208));
        pnl2.setPreferredSize(new java.awt.Dimension(150, 30));

        btn2.setBackground(new java.awt.Color(193, 219, 208));
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-close-24.png"))); // NOI18N
        btn2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        lbl2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 0, 0));
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("Hoá đơn 2");
        lbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        header.add(pnl2);

        pnl3.setBackground(new java.awt.Color(193, 219, 208));
        pnl3.setPreferredSize(new java.awt.Dimension(150, 30));

        btn3.setBackground(new java.awt.Color(193, 219, 208));
        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-close-24.png"))); // NOI18N
        btn3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        lbl3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 0, 0));
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setText("Hoá đơn 3");
        lbl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(lbl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        header.add(pnl3);

        pnl4.setBackground(new java.awt.Color(193, 219, 208));
        pnl4.setPreferredSize(new java.awt.Dimension(150, 30));

        btn4.setBackground(new java.awt.Color(193, 219, 208));
        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-close-24.png"))); // NOI18N
        btn4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        lbl4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl4.setForeground(new java.awt.Color(255, 0, 0));
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setText("Hoá đơn 4");
        lbl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl4Layout = new javax.swing.GroupLayout(pnl4);
        pnl4.setLayout(pnl4Layout);
        pnl4Layout.setHorizontalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl4Layout.setVerticalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(lbl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        header.add(pnl4);

        pnl5.setBackground(new java.awt.Color(193, 219, 208));
        pnl5.setPreferredSize(new java.awt.Dimension(150, 30));

        btn5.setBackground(new java.awt.Color(193, 219, 208));
        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-close-24.png"))); // NOI18N
        btn5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        lbl5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl5.setForeground(new java.awt.Color(255, 0, 0));
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl5.setText("Hoá đơn 5");
        lbl5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl5Layout = new javax.swing.GroupLayout(pnl5);
        pnl5.setLayout(pnl5Layout);
        pnl5Layout.setHorizontalGroup(
            pnl5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl5Layout.setVerticalGroup(
            pnl5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        header.add(pnl5);

        lblSpace.setText("jLabel2");
        lblSpace.setPreferredSize(new java.awt.Dimension(100, 20));
        header.add(lblSpace);

        btnThemHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image 15.png"))); // NOI18N
        btnThemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHoaDonActionPerformed(evt);
            }
        });
        header.add(btnThemHoaDon);

        pnlLeft.add(header, java.awt.BorderLayout.NORTH);

        pnlBody.add(pnlLeft, java.awt.BorderLayout.CENTER);

        pnlRight.setPreferredSize(new java.awt.Dimension(900, 720));
        if(ResizeContent.getScale()==1)pnlRight.setPreferredSize(new java.awt.Dimension((int)((int)ResizeContent.getWidth()*0.28),(int)ResizeContent.getHeight()-270));
        pnlRight.setLayout(new java.awt.BorderLayout());

        pnlKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlKhachHang.setPreferredSize(new java.awt.Dimension(100, 150));

        lblKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(255, 0, 0));
        lblKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Nguoi.png"))); // NOI18N
        lblKhachHang.setText("Khách hàng");

        btnThemKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image 15.png"))); // NOI18N
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });

        pnlThongTinKhachHang.setBackground(new java.awt.Color(255, 255, 255));

        lblTenKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTenKH.setText("Tên khách hàng:");

        lblSDT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSDT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSDT.setText("Số điện thoại:");

        lblDiemThuong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDiemThuong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiemThuong.setText("Điểm thưởng:");

        txtTenKH.setEditable(false);
        txtTenKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        txtSDTKH.setEditable(false);
        txtSDTKH.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDiemThuong.setEditable(false);
        txtDiemThuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pnlThongTinKhachHangLayout = new javax.swing.GroupLayout(pnlThongTinKhachHang);
        pnlThongTinKhachHang.setLayout(pnlThongTinKhachHangLayout);
        pnlThongTinKhachHangLayout.setHorizontalGroup(
            pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhachHangLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDiemThuong)
                    .addComponent(lblSDT)
                    .addComponent(lblTenKH))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiemThuong, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThongTinKhachHangLayout.setVerticalGroup(
            pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhachHangLayout.createSequentialGroup()
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiemThuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiemThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        timSDTKhachHang1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        timSDTKhachHang1.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-find-24.png"))); // NOI18N
        timSDTKhachHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timSDTKhachHang1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlKhachHangLayout.createSequentialGroup()
                        .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timSDTKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timSDTKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRight.add(pnlKhachHang, java.awt.BorderLayout.PAGE_START);

        pnlThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        pnlThanhToan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlThanhToan.setPreferredSize(new java.awt.Dimension(100, 424));

        lblThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblThanhToan.setForeground(new java.awt.Color(255, 0, 0));
        lblThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ThanhToan.png"))); // NOI18N
        lblThanhToan.setText("Thanh toán");

        lblTongTien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTongTien.setText("Tổng tiền hàng:");

        lblDiemQuyDoi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblDiemQuyDoi.setText("Điểm quy đổi:");

        lblTienGiam.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTienGiam.setText("Tổng tiền giảm:");

        lblTienTra.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTienTra.setText("Tiền phải trả:");

        lblTienDua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTienDua.setText("Tiền khách đưa:");

        lblTienThua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTienThua.setText("Tiền thừa (Làm tròn):");

        lblGhiChu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblGhiChu.setText("Ghi chú:");

        btnThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThanhToan.setText("Thanh toán và in hoá đơn");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnLuuTam.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLuuTam.setText("Lưu tạm hoá đơn");
        btnLuuTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuTamActionPerformed(evt);
            }
        });

        txtTongTien.setEditable(false);
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        txtDiemQuyDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiemQuyDoiActionPerformed(evt);
            }
        });

        txtTienGiam.setEditable(false);

        txtTienTra.setEditable(false);

        txtTienDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienDuaActionPerformed(evt);
            }
        });

        txtTienThua.setEditable(false);

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

        javax.swing.GroupLayout pnlThanhToanLayout = new javax.swing.GroupLayout(pnlThanhToan);
        pnlThanhToan.setLayout(pnlThanhToanLayout);
        pnlThanhToanLayout.setHorizontalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblThanhToan)
                        .addGroup(pnlThanhToanLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlThanhToanLayout.createSequentialGroup()
                                    .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTienThua)
                                        .addComponent(lblDiemQuyDoi, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTongTien, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTienGiam, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTienTra, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTienDua, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblGhiChu, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtTienThua, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTienDua, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTienTra, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTienGiam, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDiemQuyDoi, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(spGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)))))))
                .addGap(0, 0, 0))
        );
        pnlThanhToanLayout.setVerticalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addComponent(lblThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongTien)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiemQuyDoi)
                    .addComponent(txtDiemQuyDoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienGiam)
                    .addComponent(txtTienGiam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienTra)
                    .addComponent(txtTienTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienDua)
                    .addComponent(txtTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienThua)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGhiChu)
                    .addComponent(spGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pnlRight.add(pnlThanhToan, java.awt.BorderLayout.CENTER);

        pnlBody.add(pnlRight, java.awt.BorderLayout.EAST);

        add(pnlBody, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        // TODO add your handling code here:
        KhachHangPage khachHang = new KhachHangPage();
        AddContent.addContent(khachHang);
        khachHang.setPnlRightTrue();
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed
//
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:khang
    	LocalDateTime now = LocalDateTime.now();
    	entities.HoaDon hd = null;
    	if(dsHH.size()==0) {
    		JOptionPane.showMessageDialog(null,"Hóa đơn chưa có sản phẩm!","Cảnh báo", JOptionPane.WARNING_MESSAGE);
    		return;
    	}
    	if(!ktQuyDoi())
    		return;
    	if(!ktTienKhachDua())
    		return;
    	
    	int diemQuyDoi = 0;
    	if(!txtDiemQuyDoi.getText().replaceAll(",", "").equalsIgnoreCase(""))
    		diemQuyDoi = Integer.parseInt(txtDiemQuyDoi.getText().replaceAll(",", ""));
    	
    	double tienPhaiTra = Double.parseDouble(txtTienTra.getText().replaceAll(",", ""));
    	String ghiChu = txtGhiChu.getText();
    	double tienKhachDua = Double.parseDouble(txtTienDua.getText().replaceAll(",", ""));
		
		//Kiểm tra bán theo đơn
    	if(ckBBanTheoDon.isSelected()) {
    		if(nhapMaDonThuoc1.getText().isEmpty()) {
    			JOptionPane.showMessageDialog(null, "Nhập mã đơn thuốc!");
    			return;
    		}else {
    			DonThuoc dt = donThuocDao.layDonThuocTheoMa(nhapMaDonThuoc1.getText());
    	    	if(dt!=null) {
    	    		JOptionPane.showMessageDialog(null, "Đơn thuốc đã tồn tại!\nYêu cầu nhập đơn thuốc mới.", "Thông báo", JOptionPane.WARNING_MESSAGE);
    	    		nhapMaDonThuoc1.selectAll();
    	    		nhapMaDonThuoc1.requestFocus();
    	    	}
    	    	else {
    	    		donThuoc = new DonThuoc();
    	    		donThuoc.setMaDonThuoc(nhapMaDonThuoc1.getText());	
    			}
    		}
    	}
    	
    	
    	
    		
    		//Tạo đối tượng hóa đơn
    		try {
    			hd = new HoaDon(GeneratePK.getMaHD(), now, nhanVien, khachHang, tienKhachDua, diemQuyDoi,ghiChu, ca,TrangThaiHoaDon.HOAN_THANH,tienPhaiTra);
    			PdfWriterExample.writePdf(tableModel, hd);
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		//Thêm hóa đơn vào CSDL
    		kiemTraVaThemDonThuoc(hd);
    		themHoaDon(hd);
        	//Cập nhật điểm thưởng
        	if(khachHang!=null) {
        		int diemThuong = khachHang.getDiemThuong()+(int)(hd.getTongTien()/100)-diemQuyDoi;
            	khachHang.setDiemThuong(diemThuong);
            	updateKhachHang(khachHang);
        	}
    		
    	//Thêm chi tiết hóa đơn vào CSDL
    	for(int i =0;i<dsHH.size();i++) {
    		HangHoa hh = dsHH.get(i);
    		
    		//Thay đổi số lượng định mức trong hàng hóa
    		int soLuong = (int)tbChiTietHoaDon.getValueAt(i, 2);
    		DonViTinh donViTinh = donViTinhDao.layDVTTheoTenVaMaHangHoa(dsHH.get(i).getMaHangHoa(), tbChiTietHoaDon.getValueAt(i, 1).toString());    		
    		int soLuongBiTru = soLuong * donViTinh.getQuyDoi();
    		hh.setSoLuongDinhMuc(hh.getSoLuongDinhMuc()-soLuongBiTru);
    		boolean capNhatSL = hangHoaDao.capNhatSoLuongHangHoa(hh);
    		
    		//Thay đổi số lượng hàng hóa của lô hàng
    		List<LoHang> dsLoHang = loHangDAO.timLoHangTheoHangHoa(hh);
    		if (capNhatSL == true) {
				for (int j = 0; j < dsLoHang.size(); j++) {
					
					int ketQua = dsLoHang.get(j).getSoLuong() - soLuongBiTru;
					LoHang lo = dsLoHang.get(j);
					
					if (ketQua >= 0) {
						loHangDAO.capNhatSoLuongLoTheoMaHHVaSoLo(ketQua, hh, dsLoHang.get(j));
						chiTietHDDao.themChiTietHoaDon_LoHang(hd,donViTinh,dsLoHang.get(j),soLuongBiTru);
						break;
					}
					else {
						int soLuongConLai = lo.getSoLuong();
						while (soLuongConLai>=0) {
							
							soLuongConLai = soLuongConLai - donViTinh.getQuyDoi();
							
						}
						if (soLuongConLai - donViTinh.getQuyDoi() < 0) {
							soLuongConLai = soLuongConLai + donViTinh.getQuyDoi();
						}
						if (soLuongConLai != dsLoHang.get(j).getSoLuong()) {
							loHangDAO.capNhatSoLuongLoTheoMaHHVaSoLo(soLuongConLai, hh, dsLoHang.get(j));
							chiTietHDDao.themChiTietHoaDon_LoHang(hd,donViTinh,dsLoHang.get(j),dsLoHang.get(j).getSoLuong() - soLuongConLai);
						}
						soLuongBiTru = (soLuongBiTru - (dsLoHang.get(j).getSoLuong() - soLuongConLai)) ;
					}
				}
			}
    					
    		//Thêm chi tiết hóa đơn
    		double donGia =  donViTinh.getGiaBan();  
    		ChiTietHoaDon cthd = new ChiTietHoaDon(hd, soLuong, donGia, donViTinh);
			chiTietHDDao.addChiTietHD(cthd);
    	}
    	drop();
    	JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!");
    	//khangneae
		PrintExample.printContent();
    }//GEN-LAST:event_btnThanhToanActionPerformed

	private boolean kiemTraVaThemDonThuoc(HoaDon hd) {
	// TODO Auto-generated method stub
		if (donThuoc!=null) {
				donThuoc.setHoaDon(hd);
				
				return true;
		}
		return false;
}

	private boolean themHoaDon(HoaDon hd) {
	// TODO Auto-generated method stub
		return hoaDonDao.addHoaDon(hd);		
	}
	
	

	private void drop() {
		// TODO Auto-generated method stub
		tableModel.setRowCount(0);
		dsHH.clear();
		khachHang = null;
		timSDTKhachHang1.setText("");
		txtTenKH.setText("");
		txtSDTKH.setText("");
		txtDiemThuong.setText("");
		txtTongTien.setText("");
		txtDiemQuyDoi.setText("");
		txtTienGiam.setText("");
		txtTienTra.setText("");
		txtTienDua.setText("");
		txtTienThua.setText("");
		txtGhiChu.setText("");
		timMaSP1.setText("");
		timMaSP1.requestFocus();
		txtDiemQuyDoi.setEditable(false);
		ckBBanTheoDon.setSelected(false);
    	nhapMaDonThuoc1.setText("");
    	nhapMaDonThuoc1.setEditable(false);
	}

	private void updateKhachHang(KhachHang khach) {
		// TODO Auto-generated method stub
		khachHangDao.capNhatDiemKhachHang(khach);
	}

	private boolean ktQuyDoi() {
    	if(txtDiemQuyDoi.getText().replaceAll(",", "").equalsIgnoreCase(""))
    		return true;
    	try { 
    		double diemQD = Double.parseDouble(txtDiemQuyDoi.getText().replaceAll(",", ""));
    		double diemThuong = khachHang.getDiemThuong();
    		if(diemQD>diemThuong) {
    			JOptionPane.showMessageDialog(this, "Không đủ điểm!");
    			txtDiemQuyDoi.setText("");
    			txtTienGiam.setText("0");
    			return false;
    		}else if(diemQD%1000!=0) {
    			JOptionPane.showMessageDialog(this, "Điểm quy đổi phải chia hết cho 1000!");
    			txtDiemQuyDoi.setText("");
    			txtDiemQuyDoi.requestFocus();
    			txtTienGiam.setText("0");
    			return false;
    		}else if(diemQD>Double.parseDouble(txtTongTien.getText().replaceAll(",", ""))) {
    			JOptionPane.showMessageDialog(this, "Điểm quy đổi phải nhỏ hơn tổng tiền hàng!");
    			txtDiemQuyDoi.setText("");
    			txtDiemQuyDoi.requestFocus();
    			txtTienGiam.setText("0");
    			return false;
    		}else
    			txtTienGiam.setText(Formater.decimalFormat(diemQD));
    		updateTienPhaiTra();
			updateTienThua();
			return true;
		} catch (Exception e) {
			txtDiemQuyDoi.setText("");
			txtTienGiam.setText("0");
			updateTienPhaiTra();
			updateTienThua();
			return false;
		}
	}

	private void btnLuuTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuTamActionPerformed
        // TODO add your handling code here:
		LocalDateTime now = LocalDateTime.now();
    	entities.HoaDon hd = null;
    	if(dsHH.size()==0) {
    		JOptionPane.showMessageDialog(null,"Hóa đơn chưa có sản phẩm!","Cảnh báo", JOptionPane.WARNING_MESSAGE);
    		return;
    	}
    	String ghiChu = txtGhiChu.getText();
    	double tongTien = Double.parseDouble(txtTongTien.getText().replaceAll(",", ""));
		
		//Kiểm tra bán theo đơn
    	if(ckBBanTheoDon.isSelected()) {
    		if(nhapMaDonThuoc1.getText().isEmpty()) {
    			JOptionPane.showMessageDialog(null, "Nhập mã đơn thuốc!");
    			return;
    		}else {
    			DonThuoc dt = donThuocDao.layDonThuocTheoMa(nhapMaDonThuoc1.getText());
    	    	if(dt!=null) {
    	    		JOptionPane.showMessageDialog(null, "Đơn thuốc đã tồn tại!\nYêu cầu nhập đơn thuốc mới.", "Thông báo", JOptionPane.WARNING_MESSAGE);
    	    		nhapMaDonThuoc1.selectAll();
    	    		nhapMaDonThuoc1.requestFocus();
    	    	}
    	    	else {
    	    		donThuoc = new DonThuoc();
    	    		donThuoc.setMaDonThuoc(nhapMaDonThuoc1.getText());	
    			}
    		}
    	}
    	
    		//Tạo đối tượng hóa đơn
    		try {
    			hd = new HoaDon(GeneratePK.getMaHD(), now, nhanVien, khachHang, 0, 0,ghiChu, ca,TrangThaiHoaDon.THEM_TAM,tongTien);
    			PdfWriterExample.writePdf(tableModel, hd);
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		//Thêm hóa đơn vào CSDL
    		kiemTraVaThemDonThuoc(hd);
    		themHoaDon(hd);
        	//Cập nhật điểm thưởng
        
    		
    	//Thêm chi tiết hóa đơn vào CSDL
    	for(int i =0;i<dsHH.size();i++) {
    		HangHoa hh = dsHH.get(i);
    		
    		//Thay đổi số lượng định mức trong hàng hóa
    		int soLuong = (int)tbChiTietHoaDon.getValueAt(i, 2);
    		DonViTinh donViTinh = donViTinhDao.layDVTTheoTenVaMaHangHoa(dsHH.get(i).getMaHangHoa(), tbChiTietHoaDon.getValueAt(i, 1).toString());    		
    		int soLuongBiTru = soLuong * donViTinh.getQuyDoi();
    		hh.setSoLuongDinhMuc(hh.getSoLuongDinhMuc()-soLuongBiTru);
    		boolean capNhatSL = hangHoaDao.capNhatSoLuongHangHoa(hh);
    		
    		//Thay đổi số lượng hàng hóa của lô hàng
    		List<LoHang> dsLoHang = loHangDAO.timLoHangTheoHangHoa(hh);
    		if (capNhatSL == true) {
				for (int j = 0; j < dsLoHang.size(); j++) {
					
					int ketQua = dsLoHang.get(j).getSoLuong() - soLuongBiTru;
					LoHang lo = dsLoHang.get(j);
					
					if (ketQua >= 0) {
						loHangDAO.capNhatSoLuongLoTheoMaHHVaSoLo(ketQua, hh, dsLoHang.get(j));
						chiTietHDDao.themChiTietHoaDon_LoHang(hd,donViTinh,dsLoHang.get(j),soLuongBiTru);
						break;
					}
					else {
						int soLuongConLai = lo.getSoLuong();
						while (soLuongConLai>=0) {
							
							soLuongConLai = soLuongConLai - donViTinh.getQuyDoi();
							
						}
						if (soLuongConLai - donViTinh.getQuyDoi() < 0) {
							soLuongConLai = soLuongConLai + donViTinh.getQuyDoi();
						}
						if (soLuongConLai != dsLoHang.get(j).getSoLuong()) {
							loHangDAO.capNhatSoLuongLoTheoMaHHVaSoLo(soLuongConLai, hh, dsLoHang.get(j));
							chiTietHDDao.themChiTietHoaDon_LoHang(hd,donViTinh,dsLoHang.get(j),dsLoHang.get(j).getSoLuong() - soLuongConLai);
						}
						soLuongBiTru = (soLuongBiTru - (dsLoHang.get(j).getSoLuong() - soLuongConLai)) ;
					}
				}
			}
    					
    		//Thêm chi tiết hóa đơn
    		double donGia =  donViTinh.getGiaBan();  
    		ChiTietHoaDon cthd = new ChiTietHoaDon(hd, soLuong, donGia, donViTinh);
			chiTietHDDao.addChiTietHD(cthd);
    	}
    	drop();
    	JOptionPane.showMessageDialog(null, "Tạo hóa đơn tạm thành công!");
    }//GEN-LAST:event_btnLuuTamActionPerformed

    private void txtDiemQuyDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiemQuyDoiActionPerformed
        // TODO add your handling code here:
    	ktQuyDoi();
    }//GEN-LAST:event_txtDiemQuyDoiActionPerformed

    private void txtTienDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienDuaActionPerformed
        // TODO add your handling code here:
    	ktTienKhachDua();
    	
    }//GEN-LAST:event_txtTienDuaActionPerformed

    private boolean ktTienKhachDua() {
		// TODO Auto-generated method stub
    	double tienKhachDua = 0;
    	if(txtTienTra.getText().equalsIgnoreCase(""))
    		return false;
    	try {
			tienKhachDua = Double.parseDouble(txtTienDua.getText().replaceAll(",", ""));
			double tienPhaiTra = Double.parseDouble(txtTienTra.getText().replaceAll(",", ""));
			if(tienKhachDua<tienPhaiTra) {
				JOptionPane.showMessageDialog(null,"Tiền khách đưa phải lớn hơn hoặc bằng tiền phải trả!","Cảnh báo", JOptionPane.WARNING_MESSAGE);
				txtTienDua.requestFocus();
				updateTienThua();
				return false;
			}else {
				txtTienDua.setText(Formater.decimalFormat(tienKhachDua));
				updateTienThua();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Tiền khách đưa phải lớn hơn hoặc bằng tiền phải trả!","Cảnh báo", JOptionPane.WARNING_MESSAGE);
			txtTienDua.requestFocus();
			updateTienThua();
			return false;
		}
	}

	private void txtGhiChuAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtGhiChuAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuAncestorAdded

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void timMaSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timMaSP1ActionPerformed
        // TODO add your handling code here:
    	//Khang
    	entities.HangHoa hangHoa = null;
    	DonViTinh donVi = null;
    	try {
    		hangHoa = hangHoaDao.timHangHoaTheoMaVachVaMaHH(timMaSP1.getText());
    		donVi = donViTinhDao.layDVTTheoMa(timMaSP1.getText());

		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
    	if(hangHoa!=null && donVi.getTrangThaiDonViTinh().equals(TrangThaiDonViTinh.DANG_BAN)) { //Tìm thấy hàng hóa
    		if(hangHoa.getSoLuongDinhMuc()==0) {//Kiểm tra số lượng
    			JOptionPane.showMessageDialog(null,"Hàng hóa không đủ số lượng","Cảnh báo", JOptionPane.WARNING_MESSAGE);
    			timMaSP1.setText("");
    			timMaSP1.requestFocus();
    			return;
    		}	
    		int soLuong = 1;
        	for(int i=0;i<tableModel.getRowCount();i++) {//Kiểm tra hh đã có trong table chưa
        		if(tableModel.getValueAt(i, 0).toString().equals(hangHoa.getTenHangHoa()) && (donVi.getTenDonViTinh().equals(tableModel.getValueAt(i, 1).toString()))) {//HH đã có trong table
        			soLuong = ((int)tableModel.getValueAt(i, 2))+1;//Tăng số lượng lên 1
        			if(soLuong>hangHoa.getSoLuongDinhMuc()) {//Kiểm tra số lượng DM
        				JOptionPane.showMessageDialog(null,"Hàng hóa không đủ số lượng","Cảnh báo", JOptionPane.WARNING_MESSAGE);
        				soLuong = hangHoa.getSoLuongDinhMuc();
        			}
        			tableModel.setValueAt(soLuong, i, 2);//cập nhật sl
        			reload();
        			timMaSP1.setText("");
        			timMaSP1.requestFocus();
        			return;
        		}

        	}
        	//Thêm mới
        	//List<DonViTinh> dsDVT = doDuLieuVaoComboBoxDonViTinh(hangHoa);
        	dsHH.add(hangHoa);//Thêm vào dsHH
        	double giaBan = donVi.getGiaBan();
        	double thanhTien = soLuong * giaBan;
        	tableModel.addRow(new Object[] {hangHoa.getTenHangHoa(), donVi.getTenDonViTinh(),soLuong,Formater.decimalFormat(giaBan),Formater.decimalFormat(thanhTien)});
        	reload();
    	}
    	else//Không tìm thấy HH
    		JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm tương ứng!");
    	timMaSP1.setText("");
		timMaSP1.requestFocus();
    	
    	
    }//GEN-LAST:event_timMaSP1ActionPerformed

    private void timSDTKhachHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timSDTKhachHang1ActionPerformed
        // TODO add your handling code here:
    	khachHang = khachHangDao.layKhachHangTheoSDT(timSDTKhachHang1.getText());
			if (khachHang != null) {
        		txtTenKH.setText(khachHang.getTenKhachHang());
        		txtSDTKH.setText(khachHang.getSoDienThoai());
        		String diem = String.valueOf(khachHang.getDiemThuong());
        		txtDiemThuong.setText(diem);
        		timSDTKhachHang1.setText("");
        		txtDiemQuyDoi.setEditable(true);
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng!");
    			timSDTKhachHang1.selectAll();
    			timSDTKhachHang1.requestFocus();
    			txtTenKH.setText("");
    			txtSDTKH.setText("");
    			txtDiemThuong.setText("");
    			khachHang = null;
			} 
//    	else {
//			JOptionPane.showConfirmDialog(this, "Yêu cầu nhập số điện thoại!", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
//		}
    	
    }//GEN-LAST:event_timSDTKhachHang1ActionPerformed

    private void nhapMaDonThuoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapMaDonThuoc1ActionPerformed
        // TODO add your handling code here:
    	
    }//GEN-LAST:event_nhapMaDonThuoc1ActionPerformed

    private void ckBBanTheoDonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckBBanTheoDonItemStateChanged
        // TODO add your handling code here:
    	if (evt.getSource() == ckBBanTheoDon) {
    		if (ckBBanTheoDon.isSelected()) {
    			nhapMaDonThuoc1.setEditable(true);;
    			nhapMaDonThuoc1.requestFocus();
			}
			else {
				nhapMaDonThuoc1.setText("");
				nhapMaDonThuoc1.setEditable(false);
			}
		}
    }//GEN-LAST:event_ckBBanTheoDonItemStateChanged

    private void cbChonDonThuocMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChonDonThuocMauActionPerformed
        // TODO add your handling code here:
    	if(cbChonDonThuocMau.getSelectedIndex()==0)return;
    	
    	themDonThuocMauVaoChiTietHD(cbChonDonThuocMau.getSelectedIndex()-1);
    }//GEN-LAST:event_cbChonDonThuocMauActionPerformed

    private void moveBHPage(BanHangPage bh,int num) {//Hàm copy header
    	bh.pnl1.setVisible(pnl1.isVisible());
    	bh.pnl2.setVisible(pnl2.isVisible());
    	bh.pnl3.setVisible(pnl3.isVisible());
    	bh.pnl4.setVisible(pnl4.isVisible());
    	bh.pnl5.setVisible(pnl5.isVisible());
    	
    	bh.hdCount = hdCount;
    	bh.lblSpace.setPreferredSize(lblSpace.getPreferredSize());
    	bh.timMaSP1.requestFocus();
    	if(num==1)
    		bh.setBorderHD(bh.pnl1);
    	else if(num==2)
    		bh.setBorderHD(bh.pnl2);
    	else if(num==3)
    		bh.setBorderHD(bh.pnl3);
    	else if(num==4)
    		bh.setBorderHD(bh.pnl4);
    	else if(num==5)
    		bh.setBorderHD(bh.pnl5);
    	
    	PnlBanHang.current = num;
    	AddContent.addContent(bh);
    }
    private void dropBorder() {
    	pnl1.setBorder(null);
    	pnl2.setBorder(null);
    	pnl3.setBorder(null);
    	pnl4.setBorder(null);
    	pnl5.setBorder(null);
    	
    }
    private void setBorderHD(JPanel pnl) {
    	dropBorder();
    	pnl.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
    	
    }
    private void lbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl1MouseClicked
        // TODO add your handling code here:111
        if(pnl1.getBorder()==null)
        moveBHPage(PnlBanHang.bh1,1);
    }//GEN-LAST:event_lbl1MouseClicked
    
    private void removeHDPage(JPanel pnl, int num) {
    	if(hdCount==1)return;
    	if(num==1)
    		PnlBanHang.bh1.drop();
    	else if(num==2)
    		PnlBanHang.bh2.drop();
    	else if(num==3)
    		PnlBanHang.bh3.drop();
    	else if(num==4)
    		PnlBanHang.bh4.drop();
    	else if(num==5)
    		PnlBanHang.bh5.drop();
    	
    	pnl.setVisible(false);
    	lblSpace.setPreferredSize(new Dimension(lblSpace.getWidth()+155,lblSpace.getHeight()));
    	hdCount--;
    	if(pnl.getBorder()!=null) {
    		if(pnl1.isVisible()) {
    			setBorderHD(pnl1);
    			moveBHPage(PnlBanHang.bh1, 1);
    			return;
    		}else if(pnl2.isVisible()) {
    			setBorderHD(pnl2);
    			moveBHPage(PnlBanHang.bh2, 2);
    			return;
    		}else if(pnl3.isVisible()) {
    			setBorderHD(pnl3);
    			moveBHPage(PnlBanHang.bh3, 3);
    			return;
    		}else if(pnl4.isVisible()) {
    			setBorderHD(pnl4);
    			moveBHPage(PnlBanHang.bh4, 4);
    			return;
    		}else if(pnl5.isVisible()) {
    			setBorderHD(pnl5);
    			moveBHPage(PnlBanHang.bh5, 5);
    			return;
    		}
    	}
    		
    }
    
    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        removeHDPage(pnl1,1);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        removeHDPage(pnl2,2);
    }//GEN-LAST:event_btn2ActionPerformed

    private void lbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2MouseClicked
        // TODO add your handling code here:
        if(pnl2.getBorder()==null)
        moveBHPage(PnlBanHang.bh2,2);
    }//GEN-LAST:event_lbl2MouseClicked

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        removeHDPage(pnl3,3);
    }//GEN-LAST:event_btn3ActionPerformed

    private void lbl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3MouseClicked
        // TODO add your handling code here:
        if(pnl3.getBorder()==null)
        moveBHPage(PnlBanHang.bh3,3);
    }//GEN-LAST:event_lbl3MouseClicked

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        removeHDPage(pnl4,4);
    }//GEN-LAST:event_btn4ActionPerformed

    private void lbl4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl4MouseClicked
        // TODO add your handling code here:
        if(pnl4.getBorder()==null)
        moveBHPage(PnlBanHang.bh4,4);
    }//GEN-LAST:event_lbl4MouseClicked

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:111
        removeHDPage(pnl5,5);

    }//GEN-LAST:event_btn5ActionPerformed

    private void lbl5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl5MouseClicked
        // TODO add your handling code here:
        if(pnl5.getBorder()==null)
        moveBHPage(PnlBanHang.bh5,5);
    }//GEN-LAST:event_lbl5MouseClicked
    private boolean themHDPage(boolean temp, JPanel pnl) {
    	if(!(pnl.isVisible()||temp)) {
			pnl.setVisible(true);
			temp = true;
			lblSpace.setPreferredSize(new Dimension(lblSpace.getWidth()-155,lblSpace.getHeight()));
			hdCount++;
			return temp;
		}
    	return temp;
    }
    private void btnThemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHoaDonActionPerformed
        // TODO add your handling code here:111
        boolean temp = false;
        temp = themHDPage(temp, pnl1);
        if(temp)return;
        temp =themHDPage(temp, pnl2);
        if(temp)return;
        temp =themHDPage(temp, pnl3);
        if(temp)return;
        temp =themHDPage(temp, pnl4);
        if(temp)return;
        temp =themHDPage(temp, pnl5);
        

    }//GEN-LAST:event_btnThemHoaDonActionPerformed
    
    private void themDonThuocMauVaoChiTietHD(int vt) {
    	List<DonThuocMau> dsDTM = donThuocMauDao.getDonThuocMau();
		DonThuocMau dtm = dsDTM.get(vt);
		List<ChiTietDonThuocMau> dsCTDTM = chiTietDTMDAO.layChiTietDTMTheoMaDTM(dtm);
		for (int i = 0; i < dsCTDTM.size(); i++) {
			if(dsCTDTM.get(i).getDonViTinh().getHangHoa()!=null && dsCTDTM.get(i).getDonViTinh().getTrangThaiDonViTinh().equals(TrangThaiDonViTinh.DANG_BAN)) { //Tìm thấy hàng hóa
	    		if(dsCTDTM.get(i).getDonViTinh().getHangHoa().getSoLuongDinhMuc()==0) {//Kiểm tra số lượng
	    			JOptionPane.showMessageDialog(null,"Hàng hóa không đủ số lượng","Cảnh báo", JOptionPane.WARNING_MESSAGE);
	    			return;
	    		}	
	    		int soLuong = 1;
	    		boolean temp = false;
	        	for(int j=0;j<tableModel.getRowCount();j++) {//Kiểm tra hh đã có trong table chưa
	        		if(tableModel.getValueAt(j, 0).toString().equals(dsCTDTM.get(i).getDonViTinh().getHangHoa().getTenHangHoa()) && (dsCTDTM.get(i).getDonViTinh().getTenDonViTinh().equals(tableModel.getValueAt(j, 1).toString()))) {//HH đã có trong table
	        			soLuong = ((int)tableModel.getValueAt(j, 2))+dsCTDTM.get(i).getSoLuong();//Tăng số lượng lên 1
	        			if(soLuong>dsCTDTM.get(i).getDonViTinh().getHangHoa().getSoLuongDinhMuc()) {//Kiểm tra số lượng DM
	        				JOptionPane.showMessageDialog(null,"Hàng hóa không đủ số lượng","Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        				soLuong = dsCTDTM.get(i).getDonViTinh().getHangHoa().getSoLuongDinhMuc();
	        			}
	        			tableModel.setValueAt(soLuong, j, 2);//cập nhật sl
	        			reload();
	        			timMaSP1.setText("");
	        			timMaSP1.requestFocus();
	        			temp = true;
	        		}

	        	}
	        	//Thêm mới
	        	if(!temp) {
	        	dsHH.add(dsCTDTM.get(i).getDonViTinh().getHangHoa());//Thêm vào dsHH
	        	double giaBan = dsCTDTM.get(i).getDonViTinh().getGiaBan();
	        	double thanhTien = dsCTDTM.get(i).getSoLuong() * giaBan;
	        	tableModel.addRow(new Object[] {dsCTDTM.get(i).getDonViTinh().getHangHoa().getTenHangHoa(), dsCTDTM.get(i).getDonViTinh().getTenDonViTinh(),dsCTDTM.get(i).getSoLuong(),Formater.decimalFormat(giaBan),Formater.decimalFormat(thanhTien)});
	        	reload();
	        	}
	    	}
		} 	
	}
    
    public void reload() {
    	double tongTien = capNhatThanhTien(); //thanhtien của tất cả cthd
    	double tienGiam = 0;
    	if(!txtTienGiam.getText().replaceAll(",", "").equalsIgnoreCase(""))
    		tienGiam = Double.parseDouble(txtTienGiam.getText().replaceAll(",", ""));
    	txtTongTien.setText(Formater.decimalFormat(tongTien));//Cập nhật thành tiền của từng cthd và tổng tiền
    	double tienPhaiTra = updateTienPhaiTra();
    	txtTienTra.setText(Formater.decimalFormat(tienPhaiTra));
    	double tienKhachDua = 0;
    	if(!txtTienDua.getText().replaceAll(",", "").equalsIgnoreCase(""))
    			tienKhachDua = Double.parseDouble(txtTienDua.getText().replaceAll(",", ""));
    	double tienThua = updateTienThua();
    	txtTienThua.setText(Formater.decimalFormat(tienThua));
    }
    
    private double updateTienThua() {
		// TODO Auto-generated method stub
    	double tienThua = 0;
    	try {
			double tienKD = Double.parseDouble(txtTienDua.getText().replaceAll(",", ""));
			double tienPT = Double.parseDouble(txtTienTra.getText().replaceAll(",", ""));
			tienThua = tienKD-tienPT;
			if(tienThua<0) {
				txtTienThua.setText("0");
				return 0;
			}else {
				txtTienThua.setText(Formater.decimalFormat(tienThua));
				return tienThua;
			}
		} catch (Exception e) {
			// TODO: handle exception
			txtTienThua.setText(Formater.decimalFormat(tienThua));
			return tienThua;
		}
	}

	private double updateTienPhaiTra() {
		// TODO Auto-generated method stub
    	double tienHang = 0;
		try {
			tienHang = Double.parseDouble(txtTongTien.getText().replaceAll(",", ""));
			double tienGiam = Double.parseDouble(txtTienGiam.getText().replaceAll(",", ""));
			double tienPhaiTra = tienHang-tienGiam;
			if(tienPhaiTra<0)
				tienPhaiTra = 0;
			else tienPhaiTra = roundToNearest500(tienPhaiTra);//Làm tròn 
			txtTienTra.setText(Formater.decimalFormat(tienPhaiTra));
			return tienPhaiTra;
		} catch (Exception e) {
			// TODO: handle exception
			txtTienTra.setText(Formater.decimalFormat(roundToNearest500(tienHang)));
			return tienHang;
		}
	}

	public double roundToNearest500(double number) {
        // Chia số ban đầu cho 500
    	double quotient = number / 500;
        // Làm tròn kết quả chia
    	double roundedQuotient = Math.round(quotient);
        // Nhân kết quả tròn với 500
    	double roundedNumber = roundedQuotient * 500;
        return roundedNumber;
    }

	private double capNhatThanhTien() {
    	// TODO Auto-generated method stub
    	double tongTien = 0;
    	for(int i=0;i<tableModel.getRowCount();i++) {
    		String thanhTienS = tableModel.getValueAt(i, 3).toString().replaceAll(",", "");
    		double thanhTien = (int)tableModel.getValueAt(i, 2)*Double.parseDouble(thanhTienS);
    		tableModel.setValueAt(Formater.decimalFormat(thanhTien), i, 4);
    		tongTien+=thanhTien;
    	}
    	return tongTien;
	}

	//Them don thuoc mau
    public List<DonThuocMau> themDonThuocMau() {
    		List<DonThuocMau> dsDonThuocMau = donThuocMauDao.getDonThuocMau();
    		dsDonThuocMau.forEach(donTM -> cbChonDonThuocMau.addItem(donTM.getTenDonThuocMau()));
    		return dsDonThuocMau;
    }
    
    //Them du lieu don vi tinh vao ComboBox
    public List<DonViTinh> doDuLieuVaoComboBoxDonViTinh(HangHoa hangHoa) {
		List<DonViTinh> dsDonViTinh = donViTinhDao.timDVTTheoMaHH(hangHoa.getMaHangHoa());
		JComboBox cbDonViTinh = new JComboBox();
//		dsDonViTinh.forEach(donVi -> cbDonViTinh.addItem(donVi.getTenDonViTinh()));
		for (int i = 0; i < dsDonViTinh.size(); i++) {
			DonViTinh dvt = dsDonViTinh.get(i);
			if (dvt.getTrangThaiDonViTinh().equals(TrangThaiDonViTinh.DANG_BAN)) {
				cbDonViTinh.addItem(dvt.getTenDonViTinh());
			}
		}
		tbChiTietHoaDon.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(cbDonViTinh));
		return dsDonViTinh;
    }
    
    public void updateTime() {
   	 // Tạo và khởi chạy một luồng để cập nhật thời gian liên tục
    	Thread updateTimeThread = new Thread(() -> {
            try {
                while (true) {
                	LocalDateTime now = LocalDateTime.now();
                    
                    // Định dạng thời gian
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
                    
                    // Chuyển đổi LocalDateTime thành chuỗi theo định dạng mong muốn
                    String formattedDateTime = now.format(formatter);
                    txtTimer.setText(formattedDateTime); // Cập nhật thời gian
                    Thread.sleep(1000); // Ngủ 1 giây
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        updateTimeThread.start(); // Bắt đầu luồng

       
   }
    
    private void phimTat() {
    	// Tạo một Action và gán chức năng khi nhấn phím 
    	Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
          	  if(tbChiTietHoaDon.getSelectedRow()!=-1)
          		tableModel.removeRow(tbChiTietHoaDon.getSelectedRow());
            }
        };
        Action action2 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
          	  timMaSP1.requestFocus();
          	  timMaSP1.setText("");
            }
        };
     // Gắn hành động với phím tắt 
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "performF11Action");
        this.getActionMap().put("performF11Action", action);
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "performF4Action");
        this.getActionMap().put("performF4Action", action2);
		
	}
    
    public void setTable() {
    	
    	tbChiTietHoaDon.setModel(tableModel);
    	TableColumn column1 = tbChiTietHoaDon.getColumnModel().getColumn(0);
        column1.setPreferredWidth(200);
        TableColumn column5 = tbChiTietHoaDon.getColumnModel().getColumn(5);
        column5.setPreferredWidth(5);
    	TableColumn column = tbChiTietHoaDon.getColumnModel().getColumn(2);
        column.setCellEditor(new SpinnerEditor());
        TableActionEvent event = new TableActionEvent() {
			
			@Override
			public void onDelete(int row) {
				if(tbChiTietHoaDon.isEditing()) {
					tbChiTietHoaDon.getCellEditor().stopCellEditing();
				}
				DefaultTableModel model = (DefaultTableModel)tbChiTietHoaDon.getModel();
				model.removeRow(row);
				dsHH.remove(row);
				reload();
				
			}
		};
        tbChiTietHoaDon.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        tbChiTietHoaDon.getColumnModel().getColumn(5).setCellRenderer(new ButtonRender());
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {//Bắt sự kiện thay đổi số lượng và đơn vị tính trên jtable
                try {
                	if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 2) {
                    	int row = tbChiTietHoaDon.getSelectedRow();
                    	if(row==-1)return; //Trường hợp sl thay đổi khi thêm mới 
                    	int soLuong = Integer.parseInt(tbChiTietHoaDon.getValueAt(row, 2).toString());
                		DonViTinh donViTinh = donViTinhDao.layDVTTheoTenVaMaHangHoa(dsHH.get(row).getMaHangHoa(), tbChiTietHoaDon.getValueAt(row, 1).toString());    		
                		int soLuongSauQuyDoi = soLuong*donViTinh.getQuyDoi();
                		
                       if(soLuongSauQuyDoi>dsHH.get(row).getSoLuongDinhMuc()) {//Kiểm tra số lượng
                    	   JOptionPane.showMessageDialog(null,"Hàng hóa không đủ số lượng","Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    	   //Cập nhật số lượng = sl định mức
                    	   int soLuongToiDa = dsHH.get(row).getSoLuongDinhMuc()/donViTinh.getQuyDoi();
                    	   tbChiTietHoaDon.setValueAt(soLuongToiDa, row,2);
                    	   
                       }
                       reload();
                	}
                	else if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 1) {
                    		int row = tbChiTietHoaDon.getSelectedRow();
                        	if(row==-1)return; //Trường hợp sl thay đổi khi thêm mới 
                        	int soLuong = Integer.parseInt(tbChiTietHoaDon.getValueAt(row, 2).toString());
                        	DonViTinh donViTinh = null;
                        	try {
                    			donViTinh = donViTinhDao.layDVTTheoTenVaMaHangHoa(dsHH.get(row).getMaHangHoa(), tbChiTietHoaDon.getValueAt(row, 1).toString());    	
							} catch (Exception e2) {
								// TODO: handle exception
								return;
							}		
                    		int soLuongSauQuyDoi = soLuong*donViTinh.getQuyDoi();
                    		
                    		if(soLuongSauQuyDoi>dsHH.get(row).getSoLuongDinhMuc()) {//Kiểm tra số lượng
                    			JOptionPane.showMessageDialog(null,"Hàng hóa không đủ số lượng","Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    			//Cập nhật số lượng = sl định mức
                    			int soLuongToiDa = dsHH.get(row).getSoLuongDinhMuc()/donViTinh.getQuyDoi();
                    			tbChiTietHoaDon.setValueAt(soLuongToiDa, row,2);  
                    		}
        					double giaBan = donViTinh.getGiaBan();
        					tbChiTietHoaDon.setValueAt(giaBan, row, 3);
        					reload();
                	}
				} catch (Exception e2) {
					// TODO: handle exception
					return;
				}

				}
        });
        
//        
        tbChiTietHoaDon.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
//				if(tbChiTietHoaDon.isEditing()) {
//					tbChiTietHoaDon.getCellEditor().stopCellEditing();
//				}
//				
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
				int row = tbChiTietHoaDon.getSelectedRow();
				try {
					List<DonViTinh> dvt = doDuLieuVaoComboBoxDonViTinh(dsHH.get(row));
				} catch (Exception e2) {
					// TODO: handle exception
					return;
				}
				//System.out.println(dvt);
			}
		});
        
    }
    
    
    
    
    private int hdCount = 1;
    String headerString[] = "Tên sản phẩm;Đơn vị tính;Số lượng;Giá bán;Thành tiền; ".split(";");
    private DefaultTableModel tableModel = new DefaultTableModel(headerString,0);
    private List<HangHoa> dsHH = new ArrayList<>();
    private HangHoaDao hangHoaDao;
    private HoaDonDao hoaDonDao;
    private DonViTinhDao donViTinhDao;
    private KhachHang_DAO khachHangDao;
    private DonThuocMauDao donThuocMauDao;
    private Ca_DAO caDao;
    private LoHangDao loHangDAO;
    private ChiTietHoaDonDao chiTietHDDao;
	private DonThuoc donThuoc = null;
	private DonThuoc_DAO donThuocDao;
	private ChiTietDonThuocMau_DAO chiTietDTMDAO;
    private KhachHang khachHang = null;
    private NhanVien nhanVien = LoginInfo.nhanVien;
    private Ca ca = LoginInfo.ca;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btnLuuTam;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemHoaDon;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JComboBox<String> cbChonDonThuocMau;
    private javax.swing.JCheckBox ckBBanTheoDon;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbLapHD;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lblDiemQuyDoi;
    private javax.swing.JLabel lblDiemThuong;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblPhimTat;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblSpace;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblTienDua;
    private javax.swing.JLabel lblTienGiam;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTienTra;
    private javax.swing.JLabel lblTongTien;
    private sampleUi.NhapMaDonThuoc nhapMaDonThuoc1;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JPanel pnl5;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlThanhToan;
    private javax.swing.JPanel pnlThongTinKhachHang;
    private javax.swing.JScrollPane spGhiChu;
    private javax.swing.JTable tbChiTietHoaDon;
    private sampleUi.TimMaSP timMaSP1;
    private sampleUi.TimSDTKhachHang timSDTKhachHang1;
    private javax.swing.JTextField txtDiemQuyDoi;
    private javax.swing.JTextField txtDiemThuong;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtSDTKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTienDua;
    private javax.swing.JTextField txtTienGiam;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTienTra;
    private javax.swing.JTextField txtTimer;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
