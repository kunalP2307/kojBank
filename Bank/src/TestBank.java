public class TestBank {
	public static void main(String Args[]) {
		Branch B = new PuneBranch();
		Customer c1 = new Customer();
		Branch.openAccount(c1);
	}
}