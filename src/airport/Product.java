package airport;

abstract public class Product {
	private String name;
	private float price;
	private boolean isAvailable;
	
	public Product(String name, float price, boolean isAvailable) {
		this.name = name;
		this.price = price;
		this.isAvailable = isAvailable;
	}
	
	public String getName() {
		return name;
	}
	
	public float getPrice() {
		return price;
	} 
	
	public boolean getIsAvailable() {
		return isAvailable;
	}
	
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}
