package passengers;


public class passenger {
    protected int accountBalance;
    protected String name;
    protected String password;
    protected int phoneNumber;

    public passenger(String name, int accountBalance, String password, int phoneNumber) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    public int getAccountBalance() {
        return accountBalance;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
    

    public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void display() {
        System.out.println("Passenger's name: " + name);
        System.out.println("Passenger's money amount: " + this.getAccountBalance());
        System.out.println("Passenger's phone number: " + phoneNumber);
        System.out.println("********************************");
    }
}