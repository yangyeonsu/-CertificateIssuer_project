import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


// 3. 학생용 메뉴 (인터페이스)

public interface StudentMenu        
{			
	// 로그인
	void login();

	// 로그인 인증하는 페이지
	void loginConfirm();			

	// 증명서 메뉴창, 선택받고 넘어가
	int selectType();

	// 인쇄 매수 입력
	int a4Num();	// 매수 변수 리턴

	// 장바구니 호출 유무
	String callBasket();
}



// 증명서 폼
class GraphicsDrawLineEx extends JFrame
{
    GraphicsDrawLineEx()
	{
        this.setTitle("drawLine 사용 예제");
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



// 재학생 클래스
class RegiStudent implements StudentMenu
{
	Scanner sc = new Scanner(System.in);

	String putHak, putPw;


	@Override
	public void login()
	{
		System.out.print("학번 : ");
		putHak = sc.next();					// 입력하는 재학생 학번
		System.out.print("비밀번호 : ");
		putPw = sc.next();					// 입력하는 재학생 비번
		loginConfirm();
	}
	
	// 로그인 인증하는 페이지
	@Override
	public void loginConfirm()
	{
		StList stl = new StList();
		
		// 학번 불러오기
		Iterator<String> keys = stl.stList().keySet().iterator();
		while (true)
		{			
			if(stl.stList().containsKey(putHak)  && putHak.substring(4).equals(putPw) == true )
			{
				System.out.println("로그인 성공");
				selectType();
				break;
			}
			
			else
			{
				System.out.println("잘못입력하셨습니다.");
				login();
			}
		}
		
	}


	@Override
	public int selectType()
	{
		int certType;					// 증명서 종류

		do
		{
			System.out.println("발급하실 증명서를 선택해주세요 ①등록금납입증명서(1300￦) ②성적증명서(2100￦) ③재학증명서(1800￦) : ");	// 졸업증명서(3300￦)
			certType = sc.nextInt();			
		}
		while (certType<1 || certType>3);
		

		if (certType == 1)
			tuitionPayment();				// ①등록금납입증명서
		else if(certType == 2)
			transcript();					// ②성적증명서
		else 
			enrollment();					// ③재학증명서

		return certType;
	}
	
	@Override
	public int a4Num()					
	{
		int su;
		do
		{
			System.out.print("출력하실 매수를 입력해주세요(1~5) : ");
			su = sc.nextInt();			// 매수 → su
		}
		while (su<1 || su>5);

		return su;
	}

	@Override
	public String callBasket() 	// 장바구니
	{
		Scanner sc = new Scanner(System.in);
		String[] certi = {"등록금납입증명서", "성적증명서", "재학증명서"};
		int suu = a4Num();
		int ct = selectType();
		System.out.printf("%s %d 매를 장바구니에 담으시겠습니까?(Y/N) : ", certi[ct-1], suu);
		String con = sc.next();

		return con;
	}
	
	FirstScreen fs = new FirstScreen();

	// grid 사용
	public void tuitionPayment()		// ①등록금납입증명서
	{
		fs.fsPrint();
		new GraphicsDrawLineEx();
		
	}
	public void transcript()			// ②성적증명서
	{
		fs.fsPrint();
	}			
	public void enrollment()			// ③재학증명서
	{
		fs.fsPrint();
	}
}

// 졸업생 클래스
class GradStudent extends RegiStudent
{
	@Override
	public int selectType()
	{
		int certType;					// 증명서 종류
		do
		{
			System.out.println("발급하실 증명서를 선택해주세요 ①성적증명서(1800￦) ②졸업증명서(3300￦) : ");	// 졸업증명서(3300￦)
			certType = sc.nextInt();			
		}
		while (certType<1 || certType>3);
		

		if (certType == 1)
			transcript();				// ①성적증명서
		else if(certType == 2)
			gradscript();				// ②졸업증명서
		

		return certType;
	}




	public void gradscript()			// ②졸업증명서
	{
		fs.fsPrint();
	}
}

