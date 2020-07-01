import java.util.Scanner;

import BasicUtilities.Address;

interface Branch {
	static String accountTypes[][] = {
			{"Savings","BSBD","BSBDSS"},
			{"Current"},
			{"Term Deposits","Recuring Deposit","Fixed Deposit"},
			{"Share Accounts","Traiding","Demant"},
			{"NRO","NRI","NRE","FCNR"}
	};	
	
	
	public static Account setAccountType() {
		boolean validChoice = false;
		String Ch;
		Scanner Scan = new Scanner(System.in);
		byte choice=0,choice2=0;
		while(validChoice == false){
			System.out.println("\tAccount Types :");
			for(int i=0; i<PuneBranch.accountTypes.length; i++)
				System.out.println("\t\t"+(i+1)+"- "+Branch.accountTypes[i][0]);
			
			System.out.print("\tSelect Situable Type For You :");
			choice = Scan.nextByte();
		
			if(choice >= 6) {
				System.out.println("Kindly Select From the Given Options...");
			}
			else {
				validChoice = true;
				System.out.println("\t~"+PuneBranch.accountTypes[choice-1][0]+" Accountss");
				for(int i=0; i<PuneBranch.accountTypes[choice-1].length-1;i++) {
					System.out.println("\t\t"+(i+1)+"- "+Branch.accountTypes[choice-1][i+1]);
				}
			}
		}
		validChoice = false;
		while(validChoice == false){
			System.out.print("\tSelect the type of "+Branch.accountTypes[choice-1][0]+" : ");
			choice2 = Scan.nextByte();
			if(choice2 >= PuneBranch.accountTypes[choice-1].length) {
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
	
	
	public static void openAccount(Customer C) {
		C = Customer.setCustDetails(C);
		C = Account.setAccountDetails(C);
	}
	
}