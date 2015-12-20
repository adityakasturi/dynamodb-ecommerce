import java.util.ArrayList;

public class DynamoDBTest {
	
	private DynamoDBConnect db = new DynamoDBConnect();

	public static void main(String[] args) {
		DynamoDBConnect db = new DynamoDBConnect();
		ArrayList<String> a =db.getAllItems("Id");
		
		
		
		System.out.println(a);
	}
	
	
	public String check(int a){
		return this.db.getItemJSON(a);
	}
	
}
