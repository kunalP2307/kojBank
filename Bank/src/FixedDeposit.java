import java.util.Scanner;

import BasicUtilities.Name;

public class FixedDeposit extends TermDeposit{
	public static double intsrestRates[] = {3.50,4.00,5.00,5.40,5.60,6.00,6.60,6.70};
	public static String maturityPeroidImDays[] = {"7-14","15-30","31-45","46-90","91-120","121-179","180","181-364"};

	protected float principleAmmount;
	protected  String typeOfFDInvestment;
	
	public float getPrincipleAmmount() {
		return principleAmmount;
	}

	public void setPrincipleAmmount(float principleAmmount) {
		this.principleAmmount = principleAmmount;
	}

	public String getTypeOfFDInvestment() {
		return typeOfFDInvestment;
	}

	public void setTypeOfFDInvestment(String typeOfFDInvestment) {
		this.typeOfFDInvestment = typeOfFDInvestment;
	}

	public void createAccount() {
		Scanner Sc = new Scanner(System.in);
		int i=0;
		
		System.out.println("\t-------------------------------");
		System.out.println("\n\t\t ~ Earn More on Your Investment ...!");
		System.out.print("\t Want to fInd how much you can earn through \n\t  our Fixed Deposits [Y/n]");
		String Ch = Sc.next();
		if(Ch.equalsIgnoreCase("y")) {
			showEarnigs();
		}
		
		System.out.print("\t Apply Now [Y/n] ");
		Ch = Sc.next();
		if(Ch.equalsIgnoreCase("Y")) {
			System.out.print("\t Deposit Ammount :");
			float PrincipleAmm = Sc.nextFloat();
			setPrincipleAmmount(PrincipleAmm);
			
			setIntrestRateAndMaturity();
			do {
				System.out.println("\n\t 1- Redeem Principal Redeem Intrest ");
				System.out.println("\t 2- Renew Principal Redeem Intrest ");
				System.out.println("\t 3- Renew Principle And Intrest");
				System.out.println("\t\t\tSelect Form the Above Three Options....");
				System.out.print("\t At Maturity :");
				int choice = Sc.nextInt();
				switch(choice) {
					case 1:
						setTypeOfFDInvestment("RPRI");
						
					break;
					
					case 2:
						setTypeOfFDInvestment("NPRI");
					break;
					
					case 3:
						setTypeOfFDInvestment("NPNI");
					break;
					default:
						i++;
						System.out.println("\tKindly Select the Valid Option...");
						continue;
				}			
			}while(i==1);
			showMsg();
		}
	}
	
	public void showIntrestRatesAndMAaturityPeroids(String maturityPeroids[],double intrestRates[]){	
		System.out.println("\n\tThe Following Time Period And its Corresponding Rate of Intrest..");
		System.out.println("\n\tPeroid"+"\t\t\t"+"Intrest");
		System.out.println("\t......"+"\t\t\t|\t"+".......");
		for(int i=0 ; i<FixedDeposit.maturityPeroidImDays.length ; i++) {
			System.out.println("\t"+maturityPeroids[i]+" Days"+"\t\t|\t"+intrestRates[i]+"%");
		}
		
	}
		
	public void setIntrestRateAndMaturity() {				// function to set the Investment Peroid And Its Corresponding Intrest Rate
		Scanner Sc = new Scanner(System.in);
		String Ch;
		System.out.print("\t Want to Check the Intrest Rates By Identfying the "
				+ "\n\t   Time Peroid Yes/Continue[Y/c] :");
		Ch = Sc.next();
		
		if(Ch.equalsIgnoreCase("Y")) {
			showIntrestRatesAndMAaturityPeroids(maturityPeroidImDays, intsrestRates);
		}
		do {
			System.out.print("\t Time Peroid (in Days ) : ");
			int peroid = Sc.nextInt();
			
			if(peroid < 7 || peroid > 365) {
				System.out.println("\t Sorry we Don't Have the selected Time Peroid as of Now...");
				System.out.print("\t Want to Chechout the InvestMent Time Peroids [Y/n]");
				Ch = Sc.next();
				if(Ch.equalsIgnoreCase("y")) {
					showIntrestRatesAndMAaturityPeroids(maturityPeroidImDays, intsrestRates);
				}
				
				System.out.print("\t Found the Situable InvestMent Peroid For You [Y/n] :");
				Ch = Sc.next();
				if(Ch.equalsIgnoreCase("y")) {
						continue;
				}
			}   
			
			else if(peroid >= 7 || peroid <= 14) {
				setIntrestRate(intsrestRates[0]);
				break;
			}
			else if(peroid >= 15 || peroid <= 30) {
				setIntrestRate(intsrestRates[1]);
				break;
			}
			else if(peroid >= 31 || peroid <= 45) {
				setIntrestRate(intsrestRates[2]);
				break;
			}
			else if(peroid >= 46 || peroid <= 90) {
				setIntrestRate(intsrestRates[3]);
				break;
			}
			else if(peroid >= 91 || peroid <= 120) {
				setIntrestRate(intsrestRates[4]);
				break;
			}
			else if(peroid >= 121 || peroid <= 179) {
				setIntrestRate(intsrestRates[5]);
				break;
			}
			else if(peroid == 180) {
				setIntrestRate(intsrestRates[6]);
				break;
			}
			else if(peroid >= 180 || peroid <= 364) {
				setIntrestRate(intsrestRates[7]);
				break;
			}
		}while(true);		
	}
	
	public void calculateIntrest(int Peroid, double intrestRate,  float Principal) {
		System.out.println("INside Calculate Intrest");
		
	}
	public void showEarnigs() {
		Scanner Sc = new Scanner(System.in);
		System.out.print("\t Deposit Ammount :");
		float Principal = Sc.nextFloat();
		setIntrestRateAndMaturity();
		calculateIntrest(getMaturityPeroid(), getIntrestRate(), Principal);
	}

	@Override
	public void showMsg(boolean accStatus, Name custName) {
		// TODO Auto-generated method stub
		
	}
}
