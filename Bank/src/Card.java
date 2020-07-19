import java.sql.Date;
import java.util.Random;
import java.util.Scanner;

import BasicUtilities.MaskString;
import BasicUtilities.Name;

public class Card {
	 	

	public static long LastCardNo = 6522290000000001l;
	public static int noOfCardsDistribuited = 1;
	public static Card cardsDistribuited[];
	
	
	static {
		cardsDistribuited = new Card[5];
		cardsDistribuited[0] = new Card();
		cardsDistribuited[0].accountLinkedToCard = new CurrentAccount();
		cardsDistribuited[0].accountLinkedToCard.setAccBalance(10000);
		cardsDistribuited[0].setCardNo(6522290000000000l);
		cardsDistribuited[0].setCVV(123);
	}
	
	protected Account accountLinkedToCard;
	protected long regMobiileNo;
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

	public Account getAccountLinkedToCard() {
		return accountLinkedToCard;
	}

	public void setAccountLinkedToCard(Account accountLinkedToCard) {
		this.accountLinkedToCard = accountLinkedToCard;
	}

	public void applyForCard() {
		/*
		 * 
		 * 
		 */
	}
	
	
	
	public static Card generateCard(long regMobiileNo,Account accountLinkedToCard,Name nameOnCard ) {
		Card C = new Card();
		Random R = new Random();
		C.setRegMobiileNo(regMobiileNo); 
		C.setAccountLinkedToCard(accountLinkedToCard);
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
		
		boolean transactionStatus = false;
		 Card is_validCard= validateCard();
		 if(transactionAmmount < 0) {
			 System.out.println("\n\t Ammount Can't Bw Negative..!");
			 return false;
		 }
			
		 	if(is_validCard != null) {
		 			if(is_validCard.accountLinkedToCard.getAccBalance() < transactionAmmount) {
		 				System.out.println("\n\t Sorry You Don't Have Enough Balamce To Make the Transaction...");
			 			return false;
		 			}
		 			is_validCard.accountLinkedToCard.setAccBalance(is_validCard.accountLinkedToCard.getAccBalance() - transactionAmmount);
		 			// pass accNo of the Card to the method to return the account Balance..
		 			
		 			// show account debited by transactoionAmmount
		 			System.out.println("Transaction Successfull..");
		 			return true;
		 		}
			else if(is_validCard == null) {
				System.out.println("\n\t Opps..! Something Went Wrong...!"
							+"\n\t   Could Not Initiate Your Transaction.."
							+ "\n\t   The Entered Card Details Seems Invalid..");
			}
		return transactionStatus;
	}
	public static Card validateCard() {
		
		System.out.println(cardsDistribuited[0].getCardNo());
		System.out.println(cardsDistribuited[0].getCVV());
		Scanner Sc = new Scanner(System.in);
		boolean is_validCard  = false;
		System.out.println("\t -- Fill the Card Details --\n");
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
					return cardsDistribuited[pos];
				}
			}
		}
		return null;
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
	
	public static long getCardBalance(Card card) {
		return 0;
	}
	
	public boolean withDrawalMoney() {
		return true;
	}
	public static void showCards(Card[] cards,int noOfCardsOwned) throws Exception{
		
		if(noOfCardsOwned == 0) {
			System.out.println("\t Sorry You Don't Own Any Cards"
					+ "\n\t But You Can Apply for it In Manage Card Section ");
		}
		else {
			for(int i=0; i<noOfCardsOwned ; i++) {
				System.out.println("\t"+(i+1) +"Card Ending : "+MaskString.maskString(Long.toString(cards[i].getCardNo()), 0, 8, '*'));
			}
		}
	}
	
//	public static void main(String Args[]) {
//		Name n = new Name();
//		BSBD b = new BSBD();
//		b.setAccBalance(12000);
//		Card C = Card.generateCard(1234, b, n);
//		Card.makeTransaction(2345);
//		System.out.println("Card Balance :"+C.accountLinkedToCard.getAccBalance());
//		System.out.println("Card Balance :"+b.getAccBalance());
//	//	Card.generateCard(23, 23, n);
//	}

}


