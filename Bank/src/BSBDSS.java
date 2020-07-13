import BasicUtilities.Name;

public class BSBDSS extends SavingsAccount {
	static {
		intrestRate = 3.5F;
		minBalanceToMaintain = 0;
		chargesForNotMaintaingTheMinBalance = 80f;
	}
	public void createAccount() {
	}
	public void setAccountLimitations(){
	}
	public void showMsg(boolean accStatus , Name custName) {
		System.out.println("\n\t Congrats...! Your Savings Account Has Been Created in Our Branch..! "
				+ "\n\t Enjoy The Fantastic Features Provided, AnyTime AnyWhere... :)  "
				+ "\n\t Your Transaction Limit is Just a Lac for year "
				+ "\n\t You Can Increase the limit By just Paying Rs.1500 And Converting Account to BSBD");
	}
}
