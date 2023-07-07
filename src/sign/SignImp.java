package sign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
	
	/*  memberDAO에 넣을 내용
	 * 
	 * 	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	public memberDAO() {
		con = DBConnect.getConnect();
	}

	public memberDTO search(String id) {
		memberDTO dto = null;
		String sql = " select * from memberList where m_id ='"+ id + "' ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new memberDTO();
				dto.setId(rs.getString("m_id"));
				dto.setPwd(rs.getString("m_pwd"));
				dto.setName(rs.getString("m_name"));
				dto.setEmail(rs.getString("m_email"));
				dto.setAddr(rs.getString("m_addr"));
				dto.setTel(rs.getString("m_tel"));
				dto.setDate(rs.getString("m_date"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public int modify(memberDTO dto) {
		String sql;
		String modify;
		while(true) {
			System.out.println("====회원 수정 =====");
			System.out.println("1.비밀번호\n2.이름\n3.이메일\n4.주소\n5.전화번호\n6.종료");
			System.out.print(">>> :");
			int num = sc.nextInt();
			int result = 0;
			switch(num) {
			case 1: 
				sql = "update memberlist set m_pwd = ? where m_id = '"+ dto.getId() +"'";
				System.out.println("수정할 pwd 입력 : "); 
				modify = sc.next();
				dto.setPwd(modify);

				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, dto.getPwd());
					result = ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2: 
				sql = "update memberlist set m_name = ? where m_id = '"+ dto.getId() +"'";
				System.out.println("수정할 pwd 입력 : "); 
				modify = sc.next();
				dto.setName(modify);

				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, dto.getName());
					result = ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3: 
				sql = "update memberlist set m_email = ? where m_id = '"+ dto.getId() +"'";
				System.out.println("수정할 pwd 입력 : "); 
				modify = sc.next();
				dto.setEmail(modify);

				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, dto.getEmail());
					result = ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				sql = "update memberlist set m_addr = ? where m_id = '"+ dto.getId() +"'";
				System.out.println("수정할 pwd 입력 : "); 
				modify = sc.next();
				dto.setAddr(modify);

				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, dto.getAddr());
					result = ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5: 
				sql = "update memberlist set m_tel = ? where m_id = '"+ dto.getId() +"'";
				System.out.println("수정할 pwd 입력 : "); 
				modify = sc.next();
				dto.setTel(modify);

				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, dto.getTel());
					result = ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				return result;
			}
		}
	}
	
	public int delete(memberDTO dto) {
		int result = 0;
		String sql = "delete from memberlist where m_id = '"+ dto.getId() +"'";
		try {
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	-----------------------------------------------------------------
	MAIN에서 2번에 넣을 내용
	if(result == 1) {
				System.out.println("이미 로그인 중입니다.");
			}else {
				result = s.signIn();
			}
	 */


}
