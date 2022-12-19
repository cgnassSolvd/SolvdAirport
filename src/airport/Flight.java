package airport;

import exception.DayException;
import exception.MonthException;
import exception.YearException;

public class Flight {
	final private static int dateFields = 3;
	private int flightNumber;
	private Airplane airplane;
	private String from;
	private String destination;
	private int[] date;
	private int[] departTime;

	public Flight(Airplane airplane, String from, String destination, int month, int day, int year, int departTimeHour,
			int departTimeMinute) {
		this.airplane = airplane;
		this.from = from;
		this.destination = destination;
		this.date = new int[dateFields];
		try {
			checkDay(day);
		} catch (DayException e) {
			e.printStackTrace();
		}
		try {
			checkMonth(month);
		} catch (MonthException e) {
			e.printStackTrace();
		}
		try {
			checkYear(year);
		} catch (YearException e) {
			e.printStackTrace();
		}
		this.date[0] = month;
		this.date[1] = day;
		this.date[2] = year;
		this.departTime = new int[2];
		this.departTime[0] = departTimeHour;
		this.departTime[1] = departTimeMinute;
		this.flightNumber = this.hashCode();
	}
	
	public Flight(Flight flight) {
		this.airplane = flight.airplane;
		this.from = flight.from;
		this.destination = flight.destination;
		this.date = new int[3];
		this.date[0] = flight.date[0];
		this.date[1] = flight.date[1];
		this.date[2] = flight.date[2];
		this.departTime = new int[2];
		this.departTime[0] = flight.departTime[0];
		this.departTime[1] = flight.departTime[1];
		this.flightNumber = this.hashCode();
	}

	public String getFrom() {
		return from;
	}

	public String getDestination() {
		return destination;
	}
	
	public Seat[][] getSeats(){
		return airplane.getSeats();
	}

	public int[] getDate() {
		int[] date = new int[3];
		date[0] = this.date[0];
		date[1] = this.date[1];
		date[2] = this.date[2];
		return date;
	}

	public int[] getDepartTime() {
		int[] departTime = new int[2];
		departTime[0] = this.departTime[0];
		departTime[1] = this.departTime[1];
		departTime[2] = this.departTime[2];
		return departTime;
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}
	
	public Airplane getAirplane() {
		return airplane;
	}
	
	public static void checkDay(int day) throws DayException {
		if(day > 31 || day < 1) {
			throw new DayException("Invalid Day");
		}
	}
	
	public static void checkMonth(int month) throws MonthException {
		if(month > 12 || month < 1) {
			throw new MonthException("Invalid Month");
		}
	}
	
	public static void checkYear(int year) throws YearException {
		if(year > 3000 || year < 1800) {
			throw new YearException("Invalid Year");
		}
	}

	@Override
	public String toString() {
		return "Flight Number: " + flightNumber + " | From: " + from + " | Destination: " + destination;
	}

	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (!(object instanceof Flight)) {
			return false;
		}
		Flight flight = (Flight) object;
		if (airplane.equals(flight.airplane) && from.equals(flight.getFrom())
				&& destination.equals(flight.getDestination()) && date[0] == flight.getDate()[0]
				&& date[1] == flight.getDate()[1] && date[2] == flight.getDate()[2]
				&& departTime[0] == flight.getDepartTime()[0] && departTime[1] == flight.getDepartTime()[1]) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return airplane.hashCode() + from.hashCode() + destination.hashCode();
	}
}
