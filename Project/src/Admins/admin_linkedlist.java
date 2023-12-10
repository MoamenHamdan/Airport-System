package Admins;

public class admin_linkedlist {
	admin_Node first;

	public boolean isEmpty() {
		return first == null;
	}

	public void insertAtBack(admin data) {
		admin_Node newNode = new admin_Node(data);

		if (isEmpty()) {
			first = newNode;
		} else {
			admin_Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}

	public admin deleteFromFront() {
		admin deletedAdmin = first.data;
		if (!isEmpty()) {
			first = first.next;
		}
		return deletedAdmin;
	}
}
