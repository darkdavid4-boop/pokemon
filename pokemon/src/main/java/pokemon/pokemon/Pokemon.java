package pokemon.pokemon;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Pokemon {

	private @Id
	@GeneratedValue long id;
	private String name;
	private String type1;
	private String type2;
	
	Pokemon(){}
	
	Pokemon(String name, String type1, String type2){
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType1() {
		return this.type1;
	}
	public String getType2() {
		return this.type2;
	}
	
	public void setId(Long id) {
	    this.id = id;
	}

	  public void setName(String name) {
	    this.name = name;
	}

	  public void setType1(String type1) {
	    this.type1 = type1;
	}
	  public void setType2(String type2) {
		    this.type2 = type2;
		}
	  
	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Pokemon))
	      return false;
	    Pokemon pokemon = (Pokemon) o;
	    return Objects.equals(this.id, pokemon.id) && Objects.equals(this.name, pokemon.name)
	        && Objects.equals(this.type1, pokemon.type1) && Objects.equals(this.type2, pokemon.type2);
	  }
	  
	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.name, this.type1, this.type2);
	  }
	  
	  @Override
	  public String toString() {
	    return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", type1='" + this.type1 + '\'' + '}' 
	    		+ ", type2='" + this.type2 + '\'' + '}';
	  }
}
