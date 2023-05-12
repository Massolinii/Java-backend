package w2.d4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Main {
	
	private static List<Order> listaOrdini = new ArrayList <Order>();
	private static List<Product> listaProdotti = new ArrayList <Product>();
	
	public static void main(String[] args) {
		
		Product p1 = new Product(1L, "1984", "Books", 19.90);
		Product p2 = new Product(2L, "Pannolini", "Baby", 5.0);
		Product p3 = new Product(3L, "Jeans", "Boys", 23.30);
		Product p4 = new Product(4L, "Animal Farm", "Books", 108.90);
		Product p5 = new Product(5L, "Culla", "Baby", 88.05);
		Product p6 = new Product(6L, "Shirt", "Boys", 18.90);
		
		Customer c1 = new Customer(1L, "Mario Rossi", 1);
		Customer c2 = new Customer(2L, "Paolo Scavalcacinghie", 2);
		Customer c3 = new Customer(3L, "Maria Culuniru", 3);
		
		//scolastico
		listaProdotti.add(p1);
		listaProdotti.add(p2);
		listaProdotti.add(p3);
		listaProdotti.add(p4);
		listaProdotti.add(p5);
		listaProdotti.add(p6);
		
		listaOrdini.add(new Order(1L, listaProdotti, c1));
		
		//serio
		listaOrdini.add(new Order(2L, Arrays.asList(p1, p3, p3), c2));
		listaOrdini.add(new Order(3L, Arrays.asList(p1, p2, p3, p4, p5), c3));

		System.out.println("Lista Prodotti");
		listaProdotti.forEach(p -> System.out.println(p));
		
		System.out.println("Lista Prodotti Books 100");
		List<Product> listaProdottiFiltrati = getProdotti("Books", 15.0);
		listaProdotti.forEach(p -> System.out.println(p));
		
		System.out.println("Lista Ordini baby");
		List<Order> listaOrdiniFiltrati = getOrder("baby");
		listaOrdiniFiltrati.forEach(p -> System.out.println(p));
		
		System.out.println("Lista Ordini Boys");
		List<Product> listaOrdiniScontati = getProdottiScontati("Boys", 0.9);
		listaOrdiniFiltrati.forEach(p -> System.out.println(p));
		
		System.out.println("Lista Prodotti TIER 2");
		List<Product> listaProdottiTier = getProdottiTier(2, LocalDate.of(2023, 05, 10), LocalDate.of(2023, 05, 12));
		listaProdottiTier.forEach(p -> System.out.println(p));
	}
	
	public static List<Product> getProdotti(String categoria, Double prezzo) {
		return listaProdotti.stream()
					 .filter(p -> p.getCategory().equals(categoria))
					 .filter(p -> p.getPrice() > prezzo)
					 .collect(Collectors.toList());
	}
	
	public static List<Order> getOrder(String categoria) {
		return listaOrdini.stream()
					.filter(o -> o.getProducts()
								  .stream()
								  .anyMatch(p -> p.getCategory().equalsIgnoreCase(categoria))
								  )
					.collect(Collectors.toList());
				
	}
	
	public static List<Product> getProdottiScontati(String categoria, Double sconto) {
		return listaProdotti.stream()
					.filter(p -> p.getCategory().equals(categoria))
					.map(p -> {
						Product pr = p;
						pr.setPrice(pr.getPrice() * sconto);
						return pr;
					})
					.collect(Collectors.toList());
	}
	
	public static List<Product> getProdottiTier(Integer tier, LocalDate dataStart, LocalDate dataEnd) {
		return listaOrdini.stream()
				.filter(o -> o.getCustomer().getTier() == tier)
				.filter(o -> o.getOrderDate().compareTo(dataStart) >= 0)
				.filter(o -> o.getOrderDate().compareTo(dataEnd) <= 0)
				.flatMap(o -> o.getProducts().stream())
				.distinct()
				.collect(Collectors.toList());
	}
	
}
