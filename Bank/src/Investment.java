import java.util.Scanner;

public class Investment {
	TermDeposit Investments[];
	int noOfinvestments;
	
	
	
	public void manageInvestments() {
		
		noOfinvestments = 123;
//		Scanner Sc = new Scanner(System.in);
//		System.out.println("\n\n\t I - Invest Now ");
//		System.out.println("\t S - Show My Investments ");
//		System.out.println("\t P - Premature Withdrawal ");
//		System.out.print("\t Select >> ");
//		char choice = Sc.next().charAt(0);
//		
//		switch(choice) {
//			case 'i' | 'I':
//				
//				
//			break;
//		}
	}
	public void applyForRD(Investment investments[],int noOfInvestments) {
		Scanner Sc = new Scanner(System.in);
		do {
			System.out.println("\t ---- Investment Options -----");
			System.out.println("\t R - Recuring Deposit "
					+ "\n\t F - Fixed Deposit ");
			System.out.println("\t Select >> ");
			char choice = Sc.next().charAt(0);
			if(choice == 'r' || choice == 'R') {
				
			}
			else if(choice == 'r' || choice == 'R') {
				
			}
			else {
				System.out.print("\t Sorry..! No such option found "
						+ "\n\t You can continue to main menu by pressing C :");
				choice = Sc.next().charAt(0);
				if(choice == 'c' || choice == 'C') 
					continue;
				else
					break;
			}
		}while(true);
			
		
	}
	public void applyForFD() {
		/*
		 * 
		 * 
		 * 
		 */
	}
	

}
