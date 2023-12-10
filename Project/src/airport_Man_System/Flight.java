package airport_Man_System;

import java.util.Scanner;

import passengers.passenger;
import passengers.passenger_Linkedlist;

public class Flight extends passenger_Linkedlist {
	protected static int id = 0;
	protected Airplane airplane;
	protected int ticketPrice;
	protected String destination;
	protected String company;
	protected String date;
	protected String duration;
	protected int nmbrOFsoldTickets;
	protected String takeOffTime;

	public Flight() {
		super();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Flight Details");
		System.out.println("Enter the number of seats:");
		airplane = new Airplane(id++, scan.nextInt());
		System.out.println("Enter the destiation of the flight:(word)");
		String destination = scan.next();
		this.destination = destination;
		System.out.println("Enter the Airline company:(word)");
		company = scan.next();
		System.out.println("Enter the date of the flight:(word)");
		date = scan.next();
		System.out.println("Enter the duration of the flight:(word)");
		duration = scan.next();
		System.out.println("Enter the takeoff time of the flight:(word)");
		takeOffTime = scan.next();
		System.out.println("Enter the seat price of the flight:");
		ticketPrice = scan.nextInt();
		nmbrOFsoldTickets = 0;
	}

	public boolean isEmpty() {
		return nmbrOFsoldTickets == 0;
	}

	public boolean isFull() {
		return nmbrOFsoldTickets == airplane.getNumberOfSeats();
	}

	public void edit(Flight x) {
		int xy=airplane.getId();
		airplane = x.airplane;
		id--;
		airplane.setId(xy);
		this.destination = x.destination;
		this.company = x.company;
		this.date = x.date;
		this.duration = x.duration;
		this.takeOffTime = x.takeOffTime;
		ticketPrice = x.ticketPrice;
		nmbrOFsoldTickets = x.nmbrOFsoldTickets;
	}

	public boolean addPassenger(passenger x) {
		if (!isFull()) {
			insertAtFront(x);
			nmbrOFsoldTickets++;
			return true;
		}
		return false;
	}

	public void display() {
		System.out.println("Flight ID: " + airplane.getId());
		System.out.println("Number of available seats: " + (airplane.getNumberOfSeats()-nmbrOFsoldTickets));
		System.out.println("Ticket price: " + ticketPrice);
		System.out.println("Destination: " + destination);
		System.out.println("Flight airline: " + company);
		System.out.println("Date : " + date);
		System.out.println("Duration: " + duration);
		System.out.println("Number of sold tickets : " + nmbrOFsoldTickets);
		System.out.println("Takeoff Time : " + takeOffTime);
		System.out.println();
	}

}
