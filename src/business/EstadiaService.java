package business;

import datalayer.EstadiaDAO;
import datalayer.IEstadiaDAO;
import datalayer.common.DatabaseException;
import model.Alojamento;
import model.Estadia;


public class EstadiaService implements IEstadiaService{

	IEstadiaDAO estadiaDao;	
	public IEstadiaDAO getEstadiaDAO() {	return estadiaDao;	}
	public void setEstadiaDAO(IEstadiaDAO estadiaDao) { this.estadiaDao = estadiaDao; }
	public EstadiaService(){ estadiaDao = new EstadiaDAO(); }
	
	
	@Override
	public int insert(Estadia estadia) throws ServiceException {
		try{ return estadiaDao.insert(estadia); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }		
	}
	@Override
	public boolean insertAlojamento(Estadia estadia, Alojamento alojamento) throws ServiceException {
		try{ return estadiaDao.insertAlojamento(estadia,alojamento); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }	
	}
	
}
