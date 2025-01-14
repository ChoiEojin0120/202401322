package RandomStock;

public class Buying extends Money_Have implements SellorBuy
//Money_Have를 상속하여 현재 소유한 외화를 저장하는 변수에 접근 가능
//SellorBuy 인터페이스의 Sell_Buy 추상 메소드 정의
{
    public void Sell_Buy(int money, double dollar, double yen, 
    		double yuan, double euro, double won)
    {
        InputScan scan = new InputScan();//InputScan 객체를 불러와 정수값을 입력받음
        boolean buy = true;//외화를 계속 구매할 수 있게 하는 변수

        while (buy)
        {        	
        	System.out.println("어떤 외화를 구입합니까?");
    		System.out.println("1. 달러\n2. 엔화\n3. 위안\n4. 유로\n5. 원화\n6. 구매 종료");

    		int choice = scan.Input();
    		
            switch (choice)
            {
                case 1:
                    exchangeCurrency(scan, money, dollar, "USD");
                    
                    System.out.println("\n소지금: " + USD + "달러\n");
                    System.out.println("현재 소지한 원화: " + KRW + "원"); //현재 소지한 외화 출력
    				System.out.println("현재 소지한 엔화: " + JPY + "엔");
    				System.out.println("현재 소지한 위안: " + CNY + "위안");
    				System.out.println("현재 소지한 유로: " + EUR + "유로\n");
    				
                    continue;
                case 2:
                    exchangeCurrency(scan, money, yen, "JPY");

                    System.out.println("\n소지금: " + USD + "달러\n");
                    System.out.println("현재 소지한 원화: " + KRW + "원");
    				System.out.println("현재 소지한 엔화: " + JPY + "엔");
    				System.out.println("현재 소지한 위안: " + CNY + "위안");
    				System.out.println("현재 소지한 유로: " + EUR + "유로\n");
    				
                    continue;
                case 3:
                    exchangeCurrency(scan, money, yuan, "CNY");

                    System.out.println("\n소지금: " + USD + "달러\n");
                    System.out.println("현재 소지한 원화: " + KRW + "원");
    				System.out.println("현재 소지한 엔화: " + JPY + "엔");
    				System.out.println("현재 소지한 위안: " + CNY + "위안");
    				System.out.println("현재 소지한 유로: " + EUR + "유로\n");
    				
                    continue;
                case 4:
                    exchangeCurrency(scan, money, euro, "EUR");

                    System.out.println("\n소지금: " + USD + "달러\n");
                    System.out.println("현재 소지한 원화: " + KRW + "원");
    				System.out.println("현재 소지한 엔화: " + JPY + "엔");
    				System.out.println("현재 소지한 위안: " + CNY + "위안");
    				System.out.println("현재 소지한 유로: " + EUR + "유로\n");
    				
                    continue;
                case 5:
                    exchangeCurrency(scan, money, won, "KRW");

                    System.out.println("\n소지금: " + USD + "달러\n");
                    System.out.println("현재 소지한 원화: " + KRW + "원");
    				System.out.println("현재 소지한 엔화: " + JPY + "엔");
    				System.out.println("현재 소지한 위안: " + CNY + "위안");
    				System.out.println("현재 소지한 유로: " + EUR + "유로\n");
    				
                    continue;
                case 6:
                	buy = false;//buy를 false로 바꾸어 루프 조건 만족X, 실행 종료
                default:
            }
        }
    }

    private static void exchangeCurrency(InputScan scan, int money, double rate, String currency)
    //InputScan scan 객체를 생성하여 정수값을 입력받을 수 있게 함
    //소지금, 환율, 통화명을 받은 후 외화 구매
    //private static으로 설정되어 있어 외부 개입X, 객체 생성 없이도 접근 가능
    {
        System.out.print("\n환전할 금액: ");
        int amount = scan.Input();//환전할 금액을 scan메소드를 통해 입력받음

        if (money < amount * rate)//구매 시의 금액(환전 금액*구매 환율)이 소지금보다 작을 경우 소지금 부족 출력
        {
            System.out.println("소지금이 부족합니다.");
        }
        else
        {
            USD -= amount * rate; //외화 구매량(환전 금액*구매 환울)만큼 소지금(MainMenu에서 seed만큼 USD에 저장됨)감소
            
            switch (currency)
            {
                case "USD":
                    USD += amount;
                    break;
                    
                case "JPY":
                	JPY += amount; //외화 구매량만큼 외화 소지량 증가
                	break;
                	
                case "CNY":
                	CNY += amount;
                	break;
                	
                case "EUR":
                	EUR += amount;
                	break;
                	
                case "KRW":
                	KRW += amount;
                	break;
                    
            }
        }
    }
}
