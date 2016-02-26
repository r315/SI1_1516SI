package business;

import java.util.List;
import model.Parque;

public interface IParqueService extends IService{
	List<Parque> getAll() throws ServiceException;
}