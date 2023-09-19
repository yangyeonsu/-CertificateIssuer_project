
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class StList 
{
	Map<String, String> map = new HashMap<>();  //---> HashMap 인스턴스 map 생성
	Scanner sc = new Scanner(System.in);        //---> 스캐너 인스턴스 생성

	public void stList() // map을 반환하는 메소드, 데이터 넣고 역할 끝.
	{	
		// map이라는 HashMap 자료구조에 요소 추가 // put(k,v);
		map.put("20230125", "강별희");
		map.put("20230126", "양연수");
		map.put("20230127", "최하경");
		map.put("20230128", "한아현");

		//System.out.println(map);
		//return map;
	}
	
	public void readList() //--- > 학생 정보 조회 메소드
	{
		System.out.println(map);
	}
 
	public void putNew()	//-- > 학생 정보 추가 메소드 (AdminMenu 클래스에서 호출)	(완성)
	{
		System.out.print(">> 추가할 학생의 학번을 입력하세요 : ");
		String hak = sc.next();
		System.out.print(">> 추가할 학생의 이름을 입력하세요 : ");
		String name = sc.next();
		map.put(hak, name);
		System.out.println("학생 정보 (" + hak +","+ name + ") 가 추가되었습니다.");
		System.out.println(map);
	}
	
	public void change() //---> 학생 정보 수정 메소드 (AdminMenu 클래스에서 호출)	(완성)
	{
		// containsValue() : 해당 값이 자료구조 안에 있으면 true 반환하는 메소드
		
		int cnt = 0;
		String name = "";                //--> 수정할 학생 원래 이름
		String newName = "";			 //--> 바꿀 이름

		do
		{	
			System.out.print(">> 수정할 학생의 이름을 입력하세요 : ");
			name = sc.next();        

			if (map.containsValue(name))
			{
				System.out.print(">> 변경할 이름을 입력하세요 : ");
				newName = sc.next();
				break;
			}
			else
			{
				System.out.println(">> 해당 학생이 존재하지 않습니다.");
				cnt++;
			}
		}
		while (cnt < 3);
		
				
		Iterator<String> keys = map.keySet().iterator();
		while (keys.hasNext())
		{
			String key = keys.next(); 

			if ((map.get(key)).equals(name))
			{				
				//stList().replace(key, newName); //----> if문 실행은 되는데 실제 값이 변경 안 되고있음~~~~!!!!! 
				map.put(key, newName);
				System.out.printf("%s 학생의 이름이 %s(으)로 변경되었습니다.\n", name, newName);
				System.out.println("3. " + map);
				break;//루프 종료
			}		
		}

	}//--> change()

	public void delete() //---> 학생 정보 삭제 메소드 (AdminMenu 클래스에서 호출)	(완성)
	{
		// remove()
		
		String temp = "";	// 삭제할 학번 임시 변수
		int cnt = 0;

		do
		{
			System.out.print(">> 삭제할 학생의 학번을 입력하세요 : ");
			temp = sc.next();

			if (map.containsKey(temp))
			{	
				String tmp = map.get(temp); //  삭제 대상 학생명
				map.remove(temp);
				System.out.printf("학생 정보( %s, %s) 삭제 되었습니다.\n", temp,tmp);
				break;
			}
			else
			{
				System.out.println(">> 해당 학생이 존재하지 않습니다.");
				cnt++;
			}
		}
		while (cnt<3);
		



		
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


 // 전역변수 map =/= return 으로 받는 map은 다르다. (이름만 같음) 



 /*  entry를 활용해서 key, value를 같이 얻어오는 방법 --> 출처:   https://mommoo.tistory.com/50

	 Set set = hashMap.entrySet();

	Iterator iterator = set.iterator();



	while(iterator.hasNext())
	{

	  Map.Entry entry = (Map.Entry)iterator.next();

	  String key = (String)entry.getKey();

	  String value = (String)entry.getValue();

	  System.out.println("hashMap Key : " + key);

	  System.out.println("hashMap Value : " + value);
	 }
 
 */


 /* map 자료구조를 전체 출력하는 방법 --> 출처: https://tychejin.tistory.com/31
 
 
 
 */