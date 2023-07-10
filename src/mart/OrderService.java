package mart;

import java.util.ArrayList;

public interface OrderService {
	public void main();
	public void display(String id);
	public ArrayList<MartDTO> getList(String id);
	public int delete(String id);
}
