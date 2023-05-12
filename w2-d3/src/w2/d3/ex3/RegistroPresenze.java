package w2.d3.ex3;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;

import w2.d3.ex2.ThreadExample;

public class RegistroPresenze {
	
	private static List<Presenza> listaPresenze = new ArrayList<Presenza>();
	private static String path = "dati/presenze.txt";
	private static File file = new File(path);
	
	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(RegistroPresenze.class);
		
		creaPresenze();
		
		listaPresenze.forEach(p -> System.out.println(p));
		
		try {
			leggiPresenze();
		} catch (IOException e) {
			log.error("ERRORE IO File " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	public static void creaPresenze() {
		listaPresenze.add(new Presenza("Mario Rossi", 5));
		listaPresenze.add(new Presenza("Joseph Green", 9));
		listaPresenze.add(new Presenza("Paolo Scavalcacinghie", 7));
	}
	
	public static void salvaPresenze() throws IOException {
		String presenzeTxt = "";
		for (Presenza presenza : listaPresenze) {
			if(presenzeTxt.length() != 0) {
				presenzeTxt += "#";
			}
			presenzeTxt += presenza;
		}
		FileUtils.writeStringToFile(file, presenzeTxt, "UTF-8");
	}
	
	public static void leggiPresenze() throws IOException {
		String presenzeTxt = FileUtils.readFileToString(file, "UTF-8");
		String[] arr = presenzeTxt.split("#");
		System.out.println(presenzeTxt);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("indice: " + i + " Valore: " + arr[i]);
		}
	}
}
