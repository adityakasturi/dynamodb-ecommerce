import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * DataLoader.java
 * 
 * This file used to read the data from the csv files.
 * 
 * 
 * 
 * @author adityakasturi
 *
 */
public class DataLoader {

	private static final String DELIMITER = ",";

	private BufferedReader br = null;
	
	private ArrayList<String[]> items = new ArrayList<String[]>();
	
	String fileName = "/Users/adityakasturi/workspace/academic/dbsiproject/src/Abt.csv";
	
	private ArrayList<Product> products = new ArrayList<Product>();
	
	/**
	 * Reads the file from the Given folder and Stores the data
	 * 
	 * from the delimiters which ever are extracted in here.
	 * 
	 * 
	 * @param fileName
	 */

	public void readFile() {
		
		String currentLine = "";
		Product p = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while ((currentLine = br.readLine()) != null) {
				String[] words = currentLine.split(DELIMITER);
				items.add(words);
			}
		} catch (FileNotFoundException e) {
			System.out.println("" + "Error in reading the file " + "and File Not Found Exception in DataLoader Object");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void arrange(){
        ArrayList<String[]> items =  this.getItems();
		Product p = null;
        for (String[] strings : items) {
			if(strings[strings.length-1].contains("$") && (strings[strings.length -1].length() < 10)){
				int length = strings.length;
				p = new Product();
				p.setUniqueId(Integer.valueOf((strings[0])));
				p.setName(strings[1]);
				int descLen = (length - 3);
				p.setDescCount(descLen);
				for(int i = 2; i<(length-1);i++){
					p.addtitles(strings[i]);
				}
				p.setPrice(strings[length-1]);
				products.add(p);
				System.out.print(" Product desc count:> " + p.getDescCount());
				//System.out.print("   "+p.getDescriptionTitles());
				System.out.println(" Price "+p.getPrice());
			}
			
		}
	}
	
	
	public ArrayList<String[]> getItems() {
		readFile();
		return items;
	}

	public void setItems(ArrayList<String[]> items) {
		this.items = items;
	}


	
	

	public ArrayList<Product> getProducts() {
		arrange();
		return products;
	}




	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}	
}
