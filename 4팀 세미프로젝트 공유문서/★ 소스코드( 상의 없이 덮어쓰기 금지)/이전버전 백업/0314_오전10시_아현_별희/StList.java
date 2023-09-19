
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class StList 
{
	Map<String, String> map = new HashMap<>();  //---> HashMap �ν��Ͻ� map ����
	Scanner sc = new Scanner(System.in);        //---> ��ĳ�� �ν��Ͻ� ����

	public void stList() // map�� ��ȯ�ϴ� �޼ҵ�, ������ �ְ� ���� ��.
	{	
		// map�̶�� HashMap �ڷᱸ���� ��� �߰� // put(k,v);
		map.put("20230125", "������");
		map.put("20230126", "�翬��");
		map.put("20230127", "���ϰ�");
		map.put("20230128", "�Ѿ���");

		//System.out.println(map);
		//return map;
	}
	
	public void readList() //--- > �л� ���� ��ȸ �޼ҵ�
	{
		System.out.println(map);
	}
 
	public void putNew()	//-- > �л� ���� �߰� �޼ҵ� (AdminMenu Ŭ�������� ȣ��)	(�ϼ�)
	{
		System.out.print(">> �߰��� �л��� �й��� �Է��ϼ��� : ");
		String hak = sc.next();
		System.out.print(">> �߰��� �л��� �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		map.put(hak, name);
		System.out.println("�л� ���� (" + hak +","+ name + ") �� �߰��Ǿ����ϴ�.");
		System.out.println(map);
	}
	
	public void change() //---> �л� ���� ���� �޼ҵ� (AdminMenu Ŭ�������� ȣ��)	(�ϼ�)
	{
		// containsValue() : �ش� ���� �ڷᱸ�� �ȿ� ������ true ��ȯ�ϴ� �޼ҵ�
		
		int cnt = 0;
		String name = "";                //--> ������ �л� ���� �̸�
		String newName = "";			 //--> �ٲ� �̸�

		do
		{	
			System.out.print(">> ������ �л��� �̸��� �Է��ϼ��� : ");
			name = sc.next();        

			if (map.containsValue(name))
			{
				System.out.print(">> ������ �̸��� �Է��ϼ��� : ");
				newName = sc.next();
				break;
			}
			else
			{
				System.out.println(">> �ش� �л��� �������� �ʽ��ϴ�.");
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
				//stList().replace(key, newName); //----> if�� ������ �Ǵµ� ���� ���� ���� �� �ǰ�����~~~~!!!!! 
				map.put(key, newName);
				System.out.printf("%s �л��� �̸��� %s(��)�� ����Ǿ����ϴ�.\n", name, newName);
				System.out.println("3. " + map);
				break;//���� ����
			}		
		}

	}//--> change()

	public void delete() //---> �л� ���� ���� �޼ҵ� (AdminMenu Ŭ�������� ȣ��)	(�ϼ�)
	{
		// remove()
		
		String temp = "";	// ������ �й� �ӽ� ����
		int cnt = 0;

		do
		{
			System.out.print(">> ������ �л��� �й��� �Է��ϼ��� : ");
			temp = sc.next();

			if (map.containsKey(temp))
			{	
				String tmp = map.get(temp); //  ���� ��� �л���
				map.remove(temp);
				System.out.printf("�л� ����( %s, %s) ���� �Ǿ����ϴ�.\n", temp,tmp);
				break;
			}
			else
			{
				System.out.println(">> �ش� �л��� �������� �ʽ��ϴ�.");
				cnt++;
			}
		}
		while (cnt<3);
		



		
	}

}
/* =========== ���������� ^_^ [ 3/8 �� - 172 ] ===============
	           ��� �÷���(Collection) ���	
  ---------------------------------------------------------
	�� Map �� ����...-->  HashMap Ŭ����.

HashMap<K,V> Ŭ����
: Hashtable Ŭ������ ���������� Map �������̽����� ��ӹ��� 
HashMap Ŭ������ ����� Hashtable�� ���������� 
Synchronization�� ��� ���ü� ������ ���ٸ�(��, ��Ƽ ������ ���α׷��� �ƴѰ��)
HashMap�� ����ϴ°� ���� ��� �����ϴ�
���� HashMap�� Hashtable�� �޸� null�� ����Ѵ�. 

Hashtable�� ���� ���������...
��Ƽ������ ������Ƽ. �� ����ȭ�� �����ִ� Hashtable�̴�~~ (����� �ϳ� �����ִ�~ ������ ����)

 =========================================================*/


 // �������� map =/= return ���� �޴� map�� �ٸ���. (�̸��� ����) 



 /*  entry�� Ȱ���ؼ� key, value�� ���� ������ ��� --> ��ó:   https://mommoo.tistory.com/50

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


 /* map �ڷᱸ���� ��ü ����ϴ� ��� --> ��ó: https://tychejin.tistory.com/31
 
 
 
 */