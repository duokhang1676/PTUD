package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection con = null;

	private static ConnectDB instance = new ConnectDB();

	public static ConnectDB getInstance() {
		return instance;
	}

	public void connect() throws SQLException {
		con = DriverManager.getConnection(DBConfiguation.databaseURL, DBConfiguation.user, DBConfiguation.password);
	}
	
	public void connect2() throws SQLException {
		con = DriverManager.getConnection(DBConfiguation.databaseURL2, DBConfiguation.user2, DBConfiguation.password2);
	}

	public void disconnect() {
		if (con == null) {
			return;
		}
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}
}
