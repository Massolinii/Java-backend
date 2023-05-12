package com.library.database;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.io.IOException;

public class Library {
	public static void main(String[] args) {
		Catalog catalog = new Catalog();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Welcome to Scavalcacinghie BookStore!");
			System.out.println("1. Add an element to the Catalog.");
			System.out.println("2. Remove an element from the Catalog.");
			System.out.println("3. Search by ISBN.");
			System.out.println("4. Search by Publication Year.");
			System.out.println("5. Search by Author.");
			System.out.println("6. Save current data to file.");
			System.out.println("7. Load current data from file.");
			System.out.println("0. Exit.");
			
			try {
				int option = Integer.parseInt(scanner.nextLine());
				
				switch(option) {
				case 1:
					System.out.println("Adding a new Element in the Catalog.");
			        System.out.println("Please select type: (1 for Books, 2 for Magazine)");
			        int elementType = Integer.parseInt(scanner.nextLine());

			        System.out.println("ADD ISBN:");
			        String isbn = scanner.nextLine();
			        System.out.println("ADD Title:");
			        String title = scanner.nextLine();
			        System.out.println("ADD Release Year:");
			        int releaseYear = Integer.parseInt(scanner.nextLine());
			        System.out.println("Add Page Number:");
			        int pageNum = Integer.parseInt(scanner.nextLine());

			        if(elementType == 1) {
			            System.out.println("Add Author:");
			            String author = scanner.nextLine();
			            System.out.println("Add Genre:");
			            String genre = scanner.nextLine();
			            catalog.addElement(new Book(isbn, title, releaseYear, pageNum, author, genre));
			        } else if(elementType == 2) {
			            System.out.println("Add Periodicity: (WEEKLY, MONTHLY, SEMIANNUAL)");
			            Magazine.Periodicity period = Magazine.Periodicity.valueOf(scanner.nextLine().toUpperCase());
			            catalog.addElement(new Magazine(isbn, title, releaseYear, pageNum, period));
			        } else {
			            System.out.println("Unvalid Type. Please Retry.");
			        }
			        break;
				case 2:
			        System.out.println("Add ISBN of the Element to remove:");
			        String removeIsbn = scanner.nextLine();
			        catalog.removeElement(removeIsbn);
					break;
				case 3:
					System.out.println("Add ISBN of the Element to search:");
				    String searchIsbn = scanner.nextLine();
				    Optional<Deployable> result = catalog.searchISBN(searchIsbn);
				    if(result.isPresent()) {
				        System.out.println("Element found: " + result.get());
				    } else {
				        System.out.println("Nothing found for this ISBN.");
				    }
				    break;
				case 4:
					System.out.println("Add Publish Year to search:");
				    int year = Integer.parseInt(scanner.nextLine());
				    List<Deployable> results = catalog.searchYear(year);
				    if(!results.isEmpty()) {
				        System.out.println("Elements found:");
				        for(Deployable item : results) {
				            System.out.println(item);
				        }
				    } else {
				        System.out.println("Nothing found for this Year.");
				    }
				    break;
				case 5:
					System.out.println("Add author name to search:");
				    String author = scanner.nextLine();
				    List<Book> authorResults = catalog.searchAuthor(author);
				    if(!authorResults.isEmpty()) {
				        System.out.println("Books found:");
				        for(Book book : authorResults) {
				            System.out.println(book);
				        }
				    } else {
				        System.out.println("No books found for this author.");
				    }
				    break;
				case 6:
					 try {
					        catalog.writeToDisk();
					        System.out.println("Catalog successfully uploaded to file.");
					    } catch(IOException e) {
					        System.out.println("There was an error during file upload...");
					    }
					    break;
				case 7:
					try {
				        catalog.loadFromDisk();
				        System.out.println("Catalog successfully loaded from file.");
				    } catch(IOException e) {
				        System.out.println("There was an error during file download...");
				    }
				    break;
				case 0:
					System.out.println("Arrivederci!");
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Unvalid response. Please try again.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please use a number from 1 to 8.");

			}
		}
	}

}
