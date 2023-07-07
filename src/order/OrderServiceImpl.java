package order;

import java.util.Scanner;

import add_user.memberDAO;
import add_user.memberDTO;
import mart.MartDTO;
import mart.inventory;
import mart.inventoryImpl;

public class OrderServiceImpl implements OrderService {
	
	inventory inven = new inventoryImpl();
	memberDTO dto = new memberDTO();
	
	memberDAO dao;
	public OrderServiceImpl() {
		dao = new memberDAO();
	}
	
	@Override
	public void display() {
	
		Scanner sc = new Scanner(System.in);
		int num;
		
//		if (login == 0) {
//			System.out.println("로그인 후 이용해주세요");
//		}
		
		while (true) {
			System.out.println("1.주문 하기");
			System.out.println("2.주문 내역");
			System.out.println("3.주문 취소");
			System.out.println("4. main ");
			System.out.println(">>> ");
			num = sc.nextInt();
			switch (num) {
			case 1:
				inven.display();
				break;
			case 2: 
				System.out.println("님의 주문 내역");
				System.out.println("=====================");
				inven.getList();
				
				
				break;
			case 3:
				System.out.println("주문 취소하시겠습니까?");
				System.out.println("1.yes\t 2.no");
				int ans = sc.nextInt();
				if (ans == 1) {
					
					
					System.out.println("주문이 취소되었습니다");
					System.out.println("main으로 돌아갑니다..");
					return;
				}else {
					System.out.println("이전으로 돌아갑니다..");
					break;
				}
			case 4:
				return;
			}
		}	
	}
}
