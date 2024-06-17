package service;

import java.util.List;

import model.Pokemon;

public interface PokemonService {
	List<Pokemon> buscarPokemon(String name);
}
