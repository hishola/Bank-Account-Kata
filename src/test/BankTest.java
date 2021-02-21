package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bankAccount.Bank;
import bankAccount.Operation;
import bankAccount.Statement;
import bankAccount.User;

public class BankTest {

	@Test
	public void testAddNewUser() {
		Bank bank = new Bank();
		User u1 = new User(1, "ISHOLA", "Hamed", 1000001);
		User u2 = new User(2, "TONDEY", "Ruth", 1000002);
		bank.addNewUser(u1);
		bank.addNewUser(u2);
		
		assertEquals(2, bank.getDatabase().keySet().size());
		assertEquals(true, bank.getDatabase().keySet().contains(u1));
		assertEquals(true, bank.getDatabase().keySet().contains(u2));
	}

	@Test
	public void testFindUser() {
		Bank bank = new Bank();
		User u1 = new User(1, "ISHOLA", "Hamed", 1000001);
		bank.addNewUser(u1);
		
		User foundUser = bank.findUser(u1);
		
		assertEquals(1000001,foundUser.getAccountNumber());
		assertEquals("ISHOLA", foundUser.getNom().toUpperCase());
	}

	@Test
	public void testAddDeposit() {
		Bank bank = new Bank();
		User u1 = new User(1, "ISHOLA", "Hamed", 1000001);
		bank.addNewUser(u1);
		bank.addDeposit(u1, 1000);
		bank.addDeposit(u1, 2000);
		
		assertEquals(3000,bank.getUserLastStatement(u1).getBalance(), 0.0001);
	}

	@Test
	public void testWithdraw() {
		Bank bank = new Bank();
		User u1 = new User(1, "ISHOLA", "Hamed", 1000001);
		bank.addNewUser(u1);
		bank.addDeposit(u1, 1000);
		bank.addDeposit(u1, 2000);
		bank.withdraw(u1, 500);
		bank.withdraw(u1, 100);
		
		assertEquals(2400,bank.getUserLastStatement(u1).getBalance(), 0.0001);
	}

	@Test
	public void testGetUserLastStatement() {
		Bank bank = new Bank();
		User u1 = new User(1, "ISHOLA", "Hamed", 1000001);
		bank.addNewUser(u1);
		bank.addDeposit(u1, 1000);
		bank.addDeposit(u1, 2000);
		bank.withdraw(u1, 500);
		bank.withdraw(u1, 50);
		
		Statement st = bank.getUserLastStatement(u1);
		
		assertEquals(50, st.getAmount(), 0.0001);
		assertEquals(Operation.WITHDRAW, st.getOperation());
		assertEquals(2450, st.getBalance(), 0.0001);
	}

	@Test
	public void testPrintAccountStatement() {
		Bank bank = new Bank();
		User u1 = new User(1, "ISHOLA", "Hamed", 1000001);
		bank.addNewUser(u1);
		bank.addDeposit(u1, 1000);
		bank.addDeposit(u1, 2000);
		bank.withdraw(u1, 500);
		bank.withdraw(u1, 250);
		bank.withdraw(u1, 150);
		bank.withdraw(u1, 100);
		
		System.out.println(bank.printAccountStatement(u1));
		assertEquals(2000, bank.getUserLastStatement(u1).getBalance(), 0.0001);
	}

	@Test
	public void testPrintAccountHistory() {
		Bank bank = new Bank();
		User u1 = new User(1, "ISHOLA", "Hamed", 1000001);
		bank.addNewUser(u1);  // adding New User creates a first statement with 0 balance
		bank.addDeposit(u1, 1000);
		bank.addDeposit(u1, 2000);
		bank.withdraw(u1, 500);
		bank.withdraw(u1, 250);
		bank.withdraw(u1, 150);
		bank.withdraw(u1, 100);
		
		System.out.println(bank.printAccountHistory(u1));
		assertEquals(7, bank.getDatabase().get(u1).size()); //assert that the number of statement history is 7
	}

}
