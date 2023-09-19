/*=================================
  ���� �÷���(Collection) ����
===================================*/

// Test164 Ŭ������ �ϼ��Ͽ�
// ���� ����� ���� ���α׷��� �����Ѵ�.

/*
���� ��)

	==[�޴� ����]==
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	===============
>> �޴� ����(1~6) : 1

1��° ��� �Է� : �翬��
1��° ��� �Է� ���� ~!!
��� �Է� ���(Y/N) : y

2��° ��� �Է� : ������
2��° ��� �Է� ���� ~!!
��� �Է� ���(Y/N) : n

	==[�޴� ����]==
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	===============
>> �޴� ����(1~6) : 2

[���� ��ü ���]
�翬��
������
���� ��ü ��� �Ϸ�~!!!

	==[�޴� ����]==
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	===============
>> �޴� ����(1~6) : 3

>> �˻��� ��� �Է� : ������

[�˻� ��� ���]
�׸��� �����մϴ�.

	==[�޴� ����]==
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	===============
>> �޴� ����(1~6) : 3

>> �˻��� ��� �Է� : �̱��

[�˻� ��� ���]
�׸��� �������� �ʽ��ϴ�.

	==[�޴� ����]==
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	===============
>> �޴� ����(1~6) : 4

>> ������ ��� �Է� : ���غ�

[���� ��� ���]
�׸��� �������� �ʾ� ������ �� �����ϴ�.

	==[�޴� ����]==
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	===============
>> �޴� ����(1~6) : 4

>> ������ ��� �Է� : �翬��

[���� ��� ���]
�翬�� �׸��� �����Ǿ����ϴ�.

	==[�޴� ����]==
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	===============
>> �޴� ����(1~6) : 5

>> ������ ��� �Է� : �ּ���

[���� ��� ���]
������ ����� �������� �ʽ��ϴ�.

	==[�޴� ����]==
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	===============
>> �޴� ����(1~6) : 5

>> ������ ��� �Է� : ������
>> ������ ���� �Է� : ���ֿ�

[���� ��� ���]
������ �Ϸ�Ǿ����ϴ�.

	==[�޴� ����]==
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	===============
>> �޴� ����(1~6) : 2

[���� ��ü ���]
���ֿ�
���� ��ü ��� �Ϸ� ~!!!

	==[�޴� ����]==
	1. ��� �߰�
	2. ��� ���
	3. ��� �˻�
	4. ��� ����
	5. ��� ����
	6. ����
	===============
>> �޴� ����(1~6) : 6

���α׷� ����~!!
����Ϸ��� �ƹ� Ű�� �������� . . .
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
	
class Menus		// �� �ϼ�
{
	public static final int E_ADD = 1;		//-- ��� �߰�
	public static final int E_DISP = 2;		//-- ��� ���
	public static final int E_FIND = 3;		//-- ��� �˻�
	public static final int E_DEL = 4;		//-- ��� ����
	public static final int E_CHA = 5;		//-- ��� ����
	public static final int E_EXIT = 6;		//-- ����
}

public class Test164
{
	// �ֿ� �Ӽ� ���� �� �ϼ�
	private static final Vector<Object> vt;	//-- �ڷᱸ��
	private static BufferedReader br;		//-- �Է� �� Ȱ��
	private static Integer sel;				//-- ���� ��
	private static String con;				//-- ��� ���� ����
	
	// static(����) �ʱ�ȭ ��
	static
	{	
		// Vector �ڷᱸ�� ����
		vt = new Vector<Object>();

		// BufferedReader �ν��Ͻ� ����
		br = new BufferedReader(new InputStreamReader(System.in));

		// ����� �Է°� �ʱ�ȭ
		sel = 1;
		con = "Y";
	}


	// �޴� ��� �޼ҵ�
	public static void menuDisp()
	{
		System.out.print("\n==[�޴� ����]==\n1. ��� �߰�\n2. ��� ���\n3. ��� �˻�\n4. ��� ����\n5. ��� ����\n6. ����\n===============\n");
	}

	// �޴� ���� �޼ҵ�
	public static void menuSelect() throws IOException, NumberFormatException
	{
		System.out.print(">> �޴� ����(1~6) : ");
		sel = Integer.parseInt(br.readLine());
		//menuRun();
	}


	// ���õ� �޴� ���࿡ ���� ��� ȣ�� �޼ҵ�
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


	// �ڷᱸ���� ��� �߰�(�Է�) �޼ҵ�
	public static void addElement() throws IOException
	{
		/*
		1��° ��� �Է� : �翬��
		1��° ��� �Է� ���� ~!!
		��� �Է� ���(Y/N) : y
		*/
		int n=1;
		do
		{
			System.out.printf("%d��° ��� �Է� : ", n);
			vt.add(br.readLine());
			System.out.printf("%d��° ��� �Է� ����~!!\n", n);
			System.out.print("��� �Է� ���(Y/N) : ");
			con = br.readLine();
			n++;
		}
		while (con.equals("y") || con.equals("Y"));
	}


	// �ڷᱸ�� ��ü ��� ��� �޼ҵ�
	public static void dispElement()
	{
		//Iterator<Object> it = vt.iterator;
		/*
		[���� ��ü ���]
		�翬��
		������
		���� ��ü ��� �Ϸ�~!!!
		*/
		System.out.println("[���� ��ü ���]");
		//System.out.println((String)it.next());
		for(Object obj : vt)
			System.out.println(obj);
	}

	// �ڷᱸ�� �� ��� �˻� �޼ҵ�
	public static void findElement() throws IOException
	{
		/*
		>> �˻��� ��� �Է� : ������

		[�˻� ��� ���]
		�׸��� �����մϴ�.
		*/
		System.out.print(">> �˻��� ��� �Է� : ");
		boolean b = vt.contains(br.readLine());
		System.out.println("\n[�˻� ��� ���]");
		if(b == true)
		{
			System.out.println("�׸��� �����մϴ�.");
		}
		else
			System.out.println("�׸��� �������� �ʽ��ϴ�.");
	}

	// �ڷᱸ�� �� ��� ���� �޼ҵ�
	public static void delElement() throws IOException
	{
		/*
		>> ������ ��� �Է� : �翬��

		[���� ��� ���]
		�翬�� �׸��� �����Ǿ����ϴ�.
		*/
		System.out.print(">> ������ ��� �Է� : ");
		String name = br.readLine();
		boolean b = vt.contains(name);
		if (b==true)
		{
			vt.remove(name);
			System.out.println("\n[���� ��� ���]");
			System.out.printf("%s �׸��� �����Ǿ����ϴ�.\n", name);
		}
		else
		{
			System.out.println("\n[���� ��� ���]");
			System.out.println("������ ����� �������� �ʽ��ϴ�.");
		}
		
	}

	// �ڷᱸ�� �� ��� ����(����) �޼ҵ�
	public static void chaElement() throws IOException
	{
		/*
		>> ������ ��� �Է� : �ּ���

		[���� ��� ���]
		������ ����� �������� �ʽ��ϴ�.

		>> ������ ��� �Է� : ������
		>> ������ ���� �Է� : ���ֿ�
		*/
		//vt.set(0,"");
		System.out.print(">> ������ ��� �Է� : ");
		String name = br.readLine();
		boolean b = vt.contains(name);
		if (b==true)
		{
			System.out.print(">> ������ ���� �Է� : ");
			String name2 = br.readLine();
			int i = vt.indexOf(name);
			vt.set(i,name2);
			System.out.println("\n[���� ��� ���]\n");
			System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
		}
		else
		{
			System.out.println("[���� ��� ���]\n");
			System.out.println("������ ����� �������� �ʽ��ϴ�.\n");
		}

	}

	// ���α׷� ���� �޼ҵ� �� �ϼ�
	public static void exit()
	{
		System.out.println("\n���α׷� ����~!!!");
		// return();			// �� �޼ҵ� ���� o, �ý������� x
		System.exit(-1);		// �ý����� ����Ǹ鼭 ��ȯ�� -1�� �ѱ��.(Ȯ�ο뵵)
	}

	// main() �޼ҵ� �� �ϼ�
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