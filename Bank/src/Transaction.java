import java.sql.Date;
import java.time.LocalDate;

public class Transaction {
	 int noOfTransaction;
	 LocalDate dateOfTransaction;
	 String Particulars;
	 float ammountWithDrawn;
	 float ammountDeposited;
	 float balance;
	
	public int getNoOfTransaction() {
		return noOfTransaction;
	}
	public void setNoOfTransaction(int noOfTransaction) {
		this.noOfTransaction = noOfTransaction;
	}

	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public String getParticulars() {
		return Particulars;
	}
	public void setParticulars(String particulars) {
		Particulars = particulars;
	}
	public float getAmmountWithDrawn() {
		return ammountWithDrawn;
	}
	public void setAmmountWithDrawn(float ammountWithDrawn) {
		this.ammountWithDrawn = ammountWithDrawn;
	}
	public float getAmmountDeposited() {
		return ammountDeposited;
	}
	public void setAmmountDeposited(float ammountDeposited) {
		this.ammountDeposited = ammountDeposited;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
}
