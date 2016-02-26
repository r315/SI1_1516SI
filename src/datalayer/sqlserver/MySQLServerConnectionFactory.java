package datalayer.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLServerConnectionFactory extends ConnectionFactory {	
	
	private static MySQLServerConnectionFactory connFactory=null;
	
	public static ConnectionFactory getInstance(){
		if( connFactory==null){
			connFactory = new MySQLServerConnectionFactory();
		}
		return connFactory;
	}
	
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
	

		Connection conn = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			String t = GetConnectionString();
			conn = (Connection) DriverManager.getConnection(t);
			//conn.setAutoCommit(false);
		}catch(Exception ex){
			
		}		
		return conn;
	}

}
