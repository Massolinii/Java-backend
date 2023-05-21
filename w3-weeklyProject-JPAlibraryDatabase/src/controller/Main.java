package controller;

import java.time.LocalDate;

import Enums.*;
import dao.*;
import model.*;

public class Main {

	public static void main(String[] args) {
		
		ElementDAOInterface elementDAO = new ElementDAO();
		LoanDAOInterface loanDAO = new LoanDAO();
        UserDAOInteface userDAO = new UserDAO();
		
        // Database creation 
        // Element creation 
        // Book creation
		Book recipe1 = new Book("Cooking With Nina", 2021, 188, "Nina Culic", BookGenre.COOKING);
		elementDAO.save(recipe1);
		Book recipe2 = new Book("Recooking With Nina", 2022, 222, "Nina Culic", BookGenre.COOKING);
		elementDAO.save(recipe2);
		Book recipe3 = new Book("Uncooking With Nina", 2023, 700, "Nina Culic", BookGenre.COOKING);
		elementDAO.save(recipe3);
		
		Book bio1 = new Book("Io&LaMiaOssessione", 2017, 150, "Mario Mario", BookGenre.BIOGRAPHY);
		elementDAO.save(bio1);
		
		Book horror1 = new Book("Boo", 2023, 100, "Paolo Scavalcacinghie", BookGenre.HORROR);
		elementDAO.save(horror1);
		Book horror2 = new Book("IT", 2023, 100, "Steven King", BookGenre.HORROR);
		elementDAO.save(horror2);
		
		Book other1 = new Book("Playgirl", 2023, 40, "Minchio Mariano", BookGenre.OTHER);
		elementDAO.save(other1);
		
		// Magazine creation
		Magazine hunting1 = new Magazine("Hunting Weekly", 2023, 45, MagazinePeriodicity.WEEKLY);
		elementDAO.save(hunting1);
		
		Magazine javalearning1 = new Magazine("Learning Java Ch.1", 2018, 50, MagazinePeriodicity.MONTLHY);
		elementDAO.save(javalearning1);
		Magazine javalearning2 = new Magazine("Learning Java Ch.2", 2019, 52, MagazinePeriodicity.MONTLHY);
		elementDAO.save(javalearning2);
		
		Magazine novella2000_1 = new Magazine("Novella 2000 1", 2020, 70, MagazinePeriodicity.SEMIANNUAL);
		elementDAO.save(novella2000_1);
		Magazine novella2000_2 = new Magazine("Novella 2000 2", 2020, 68, MagazinePeriodicity.SEMIANNUAL);
		elementDAO.save(novella2000_2);
		Magazine novella2000_3 = new Magazine("Novella 2000 3", 2021, 75, MagazinePeriodicity.SEMIANNUAL);
		elementDAO.save(novella2000_3);
		
		// DELETE ELEMENT 
		elementDAO.delete(recipe2);
		
		// SEARCH BY ISBN
		elementDAO.getElByISBN(11);
		// SEARCH BY YEAR 
		elementDAO.getElsByYear(2020);
		// SEARCH BY AUTHOR
		elementDAO.getElsByAuthor("Nina Culic");
		// SEARCH BY TITLE
		elementDAO.getElsByTitle("Nina");
		
		
		// User creation 
		User user1 = new User("Pierpietro", "Mariano", LocalDate.of(1999, 1, 29));
		userDAO.save(user1);
		User user2 = new User("Mario", "Rossi", LocalDate.of(1980, 1, 1));
		userDAO.save(user2);
		// Get user by ID
		userDAO.getUserById(1);
		
		// Loan creation 
		Loan loan1 = new Loan(user1, recipe1, LocalDate.now(), null);
		loanDAO.save(loan1);
		Loan loan2 = new Loan(user2, javalearning1, LocalDate.of(2012, 12, 21), null);
		loanDAO.save(loan2);
		
		// Loan research BY LOAN ID
		loanDAO.getLoanFromLoanId(1);
		// Loan research BY USER ID
		loanDAO.getLoansFromUserId(1);
		// Loan research BY EXPIRED DATE
		loanDAO.getExpiredLoans();
		
		// Loan return
		loan1.setLoanReturn(LocalDate.of(2023, 6, 20));
		loanDAO.update(loan1);
		// Loan research BY USER ID again, LOAN is returned
		loanDAO.getLoanFromLoanId(1);
		
	}
	
}
