package it.uniroma3.siw.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "indirizzo"}))
public class Sala extends EntitaBase {

	@NotBlank(message = "il nome è obbligatorio")
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(message = "l'indirizzo è obbligatorio")
	@Column(nullable = false)
	private String indirizzo;
	
	@Column(nullable = false)
	private Integer capienza;
	
	//una sala può ospitare più proiezioni
	private List<Proiezione> proiezioniProgrammate;
}
