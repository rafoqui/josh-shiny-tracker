package dao;

import java.util.List;

import model.Pokemon;

public interface PokemonDao {
	List<Pokemon> buscarPokemon(String term);
	
}
