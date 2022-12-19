package airport;

import classEnum.SeatClass; 

public class Seat extends Product{
	private SeatClass seatClass;

	public Seat(String name, float price, SeatClass seatClass, boolean isAvailable) {
		super(name, price, isAvailable);
		this.seatClass = seatClass;	
	}
	 
	public Seat(Seat seat) {
		super(seat.getName(), seat.getPrice(), seat.getIsAvailable());
		this.seatClass = seat.seatClass;	
	}

	public SeatClass getSeatClass() {
		return seatClass;
	}
	
	@Override
	public String toString() {
		String seatClass = "";
		String isOccupied = "";
		switch (this.seatClass) {
		case FIRST:
			seatClass = " - First Class ";
		case BUSINESS:
			seatClass = " - Business Class ";
		case ECONOMY:
			seatClass = " - Economy Class ";
		}
		if (this.getIsAvailable()) {
			isOccupied = "Open";
		} else {
			isOccupied = "Taken";
		}
		return this.getName() + seatClass + " : " + " $" + this.getPrice() + " [" + isOccupied + "]";
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (!(object instanceof Seat)) {
			return false;
		}
		Seat seat = (Seat) object;
		if (super.getName().equals(seat.getName()) && seatClass.equals(seat.getSeatClass()) 
				&& this.getIsAvailable()== seat.getIsAvailable()) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (int) (super.getName().hashCode() + seatClass.hashCode());
	}
}
