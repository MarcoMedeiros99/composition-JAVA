package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		String name;
		String email;
		Date brithDate;
		String brithDateText;

		System.out.println("Enter cliente data");

		System.out.println("NAME: ");
		name = sc.nextLine();
		System.out.println("EMAIL: ");
		email = sc.nextLine();
		System.out.println("BIRTH DATE: (DD/MM/YYYY)");
		brithDateText = sc.nextLine();
		brithDate = sdf.parse(brithDateText);
		
		Client client = new Client(name, email, brithDate);

		System.out.println("Enter Order data");

		System.out.println("STATUS: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);

		System.out.println("How many items tu this order? ");
		int qtdOrder = sc.nextInt();
		sc.nextLine();

		String productName;
		Double productPrice;
		int quantity;

		for (int i = 0; i < qtdOrder; i++) {

			System.out.println("Enter #" + (i + 1) + " tem data: ");

			System.out.println("Product name: ");
			productName = sc.nextLine();
			System.out.println("Product price: ");
			productPrice = sc.nextDouble();
			System.out.println("Product quantity: ");
			quantity = sc.nextInt();
			sc.nextLine();

			Product product = new Product(productName, productPrice);
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);
			
		}
		
		System.out.println();
		System.out.println(order);

		sc.close();
	}

}
