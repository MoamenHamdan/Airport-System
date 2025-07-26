package Admins;

import java.util.Scanner;

// this is  implementing a queue using a linked list

public class adminQueue extends admin_linkedlist {
	public boolean isEmpty() {
		return super.isEmpty();
	}

	public void enqueue(admin data) {
		super.insertAtBack(data);
	}

	public admin dequeue() {
		return super.deleteFromFront();
	}
	
	public admin searchById(int id) {
		adminQueue temp = new adminQueue();
		admin foundAdmin = null;
		while (!isEmpty()) {
			admin currentAdmin = dequeue();
			if (currentAdmin.getId() == id) {
				foundAdmin = currentAdmin;
			}
			temp.enqueue(currentAdmin);
		}
		while (!temp.isEmpty()) {
			admin currentAdmin = temp.dequeue();
			enqueue(currentAdmin);
		}
		return foundAdmin;
	}

	public boolean checkAccount(int id, String password) {
		
		adminQueue temp = new adminQueue();
		boolean isMatch = false;
		while (!isEmpty()) {
			admin currentAdmin = dequeue();
			if (currentAdmin.getId() == id && currentAdmin.getPassword().equals(password)) {
				isMatch = true;
			}
			temp.enqueue(currentAdmin);
		}
		while (!temp.isEmpty()) {
			admin currentAdmin = temp.dequeue();
			enqueue(currentAdmin);
		}
		return isMatch;
	}

	public void displayAllAdmins() {
		adminQueue temp = new adminQueue();
		while (!isEmpty()) {
			admin currentAdmin = dequeue();
			System.out.println("Admin ID: " + currentAdmin.getId());
			System.out.println("Name: " + currentAdmin.getFirstName() + " " + currentAdmin.getLastName());
			System.out.println("Phone Number: " + currentAdmin.getPhoneNumber());
			System.out.println("------------------------------");

			temp.enqueue(currentAdmin);
		}

		while (!temp.isEmpty()) {
			admin currentAdmin = temp.dequeue();
			enqueue(currentAdmin);
		}
	}

	public void editAccountInfo() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Please enter your ID:");
            int id = scan.nextInt();
            System.out.println("Please enter your password:");
            String password = scan.next();

            adminQueue temp = new adminQueue();
            boolean accountFound = false;

            while (!isEmpty()) {
                admin currentAdmin = dequeue();
                if (currentAdmin.getId() == id && currentAdmin.getPassword().equals(password)) {

                    System.out.println("Enter new information:");

                    System.out.print("Enter your first name: ");
                    currentAdmin.setFirstName(scan.next());

                    System.out.print("Enter your last name: ");
                    currentAdmin.setLastName(scan.next());

                    System.out.print("Enter your phone number: ");
                    currentAdmin.setPhoneNumber(scan.nextInt());

                    System.out.println("Account information updated successfully.");
                    accountFound = true;
                }

                temp.enqueue(currentAdmin);
            }

            while (!temp.isEmpty()) {
                enqueue(temp.dequeue());
            }

            if (!accountFound) {
                System.out.println("Account not found. Please check your ID and password.");
            }
        } finally {
            scan.close();
        }
    }

    public void deleteAdminById(int id) {
        Scanner scan = new Scanner(System.in);
        try {
            adminQueue temp = new adminQueue();
            boolean adminFound = false;

            while (!isEmpty()) {
                admin currentAdmin = dequeue();
                if (currentAdmin.getId() == id) {

                    System.out.println("Admin found:");
                    System.out.println("ID: " + currentAdmin.getId());
                    System.out.println("Name: " + currentAdmin.getFirstName() + " " + currentAdmin.getLastName());
                    System.out.println("Phone Number: " + currentAdmin.getPhoneNumber());

                    System.out.println("Do you want to delete this admin? (yes/no)");
                    String confirmation = scan.next().toLowerCase();

                    if (confirmation.equals("yes")) {

                        System.out.println("Admin deleted successfully.");
                        adminFound = true;
                    } else {
                        temp.enqueue(currentAdmin);
                    }
                } else {
                    temp.enqueue(currentAdmin);
                }
            }

            while (!temp.isEmpty()) {
                enqueue(temp.dequeue());
            }

            if (!adminFound) {
                System.out.println("Admin not found with ID: " + id);
            }
        } finally {
            scan.close();
        }
    }

}
