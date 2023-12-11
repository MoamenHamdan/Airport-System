package airport_Man_System;

import passengers.passenger;

public class Priorityqueue extends Priorityqueue_Linkedlist {
	public Priorityqueue() {
		super();
	}

	public void enqueue(Flight flight, int priority) {
		priorityEnqueue(flight, priority);
	}

	public void enqueueIgnorePriority(Flight flight, int priority) {
		insertAtBack(flight, priority);
	}
	public Flight peek() {
		return first.getData();
	}
	public Flight_Node dequeue() {
		return deleteFromFront();
	}

	public void deleteFlightById(int flightId) {
		Priorityqueue tempQueue = new Priorityqueue();
		while (!isEmpty()) {
			Flight_Node currentNode = dequeue();
			if (flightId != currentNode.getData().airplane.getId()) {
				tempQueue.enqueue(currentNode.getData(), currentNode.priority);
			}
		}
		while (!tempQueue.isEmpty()) {
			Flight_Node currentNode = tempQueue.dequeue();
			enqueue(currentNode.getData(), currentNode.priority);
		}
	}

	public Flight searchFlightById(int flightId) {
		Priorityqueue tempQueue = new Priorityqueue();
		Flight_Node foundNode = null;
		while (!isEmpty()) {
			Flight_Node currentNode = dequeue();
			if (flightId == currentNode.getData().airplane.getId()) {
				foundNode = currentNode;
			}
			tempQueue.enqueue(currentNode.getData(), currentNode.priority);
		}
		while (!tempQueue.isEmpty()) {
			Flight_Node currentNode = tempQueue.dequeue();
			enqueue(currentNode.getData(), currentNode.priority);
		}
		if(foundNode==null)
			return null;
		return foundNode.getData();
	}
	public void DisplayFlightICanAfford(int x) {
		Priorityqueue tempQueue = new Priorityqueue();

		System.out.println("Flights:");

		while (!isEmpty()) {
			Flight_Node currentNode = dequeue();
			if(currentNode.getData().ticketPrice<=x) {
			currentNode.getData().display();
			System.out.println();
			}
			tempQueue.enqueue(currentNode.getData(), currentNode.priority);
		}
		while (!tempQueue.isEmpty()) {
			Flight_Node currentNode = tempQueue.dequeue();
			enqueue(currentNode.getData(), currentNode.priority);
		}
	}
	public void displayFlightsbydestination(String d) {
		Priorityqueue tempQueue = new Priorityqueue();

		System.out.println("Flights:");

		while (!isEmpty()) {
			Flight_Node currentNode = dequeue();
			if(currentNode.getData().destination.equalsIgnoreCase(d)) {
			currentNode.getData().display();
			System.out.println();
			}
			tempQueue.enqueue(currentNode.getData(), currentNode.priority);
		}
		while (!tempQueue.isEmpty()) {
			Flight_Node currentNode = tempQueue.dequeue();
			enqueue(currentNode.getData(), currentNode.priority);
		}
	}
	public void displayAllFlights() {
		Priorityqueue tempQueue = new Priorityqueue();

		System.out.println("All Flights:");

		while (!isEmpty()) {
			Flight_Node currentNode = dequeue();
			currentNode.getData().display();
			System.out.println();
			tempQueue.enqueue(currentNode.getData(), currentNode.priority);
		}
		while (!tempQueue.isEmpty()) {
			Flight_Node currentNode = tempQueue.dequeue();
			enqueue(currentNode.getData(), currentNode.priority);
		}
	}

	public void Displaymyflights(passenger foundPassenger) {
		Priorityqueue tempQueue = new Priorityqueue();
		while (!isEmpty()) {
			Flight_Node currentNode = dequeue();
			if(currentNode.getData().searchPassenger(foundPassenger)) {
			currentNode.getData().display();
			System.out.println();
			}
			tempQueue.enqueue(currentNode.getData(), currentNode.priority);
		}
		while (!tempQueue.isEmpty()) {
			Flight_Node currentNode = tempQueue.dequeue();
			enqueue(currentNode.getData(), currentNode.priority);
		}
	}



}
