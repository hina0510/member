package mart;

import java.util.ArrayList;
import java.util.Scanner;

import add_user.memberDTO;
import add_user.signUpImpl;

public class OrderServiceImpl implements OrderService {
	
	memberDTO dto1 = new memberDTO();
	MartDTO dto = new MartDTO();
	
	MartDAO dao;
	public OrderServiceImpl() {
		dao = new MartDAO();
	}
	
	@Override
	public void main(String mid) {
	
		Scanner sc = new Scanner(System.in);
		int num;
		
		while (true) {
			System.out.println();
			System.out.println("1.주문 하기");
			System.out.println("2.주문 내역");
			System.out.println("3.주문 취소");
			System.out.println("4. main ");
			System.out.print(">>> ");
			num = sc.nextInt();
			switch (num) {
			case 1:
				display(mid);
				break;
			case 2:
				getList(mid);				
				break;
			case 3:
				ArrayList<MartDTO> list = new ArrayList<>();
				list = dao.getList(mid);
				if (list == null) {
					System.out.println(" ** 아무것도 담겨있지않습니다! **");
					break;
				}else {
					System.out.println("주문 취소하시겠습니까?");
					System.out.println("1.yes\t 2.no");
					int ans = sc.nextInt();
					if (ans == 1) {
						delete(mid);
						System.out.println("주문이 취소되었습니다");
						System.out.println("main으로 돌아갑니다..\n");
						return;
					}else {
						System.out.println("이전으로 돌아갑니다..");
						break;
					}
				}
			case 4:
				return;
			}
		}	
	}
		
	private int display(String id) {
		MartDTO dto = new MartDTO();
		Scanner sc = new Scanner(System.in);
		int pro, num;
		
		while(true) {
			System.out.println();
			System.out.println("=== MART ===");
			System.out.println("1. 물");
			System.out.println("2. 휴지");
			System.out.println("3. 신발");
			System.out.println("4. 가방");
			System.out.println("5. exit");
			System.out.print("주문하실 물품 >>> ");
			pro = sc.nextInt();
			
			if (pro == 5) {
				return dao.insert(id, dto);
			}
			
			System.out.print("개수 >> ");
			num = sc.nextInt();
			
			if (pro == 1) {
				System.out.println("물 : " +num);
				dto.setPro1(num);
			}
			if (pro == 2) {
				System.out.println("휴지 : " +num);
				dto.setPro2(num);
			}
			if (pro == 3) {
				System.out.println("신발 : " +num);
				dto.setPro3(num);
			}
			if (pro == 4) {
				System.out.println("가방 : " +num);
				dto.setPro4(num);
			}
			
		}
		
	}

	private void getList(String mid) {
		
		ArrayList<MartDTO> list = new ArrayList<>();
		list = dao.getList(mid);
		if (list == null) {
			System.out.println(" ** 아무것도 담겨있지않습니다! **");
		}else {
			System.out.println(mid + "님의 장바구니 목록");
			
			for (MartDTO li : list) {
				System.out.println("물 : " +li.getPro1());
				System.out.println("휴지 : " +li.getPro2());
				System.out.println("신발 : " +li.getPro3());
				System.out.println("가방 : " +li.getPro4());
			}
		}
	}

	private int delete(String mid) {
		int result = dao.delete(mid);
		return result;
	}
	
	
}
