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
	  public void displayTransactionStack(passenger x) {
	        System.out.println("Transaction Stack for " + x.getName() + ":");
	        x.getTransactionsStack().display();
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
	        Transaction transaction = new Transaction(newBalance - x.getAccountBalance());
	        x.setAccountBalance(newBalance);
	        x.getTransactionsStack().push(transaction);
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
	public boolean searchPassenger(passenger foundPassenger) {
		passenger_Node current = first;
		while (current != null) {
			if (current.data.equals(foundPassenger)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	public boolean deletePassengerByNameWithConfirmation(String name) {
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
				return true;
			} else {
				System.out.println("Account deletion canceled.");
				return false;
			}
		} else {
			System.out.println("Account not found for " + name);
			return false;
		}
	}
	public void displayAllPassengers() {
		passenger_Node x=first;
		while(x!=null) {
			displayPassengerInfo(x.data);
			x=x.next;
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
