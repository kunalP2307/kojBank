package BasicUtilities;
import java.util.Scanner;

public class Age {
	
	public static byte getAge() {
		Scanner Sc = new Scanner(System.in);
		byte int_age=0;
		do {
			System.out.print("\tAge : ");
			String Age = Sc.next();
				try {
		            int_age = Byte.parseByte(Age);
		        } catch (NumberFormatException e) {
		        	System.out.println("\t Please Enter Valid Age..");
		        	continue;
		       }
			   break;
		}while(true);
	return int_age;
	}
}