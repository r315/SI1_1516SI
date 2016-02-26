package business;

import java.sql.Date;
import java.util.List;

import datalayer.AlojamentoDAO;
import datalayer.IAlojamentoDAO;
import datalayer.common.DatabaseException;
import model.Alojamento;

public class AlojamentoService implements IAlojamentoService{

	IAlojamentoDAO alojamentoDao;	
	public IAlojamentoDAO getAlojamentoDAO() {	return alojamentoDao;	}
	public void setAlojamentoDAO(IAlojamentoDAO alojamentoDao) { this.alojamentoDao = alojamentoDao; }
	public AlojamentoService(){	alojamentoDao = new AlojamentoDAO(); }
	
	
	@Override
	public int insert(Alojamento alojamento) throws ServiceException {
		try{ return alojamentoDao.insert(alojamento); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }		
	}
	
	@Override
	public boolean remove(Alojamento alojamento) throws ServiceException {
		try{ return alojamentoDao.remove(alojamento); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }	
	}
	
	@Override
	public List<Alojamento> getAll() throws ServiceException {
		try{ return alojamentoDao.getAll(); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }	
	}
	@Override
	public boolean removeByPk(String parque, int id) throws ServiceException {
		try{ return alojamentoDao.removeByPk(parque, id); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }	
	}
	@Override
	public Alojamento getByPk(String parque, int id) throws ServiceException {
		try{ return alojamentoDao.getByPk(parque, id); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }	
	}
	@Override
	public boolean updatePreco(Alojamento alojamento) throws ServiceException {
		try{ return alojamentoDao.updatePreco(alojamento); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }		
	}
	@Override
	public boolean insereExtra(Alojamento alojamento, int extra_ID) throws ServiceException {
		try{ return alojamentoDao.insereExtra(alojamento, extra_ID); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }
	}
	@Override
	public boolean disponibilidade(Alojamento alojamento, Date Dt_Entada, Date Dt_Saida) throws ServiceException {
		try{ return alojamentoDao.disponibilidade(alojamento, Dt_Entada, Dt_Saida); } 
		catch (DatabaseException exception) { 
			throw new ServiceException(exception.getMessage(), exception); }
	}
	
	
}
