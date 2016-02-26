package business;

import java.util.List;

import datalayer.HospedeDAO;
import datalayer.IHospedeDAO;
import datalayer.common.DatabaseException;
import model.Hospede;

public class HospedeService implements IHospedeService{

	IHospedeDAO hospedeDao;	
	public IHospedeDAO getHospedeDAO() {	return hospedeDao;	}
	public void setHospedeDAO(IHospedeDAO hospedeDao) { this.hospedeDao = hospedeDao; }
	public HospedeService(){	hospedeDao = new HospedeDAO(); }
	
	
	@Override
	public int insert(Hospede hospede) throws ServiceException {
		try{ return hospedeDao.insert(hospede); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }		
	}
	
	@Override
	public List<Hospede> getAll() throws ServiceException {
		try{ return hospedeDao.getAll(); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }	
	}


	
}
