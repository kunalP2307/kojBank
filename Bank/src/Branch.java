import java.util.Scanner;
import BasicUtilities.Address;
import BasicUtilities.Name;
import BasicUtilities.ProgressBar;

public class Branch {
	public static String accountTypes[][] = {
			{"Savings","BSBD","BSBDSS"},
			{"Current","Current"},
			{"Term Deposits","Recuring Deposit","Fixed Deposit"},
			{"Share Accounts","Traiding","Demant"},
			{"NRO","NRI","NRE","FCNR"}
	};	
	protected static Customer[] customers;
	public static int noOfCusts = 0;
	
	static {
		customers = new Customer[5];
	}
	
	public static void addCustomer(Customer C) {
		customers[noOfCusts] = C;
	}
	
	public static Account setAccountType() {
		boolean validChoice = false;
		String Ch;
		Scanner Scan = new Scanner(System.in);
		byte choice=0,choice2=0;
		while(validChoice == false){
			System.out.println("\tAccount Types :\n");
			for(int i=0; i<Branch.accountTypes.length; i++)
				System.out.println("\t\t"+(i+1)+"- "+Branch.accountTypes[i][0]);
			
			System.out.print("\n\tSelect Situable Type For You :");
			choice = Scan.nextByte();
		
			if(choice >= 6) {
				System.out.println("\n\t Kindly Select From the Given Options...");
			}
			else {
				validChoice = true;
				System.out.println("\t~"+Branch.accountTypes[choice-1][0]+" Accountss");
				for(int i=0; i<Branch.accountTypes[choice-1].length-1;i++) {
					System.out.println("\t\t"+(i+1)+"- "+Branch.accountTypes[choice-1][i+1]);
				}
			}
		}
		validChoice = false;
		while(validChoice == false){
			System.out.print("\tSelect the type of "+Branch.accountTypes[choice-1][0]+" : ");
			choice2 = Scan.nextByte(); 
			if(choice2 >= Branch.accountTypes[choice-1].length) {
				System.out.println("Kindly Select the Valid Option..");
				validChoice = false;
			}
			else {
				validChoice = true;
			}
		}
		switch(choice) {
			case 1:
				switch(choice2) {
					case 1:
						BSBD B = new BSBD();
						return B;
					
					case 2:
						BSBDSS Bs = new BSBDSS();
						return Bs;
				}
				
			case 2:
				CurrentAccount Cr = new CurrentAccount();
				return Cr;
			
			case 3:
				switch(choice2) {
					case 1:
						RecuringDepostit  RD = new RecuringDepostit();
						return RD;
				
					case 2:
						FixedDeposit FD = new FixedDeposit();
						return FD;
				}
			
			case 4:
				ShareAccount S = new ShareAccount();
				return S;
			
			case 5:
				switch(choice2) {
					case 1:
						NRI Ni = new NRI();
						return  Ni;
						
					case 2:
						NRE Ne = new NRE();
						return  Ne;
						
					case 3:
						FCNR Fc = new FCNR();
						return  Fc;
				
				}
		}
		return null;
	}
	public class AccountAutentication{
		Customer currentlyLoggedIn;
		public void setCurrentlyLogedIn(Customer currentlyLoggedIn) {
			this.currentlyLoggedIn = currentlyLoggedIn;
		}
		public Customer getCurrentlyLogedIn() {
			return currentlyLoggedIn;
		}
		
		public boolean login() {
			Scanner Sc = new Scanner(System.in);
			boolean validCreds = false;
			int i = 0;
			System.out.println("\t-----Login--------");
			System.out.print("\n\n\t\t     CRN No : ");
			int Crn = Sc.nextInt();
			System.out.print("\t\t Mobile Pin : ");
			int mpin = Sc.nextInt();
		
			for(i=0; i<noOfCusts; i++) {
				if(customers[i].getCustID() == Crn) {
					break;
				}
			}
			if(PassWord.decryptPassWord(customers[i].getmPin()) == mpin) {
				validCreds = true;
				setCurrentlyLogedIn(customers[i]);
			}
			System.out.print("\t ~ Login [press any key to Login] ");
			String Temp = Sc.next(); 
			setCurrentlyLogedIn(customers[i]);
			return validCreds;
		}
		public boolean SignUp() {
			Scanner Sc = new Scanner(System.in);
			boolean loginStatus = false;
			boolean accountCreated = Branch.openAccount();
			if(accountCreated) {
				System.out.println("\n\t-----Sign In--------");
				loginStatus =login();
				System.out.print("\t ~ Sign Up [press any key to sign up] ");
				String temp = Sc.next();
			}
			//System.out.println(b);
			return loginStatus;
		}
	}
	
	public static boolean openAccount() {
		Scanner Sc = new Scanner(System.in);
		boolean isValidAccountDetails =false;
		Customer C = new Customer();
		Customer.setCustDetails(C);
		Account.setAccountDetails(C);
		System.out.println("\n\n\t Verify Account Details for Further Process [y/n]");
		String Ch = Sc.next();
		if(Ch.equalsIgnoreCase("y")) {
			isValidAccountDetails = verifyAccountDetails(C);
		}
		else
			return false;
		if(isValidAccountDetails) {
			Branch.addCustomer(C);
		}
		C.account.showMsg(isValidAccountDetails, C.custName);
		return isValidAccountDetails;
		
	}
	
	public static boolean verifyAccountDetails(Customer C) {
		System.out.println("\t Please Wait While we Verify Your Details..");
		try {
			ProgressBar.fillProgressBar();
		}catch(Exception e) {}
		if(C.account instanceof BSBD) {
			if(C.account.accBalance < 1500) {
				System.out.println("\n\t Minimum Balance should be greater than 1500 to Open the acoount");
				return false;
			}
		}
		else if(C.account instanceof BSBDSS) {
			if(C.age < 18) {
				System.out.println("\n\t Your Age should be greater than 18 to open the Account");
				return false;
			}
		}
		else if(C.account instanceof CurrentAccount) {
			if(C.account.accBalance < 5000 || C.age < 18) {
				return false;
			}
		}
		else 
			return true;
		return true;
	}
	
	
	public static void applyCard(Customer C) {
		Card card = Card.generateCard(C.mobileNo, C.account, C.custName);
		C.setCard(card, C.nofCardsOwned);
			C.nofCardsOwned ++;
	}
		
}
