package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
}
