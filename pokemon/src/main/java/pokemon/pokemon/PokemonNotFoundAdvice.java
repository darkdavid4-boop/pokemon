package pokemon.pokemon;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class PokemonNotFoundAdvice {

	@ExceptionHandler(PokemonNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String pokemonNotFoundHandler(PokemonNotFoundException ex) {
	    return ex.getMessage();
	  }
}
