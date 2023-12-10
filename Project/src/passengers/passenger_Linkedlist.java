package passengers;

import java.util.Scanner;

public class passenger_Linkedlist {
	passenger_Node first;
	Scanner scan = new Scanner(System.in);

	public passenger_Linkedlist() {
		this.first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	// jad is this used for anything ?
	// kenet isert at back bass 7a a3mel front kermel l time complexity
	// w akid used for something la2an baleha mafik t7ot passengers bl LL
	public void insertAtFront(passenger data) {
		passenger_Node passengerNode = new passenger_Node(data);
		passengerNode.next = first;
		first = passengerNode;
	}

	public passenger deleteFromFront() {
		passenger deleted = first.data;
		if (!isEmpty()) {
			first = first.next;
		}
		return deleted;
	}

	// ghayaret l search la tred passenger kermel bass yfout 3al account taba3o
	// ye2dar ychtre mch na3mel search tene
	// fa bl main if search!=null ye3ne found
	public passenger searchPassengerByNameAndPassword(String name, String password) {
		passenger_Node current = first;
		while (current != null) {
			if (current.data.getName().equals(name) && current.data.getPassword().equals(password)) {
				return current.data;
			}
			current = current.next;
		}
		return null;
	}

	public void editPassengerAccount(passenger x) {
		if (x == null)
			return;
		System.out.println("Enter new information for " + x.name + ":");
		System.out.print("Enter new name: ");
		x.setName(scan.next());
		System.out.print("Enter new phone number (8 digits): ");
		x.setPhoneNumber(scan.nextInt());
		System.out.print("Enter new account balance: ");
		int newBalance = scan.nextInt();

		x.setAccountBalance(newBalance);
		System.out.println("Account information updated successfully.");
	}

	public passenger searchPassengerByName(String name) {
		passenger_Node current = first;
		while (current != null) {
			if (current.data.getName().equals(name)) {
				return current.data;
			}
			current = current.next;
		}
		return null;
	}

	public void deletePassengerByNameWithConfirmation(String name) {
		passenger passengerToDelete = searchPassengerByName(name);
		if (passengerToDelete != null) {
			System.out.println("Do you want to delete the account for " + name + "? (yes/no)");
			String confirmation = scan.next().toLowerCase();
			if (confirmation.equals("yes")) {
				System.out.println("Account deleted successfully.");
				passenger_Node current = first;
				passenger_Node previous = null;
				while (current != null && !current.data.getName().equals(name)) {
					previous = current;
					current = current.next;
				}
				if (previous == null) {
					first = current.next;
				} else {
					previous.next = current.next;
				}
			} else {
				System.out.println("Account deletion canceled.");
			}
		} else {
			System.out.println("Account not found for " + name);
		}
	}

	public void displayPassengerInfo(passenger x) {
		if (x == null)
			return;
			System.out.println("Passenger Information:");
			System.out.println("Name: " + x.getName());
			System.out.println("Phone Number: " + x.getPhoneNumber());
			System.out.println("Account Balance: " + x.getAccountBalance());
	}

}
