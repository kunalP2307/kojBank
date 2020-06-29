import java.util.Scanner;

public class Employee {
	protected String companyName;
	protected String companyAddress;
	protected int noOfEmployees;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public int getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public static Employee acceptEmployeeInfo() {
		Scanner Sc = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.println("\tCompany Name : ");
		emp.setCompanyName(Sc.nextLine());
		System.out.println("\tCompany Address : ");
		emp.setCompanyAddress(Sc.nextLine());
		System.out.println("\tNo of Employees : ");
		emp.setNoOfEmployees(Sc.nextInt());
		return emp;
	}
	
		
	
}
