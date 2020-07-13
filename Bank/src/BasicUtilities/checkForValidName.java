package BasicUtilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkForValidName {
	public static void main(String Args[]) {
		  Pattern pattern = Pattern.compile("[a-zA-Z]*");
	      String str = "kunal";
	      Matcher matcher = pattern.matcher(str);
	 
	      if (!matcher.matches()) {
	           System.out.println("string '"+str + "' contains special character");
	      } else {
	           System.out.println("string '"+str + "' doesn't contains special character");
	      }
	}

}
