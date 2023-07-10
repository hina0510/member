package mart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	public ArrayList<MartDTO> getList(String mid) {
		
		ArrayList<MartDTO> list = new ArrayList<>();
		
		String sql = "select * from mart where id = '" + mid+"'";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				MartDTO dto = new MartDTO();
				dto.setPro1(rs.getInt("pro1"));
				dto.setPro2(rs.getInt("pro2"));
				dto.setPro3(rs.getInt("pro3"));
				dto.setPro4(rs.getInt("pro4"));
				
				list.add(dto);
				return list;
			} 
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
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
	public int insert(String id, MartDTO dto) {
		
		int re = 0;
		String sql = "insert into mart values("+ id +", ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getPro1());
			ps.setInt(2, dto.getPro2());
			ps.setInt(3, dto.getPro3());
			ps.setInt(4, dto.getPro4());
			
			re = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
	
	
}
