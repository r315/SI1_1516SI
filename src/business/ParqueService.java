package business;

import java.util.List;

import model.Parque;
import datalayer.IParqueDAO;
import datalayer.ParqueDAO;
import datalayer.common.DatabaseException;

public class ParqueService implements IParqueService{	

	IParqueDAO parquedao;	
	public IParqueDAO getStudentDAO() {	return parquedao;	}
	public void setParqueDAO(IParqueDAO parquedao) { this.parquedao = parquedao; }
	public ParqueService(){	parquedao = new ParqueDAO(); }
	
	@Override
	public List<Parque> getAll() throws ServiceException {
		try 
		{
			return parquedao.getAll();
		} 
		catch (DatabaseException exception) 
		{
			throw new ServiceException(exception.getMessage(), exception);
		}
	}

}
