package wiley.programs.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Database {
	private List<Account> accounts;
	private List<Transaction> transactions;
	private List<Atm> atm;

	public Database(List<Account> accounts, List<Transaction> transactions, List<Atm> atm) {
		this.accounts = new ArrayList<Account>();
		this.transactions = new ArrayList<Transaction>();
		this.atm = new ArrayList<Atm>();
	}

	public List<Account> getAccount(int id) {
		return accounts.stream().filter(i -> i.getId() == id).collect(Collectors.toList());
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}

	public List<Transaction> getTransactions(int acc_id) {
		return transactions.stream().filter(i -> i.getAcc_id() == acc_id).collect(Collectors.toList());
	}

	public void addTransactions(Transaction transaction) {
		this.transactions.add(transaction);
	}

	public List<Atm> getAtm(int branch_id) {
		return atm.stream().filter(i -> i.getBranch_id() == branch_id).collect(Collectors.toList());
	}

	public void addAtm(Atm atm) {
		this.atm.add(atm);
	}

}
