package datalayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Alojamento;
import model.Bungalow;
import model.Roulote;
import model.Tenda;
import datalayer.common.BaseDAO;
import datalayer.common.DatabaseException;

public class AlojamentoDAO extends BaseDAO implements IAlojamentoDAO {
	
	private static final String INSERT = "insert into Alojamento(Parque,Localizacao,Descricao,Preco,Tipo) values(?,?,?,?,?)";
	private static final String INSERT_BUNGALOW = "insert into Bungalow(Parque,ID,Topologia) values(?,?,?)";
	private static final String INSERT_ROULOTE = "insert into Roulote(Parque,ID) values(?,?)";
	private static final String INSERT_TENDA = "insert into Tenda(Parque,ID,Area) values(?,?,?)";
	private static final String SELECTALL = "select * from Alojamento";
	private static final String SELECTBYPK = "select * from Alojamento where Parque=? and ID=?";
	private static final String REMOVE = "delete from Alojamento where ID=?";
	private static final String UPDATEPRECO = "update Alojamento set Preco=? where Parque=? and ID=?;";
	private static final String UPDATE_HIST_PRECO_DT_FIM = "update Hist_Precos_Alojamento set Dt_Fim = ? where Parque=? and Aloj_ID=? and Dt_Fim = '2099-01-01'";
	private static final String INSERT_HIST_PRECO_ALOJ = "insert into Hist_Precos_Alojamento(Parque,Aloj_ID,Dt_Inicio,Dt_Fim,Preco) values(?,?,?,'2099-01-01',?)";
	private static final String INSERT_EXTRA_ALOJ = "insert into Alojamento_Extras( Parque, Alojamento, Extra ) values ( ?, ?, ? )";
	private static final String DISPONIBILIDADE =   "SELECT COUNT(*)  "
												  + "FROM Estadia_Alojamentos as EA "
												  +    "inner join Estadia as Est on ( EA.Estadia = Est.ID )"
												  + " WHERE Aloj_Parque=? and Aloj_ID=? and "
												  		 + " ((? >= DT_entrada and ? < DT_Saida) or "
												  		 + " ( ? > DT_entrada and ? <= DT_Saida) or"
												  		 + " ( DT_entrada  >= ? and DT_entrada < ? ) )";
	

	@Override
	public int insert(Alojamento alojamento) throws DatabaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		int res;
		
		try{
			conn = getConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,alojamento.parque);
			pstmt.setString(2,alojamento.localizacao);
			pstmt.setString(3,alojamento.descricao);
			pstmt.setFloat(4,alojamento.preco);
			pstmt.setString(5,alojamento.tipo);
			res = pstmt.executeUpdate();
			if(res != 0){
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}else
				throw new DatabaseException("Error no line inserted!");
			
			
			if ( alojamento instanceof Bungalow) {
				pstmt2 = conn.prepareStatement(INSERT_BUNGALOW);
				pstmt2.setString(1,alojamento.parque);
				pstmt2.setInt(2,res);
				pstmt2.setString(3,((Bungalow)alojamento).topologia);
			}
			else 
				if ( alojamento instanceof Roulote) {
					pstmt2 = conn.prepareStatement(INSERT_ROULOTE);
					pstmt2.setString(1,alojamento.parque);
					pstmt2.setInt(2,res);
				}
				else
					if ( alojamento instanceof Tenda) {
						pstmt2 = conn.prepareStatement(INSERT_TENDA);
						pstmt2.setString(1,alojamento.parque);
						pstmt2.setInt(2,res);
						pstmt2.setInt(3,((Tenda)alojamento).area);
					}
			pstmt2.execute();
					
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
			closePreparedStatement(pstmt2);
			closeConnection(conn);
		}
	}

	@Override
	public boolean removeByPk(String parque, int id) throws DatabaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res;
		try{
			conn = getConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(REMOVE);
			pstmt.setInt(1,id);			
			res = pstmt.executeUpdate();
			if(res != 0){
				conn.commit();
				return true;
			}else
				throw new DatabaseException("Error no line inserted!");						
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
	public boolean remove(Alojamento alojamento) throws DatabaseException {
		return removeByPk(alojamento.parque, alojamento.id);		
	}

	@Override
	public Alojamento getByPk(String parque, int id)throws DatabaseException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{			
			conn = getConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(SELECTBYPK);
			pstmt.setString(1,parque);
			pstmt.setInt(2,id);
			ResultSet rs = pstmt.executeQuery();

			Alojamento alojamento = new Alojamento();	
			if(rs.next()){
				alojamento.parque = rs.getString(1);
				alojamento.id = rs.getInt(2);
				alojamento.localizacao = rs.getString(3);
				alojamento.descricao = rs.getString(4);
				alojamento.preco = rs.getFloat(5);
				alojamento.tipo = rs.getString(6);					
				return alojamento;
			}
			throw new DatabaseException("Alojamento not found");
							
			
		}catch (Exception exception) {
			throw new DatabaseException(
					"Unable to list the table. \nCause: "
							+ exception.getMessage(), exception);
		} finally {
			closePreparedStatement(pstmt);
			closeConnection(conn);
		}
	}
	
	@Override
	public List<Alojamento> getAll() throws DatabaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{			
			conn = getConnectionFactory().getConnection();
			ArrayList<Alojamento> containner =  new ArrayList<Alojamento>();			
			
			pstmt = conn.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()){
				Alojamento item = new Alojamento();				
				item.parque = rs.getString(1);
				item.id = rs.getInt(2);
				item.localizacao = rs.getString(3);
				item.descricao = rs.getString(4);
				item.preco = rs.getFloat(5);
				item.tipo = rs.getString(6);
				containner.add(item);
			}
			return containner;
			
		}catch (Exception exception) {
			throw new DatabaseException(
					"Unable to list the table. \nCause: "
							+ exception.getMessage(), exception);
		} finally {
			closePreparedStatement(pstmt);
			closeConnection(conn);
		}
		
	}

	@Override
	public boolean updatePreco(Alojamento alojamento)throws DatabaseException {
		
		if ( !updateHistoricoAlojamento(alojamento) ) 
			return false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res;
		
		try{
			conn = getConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(UPDATEPRECO);
			pstmt.setFloat(1,alojamento.preco);
			pstmt.setString(2,alojamento.parque);
			pstmt.setInt(3,alojamento.id);			
			res = pstmt.executeUpdate();
			
			if(res != 0){
				conn.commit();
				return true;
			}else
				throw new DatabaseException("Error no line updated!");			
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
	
	private boolean updateHistoricoAlojamento(Alojamento alojamento)throws DatabaseException {
		Connection conn = null;
		int res;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try{
			conn = getConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			
			pstmt2 = conn.prepareStatement(UPDATE_HIST_PRECO_DT_FIM);
			pstmt2.setDate(1, new java.sql.Date(System.currentTimeMillis()));
			pstmt2.setString(2,alojamento.parque);
			pstmt2.setInt(3,alojamento.id);			
			res = pstmt2.executeUpdate();
			
			if ( res != 0 ) {
				pstmt = conn.prepareStatement(INSERT_HIST_PRECO_ALOJ);
				pstmt.setString(1,alojamento.parque);
				pstmt.setInt(2,alojamento.id);
				pstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
				pstmt.setFloat(4,alojamento.preco);
				res = pstmt.executeUpdate();
			}
			
			if(res != 0){
				conn.commit();
				return true;
			}else
				throw new DatabaseException("Error no line updated!");			
		}
		catch (Exception exception)
		{
			if (conn != null) { try { conn.rollback(); } catch(Exception excep) {  } }		            
			throw new DatabaseException("Unable to insert \nCause: "
					+ exception.getMessage(), exception);
		}
		finally{
			closePreparedStatement(pstmt);
			closePreparedStatement(pstmt2);
			closeConnection(conn);		
		}
		
	}

	@Override
	public boolean insereExtra(Alojamento alojamento, int extra_ID) throws DatabaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res;
		
		try{
			conn = getConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(INSERT_EXTRA_ALOJ);
			pstmt.setString(1,alojamento.parque);
			pstmt.setInt(2,alojamento.id);
			pstmt.setInt(3,extra_ID);
			res = pstmt.executeUpdate();
			if(res != 0){
				conn.commit();
				return true;
			}else
				throw new DatabaseException("Error no line inserted!");
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
	public boolean disponibilidade(Alojamento alojamento, Date Dt_Entada, Date Dt_Saida)throws DatabaseException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{			
			conn = getConnectionFactory().getConnection();
			pstmt = conn.prepareStatement(DISPONIBILIDADE);
			pstmt.setString(1,alojamento.parque);
			pstmt.setInt(2,alojamento.id);
			pstmt.setDate(3,Dt_Entada);
			pstmt.setDate(4,Dt_Entada);
			pstmt.setDate(5,Dt_Saida);
			pstmt.setDate(6,Dt_Saida);
			pstmt.setDate(7,Dt_Entada);
			pstmt.setDate(8,Dt_Saida);
			ResultSet rs = pstmt.executeQuery();
			if( rs.next() ) 
				if ( rs.getInt(1) == 0)
					return true;
			return false;
		}catch (Exception exception) {
			throw new DatabaseException(
					"Unable to get Disponibilidades. \nCause: "
							+ exception.getMessage(), exception);
		} finally {
			closePreparedStatement(pstmt);
			closeConnection(conn);
		}
	}
	
}
