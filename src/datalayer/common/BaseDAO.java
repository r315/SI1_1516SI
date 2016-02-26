package datalayer.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import datalayer.sqlserver.ConnectionFactory;

public abstract class BaseDAO {
	private static ConnectionFactory _connFactory = null;

	protected ConnectionFactory getConnectionFactory(){
		return _connFactory;
	}

	public static void setConnectionFactory(ConnectionFactory connFact) {
		_connFactory = connFact;
	}
	
	protected void closeConnection(Connection conn) throws DatabaseException
	{
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException exception) {
				throw new DatabaseException(exception.getMessage());
			}
		}
	}
	
	protected void closePreparedStatement(PreparedStatement pstmt) throws DatabaseException
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();
			} catch (SQLException exception) {
				throw new DatabaseException(exception.getMessage());
			}
		}
	}
	
}
