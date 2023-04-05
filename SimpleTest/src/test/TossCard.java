package test;

public class TossCard extends Card {
	static String company = "Toss";
	String cardStaff;

	public TossCard(String cardNo, int validDate, int cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card No, " + this.cardNo);
		System.out.println("담당직원 - " + this.cardStaff + ", " + this.company);
	}
}
