package datalayer;

import java.sql.Date;
import java.util.List;

import model.Alojamento;
import datalayer.common.DatabaseException;

public interface IAlojamentoDAO {
	int insert(Alojamento alojamento)throws DatabaseException;
	boolean remove(Alojamento alojamento)throws DatabaseException;
	boolean removeByPk(String parque, int id)throws DatabaseException;
	List<Alojamento>getAll()throws DatabaseException;
	Alojamento getByPk(String parque, int id)throws DatabaseException;
	boolean updatePreco(Alojamento alojamento)throws DatabaseException;
	boolean insereExtra(Alojamento alojamento, int extra_ID) throws DatabaseException;
	boolean disponibilidade(Alojamento alojamento, Date Dt_Entada, Date Dt_Saida) throws DatabaseException;
}
