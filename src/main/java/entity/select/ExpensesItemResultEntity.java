package entity.select;

public class ExpensesItemResultEntity {
	private Integer expensesNumber;
	private String expensesName;
	private String rate;
	private boolean checkDisplayed;
	public Integer getExpensesNumber() {
		return expensesNumber;
	}
	public void setExpensesNumber(Integer expensesNumber) {
		this.expensesNumber = expensesNumber;
	}
	public String getExpensesName() {
		return expensesName;
	}
	public void setExpensesName(String expensesName) {
		this.expensesName = expensesName;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public boolean isCheckDisplayed() {
		return checkDisplayed;
	}
	public void setCheckDisplayed(boolean checkDisplayed) {
		this.checkDisplayed = checkDisplayed;
	}
}
