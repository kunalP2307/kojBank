import java.util.Scanner;

import BasicUtilities.Address;

public class CurrentAccount extends Account{
	public static float minBalanceToBeMaintained=5000;
	public static float maxCashTransactionAmountPerDay;
	public static float chargesOrCashTransactionPer_1000Rs;
	public static String profession;
	public static String professionTypes[] = {"Employee","Buisnessman","Other"};
	protected Employee employeeInfo;
	int choice;
	Employee employee=new Employee();
	CurrentAccount ca= new CurrentAccount();
	
	public Employee getEmployeeInfo() {
		return employeeInfo;
	}
	public void setEmployeeInfo(Employee employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public void createAccount() {
		Scanner Sc = new Scanner(System.in);
		
		System.out.println("\tProfession Types : ");
		for(int i=0; i<CurrentAccount.professionTypes.length; i++)
			System.out.println("\t\t"+(i+1)+"- "+CurrentAccount.professionTypes[i]);
		
		System.out.println("/tSelect suitable profession type for u : ");
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
}
