package mart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import add_user.DBConnect;
import add_user.memberDTO;

public class MartDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public MartDAO() {
		con = DBConnect.getConnect();
	}
	
	// 장바구니 목록
	public MartDTO getList(String id) {
		
		MartDTO dto = null;
		String sql = "select * from mart where id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				dto = new MartDTO();
				System.out.println(rs.getString("id") +"님의 주문 내역" );
				System.out.println("물 : " + rs.getInt("pro1"));
				System.out.println("휴지 :" + rs.getInt("pro2"));
				System.out.println("신발 : " + rs.getInt("pro3"));
				System.out.println("가방 : " + rs.getInt("pro4"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return dto;
	}

	// 장바구니 목록 삭제
	public int delete(String id) {
		int result = 0;
		
		String sql = "delete from mart where id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			result = ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 장바구니 담기
	public int insert(String id) {
		
		MartDTO dto = new MartDTO();
		int re = 0;
		
		String sql = "insert into mart values(?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, dto.getPro1());
			ps.setInt(3, dto.getPro2());
			ps.setInt(4, dto.getPro3());
			ps.setInt(5, dto.getPro4());
			
			re = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
	
	
}
