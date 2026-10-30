package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
//per fare in modo che ci sia solo un attore per film che interpreta quel personaggio 
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"film_id", "attore_id", "personaggio"}))
public class PersonaggioInterpretato extends EntitaBase{
	
	@NotBlank
	@Column(nullable = false)
	private String personaggio;
	
	/*
	 * per quello specifico film con quello specifico attore esiste solo un personaggio
	 */
	
	//un personaggio appartiene ad uno o più film 
	@ManyToOne
	private Film film;
	
	//un personaggio interpretato può essere recitato da uno o più attori
	@ManyToOne
	private Attore attore;

	public String getPersonaggio() {
		return personaggio;
	}

	public void setPersonaggio(String personaggio) {
		this.personaggio = personaggio;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Attore getAttore() {
		return attore;
	}

	public void setAttore(Attore attore) {
		this.attore = attore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(attore, film, personaggio);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaggioInterpretato other = (PersonaggioInterpretato) obj;
		return Objects.equals(attore, other.attore) && Objects.equals(film, other.film)
				&& Objects.equals(personaggio, other.personaggio);
	}
}
