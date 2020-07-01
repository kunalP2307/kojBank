import java.time.LocalDate;

public class PassBook {
	protected int TransactionNo;
	
	protected Transaction transaction[];
	public PassBook() {
		transaction = new Transaction[50];
		System.out.println("memory initiated for transaction");
		TransactionNo= 0;
	}
	
	public int getTransactionNo() {
		return TransactionNo;
	}
	public void setTransactionNo(int transactionNo) {
		TransactionNo = transactionNo;
	}
	public Transaction[] getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction[] transaction) {
		this.transaction = transaction;
	}
	public void setTransaction(Transaction trans) {
		transaction[TransactionNo] = trans;
		TransactionNo++;
	}
	
	public void writeTransaction(String particular,float ammount,float balance) {
		Transaction T = new Transaction();
		LocalDate D = LocalDate.now();
		T.setNoOfTransaction(TransactionNo);
		T.setDateOfTransaction(D);
		T.setParticulars(particular);
		if(ammount < 0) {
			T.setAmmountDeposited(0);
			T.setAmmountWithDrawn(ammount);
		}
		else {
			T.setAmmountWithDrawn(0);
			T.setAmmountDeposited(ammount);
		}
		T.setBalance(balance);
		setTransaction(T);
	}	
	
	
	public void displayPassBook() {
		System.out.println("\t\tt\t-----PassBook-------");
		System.out.println("\n\n");
		
		System.out.println("\t Line |  Date  | Particular | Ammount  | Ammount   | Balance ");
		System.out.println("\t  No.			     Debited   Credited");
		System.out.println("\t -----------------------------------------------------------------");
		for(int i=0; i<TransactionNo ; i++) {
			System.out.println("\t "+(i+1)+" |   "+transaction[i].getDateOfTransaction()+"   |   "+transaction[i].getParticulars()+"   |   "+transaction[i].getAmmountWithDrawn()+"  |   "+transaction[i].getAmmountDeposited()+"  |  "+transaction[i].getBalance());
		}
		  
	}
	
	public static void main(String Args[]) {
		PassBook P = new PassBook();
		LocalDate D = LocalDate.now();
		System.out.println(D);
		P.writeTransaction("ATM", 2345, 23456);
		P.displayPassBook();
	}
}