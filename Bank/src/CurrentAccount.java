import java.util.Scanner;

import BasicUtilities.Address;
import BasicUtilities.Name;


public class CurrentAccount extends Account{
	public static float minBalanceToBeMaintained=5000;
	public static float maxCashTransactionAmountPerDay=200000;
	public static float chargesOrCashTransactionPer_1000Rs=1;
	public static String profession;
	public static String professionTypes[] = {"Employee","Buisnessman","Other"};
	protected Employee employeeInfo;
	int choice;
	
	public Employee getEmployeeInfo() {
		return employeeInfo;
	}
	public void setEmployeeInfo(Employee employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public void createAccount() {
		Scanner Sc = new Scanner(System.in);
		Employee employee=new Employee();
		CurrentAccount ca= new CurrentAccount();
		
		System.out.println("\tProfession Types : ");
		for(int i=0; i<CurrentAccount.professionTypes.length; i++)
			System.out.println("\t\t"+(i+1)+"- "+CurrentAccount.professionTypes[i]);
		
		System.out.print("\t Select suitable profession type for you : ");
		choice = Sc.nextInt();
		
		switch(choice) {
		case 1:
			profession = CurrentAccount.professionTypes[1];	
			ca.setEmployeeInfo(employee.acceptEmployeeInfo());	
		case 2:
			profession = CurrentAccount.professionTypes[2];	
		case 3:
			System.out.println("\tProfession : ");
			profession=Sc.nextLine();
		}
			
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
	public void showMsg(boolean accStatus,Name custName) {
		System.out.println("\n\t Congrats....! Your Account Has Benn Open In Our Bank..."
				+ "\n\t   Now Enjoy Unlimited Online Transactions Withou Any Charges... :) ");
	}
}
