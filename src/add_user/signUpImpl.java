package add_user;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class signUpImpl implements signUp{
	SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월 dd일");
	memberDAO dao;
	public signUpImpl() {
		dao = new memberDAO();
	}
	public void display() {
		Scanner input = new Scanner(System.in);
		String id, pwd, name, email, addr, tel, date;
		
		while(true) {
			System.out.println("ID 중복 확인 : ");
			id = input.next();
			memberDTO d = search(id);
			if (d==null) {
				break;
			}
			System.out.println("존재하는 id 입니다");
		}
		System.out.println("ID : ");
		id = input.next();
		System.out.println("PW : ");
		pwd = input.next();
		System.out.println("NAME : ");
		name = input.next();
		System.out.println("E-Mail : ");
		email = input.next();
		System.out.println("Addr : ");
		addr = input.next();
		System.out.println("TEL : ");
		tel = input.next();
		
		long time = System.currentTimeMillis();
		date = (String)simple.format(time);
		
		int re = insert(id, pwd, name, email, addr, tel, date);
		if(re==1) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("문제가 발생했습니다");
		}
	}
	public memberDTO search(String id) {
		memberDTO dto = dao.search(id);
		return dto;
	}
	
	public int insert(String id, String pwd, String name, String email, String addr, String tel, String date) {
		memberDTO dto = new memberDTO(id, pwd, name, email, addr, tel, date);
		
		return dao.insert(dto);
	}
}
