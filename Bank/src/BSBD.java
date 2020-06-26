import java.util.Scanner;

public class BSBD  extends SavingsAccount{ 
	/*public static float intrestRate;
	public static float minBalanceToMaintainO;
	public static float chargesForNotMaintaingTheMinBalance;
	public static float maintenanceCharges;*/
	static {
		intrestRate = 3.5F;
		minBalanceToMaintain = 1500;
		chargesForNotMaintaingTheMinBalance = 80f;
		maintenanceCharges = 150;
	}
	public void createAccount() {
		Scanner Sc = new Scanner(System.in);
		do{
			System.out.print("\tAmmount to Initiate Your Account..");
			float Balance  = Sc.nextFloat();
				if(Balance >= 1500) {
					setAccBalance(Balance);
					break;
				}
				else {
					System.out.println("\t Minimum Ammount to Initiate Your Account is  Rs 1500/-");
					continue;
				}
		}while(true);
		System.out.println("Do you want to perform any transaction then press 1");
		int s=Sc.nextInt();
		int cnt=0;
		if(s==1) {
			// Here call Transaction method
			cnt++;
		}
		if(cnt==4) {
			System.out.println("Your monthly transaction limit completed");
		}
		if(accBalance<1500) {
			System.out.println("80 rupees applies as charges for not maintaining minimum balance in account");
			
		}
	}

}
