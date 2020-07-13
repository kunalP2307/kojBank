import java.util.Scanner;
import BasicUtilities.Name;

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
	
	public void setAccountLimitations() {
		
	}
	public void createAccount() {
		Account.initateAccountBalance(minBalanceToMaintain);
	}	
	
	public void showMsg(boolean accStatus , Name custName) {
		System.out.println("\n\n\t Hey..! "+custName);
		if(accStatus == true) {
			System.out.println("\n\t Congrats...! Your Savings Account Has Been Created in Our Branch..! "
				+ "\n\t Enjoy The Fantastic Features Provided AnyTime AnyWhere... :)  "
				+ "\n\t Your Transaction Limit is Just 1 Lac per year You Can Upgrade to BSBD By Paying Rs 1500 Only.. ");
		}
		else {
			System.out.println("\t We are unable to Open Your Account With the Provied Details.."
					+ "\n\t Sorry for The inconvinience..! ");
		}
	}

}
