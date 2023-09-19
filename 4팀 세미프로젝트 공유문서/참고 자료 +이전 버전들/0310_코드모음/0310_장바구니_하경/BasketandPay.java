import java.util.Scanner;
import java.util.Vector;

class Menus		//-- 변수만 생성
{
	public static final int E_PAY = 1;		//-- 전체 결제 
	public static final int E_BACK = 2;		//-- 메뉴로 돌아가기
	public static final int E_DEL = 3;		//-- 장바구니 삭제
	public static int sum = 0;				//-- 누적 금액
}

class BasketandPay
{	
	// 주요 속성 구성
	private static final Vector<Object> vt1;		//-- 자료구조
	private static final Vector<Object> vt2;		//-- 자료구조
	private static Scanner sc;					//-- 입력 시 활용
	private static Integer sel;					//-- 선택 값
	
	static
	{
		// Vector 자료구조 생성
		vt1 = new Vector<Object>();
		vt2 = new Vector<Object>();

		// Scanner 인스턴스 생성
		sc = new Scanner(System.in);
 
		// 사용자 입력 값 초기화
		sel = 0;
	}
	

	// 매개변수로 받은 증명서 종류와 매수를 자료구조에 저장


	// 메뉴 선택 메소드
	public static void menuSelect() throws NumberFormatException
	{
		addElement();		// 우선 장바구니에 넣고 시작


		// 문자열 예외처리
		try
		{
			do
			{
				System.out.print(">> 메뉴 선택(1-3) : ");
				sel = sc.nextInt();
			}
			while (sel < 1 || sel > 6);
			
		}
		catch (NumberFormatException e)	// 숫자 이외에는
		{
			System.out.println("1~3 사이의 숫자로 선택해주세요");
		}
	}



	// 선택된 메뉴 실행에 따른 기능 호출 메소드
	public static void menuRun() 
	{
		

		switch (sel)
		{
		case Menus.E_PAY: HowtoPay(); break;
		case Menus.E_BACK: BacktoMenu(); break;
		case Menus.E_DEL: delBasket(); break;		
		}
	}

	// 장바구니에 넣기
	public static void addElement()
	{
		Register rg = new Register();			// 연수의 Register클래스 인스턴스 생성

		int certificate = rg.printMenu();		// certificate 변수 받아오고
		int su = rg.howMany();					// su 받아오고

		vt1.add(certificate);		// 증명서
		vt2.add(su);				//
		
	}

	public static void HowtoPay() 
	{}
	public static void BacktoMenu() 
	{}
	public static void delBasket() 
	{}

}