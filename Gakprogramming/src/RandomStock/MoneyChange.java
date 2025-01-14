package RandomStock;

public class MoneyChange //외화의 환율을 변동시키는 메소드가 있는 클래스
{
	public double UpDown(double dollar)//double인 환율값을 받음
	{
		int Change = (int)(Math.random()*3) + 1; //1~3 중 하나를 뽑음, 환율이 변화하는 경우를 결정
		int updown = (int)(Math.random()*10)+1; //0.1 이상 1.0 미만 소숫점 한 자리 아래 수 뽑음, 이만큼 환율이 변화함
		double UpDown = updown/10;
		
		switch(Change)
		{
			case 1:
				dollar += UpDown; //Change가 1일 시 환율이 UpDown만큼 오름
				break;
			case 2:
				break; //Change가 2일 시 아무런 변화도 일어나지 않음
			case 3:
				dollar -= UpDown; //Change가 3일 시 환율이 UpDown만큼 내림
				break;
		}
		
		return dollar;//변화한 환율 값 리턴
	}
}
