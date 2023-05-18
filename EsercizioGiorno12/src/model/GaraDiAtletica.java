package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("gara_di_atletica")
public class GaraDiAtletica extends Evento {
	
	@Column(nullable = false)
	private Set<Persona> setAtleti;
	
	@Column(nullable = false)
	private Persona vincitore;

	public GaraDiAtletica(Set<Persona> setAtleti, Persona vincitore) {
		super();
		this.setAtleti = setAtleti;
		this.vincitore = vincitore;
	}
	
	public GaraDiAtletica() {
		super();
	}

	public Set<Persona> getSetAtleti() {
		return setAtleti;
	}

	public void setSetAtleti(Set<Persona> setAtleti) {
		this.setAtleti = setAtleti;
	}

	public Persona getVincitore() {
		return vincitore;
	}

	public void setVincitore(Persona vincitore) {
		this.vincitore = vincitore;
	}
	
	
}
