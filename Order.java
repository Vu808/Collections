
public class Order {

	private String item;
	private String name;
	private int time;
	
	public Order(String item, String name, int time) {
		this.item = item;
		this.name = name;
	}
	
	public String item() {
		return item;
	}
	
	public String name() {
		return name;
	}
	
	public int time() {
		return time;
	}
}
