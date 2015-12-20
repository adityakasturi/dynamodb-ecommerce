
public class ProductInfo {
   String quantity="";
   String item="";
   String desc="";
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public ProductInfo(String quantity, String item, String desc) {
	super();
	this.quantity = quantity;
	this.item = item;
	this.desc = desc;
}
}
