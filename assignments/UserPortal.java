package wiley.programs.assignments;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



class Bank {
	private String id, name;
	private HashMap<String,Customer> customers;
	private HashMap<String,List<TransactionHistory>> transactions;

	public HashMap<String, List<TransactionHistory>> getTransactions() {
		return transactions;
	}

	public void setTransactions(HashMap<String, List<TransactionHistory>> transactions) {
		this.transactions = transactions;
	}

	public HashMap<String, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(HashMap<String, Customer> customers) {
		this.customers = customers;
	}

	public Bank(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public boolean openAccount() {
//		System.out.println("Please enter your name:");
		return false;
	}
	public Customer login(Scanner sc) {
		System.out.println("Enter your customer id");
		String custid=sc.nextLine();
		Customer customer=this.customers.get(custid);
		if(customer==null) {
			System.out.println("Account not found.");
			return null;
		}
		System.out.println("Enter your password:");
		String password=sc.nextLine();
		if(!customer.getPassword().equals(password)) {
			return null;
		}

		return customer;
	}

	public void displayAccountInfo(String customer_id) {
		Customer c= this.customers.get(customer_id);
		System.out.println("Customer id: "+c.getId()+", Name: "+c.getName()+", Balance: "+c.getAccount_balance());
	}

	public void deposit(String customer_id) {
		Customer customer=this.customers.get(customer_id);
		this.addTransaction(customer_id,1000);
		customer.setAccount_balance(customer.getAccount_balance()+1000);
	}

	private void addTransaction(String customer_id,long amount) {
		List<TransactionHistory> transaction= this.transactions.get(customer_id);
		if(transaction==null) {
			this.transactions.put(customer_id,Arrays.asList(new TransactionHistory(customer_id,1000,"3","1")));
		}
		else {
			this.transactions.put(customer_id,Arrays.asList(new TransactionHistory(customer_id,1000,"3","1")));
		}
	}
}

class Customer {
	private static long cust_id=1;
	private long account_balance;
	//status-> 1: active 2:blocked 3:closed
	//type-> 1: saving, 2: current
	private String  id,name, bank_id, phone_no, email, account_status, type, password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer( String name, String bank_id, String phone_no, String email, String account_status,
			long account_balance, String type, String password) {
		this.id = "Jpmc-"+cust_id;
		this.setName(name);
		this.bank_id = bank_id;
		this.phone_no = phone_no;
		this.email = email;
		this.account_status = account_status;
		this.setAccount_balance(account_balance);
		this.type = type;
		this.setPassword(password);
		cust_id++;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(long account_balance) {
		this.account_balance = account_balance;
	}
}

class TransactionHistory {
	private long amount;
	private String customer_id, status, transaction_type;
	Date timestamp;

	public TransactionHistory(String customer_id, long amount, String status, String transaction_type) {
		this.customer_id = customer_id;
		this.amount = amount;
		this.status = status;
		this.transaction_type = transaction_type;
		this.timestamp = new Date();
	}
}

public class UserPortal {
	private Boolean authenticated=false;
	private Customer customer=null;
	private Bank bank=null;
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		if(this.getAuthenticated())
			this.customer = customer;
	}
	public static final Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		UserPortal up=new UserPortal();
		
		
		HashMap <String,Customer> customers=new HashMap();
		HashMap <String,List<TransactionHistory>> transactions=new HashMap();
		
		Bank bank=new Bank("1","JPMC");
		up.setBank(bank);
		
		
		Customer customer1=new Customer("Jatin","1","1234567890","jatin@gmail.com","1", 1000,"1","password");
		Customer customer2=new Customer("Jatin2","1","1234567892","jatin2@gmail.com","1", 2000,"1","password2");
		customers.put(customer1.getId(), customer1);
		customers.put(customer2.getId(), customer2);
		bank.setCustomers(customers);
		
		TransactionHistory th1=new TransactionHistory(customer1.getId(),1000,"3","1");
		TransactionHistory th2=new TransactionHistory(customer1.getId(),1000,"3","1");
		TransactionHistory th3=new TransactionHistory(customer2.getId(),1000,"3","1");
		transactions.put(customer1.getId(), (List<TransactionHistory>) Arrays.asList(th1));
		transactions.put(customer1.getId(), (List<TransactionHistory>) Arrays.asList(th2));
		transactions.put(customer2.getId(), (List<TransactionHistory>) Arrays.asList(th3));
		bank.setTransactions(transactions);
		
		String choice="0";
		while (!choice.equals("5")) {
			displayOptions();
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				System.out.println("Open Account");
				if(bank.openAccount()) System.out.println("Account created");
				else System.out.println("Failed. please try again");
				break;
			case "2":
				System.out.println("Login");
				Customer customer=bank.login(sc);
				if(customer!=null) {
					up.setAuthenticated(true);
					up.setCustomer(customer);
					up.goToAuthenticatedMenu();
				}
				break;
			case "3":
				System.out.println("exiting...");
				break;
			default:
				break;
			}
		}
		
	}
	private void goToAuthenticatedMenu() {
		String choice="0";
		while (!choice.equals("4")) {
			displayOptionsAuthenticated();
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				bank.displayAccountInfo(this.customer.getId());
				break;
			case "2":
				bank.deposit(this.customer.getId());
				break;
			case "3":
				
				break;
			default:
				break;
			}
		}
	}
	public static void displayOptions() {
		String options = "1) Open an account  \n2) Login\n3) Exit";
		System.out.println(options);
	}
	public static void displayOptionsAuthenticated() {
		String options = "1) Check account Info  \n2) Deposit\n3) Withdraw \n4)Logout";
		System.out.println(options);
	}
	public Boolean getAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

}
