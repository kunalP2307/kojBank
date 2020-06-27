
public abstract class TermDeposit extends Account {
	
	
	protected int maturityPeroid;
	protected double intrestRate;
	protected float intrestAmmount;
	//protected termDepositCertificate certificate;
	
	public abstract void createAccount();
	public abstract void showIntrestRatesAndMAaturityPeroids(String maturityPeroids[],double intrestRates[]);
	public abstract void setIntrestRateAndMaturity();
	public abstract void calculateIntrest(int Peroid, double intrestRate,  float Principal);
	public abstract void showEarnigs();


	public int getMaturityPeroid() {
		return maturityPeroid;
	}

	public void setMaturityPeroid(int maturityPeroid) {
		this.maturityPeroid = maturityPeroid;
	}

	public double getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(Double intrestRate) {
		this.intrestRate = intrestRate;
	}

	public float getIntrestAmmount() {
		return intrestAmmount;
	}

	public void setIntrestAmmount(float intrestAmmount) {
		this.intrestAmmount = intrestAmmount;
	}
	
	
}
