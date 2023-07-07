package add_user;

import java.util.ArrayList;
import java.util.Scanner;

public class memberService {
	memberDTO dto = new memberDTO();
	public void administrator(){

		while(true) {
			Scanner input = new Scanner(System.in);
			String id;
			String pwd;
			int num;
			System.out.println("아이디를 입력해 주세요");
			id = input.next();
			System.out.println("비밀번호를 입력해 주세요");
			pwd = input.next();
			if(id == dto.id && pwd == dto.pwd) {
				System.out.println("원하시는 내용을 선택해주세요");
				System.out.println("1.전체 회원 정보 보기");
				System.out.println("2.삭제");
				num = input.nextInt();
				switch(num) {
				case 1 : 
					ArrayList<memberDTO> list = getList();
					System.out.println("=== 회원 정보 ===");
					System.out.println("id\tname\temail\taddr\ttel\tdate");
					System.out.println("================");
					for(memberDTO d : list) {
						System.out.print( d.getId()+"\t" );
						System.out.print( d.getName()+"\t" );
						System.out.print( d.getEmail()+"\t" );
						System.out.print( d.getAddr()+"\t" );
						System.out.print( d.getTel()+"\t" );
						System.out.print( d.getDate()+"\t" );
						System.out.println("--------------");
						break;
					}
				case 2 : 
					break;
				case 3 : 
					System.out.println("나가기");return;
				}
			}else if(id != dto.id){
				System.out.println("id가 존재 하지않습니다");
				return;
			}else if(pwd != dto.pwd) {
				System.out.println("비밀번호가 맞지 않습니다");
				return;
			
			}


		}
	}
	
	ArrayList<memberDTO> getList() {
		ArrayList<memberDTO> list = null;
		//process
		return list;
	}
}
