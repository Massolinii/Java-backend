package com.library.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Magazine extends Deployable {
	
	private static final Logger log = LoggerFactory.getLogger(Magazine.class);
	
	private Periodicity period;
	
	public enum Periodicity {
		WEEKLY, 
		MONTHLY, 
		SEMIANNUAL;
	}

	public Magazine(String isbn, String title, int releaseYear, int pageNum, Periodicity period) {
		super(isbn, title, releaseYear, pageNum);
		this.period = period;
	}

	public Periodicity getPeriod() {
		return period;
	}

	public void setPeriod(Periodicity period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "Magazine, " + getIsbn() + ", " + getTitle() + ", " + getReleaseYear() + ", " + getPageNum() + ", " + period;
	}
	
	// Metodo statico per creare un oggetto Magazine da una stringa
	public static Magazine fromString(String str) {
	    String[] parts = str.split(", ");
	 // Se la lunghezza dell'array non è la lunghezza attesa (5) lancia un'eccezione
	    if (parts.length != 5) {
	        return null;
	    }

	    try {
	        String isbn = parts[0];
	        String title = parts[1];
	        int releaseYear = Integer.parseInt(parts[2]);
	        int pageNum = Integer.parseInt(parts[3]);
	        Periodicity period;
	        try {
	            period = Periodicity.valueOf(parts[4]);
	        } catch (IllegalArgumentException e) {
	            log.error("Invalid Periodicity value in Magazine.fromString: " + parts[5], e);
	            return null;
	        }
	        
	        return new Magazine(isbn, title, releaseYear, pageNum, period);
	    } catch (NumberFormatException e) {
	        log.error("NumberFormatException in Magazine.fromString: ", e);
	        return null;
	    }
	}
}
