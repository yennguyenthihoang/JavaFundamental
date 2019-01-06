package fr.epita.bank.datamodel;

public class SavingsAccount extends Account{
private double interrestRate;
	
	private SavingsAccount(double balance) {
		super(balance);
	}

	public SavingsAccount(double balance, double interrestRate) {
		super(balance);
		this.interrestRate = interrestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interrestRate=" + interrestRate + ", getBalance()=" + getBalance() + "]";
	}
	
	public double computeInterest(double currentAmount) {
		return currentAmount*this.interrestRate*12;
	}
	public void withDraw(double wdAmount) {
		this.setBalance(this.getBalance() - wdAmount);
	}
}
