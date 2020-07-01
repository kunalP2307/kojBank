import java.util.Scanner;
import BasicUtilities.*;

public class Customer {
	
	protected int custID;
	protected String mPin;
	protected Name custName;
	protected long mobileNo;
	protected Address custAddress;
	protected byte age;
	protected String Gender;
	protected IdProof personalID;
	//protected Account[] accounts;
	protected Account account;
	protected Card cards[];
	protected Loan loans[];
	protected TermDeposit investments[];
	protected UPI upi[];
	protected Beneficiary beneficiary;
	protected int nofCardsOwned = 0;
	public static int LastCustNo = 1201;
	
	
	// Getters And Setters
	public int getCustID() {
		return custID;
	}
	public void setCustID() {
		this.custID = LastCustNo;
		LastCustNo ++;
	}
	
	public String getmPin() {
		return mPin;
	}
	public void setmPin(int mPin) {
		this.mPin = PassWord.encryptPassWord(mPin);
	}
	
	public String getCustName() {
		return custName.getLastName()+" "+custName.getFirstName()+" "+custName.getMiddleName();
	}
	public void setCustName(Name custName) {
		this.custName = custName;
	}
	
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public Address getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(Address custAddress) {
		this.custAddress = custAddress;
	}
	
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
	
	public IdProof getPersonalId() {
		return personalID;
	}
	public void setPersonalId(IdProof personalID) {
		this.personalID = personalID;
	}
	public IdProof getPersonalID() {
		return personalID;
	}
	public void setPersonalID(IdProof personalID) {
		this.personalID = personalID;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Card[] getCards() {
		return cards;
	}
	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	public void setCard(Card card,int pos) {
		if(pos == 0) {
			System.out.println("memory initialized");
			this.cards = new Card[2];
		}
		cards[pos] = card;
	}
	
	public void applyCard() {
		Name n = new Name();
		Card C1 = new Card();
		C1 = Card.generateCard(123, 132, n);
		setCard(C1, nofCardsOwned);
		nofCardsOwned ++;
		System.out.println(C1.getCardNo());
	}
	
	
	public static Customer setCustDetails(Customer C) {
		Scanner Scan = new Scanner(System.in);
		byte choice = 0; 
		
	
		DrawLine line = new DrawLine();
		FormUtilities form = new FormUtilities();
		
		C.setCustID();
		System.out.println("\t\tKindly Fill All the Mendetoery Fields :");
		System.out.println("\n\t ~Personal Details..");
		line.drawTabLine();
		C.setCustName(Name.setName());
		System.out.print("\tAge : ");
		C.setAge(Scan.nextByte());
		
		System.out.print("\tMobile No : ");
		C.setMobileNo(Scan.nextLong());
		
		C.setGender(form.selectGender());		
		line.drawTabLine();
		
		C.setCustAddress(Address.acceptAddress());	
		line.drawTabLine();
		
		C.setPersonalId(IdProof.acceptIdProof());		
		line.drawTabLine();
		
		System.out.print("\tWant to add Beneficiary For Your Account [Y/n] : " );
		String Choice = Scan.next();
		if(Choice.equalsIgnoreCase("Y")) {
			C.setBeneficiary(Beneficiary.acceptBeneficiary());
		}
		System.out.println("\tOne Final Step...! ");
		enTer: do {
			System.out.print("\tSet Your Mobile Pin : ");
		int temp = Scan.nextInt();
		reEnter: do{ 
			System.out.print("\tReEnter : ");
			if(Scan.nextInt() == temp) {
				C.setmPin(temp);
				break enTer;
			}
			else {
				System.out.println("\t ReEntered Pin Dosen't matches with the prevously Entered Pin  :");
				System.out.println("\t ReEnter Pin (R)");
				System.out.println("\t Set new MPin (N)");
				System.out.print("\n\t Select One : ");
				String Ch = Scan.next();
				if(Ch.equalsIgnoreCase("R")) {
					continue reEnter;
				}
				else if(Ch.equalsIgnoreCase("N")) {
					continue enTer;
				}
			}
		}while(true);
		}while(true);
				
			
		line.drawTabLine();
		return C;
			
	}	
}
