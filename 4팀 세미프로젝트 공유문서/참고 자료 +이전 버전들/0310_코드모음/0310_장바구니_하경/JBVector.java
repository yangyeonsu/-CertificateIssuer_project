import java.util.Vector;

class Loading
{
	private static int count;

	public static void loading()
	{
		System.out.print("결제중");
		count = 0;
		Timer t = new Timer();
		TimerTask tm = new TimerTask(){
				
				@Override
				public void run()
				{
					
					if(count<5)
					{
						System.out.print(".");
						count++;
					}
					else
					{
						//
						t.cancel();
					}
				}
			};
			
			t.schedule(tm, 1000, 1000);

	}
}


class JBandPay extends Loading
{
	int sum;			// 결제 금액 누적합. 


	// User클래스의 basket메소드에서 매개변수 넘겨받기
	// 증명서 종류와 매수를 장바구니(벡터)에 넣는 메소드
	void getCerti(int certificate, int su)		// 증명서 번호와 매수
	{
		// Vector(벡터) 자료구조 v 생성
		Vector<Object> v1 = new Vector<Object>();
		Vector<Object> v2 = new Vector<Object>();

		// v1 벡터 자료구조에 증명서번호 담기
		v1.add(certificate);		
		// v2 벡터 자료구조에 증명서의 매수 담기
		v2.add(su);		
		
		CalSum(certificate, su);
		
	}
	
	// 금액 계산
	void CalSum(int certificate, int su)
	{
		switch (certificate)
		{
		case 1: sum += 1300*su; break;
		case 2: sum += 2100*su; break;
		case 3: sum += 1800*su; break;		
		}
		
	}

	void Golla()
	{
		Register rg = new Register();
		Scanner sc = new Scanner(System.in);	

		System.out.print("1. 장바구니 전체 결제\n2. 메뉴창으로 돌아가기\n3. 장바구니 비우기");
		int g = sc.nextInt();

		switch (g)
		{
		case 1: TotPay(); break;
		case 2: rg.printMenu(); break;		// 연수가 만든 클래스의 메소드 호출
		case 3: JBreset(); break;		
		}
		
	}

	void TotPay()		// 전체 결제 메소드
	{
		Scanner sc = new Scanner(System.in);	

		System.out.print("1. 카드결제\n2. 현금\n3. 계좌이체");
		int p = sc.nextInt();

		switch (p)
		{
		case 1: Card(); break;
		case 2: Cash(); break;
		case 3: Transfer(); break;		
		}
	}

	// 카드 결제 메소드
	void Card()
	{
		Random rd = new Random();
		int num;										// 카드 결제 오류를 결정하는 랜덤 수를 받는 변수
		System.out.println("결재할 금액 " + sum);		// 결제할 총 금액 출력 
		System.out.println("카드를 삽입해주세요.");
		
		

		num = rd.nextInt(10);							// 0 ~ 9사이의 랜덤 변수를 생성 
		// System.out.println(num);

		if (num == 0) 
		{									// → 0이 나오면 
			Loading.loading(3);							//  인식 불가
			//System.out.println("IC칩 인식이 불가합니다.\n카드를 긁어주세요.");		// 카드 인식 오류
			
		}
		else
		{
			Loading.loading(1);		//결제 완료
		}
		
		
	}

	void Cash()
	{
		Scanner sc = new Scanner(System.in);
		int cash;

		System.out.println("결재할 금액 " + sum);

		System.out.println("현금을 투입하세요");
		System.out.print("투입할 금액 입력 : ");
		cash = sc.nextInt();

		/*
		if (cash == sum)
		{
			Loading.loading();
		}
		else
			if (cash > sum)
			{
				
			}
			*/

		
	}
	
}





