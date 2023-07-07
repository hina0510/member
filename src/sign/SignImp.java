package sign;

import java.util.Scanner;
import add_user.*;

public class SignImp implements Sign{

	memberDAO dao;
	public SignImp() {
		dao = new memberDAO();
	}

	Scanner sc = new Scanner(System.in);
	int num;
	String modify;
	
	public int signIn() {

		System.out.println("===== 로그인 =====");
		System.out.print("ID : ");
		String id = sc.next();
		memberDTO dto = search(id);
		if(dto == null) {
			System.out.println("존재하지 않는 회원입니다. 다시 입력해주세요.");
			return 0;
		}else {
			System.out.print("Password :");
			String pwd = sc.next();
			if(dto.getPwd().equals(pwd)) {
				System.out.println("로그인되었습니다.");

				while(true) {
					System.out.println("-----------------------------------");
					System.out.println("(1).회원정보 확인\t(2).회원정보 수정\t");
					System.out.println("(3).회원 탈퇴\t(4).메인\t");
					System.out.print(">>> : ");
					num = sc.nextInt();
					switch(num) {
					case 1: 
						System.out.println("====================================== 회원정보 ========================================");
						System.out.println("아이디\t비밀번호\t이름\t이메일\t\t주소\t전화번호\t\t가입일\t");
						System.out.println("======================================================================================");
					
							System.out.print(dto.getId() + "\t");
							System.out.print(dto.getPwd() + "\t");
							System.out.print(dto.getName() + "\t");
							System.out.print(dto.getEmail() + "\t");
							System.out.print(dto.getAddr() + "\t");
							System.out.print(dto.getTel() + "\t");
							System.out.println(dto.getDate() + "\t");
							System.out.println("-------------------------------------------------------------------------------------");
						
						break;
					case 2: 
						modify(dto);
						System.out.println("수정이 완료되었습니다.");
						break;
					case 3: 
						System.out.println("정말 삭제하시겠습니까? yes or no");
						String sel = sc.next();
						if(sel.equals("yes")) {
							delete(dto);
						}else if(sel.equals("no")) {
							System.out.println("삭제를 취소하였습니다.");
							break;
						}else {
							System.out.println("제대로 입력해주세요.");
							break;
						}
						break;
					case 4: 
						return 1;
					default :
						System.out.println("메뉴의 번호에 맞게 입력해주세요.");
						break;
					}
				}
			}else {
				System.out.println("비밀번호가 틀립니다.");
				return 0;
			}
		}
	}

	public memberDTO search(String id) {
		memberDTO dto = dao.search(id);
		return dto;
	}
	
	public int modify(memberDTO d) {
		return dao.modify(d);
	}
	
	public int delete(memberDTO dto) {

		return dao.delete(dto);
	}

}
