package datalayer;

import model.Alojamento;
import model.Estadia;
import datalayer.common.DatabaseException;

public interface IEstadiaDAO {
	int insert(Estadia estadia) throws DatabaseException;
	boolean insertAlojamento(Estadia estadia, Alojamento alojamento) throws DatabaseException;
}
