package dao;

import java.util.List;

import model.Counter;

public interface CounterDao {
	void crearCounter(Counter counter);
	
	Counter recuperarCounter(long id);
	
	void actualizarCounter(Counter counter);
	
	void eliminarCounter(long id);
	
	List<Counter> devolverCounters();
	
}
