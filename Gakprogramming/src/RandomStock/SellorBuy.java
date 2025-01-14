package RandomStock;

public interface SellorBuy//외화를 사고파는 인터페이스
{
	public void Sell_Buy(int money, 
			double dollar, double yen, double yuan, double euro, double won);
	//환율과 소지금을 받는 추상 메소드
}
