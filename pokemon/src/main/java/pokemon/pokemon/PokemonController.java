package pokemon.pokemon;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PokemonController {

	private final PokemonRepository repository;
	
	PokemonController(PokemonRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/pokemons")
	List<Pokemon> all(){
		return repository.findAll();
	}
	
	@PostMapping("/pokemons")
	Pokemon newPokemon(@RequestBody Pokemon newPokemon) {
		return repository.save(newPokemon);
	}
	
	@GetMapping("/pokemons/{id}")
	Pokemon one(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new PokemonNotFoundException(id));
	}
	
	@PutMapping("/pokemons/{id}")
	Pokemon replacePokemon(@RequestBody Pokemon newPokemon, @PathVariable Long id) {
		
		return repository.findById(id)
				.map(pokemon -> {
					pokemon.setName(newPokemon.getName());
					pokemon.setType1(newPokemon.getType1());
					pokemon.setType2(newPokemon.getType2());
					return repository.save(pokemon);
				})
				.orElseGet(() -> {
					return repository.save(newPokemon);
				});
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
	public ResponseEntity<Void> validatePokemon(@PathVariable Long id){
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/pokemons/{id}")
	void deletePokemon(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
