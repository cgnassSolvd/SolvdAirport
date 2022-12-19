package airport;

import java.util.LinkedList;

import interfaces.IGroundTransportation;
import interfaces.ISpot;

public class Bus<T> implements IGroundTransportation{
	private String name;
	private int capacity;
	private int passengers;
	private LinkedList<T> stops;
	
	public Bus(String name, int capacity, int passengers, LinkedList<T> stops) {
		this.name = name;
		this.capacity = capacity;
		this.passengers = passengers; 
		this.stops = stops;
	}
	
	public Bus() { 
		this.name = "Shuttle 594";
		this.capacity = 20;
		this.passengers = 10;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public void ride() {
		passengers++;
	}
	
	@Override 
	public String toString() {
		return  name;
	}	
}
