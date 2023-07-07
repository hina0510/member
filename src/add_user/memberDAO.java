package add_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class memberDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
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
}
