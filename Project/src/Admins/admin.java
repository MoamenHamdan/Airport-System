package Admins;


public class admin {
	public static int nextId = 2023000;
	private static String UniversalPass="Jad/Moamen";
	

	protected String FirstName;
	protected String lastName;
	protected int PhoneNumber;
	protected int id;
	protected String password;

	public admin(String firstName, String lastName, int phoneNumber, String password) {
		this.FirstName = firstName;
		this.lastName = lastName;
		this.PhoneNumber = phoneNumber;
		this.id = nextId++;
		this.password = password;
	}

	public static String getUniversalPass() {
		return UniversalPass;
	}
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
	
}
