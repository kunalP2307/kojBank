package BasicUtilities;

import java.util.Scanner;

public class MobileNo {
	
	public static long getMobileNo() {
		Scanner Sc = new Scanner(System.in);
		long mobileNo=0;
		boolean b = false;
		String str_mobNo;
		do {
			System.out.print("\tMobile No : ");
			str_mobNo = Sc.next();
			b = checkValidMobileNo(str_mobNo);
			if(!b) {
				System.out.println("\t Plese Enter Valid Mobile No .. ");
			}
		}while(b == false);
		mobileNo = Long.parseLong(str_mobNo);
		return mobileNo;
	}
	public static boolean checkValidMobileNo(String MobileNo) {
		String mobileNo_regex = "[7-9][0-9]{9}";
		return MobileNo.matches(mobileNo_regex);
	}
	
	
	public static void main(String Args[]) {
		MobileNo.getMobileNo();
	}
}
