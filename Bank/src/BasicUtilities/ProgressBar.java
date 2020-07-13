package BasicUtilities;

public class ProgressBar {
	
	public static void fillProgressBar()throws Exception {
		for(int i=0 ; i<40 ; i++) {
			if(i==0) {
				System.out.print("\t[");
			}
			System.out.print("#");
			try {
				Thread.sleep(80);
			}catch(Exception e) {}
		}
		System.out.print("]");
	}
	public static void main(String args[]) throws Exception{
		ProgressBar.fillProgressBar();
	}
	

}
