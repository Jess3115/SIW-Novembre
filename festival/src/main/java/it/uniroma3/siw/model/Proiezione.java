package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Proiezione extends EntitaBase {

	@Column(nullable = false)
	private LocalDate data;
	
	@Column(nullable = false)
	private LocalTime ora;
	
	@Enumerated(EnumType.STRING) //salva il nome ("SCHEDULED") e non la posizione numerica. Così aggiungere o riordinare valori non corrompe i dati 
	@Column(nullable = false)
	private StatoProiezione stato = StatoProiezione.SCHEDULED;
	
	//una proiezione appartine a un festival
	@ManyToOne
	//la parte proprietaria avrà nel DB la FK
	//@JoinColumn(name="...") nel caso volessi cambiare il nome della colonna che genera nel db, di default sarà festivalAppartenenza_id
	private Festival festivalAppartenenza; 
	
	//una proiezione riguarda un film
	@ManyToOne
	private Film filmProiettato;
	
	
	//una proiezione si svolge in una sala
	@ManyToOne
	private Sala salaAppartenenza;


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public LocalTime getOra() {
		return ora;
	}


	public void setOra(LocalTime ora) {
		this.ora = ora;
	}


	public StatoProiezione getStato() {
		return stato;
	}


	public void setStato(StatoProiezione stato) {
		this.stato = stato;
	}


	public Festival getFestivalAppartenenza() {
		return festivalAppartenenza;
	}


	public void setFestivalAppartenenza(Festival festivalAppartenenza) {
		this.festivalAppartenenza = festivalAppartenenza;
	}


	public Film getFilmProiettato() {
		return filmProiettato;
	}


	public void setFilmProiettato(Film filmProiettato) {
		this.filmProiettato = filmProiettato;
	}


	public Sala getSalaAppartenenza() {
		return salaAppartenenza;
	}


	public void setSalaAppartenenza(Sala salaAppartenenza) {
		this.salaAppartenenza = salaAppartenenza;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(data, festivalAppartenenza, filmProiettato, ora, salaAppartenenza, stato);
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
		Proiezione other = (Proiezione) obj;
		return Objects.equals(data, other.data) && Objects.equals(festivalAppartenenza, other.festivalAppartenenza)
				&& Objects.equals(filmProiettato, other.filmProiettato) && Objects.equals(ora, other.ora)
				&& Objects.equals(salaAppartenenza, other.salaAppartenenza) && stato == other.stato;
	}
}
