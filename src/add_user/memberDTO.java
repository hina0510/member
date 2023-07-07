package add_user;

public class memberDTO {
	String id, pwd, name, email, addr, tel, date;
	public memberDTO(String id, String pwd, String name, String email, String addr, String tel, String date) {
		this.id = id; this.pwd = pwd; this.name = name; this.email = email; this.addr = addr;
		this.tel = tel; this.date = date;
	}
	public memberDTO() { }

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	public String getPwd() {return pwd;}
	public void setPwd(String pwd) {this.pwd = pwd;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	public String getAddr() {return addr;}
	public void setAddr(String addr) {this.addr = addr;}

	public String getTel() {return tel;}
	public void setTel(String tel) {this.tel = tel;}

	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;} 
}
