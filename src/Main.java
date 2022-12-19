import java.util.ArrayList; 
import java.util.Scanner;
import airport.Airline;
import airport.Airplane;
import airport.Airport;
import airport.Flight;
import airport.Product;
import airport.Seat;
import classEnum.SeatClass;
import interfaces.ICompany;
import interfaces.IGroundTransportation;
import interfaces.IHelp;
import interfaces.IShop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger Logger = LogManager.getLogger(Main.class.getName());;
	public static void main(String[] args) {
		boolean done = false;
		Airport airport = new Airport();
		Scanner scanner = new Scanner(System.in);
		int input;
		while (!done) {
			Logger.info("(0) Exit");
			Logger.info("(1) Airlines");
			Logger.info("(2) Parking");
			Logger.info("(3) Ground Transportation");
			Logger.info("(4) Shops");
			Logger.info("(5) Help");
			Logger.info("Select Service: ");
			input = scanner.nextInt();
			while (input > 5 || input < 0) {
				breakPrompt();
				Logger.info("(0) Exit");
				Logger.info("Sorry, invalid input. Please try again.");
				Logger.info("(1) Airlines");
				Logger.info("(2) Parking");
				Logger.info("Select Service: ");
				input = scanner.nextInt();
			}
			breakPrompt();
			switch (input) {
			case 0:
				done = true;
				break;
			case 1:
				airlinesPrompt(airport);
				break;
			case 2:
				productsPrompt(airport);
				break;
			case 3:
				groundTransportationPrompt(airport);
				break;
			case 4:
				shopPrompt(airport);
				break;
			case 5:
				helpPrompt(airport);
				break;
			}
			breakPrompt();
		}
	}

	public static void shopPrompt(Airport airport) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		Logger.info("(0) Exit");
		Logger.info(airport.getShopList());
		Logger.info("Select: ");
		input = scanner.nextInt();
		if (input == 0) {
			return;
		}
		breakPrompt();
		shopSelectionPrompt(airport.getShops().get(input - 1));
	}

	public static void shopSelectionPrompt(IShop shop) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		Logger.info("(0) Exit");
		Logger.info("(1) Get Location");
		Logger.info("(2) Get Hours");
		Logger.info("Select: ");
		input = scanner.nextInt();
		switch (input) {
		case 0:
			return;
		case 1:
			Logger.info(shop.getLocation());
			break;
		case 2:
			Logger.info(shop.getHours());
			break;
		}
		Logger.info("(0) Exit");
		Logger.info("Select: ");
		scanner.next();
	}

	public static void helpPrompt(Airport airport) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		Logger.info("(0) Exit");
		Logger.info(airport.getHelpList());
		Logger.info("Select: ");
		input = scanner.nextInt();
		if (input == 0) {
			return;
		}
		breakPrompt();
		helpSelectionPrompt(airport.getHelp().get(input - 1));
	}

	public static void helpSelectionPrompt(IHelp help) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		Logger.info("(0) Exit");
		Logger.info("(1) Get Phone Number");
		Logger.info("(2) Get Email");
		Logger.info("Select: ");
		input = scanner.nextInt();
		switch (input) {
		case 0:
			return;
		case 1:
			Logger.info(help.getPhoneNumber());
			break;
		case 2:
			Logger.info(help.getEmail());
			break;
		}
		Logger.info("(0) Exit");
		Logger.info("Select: ");
		scanner.next();
	}

	public static void productsPrompt(ICompany company) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		Logger.info("(0) Exit");
		Logger.info(company.getProductList());
		Logger.info("Select: ");
		input = scanner.nextInt();
		if (input == 0) {
			return;
		}
		breakPrompt();
		purchaseProductPrompt(company, company.getProducts().get(input - 1));
	}

	public static void purchaseProductPrompt(ICompany company, Product product) {
		breakPrompt();
		if (company.purchase(product) == false) {
			Logger.info("Sorry, product selected is not available");
			productsPrompt(company);
		}
	}

	public static void airlinesPrompt(Airport airport) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		Logger.info("(0) Exit");
		Logger.info(airport.getAirlinesList());
		Logger.info("Select: ");
		input = scanner.nextInt();
		if (input == 0) {
			return;
		}
		breakPrompt();
		flightsPrompt(airport.getAirlines().get(input - 1));
		breakPrompt();
	}

	public static void flightsPrompt(Airline airline) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		ICompany company = null;
		Logger.info("(0) Exit");
		Logger.info(airline.getFlightList());
		Logger.info("Select: ");
		input = scanner.nextInt();
		breakPrompt();
		if (input == 0) {
			return;
		}
		company = airline.getFlights().get(input - 1).getAirplane();
		productsPrompt(company);
		breakPrompt();
	}

	public static void groundTransportationPrompt(Airport airport) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		Logger.info("(0) Exit");
		Logger.info(airport.getGroundTransportationList());
		Logger.info("Select: ");
		input = scanner.nextInt();
		if (input == 0) {
			return;
		}
		breakPrompt();
		IGroundTransportation groundTransportation = airport.getGroundTransportation().get(input - 1);
		ridePrompt(groundTransportation);
		breakPrompt();
	}

	public static void ridePrompt(IGroundTransportation groundTransportation) {
		groundTransportation.ride();
	}

	public static void breakPrompt() {
		for (int i = 0; i < 50; i++) {
			
		}
	}
}
