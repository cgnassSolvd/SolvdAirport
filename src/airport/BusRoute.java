package airport;

public class BusRoute {
	private Node head;
	private int size = 0;
	private static class Node<T>{
		T data;
		Node next;
		Node(T data){
			this.data = data;
			this.next = null;
		}
	}
	
	public <T> void add(int index, T data) {
		Node curr = this.head;
		int i = 0;
		if(index > size || index < 0) {
			return;
		}
		if(index == 0) {
			if(this.head == null) {
				this.head = new Node(data);
			} else {
				Node node = new Node(data);
				node.next = this.head;
				this.head = node;
			}
		} else if(index == size) {
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = new Node(data);
		} else {
			while(i < index - 1) {
				curr = curr.next;
				i++;
			}
			Node node = new Node(data);
			node.next = curr.next;
			curr.next = node;
		}
		size++;
	}
	
	public void remove(int index) {
		int i = 0;
		if(size == 0 || size <= index || index < 0) {
			return;
		}
		if(index == 0) {
			Node node = this.head;
			this.head = node.next;
			node.next = null;
		} else {
			Node curr = this.head;
			while(i < index - 1) {
				curr = curr.next;
				i++;
			}
			Node trash = curr.next;
			curr.next = curr.next.next;
			trash.next = null;
		}
		size--;
	}
}
