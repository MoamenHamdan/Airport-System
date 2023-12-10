package airport_Man_System;

public class Flight_Node {
	private Flight data;
	int priority;
	Flight_Node next;

	public Flight_Node(Flight data, int p) {
		this.setData(data);
		priority = p;
		next = null;
	}

	public Flight getData() {
		return data;
	}

	public void setData(Flight data) {
		this.data = data;
	}

}
