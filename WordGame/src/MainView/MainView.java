package MainView;

import java.util.Scanner;

import DAO.DAO;

import DAO.Login;
import DAO.Resgister;

public class MainView {
	String msg;
	String userID;
	String userId, userPw, userName, userEmail;
	String fname, femail, fID, fpw, rpw;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Login log = new Login();
		Resgister reg = new Resgister();

		System.out.println("──────────────────────── * [ 단어 암기 게임 ] * ─────────────────────────\n");
		Thread.sleep(800);
		System.out.println("*        [Java]                *              [전등]        *            *\n");
		Thread.sleep(600);
		System.out.println("   *                  *                           *    [telephone]   *\n");
		Thread.sleep(600);
		System.out.println("       *    [전화기]              *          *             *            *\n");
		Thread.sleep(600);
		System.out.println("*                   *     [apple]                 *             *\n");
		Thread.sleep(600);
		System.out.println("        *                  *             *             [이클립스]    *\n");
		Thread.sleep(600);
		System.out.println("             *             [car]             *                         *\n");
		Thread.sleep(600);
		System.out.println("*              [자동차]                *         [책상]      *           *\n\n");
		Thread.sleep(600);
		while (true) {
			System.out.print("\n[1. 로그인]   [2. 회원가입]   [3. 게임플레이]		0[0. 종료] \n  >>> ");
			String menu = sc.next();
			switch (menu) {
			case "1":
				log.login();
				break;
			case "2":
				reg.resister();
				break;
			case "3":
				
				break;
				
			case "0":
				System.out.println("\n\n게임을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("\n번호를 다시 확인해주세요.");
			}
		}
	} // main view close
}
