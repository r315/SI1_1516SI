package datalayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datalayer.common.BaseDAO;
import datalayer.common.DatabaseException;

public class QueryDAO extends BaseDAO implements IQueryDAO {

	private static final String QUERYCUSTOALOJA = 
			"select SUM(Preco) as Total_Alojamentos " +
			"from Estadia as Est " +
				"inner join Estadia_Alojamentos as EA on ( Est.ID = EA.Estadia ) " +
				"inner join Hist_Precos_Alojamento as Prc on (  " +
					"EA.Aloj_ID = Prc.Aloj_ID and ( Est.DT_entrada >= Prc.Dt_Inicio AND Est.DT_entrada <= Prc.Dt_Fim ) ) " +
			"where ( Est.Hospede = ?  and DT_Entrada = ? ) ";

	private static final String QUERYCUSTOEXTRA = 
			"select SUM(Preco) as Total_Extras "+
			"from Estadia as Est " +
				"inner join Estadia_Extras_Por_Alojamento as EEpA on ( Est.ID = EEpA.Estadia ) "+
				"inner join Hist_Precos_Extra as Prc on ( "+
					"EEpA.Extra = Prc.ExtraID and ( Est.DT_entrada >= Prc.Dt_Inicio AND Est.DT_entrada <= Prc.Dt_Fim ) ) "+
			"where ( Est.Hospede = ?  and DT_Entrada = ? )" ;
	
	private static final String QUERYCUSTOACTIVIDADES =			
			"select SUM( Num_Participantes * PrecoPessoa ) as Total_Actividades "+
			"from Estadia as Est " +
				"inner join Estadia_Actividades as EA on ( Est.ID = EA.Estadia ) "+
				"inner join Hist_Precos_Actividade as Prc on ( "+
					"EA.Parque = Prc.Parque and EA.Nome = Prc.Nome AND "+
					"EA.Data = Prc.Data and ( Est.DT_entrada >= Prc.Dt_Inicio AND "+
					"Est.DT_entrada <= Prc.Dt_Fim ) ) " +
			"where ( Est.Hospede = ?  and DT_Entrada = ?)" ;
	
	private static final String QUERYCUSTOSINAL = "select Sinal "
												+ "from Estadia "
												+ "where Hospede=? and DT_entrada=?";


	private float getCommon(String query, int nif, Date data)throws DatabaseException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {			
			conn = getConnectionFactory().getConnection();

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nif);
			pstmt.setDate(2, data);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				return rs.getFloat(1);
			throw new DatabaseException("QueryDAO: query error");
			
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
	public float getCustoAlojamento(int nif, Date data)
			throws DatabaseException {		
		return getCommon(QUERYCUSTOALOJA,nif,data);
	}	
	@Override
	public float getCustoExtra(int nif, Date data) throws DatabaseException {	
			return getCommon(QUERYCUSTOEXTRA,nif,data);
	}
	@Override
	public float getCustoActividades(int nif, Date data)
			throws DatabaseException {
		return getCommon(QUERYCUSTOACTIVIDADES,nif,data);
	}
	@Override
	public float getCustoSinal(int nif, Date data) throws DatabaseException {
		return getCommon(QUERYCUSTOSINAL,nif,data);
	}

}
