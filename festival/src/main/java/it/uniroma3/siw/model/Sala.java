package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

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
	@OneToMany(mappedBy = "salaAppartenenza")
	private List<Proiezione> proiezioniProgrammate;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	public List<Proiezione> getProiezioniProgrammate() {
		return proiezioniProgrammate;
	}

	public void setProiezioniProgrammate(List<Proiezione> proiezioniProgrammate) {
		this.proiezioniProgrammate = proiezioniProgrammate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(capienza, indirizzo, nome, proiezioniProgrammate);
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
		Sala other = (Sala) obj;
		return Objects.equals(capienza, other.capienza) && Objects.equals(indirizzo, other.indirizzo)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(proiezioniProgrammate, other.proiezioniProgrammate);
	}
}
