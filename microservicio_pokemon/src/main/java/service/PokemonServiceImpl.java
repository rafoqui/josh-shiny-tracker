package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PokemonDao;
import model.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	PokemonDao dao;
	
	/**
	 * Returns all the names from the database that contains the term passed.
	 */
	@Override
	public List<Pokemon> buscarPokemon(String name) {
		return dao.buscarPokemon(name);
	}

}
