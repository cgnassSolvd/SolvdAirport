package airport;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import classEnum.SeatClass;
import exception.ColOutOfBoundsException;
import exception.RowOutOfBoundsException;
import interfaces.ICompany;

public class Airplane implements ICompany {
	private String name;
	private Seat[][] seats;
	private int rows;
	private int columns;
	final private float firstClassPrice = (float)10245.75;
	final private float businessClassPrice = (float)10245.75;
	final private float economyClassPrice = (float)10245.75;
	private static Logger logger;
	
	public Airplane(String name, int rows, int columns) {
		logger = LogManager.getLogger(Airplane.class);
		
		this.name = name;
		this.rows = rows;
		this.columns = columns;
		float price = 0;
		SeatClass seatClass = SeatClass.FIRST;
		this.seats = new Seat[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(i < rows/5) {
					price = firstClassPrice;
				} else if(i < rows/2) {
					price = businessClassPrice;
					seatClass = SeatClass.BUSINESS;
				} else {
					price = economyClassPrice;
					seatClass = SeatClass.ECONOMY;
				}
				String seatId = "";
				char colId;
				colId = (char) (64 + j + 1);
				seatId += (Character.toString(colId) + (i + 1));
				Seat seat = new Seat(seatId, price, seatClass, true);
				seats[i][j] = seat;
			}
		}	
	}

	public Airplane(Airplane airplane) {
		this.name = airplane.name;
		this.seats = new Seat[airplane.rows][airplane.columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.seats[i][j] = airplane.seats[i][j];
			}
		}
		this.rows = airplane.rows;
		this.columns = airplane.columns;
	}

	public String getName() {
		return name;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setSeat(int row, int col, float price, SeatClass seatClass, boolean isAvailable) {
		String seatId = "";
		char colId;
		colId = (char) (64 + col);
		try {
			checkRow(row, this.getRows());
		} catch (RowOutOfBoundsException e) {
			logger.error("Row out of bounds");
		}
		try {
			checkCol(col, this.getColumns());
		} catch (ColOutOfBoundsException e) {
			logger.error("Column out of bounds");
		}
		seatId += (Character.toString(colId) + row);
		Seat seat = new Seat(seatId, price, seatClass, isAvailable);
		seats[row - 1][col - 1] = seat;
	}

	public Seat getSeat(String seatId) {
		for (int i = 0; i < this.seats.length; i++) {
			for (int j = 0; j < this.seats[0].length; j++) {
				if (seats[i][j] != null && seats[i][j].getName().equals(seatId)) {
					return seats[i][j];
				}
			}
		}
		return null;
	}

	public Seat[][] getSeats() {
		Seat[][] seats = new Seat[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				seats[i][j] = new Seat(this.seats[i][j]);
			}
		}
		return seats;
	}

	public String getSeatList() {
		String list = "";
		for (int i = 0; i < this.seats.length; i++) {
			for (int j = 0; j < this.seats[0].length; j++) {
				if (seats[i][j] != null) {
					list += (seats[i][j].toString() + "\n");
				} else {
					list += "NULL\n";
				}
			}
		}
		return list;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (!(object instanceof Seat)) {
			return false;
		}
		Airplane airplane = (Airplane) object;
		if (rows != airplane.getRows() || columns != airplane.getColumns()) {
			return false;
		}
		for (int i = 0; i < airplane.getSeats().length; i++) {
			for (int j = 0; j < airplane.getSeats()[0].length; j++) {
				if (!seats[i][j].equals(airplane.getSeats()[i][j])) {
					return false;
				}
			}
		}
		if (name.equals(airplane.getName())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + columns + (rows / 2);
	}

	@Override
	public ArrayList<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<>();
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
					products.add(seats[i][j]);
			} 
		}
		return products;
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

	@Override
	public Product getProduct(String name) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (seats[i][j].getName().equals(name) && seats[i][j].getIsAvailable() == true) {
					return new Seat(seats[i][j]);
				}
			}
		}
		return null;
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
	
	private static void checkRow(int row, int bound) throws RowOutOfBoundsException {
		if (row > bound || row < 1) {
			throw new RowOutOfBoundsException("Row is out of bounds");
		}
	}

	private static void checkCol(int col, int bound) throws ColOutOfBoundsException {
		if (col > bound || col < 1) {
			throw new ColOutOfBoundsException("Column is out of bounds");
		}
	}

}
