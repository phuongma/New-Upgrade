package Data;

public class AccountInfo {
	private String username = "user12345@upgrade-challenge.com";
	private String password = "Upgrade1";
	private String loanAmount;
	private String monthlyPayment;
	private String term;
	private String interestRate;
	private String apr;

	public void acctInfo() {	
	}
	
	public void setUsername(String strUsername) {
		username = strUsername;
	}

	public void setPassword(String strPassword) {
		password = strPassword;
	}
	
	public void setLoanAmount(String strLoanAmount) {
		loanAmount = strLoanAmount;
	}
	
	public void setMonthlyPayment(String strMonthlyPayment) {
		monthlyPayment = strMonthlyPayment;
	}

	public void setTerm(String strTerm) {
		term = strTerm;
	}
	
	public void setInterestRate(String strInterestRate) {
		interestRate = strInterestRate;
	}

	public void setApr(String strApr) {
		apr = strApr;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	
	public String getLoanAmount() {
		return loanAmount;
	}
	
	public String getMonthlyPayment() {
		return monthlyPayment;
	}

	public String getTerm() {
		return term;
	}
	
	public String getInterestRate() {
		return interestRate;
	}

	public String getApr() {
		return apr;
	}
}
