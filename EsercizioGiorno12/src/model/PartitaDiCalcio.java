package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("partita_di_calcio")
public class PartitaDiCalcio extends Evento {
	
	@Column(nullable = false)
	private String squadraCasa;
	
	@Column(nullable = false)
	private String squadraOspite;
	
	@Column
	private String squadraVincente;
	
	@Column(nullable = false)
	private int golSquadraCasa = 0;
	
	@Column(nullable = false)
	private int golSquadraOspite = 0;
	
	public PartitaDiCalcio() {
		super();
	}

	public PartitaDiCalcio(String squadraCasa, String squadraOspite, String squadraVincente, int golSquadraCasa,
			int golSquadraOspite) {
		super();
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.golSquadraCasa = golSquadraCasa;
		this.golSquadraOspite = golSquadraOspite;
	}

	public String getSquadraCasa() {
		return squadraCasa;
	}

	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public int getGolSquadraCasa() {
		return golSquadraCasa;
	}

	public void setGolSquadraCasa(int golSquadraCasa) {
		this.golSquadraCasa = golSquadraCasa;
	}

	public int getGolSquadraOspite() {
		return golSquadraOspite;
	}

	public void setGolSquadraOspite(int golSquadraOspite) {
		this.golSquadraOspite = golSquadraOspite;
	}
	
	
	
}
