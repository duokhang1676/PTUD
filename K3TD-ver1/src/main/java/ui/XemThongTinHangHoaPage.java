/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import components.AddContent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import components.ButtonColumnUtil;
import components.ButtonRender;
import components.FormatJtable;
import components.ResizeContent;
import components.SpinnerEditor;
import components.TableActionCellEditor;
import components.TableActionEvent;
import dao.DonViTinhDao;
import dao.HangHoaDao;
import dao.NhomHangDao;
import entities.DonViTinh;
import entities.HangHoa;
import entities.LoaiHang;
import entities.NhomHang;
import entities.TrangThaiDonViTinh;
import entities.TrangThaiHangHoa;

/**
 *
 * @author Admin
 */
public class XemThongTinHangHoaPage extends javax.swing.JPanel {

	private NhomHangDao nhomHang_dao;
	private HangHoaDao hangHoa_dao;
	protected static DefaultTableModel model_DVT;
	protected static JTable tbl_DVT;
	private List<NhomHang> dsNhomHang;
	private int stt = 2;
	private DonViTinhDao donViTinh_dao;
	private JComboBox<String> cb_trangThaiDVT;
	protected static JComboBox<Object> cb_tenDVT;

	/**
	 * Creates new form TaoHangHoa2
	 */
	public XemThongTinHangHoaPage() {
		initComponents();
		ResizeContent.resizeContent(this);
		loadDataLoaiHang();
		loadDataNhomHang();
		addTableDVT();
		setTable();

	}
	public void setTable() {
    	TableColumn column = tbl_DVT.getColumnModel().getColumn(2);
        column.setCellEditor(new SpinnerEditor());
        TableActionEvent event = new TableActionEvent() {
			
			@Override
			public void onDelete(int row) {
				if(tbl_DVT.isEditing()) {
					tbl_DVT.getCellEditor().stopCellEditing();
				}
				DefaultTableModel model = (DefaultTableModel)tbl_DVT.getModel();
				if (model.getRowCount() > 1) {
					model.removeRow(row);
				}
				
				reload();
				
			}

			
		};
//		tbl_DVT.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
//		tbl_DVT.getColumnModel().getColumn(6).setCellRenderer(new ButtonRender());
        
		model_DVT.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {//Bắt sự kiện thay đổi số lượng trên jtable
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 6) {
                	int row = tbl_DVT.getSelectedRow();
                	if(row==-1)return; //Trường hợp sl thay đổi khi thêm mới 
                	
                   
                   reload();
                }
            }	
        });
    }

    private void reload() {
		// TODO Auto-generated method stub
		
	}

	private void addTableDVT() {
		// TODO Auto-generated method stub
		String[] colNames = { "STT", "Tên đơn vị tính", "Quy đổi", "Giá bán", "Mã vạch", "Bán hàng","" };

		model_DVT = new DefaultTableModel(colNames, 0);
		tbl_DVT = new JTable(model_DVT);
		FormatJtable.setFontJtable(tbl_DVT);
		JScrollPane js_tableHangHoa = new JScrollPane(tbl_DVT);

		if (tbl_DVT.getColumnModel().getColumnCount() > 0) {
			tbl_DVT.getColumnModel().getColumn(0).setResizable(false);
			tbl_DVT.getColumnModel().getColumn(1).setResizable(false);
			tbl_DVT.getColumnModel().getColumn(2).setResizable(false);
			tbl_DVT.getColumnModel().getColumn(3).setResizable(false);
			tbl_DVT.getColumnModel().getColumn(4).setResizable(false);
			tbl_DVT.getColumnModel().getColumn(5).setResizable(false);
			tbl_DVT.getColumnModel().getColumn(6).setResizable(false);
		}

		tbl_DVT.getColumnModel().getColumn(0).setPreferredWidth(50);
		cb_tenDVT = new JComboBox<>();
//        loadDataTenDVT();
		String[] tenDVT = { "Hộp", "Vĩ", "Viên", "Chai", "Bánh", "Lọ", "Tuýp" };
		for (String s : tenDVT) {
			cb_tenDVT.addItem(s);
		}
		tbl_DVT.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(cb_tenDVT));
		cb_trangThaiDVT = new JComboBox<String>();
		cb_trangThaiDVT.addItem("Đang bán");
		cb_trangThaiDVT.addItem("Ngừng bán");
		tbl_DVT.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(cb_trangThaiDVT));
		Object[] emptyRow = { 1, null, null, 0, "MV*****", "Đang bán" };
		model_DVT.addRow(emptyRow);
		JTableHeader headerTable = tbl_DVT.getTableHeader();
		headerTable.setPreferredSize(new Dimension(headerTable.getPreferredSize().width, 40));
		headerTable.setBackground(Color.white);
		tbl_DVT.setRowHeight(40);

//		setCellEditable();
		this.add(js_tableHangHoa, BorderLayout.CENTER);

//        tbl_DVT.addMouseListener(this);
		model_DVT.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if (e.getType() == TableModelEvent.UPDATE || e.getType() == TableModelEvent.INSERT
						|| e.getType() == TableModelEvent.DELETE) {
					int row = e.getFirstRow();
					int col = e.getColumn();
					if (col == 2) {
						for (int i = 1; i < tbl_DVT.getRowCount(); i++) {
							int quyDoi = Integer.parseInt(model_DVT.getValueAt(1, 2).toString());
							if (quyDoi == 1) {
								showMessage("Đã có đơn vị tính có quy đổi bằng 1!");
							}
						}
					}
					if (col == 3) {
						String giaBanStr = model_DVT.getValueAt(row, 3).toString();
						try {
							double giaBan = Double.parseDouble(giaBanStr);
							if (giaBan < 0) {
								showMessage("Giá bán phải lớn hơn 0!");
							}

						} catch (Exception e2) {
							// TODO: handle exception
							showMessage("Giá bán phải nhập số!");
						}

					}

					if (col == 4) {
						String maVach = model_DVT.getValueAt(row, 4).toString();
						System.out.println(maVach);
						if (maVach.matches("^MV[0-9]{5}")) {
//							DonViTinh dvt = donViTinh_dao.timDVTTheoMaVach(maVach);

//							if (dvt == null) {
							for (int i = 1; i < tbl_DVT.getRowCount(); i++) {
								System.out.println(model_DVT.getValueAt(i, 4).toString());
								if (model_DVT.getValueAt(i, 4).toString().equals(maVach)) {
									showMessage("Mã vạch " + maVach + " đã tồn tại!");
								}
							}
//							}else {
//								showMessage("Mã vạch "+maVach+" đã tồn tại!");
//							}
						} else {
							showMessage("Mã vạch phải theo định dạng: MV*****, với * là một số từ 0 đến 9!");
						}
					}
				}
			}
		});
	}

	private void loadDataTenDVT() {
		// TODO Auto-generated method stub
		List<DonViTinh> dsDVT = donViTinh_dao.getAllDVT();
		for (DonViTinh donViTinh : dsDVT) {
			cb_tenDVT.addItem(donViTinh.getTenDonViTinh());
		}
	}

	private void loadDataNhomHang() {
		// TODO Auto-generated method stub
		nhomHang_dao = new NhomHangDao();

		dsNhomHang = nhomHang_dao.getAllDataNhomHang();
		dsNhomHang.forEach(nh -> cb_nhomHangHoa.addItem(nh.getTenNhomHang()));
	}

	private void loadDataLoaiHang() {
		// TODO Auto-generated method stub
		String loaiHang = null;
		for (LoaiHang lh : LoaiHang.values()) {
			if (lh.equals(LoaiHang.DUOC_PHAM)) {
				loaiHang = "Dược phẩm";
			} else if (lh.equals(LoaiHang.VAT_TU_YTE)) {
				loaiHang = "Vật tư y tế";
			} else {
				loaiHang = "Khác";
			}
			cb_loaiHangHoa.addItem(loaiHang);
		}
	}

	public void showMessage(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txt_maHangHoa = new javax.swing.JTextField();
        cb_loaiHangHoa = new javax.swing.JComboBox<>();
        txt_nuocSX = new javax.swing.JTextField();
        txt_HoatChat = new javax.swing.JTextField();
        txt_hangSanXuat = new javax.swing.JTextField();
        txt_quyCach = new javax.swing.JTextField();
        txt_soDangKy = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txt_hamLuong = new javax.swing.JTextField();
        lb_danhsach = new javax.swing.JLabel();
        txt_tenHangHoa1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_vat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_soLuongCanhBao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cb_nhomHangHoa = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txt_moTa = new javax.swing.JTextField();
        txt_soLuongDinhMuc1 = new javax.swing.JTextField();
        cb_trangThai = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btn_xemLo = new javax.swing.JButton();
        pnlFooter = new javax.swing.JPanel();
        btn_Luu = new javax.swing.JButton();
        btn_Dong = new javax.swing.JButton();
        btn_themDVT = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1940, 770));
        setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setPreferredSize(new java.awt.Dimension(1940, 450));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel51.setText("Mã Hàng Hoá");

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel52.setText("Loại Hàng Hoá");

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel53.setText("Số đăng ký ");

        jLabel54.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel54.setText("Hoạt chất");

        jLabel55.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel55.setText("Hãng sản xuất");

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel56.setText("Nước sản xuất");

        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel57.setText("Tên hàng hoá");

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel58.setText("Hàm lượng ");

        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel59.setText("Mô tả");

        jLabel60.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel60.setText("Quy cách đóng gói");

        jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel61.setText("Vat(%)");

        txt_maHangHoa.setEditable(false);
        txt_maHangHoa.setText("Mã tự động\n");
        txt_maHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        cb_loaiHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        txt_nuocSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        txt_HoatChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        txt_hangSanXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        txt_quyCach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        txt_soDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel62.setText("Nhóm hàng hoá");

        lb_danhsach.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lb_danhsach.setText("Danh sách đơn vị tính(1 đơn vị tính)");

        txt_tenHangHoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenHangHoa1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Số lượng định mức");

        txt_vat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vatActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Số lượng cảnh báo");

        txt_soLuongCanhBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongCanhBaoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Sao chép thông tin thuốc");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Xem thông tin hàng hoá");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Thông tin hàng hoá");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.red));
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(370, 40));

        cb_nhomHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("+");
        jButton1.setPreferredSize(new java.awt.Dimension(39, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cb_nhomHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(cb_nhomHangHoa)
        );

        txt_moTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_moTajTextField5ActionPerformed(evt);
            }
        });

        cb_trangThai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        cb_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang bán", "Ngừng bán" }));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Trạng thái");

        btn_xemLo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_xemLo.setText("Xem thông tin lô hàng");
        btn_xemLo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemLoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lb_danhsach))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                                    .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnlHeaderLayout.createSequentialGroup()
                                            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_nuocSX, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel56))
                                            .addGap(18, 18, 18)
                                            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel55)
                                                .addComponent(txt_hangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(70, 70, 70)
                                            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel59)
                                                .addComponent(txt_moTa)))
                                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_hamLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlHeaderLayout.createSequentialGroup()
                                                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_tenHangHoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel57)
                                                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                                                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                                                                .addComponent(cb_loaiHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18))
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                                                                .addComponent(jLabel52)
                                                                .addGap(147, 147, 147)))
                                                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel62)))
                                                    .addComponent(txt_HoatChat, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel54))
                                                .addGap(68, 68, 68)
                                                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel58)
                                                    .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel53)
                                                        .addComponent(txt_maHangHoa)
                                                        .addComponent(txt_soDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel51)))))
                                    .addGap(68, 68, 68)
                                    .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_quyCach)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                                            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_vat, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel61))
                                            .addGap(28, 28, 28)
                                            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cb_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(txt_soLuongDinhMuc1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel60)
                                        .addComponent(txt_soLuongCanhBao, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)))
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 1521, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addGroup(pnlHeaderLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(65, 65, 65)
                                    .addComponent(btn_xemLo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(409, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btn_xemLo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel51)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tenHangHoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soLuongDinhMuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_soLuongCanhBao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_quyCach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_vat, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(cb_trangThai)))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel62)
                                .addComponent(jLabel53)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                                        .addComponent(txt_soDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE))
                                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                                        .addComponent(cb_loaiHangHoa)
                                        .addGap(6, 6, 6)))
                                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel54))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_HoatChat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_hamLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel55))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_nuocSX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_hangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_moTa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(92, 92, 92)
                .addComponent(lb_danhsach)
                .addGap(18, 18, 18))
        );

        if(ResizeContent.getScale()==1)
        reponsiveScale1();

        add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlFooter.setBackground(new java.awt.Color(193, 219, 208));
        pnlFooter.setMinimumSize(new java.awt.Dimension(0, 50));
        pnlFooter.setPreferredSize(new java.awt.Dimension(1940, 60));

        btn_Luu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_Luu.setText("Sửa");
        btn_Luu.setPreferredSize(new java.awt.Dimension(72, 40));
        btn_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuActionPerformed(evt);
            }
        });

        btn_Dong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_Dong.setText("Trở về");
        btn_Dong.setPreferredSize(new java.awt.Dimension(72, 40));
        btn_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DongActionPerformed(evt);
            }
        });

        btn_themDVT.setText("+ Thêm đơn vị tính");
        btn_themDVT.setPreferredSize(new java.awt.Dimension(131, 40));
        btn_themDVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themDVTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btn_themDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1394, Short.MAX_VALUE)
                .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Luu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_themDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        add(pnlFooter, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xemLoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xemLoActionPerformed
        // TODO add your handling code here:
    	AddContent.addContent(new LoHangPage());
    }//GEN-LAST:event_btn_xemLoActionPerformed

	private void reponsiveScale1() {

	}

	private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_LuuActionPerformed
		// TODO add your handling code here:
		if (validData()) {
			hangHoa_dao = new HangHoaDao();
			donViTinh_dao = new DonViTinhDao();
			String maHH = txt_maHangHoa.getText();
			String tenHH = txt_tenHangHoa1.getText();
			String soDK = txt_soDangKy.getText();

			List<NhomHang> dsNhom = nhomHang_dao.getAllDataNhomHang();
			NhomHang nhomHang = dsNhom.get(cb_nhomHangHoa.getSelectedIndex());
			System.out.println(nhomHang.toString());

			String nuocSX = txt_nuocSX.getText();
			String hangSX = txt_hangSanXuat.getText();
			String hoatChat = txt_HoatChat.getText();
			String hamLuong = txt_hamLuong.getText();
			String quyCachDG = txt_quyCach.getText();
			String moTa = txt_moTa.getText();
			Double thue = Double.parseDouble(txt_vat.getText());

			int soLuongDM = Integer.parseInt(txt_soLuongDinhMuc1.getText());
			int soLuongCB = Integer.parseInt(txt_soLuongCanhBao.getText());

			LoaiHang lh = null;
			String selectedLoaiHang = cb_loaiHangHoa.getSelectedItem().toString();
			if (selectedLoaiHang.equals("Dược phẩm")) {
				lh = LoaiHang.DUOC_PHAM;
			} else if (selectedLoaiHang.equals("Vật tư y tế")) {
				lh = LoaiHang.VAT_TU_YTE;
			} else {
				lh = LoaiHang.KHAC;
			}

			TrangThaiHangHoa trangThai = null;
			String selectedTrangThai = cb_trangThai.getSelectedItem().toString();
			if (selectedTrangThai.equals("Đang bán")) {
				trangThai = TrangThaiHangHoa.DANG_BAN;
			} else {
				trangThai = TrangThaiHangHoa.NGUNG_BAN;
			}

			HangHoa hh = new HangHoa("", tenHH, lh, soDK, nhomHang, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa,
					thue, soLuongDM, soLuongCB, trangThai);
			System.out.println(hh.toString());
//	    	hangHoa_dao.themHangHoa(hh);
			boolean hhoa = hangHoa_dao.updateHangHoa(hh, maHH);

			for (int i = 0; i < tbl_DVT.getRowCount(); i++) {
				
				String tenDVT = (String) model_DVT.getValueAt(i, 1);
				System.out.println(tenDVT);
				int quyDoi = Integer.parseInt(model_DVT.getValueAt(i, 2).toString());
				System.out.println(quyDoi);
				double giaBan = Double.valueOf((String) model_DVT.getValueAt(i, 3));
				TrangThaiDonViTinh trangThaiDVT = TrangThaiDonViTinh.DANG_BAN;
				String maVach = (String) model_DVT.getValueAt(i, 4);

				DonViTinh dvt = new DonViTinh(0, tenDVT, hh, quyDoi, giaBan, maVach, trangThaiDVT);

//	    			if (donViTinh_dao.themDVT(dvt)) {
//	    				showMessage("Thêm thành công!");
//	    			}else {
//	    				showMessage("Thêm không thành công!");
//	    			}
//				DonViTinh dvtTim = donViTinh_dao.timDVTTheoMaHHVaTen(maHH, tenDVT);
//				if (dvtTim == null) {
//					donViTinh_dao.themDVT(dvt);
//				}else {
//					donViTinh_dao.updateDVT(dvt,maHH,tenDVT );
//				}
				donViTinh_dao.updateDVT(dvt,maHH,tenDVT );
				System.out.println(model_DVT.getValueAt(i, 1));
			}
			showMessage("Sửa thành công!");

		}
	

	}// GEN-LAST:event_btn_LuuActionPerformed

	private boolean validData() {
		// TODO Auto-generated method stub
		String tenHH = txt_tenHangHoa1.getText().trim();
		String soLuongDM = txt_soLuongDinhMuc1.getText().trim();
		String soLuongCB = txt_soLuongCanhBao.getText().trim();
		String soDK = txt_soDangKy.getText().trim();
		String thue = txt_vat.getText().trim();

		if (tenHH.length() > 0) {
			
		}else {
			showMessage("Tên hàng hóa không được để trống");
			return false;
		}

		

		if (soLuongCB.length() > 0) {
			try {
				int soLuongCanhBao = Integer.parseInt(soLuongCB);
				if (soLuongCanhBao < 0 ) {
					showMessage("Số lượng cảnh báo phải lớn hơn 0");
					txt_soLuongCanhBao.requestFocus();
					txt_soLuongCanhBao.selectAll();
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				showMessage("Số lượng cảnh báo phải nhập số!");
				txt_soLuongCanhBao.requestFocus();
				txt_soLuongCanhBao.selectAll();
				return false;
			}
		} else {
			showMessage("Số lượng cảnh báo không được để trống!");
			return false;
		}

		if (soDK.length() > 0) {
			
		}else {
			showMessage("Số đăng kí không được để trống!");
			return false;
		}

		if (thue.length() > 0) {
			try {
				double thueDouble = Double.parseDouble(thue);
				if (thueDouble < 0 || thueDouble > 100) {
					showMessage("Thuế phải nằm trong khoảng từ 0 đến 100%!");
					txt_vat.requestFocus();
					txt_vat.selectAll();
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
				showMessage("Thuế phải nhập số!");
				txt_vat.requestFocus();
				txt_vat.selectAll();
				return false;
			}

		} else {
			showMessage("Thuế không được để trống!");
			return false;
		}

		return true;
	}

	private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jComboBox2ActionPerformed

	private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField8ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField8ActionPerformed

	private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField7ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField7ActionPerformed

	private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField5ActionPerformed

	private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField4ActionPerformed

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField3ActionPerformed

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jComboBox1ActionPerformed

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void txt_tenHangHoa1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_tenHangHoa1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txt_tenHangHoa1ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton1ActionPerformed

	private void txt_soLuongCanhBaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_soLuongCanhBaoActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txt_soLuongCanhBaoActionPerformed

	private void txt_moTajTextField5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_moTajTextField5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txt_moTajTextField5ActionPerformed

	private void btn_xoaDVTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_xoaDVTActionPerformed
		// TODO add your handling code here:
		int selectedRow = tbl_DVT.getSelectedRow();
		if (selectedRow == -1) {
			showMessage("Chọn dòng để xóa!");
		} else {
			if (model_DVT.getRowCount() > 1) {

				model_DVT.removeRow(selectedRow);
				for (int i = selectedRow; i < tbl_DVT.getRowCount(); i++) {
					model_DVT.setValueAt(stt, i, 0);

				}
			}
		}
	}// GEN-LAST:event_btn_xoaDVTActionPerformed

	private void btn_DongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_DongActionPerformed
		// TODO add your handling code here:
		AddContent.addContent(new XemThongTinHangHoaPage());
		AddContent.addContent(new HangHoaPage());
	}// GEN-LAST:event_btn_DongActionPerformed

	private void txt_vatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_vatActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txt_vatActionPerformed

	private void btn_themDVTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_themDVTActionPerformed
		// TODO add your handling code here:

		Object[] emptyRow = { stt++, null,0, 0,"" ,"Đang bán","" };
		model_DVT.addRow(emptyRow);

	}// GEN-LAST:event_btn_themDVTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Dong;
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_themDVT;
    private javax.swing.JButton btn_xemLo;
    protected static javax.swing.JComboBox<String> cb_loaiHangHoa;
    protected static javax.swing.JComboBox<String> cb_nhomHangHoa;
    protected static javax.swing.JComboBox<String> cb_trangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lb_danhsach;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    protected static javax.swing.JTextField txt_HoatChat;
    protected static javax.swing.JTextField txt_hamLuong;
    protected static javax.swing.JTextField txt_hangSanXuat;
    protected static javax.swing.JTextField txt_maHangHoa;
    protected static javax.swing.JTextField txt_moTa;
    protected static javax.swing.JTextField txt_nuocSX;
    protected static javax.swing.JTextField txt_quyCach;
    protected static javax.swing.JTextField txt_soDangKy;
    protected static javax.swing.JTextField txt_soLuongCanhBao;
    protected static javax.swing.JTextField txt_soLuongDinhMuc1;
    protected static javax.swing.JTextField txt_tenHangHoa1;
    protected static javax.swing.JTextField txt_vat;
    // End of variables declaration//GEN-END:variables
}
