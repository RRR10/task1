package testtask.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector  {

	public Connection createDbCon() throws ClassNotFoundException, SQLException {
		String driver = "org.sqlite.JDBC";
		Class.forName(driver);
		String dbName = "testtask.db";
		String dbUrl = "jdbc:sqlite:" + dbName;
		Connection conn = DriverManager.getConnection(dbUrl);
		return conn;
	}

}