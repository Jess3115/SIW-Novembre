package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Attore extends EntitaBase {

	@NotBlank(message = "il nome è obbligatorio")
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(message = "il cognome è obbligatorio")
	@Column(nullable = false)
	private String cognome;
	
	private LocalDate dataNascita;
	
	private String nazionalita;
	
	//un attore può aver recitato in più film, in ogni film interpreta un personaggio
	@OneToMany(mappedBy = "attore")
	private List<PersonaggioInterpretato> filmRecitati;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public List<PersonaggioInterpretato> getFilmRecitati() {
		return filmRecitati;
	}

	public void setFilmRecitati(List<PersonaggioInterpretato> filmRecitati) {
		this.filmRecitati = filmRecitati;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cognome, dataNascita, filmRecitati, nazionalita, nome);
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
		Attore other = (Attore) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(dataNascita, other.dataNascita)
				&& Objects.equals(filmRecitati, other.filmRecitati) && Objects.equals(nazionalita, other.nazionalita)
				&& Objects.equals(nome, other.nome);
	}
}
