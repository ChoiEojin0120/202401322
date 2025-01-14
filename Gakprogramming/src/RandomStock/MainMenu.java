/*

객체지향프로그래밍 평과과제 (배점 25점)

학과: 컴퓨터공학과
학번: 202401322
이름: 최어진

과제 주제: 달러를 이용한 외환 투자
 
*/

package RandomStock;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//데이터 입력 스트림 import

public class MainMenu extends Money_Have
{
	public static void main(String args[]) throws IOException
		{
			Dollar dollar = new Dollar();
		
			System.out.println("\n======================================\n");
		
			System.out.println("외화 투자 시뮬레이터");
			
			System.out.println("\n======================================\n");
			
			System.out.println("바로 시작하기: 1");
			System.out.println("설명 듣기: 2\n");

			boolean success = true; //투자 성공 여부 초기화
			InputScan scan = new InputScan(); //숫자를 입력받는 메소드
			
			if(scan.Input() == 2) // 2를 입력받을 시 설명 출력
			{
				System.out.println("\n미국, 일본, 중국, EU, 한국의 외화에 투자하여 목표 금액에 도달하는 것이 목표입니다.");
				System.out.println("환율은 투자할 때마다 값이 바뀝니다.");
				System.out.println("소지금이 0이 되거나 목표 금액에 도달할 시 시뮬레이션이 종료됩니다.\n");
			}
			
			System.out.print("\n시작 금액을 숫자로 입력하십시오: ");
			int seed = scan.Input();
			
			if(seed <= 0) //시작 금액은 0 이상이어야 함
			{
				System.out.println("\n시작 금액은 0달러보다 커야 합니다.");
				System.out.println("시작 금액을 재입력하십시오.\n");
				
				while (seed <= 0) //시작 금액에 0 이상의 수를 입력할 때까지 루프
				{
					System.out.print("시작 금액: ");
					seed = scan.Input();
				}
			}
			
			System.out.print("\n목표 금액을 숫자로 입력하십시오: ");
			int ideal = scan.Input();
			
			if(ideal <= seed) //목표 금액은 시작 금액을 초과해야 함
			{
				System.out.println("\n목표 금액은 시작 금액보다 커야 합니다.");
				System.out.println("목표 금액을 재입력하십시오.\n");
				
				while (ideal <= seed) //목표 금액에 100이상의 수를 입력할 때까지 루프
				{
					System.out.print("목표 금액: ");
					ideal = scan.Input();
				}
			}
			
			for(USD = seed; USD <= ideal;) //시작 금액인 seed를 달러인 USD에 저장
			{	
				System.out.println("\n소지금: " + USD + "달러");
				System.out.println("목표 금액: " + ideal + "달러");
				System.out.println("목표까지 남은 금액: " + (ideal-USD) + "달러\n");

				System.out.println("현재 소지한 원화: " + KRW + "원");
				System.out.println("현재 소지한 엔화: " + JPY + "엔");
				System.out.println("현재 소지한 위안: " + CNY + "위안");
				System.out.println("현재 소지한 유로: " + EUR + "유로\n");
				
				if (USD <= 0) //소지금이 0이하일 시 강제 종료
				{
					System.out.println("소지금이 0달러 이하로 떨어졌습니다.");
					System.out.println("프로그램을 종료합니다.");
					success = false; //투자 성공 여부를 실패로 바꿈
					
					break;
				}
				
				System.out.println("1. 외화 사기\n2. 외화 팔기\n");
				
				switch(scan.Input())
				{
				case 1:
					dollar.Buy(); //외화를 구매하는 메소드 호출
					continue;
					
				case 2:		
					dollar.Sell(); //외화를 판매하는 메소드 호출
					continue;
					
				default:
					System.out.println("잘못된 입력입니다."); //1과 2가 아닌 다른 입력값일 시 출력
					continue;
				}
			}
			
			System.out.println("\n======================================\n");
			
			System.out.println("지금까지의 결과");
			System.out.println("시작 금액: " + seed);
			System.out.println("목표 금액: " + ideal);
			
			System.out.println("\n======================================\n");
			
			System.out.println("\n현재 소지한 원화: " + KRW + "원");
			System.out.println("현재 소지한 엔화: " + JPY + "엔");
			System.out.println("현재 소지한 위안: " + CNY + "위안");
			System.out.println("현재 소지한 유로: " + EUR + "유로");
			
			System.out.println("\n======================================\n");
			
			System.out.println("벌어들인 금액: " + USD + "달러");
			System.out.print("목표 금액 달성 여부: ");
			
			if(success)// 성공 시 success 값이 초기 그대로 true이므로 성공 출력
			{
				System.out.println("성공");
				System.out.println("남은 금액: " + (USD-ideal) + "달러");
			}
			else //실패 시 success가 false가 되므로 실패 출력
			{
				System.out.println("실패");
				System.out.println("갚아야 할 금액: " + (USD-ideal) + "달러");
			}
			
			System.out.println("지금까지 벌어들인 금액, 목표, 성공 횟수를 저장합니다.\n");
			
			//append 패러미터의 값을 true로 설정하여 계속해서 값을 저장하도록 함
			//기본 타입(int)입력 보조 스트림 연결하여 int값을 저장함
			
			OutputStream moneyrank = new FileOutputStream("C:/temp/Rank_Money.db", true);
			
			try (DataOutputStream rank_Money = new DataOutputStream(moneyrank))
			{
				rank_Money.writeInt(USD);
			}
			
			OutputStream idealrank = new FileOutputStream("C:/temp/Rank_Ideal.db", true);
			
			try (DataOutputStream rank_Ideal = new DataOutputStream(idealrank))
			{
				rank_Ideal.writeInt(ideal);
			}
			
			OutputStream Success = new FileOutputStream("C:/temp/Success.db", true);
			
			try (DataOutputStream SorF = new DataOutputStream(Success))
			{
				if(success)
				{
					SorF.writeInt(1); //투자 성공 시 1 저장
				}
				else
				{
					SorF.writeInt(0); //투자 실패 시 0 저장
				}
			}
			
			System.out.println("시뮬레이션이 종료되었습니다.\n");
			System.out.println("1. 랭킹 보기");
			System.out.println("1이 아닌 숫자 키를 눌러 종료");
			
			if(scan.Input() == 1)
			{//가장 큰 목표 금액과 수익, 투자 성공 및 실패 횟수를 저장한 파일을 읽어서 출력하는 메소드
				System.out.println("가장 크게 벌어들인 금액: " + Rank.bestmoney());
				System.out.println("가장 크게 설정한 목표: " + Rank.bestideal());
				System.out.println("성공한 횟수: " + Rank.Success()[0]);//Success는 배열을 리턴하므로 배열의 1번째 값인 성공 횟수 출력
				System.out.println("실패한 횟수: " + Rank.Success()[1]);//배열의 2번째 값인 실패 횟수 출력
				scan.closeScanner();//Scanner 객체를 사용하는 InputScan 메소드를 닫아 메모리 누수 방지
			}
			else
			{
				System.out.println("수고하셨습니다.");
				scan.closeScanner();//Scanner 객체를 사용하는 InputScan 메소드를 닫아 메모리 누수 방지
			}
			
		}
			
}
