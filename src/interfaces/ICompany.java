package interfaces;

import java.util.ArrayList;

import airport.Product;

public interface ICompany {
	public ArrayList<Product> getProducts();
	public String getProductList();
	public Product getProduct(String name);
	public boolean purchase(Product product);
}
