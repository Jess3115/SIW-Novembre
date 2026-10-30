package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"filmRecensito", "utenteRegistrato"}))
public class Recensione extends EntitaBase {

	@NotBlank
	@Column(length = 2000)
	private String testo;
	
	@NotNull
	@Min(1)
	@Max(5)
	private Integer voto;
	
	private LocalDateTime data;
	
	//una recensione riguarda un film 
	@ManyToOne
	private Film filmRecensito;
	
	//una recensione è scritta da un utente registrato
	@ManyToOne
	private Utente utente;

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Integer getVoto() {
		return voto;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Film getFilmRecensito() {
		return filmRecensito;
	}

	public void setFilmRecensito(Film filmRecensito) {
		this.filmRecensito = filmRecensito;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(data, filmRecensito, testo, utente, voto);
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
		Recensione other = (Recensione) obj;
		return Objects.equals(data, other.data) && Objects.equals(filmRecensito, other.filmRecensito)
				&& Objects.equals(testo, other.testo) && Objects.equals(utente, other.utente)
				&& Objects.equals(voto, other.voto);
	}
}
