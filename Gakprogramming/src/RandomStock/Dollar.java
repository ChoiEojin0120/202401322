package RandomStock;
import java.util.HashMap;
import java.util.Map;

public class Dollar extends Money_Have//가지고 있는 모든 외화 값을 저장하고 있는 Money_Have 상속
{
    public void Buy()
    {	
    	Buying buy = new Buying();//외화를 구매하는 객체 Buying 불러옴
    	
    	Map<String, Double> Dollar = new HashMap<String, Double>();
    	//외화를 살 때의 환율을 Map으로 저장함
    	
    	Dollar.put("달러", 1.00);
		Dollar.put("엔화", 0.60);
		Dollar.put("위안", 0.70);
		Dollar.put("유로", 1.10);
		Dollar.put("원화", 0.50);
    	
    	double dollar = Dollar.get("달러");
		double yen = Dollar.get("엔화");
		double yuan = Dollar.get("위안");
		double euro = Dollar.get("유로");
		double won = Dollar.get("원화");
		//각 외화의 환율을 변수로 저장하여 구매 메소드와 환율 변화 메소드에서 사용하도록 함
		
		MoneyChange moneychange = new MoneyChange();
		
    	System.out.println("\n======================================\n");
    	
    	System.out.println("구매 시의 환율:\n");
		
		for (Map.Entry<String, Double> entry : Dollar.entrySet())
		//외화의 이름과 환율을 저장하는 Dollar Map에 포함된 Key와 Value를 Set으로 변환 후 entry Map에 저장
		{
			System.out.println(entry.getKey() + " : " + (entry.getValue()) + "배");
			//for문을 돌면서 entry Map에 저장된 Dollar Map의 Key와 Value를 출력
		}
		
		System.out.println("\n======================================\n");
		
		buy.Sell_Buy(USD, dollar, yen, yuan, euro, won);
		//현재 가지고 있는 달러와 달러를 각 나라의 외화로 바꿀 때의 환율을 받아 외화를 구매하는 메소드
		
		Dollar.put("엔화", moneychange.UpDown(yen));
		Dollar.put("위안", moneychange.UpDown(yuan));
		Dollar.put("유로", moneychange.UpDown(euro));
		Dollar.put("원화", moneychange.UpDown(won));
		//0.1 이상 1.0이하의 소숫점 1자리 수를 더하거나 빼는 메소드 UpDown으로 환율 변화
		//변화한 환율을 Dollar에 저장, 이때 같은 Key가 존재하므로 기존 Value에 덮어씌워짐
		
    }

    public void Sell()
    {
    	Selling sell = new Selling(); //외화를 파는 객체 Selling 불러옴
    	
    	Map<String, Double> Dollar = new HashMap<String, Double>();
    	//외화를 팔 때의 환율을 Map으로 저장함
    	
    	Dollar.put("달러", 1.00);
		Dollar.put("엔화", 1.50);
		Dollar.put("위안", 1.40);
		Dollar.put("유로", 0.90);
		Dollar.put("원화", 1.60);
    	
		double dollar = Dollar.get("달러");
		double yen = Dollar.get("엔화");
		double yuan = Dollar.get("위안");
		double euro = Dollar.get("유로");
		double won = Dollar.get("원화");
		//각 외화의 환율을 변수로 저장하여 판매 메소드와 환율 변화 메소드에서 사용하도록 함
		
		MoneyChange moneychange = new MoneyChange();
		
    	System.out.println("\n======================================\n");
		
    	System.out.println("판매 시의 환율:\n");
    	
		for (Map.Entry<String, Double> entry : Dollar.entrySet())
		{
			System.out.println(entry.getKey() + " : " + (entry.getValue()) + "배");
		}
		
		System.out.println("\n======================================\n");
		
		sell.Sell_Buy(USD, dollar, yen, yuan, euro, won);
		//현재 가지고 있는 달러와 달러를 각 나라의 외화로 바꿀 때의 환율을 받아 외화를 판매하는 메소드
		
		Dollar.put("엔화", moneychange.UpDown(yen));
		Dollar.put("위안", moneychange.UpDown(yuan));
		Dollar.put("유로", moneychange.UpDown(euro));
		Dollar.put("원화", moneychange.UpDown(won));
	}
}
