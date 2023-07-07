package add_user;


public interface signUp {
	public void display();
	public memberDTO search(String id);
	public int insert(String id, String pwd, String name, String email, String addr, String tel, String date);
}
