import java.util.Scanner;
import java.util.Vector;

class Menus		//-- ������ ����
{
	public static final int E_PAY = 1;		//-- ��ü ���� 
	public static final int E_BACK = 2;		//-- �޴��� ���ư���
	public static final int E_DEL = 3;		//-- ��ٱ��� ����
	public static int sum = 0;				//-- ���� �ݾ�
}

class BasketandPay
{	
	// �ֿ� �Ӽ� ����
	private static final Vector<Object> vt1;		//-- �ڷᱸ��
	private static final Vector<Object> vt2;		//-- �ڷᱸ��
	private static Scanner sc;					//-- �Է� �� Ȱ��
	private static Integer sel;					//-- ���� ��
	
	static
	{
		// Vector �ڷᱸ�� ����
		vt1 = new Vector<Object>();
		vt2 = new Vector<Object>();

		// Scanner �ν��Ͻ� ����
		sc = new Scanner(System.in);
 
		// ����� �Է� �� �ʱ�ȭ
		sel = 0;
	}
	

	// �Ű������� ���� ���� ������ �ż��� �ڷᱸ���� ����


	// �޴� ���� �޼ҵ�
	public static void menuSelect() throws NumberFormatException
	{
		addElement();		// �켱 ��ٱ��Ͽ� �ְ� ����


		// ���ڿ� ����ó��
		try
		{
			do
			{
				System.out.print(">> �޴� ����(1-3) : ");
				sel = sc.nextInt();
			}
			while (sel < 1 || sel > 6);
			
		}
		catch (NumberFormatException e)	// ���� �̿ܿ���
		{
			System.out.println("1~3 ������ ���ڷ� �������ּ���");
		}
	}



	// ���õ� �޴� ���࿡ ���� ��� ȣ�� �޼ҵ�
	public static void menuRun() 
	{
		

		switch (sel)
		{
		case Menus.E_PAY: HowtoPay(); break;
		case Menus.E_BACK: BacktoMenu(); break;
		case Menus.E_DEL: delBasket(); break;		
		}
	}

	// ��ٱ��Ͽ� �ֱ�
	public static void addElement()
	{
		Register rg = new Register();			// ������ RegisterŬ���� �ν��Ͻ� ����

		int certificate = rg.printMenu();		// certificate ���� �޾ƿ���
		int su = rg.howMany();					// su �޾ƿ���

		vt1.add(certificate);		// ����
		vt2.add(su);				//
		
	}

	public static void HowtoPay() 
	{}
	public static void BacktoMenu() 
	{}
	public static void delBasket() 
	{}

}