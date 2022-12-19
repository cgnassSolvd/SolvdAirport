package airport;

import java.util.ArrayList; 
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;

import interfaces.ICompany;
import interfaces.IGroundTransportation;
import interfaces.IHelp;
import interfaces.IShop;

public class Airport implements ICompany, IHelp{
	private String name;
	private String phoneNumber;
	private String email;
	private ArrayList<Airline> airlines;
	private ArrayList<IHelp> customerServices;
	private ArrayList<IGroundTransportation> groundTransportation;
	private ArrayList<Product> parkingSpots;
	private ArrayList<IShop> shops;
	
	
	public Airport(String name, String phoneNumber, String email, ArrayList<Airline> airlines,
			ArrayList<Product> parkingSpots, ArrayList<IGroundTransportation> groundTransportation, ArrayList<IHelp> customerServices,
			ArrayList<IShop> shops) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.airlines = airlines;
		this.parkingSpots = parkingSpots;
		this.groundTransportation = groundTransportation;
		this.customerServices = customerServices;
		this.shops = shops;
	}

	public Airport() {
		ArrayList<Airline> airlines = new ArrayList<>();
		ArrayList<Product> parkingSpots = new ArrayList<>();
		ArrayList<IGroundTransportation> groundTransportation = new ArrayList<>();
		ArrayList<IHelp> customerServices = new ArrayList<>();
		ArrayList<IShop> shops = new ArrayList<>();
		shops.add(new Restaurant());
		shops.add(new Store());
		customerServices.add(this);
		
		groundTransportation.add(new Bus());
		groundTransportation.add(new Taxi());
		airlines.add(new Airline());
		customerServices.add(airlines.get(0));
		Parking parking1 = new Parking("A1", (float) 5.25, true);
		Parking parking2 = new Parking("A2", (float) 5.25, true);
		parkingSpots.add(parking1);
		parkingSpots.add(parking2);
		this.name = "Dulles";
		this.phoneNumber = "301-234-7372";
		this.email = "dullesairport@gmail.com";
		this.parkingSpots = parkingSpots;
		this.airlines = airlines;
		this.groundTransportation = groundTransportation;
		this.customerServices = customerServices;
		this.shops = shops;
	}
	
	public ArrayList<IShop> getShops(){
		return this.shops;
	}

	public ArrayList<Airline> getAirlines() {
		return this.airlines;
	}
	
	public ArrayList<IGroundTransportation> getGroundTransportation(){
		return this.groundTransportation;
	}
	
	public String getShopList() {
		String shopList = "";
		ArrayList<IShop> shops = this.getShops();
		for (int i = 0; i < shops.size(); i++) {
			shopList += ("(" + (i + 1) + ") " + shops.get(i).toString() + "\n");
		}
		return shopList;		
	}
	

	public String getAirlinesList() {
		String airlineList = "";
		ArrayList<Airline> airlines = this.getAirlines();
		for (int i = 0; i < airlines.size(); i++) {
			airlineList += ("(" + (i + 1) + ") " + airlines.get(i).toString() + "\n");
		}
		return airlineList;
	}
	
	public String getGroundTransportationList() {
		String groundTransportationList = "";
		ArrayList<IGroundTransportation> groundTransportation = this.getGroundTransportation();
		for (int i = 0; i < groundTransportation.size(); i++) {
			groundTransportationList += ("(" + (i + 1) + ") " + groundTransportation.get(i).toString() + "\n");
		} 
		return groundTransportationList;
	}

	@Override
	public ArrayList<Product> getProducts() {
		return this.parkingSpots;
	}

	@Override
	public String getProductList() {
		String productList = ""; 
		ArrayList<Product> products = this.getProducts();
		for (int i = 0; i < products.size(); i++) {

			productList += ("(" + (i + 1) + ") " + products.get(i).toString() + "\n");

		}
		return productList;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public Product getProduct(String name) {

		for (int i = 0; i < parkingSpots.size(); i++) {

			if (parkingSpots.get(i).getName().equals(name)) {
				return parkingSpots.get(i); 
			}

		}
		return null;
	}

	@Override
	public String getPhoneNumber() {
		return "Phone Number: " + this.phoneNumber;
	}

	@Override
	public String getEmail() {
		return "Email: " + this.email;
	}

	@Override
	public boolean purchase(Product product) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		System.out.println("(0) Exit");
		System.out.println("(1) Confirm Purchase: " + product.toString());
		System.out.print("Select: ");
		input = scanner.nextInt();
		if (product.getIsAvailable() == true && input == 1) {
			
			product.setIsAvailable(false);
			System.out.println(product.toString() + " - Purchased");
			System.out.println("(1) Continue");
			scanner.next();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public ArrayList<IHelp> getHelp() {
		return customerServices;
	}

	@Override
	public String getHelpList() {
		String helpList = "";
		for (int i = 0; i < customerServices.size(); i++) {
			helpList += ("(" + (i + 1) + ") " + customerServices.get(i).toString() + "\n");
		}
		return helpList;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
