package test;

public class Card {
	String cardNo;
	int validDate;
	int cvc;
	
	public Card(String cardNo,int validDate,int cvc) {
		this.cardNo = cardNo;
		this.validDate =validDate;
		this.cvc =cvc;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getValidDate() {
		return validDate;
	}

	public void setValidDate(int validDate) {
		this.validDate = validDate;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public void showCardInfo() {
		System.out.println("카드정보 ( Card NO : "+this.cardNo+", 유효기간 : "+this.validDate+", CVC : "+this.cvc);
	}
}
