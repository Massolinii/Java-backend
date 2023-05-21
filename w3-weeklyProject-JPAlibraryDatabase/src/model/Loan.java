package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
@NamedQuery(name = "findAllLoan", query = "SELECT l FROM Loan l")
public class Loan {
	
	/* A Loan should have an ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	@OneToOne
	@JoinColumn(name = "element_id", nullable = false)
	private Element loanElement;
	
	@Column(nullable = false)
	private LocalDate loanStart;
	
	@Column(nullable = false)
	private LocalDate loanEnd;
	
	@Column
	private LocalDate loanReturn;

	public Loan() {
		super();
	}

	public Loan(User user, Element loanElement, LocalDate loanStart, LocalDate loanReturn) {
		super();
		this.user = user;
		this.loanElement = loanElement;
		this.loanStart = loanStart;
		this.loanEnd = loanStart.plusDays(30);
		this.loanReturn = loanReturn;
	}
	
	@Override
	public String toString() {
		
		return "LOAN || " + user + " BORROWED ITEM : " + loanElement 
				+ " | ON DATE : " + loanStart + " | RETURNED : " + (loanReturn != null ? "YES" : "NO") + (loanReturn != null ? "" : " | EXP. BY " + loanEnd) ;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Element getLoanElement() {
		return loanElement;
	}

	public void setLoanElement(Element loanElement) {
		this.loanElement = loanElement;
	}

	public LocalDate getLoanStart() {
		return loanStart;
	}

	public void setLoanStart(LocalDate loanStart) {
		this.loanStart = loanStart;
	}

	public LocalDate getLoanEnd() {
		return loanEnd;
	}

	public void setLoanEnd(LocalDate loanEnd) {
		this.loanEnd = loanEnd;
	}

	public LocalDate getLoanReturn() {
		return loanReturn;
	}

	public void setLoanReturn(LocalDate loanReturn) {
		this.loanReturn = loanReturn;
	}


	
}
