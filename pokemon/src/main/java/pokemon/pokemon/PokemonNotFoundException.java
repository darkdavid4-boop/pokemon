package pokemon.pokemon;

public class PokemonNotFoundException extends RuntimeException {

	PokemonNotFoundException(long id){
		super("Could not find employee "+ id);
	}
}
