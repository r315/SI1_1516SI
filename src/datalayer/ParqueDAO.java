package datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Parque;
import datalayer.common.BaseDAO;
import datalayer.common.DatabaseException;

public class ParqueDAO extends BaseDAO implements IParqueDAO{
	
	private static final String SELECTALL = "select * from Parque";

	@Override
	public List<Parque> getAll() throws DatabaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {			
			Parque item;
			ArrayList<Parque> container = new ArrayList<Parque>();

			conn = getConnectionFactory().getConnection();

			pstmt = conn.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				item = new Parque();				
				item.nome = rs.getString(1);
				item.morada = rs.getString(2);
				item.localizacao = rs.getString(3);				
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
	

}
