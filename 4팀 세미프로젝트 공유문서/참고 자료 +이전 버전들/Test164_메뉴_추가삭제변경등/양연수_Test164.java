/*=================================
  ■■■ 컬렉션(Collection) ■■■
===================================*/

// Test164 클래스를 완성하여
// 다음 기능을 가진 프로그램을 구현한다.

/*
실행 예)

	==[메뉴 선택]==
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	===============
>> 메뉴 선택(1~6) : 1

1번째 요소 입력 : 양연수
1번째 요소 입력 성공 ~!!
요소 입력 계속(Y/N) : y

2번째 요소 입력 : 유서영
2번째 요소 입력 성공 ~!!
요소 입력 계속(Y/N) : n

	==[메뉴 선택]==
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	===============
>> 메뉴 선택(1~6) : 2

[벡터 전체 출력]
양연수
유서영
벡터 전체 출력 완료~!!!

	==[메뉴 선택]==
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	===============
>> 메뉴 선택(1~6) : 3

>> 검색할 요소 입력 : 유서영

[검색 결과 출력]
항목이 존재합니다.

	==[메뉴 선택]==
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	===============
>> 메뉴 선택(1~6) : 3

>> 검색할 요소 입력 : 이기배

[검색 결과 출력]
항목이 존재하지 않습니다.

	==[메뉴 선택]==
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	===============
>> 메뉴 선택(1~6) : 4

>> 삭제할 요소 입력 : 이준복

[삭제 결과 출력]
항목이 존재하지 않아 삭제할 수 없습니다.

	==[메뉴 선택]==
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	===============
>> 메뉴 선택(1~6) : 4

>> 삭제할 요소 입력 : 양연수

[삭제 결과 출력]
양연수 항목이 삭제되었습니다.

	==[메뉴 선택]==
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	===============
>> 메뉴 선택(1~6) : 5

>> 변경할 요소 입력 : 주수인

[변경 결과 출력]
변경할 대상이 존재하지 않습니다.

	==[메뉴 선택]==
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	===============
>> 메뉴 선택(1~6) : 5

>> 변경할 요소 입력 : 유서영
>> 수정할 내용 입력 : 진주연

[변경 결과 출력]
변경이 완료되었습니다.

	==[메뉴 선택]==
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	===============
>> 메뉴 선택(1~6) : 2

[벡터 전체 출력]
진주연
벡터 전체 출력 완료 ~!!!

	==[메뉴 선택]==
	1. 요소 추가
	2. 요소 출력
	3. 요소 검색
	4. 요소 삭제
	5. 요소 변경
	6. 종료
	===============
>> 메뉴 선택(1~6) : 6

프로그램 종료~!!
계속하려면 아무 키나 누르세요 . . .
*/


/*		if (sel == m.E_ADD){
			addElement();
		}else if(sel == m.E_DISP){
			dispElement();
		}else if(sel == m.E_FIND){
			findElement();
		}else if(sel == m.E_DEL){
			delElement();
		}else if(sel == m.E_CHA){
			chaElement();
		}else if(sel == m.E_EXIT){
			exit();
		}
*/

import java.util.Vector;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//import java.util.Iterator;
	
class Menus		// → 완성
{
	public static final int E_ADD = 1;		//-- 요소 추가
	public static final int E_DISP = 2;		//-- 요소 출력
	public static final int E_FIND = 3;		//-- 요소 검색
	public static final int E_DEL = 4;		//-- 요소 삭제
	public static final int E_CHA = 5;		//-- 요소 변경
	public static final int E_EXIT = 6;		//-- 종료
}

public class Test164
{
	// 주요 속성 구성 → 완성
	private static final Vector<Object> vt;	//-- 자료구조
	private static BufferedReader br;		//-- 입력 시 활용
	private static Integer sel;				//-- 선택 값
	private static String con;				//-- 계속 진행 여부
	
	// static(정적) 초기화 블럭
	static
	{	
		// Vector 자료구조 생성
		vt = new Vector<Object>();

		// BufferedReader 인스턴스 생성
		br = new BufferedReader(new InputStreamReader(System.in));

		// 사용자 입력값 초기화
		sel = 1;
		con = "Y";
	}


	// 메뉴 출력 메소드
	public static void menuDisp()
	{
		System.out.print("\n==[메뉴 선택]==\n1. 요소 추가\n2. 요소 출력\n3. 요소 검색\n4. 요소 삭제\n5. 요소 변경\n6. 종료\n===============\n");
	}

	// 메뉴 선택 메소드
	public static void menuSelect() throws IOException, NumberFormatException
	{
		System.out.print(">> 메뉴 선택(1~6) : ");
		sel = Integer.parseInt(br.readLine());
		//menuRun();
	}


	// 선택된 메뉴 실행에 따른 기능 호출 메소드
	public static void menuRun() throws IOException
	{
		Menus m = new Menus();
		
		switch(sel){
			case 1 : addElement(); break;
			case 2 : dispElement(); break;
			case 3 : findElement(); break;
			case 4 : delElement(); break;
			case 5 : chaElement(); break;
			case 6 : exit(); break;
		}
	}


	// 자료구조에 요소 추가(입력) 메소드
	public static void addElement() throws IOException
	{
		/*
		1번째 요소 입력 : 양연수
		1번째 요소 입력 성공 ~!!
		요소 입력 계속(Y/N) : y
		*/
		int n=1;
		do
		{
			System.out.printf("%d번째 요소 입력 : ", n);
			vt.add(br.readLine());
			System.out.printf("%d번째 요소 입력 성공~!!\n", n);
			System.out.print("요소 입력 계속(Y/N) : ");
			con = br.readLine();
			n++;
		}
		while (con.equals("y") || con.equals("Y"));
	}


	// 자료구조 전체 요소 출력 메소드
	public static void dispElement()
	{
		//Iterator<Object> it = vt.iterator;
		/*
		[벡터 전체 출력]
		양연수
		유서영
		벡터 전체 출력 완료~!!!
		*/
		System.out.println("[벡터 전체 출력]");
		//System.out.println((String)it.next());
		for(Object obj : vt)
			System.out.println(obj);
	}

	// 자료구조 내 요소 검색 메소드
	public static void findElement() throws IOException
	{
		/*
		>> 검색할 요소 입력 : 유서영

		[검색 결과 출력]
		항목이 존재합니다.
		*/
		System.out.print(">> 검색할 요소 입력 : ");
		boolean b = vt.contains(br.readLine());
		System.out.println("\n[검색 결과 출력]");
		if(b == true)
		{
			System.out.println("항목이 존재합니다.");
		}
		else
			System.out.println("항목이 존재하지 않습니다.");
	}

	// 자료구조 내 요소 삭제 메소드
	public static void delElement() throws IOException
	{
		/*
		>> 삭제할 요소 입력 : 양연수

		[삭제 결과 출력]
		양연수 항목이 삭제되었습니다.
		*/
		System.out.print(">> 삭제할 요소 입력 : ");
		String name = br.readLine();
		boolean b = vt.contains(name);
		if (b==true)
		{
			vt.remove(name);
			System.out.println("\n[삭제 결과 출력]");
			System.out.printf("%s 항목이 삭제되었습니다.\n", name);
		}
		else
		{
			System.out.println("\n[삭제 결과 출력]");
			System.out.println("변경할 대상이 존재하지 않습니다.");
		}
		
	}

	// 자료구조 내 요소 수정(변경) 메소드
	public static void chaElement() throws IOException
	{
		/*
		>> 변경할 요소 입력 : 주수인

		[변경 결과 출력]
		변경할 대상이 존재하지 않습니다.

		>> 변경할 요소 입력 : 유서영
		>> 수정할 내용 입력 : 진주연
		*/
		//vt.set(0,"");
		System.out.print(">> 변경할 요소 입력 : ");
		String name = br.readLine();
		boolean b = vt.contains(name);
		if (b==true)
		{
			System.out.print(">> 수정할 내용 입력 : ");
			String name2 = br.readLine();
			int i = vt.indexOf(name);
			vt.set(i,name2);
			System.out.println("\n[변경 결과 출력]\n");
			System.out.println("변경이 완료되었습니다.\n");
		}
		else
		{
			System.out.println("[변경 결과 출력]\n");
			System.out.println("변경할 대상이 존재하지 않습니다.\n");
		}

	}

	// 프로그램 종료 메소드 → 완성
	public static void exit()
	{
		System.out.println("\n프로그램 종료~!!!");
		// return();			// → 메소드 종료 o, 시스템종료 x
		System.exit(-1);		// 시스템이 종료되면서 반환값 -1을 넘긴다.(확인용도)
	}

	// main() 메소드 → 완성
	public static void main(String[] args) throws IOException, NumberFormatException
	{
		do
		{
			menuDisp();
			menuSelect();
			menuRun();
		}
		while (true);
	}
}