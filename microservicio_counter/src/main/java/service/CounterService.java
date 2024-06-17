package service;

import java.util.List;

import model.Counter;

public interface CounterService {
	boolean agregarCounter(Counter counter);
	List<Counter> recuperarCounters();
	void actualizarCounter(Counter counter);
	boolean eliminarCounter(long idCounter);
	Counter buscarCounter(long idCounter);
	void oddsCalculator(Counter counter);
	void modificarShinyCharm(Counter counter, boolean charm);
}
