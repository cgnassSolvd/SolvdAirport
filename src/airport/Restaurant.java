package airport;

import java.util.ArrayDeque;
import java.util.ArrayList;

import interfaces.ICompany;
import interfaces.IShop;

public class Restaurant implements IShop{
		private String name;
		private String hours;
		private String location;
		
		public Restaurant(String name, String hours, String location, boolean hasReservations) {
			this.name = name;
			this.hours = hours;
			this.location = location;
		}
		
		public Restaurant() {
			this.name = "Red Robin";
			this.hours = "11:00AM - 11:00PM";
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
