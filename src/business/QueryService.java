package business;

import java.sql.Date;

import datalayer.IQueryDAO;
import datalayer.QueryDAO;
import datalayer.common.DatabaseException;
import business.ServiceException;

public class QueryService implements IQueryService{

	IQueryDAO queryDao;
	
	@Override
	public float getCustoTotalAlojamento(int nif, Date data)
			throws ServiceException {
		try{
			float total = queryDao.getCustoAlojamento(nif,data);
			total += queryDao.getCustoExtra(nif, data);
			total += queryDao.getCustoActividades(nif, data);
			total -= queryDao.getCustoSinal(nif,data);
			return total;
		}catch(DatabaseException ex){
			throw new ServiceException(ex.getMessage(), ex);
		}		
	}

	public QueryService(){ queryDao = new QueryDAO(); }
}
