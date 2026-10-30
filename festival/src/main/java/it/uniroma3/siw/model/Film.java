package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import it.uniroma3.siw.validation.NotFutureYear;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Film extends EntitaBase {

	@NotBlank(message = "il titolo è obbligatorio")
	@Column(nullable = false)
	private String titolo;
	
	@NotNull
	@Min(value = 1900)
	@NotFutureYear
	private Integer anno;
	
	@NotNull
	@Column(nullable = false)
	private Integer durata;
	
	private String genere;
	
	private String regista;
	
	private String paeseProduzione;
	
	//un film può partecipare a uno o più festival
	@ManyToMany(mappedBy = "filmPresentati") //in film (parte inversa) [Il mappedBy lo metti nella classe che non gestisci direttamente quando crei l’associazione]
	private List<Festival> festivalPartecipante;
	
	//ogni film ha più attori, ciascuno dei quali interpreta un personaggio
	@OneToMany(mappedBy = "film", cascade= {CascadeType.PERSIST, CascadeType.REMOVE}) //per fare in modo che le operazioni avvengono in cascata a tutti gli oggetti collegati (composizione) influisce le prestazioni
	private List<PersonaggioInterpretato> cast;
	
	//un film può avere più proiezioni
	@OneToMany(mappedBy = "filmProiettato", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Proiezione> proiezioniPartecipante;
	
	//un film può avere più recensioni
	@OneToMany(mappedBy = "filmRecensito", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Recensione> recensioniRicevute;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public String getPaeseProduzione() {
		return paeseProduzione;
	}

	public void setPaeseProduzione(String paeseProduzione) {
		this.paeseProduzione = paeseProduzione;
	}

	public List<Festival> getFestivalPartecipante() {
		return festivalPartecipante;
	}

	public void setFestivalPartecipante(List<Festival> festivalPartecipante) {
		this.festivalPartecipante = festivalPartecipante;
	}

	public List<PersonaggioInterpretato> getCast() {
		return cast;
	}

	public void setCast(List<PersonaggioInterpretato> cast) {
		this.cast = cast;
	}

	public List<Proiezione> getProiezioniPartecipante() {
		return proiezioniPartecipante;
	}

	public void setProiezioniPartecipante(List<Proiezione> proiezioniPartecipante) {
		this.proiezioniPartecipante = proiezioniPartecipante;
	}

	public List<Recensione> getRecensioniRicevute() {
		return recensioniRicevute;
	}

	public void setRecensioniRicevute(List<Recensione> recensioniRicevute) {
		this.recensioniRicevute = recensioniRicevute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(anno, cast, durata, festivalPartecipante, genere, regista, paeseProduzione,
				proiezioniPartecipante, recensioniRicevute, titolo);
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
		Film other = (Film) obj;
		return Objects.equals(anno, other.anno) && Objects.equals(cast, other.cast)
				&& Objects.equals(durata, other.durata)
				&& Objects.equals(festivalPartecipante, other.festivalPartecipante)
				&& Objects.equals(genere, other.genere)
				&& Objects.equals(regista, other.regista) && Objects.equals(paeseProduzione, other.paeseProduzione)
				&& Objects.equals(proiezioniPartecipante, other.proiezioniPartecipante)
				&& Objects.equals(recensioniRicevute, other.recensioniRicevute) && Objects.equals(titolo, other.titolo);
	}
}
