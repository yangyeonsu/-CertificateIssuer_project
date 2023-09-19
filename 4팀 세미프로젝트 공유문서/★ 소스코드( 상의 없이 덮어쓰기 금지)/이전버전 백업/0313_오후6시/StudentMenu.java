import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


// 3. �л��� �޴� (�������̽�)

public interface StudentMenu        
{			
	// �α���
	void login();

	// �α��� �����ϴ� ������
	void loginConfirm();			

	// ���� �޴�â, ���ùް� �Ѿ
	int selectType();

	// �μ� �ż� �Է�
	int a4Num();	// �ż� ���� ����

	// ��ٱ��� ȣ�� ����
	String callBasket();
}



// ���� ��
class GraphicsDrawLineEx extends JFrame
{
    GraphicsDrawLineEx()
	{
        this.setTitle("drawLine ��� ����");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        this.add(panel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setSize(2000,1500);
        this.setVisible(true);
    }
    class MyPanel extends JPanel
	{
        public void paintComponent(Graphics g)
		{
            super.paintComponent(g);
            g.drawLine(100, 100, 100, 1000);
            g.drawLine(100, 1000, 1250, 1000);
            g.drawLine(1250, 1000, 1250, 100);
            g.drawLine(1250, 100, 100, 100);
        }
    }
}



// ���л� Ŭ����
class RegiStudent implements StudentMenu
{
	Scanner sc = new Scanner(System.in);

	String putHak, putPw;


	@Override
	public void login()
	{
		System.out.print("�й� : ");
		putHak = sc.next();					// �Է��ϴ� ���л� �й�
		System.out.print("��й�ȣ : ");
		putPw = sc.next();					// �Է��ϴ� ���л� ���
		loginConfirm();
	}
	
	// �α��� �����ϴ� ������
	@Override
	public void loginConfirm()
	{
		StList stl = new StList();
		
		// �й� �ҷ�����
		Iterator<String> keys = stl.stList().keySet().iterator();
		while (true)
		{			
			if(stl.stList().containsKey(putHak)  && putHak.substring(4).equals(putPw) == true )
			{
				System.out.println("�α��� ����");
				selectType();
				break;
			}
			
			else
			{
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				login();
			}
		}
		
	}


	@Override
	public int selectType()
	{
		int certType;					// ���� ����

		do
		{
			System.out.println("�߱��Ͻ� ������ �������ּ��� ���ϱݳ�������(1300��) �輺������(2100��) ����������(1800��) : ");	// ��������(3300��)
			certType = sc.nextInt();			
		}
		while (certType<1 || certType>3);
		

		if (certType == 1)
			tuitionPayment();				// ���ϱݳ�������
		else if(certType == 2)
			transcript();					// �輺������
		else 
			enrollment();					// ����������

		return certType;
	}
	
	@Override
	public int a4Num()					
	{
		int su;
		do
		{
			System.out.print("����Ͻ� �ż��� �Է����ּ���(1~5) : ");
			su = sc.nextInt();			// �ż� �� su
		}
		while (su<1 || su>5);

		return su;
	}

	@Override
	public String callBasket() 	// ��ٱ���
	{
		Scanner sc = new Scanner(System.in);
		String[] certi = {"��ϱݳ�������", "��������", "��������"};
		int suu = a4Num();
		int ct = selectType();
		System.out.printf("%s %d �Ÿ� ��ٱ��Ͽ� �����ðڽ��ϱ�?(Y/N) : ", certi[ct-1], suu);
		String con = sc.next();

		return con;
	}
	
	FirstScreen fs = new FirstScreen();

	// grid ���
	public void tuitionPayment()		// ���ϱݳ�������
	{
		fs.fsPrint();
		new GraphicsDrawLineEx();
		
	}
	public void transcript()			// �輺������
	{
		fs.fsPrint();
	}			
	public void enrollment()			// ����������
	{
		fs.fsPrint();
	}
}

// ������ Ŭ����
class GradStudent extends RegiStudent
{
	@Override
	public int selectType()
	{
		int certType;					// ���� ����
		do
		{
			System.out.println("�߱��Ͻ� ������ �������ּ��� �缺������(1800��) ����������(3300��) : ");	// ��������(3300��)
			certType = sc.nextInt();			
		}
		while (certType<1 || certType>3);
		

		if (certType == 1)
			transcript();				// �缺������
		else if(certType == 2)
			gradscript();				// ����������
		

		return certType;
	}




	public void gradscript()			// ����������
	{
		fs.fsPrint();
	}
}

