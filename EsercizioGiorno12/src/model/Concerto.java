package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import utils.Genere;
import utils.TipoEvento;

@Entity
@DiscriminatorValue("concerto")
public class Concerto extends Evento {

	@Column(nullable = false)
	private Genere genere;
	
	@Column(nullable = false)
	private boolean inStreaming;

	public Concerto(Genere genere, boolean inStreaming) {
		super();
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public Concerto() {
		super();
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public boolean isInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(boolean inStreaming) {
		this.inStreaming = inStreaming;
	}
	
	
	
}
