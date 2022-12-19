package airport;

import java.util.TreeSet;

public class Bag {
	private String id;
	private TreeSet<Integer> bag;

	public Bag(String id) {
		this.id = id;
		bag = new TreeSet<>();
	}

	public void add(Integer x) {
		this.bag.add(x);
	}
}
