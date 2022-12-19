package airport;
import java.util.ArrayList;
import java.util.HashMap;

import interfaces.ICompany;
import interfaces.IHelp; 

public class Airline implements IHelp{
	private ArrayList<Flight> flights;
	private String name;
	private String phoneNumber;
	private String email;
	
	public Airline(String name, String phoneNumber, String email, ArrayList<Flight> flights) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email; 
		this.flights = flights;
	}
	
	public Airline() {
		Airplane airplane1 = new Airplane("Boeing 256", 10, 2);
		Airplane airplane2 = new Airplane("Boeing 456", 20, 4);
		Flight flight1 = new Flight(airplane1 , "DC", "Paris", 1, 1, 2023, 1, 0);
		Flight flight2 = new Flight(airplane2 , "DC", "New York", 1, 1, 2023, 1, 0);
		ArrayList<Flight> flights = new ArrayList<>();
		flights.add(flight1);
		flights.add(flight2); 
		this.name = "Delta";
		this.phoneNumber = "636-474-5794";
		this.email = "deltaairlines@gmail.com";
		this.flights = flights;
	}


	public Flight getFlight(int flightNumber) {
		return flights.get(flightNumber);
	}
	
	
	public ArrayList<Flight> getFlights(){
		return flights;
	}

	public String getFlightList() {
		String flightList = "";
		ArrayList<Flight> flights = this.getFlights();
		for (int i = 0; i < flights.size(); i++) {

			flightList += ("(" + (i + 1) + ") " + flights.get(i).toString() + "\n");

		}
		return flightList;
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
	public String toString() {
		return name;
	}

	@Override
	public ArrayList<IHelp> getHelp() {
		ArrayList<IHelp> help = new ArrayList<>();
		help.add(this);
		return help;
	}

	@Override
	public String getHelpList() {
		String help = "";
		for(int i = 0; i < this.getHelp().size(); i++) {
			help += this.getHelp().get(i);
		}
		return help;
	}
}
