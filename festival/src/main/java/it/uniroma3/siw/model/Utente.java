package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Utente extends EntitaBase {

	@NotBlank(message = "inserisci un username")
	@Column(nullable = false, unique = true)
	private String username;
	
	@NotBlank(message = "la password è obbligatoria")
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private RuoloUtente ruolo;
	
	@OneToMany(mappedBy = "utente")
	private List<Recensione> recensioni;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RuoloUtente getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloUtente ruolo) {
		this.ruolo = ruolo;
	}

	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(password, recensioni, ruolo, username);
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
		Utente other = (Utente) obj;
		return Objects.equals(password, other.password) && Objects.equals(recensioni, other.recensioni)
				&& ruolo == other.ruolo && Objects.equals(username, other.username);
	}
}
