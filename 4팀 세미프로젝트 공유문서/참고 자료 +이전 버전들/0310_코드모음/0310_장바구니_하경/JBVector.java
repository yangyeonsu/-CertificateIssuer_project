import java.util.Vector;

class Loading
{
	private static int count;

	public static void loading()
	{
		System.out.print("������");
		count = 0;
		Timer t = new Timer();
		TimerTask tm = new TimerTask(){
				
				@Override
				public void run()
				{
					
					if(count<5)
					{
						System.out.print(".");
						count++;
					}
					else
					{
						//
						t.cancel();
					}
				}
			};
			
			t.schedule(tm, 1000, 1000);

	}
}


class JBandPay extends Loading
{
	int sum;			// ���� �ݾ� ������. 


	// UserŬ������ basket�޼ҵ忡�� �Ű����� �Ѱܹޱ�
	// ���� ������ �ż��� ��ٱ���(����)�� �ִ� �޼ҵ�
	void getCerti(int certificate, int su)		// ���� ��ȣ�� �ż�
	{
		// Vector(����) �ڷᱸ�� v ����
		Vector<Object> v1 = new Vector<Object>();
		Vector<Object> v2 = new Vector<Object>();

		// v1 ���� �ڷᱸ���� ������ȣ ���
		v1.add(certificate);		
		// v2 ���� �ڷᱸ���� ������ �ż� ���
		v2.add(su);		
		
		CalSum(certificate, su);
		
	}
	
	// �ݾ� ���
	void CalSum(int certificate, int su)
	{
		switch (certificate)
		{
		case 1: sum += 1300*su; break;
		case 2: sum += 2100*su; break;
		case 3: sum += 1800*su; break;		
		}
		
	}

	void Golla()
	{
		Register rg = new Register();
		Scanner sc = new Scanner(System.in);	

		System.out.print("1. ��ٱ��� ��ü ����\n2. �޴�â���� ���ư���\n3. ��ٱ��� ����");
		int g = sc.nextInt();

		switch (g)
		{
		case 1: TotPay(); break;
		case 2: rg.printMenu(); break;		// ������ ���� Ŭ������ �޼ҵ� ȣ��
		case 3: JBreset(); break;		
		}
		
	}

	void TotPay()		// ��ü ���� �޼ҵ�
	{
		Scanner sc = new Scanner(System.in);	

		System.out.print("1. ī�����\n2. ����\n3. ������ü");
		int p = sc.nextInt();

		switch (p)
		{
		case 1: Card(); break;
		case 2: Cash(); break;
		case 3: Transfer(); break;		
		}
	}

	// ī�� ���� �޼ҵ�
	void Card()
	{
		Random rd = new Random();
		int num;										// ī�� ���� ������ �����ϴ� ���� ���� �޴� ����
		System.out.println("������ �ݾ� " + sum);		// ������ �� �ݾ� ��� 
		System.out.println("ī�带 �������ּ���.");
		
		

		num = rd.nextInt(10);							// 0 ~ 9������ ���� ������ ���� 
		// System.out.println(num);

		if (num == 0) 
		{									// �� 0�� ������ 
			Loading.loading(3);							//  �ν� �Ұ�
			//System.out.println("ICĨ �ν��� �Ұ��մϴ�.\nī�带 �ܾ��ּ���.");		// ī�� �ν� ����
			
		}
		else
		{
			Loading.loading(1);		//���� �Ϸ�
		}
		
		
	}

	void Cash()
	{
		Scanner sc = new Scanner(System.in);
		int cash;

		System.out.println("������ �ݾ� " + sum);

		System.out.println("������ �����ϼ���");
		System.out.print("������ �ݾ� �Է� : ");
		cash = sc.nextInt();

		/*
		if (cash == sum)
		{
			Loading.loading();
		}
		else
			if (cash > sum)
			{
				
			}
			*/

		
	}
	
}





