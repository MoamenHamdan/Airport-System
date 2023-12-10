package airport_Man_System;

public class Priorityqueue_Linkedlist {
	protected Flight_Node first;

	public Priorityqueue_Linkedlist() {
		first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertAtBack(Flight v, int p) {
		Flight_Node n = new Flight_Node(v, p);
		if (isEmpty()) {
			first = n;
		} else {
			Flight_Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = n;
			n.next = null;
		}
	}

	public void priorityEnqueue(Flight a, int priority2) {
		Flight_Node n = new Flight_Node(a, priority2);
		if (isEmpty())
			first = n;
		else if (priority2 > first.priority) {
			n.next = first;
			first = n;
		} else {
			Flight_Node current = first;
			while (current.next != null) {
				if (current.next.priority < priority2) {
					n.next = current.next;
					current.next = n;
					return;
				}
				current = current.next;
			}
			current.next = n;
			n.next = null;
		}
	}

	public Flight_Node deleteFromFront() {
		Flight_Node temp = first;
		if (!isEmpty()) {
			first = first.next;
		}
		return temp;
	}
	
	public void display() {
		Flight_Node current = first;
		while (current != null) {
			current.getData().display();
			System.out.print("");
			current = current.next;
		}
	}
}
