package MvcPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public  class ConnectionProvider {

	static Connection con;

	public static Connection CreateC() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String password = "goodtogo";
			String url = "jdbc:mysql://localhost:3306/mvccrud";
			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {

		}
		return con;
	}

}
