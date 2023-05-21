package model;

import javax.persistence.Entity;

import Enums.MagazinePeriodicity;

@Entity
public class Magazine extends Element {

	private MagazinePeriodicity magPeriodicity;

	public MagazinePeriodicity getMagPeriodicity() {
		return magPeriodicity;
	}

	public void setMagPeriodicity(MagazinePeriodicity magPeriodicity) {
		this.magPeriodicity = magPeriodicity;
	}
	
	public Magazine() {
		super();
	}
	
	public Magazine(String title, Integer publicationYear, Integer pageNumber, MagazinePeriodicity magPeriodicity) {
		super(title, publicationYear, pageNumber);
		this.magPeriodicity = magPeriodicity;
	}

	@Override
	public String toString() {
		return "MAGAZINE || TITLE: " + getTitle() + " | PERIODICITY " + magPeriodicity + " ( " + getPublicationYear() + " | Pages : " + getPageNumber() + " )";
	}
	
}
