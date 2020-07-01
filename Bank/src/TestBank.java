import java.util.Scanner;


public class TestBank {
	public static void main(String Args[]) {
		Scanner Sc = new Scanner(System.in);	
		Branch B = new Branch();
		boolean logedIn = false;
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
				System.out.println("\t---- Login ----");
				logedIn = Authenticate.login();		
				System.out.println("\t ~ Sign Up [press any key to Login] ");
				String Temp = Sc.next();
				break;
			}
			else if(Ch.equalsIgnoreCase("c")) {
				Branch.openAccount();
				System.out.println("\t---- Sign Up ---");
				logedIn = Authenticate.SignUp();
				System.out.println("\t ~ Sign Up [press any key to sign up] ");
				String temp = Sc.next();
				//System.out.println(logedIn);
				break;
			}
			else {
				System.out.println("\t\t Kind Find the Entered Option...");
				System.out.print("\t\t You Can Simply Continue to Main Menu By pressing : C ");
				if(Sc.next().equalsIgnoreCase("c")) 
					continue;
			}
		}while(true);
		
		if(logedIn == true) {
			AfterLogIn();
		}
	}
	
	
	
	public static void AfterLogIn() {
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("K.O.J Bank\n\n");
		System.out.println("\n p ~ Profile 		f ~ forgot Pin 		h ~ Need Help  	 l ~ logout");
		System.out.println("\n Manage Account : ");
		System.out.println(" i ~ FD_RD Accounts  c ~ Cards 	 L ~ Loans  ");
		System.out.println("\n Money Tranfer : ");
		System.out.println(" a ~ Account Transfer   c ~ to Contact   ");
		System.out.println("\n Invest Money : ");
		System.out.println(" f - Fixed Deposti    r ~ Recuring Deposit");
		System.out.println("\n Apply Now : ");
		System.out.println(" Ac ~ Cards   Al ~ Loan ");
		
		
		Scanner Sc = new Scanner(System.in);
		System.out.print("\t Select Operation : ");
		String Ch = Sc.next();
		
		System.out.println("Sorry Currently We are Working on THis Feilds.."
				+ "\n\t  Come Back And explore Our Feed");
		
	}
}