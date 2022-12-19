package airport;

import interfaces.IShop;

public class Store implements IShop{
	private String name;
	private String hours;
	private String location;
	
	public Store(String name, String hours, String location) {
		this.name = name;
		this.hours = hours;
		this.location = location;
	}

	public Store() {
		this.name = "COACH";
		this.hours = "10:00PM - 11:00PM";
		this.location = "Post-Security / Concourse D";
	}
	
	@Override
	public String getHours() {
		return hours;
	}

	@Override
	public String getLocation() {
		return location;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
