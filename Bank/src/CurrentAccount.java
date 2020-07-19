import java.util.Scanner;

import BasicUtilities.Address;
import BasicUtilities.DrawLine;
import BasicUtilities.Name;


public class CurrentAccount extends Account{
	
	public static String professionTypes[] = {"Employee","Buisnessman","Other"};
	public static float minBalanceToBeMaintained=5000;
	public static float maxCashTransactionAmountPerDay=200000;
	public static float chargesOrCashTransactionPer_1000Rs=1;
	protected String profession;
	protected Object professionInfo;
	
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public Object getProfessionInfo() {
		return professionInfo;
	}
	public void setProfessionInfo(Object professionInfo) {
		this.professionInfo = professionInfo;
	}

	public void createAccount() {
		Scanner Sc = new Scanner(System.in);
		Employee employee=new Employee();
		DrawLine line = new DrawLine();
		CurrentAccount ca= new CurrentAccount();
		int choice;
		
		System.out.println("\n\n\tProfession Types : ");
		for(int i=0; i<CurrentAccount.professionTypes.length; i++)
			System.out.println("\t\t"+(i+1)+"- "+CurrentAccount.professionTypes[i]);
		
		System.out.print("\t Select suitable profession type for you : ");
		choice = Sc.nextInt();
		
		switch(choice) {
		case 1:
			profession = CurrentAccount.professionTypes[0];	
			setProfessionInfo(employee.acceptEmployeeInfo());
			break;
		case 2:
			profession = CurrentAccount.professionTypes[1];
			break;
		case 3:
			System.out.println("\tProfession : ");
			profession=Sc.nextLine();
			break;
		default:
			System.out.println("\tInvalid choice");
		}
		
		line.drawTabLine();
		initateAccountBalance(5000);
	}
	public void showMsg(boolean accStatus,Name custName) {
		System.out.println("\n\t Congrats....! Your Account Has Been Open In Our Bank..."
				+ "\n\t   Now Enjoy Unlimited Online Transactions Without Any Charges... :) ");
	}
}
