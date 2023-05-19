package controller;

import java.time.LocalDate;

import Enums.BookGenre;
import Enums.MagazinePeriodicity;
import dao.ElementDAO;
import dao.IElementDAO;
import dao.ILoanDAO;
import dao.IUserDAO;
import dao.LoanDAO;
import dao.UserDAO;
import model.Book;
import model.Loan;
import model.Magazine;
import model.User;

public class Main {

	public static void main(String[] args) {
		IElementDAO elementDAO = new ElementDAO();
		ILoanDAO loanDAO = new LoanDAO();
        IUserDAO userDAO = new UserDAO();
		
		Book recipe1 = new Book("Cooking With Nina", 2022, 188, "Nina Culic", BookGenre.COOKING);
		elementDAO.save(recipe1);
		Book recipe2 = new Book("Recooking With Nina", 2023, 222, "Nina Culic", BookGenre.COOKING);
		elementDAO.save(recipe2);
		
//		Book bio1 = new Book("Io&LaMiaOssessione", 2017, 150, "Mario Mario", BookGenre.BIOGRAPHY);
//		elementDAO.save(bio1);
//		
//		Book horror1 = new Book("Boo", 2023, 100, "Paolo Scavalcacinghie", BookGenre.HORROR);
//		elementDAO.save(horror1);
//		Book horror2 = new Book("IT", 2023, 100, "Steven King", BookGenre.HORROR);
//		elementDAO.save(horror2);
//		
//		Book other1 = new Book("Playgirl", 2023, 40, "Minchio Mariano", BookGenre.OTHER);
//		elementDAO.save(other1);
//		
//		Magazine hunting1 = new Magazine("Hunting Weekly", 2023, 45, MagazinePeriodicity.WEEKLY);
//		elementDAO.save(hunting1);
//		
//		Magazine javalearning1 = new Magazine("Learning Java Ch.1", 2018, 50, MagazinePeriodicity.MONTLHY);
//		elementDAO.save(javalearning1);
//		Magazine javalearning2 = new Magazine("Learning Java Ch.2", 2019, 52, MagazinePeriodicity.MONTLHY);
//		elementDAO.save(javalearning2);
//		
//		Magazine novella2000_1 = new Magazine("Novella 2000 1", 2020, 70, MagazinePeriodicity.SEMIANNUAL);
//		elementDAO.save(novella2000_1);
//		Magazine novella2000_2 = new Magazine("Novella 2000 2", 2020, 68, MagazinePeriodicity.SEMIANNUAL);
//		elementDAO.save(novella2000_2);
//		Magazine novella2000_3 = new Magazine("Novella 2000 3", 2021, 75, MagazinePeriodicity.SEMIANNUAL);
//		elementDAO.save(novella2000_3);
		
		User user1 = new User("Pierpietro", "Mariano", LocalDate.of(1999, 1, 29));
		userDAO.save(user1);
		
		User user2 = new User("Mario", "Rossi", LocalDate.of(1980, 1, 1));
		userDAO.save(user2);
		
		Loan loan1 = new Loan(user1, recipe1, LocalDate.now(), null);
		loanDAO.save(loan1);
		
		loan1.setLoanReturn(LocalDate.of(2023, 6, 20));
		loanDAO.update(loan1);
		
	}
	
}
