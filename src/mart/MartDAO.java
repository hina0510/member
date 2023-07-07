package mart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import add_user.DBConnect;

public class MartDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public MartDAO() {
		con = DBConnect.getConnect();
	}
	
	public MartDTO getList(String id) {
		
		MartDTO dto = null;
		String sql = "select * from mart where id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				dto = new MartDTO();
				System.out.println(rs.getInt("id") +"님의 주문 내역" );
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
}
