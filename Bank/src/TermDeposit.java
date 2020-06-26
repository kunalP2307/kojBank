
public abstract class TermDeposit extends Account {
	
	
	protected float principleAmmount;
	protected int maturityPeroid;
	protected double intrestRate;
	protected float intrestAmmount;
	//protected termDepositCertificate certificate;
	
	public abstract void createAccount();

	public float getPrincipleAmmount() {
		return principleAmmount;
	}

	public void setPrincipleAmmount(float principleAmmount) {
		this.principleAmmount = principleAmmount;
	}

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
