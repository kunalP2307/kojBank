import java.util.Scanner;

import BasicUtilities.Name;

public class RecuringDepostit extends TermDeposit{
	
	public static double intsrestRates[] = {4.75,5.15,5.25,4.90,4.90,4.90};
	public static String maturityPeroidInMonths[] = {"6","12","18","24","30","36"};
	
	protected boolean monthlyDepositRecord[] = new boolean[36];
	protected float monthlyDepositAmmount;
	/*protected float principleAmmount;
	protected int maturityPeroid;
	protected double intrestRate;
	protected float intrestAmmount; */
	
	
	public float getMonthlyDepositAmmount() {
		return monthlyDepositAmmount;
	}

	public void setMonthlyDepositAmmount(float monthlyDepositAmmount) {
		this.monthlyDepositAmmount = monthlyDepositAmmount;
	}
	public void createMonthlyDepositCard() {
		monthlyDepositRecord[0] = true;
		System.out.println(monthlyDepositRecord[0]);
	}

	public void createAccount() {
		Scanner Sc = new Scanner(System.in);
		String Ch;
		System.out.println("\n\n\t---------Recuring Deposti-------------\n");
		System.out.println("\n\t     ~Save significant Ammount by making "
						+ "\n\t      Smaller investment every month..");		
		
		// draw line
		
		System.out.print("\n\t  Find out how much you can earn and save by making"
				+ "\n\t 	monthly deposits in our Recurring Deposits"
				+ "\n\t		 Yes / Continue ..[Y/c] : ");
		Ch  = Sc.next();
		if(Ch.equalsIgnoreCase("y")) {
			showEarnigs();
		}
		
		System.out.print("\n\t Apply Now [Y/n] : ");
		Ch = Sc.next();
		if(Ch.equalsIgnoreCase("Y")) {
			do {	
				System.out.print("\n\t Regular Monthly Deposit Ammount : ");
				float Ammount = Sc.nextFloat();
				if(Ammount >= 500) {
					boolean b = initateAccountBalance(Ammount,2);
					if(b)
						setMonthlyDepositAmmount(Ammount);
					break;
				}
				else {
					System.out.println("\t Oops...! Minimum Monthly Deposit Ammount must be "
							+ "\n\t  greater than equal to Rs 500/-");
					continue;
				}
				
			}while(true);
			setIntrestRateAndMaturity();
			createMonthlyDepositCard();
		}
		showMsg();
	}
	public void setIntrestRateAndMaturity() {				
		Scanner Sc = new Scanner(System.in);
		String Ch;
		System.out.print("\t Want to Check the Intrest Rates By Identfying the "
				+ "\n\t   Saving Term Yes/Continue[Y/c] :");
		Ch = Sc.next();
		
		if(Ch.equalsIgnoreCase("Y")) {
			showIntrestRatesAndMAaturityPeroids(maturityPeroidInMonths, intsrestRates);
		}
		do {
			System.out.print("\t Saving Term (In month) : ");
			int peroid = Sc.nextInt();
			
			if(peroid == 6) {
				setIntrestRate(intsrestRates[0]);
				break;
			}
			else if(peroid == 12) {
				setIntrestRate(intsrestRates[1]);
				break;
			}
			else if(peroid == 18) {
				setIntrestRate(intsrestRates[2]);
				break;
			}
			else if(peroid == 24) {
				setIntrestRate(intsrestRates[3]);
				break;
			}
			else if(peroid == 30) {
				setIntrestRate(intsrestRates[4]);
				break;
			}
			else if(peroid == 36) {
				setIntrestRate(intsrestRates[5]);
				break;
			}
			else {
				System.out.println("\t Sorry we Don't Have the selected Saving Term as of Now...");
				System.out.print("\t Want to Chechout the Saving Terms [Y/n]");
				Ch = Sc.next();
				if(Ch.equalsIgnoreCase("y")) {
					showIntrestRatesAndMAaturityPeroids(maturityPeroidInMonths, intsrestRates);
				}
				System.out.print("\t Found the Situable InvestMent Peroid For You [Y/n] :");
				Ch = Sc.next();
				if(Ch.equalsIgnoreCase("y")) {
						continue;
				}
			}
			
		}while(true);		
	}

	public void showIntrestRatesAndMAaturityPeroids(String maturityPeroids[],double intrestRates[]){	
		
		System.out.println("\n\tThe Following List shows Saving Termm And its Corresponding Rate of Intrest..");
		System.out.println("\n\tPeroid"+"\t\t\t"+"Intrest");
		System.out.println("\t......"+"\t\t\t|\t"+".......");
		for(int i=0 ; i<RecuringDepostit.maturityPeroidInMonths.length ; i++) {
			System.out.println("\t"+maturityPeroids[i]+" Months"+"\t\t|\t"+intrestRates[i]+"%");
		}
	}


	
	public void calculateIntrest(int Peroid, double intrestRate,  float Principal) {
		
		
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
		System.out.println("\n\t Stay Calm...And Earn Extra Income"
				+ "\n\t Your Ammount is in Secure Hands...");
		
	}
}
