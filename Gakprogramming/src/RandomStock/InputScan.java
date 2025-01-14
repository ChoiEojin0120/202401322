package RandomStock;

import java.util.Scanner;

public class InputScan
{
    // Scanner를 클래스 멤버 변수로 선언, private이므로 외부 접근으로 인한 입력 방해X
    private static final Scanner scanner = new Scanner(System.in);

    public int Input()//값을 입력받는 메소드
    {
        int num = 1;//메소드에서 입력받아 리턴되는 변수 num을 1로 초기화
        String input = scanner.nextLine();//scanner를 통해 값을 String으로 받음
        
        try 
        {
            num = Integer.parseInt(input); // 입력값을 정수로 변환
        } 
        catch (NumberFormatException e) //try catch 예외처리를 통해 정수값이 아닐 시 값을 1로 고정
        {
            System.out.println("해당 값은 정수가 아닙니다.");
            System.out.println("값을 1로 고정합니다.");
        }
        
        return num;//입력받은 num 값 리턴
    }

    public void closeScanner()// Scanner를 닫는 메소드, 메인 프로그램 종료 시 호출하여 메모리 누수 방지
    {
        scanner.close();
    }
}

