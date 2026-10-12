package pokemon.pokemon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {

	private static final Logger log = LoggerFactory.getLogger(Database.class);
	
	@Bean
	CommandLineRunner initDatabase(PokemonRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Pokemon("Bulbasaur", "grass", "poison")));
			log.info("Preloading " + repository.save(new Pokemon("Charmander", "fire", "null")));
			log.info("Preloading " + repository.save(new Pokemon("Squirtle", "water", "null")));
		};
	}
}
