package datalayer;

import java.util.List;

import model.Hospede;
import datalayer.common.DatabaseException;

public interface IHospedeDAO {
	List<Hospede> getAll() throws DatabaseException;
	int insert(Hospede hospede) throws DatabaseException;
}
