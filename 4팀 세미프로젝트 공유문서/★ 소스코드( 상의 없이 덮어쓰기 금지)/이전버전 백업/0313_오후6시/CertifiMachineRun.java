
// 1. 메인메소드 포함 (실제 호출할 클래스)

public class CertifiMachineRun
{
	public static void main(String[] args) // 메인 메소드 
	{
		// FirstScreen 클래스 기반 인스턴스 생성
		FirstScreen fs = new FirstScreen();

		fs.fsPrint();
		fs.fsSelectMenu();

		//RegiStudent rg = new RegiStudent();
		//rg.login();
		//rg.loginConfirm();

	}
}