package datalayer;

import java.sql.Date;

import datalayer.common.DatabaseException;

public interface IQueryDAO {
	float getCustoAlojamento(int nif, Date data)throws DatabaseException;
	float getCustoExtra(int nif, Date data)throws DatabaseException;
	float getCustoActividades(int nif, Date data)throws DatabaseException;
	float getCustoSinal(int nif, Date data)throws DatabaseException;
}
