package components;

import ui.RootFrame;

public class LoginInfo {
	public static RootFrame rootFrame;
	public static void addRootframe(RootFrame r) {
		rootFrame = r;
	}
	public static void disposeRootframe() {
		rootFrame.dispose();
	}
}
