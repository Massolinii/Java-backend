package com.library.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Magazine extends Deployable {
	
	private static final Logger log = LoggerFactory.getLogger(Magazine.class);
	
	private Periodicity period;
	
	public enum Periodicity {
		SETTIMANALE,
		MENSILE,
		SEMESTRALE;
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
		return "Magazine," + getIsbn() + "," + getTitle() + "," + getReleaseYear() + "," + getPageNum() + "," + period;
	}
	
	public static Magazine fromString(String str) {
	    String[] parts = str.split(",");
	    if (parts.length != 6) {
	        return null;
	    }

	    try {
		    String isbn = parts[1];
		    String title = parts[2];
		    int releaseYear = Integer.parseInt(parts[3]);
		    int pageNum = Integer.parseInt(parts[4]);
		    Periodicity period = Periodicity.valueOf(parts[5]);
		    
		    return new Magazine(isbn, title, releaseYear, pageNum, period);
	    } catch (NumberFormatException e) {
	    	
	    	log.error("NumberFormatException in Magazine.fromString: ", e);
	    	return null;
	    }
}}
