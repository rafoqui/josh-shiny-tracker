package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Pokemon;
import service.PokemonService;

//@CrossOrigin(origins = "*")
@RestController
public class PokemonController {
	@Autowired
	PokemonService service;
	
	@GetMapping(value="pokemon/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pokemon> buscarPokemon(@PathVariable("name") String name) {
		return service.buscarPokemon(name);
	}
}
