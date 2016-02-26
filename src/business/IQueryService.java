package business;

import java.sql.Date;

public interface IQueryService{
	float getCustoTotalAlojamento(int nif, Date data)throws ServiceException;
}
