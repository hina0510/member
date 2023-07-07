package add_user;

import java.util.Scanner;
import sign.*;

public class mainClass01 {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	signUp sign = new signUpImpl();
	Sign s = new SignImp();
	int num, result =0;
	while(true) {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 주문");
		System.out.println("4. 관리자");
		System.out.print(">>>");
		num = input.nextInt();
		switch (num) {

		case 1:
			sign.display();
			break;
		case 2: 
			if(result == 1) {
				System.out.println("이미 로그인 중입니다.");
			}else {
				result = s.signIn();
			}break;
		case 3: break;
		case 4: break;
		}
	}
}
}
