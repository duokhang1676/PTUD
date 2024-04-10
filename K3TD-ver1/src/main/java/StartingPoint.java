
import javax.swing.SwingUtilities;

import db.ConnectDB;
import ui.DangNhap;

public class StartingPoint {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				DangNhap dangNhap = new DangNhap();
				dangNhap.setVisible(true);
			}
		});
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Kết nối csld thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Kết nối csld thất bại!");
		}
	}
}
