package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

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
	private List<PersonaggioInterpretato> filmRecitati;
}
