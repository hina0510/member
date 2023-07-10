package add_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class memberDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	public memberDAO() {
		con = DBConnect.getConnect();
	}
	public int insert(memberDTO dto) {
		String sql = "insert into memberlist values(?, ?, ?, ?, ?, ?, sysdate)";
		
		int result=0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getAddr());
			ps.setString(6, dto.getTel());
			result = ps.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public memberDTO search(String id) {
		memberDTO dto = null;
		String sql = "select * from memberlist where m_id='"+id+"'";
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
		} catch (Exception e) {
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
	

}
