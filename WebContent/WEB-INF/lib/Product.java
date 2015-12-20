import java.util.ArrayList;

public class Product {
	
	private ArrayList<String> descriptions =  new ArrayList<String>();
	
	private ArrayList<String> descriptionTitles = new ArrayList<String>();
	
	private String price ;
	
	private String name;
	
	private Integer uniqueId;

	private int descCount;
	
	public void addDescription(){
		for (int i = 0; i < getDescCount(); i++) {
			String descript = name+" desciption "+String.valueOf(i+1);
			getDescriptions().add(descript);	
		}	
	}
	
	public void addtitles(String add){
		getDescriptionTitles().add(add);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(Integer uniqueId) {
		this.uniqueId = uniqueId;
	}

	public int getDescCount() {
		return descCount;
	}

	public void setDescCount(int descCount) {
		this.descCount = descCount;
	}

	public ArrayList<String> getDescriptionTitles() {
		return descriptionTitles;
	}

	public void setDescriptionTitles(ArrayList<String> descriptionTitles) {
		this.descriptionTitles = descriptionTitles;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public ArrayList<String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(ArrayList<String> descriptions) {
		this.descriptions = descriptions;
	}

}
