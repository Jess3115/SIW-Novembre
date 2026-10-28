package it.uniroma3.siw.model;

public enum StatoProiezione {
	SCHEDULED("Programmata"),
	COMPLETED("Completata"),
	CANCELLED("Cancellata");
	
	private final String stato;
	
	StatoProiezione(String stato){
		this.stato = stato;
	}

	public String getEtichetta() {
		return stato;
	}
}
