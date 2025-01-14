package RandomStock;

public class Selling extends Money_Have implements SellorBuy
//Money_Have를 상속하여 현재 소유한 외화를 저장하는 변수에 접근 가능
//SellorBuy 인터페이스의 Sell_Buy 추상 메소드 정의
{
    public void Sell_Buy(int money, double dollar, double yen, double yuan, double euro, double won)
    {
        InputScan scan = new InputScan();//InputScan 객체를 불러와 정수값을 입력받음
        boolean sell = true;//외화를 계속 판매할 수 있게 하는 변수

        while (sell)
        {
        	System.out.println("어떤 외화를 판매합니까?");
    		System.out.println("1. 달러\n2. 엔화\n3. 위안\n4. 유로\n5. 원화\n6. 판매 종료");

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
                	sell = false; //sell을 false로 바꾸어 루프 조건 만족X, 실행 종료
                	break;
            }
        }
    }

    private static void exchangeCurrency(InputScan scan, int money, double rate, String currency)
    //InputScan scan 객체를 생성하여 정수값을 입력받을 수 있게 함
    //소지금, 환율, 통화명을 받은 후 외화 판매
    //private static으로 설정되어 있어 외부 개입X, 객체 생성 없이도 접근 가능
    {
        System.out.print("\n환전할 금액: ");
        int amount = scan.Input();//환전할 금액을 scan메소드를 통해 입력받음
        
        switch (currency)//입력받은 통화명 case에 따라 판매하는 외화 변화
            {
                case "USD":
                	USD += amount * rate;
                    USD -= amount;
                    
                case "JPY":
                	if (amount > JPY) //판매할 금액이 외화 소지량보다 클 경우
                	{
                		System.out.println("소지한 엔화가 부족합니다.");
                	}
                	else
                	{
                		JPY -= amount; //판매량만큼 소지 외화 감소
                		USD += amount * rate; //판매 시의 환율만큼 달러를 얻음
                	}
                	break;
                    
                case "CNY":
                	if (amount > CNY)
                	{
                		System.out.println("소지한 위안이 부족합니다.");
                	}
                	else
                	{
                		CNY -= amount;
                		USD += amount * rate;
                	}
                	break;
                    
                case "EUR":
                	if (amount > EUR)
                	{
                		System.out.println("소지한 유로가 부족합니다.");
                	}
                	else
                	{
                		EUR -= amount;
                		USD += amount * rate;
                	}
                	break;
                    
                case "KRW":
                	if (amount > KRW)
                	{
                		System.out.println("소지한 원화가 부족합니다.");
                	}
                	else
                	{
                		KRW -= amount;
                		USD += amount * rate;
                	}
                	break;
            }
        }
    }
