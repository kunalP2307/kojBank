import java.sql.Date;
import java.util.Random;
import java.util.Scanner;

import BasicUtilities.Name;

public class Card {
	 	

	public static long LastCardNo = 6522290000000000l;
	public static int noOfCardsDistribuited = 0;
	public static Card cardsDistribuited[];
	
	
	static {
		cardsDistribuited = new Card[30];
	}
	
	
	protected long regMobiileNo;
	protected int accNo;
	protected long cardNo;
	protected Name nameOnCard;
	protected Date validTill;
	protected int CVV;
	protected int pin;
	
	
	public long getRegMobiileNo() {
		return regMobiileNo;
	}

	public void setRegMobiileNo(long regMobiileNo) {
		this.regMobiileNo = regMobiileNo;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public Name getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(Name nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}

	public static void setLastCardNo(long lastCardNo) {
		LastCardNo = lastCardNo;
	}

	public static void setNoOfCardsDistribuited(int noOfCardsDistribuited) {
		Card.noOfCardsDistribuited = noOfCardsDistribuited;
	}

	public static void setCardsDistribuited(Card[] cardsDistribuited) {
		Card.cardsDistribuited = cardsDistribuited;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public static Card generateCard(long regMobiileNo,int accNo,Name nameOnCard ) {
		Card C = new Card();
		Random R = new Random();
		C.setRegMobiileNo(regMobiileNo); 
		C.setAccNo(accNo);
		C.setNameOnCard(nameOnCard);
		C.setCardNo(LastCardNo);
		C.setCVV(R.nextInt(999));
		int temp = R.nextInt(9999);
		C.setPin(~temp);
		System.out.println(C.pin);
		System.out.println(~C.pin);
		System.out.println(C.CVV);
		// add valid till
		cardsDistribuited[noOfCardsDistribuited] = C;
		noOfCardsDistribuited++;
		LastCardNo++;
		return C;
		
	}
	
	

	public static boolean makeTransaction(float transactionAmmount) {
		 boolean validCard= validateCard();
		 boolean transactionStatus = false;
		 	if(validCard == true) {
				
		 		
		 		// check the available balance of the linked Account...
		 		// pass accNo of the Card to the method to return the account Balance..
		 		// show account debited by transactoionAmmount
				System.out.println("Transaction Successfull..");
			}
			else {
				System.out.println("\t Opps..! Something Went Wrong...!"
							+"\n\t   Could Not Initiate Your Transaction.."
							+ "\n\t   The Entered Card Details Seems Invalid..");
			}
		return transactionStatus;
	}
	
	public boolean blockCard() {
		System.out.println("\t------Block Cadrd---------");
		Scanner Sc = new Scanner(System.in);
		boolean validdMob = false;
		System.out.print("\t Your Registerd Mobile Number With the Bank Account : ");
		long mobNo = Sc.nextLong();
		// validate Mobile Number Function inside the Package
		
		int pos = 0;
		for(int i = 0 ; i<noOfCardsDistribuited; i++) {
			if(cardsDistribuited[i].getRegMobiileNo() == mobNo) {
				validdMob  = true;
				pos = i;
				break;
			}
		}
		
		if(validdMob == true) {
			noOfCardsDistribuited = DeleteFromArr(cardsDistribuited, pos ,noOfCardsDistribuited);
			System.out.println("\t Stay Calm..! "
					+ "\n\t	YOur Card Has Been Successfully Blocked..! ");
		}
		else {
			System.out.println("\t Oppss...!! Something Went Wrong..."
					+ "\n\t	There is No Card Linked To the Entered Mobile Number...");
		}
		return true;
	}
	
	
	public int DeleteFromArr(Card arr[] ,int pos,int size) {
		
			for(int i=pos ; i<size ; i++) {
				arr[i-1] = arr[i];
			}
			size--;
			return size;
	}
	
	public static boolean validateCard() {
		Scanner Sc = new Scanner(System.in);
		boolean validCard  = false;
		System.out.println("\t -- Fill the Card Details --");
		System.out.print("\t Card No : ");
		long cardNo = Sc.nextLong();
		System.out.println(cardNo);
		System.out.print("\t		  mm yyyy");
		System.out.print("\n\t Valid till : ");
		int month = Sc.nextInt();
		int year = Sc.nextInt();
		System.out.print("\n\t CVV : ");
		int cvv = Sc.nextInt();
		
		for(int i=0 ; i<noOfCardsDistribuited ; i++) {
			System.out.println(cardsDistribuited[i].getCardNo());
			
			if(cardsDistribuited[i].getCardNo() == cardNo) {
				
				if(cardsDistribuited[i].getCVV() == cvv) {
						
					// validate exipry Date
					int pos =i;
					validCard = true;
					break;
				}
			}
		}
		return validCard;
	}
	
	public boolean withDrawalMoney() {
		return true;
	}
	
	public static void main(String Args[]) {
		Name n = new Name();
		Card.generateCard(1234, 2345, n);
		Card.makeTransaction(2345);
		
	//	Card.generateCard(23, 23, n);
	}
	
}


