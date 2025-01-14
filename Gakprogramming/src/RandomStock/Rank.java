package RandomStock;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//데이터 출력 스트림 import, 예외처리 import

public class Rank extends MainMenu//가장 큰 목표 금액과 수익, 투자 성공 및 실패 횟수를 저장한 파일을 읽어서 출력하는 메소드
{
    public static int bestmoney() throws IOException //throws를 통한 예외처리
    {
        FileInputStream moneyread = new FileInputStream("C:/temp/Rank_Money.db");//수익 저장하는 파일 Rank_Money 읽어들임
        
        try (DataInputStream Read_money = new DataInputStream(moneyread))
        {
            int[] moneyRank = new int[100]; // 최대 100개의 데이터를 처리할 수 있도록 설정
            int count = 0; // 실제 데이터 개수를 추적
            int best = 0;

            // 데이터 읽기
            while (Read_money.available() > 0 && count < moneyRank.length)
            {
                moneyRank[count++] = Read_money.readInt();//파일에 값이 존재하며 실제 데이터 개수가 100개 미만일 때 읽어들인 값을 배열에 하나씩 저장
            }

            // 배열의 값을 하나씩 비교하며 최고 금액을 도출해 best에 저장함
            for (int i = 0; i < count; i++) 
            {
                if (moneyRank[i] > best) 
                {
                    best = moneyRank[i];
                }
            }

            return best; //최고 금액인 best 값을 리턴
        }
    }

    public static int bestideal() throws IOException 
    {
        FileInputStream idealread = new FileInputStream("C:/temp/Rank_Ideal.db");//목표값 저장하는 파일 Rank_Ideal 읽어들임
        
        try (DataInputStream Read_ideal = new DataInputStream(idealread)) 
        {
            int[] idealRank = new int[100];
            int count = 0;
            int best = 0;

            while (Read_ideal.available() > 0 && count < idealRank.length) 
            {
                idealRank[count++] = Read_ideal.readInt();
            }

            for (int i = 0; i < count; i++) 
            {
                if (idealRank[i] > best) 
                {
                    best = idealRank[i];
                }
            }

            return best;
        }
    }

    public static int[] Success() throws IOException 
    {
        FileInputStream successread = new FileInputStream("C:/temp/Success.db");//성공 및 실패 여부를 저장하는 파일 Success 읽어들임
        
        try (DataInputStream Read_success = new DataInputStream(successread)) 
        {
            int[] successed = new int[100];
            int count = 0;
            int Success = 0; //성공 횟수 0으로 초기화
            int Fail = 0; //실패 횟수 0으로 초기화

            while (Read_success.available() > 0 && count < successed.length) 
            {
                successed[count++] = Read_success.readInt();
            }

            for (int i = 0; i < count; i++) 
            {
                if (successed[i] == 1)//성공 시 1이 배열에 쓰여짐(MainMenu에서)
                {
                    Success++;//성공 횟수 증가
                } 
                
                else 
                {
                    Fail++;//실패하여 1이 아닌 0이 배열에 쓰여짐(MainMenu에서), 실패 횟수 증가
                }
            }

            return new int[]{Success, Fail};//성공 횟수와 실패 횟수를 배열로 받아 리턴
        }
    }
}
