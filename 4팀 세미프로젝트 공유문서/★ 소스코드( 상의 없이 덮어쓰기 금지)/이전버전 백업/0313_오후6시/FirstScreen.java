

import java.util.Calendar;
import java.util.Scanner;

// 2. �ʱ�ȭ�� Ŭ���� (����ȭ�� -> �޴� ���ñ���)

public class FirstScreen  
{	
	
	// �Է¹��� �� ���� ����
	public final String printerCode = "Canon001";	// printerCode : �����ͱ� �ڵ�
								
	

	void fsPrint()
	{
		//  ��¥, ����, �ð� ��ܿ� ��� 
		// Calendar ��ü ����
		Calendar cal = Calendar.getInstance();

		int y = cal.get(Calendar.YEAR);				// ����
		int m = cal.get(Calendar.MONTH);			// ��
		int d = cal.get(Calendar.DATE);				// ��
		int hh = cal.get(Calendar.HOUR_OF_DAY);		// ��
		int mm = cal.get(Calendar.MINUTE);			// ��
		int ss = cal.get(Calendar.SECOND);			// ��
		
		//System.out.println(y);
		System.out.println(y + "-" +m+ "-" +d+ "   " +hh+ "�� " + mm+ "�� " + ss+ "��");
		//--==>> 2023-2-9   14�� 42�� 33��	



        //  ���� ��� ���
		//System.out.printf("���� ����ִ� a4���� ���� : %d��\n", );

        // ---- enter --> ������ ���� ȭ��(�޴����� �޼ҵ�)���� �Ѿ��

	}

	void fsSelectMenu()  //  1. ���л� / 2. ������/ 3. ������  ����(�Է¹ޱ�)
	{	
		Scanner sc = new Scanner(System.in);

		
	   /*  �ν��Ͻ� ������ : 			
		 1. ���л� rg
		 2. ������ gr
		 3. ������ ad
	   */ 
		RegiStudent rg = new RegiStudent();
		GradStudent gr = new GradStudent();
		//AdminMenu ad = new AdminMenu();


		System.out.printf("�����л� �������� ������� �� �������ּ��� : ");
		int position = sc.nextInt();				// ������ ����

		switch (position)
		{
			// �����л�
			case 1: rg.login(); break;
			// ��������
			case 2: gr.login(); break;	
			// �������
			//case 3: ad.adLogin(); break;
		}
	}

}