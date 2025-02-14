package jdbcboard.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
//singleton 사용 : 클래스의 객체를 한개만 만드는 패턴
public class ConnectionUtil {
	
	private static ConnectionUtil connectionUtil = new ConnectionUtil();
	private static Properties databaseProperties;
	
	private ConnectionUtil() {
		try {
			databaseProperties = new Properties(); 
			databaseProperties.load(
					new FileReader("C:/Users/Administrator/git/jsp/JDBCBoard/src/main/webapp/WEB-INF/props/database.properties"));
			Class.forName(databaseProperties.getProperty("JDBC_DRIVER"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static ConnectionUtil getConnectionUtil() {
		return connectionUtil;
	}
	
	public Connection getConnection() throws Exception{
//		String JDBC_URL = databaseProperties.getProperty("JDBC_URL");
//		String JDBC_USER = databaseProperties.getProperty("JDBC_USER");
//		String JDBC_PASS = databaseProperties.getProperty("JDBC_PASS");
		return DriverManager.getConnection(
				databaseProperties.getProperty("JDBC_URL"),
				databaseProperties.getProperty("JDBC_USER"),
				databaseProperties.getProperty("JDBC_PASS"));
	}
	
	public void closeConnection(ResultSet rs,Statement stmt, Connection conn) 
			throws Exception {
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		if (conn!=null) conn.close();
		
	}
	
}
