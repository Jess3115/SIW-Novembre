package it.uniroma3.siw.model;

public enum RuoloUtente {
	ADMIN("amministratore"),
	USER("utente");
	
	private final String ruolo;
	
	RuoloUtente(String ruolo){
		this.ruolo = ruolo;
	}

	public String getRuolo() {
		return ruolo;
	}
}
