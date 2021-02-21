package bankAccount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Bank {
	private HashMap<User,ArrayList<Statement>> database;
	
	public Bank() {
		this.database = new HashMap<User, ArrayList<Statement>>();
	}

	public void addNewUser(User u){
		User user = findUser(u); 
		if (user == null) {
			Statement firstStatement = new Statement(new Date(), 0, 0, Operation.ACCOUNT_CREATION);
			ArrayList<Statement> statements = new ArrayList<Statement>();
			statements.add(firstStatement);
			database.put(u, statements);
		}
	}
	
	public User findUser(User u){
		for(User user : database.keySet()){
			if(user != null && u != null && user.equals(u)){
				return user;
			}
		}
		return null;
	}
	
	public void addDeposit(User u, double amount){
		User user = findUser(u); 
		if (user != null && amount > 0) {
			ArrayList<Statement> statements = database.get(user);
			double balance = statements.get(statements.size()-1).getBalance(); // We are getting the last statement balance
			Statement st = new Statement(new Date(), amount, balance+amount, Operation.DEPOSIT);
			statements.add(st);
		}
	}
	
	public void withdraw(User u, double amount){
		User user = findUser(u); 
		if (user != null && amount > 0) {
			ArrayList<Statement> statements = database.get(user);
			double balance = statements.get(statements.size()-1).getBalance(); // We are getting the last statement balance
			Statement st = new Statement(new Date(), amount, balance-amount, Operation.WITHDRAW);
			statements.add(st);
		}
	}
	
	public Statement getUserLastStatement(User u){
		User user = findUser(u);
		if (user != null) {
			ArrayList<Statement> statements = database.get(user);
			return statements.get(statements.size()-1);
		}
		return null;
	}
	
	public String printAccountStatement(User u){	
		Statement st = getUserLastStatement(u);		
		StringBuilder sb = new StringBuilder();
		return sb.append(u.toString()).append("\n").append(st.toString()).toString();		
	}
	
	public String printAccountHistory(User u){
		User user = findUser(u); 
		ArrayList<Statement> statements = database.get(user);
		
		StringBuilder sb = new StringBuilder();
		sb.append(u.toString()).append("\n");
		for(Statement st : statements){
			sb.append(st.toString()).append("\n");
		}
		return sb.toString();
	}
	
	public HashMap<User, ArrayList<Statement>> getDatabase() {
		return database;
	}

	public void setDatabase(HashMap<User, ArrayList<Statement>> database) {
		this.database = database;
	}
	
}
