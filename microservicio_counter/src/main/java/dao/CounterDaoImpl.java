package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Counter;

@Repository
public class CounterDaoImpl implements CounterDao {
	
	@Autowired
	CounterJpaSpring cntr;
	
	@Override
	public void crearCounter(Counter counter) {
		cntr.save(counter);
	}

	@Override
	public Counter recuperarCounter(long id) {
		return cntr.findById(id).orElse(null);
	}

	@Override
	public void actualizarCounter(Counter counter) {
		cntr.save(counter);
	}

	@Override
	public void eliminarCounter(long id) {
		cntr.deleteById(id);
	}

	@Override
	public List<Counter> devolverCounters() {
		return cntr.findAll();
	}

	
}
