package BasicUtilities;
import java.util.Scanner;
import javax.sound.midi.Soundbank;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Name {
	protected String firstName;
	protected String middleName;
	protected String lastName;
	
	//Getters And Setters
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		//System.out.println(firstName);
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		//System.out.println(middleName);
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		//System.out.println(lastName);
		this.lastName = lastName;
	}
	public static Name getName() {
		Scanner Scan = new Scanner(System.in);
		String name[] = new String[3];
		Name N = new Name();
	outer:	do {	
			System.out.println("\n\t\t   LastName FirstName MiddleName");
			System.out.print("\tFull Name :");
			name[0] = Scan.next();
			name[1] = Scan.next();
			name[2] = Scan.next();
			
			for(int i=0 ; i<3;i++) {
				Pattern pattern = Pattern.compile("[a-zA-Z]*");
			    Matcher matcher = pattern.matcher(name[i].trim());
			    if (!matcher.matches()) {
			    	System.out.println("Name Cannot Contain Number Or Special Character..!");
			    	continue outer;
			    }
			}
			N.setLastName(name[0]);
			N.setFirstName(name[1]);
			N.setMiddleName(name[2]);
			break;
		}while(true);
		return N;	
	}
	public String toString() {
		return getLastName()+" "+getFirstName()+" "+getMiddleName();
	}
}