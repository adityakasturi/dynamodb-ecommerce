import java.io.*;
import java.util.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class parser {
	static HashMap<String,ArrayList<String>> reviews = new HashMap<String, ArrayList<String>>();
	static HashMap<String,String> business = new HashMap<String, String>();
	static HashMap<String,String> address = new HashMap<String, String>();
	static HashMap<String,ArrayList<Integer>> rating = new HashMap<String, ArrayList<Integer>>();


	public NewProductInfo getObjects(String Line){
		JSONParser parser = new JSONParser();
		ArrayList<String> items = new ArrayList<String>();
		System.out.println(Line);
		Object obj;
		NewProductInfo product=null;
		try {
			obj = parser.parse(Line);
			
			JSONObject jsonObject = (JSONObject) obj;
			String name = (String) jsonObject.get("Name");
			String price = (String) jsonObject.get("Price");
			items.add(name);
			items.add(price);
			product = new NewProductInfo();
			for(int i=0;i<jsonObject.size()-3;i++){
				String desc = (String) jsonObject.get(name+" desciption "+(i+1));
				items.add(desc);
				product.desc.add(desc);
			}
			product.setName(name);
			product.setPrice(price);
			System.out.println("Name= "+name);
			System.out.println("Price= "+price);
			
			



			System.out.println("\n\n");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return product;
	}
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {

			BufferedReader br = null, br2=null;

			br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/sandeepragila/Desktop/RIT studies/4th sem/Topics/yelp_dataset_challenge/revs/rev2.txt")));
			br2 = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/sandeepragila/Desktop/dbsi.txt")));
			ArrayList<String> temp ;
			ArrayList<Integer> temp2;

			String Line;
			while ((Line = br2.readLine()) != null) {
				System.out.println(Line);
				Object obj = parser.parse(Line);
				JSONObject jsonObject = (JSONObject) obj;
				String name = (String) jsonObject.get("Name");
				String price = (String) jsonObject.get("Price");
				String desc = (String) jsonObject.get(name+" desciption 1");
				System.out.println("Name= "+name);
				System.out.println("Price= "+price);
				System.out.println("Desc= "+desc);
				System.out.println("\n\n");
			}
			System.exit(1);


			br.close();
			br2.close();
			//	File logFile = new File("/Users/sandeepragila/Desktop/RIT studies/4th sem/Topics/output.txt");

			// This will output the full path where the file will be written to...

			//		writer = new BufferedWriter(new FileWriter(logFile));

			//	writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
