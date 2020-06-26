import java.util.Scanner;

public class CurrentAccount extends Account{
	public static float minBalanceToBeMaintained=5000;
	public static float maxCashTransactionAmountPerDay;
	public static float chargesOrCashTransactionPer_1000Rs;
	public static String profession;
	
	
	public void createAccount() {
		Scanner Sc = new Scanner(System.in);
		System.out.println("\tProfession : ");
		profession=Sc.nextLine();
		
		do{
			System.out.print("\tAmmount to Initiate Your Account..");
			float Balance  = Sc.nextFloat();
				if(Balance >= 5000) {
					setAccBalance(Balance);
					break;
				}
				else {
					System.out.println("\t Minimum Ammount to Initiate Your Account is  Rs 5000/-");
					continue;
				}
		}while(true);
	}

	
}
