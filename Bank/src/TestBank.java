import java.util.Scanner;

import BasicUtilities.Console;

public class TestBank {
	public static void main(String Args[]) throws Exception,InterruptedException {
		Scanner Sc = new Scanner(System.in);	
		Branch B = new Branch();
		boolean islogedIn = true;
		
		Branch.AccountAutentication Authenticate = B.new AccountAutentication();
		System.out.println("\t K.O.J Introduces Online Platform to Manage All yout Banking Needs.."
				+ "\n 					From Anywhere At Anytime.. :)   ");
	
		do {
			System.out.println("\n\n\t\t ~ Login (L) ");
			System.out.println("\t\t ~ Don't Have Account "
					+ "\n\t\t   Create Now  (C) ");
			System.out.print("\n\tSelect One : ");
			String Ch = Sc.next();
			
			if(Ch.equalsIgnoreCase("l")) {
				islogedIn = Authenticate.login();		
				break;
			}
			else if(Ch.equalsIgnoreCase("c")) {
				islogedIn = Authenticate.SignUp();
	 			System.out.println(islogedIn);
				if(islogedIn)
					break;
			}
			else {
				System.out.println("\t\t Kind Find the Entered Option...");
				System.out.print("\t\t You Can Simply Continue to Main Menu By pressing : C ");
				if(Sc.next().equalsIgnoreCase("c")) 
					continue;
			}
		
			if(islogedIn == false) {
				System.out.println("\n\t Want To Continue to Main Menu [y/n] : ");
				String ch = Sc.next();
				if(ch.equalsIgnoreCase("y")) {
					continue;
				}
				else {
					Console.clear();
					System.out.println("\n\n\t Have a Nice Day..:)  ");
					break;
				}
			}
		}while(true);
		
		if(islogedIn == true) {
			AfterLogIn(Authenticate.getCurrentlyLogedIn());
		}
		
	}
	public static void AfterLogIn(Customer currentlyLogedIn) throws Exception {
		Console.clear();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("K.O.J Bank\n\n");
		System.out.println("\n p ~ Profile 	f ~ Change MPIn  h ~ Need Help  l ~ logout");
		System.out.println("\n Manage Account : \n");
		System.out.println(" i ~ FD_RD Accounts  C ~ Cards 	 L ~ Loans  V - View Balance ");
		System.out.println("\n Money Tranfer : \n");
		System.out.println(" a ~ Account Transfer   c ~ to Contact  u ~ UPI ");
		System.out.println("\n Invest Money : \n");
		System.out.println(" F - Fixed Deposti    R ~ Recuring Deposit");
		System.out.println("\n Apply For : \n");
		System.out.println(" d ~ Cards   l ~ Loan ");
		
		
		Scanner Sc = new Scanner(System.in);
		System.out.print("\n\n\t Select Operation : ");
		char Ch = Sc.next().charAt(0);
		
		switch(Ch) {
			case 'p':
				currentlyLogedIn.showProfile();
			break;
			
			case 'f':
				currentlyLogedIn.changeMpin();
			break;
			
			case 'h':
				Help.needHelp();
			break;
			
			case 'i':
				currentlyLogedIn.investment = new Investment();
				currentlyLogedIn.investment.manageInvestments();
			break;
			
			case 'C':
				//currentlyLogedIn.
			break;
			
			case 'L':
				currentlyLogedIn.loans[0].manageLoans();
			break;
			
			case 'V':
				currentlyLogedIn.account.showBalance();
			break;
			case 'a':
				currentlyLogedIn.account.accountTransfer();		
							// ammount and accountNo
			break;
			
			case 'c':
				currentlyLogedIn.upi[0].transferToContact(0, 0);
							// mobileNo Ammount
			break;
			
			case 'u':
				currentlyLogedIn.upi[0].transferToUPI_Address("", 0);
						// upiAddress Ammount
			break;
			
			case 'F':
				//currentlyLogedIn.investments[0].applyForFD();
			break;
			
			case 'R':
				//currentlyLogedIn.investments[0].applyForRD();
			break;
			
			case 'd':
				currentlyLogedIn.cards[0].applyForCard();
			break;
			
			case 'l':
				currentlyLogedIn.loans[0].applyForLoan();
			break;
			
			default:
				System.out.println("\n\t No such Operation Found...");
		}
		
	}
}