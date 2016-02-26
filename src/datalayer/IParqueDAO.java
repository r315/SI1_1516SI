package datalayer;

import java.util.List;

import model.Parque;
import datalayer.common.DatabaseException;

public interface IParqueDAO {
	List<Parque> getAll() throws DatabaseException;
}
