

import java.util.Calendar;
import java.util.Scanner;

// 2. 초기화면 클래스 (시작화면 -> 메뉴 선택까지)

public class FirstScreen  
{	
	
	// 입력받은 값 담을 변수
	public final String printerCode = "Canon001";	// printerCode : 프린터기 코드
								
	

	void fsPrint()
	{
		//  날짜, 요일, 시간 상단에 출력 
		// Calendar 객체 생성
		Calendar cal = Calendar.getInstance();

		int y = cal.get(Calendar.YEAR);				// 연도
		int m = cal.get(Calendar.MONTH);			// 달
		int d = cal.get(Calendar.DATE);				// 날
		int hh = cal.get(Calendar.HOUR_OF_DAY);		// 시
		int mm = cal.get(Calendar.MINUTE);			// 분
		int ss = cal.get(Calendar.SECOND);			// 초
		
		//System.out.println(y);
		System.out.println(y + "-" +m+ "-" +d+ "   " +hh+ "시 " + mm+ "분 " + ss+ "초");
		//--==>> 2023-2-9   14시 42분 33초	



        //  용지 재고 출력
		//System.out.printf("현재 들어있는 a4용지 수량 : %d장\n", );

        // ---- enter --> 누르면 다음 화면(메뉴선택 메소드)으로 넘어가기

	}

	void fsSelectMenu()  //  1. 재학생 / 2. 졸업생/ 3. 관리자  선택(입력받기)
	{	
		Scanner sc = new Scanner(System.in);

		
	   /*  인스턴스 변수명 : 			
		 1. 재학생 rg
		 2. 졸업생 gr
		 3. 관리자 ad
	   */ 
		RegiStudent rg = new RegiStudent();
		GradStudent gr = new GradStudent();
		//AdminMenu ad = new AdminMenu();


		System.out.printf("①재학생 ②졸업생 ③관리자 를 선택해주세요 : ");
		int position = sc.nextInt();				// 포지션 선택

		switch (position)
		{
			// ①재학생
			case 1: rg.login(); break;
			// ②졸업생
			case 2: gr.login(); break;	
			// ③관리자
			//case 3: ad.adLogin(); break;
		}
	}

}