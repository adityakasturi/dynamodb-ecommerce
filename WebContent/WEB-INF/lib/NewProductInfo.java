import java.util.ArrayList;

public class NewProductInfo {
	String id;
	String Price;
	String Name;
	ArrayList<String> desc;
	public NewProductInfo(){
		desc = new ArrayList<String>();
	}
	
	public NewProductInfo(String id, String price, String name, ArrayList<String> desc) {
		super();
		this.id = id;
		Price = price;
		Name = name;
		this.desc = desc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ArrayList<String> getDesc() {
		return desc;
	}
	public void setDesc(ArrayList<String> desc) {
		this.desc = desc;
	}
	
	

}
