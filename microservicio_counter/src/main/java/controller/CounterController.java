package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Counter;
import service.CounterService;

//@CrossOrigin(origins = "*")
@RestController
public class CounterController {
	
	@Autowired
	CounterService service;
	
	@GetMapping(value="contadores",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Counter> recuperarCounters() {
		return service.recuperarCounters();
	}
	@GetMapping(value="contadores/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Counter recuperarCounters(@PathVariable("id") long id) {
		return service.buscarCounter(id);
	}
	@PostMapping(value="contadores",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
	public String guardarCounter(@RequestBody Counter counter) {
		return String.valueOf(service.agregarCounter(counter));
	}
	@PutMapping(value="contadores",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCounter(@RequestBody Counter counter) {
		service.actualizarCounter(counter);
	}
	@DeleteMapping(value="contadores/{id}")
	public void eliminarCounter(@PathVariable("id") long id) {
		service.eliminarCounter(id);
	}
}
