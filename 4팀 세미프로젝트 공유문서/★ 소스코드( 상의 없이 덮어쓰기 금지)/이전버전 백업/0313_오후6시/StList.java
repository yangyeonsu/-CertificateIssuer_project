
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class StList 
{
	Map<String, String> map = new HashMap<>();  //---> HashMap �ν��Ͻ� ����
	Scanner sc = new Scanner(System.in);        //---> ��ĳ�� �ν��Ͻ� ����

	public Map<String, String> stList() // �������� map =/= return ���� �޴� map�� �ٸ���. (�̸��� ����) 
	{	
		// map�̶�� HashMap �ڷᱸ���� ��� �߰� // put(k,v);
		map.put("20230125", "������");
		map.put("20230126", "�翬��");
		map.put("20230127", "���ϰ�");
		map.put("20230128", "�Ѿ���");

		//System.out.println(map);
		return map;
		
	}
 
	public void putNew()	//-- > �л� ���� �߰� �޼ҵ� (AdminMenu Ŭ�������� ȣ��)	
	{
		System.out.print(">> �߰��� �л��� �й��� �Է��ϼ��� : ");
		String hak = sc.next();
		System.out.print(">> �߰��� �л��� �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		stList().put(hak, name);
		System.out.println("�л� ���� (" + hak +","+ name + ") �� �߰��Ǿ����ϴ�.");
		//System.out.println(stList());
	}
	
	public void change() //---> �л� ���� ���� �޼ҵ� (AdminMenu Ŭ�������� ȣ��)	
	{
		// containsValue() : �ش� ���� �ڷᱸ�� �ȿ� ������ true ��ȯ�ϴ� �޼ҵ�
		
		System.out.print(">> ������ �л��� �̸��� �Է��ϼ��� : ");
		String name = sc.next();         //--> ������ �л� ���� �̸�
		String newName = "";			 //--> �ٲ� �̸�

		boolean isExist = stList().containsValue(name) ; // �⺻�� true.
		int cnt = 0;

		while (cnt < 3)
		{
			if (isExist)		// �л��̸��� �ڷᱸ���� �����ϸ�
			{
				System.out.print(">> ������ �̸��� �Է��ϼ��� : ");
				newName = sc.next();

				// ������ �̸��� key �� ���ϱ�
				Iterator<String> keys = stList().keySet().iterator();
				while (keys.hasNext())
				{
					String key = keys.next(); 
					System.out.println("1. " + key);

					if (stList().get(key).equals(name))
					{	
						String newKey = key;
						System.out.println("2. " + stList().get(key));
						stList().replace(newKey, newName); //----> if�� ������ �Ǵµ� ���� ���� ���� �� �ǰ�����~~~~!!!!! 
						//stList().put(key, newName);
						
					}
					else
						continue;		
				}
				System.out.printf("%s �л��� �̸��� %s�� ����Ǿ����ϴ�.\n", name, newName);
				System.out.println("3. " + stList());
				break;//���� ����
			}
			else				// �л��̸��� �ڷᱸ���� �������� ������
			{
				System.out.print(">> �ش� �л��� �������� �ʽ��ϴ�.");
				cnt++;
			}		
		}//---> ������ �̸� �Է¹޴� ����
		


		
		

	}//--> change()

	public void delete() //---> �л� ���� ���� �޼ҵ� (AdminMenu Ŭ�������� ȣ��)	
	{
		// remove()
		
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