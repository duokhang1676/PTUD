package components;

import entities.Ca;
import entities.NhanVien;
import ui.RootFrame;

public class LoginInfo {
	public static RootFrame rootFrame;
	public static NhanVien nhanVien;
	public static Ca ca;
	public static void addRootframe(RootFrame r) {
		rootFrame = r;
	}
	public static void disposeRootframe() {
		rootFrame.dispose();
	}
	public static void setNV(NhanVien nv) {
		nhanVien = nv;
	}
}
