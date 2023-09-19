
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class StList 
{
	Map<String, String> map = new HashMap<>();  //---> HashMap 인스턴스 생성
	Scanner sc = new Scanner(System.in);        //---> 스캐너 인스턴스 생성

	public Map<String, String> stList() // 전역변수 map =/= return 으로 받는 map은 다르다. (이름만 같음) 
	{	
		// map이라는 HashMap 자료구조에 요소 추가 // put(k,v);
		map.put("20230125", "강별희");
		map.put("20230126", "양연수");
		map.put("20230127", "최하경");
		map.put("20230128", "한아현");

		//System.out.println(map);
		return map;
		
	}
 
	public void putNew()	//-- > 학생 정보 추가 메소드 (AdminMenu 클래스에서 호출)	
	{
		System.out.print(">> 추가할 학생의 학번을 입력하세요 : ");
		String hak = sc.next();
		System.out.print(">> 추가할 학생의 이름을 입력하세요 : ");
		String name = sc.next();
		stList().put(hak, name);
		System.out.println("학생 정보 (" + hak +","+ name + ") 가 추가되었습니다.");
		//System.out.println(stList());
	}
	
	public void change() //---> 학생 정보 수정 메소드 (AdminMenu 클래스에서 호출)	
	{
		// containsValue() : 해당 값이 자료구조 안에 있으면 true 반환하는 메소드
		
		System.out.print(">> 수정할 학생의 이름을 입력하세요 : ");
		String name = sc.next();         //--> 수정할 학생 원래 이름
		String newName = "";			 //--> 바꿀 이름

		boolean isExist = stList().containsValue(name) ; // 기본값 true.
		int cnt = 0;

		while (cnt < 3)
		{
			if (isExist)		// 학생이름이 자료구조에 존재하면
			{
				System.out.print(">> 변경할 이름을 입력하세요 : ");
				newName = sc.next();

				// 수정할 이름의 key 값 구하기
				Iterator<String> keys = stList().keySet().iterator();
				while (keys.hasNext())
				{
					String key = keys.next(); 
					System.out.println("1. " + key);

					if (stList().get(key).equals(name))
					{	
						String newKey = key;
						System.out.println("2. " + stList().get(key));
						stList().replace(newKey, newName); //----> if문 실행은 되는데 실제 값이 변경 안 되고있음~~~~!!!!! 
						//stList().put(key, newName);
						
					}
					else
						continue;		
				}
				System.out.printf("%s 학생의 이름이 %s로 변경되었습니다.\n", name, newName);
				System.out.println("3. " + stList());
				break;//루프 종료
			}
			else				// 학생이름이 자료구조에 존재하지 않으면
			{
				System.out.print(">> 해당 학생이 존재하지 않습니다.");
				cnt++;
			}		
		}//---> 변경할 이름 입력받는 루프
		


		
		

	}//--> change()

	public void delete() //---> 학생 정보 삭제 메소드 (AdminMenu 클래스에서 호출)	
	{
		// remove()
		
	}

}
/* =========== 컨닝페이퍼 ^_^ [ 3/8 수 - 172 ] ===============
	           ■■ 컬렉션(Collection) ■■	
  ---------------------------------------------------------
	○ Map 의 하위...-->  HashMap 클래스.

HashMap<K,V> 클래스
: Hashtable 클래스와 마찬가지로 Map 인터페이스에서 상속받은 
HashMap 클래스의 기능은 Hashtable과 동일하지만 
Synchronization이 없어서 동시성 문제가 없다면(즉, 멀티 스레드 프로그램이 아닌경우)
HashMap을 사용하는게 성능 향상에 유리하다
또한 HashMap은 Hashtable과 달리 null을 허용한다. 

Hashtable과 거의 비슷하지만...
멀티스레드 언세이프티. 즉 동기화가 빠져있는 Hashtable이다~~ (기능이 하나 빠져있다~ 성능이 좋다)

 =========================================================*/