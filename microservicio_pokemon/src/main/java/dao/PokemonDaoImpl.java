package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Pokemon;

@Repository
public class PokemonDaoImpl implements PokemonDao {
	
	@Autowired
	PokemonJpaSpring pkmn;

	@Override
	public List<Pokemon> buscarPokemon(String term) {
		return pkmn.searchByName(term);
	}

}
