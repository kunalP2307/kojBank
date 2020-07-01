import java.util.Scanner;

public class TestBank {
	public static void main(String Args[]) {
		Scanner Sc = new Scanner(System.in);	
		Branch B = new Branch();
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
				boolean bs = Authenticate.login();
				break;
			}
			else if(Ch.equalsIgnoreCase("c")) {
				Branch.openAccount();
				break;
			}
			else {
				System.out.println("\t\t Kind Find the Entered Option...");
				System.out.print("\t\t You Can Simply Continue to Main Menu By pressing : C ");
				if(Sc.next().equalsIgnoreCase("c")) 
					continue;
			}
		}while(true);
		
	}
}