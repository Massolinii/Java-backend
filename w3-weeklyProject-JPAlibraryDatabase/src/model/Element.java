package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "element")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "findAllElements", query = "SELECT el FROM Element el")
public class Element {
	
	@Id
	@SequenceGenerator(name = "element_seq", sequenceName = "element_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "element_seq")
	private Integer ISBN;
	
	@Column(nullable = false)
	private String Title;
	
	@Column(nullable = false)
	private Integer publicationYear;
	
	@Column(nullable = false)
	private Integer pageNumber;
	
	public Element(String title, Integer publicationYear, Integer pageNumber) {
		super();
		Title = title;
		this.publicationYear = publicationYear;
		this.pageNumber = pageNumber;
	}

	public Element() {
		super();
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "Element [ISBN=" + ISBN + ", Title=" + Title + ", publicationYear=" + publicationYear + ", pageNumber="
				+ pageNumber + "]";
	}
}
