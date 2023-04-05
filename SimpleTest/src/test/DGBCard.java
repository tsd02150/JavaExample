package test;

public class DGBCard extends Card{
	static String company = "대구은행";
	String cardStaff;
	
	public DGBCard(String cardNo, int validDate, int cvc,String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}
	
	@Override
	public void showCardInfo() {
		System.out.println("카드정보 (Card NO : "+this.cardNo+", 유효기간 : "+this.validDate+", CVC : "+this.cvc);
		System.out.println("담당직원 - "+this.cardStaff+", "+this.company);
	}
	
}
