package airport;

import interfaces.IGroundTransportation;
import interfaces.ISpot;

public class Taxi implements IGroundTransportation, ISpot{
	private String name;
	private String nextLocation;
	private boolean isAvailable;

	public Taxi(String name) {
		this.name = name;
		this.isAvailable = false;
	}
	
	public Taxi() { 
		this.name = "Taxi 573";
		this.isAvailable = false;
		this.nextLocation = "None";
	}

	@Override
	public void ride() {
		isAvailable = false;
	}
	
	@Override
	public void request(String nextLocation) {
		this.nextLocation = nextLocation;
		System.out.println("Stop has been requested.");
	}
	
	@Override 
	public String toString() {
		return "Taxi " + name + " | Next Stop: " + this.nextLocation;
	}
}
