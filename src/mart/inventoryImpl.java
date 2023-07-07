package mart;

import java.util.ArrayList;
import java.util.Scanner;

public class inventoryImpl implements inventory{
	
	MartDAO dao = new MartDAO();	
	MartDTO dto = new MartDTO();
	
	Scanner sc = new Scanner(System.in);
	int pro;
	int num;
	
	@Override
	public void display() {
		
		while(true) {
			System.out.println("=== MART ===");
			System.out.println("1. 물");
			System.out.println("2. 휴지");
			System.out.println("3. 신발");
			System.out.println("4. 가방");
			System.out.println("5. exit");
			System.out.println("주문하실 물품 >>> ");
			pro = sc.nextInt();
			if (pro == 5) 	return;
			
			System.out.println("개수 >> ");
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

	@Override
	public MartDTO getList(String id) {
		MartDTO dto = dao.getList(id);
		return dto;
	}
	
	

	
}
