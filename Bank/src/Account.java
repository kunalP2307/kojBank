import java.util.Scanner;
import BasicUtilities.Name;


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
	public abstract void createAccount(); 
	public abstract void showMsg(boolean accStatus ,Name custName);
	
	
	/*public abstract void manageLoans();
	
	public abstract void manageCards();
	
	public abstract void manageFDnRD();*/
	
	/*public void setBranch() {
		branch = new PuneBranch();
		if(branch instanceof PuneBranch) {
			System.out.println(PuneBranch.Telephone);
		}
	}*/
	
	public boolean accountTransfer(float ammount,int accountNo) {
		return false;
	}
	
	
	public static boolean initateAccountBalance(float minAmmount) {
		Scanner Sc = new Scanner(System.in);
		boolean paymentStatus = false;
		System.out.println("\n\t Minimum Balance To Open Account Is :"+minAmmount+"\n");
		System.out.print("\n\tAccount Opening Balance ");
		float balance  = Sc.nextFloat();
		do {
			if(balance < 0) {
				System.out.println("\t Ammount Can't Be Negative..");
				continue;
			}
			else 
				break;
		}while(true);
		
		do {
			System.out.println("\n\t ````Payment Options`````");
			System.out.print("\n\t\t D ~ Debit Card "
					+ "\n\t\t U ~ UPI ");
			System.out.print("\n\t Select Payment Option : ");
			char ch = Sc.next().charAt(0);
			switch(ch) {
				case 'U' | 'u':
				//	paymentStatus = UPI.makeTransaction(balance);
				break;
					
				case 'D' | 'd':
					paymentStatus = Card.makeTransaction(balance);
				break;	
					
				default : 
					System.out.println("\t Sorry..! No Such Payment Method Found ...\n\n");
					continue;
				}
		if(!paymentStatus) {
			System.out.println("\n\t Your Last Transaction Failed....");
			System.out.println("\n\t You Would be unable to open Account if Not Deposit Initial Ammount..");
			System.out.print("\t P - To go to Payment Options..."
					+ "\n\t E- Exit Anyway : ");
			String temp= Sc.next();
			if(temp.equalsIgnoreCase("p")) 
				continue;
			else 
				return false;
		}
		else 
			return true;
		}while(true);
	}
	
	public static void setAccountDetails(Customer C) {
		System.out.println("\n\t ~Account Details  \n");
		C.setAccount(Branch.setAccountType());
		C.account.createAccount();
	}
	
}
