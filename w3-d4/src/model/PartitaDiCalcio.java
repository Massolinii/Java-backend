package model;

import javax.persistence.Entity;

@Entity
public class PartitaDiCalcio extends Evento {
	
	private String SquadraCasa;
	private String SquadraOspite;
	private String SquadraVincente = null;
	private Integer numeroGolCasa = 0;
	private Integer numeroGolOspite = 0;
	
	
	public String getSquadraCasa() {
		return SquadraCasa;
	}
	public void setSquadraCasa(String squadraCasa) {
		SquadraCasa = squadraCasa;
	}
	public String getSquadraOspite() {
		return SquadraOspite;
	}
	public void setSquadraOspite(String squadraOspite) {
		SquadraOspite = squadraOspite;
	}
	public String getSquadraVincente() {
		return SquadraVincente;
	}
	public void setSquadraVincente(String squadraVincente) {
		SquadraVincente = squadraVincente;
	}
	public Integer getNumeroGolCasa() {
		return numeroGolCasa;
	}
	public void setNumeroGolCasa(Integer numeroGolCasa) {
		this.numeroGolCasa = numeroGolCasa;
	}
	public Integer getNumeroGolOspite() {
		return numeroGolOspite;
	}
	public void setNumeroGolOspite(Integer numeroGolOspite) {
		this.numeroGolOspite = numeroGolOspite;
	}
	@Override
	public String toString() {
		return "PartitaDiCalcio [SquadraCasa=" + SquadraCasa + ", SquadraOspite=" + SquadraOspite + ", SquadraVincente="
				+ SquadraVincente + ", numeroGolCasa=" + numeroGolCasa + ", numeroGolOspite=" + numeroGolOspite + "]";
	}
	
}
