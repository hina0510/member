package mart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
				dto = new MartDTO(rs.getInt("id"),
									rs.getInt("pro1"),
									rs.getInt("pro2"),
									rs.getInt("pro3"),
									rs.getInt("pro4"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return dto;
	}
}
