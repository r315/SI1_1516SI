package business;

import java.sql.Date;
import java.util.List;

import model.Alojamento;

public interface IAlojamentoService extends IService{
	int insert(Alojamento alojamento) throws ServiceException;
	List<Alojamento>getAll()throws ServiceException;
	boolean remove(Alojamento alojamento)throws ServiceException;	
	boolean removeByPk(String parque, int id)throws ServiceException;
	Alojamento getByPk(String parque, int id)throws ServiceException;
	public boolean updatePreco(Alojamento alojamento)throws ServiceException;
	boolean insereExtra(Alojamento alojamento, int nextInt) throws ServiceException;
	boolean disponibilidade(Alojamento alojamento, Date Dt_Entada, Date Dt_Saida) throws ServiceException;
}
