package airport;

import interfaces.ISpot;

public class Parking extends Product implements ISpot {

	public Parking(String name, float price, boolean isAvailable) {
		super(name, price, isAvailable);
	}

	@Override
	public void request(String string) {
		System.out.println("Parking Spot " + this.getName() + " has been reserved");
	}

	@Override
	public String toString() {
		String isAvailable = "";
		if (this.getIsAvailable()) {
			isAvailable += "Available";
		} else {
			isAvailable += "Not Available";
		}
		return "Parking Spot: " + this.getName() + " | Price: $" + this.getPrice() + " | " + isAvailable;
	}
}
