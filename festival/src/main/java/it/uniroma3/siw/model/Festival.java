package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
//serve per creare un vincolo di unicità su più colonne in modo da non avere dei duplicati 
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "anno"}))
public class Festival extends EntitaBase {

	@NotBlank(message = "il nome è obbligatorio")
	@Column(nullable = false, unique = true) //l'entry non deve essere null e deve essere unica 
	private String nome;
	
	@NotNull(message = "l'anno è obbligatorio")
	@Min(value = 1900, message = "anno non valido deve essere superiore di 1900")
	@Max(value = 2100, message = "anno non valido deve essere minore di 2100")
	private Integer anno;
	
	@NotBlank(message = "la citta è obbligatoria")
	@Column(nullable = false)
	private String citta;
	
	@NotNull
	private LocalDate dataInizio;
	
	@NotNull
	private LocalDate dataFine;
	
	@Column(length = 2000)
	private String descrizione;
	
	//un festival presenta più film
	@ManyToMany //in festival (parte proprietaria: l'admin associa un film a un festival)
	private List<Film> filmPresentati;
	
	//un festival prevede più proiezioni
	@OneToMany(mappedBy = "festivalAppartenenza") //ci serve perchè è bidirezionale in modo da dire al db che c'è un collegamento con l'entità proiezione
	private List<Proiezione> proiezioniPreviste;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Film> getFilmPresentati() {
		return filmPresentati;
	}

	public void setFilmPresentati(List<Film> filmPresentati) {
		this.filmPresentati = filmPresentati;
	}

	public List<Proiezione> getProiezioniPreviste() {
		return proiezioniPreviste;
	}

	public void setProiezioniPreviste(List<Proiezione> proiezioniPreviste) {
		this.proiezioniPreviste = proiezioniPreviste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(anno, citta, dataFine, dataInizio, descrizione, filmPresentati, nome,
				proiezioniPreviste);
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
		Festival other = (Festival) obj;
		return Objects.equals(anno, other.anno) && Objects.equals(citta, other.citta)
				&& Objects.equals(dataFine, other.dataFine) && Objects.equals(dataInizio, other.dataInizio)
				&& Objects.equals(descrizione, other.descrizione)
				&& Objects.equals(filmPresentati, other.filmPresentati) && Objects.equals(nome, other.nome)
				&& Objects.equals(proiezioniPreviste, other.proiezioniPreviste);
	}
}
