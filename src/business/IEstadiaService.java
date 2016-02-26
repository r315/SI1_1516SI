package business;

import model.Alojamento;
import model.Estadia;

public interface IEstadiaService extends IService{
	int insert(Estadia estadia) throws ServiceException;
	boolean insertAlojamento(Estadia estadia, Alojamento alojamento) throws ServiceException;
}
