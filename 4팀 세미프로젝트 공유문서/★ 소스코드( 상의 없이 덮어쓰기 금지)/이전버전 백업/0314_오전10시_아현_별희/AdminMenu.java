 
// 4. 관리자용 메뉴 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Map;
import java.util.Iterator;



public class AdminMenu		
{	
	// 입력 인스턴스 생성
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StList st = new StList();		// StList 클래스(학생 명단) 기반 인스턴스 생성 
		
	private String pw = "java002";  //관리자 pw
	
	// 현금 권종 별 시재 변수
	private int cash100 = 50;
	private int cash500 = 50;
	private int cash1000 = 100;
	private int cash5000 = 50;
	private int cash10000 = 30;
	
	int paper = 3; //-->  *초기값 미정. 테스트용!!


	//----------------------------------------------------------------------------

	// ① (관리자 로그인) 비밀번호 입력 메소드			(완료)
	void adLogin() 
	{	
		String tmp_pw = ""; // 사용자가 입력하는 비밀번호 담는 임시 변수
		int cnt = 0; // 비밀번호 잘못 입력한 횟수 (3이 되면 초기화면으로) 

		try
		{
			do
			{
				System.out.print("비밀번호를 입력하세요: ");
				tmp_pw = br.readLine();	

				if (!tmp_pw.equals(pw)) 
				{
				cnt ++;
				System.out.println("비밀번호가 틀렸습니다! 다시 입력하세요.");
				}
				else
				{
					System.out.println("로그인 되었습니다.\n");
					adSelect(); //---> 관리자 메뉴선택 메소드 호출!
					break;
				}
			}
			while (cnt < 3);
			
		}
		catch (IOException e){}		
	} // -----> adLogin() 


    // ② 관리자 메뉴 선택 메소드 (1~4)					(완료)
	void adSelect() throws IOException
	{

		int i = 0; // 사용자 입력값 변수 초기화 

		System.out.println("==================[관리자 메뉴]==================");
		System.out.println(" ① 수입 조회");			    // 수입 (카드/현금/이체 )
		System.out.println(" ② 시재 조회 /관리 ");			  // (권종별 조회 및 채우기)
		System.out.println(" ③ 종이 재고 조회 / 관리 ");		 // (모자라면 채우기)	
		System.out.println(" ④ 학생 정보 관리");				//학생정보(추가,수정,삭제)
		System.out.println(" ⑤ 관리자 메뉴 나가기");         // 초기 화면으로 이동    
		System.out.println(" ⑥ 기기 종료");				  // 무한 루프 종료 
		System.out.println("==================================================");
		System.out.print(">> 메뉴를 선택하세요 (숫자 입력) :");
		i = Integer.parseInt(br.readLine());	

		switch (i)
		{
			case 1: adIncome();   break;
			case 2: adManage();   break;
			case 3: adPaper();    break;
			case 4: adStManage(); break;
			case 5: adExit();     break;
			case 6:	adClose();    break;	
		}
	}


	// ③  <1> 수입 조회     ----> 결제 클래스 설계 이후 진행 예정
	void adIncome() 
	{	
		// 10원, 50원, 50000원 사용 제한
		System.out.println(" === ① 수입 조회 === ");	
		
		// 권종별 수입 : 카드, 현금(권종별), 계좌이체로 받은 금액..	

	}


	// ④   <2> 시재 조회 / 관리 
	void adManage() //--> 시재 조회 메소드
	{	
		//--> 재고 부족 경고는 초기화면에서 볼 수 있어야함 (논의 예정) 

		System.out.println(" \n=== ② 시재 조회 / 관리 === ");	

		int n = 0 ; //사용자 입력값 담을 변수
		try
		{
			System.out.print("1. 시재 조회 2. 시재 관리 (숫자로 선택) : ");
			n = Integer.parseInt(br.readLine());
		}
		catch (IOException e){}
		
		if (n == 1) // 1. 시재 조회
		{	
			System.out.println("-------------[1. 시재 조회]--------------");
			System.out.println("=== 거스름돈 권종별 시재 === "); // 나중에 결제 클래스 설계시, 해당하는 변수 - 해주기.
			System.out.println("100원: " + cash100 + "개 = " + 100 * cash100 + "원");
			System.out.println("500원: " + cash500 + "개 = " + 500 * cash500 + "원");
			System.out.println("1000원: " + cash1000 + "개 = " + 1000 * cash1000 + "원");
			System.out.println("5000원: " + cash5000 + "개 = " + 5000 * cash5000 + "원");
			System.out.println("10000원: " + cash10000 + "개 = " + 10000 * cash10000 + "원");
		}
		else // 2. 시재 관리 
		{
			adCashFull();
		}
	}
    void adCashFull() //--> 시재 관리 메소드 (권종별로 채우기)
	{
		int n = 0 ; // 사용자 입력값 변수

		try
		{	System.out.println("-------------[2. 시재 관리]--------------");
			System.out.println("1: 100원 ");
			System.out.println("2: 500원 ");
			System.out.println("3: 1000원 ");
			System.out.println("4: 5000원 ");
			System.out.println("5: 10000원 ");
			System.out.print("\n >> 채울 권종을 선택하세요! (1 ~ 5) : ");

			n = Integer.parseInt(br.readLine());
		}
		catch (IOException e){}
		
		switch (n) //--> 권종을 번호로 선택해서 변수 초기값으로 채우기.
		{
			case 1: cash100 = 50; System.out.println("[ 100원 재고를 50개로 채웠습니다.]"); break;
			case 2: cash500 = 50; System.out.println("[ 500원 재고를 50개로 채웠습니다.]"); break;
			case 3: cash1000 = 100; System.out.println("[ 1000원 재고를 100개로 채웠습니다.]");break;
			case 4: cash5000 = 50; System.out.println("[ 5000원 재고를 50개로 채웠습니다.]"); break;
			case 5: cash10000 = 30; System.out.println("[ 10000원 재고를 30개로 채웠습니다.]");break;
		}
	}



	// ⑤ <3> 종이 재고 조회 및 관리 --- (완료 ) //  재고 채우는 건 이후 수정 필요(종이 초기값 + 채울방식) 

	void adPaper() //---> 종이 재고 조회 메소드
	{		
		System.out.println(" \n=== ③ 종이 재고 조회 / 관리 === ");	
		
		int n = 0 ; //사용자 입력값 담을 변수
		try
		{
			System.out.print("1. 재고 조회 2. 재고 관리 (숫자로 선택) : ");
			n = Integer.parseInt(br.readLine());
		}
		catch (IOException e){}
		
		if (n == 1) // 1. 재고 조회
		{  System.out.println("-------------[1. 재고 조회]--------------");
		   System.out.println(">> 현재 종이는 " + paper + "개 남아있습니다.");
		}
		else // 2. 재고 관리 
		{
			adPpFull();
		}	

	}
	void adPpFull()	//---> 종이 재고 관리 메소드
	{		
		System.out.println("-------------[2. 재고 관리]--------------");
		paper = 3;
		System.out.println("종이를 3장 채웠습니다.");
	}
	
	


	// ⑤ 학생 정보 관리 (1.조회 2.추가 3.수정 4.삭제)
	void adStManage()
	{	
		
		System.out.println(" \n=== ④ 학생 정보 관리 === ");

		int n = 0; //사용자 입력값 받을 변수
		int cnt = 0; //입력 받은 횟수. 3되면 끝
		
		try
		{
			do
			{
				System.out.print("1.조회 2.추가 3.수정 4.삭제 (숫자로 선택): ");
				n = Integer.parseInt(br.readLine());
			
				if (n==1)
				{
					System.out.println("\n===== 1.조회 ====="); 
					st.readList();
					adStManageBackMenu();
				}
				else if(n==2)
				{
					System.out.println("===== 2.추가 ====="); 
					st.putNew();
					adStManageBackMenu();				
				}
				else if(n==3)
				{
					System.out.println("===== 3.수정 =====");
					st.change(); 
					adStManageBackMenu();				
				}
				else if(n==4)
				{
					System.out.println("===== 4.삭제 =====");
					st.delete(); 
					adStManageBackMenu();				
				}
				else
				{
					System.out.println("1 ~4 사이의 숫자를 입력하세요! ");
					cnt++;
				}
			}
			while (cnt<3);

			if(cnt==3)
			{
				System.out.println("3회 입력 오류로 초기화면으로 돌아갑니다...");	// 나중에 메인에서 while로 계속 돌아갈거니까...
			}
			
			/*
			switch (n)
			{
				case 1: System.out.println("\n===== 1.조회 ====="); 
				//System.out.println(st.map);				 // 더미데이터 (순서 x). 3)이제 st.map 이 가능해짐
				st.readList();
				adStManageBackMenu(); break;       
				
				case 2: System.out.println("===== 2.추가 ====="); 
				st.putNew();
				adStManageBackMenu(); break;

				case 3: System.out.println("===== 3.수정 =====");
				st.change(); 
				adStManageBackMenu(); break;
				
				case 4: System.out.println("===== 4.삭제 =====");
				st.delete(); 
				adStManageBackMenu(); break;		
			}
			*/
		}
		catch (IOException e){}
	}

	void adStManageBackMenu() throws IOException //--> 학생 관리메뉴에서 특정 메뉴 실행 후 '돌아가기' 물어보는 메소드
	{
		int n = 0;
		System.out.println("\n1. 학생 정보 관리로 돌아가기 2. 관리자 메뉴로 돌아가기 : ");
		n = Integer.parseInt(br.readLine());
		if (n==1)
			adStManage();
		else
			adSelect();

	}

	// ⑥ 관리자 메뉴 나가기 (초기 화면으로) 
	void adExit()
	{
		System.out.println("테스트 메뉴 4.");
	}
	
	// ⑦ 기기 종료 (무한 루프 종료)
	void adClose()
	{
		System.out.println("테스트 메뉴 5.");
	}


	public static void main(String[] args) // 메인 메소드 
	{	
		AdminMenu am = new AdminMenu();
		am.adLogin(); 
	}




	
}

/* 학번(key)만 출력 : Iterator 사용 - keySet()
		
            Iterator<String> keys = st.stList().keySet().iterator();
            while (keys.hasNext()){
                String key = keys.next();

                System.out.println("KEY : " + key); // Key2 , Key1, Key4, Key3, Key5
            }
*/