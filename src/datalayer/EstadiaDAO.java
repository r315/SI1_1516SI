package datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Alojamento;
import model.Estadia;
import datalayer.common.BaseDAO;
import datalayer.common.DatabaseException;

public class EstadiaDAO extends BaseDAO implements IEstadiaDAO{
	
	private static final String INSERT_ESTADIA = "insert into Estadia(Tipo, Sinal, DT_entrada, DT_Saida, Hospede) values(?,?,?,?,?)";
	private static final String INSERT_ALOJAMENTO = "insert into Estadia_Alojamentos(Estadia,Aloj_ID,Aloj_Parque) values(?,?,?)";
	
	@Override
	public int insert(Estadia estadia) throws DatabaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res;
		
		try{
			conn = getConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(INSERT_ESTADIA,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,estadia.tipo);
			pstmt.setFloat(2,estadia.sinal);
			pstmt.setDate(3,estadia.dtentrada);
			pstmt.setDate(4,estadia.dtsaida);
			pstmt.setInt(5,estadia.hospede);
			res = pstmt.executeUpdate();
			if(res != 0){
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}else
				throw new DatabaseException("Error no line inserted!");
			
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

	@Override
	public boolean insertAlojamento(Estadia estadia, Alojamento alojamento) throws DatabaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res;
		
		// Falta Verificar se esta disponivel e se sim continuar
		
		try{
			conn = getConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(INSERT_ALOJAMENTO);
			pstmt.setInt(1,estadia.id);
			pstmt.setInt(2,alojamento.id);
			pstmt.setString(3,alojamento.parque);;
			res = pstmt.executeUpdate();
			if(res != 0){
				conn.commit();
			}else
				throw new DatabaseException("Error no line inserted!");
			return true;
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
