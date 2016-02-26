package business;

import java.util.List;

import model.Hospede;

public interface IHospedeService extends IService{
	int insert(Hospede hospede) throws ServiceException;
	List<Hospede>getAll()throws ServiceException;
}
