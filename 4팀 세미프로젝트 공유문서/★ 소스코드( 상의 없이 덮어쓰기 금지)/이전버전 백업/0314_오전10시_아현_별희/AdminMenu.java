 
// 4. �����ڿ� �޴� 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Map;
import java.util.Iterator;



public class AdminMenu		
{	
	// �Է� �ν��Ͻ� ����
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StList st = new StList();		// StList Ŭ����(�л� ���) ��� �ν��Ͻ� ���� 
		
	private String pw = "java002";  //������ pw
	
	// ���� ���� �� ���� ����
	private int cash100 = 50;
	private int cash500 = 50;
	private int cash1000 = 100;
	private int cash5000 = 50;
	private int cash10000 = 30;
	
	int paper = 3; //-->  *�ʱⰪ ����. �׽�Ʈ��!!


	//----------------------------------------------------------------------------

	// �� (������ �α���) ��й�ȣ �Է� �޼ҵ�			(�Ϸ�)
	void adLogin() 
	{	
		String tmp_pw = ""; // ����ڰ� �Է��ϴ� ��й�ȣ ��� �ӽ� ����
		int cnt = 0; // ��й�ȣ �߸� �Է��� Ƚ�� (3�� �Ǹ� �ʱ�ȭ������) 

		try
		{
			do
			{
				System.out.print("��й�ȣ�� �Է��ϼ���: ");
				tmp_pw = br.readLine();	

				if (!tmp_pw.equals(pw)) 
				{
				cnt ++;
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�! �ٽ� �Է��ϼ���.");
				}
				else
				{
					System.out.println("�α��� �Ǿ����ϴ�.\n");
					adSelect(); //---> ������ �޴����� �޼ҵ� ȣ��!
					break;
				}
			}
			while (cnt < 3);
			
		}
		catch (IOException e){}		
	} // -----> adLogin() 


    // �� ������ �޴� ���� �޼ҵ� (1~4)					(�Ϸ�)
	void adSelect() throws IOException
	{

		int i = 0; // ����� �Է°� ���� �ʱ�ȭ 

		System.out.println("==================[������ �޴�]==================");
		System.out.println(" �� ���� ��ȸ");			    // ���� (ī��/����/��ü )
		System.out.println(" �� ���� ��ȸ /���� ");			  // (������ ��ȸ �� ä���)
		System.out.println(" �� ���� ��� ��ȸ / ���� ");		 // (���ڶ�� ä���)	
		System.out.println(" �� �л� ���� ����");				//�л�����(�߰�,����,����)
		System.out.println(" �� ������ �޴� ������");         // �ʱ� ȭ������ �̵�    
		System.out.println(" �� ��� ����");				  // ���� ���� ���� 
		System.out.println("==================================================");
		System.out.print(">> �޴��� �����ϼ��� (���� �Է�) :");
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


	// ��  <1> ���� ��ȸ     ----> ���� Ŭ���� ���� ���� ���� ����
	void adIncome() 
	{	
		// 10��, 50��, 50000�� ��� ����
		System.out.println(" === �� ���� ��ȸ === ");	
		
		// ������ ���� : ī��, ����(������), ������ü�� ���� �ݾ�..	

	}


	// ��   <2> ���� ��ȸ / ���� 
	void adManage() //--> ���� ��ȸ �޼ҵ�
	{	
		//--> ��� ���� ���� �ʱ�ȭ�鿡�� �� �� �־���� (���� ����) 

		System.out.println(" \n=== �� ���� ��ȸ / ���� === ");	

		int n = 0 ; //����� �Է°� ���� ����
		try
		{
			System.out.print("1. ���� ��ȸ 2. ���� ���� (���ڷ� ����) : ");
			n = Integer.parseInt(br.readLine());
		}
		catch (IOException e){}
		
		if (n == 1) // 1. ���� ��ȸ
		{	
			System.out.println("-------------[1. ���� ��ȸ]--------------");
			System.out.println("=== �Ž����� ������ ���� === "); // ���߿� ���� Ŭ���� �����, �ش��ϴ� ���� - ���ֱ�.
			System.out.println("100��: " + cash100 + "�� = " + 100 * cash100 + "��");
			System.out.println("500��: " + cash500 + "�� = " + 500 * cash500 + "��");
			System.out.println("1000��: " + cash1000 + "�� = " + 1000 * cash1000 + "��");
			System.out.println("5000��: " + cash5000 + "�� = " + 5000 * cash5000 + "��");
			System.out.println("10000��: " + cash10000 + "�� = " + 10000 * cash10000 + "��");
		}
		else // 2. ���� ���� 
		{
			adCashFull();
		}
	}
    void adCashFull() //--> ���� ���� �޼ҵ� (�������� ä���)
	{
		int n = 0 ; // ����� �Է°� ����

		try
		{	System.out.println("-------------[2. ���� ����]--------------");
			System.out.println("1: 100�� ");
			System.out.println("2: 500�� ");
			System.out.println("3: 1000�� ");
			System.out.println("4: 5000�� ");
			System.out.println("5: 10000�� ");
			System.out.print("\n >> ä�� ������ �����ϼ���! (1 ~ 5) : ");

			n = Integer.parseInt(br.readLine());
		}
		catch (IOException e){}
		
		switch (n) //--> ������ ��ȣ�� �����ؼ� ���� �ʱⰪ���� ä���.
		{
			case 1: cash100 = 50; System.out.println("[ 100�� ��� 50���� ä�����ϴ�.]"); break;
			case 2: cash500 = 50; System.out.println("[ 500�� ��� 50���� ä�����ϴ�.]"); break;
			case 3: cash1000 = 100; System.out.println("[ 1000�� ��� 100���� ä�����ϴ�.]");break;
			case 4: cash5000 = 50; System.out.println("[ 5000�� ��� 50���� ä�����ϴ�.]"); break;
			case 5: cash10000 = 30; System.out.println("[ 10000�� ��� 30���� ä�����ϴ�.]");break;
		}
	}



	// �� <3> ���� ��� ��ȸ �� ���� --- (�Ϸ� ) //  ��� ä��� �� ���� ���� �ʿ�(���� �ʱⰪ + ä����) 

	void adPaper() //---> ���� ��� ��ȸ �޼ҵ�
	{		
		System.out.println(" \n=== �� ���� ��� ��ȸ / ���� === ");	
		
		int n = 0 ; //����� �Է°� ���� ����
		try
		{
			System.out.print("1. ��� ��ȸ 2. ��� ���� (���ڷ� ����) : ");
			n = Integer.parseInt(br.readLine());
		}
		catch (IOException e){}
		
		if (n == 1) // 1. ��� ��ȸ
		{  System.out.println("-------------[1. ��� ��ȸ]--------------");
		   System.out.println(">> ���� ���̴� " + paper + "�� �����ֽ��ϴ�.");
		}
		else // 2. ��� ���� 
		{
			adPpFull();
		}	

	}
	void adPpFull()	//---> ���� ��� ���� �޼ҵ�
	{		
		System.out.println("-------------[2. ��� ����]--------------");
		paper = 3;
		System.out.println("���̸� 3�� ä�����ϴ�.");
	}
	
	


	// �� �л� ���� ���� (1.��ȸ 2.�߰� 3.���� 4.����)
	void adStManage()
	{	
		
		System.out.println(" \n=== �� �л� ���� ���� === ");

		int n = 0; //����� �Է°� ���� ����
		int cnt = 0; //�Է� ���� Ƚ��. 3�Ǹ� ��
		
		try
		{
			do
			{
				System.out.print("1.��ȸ 2.�߰� 3.���� 4.���� (���ڷ� ����): ");
				n = Integer.parseInt(br.readLine());
			
				if (n==1)
				{
					System.out.println("\n===== 1.��ȸ ====="); 
					st.readList();
					adStManageBackMenu();
				}
				else if(n==2)
				{
					System.out.println("===== 2.�߰� ====="); 
					st.putNew();
					adStManageBackMenu();				
				}
				else if(n==3)
				{
					System.out.println("===== 3.���� =====");
					st.change(); 
					adStManageBackMenu();				
				}
				else if(n==4)
				{
					System.out.println("===== 4.���� =====");
					st.delete(); 
					adStManageBackMenu();				
				}
				else
				{
					System.out.println("1 ~4 ������ ���ڸ� �Է��ϼ���! ");
					cnt++;
				}
			}
			while (cnt<3);

			if(cnt==3)
			{
				System.out.println("3ȸ �Է� ������ �ʱ�ȭ������ ���ư��ϴ�...");	// ���߿� ���ο��� while�� ��� ���ư��Ŵϱ�...
			}
			
			/*
			switch (n)
			{
				case 1: System.out.println("\n===== 1.��ȸ ====="); 
				//System.out.println(st.map);				 // ���̵����� (���� x). 3)���� st.map �� ��������
				st.readList();
				adStManageBackMenu(); break;       
				
				case 2: System.out.println("===== 2.�߰� ====="); 
				st.putNew();
				adStManageBackMenu(); break;

				case 3: System.out.println("===== 3.���� =====");
				st.change(); 
				adStManageBackMenu(); break;
				
				case 4: System.out.println("===== 4.���� =====");
				st.delete(); 
				adStManageBackMenu(); break;		
			}
			*/
		}
		catch (IOException e){}
	}

	void adStManageBackMenu() throws IOException //--> �л� �����޴����� Ư�� �޴� ���� �� '���ư���' ����� �޼ҵ�
	{
		int n = 0;
		System.out.println("\n1. �л� ���� ������ ���ư��� 2. ������ �޴��� ���ư��� : ");
		n = Integer.parseInt(br.readLine());
		if (n==1)
			adStManage();
		else
			adSelect();

	}

	// �� ������ �޴� ������ (�ʱ� ȭ������) 
	void adExit()
	{
		System.out.println("�׽�Ʈ �޴� 4.");
	}
	
	// �� ��� ���� (���� ���� ����)
	void adClose()
	{
		System.out.println("�׽�Ʈ �޴� 5.");
	}


	public static void main(String[] args) // ���� �޼ҵ� 
	{	
		AdminMenu am = new AdminMenu();
		am.adLogin(); 
	}




	
}

/* �й�(key)�� ��� : Iterator ��� - keySet()
		
            Iterator<String> keys = st.stList().keySet().iterator();
            while (keys.hasNext()){
                String key = keys.next();

                System.out.println("KEY : " + key); // Key2 , Key1, Key4, Key3, Key5
            }
*/