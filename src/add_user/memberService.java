package add_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class memberService {
	memberDTO dto = new memberDTO();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	memberDAO dao = new memberDAO();
	
	public int administrator(){
		con = DBConnect.getConnect();
		
			Scanner input = new Scanner(System.in);
			String id;
			String pwd;
			int num;
			while(true) {
				System.out.println("원하시는 내용을 선택해주세요");
				System.out.println("1.전체 회원 정보 보기");
				System.out.println("2.삭제");
				System.out.println("3.나가기");
				System.out.println("4.로그아웃");
				num = input.nextInt();
				switch(num) {
				case 1 : 
					ArrayList<memberDTO> list = dao.getList();
					System.out.println("=========== 전체 회원 정보 =======================");
					System.out.println("id\tname\temail\t\taddr\ttel\tdate");
					System.out.println("===============================================");
					for(memberDTO d : list) {
						System.out.print( d.getId()+"\t" );
						System.out.print( d.getName()+"\t" );
						System.out.print( d.getEmail()+"\t" );
						System.out.print( d.getAddr()+"\t" );
						System.out.print( d.getTel()+"\t" );
						System.out.println( d.getDate()+"\t" );
						
						
					}break;
				case 2 :
					System.out.println("삭제 id 입력 :");
					id = input.next();
					int result = delete( id );
					
					if(result == 1) {
						System.out.println("삭제 성공!!!");
					}else {
						System.out.println("문제가 발생했습니다!!!");
					}
					
					break;
				case 3 : 
					return 2;
				case 4 :
					return 0;
					
				}
			}
		}		
	
	
	private int delete(String id) {
		int result = 0;
		String sql ="delete from memberlist where m_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1 , id );
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public ArrayList<memberDTO> getList() {
		ArrayList<memberDTO> list =  dao.getList();
		
		return list;
		
		
	}
}