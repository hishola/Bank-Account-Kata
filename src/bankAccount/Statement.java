package bankAccount;

import java.util.Date;

public class Statement {
	private Date date;
	private double amount;
	private double balance;
	private String operation;
	
	public Statement(Date date, double amount, double balance, String operation) {
		super();
		this.date = date;
		this.amount = amount;
		this.balance = balance;
		this.operation = operation;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Statement [date=" + date + ", operation=" + operation + ", amount=" + amount + ", balance=" + balance+ "]";
	}
	
}
