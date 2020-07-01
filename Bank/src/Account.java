import java.util.Scanner;

import javax.sound.midi.Soundbank;

public abstract class Account {
	protected int accNo;
	protected float accBalance;
	protected String accType;
	protected String branchName;
	protected Branch branch;
	protected String dateofAccountOpening;
	protected PassBook passBook;
	
	// Getters And Setters
	
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public float getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(float accBalance) {
		this.accBalance = accBalance;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public String getDateofAccountOpening() {
		return dateofAccountOpening;
	}
	public void setDateofAccountOpening(String dateofAccountOpening) {
		this.dateofAccountOpening = dateofAccountOpening;
	}
	public abstract void  createAccount(); 
	
	
	/*public abstract void manageLoans();
	
	public abstract void manageCards();
	
	public abstract void manageFDnRD();*/
	
	/*public void setBranch() {
		branch = new PuneBranch();
		if(branch instanceof PuneBranch) {
			System.out.println(PuneBranch.Telephone);
		}
	}*/
	
	public static Customer setAccountDetails(Customer C) {
		System.out.println("\n\t ~Account Details  ");
		
		
		C.setAccount(Branch.setAccountType());
		C.account.createAccount();
		return C;
	}
}
