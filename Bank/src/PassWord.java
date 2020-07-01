
public class PassWord {
	
	public static String encryptPassWord(int pass) {
		
		String binPass = Integer.toBinaryString(pass+23);
		String binEncPass = bitwiseNot(binPass);
		return binEncPass;
	}
	
	public static int decryptPassWord(String pass) {
		String binPass = charwiseNot(pass);
		int decryptedPass= Integer.parseInt(binPass,2);
		decryptedPass -= 23;
		return decryptedPass;
	}
	
	static char invertBit(char c) {
		if(c=='1') {
			return 'x';
		}
		else return 'y';
	}
	static char invertChar(char c) {
		if(c == 'x') {
			return '1';
		}
		else return '0';
	}
	static String bitwiseNot(String bin) {
		String comple = "";
		
		for(int i =0 ; i<bin.length() ;i++) {
			comple += invertBit(bin.charAt(i));
		}
		System.out.println(comple);
		return comple;
	}
	static String charwiseNot(String bin) {
		String comple = "";
		
		for(int i =0 ; i<bin.length() ;i++) {
			comple += invertChar(bin.charAt(i));
		}
		//System.out.println(comple);
		return comple;
	}

}
