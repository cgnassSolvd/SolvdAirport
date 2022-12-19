package airport;
import java.util.ArrayDeque;
import java.util.TreeSet;

public class BagProcessor {
	private ArrayDeque bags;
	
	public BagProcessor() {
		bags = new ArrayDeque();
	}
	
	public void add(Bag bag) {
		this.bags.add(bag);
	}
	
	public void remove(Bag bag) {
		this.bags.remove(bag);
	}
}
