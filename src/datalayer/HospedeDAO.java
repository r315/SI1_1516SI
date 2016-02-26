package datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Hospede;
import datalayer.common.BaseDAO;
import datalayer.common.DatabaseException;

public class HospedeDAO extends BaseDAO implements IHospedeDAO{
	
	private static final String SELECTALL = "select * from Hospede";
	private static final String INSERT = "insert into Hospede(NIF,BI,Passaporte,Nome,Morada) values(?,?,?,?,?)";

	@Override
	public List<Hospede> getAll() throws DatabaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {			
			Hospede item;
			ArrayList<Hospede> container = new ArrayList<Hospede>();

			conn = getConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				item = new Hospede();
				item.nif = rs.getInt(1);
				item.bi = rs.getInt(2);
				item.passaporte = rs.getString(3);
				item.nome = rs.getString(4);
				item.morada = rs.getString(5);				
				container.add(item);
			}
			
			return container;
			
		} catch (Exception exception) {
			throw new DatabaseException(
					"Unable to list the table. \nCause: "
							+ exception.getMessage(), exception);
		} finally {
			closePreparedStatement(pstmt);
			closeConnection(conn);
		}
	}
	
	@Override
	public int insert(Hospede hospede) throws DatabaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res;
		
		try{
			conn = getConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1,hospede.nif);
			pstmt.setInt(2,hospede.bi);
			pstmt.setString(3,hospede.passaporte);
			pstmt.setString(4,hospede.nome);
			pstmt.setString(5,hospede.morada);
			res = pstmt.executeUpdate();
			conn.commit();
			return res;
		}
		catch (Exception exception)
		{
			if (conn != null) { try { conn.rollback(); } catch(Exception excep) {  } }		            
			throw new DatabaseException("Unable to insert \nCause: "
					+ exception.getMessage(), exception);
		}
		finally{
			closePreparedStatement(pstmt);
			closeConnection(conn);
		}
	}

}
