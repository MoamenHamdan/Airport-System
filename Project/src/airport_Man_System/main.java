package airport_Man_System;

import java.util.Scanner;

import Admins.admin;
import Admins.adminMain;
import Admins.adminQueue;
import passengers.passenger;
import passengers.passengerMain;
import passengers.passenger_Linkedlist;

public class main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		adminQueue admins = new adminQueue();
		admins.insertAtBack(new admin("Jad","Elmoghraby",76751060,"123"));
		admins.insertAtBack(new admin("Moamen","Hamdan",71117842,"123"));
		Priorityqueue Flightqueue = new Priorityqueue();
		passenger_Linkedlist passengers = new passenger_Linkedlist();
		passengers.insertAtFront(new passenger("jad",2,"123",77777777));
		passengers.insertAtFront(new passenger("jad",4,"1234",77777777));
		System.out.println("\t\t\tWelcome to our Airport Managnment System");
		System.out.println("\t\t\t****************************************");
		int choice = 0;
		while (choice != -1) {
			System.out.println("----------------------------------");
			System.out.println("Enter Your choice: ");
			System.out.println("1)Admin");
			System.out.println("2)User");
			System.out.println("-1)Quit");
			System.out.println("----------------------------------");
			choice = scan.nextInt();
			System.out.println();
			switch (choice) {
			case 1:

				System.out.println("Do you have an account? (yes/no)");
				String answer = scan.next();
				if (answer.equalsIgnoreCase("yes")) {
					System.out.println("Please enter your ID: ");
					int id = scan.nextInt();
					System.out.println("Please enter the password: ");
					String password = scan.next();

					System.out.println("Checking account...");
					if (!(admins.checkAccount(id, password))) {
						System.out.println("Account doesn't match. Please retry.");
					} else {
						System.out.println("Welcome, admin!");
						int number = 0;
						while (number != -1) {

							System.out.println("\n1-edit account");
							System.out.println("2-display all the admins");
							System.out.println("3-delete admin by his Id");
							System.out.println("4-add Flight Plan");
							System.out.println("5-update Flight Plan");
							System.out.println("6-delete Flight Plan");
							System.out.println("7-display Flight Plans");
							System.out.println("8-add new admin");
							System.out.println("9-Search for an admin by his id ");
							System.out.println("-1 to exit");
							number = scan.nextInt();
							switch (number) {
							case 1:
								admins.editAccountInfo();
								break;
							case 2:
								admins.displayAllAdmins();
								break;
							case 3:
								System.out.println("Enter the ID of the admin you want to delete:");
								int deleteId = scan.nextInt();
								admins.deleteAdminById(deleteId);
								break;
							case 4:
								Flight flight = new Flight();
								Flightqueue.insertAtBack(flight, 0);
								break;
							case 5:
								System.out.println("Enter the flight id");
								int fid = scan.nextInt();
								Flight x = Flightqueue.searchFlightById(fid);
								if (x != null) {
									Flight flight2 = new Flight();
									x.edit(flight2);
								} else
									System.out.println("Flight Not Found!");
								break;
							case 6:
								System.out.println(
										"Enter the flight id to delete\nWARNING: This action cannot be undone!");
								int fid2 = scan.nextInt();
								if (Flightqueue.searchFlightById(fid2) != null)
									Flightqueue.deleteFlightById(fid2);
								else
									System.out.println("Flight Not Found!");
								break;
							case 7:
								Flightqueue.display();
								break;
							case 8:
								System.out.print("Enter your first name: ");
								String fn = scan.next();
								System.out.print("Enter your last name: ");
								String ln = scan.next();
								System.out.print("Enter your phone number: ");
								int pn = scan.nextInt();
								System.out.println("Enter your password : ");
								String pass = scan.next();
								admin newAdmin = new admin(fn, ln, pn, pass);
								System.out.println("Admin id is: " + newAdmin.getId());
								admins.enqueue(newAdmin);
								break;
							case 9:
								System.out.println("Enter the id for the admin you want to search about  ");
								int searchByAdminId = scan.nextInt();
								admin foundAdmin = admins.searchById(searchByAdminId);

								if (foundAdmin != null) {
									System.out.println(
											"Admin with id " + searchByAdminId + " is " + foundAdmin.getFirstName());

									System.out.print("And his phone number is : " + foundAdmin.getPhoneNumber());
								} else {
									System.out.println("Admin with id 2 not found");
								}

								break;

							default:
								System.out.println("invalid number");
								break;
							}
						}

					}

				} else {
					System.out.println("Enter the Airport password");
					String airpass=scan.next();
					if(airpass.equals(admin.getUniversalPass())) {
					System.out.print("Enter your first name: ");
					String fn = scan.next();
					System.out.print("Enter your last name: ");
					String ln = scan.next();
					int pn;

					do {
						System.out.print("Enter your phone number: ");
						pn = scan.nextInt();

						if (String.valueOf(pn).length() != 8) {
							System.out.println("Error: Phone number must have exactly 8 digits. Please re-enter.");
						}
					} while (String.valueOf(pn).length() != 8);

					System.out.print("Enter your password: ");
					String pass = scan.next();

					admin newAdmin = new admin(fn, ln, pn, pass);
					System.out.println("Admin id is: " + newAdmin.getId());
					admins.enqueue(newAdmin);
					System.out.println();
					}else
						System.out.println();
					
				}

				break;

			case 2:

				System.out.println("Do you have an account? (yes/no)");
				String answer1 = scan.next();

				if (answer1.equalsIgnoreCase("yes")) {

					System.out.println("Enter your name:");
					String name = scan.next();
					System.out.println("Enter your password:");
					String password = scan.next();

					passenger foundPassenger = passengers.searchPassengerByNameAndPassword(name,password);
					if (foundPassenger !=null) {
						System.out.println("Welcome, " + name + "!");
						int number = 0;
						while (number != -1) {
							System.out.println("\n1-Edit your account ");
							System.out.println("2-delete your account ");
							System.out.println("3-display your  account  ");
							System.out.println("4-display all the flight ");
							System.out.println("5-book a flight");
							System.out.println("-1 Exit");
							number = scan.nextInt();
							switch (number) {
							case 1:
								passengers.editPassengerAccount(foundPassenger);
								break;
							case 2:
								passengers.deletePassengerByNameWithConfirmation(foundPassenger.getName());
								break;
							case 3:
								passengers.displayPassengerInfo(foundPassenger);
								break;
							case 4:
								Flightqueue.displayAllFlights();
								break;
							case 5:
								Flightqueue.displayAllFlights();
								System.out.println("Please enter the Flight ID of your desired flight");
								int fid=scan.nextInt();
								Flight f=Flightqueue.searchFlightById(fid);
								if(f!=null) {
									if(f.isFull()) {
										System.out.println("Flight fully booked");
										break;
									}
										
									if(foundPassenger.getAccountBalance()>=f.ticketPrice) {
										System.out.println("Do you want to buy a ticket (yes/no)");
										String answer12 = scan.next();
										if (answer12.equalsIgnoreCase("yes")) {
											foundPassenger.setAccountBalance(foundPassenger.getAccountBalance()-f.ticketPrice);
											f.addPassenger(foundPassenger);
										}
									}else
										System.out.println("Insufficient funds");
								}
								else
									System.out.println("Invalid ID!");
								if(Flightqueue.peek()==f&&f.isFull()) {
									Flightqueue.dequeue();
									System.out.println("-----------------------------------------\nFlight with id\""+f.id+"\" took of to it's destination\n-----------------------------------------");
								}
								break;
							default:
								System.out.println("Invalid Input ");
								break;
							}

						}
					} else {
						System.out.println("Invalid name or password. Please try again.");
					}
				} else {

					System.out.println("Enter your name:");
					String name = scan.next();
					System.out.println("Enter your account balance:");
					int balance = scan.nextInt();
					System.out.println("Enter your password:");
					String password = scan.next();
					int pn;
					do {
						System.out.print("Enter your phone number: ");
						pn = scan.nextInt();

						if (String.valueOf(pn).length() != 8) {
							System.out.println("Error: Phone number must have exactly 8 digits. Please re-enter.");
						}
					} while (String.valueOf(pn).length() != 8);
					passenger newPassenger = new passenger(name, balance, password, pn);
					passengers.insertAtFront(newPassenger);
					System.out.println("Account created successfully!");
				}

				break;
			default:
				System.out.println("Invalid input");
				break;

			}

		}

	}
}
