/**
 * Imported all the dependencies of the AMAZON WEB SERVICES
 * Which are used in Connecting to the Client
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

/**
 * This Class is used to Connect to the DynamoDb Server located on cloud and perform
 * the basic CRUD Operations
 *
 * @author adityakasturi
 */
public class DynamoDBConnect {


	/**
	 * Initialization  Which is used to Initialize
	 * The Environment Setup for the Client.
	 * Establishing Client Connection with the Credentials Configured.
	 */

    static AmazonDynamoDBClient client = new AmazonDynamoDBClient(
            new ProfileCredentialsProvider());
    static DynamoDB dynamoDB = new DynamoDB(client);

    /**
     * As the
     *
     */
    static String tableName = "ProductTable";

    public static void main(String[] args) throws Exception {

       // createUserTable();
        //listMyTables();
        //getTableInformation();
        //updateExampleTable();
        //createItems();
        //deleteUserTable();
    	//
    	//updateItem(33804, "Price", "$399");
    	getItem(11111);
    }
    
    
    ///////Put Item
    
    public void putItem(int id){
    	
    	
    	
    }
    
    ////////////////////// Delete Item
    
    public static void deleteItem(int id){
    	
    	Table table = dynamoDB.getTable(tableName);
    	System.out.println(" ID >"+id);
    	try {
            DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
            .withPrimaryKey("Id", id);
            DeleteItemOutcome outcome = table.deleteItem(deleteItemSpec);
            // Check the response.
        
            System.out.println("Printing item that was deleted...");
            
          //  System.out.println(outcome.getItem().toJSONPretty());
            
        } catch (Exception e) {
           
        	e.printStackTrace();
        	System.err.println("Error deleting item in " + tableName);
            
        	System.err.println(e.getMessage());
        	
        }
//    	DeleteItemRequest delete =  new DeleteItemRequest();
//    	String condition = "Id = "+Integer.toString(id);
//    	delete.withConditionExpression(condition).withTableName(tableName);
//    	
    }
    
    ////////////////////// get Item
    
    public static String getItem(int _id){
    	Table table = dynamoDB.getTable(tableName);

    	Item item = table.getItem("Id", _id);
    	
    	String price =  item.getString("Price");
    	String name =  item.getString("Name");
    	String id =  item.getString("Id");
    	System.out.println(id+" "+price+"   "+name);
    	String details = (id+" "+price+"   "+name);
    	
    	
    	return details;
    }
    
    /**
     * Return the JSON of the Object 
     * 
     * @param _id
     * @return
     */
    public static String getItemJSON(int _id){
    	
    	Table table = dynamoDB.getTable(tableName);
    	
    	Item item = table.getItem("Id", _id);	
    	
    	String price =  item.getString("Price");
    	String name =  item.getString("Name");
    	String id =  item.getString("Id");
    	
    	return item.toJSON();
    }
  
    
    /////////////////////////////////////////////////////////////////////// Get All Items
    
    /**
     * 
     * Returns all the Id's of the products which are loaded in the Table
     * 
     * @return
     */
    public static ArrayList<String> getAllItems(){
    	
    	
    	ArrayList<String> ids = new ArrayList<String>();
    	 
        ScanResult result = null;
     
        do{
            ScanRequest req = new ScanRequest();
            req.setTableName(tableName);
     
            if(result != null){
                req.setExclusiveStartKey(result.getLastEvaluatedKey());
            }
             
            result = client.scan(req);
     
            List<Map<String, AttributeValue>> rows = result.getItems();
     
            for(Map<String, AttributeValue> map : rows){
                try{
                    AttributeValue v = map.get("Id");
                    String id = v.getN();
                    ids.add(id);
                } catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                }
            }
        } while(result.getLastEvaluatedKey() != null);
         
       // System.out.println("Result size: " + ids.size());
        for (String string : ids) {
			System.out.println(string);
		}
        return ids;
    }
    

 ///////////////////////////////////////////////////////// Return Attribute Values
 
    
    
 public static ArrayList<String> getAllItems(String attr){
    	
    	
    	ArrayList<String> ids = new ArrayList<String>();
    	 
        ScanResult result = null;
     
        do{
            ScanRequest req = new ScanRequest();
            req.setTableName(tableName);
     
            if(result != null){
                req.setExclusiveStartKey(result.getLastEvaluatedKey());
            }
             
            result = client.scan(req);
     
            List<Map<String, AttributeValue>> rows = result.getItems();
     
            for(Map<String, AttributeValue> map : rows){
                try{
                    AttributeValue v = map.get(attr);
                    String id = null;
                    if(attr.equals("Id")){
                    	id = v.getN();
                    }else{
                    	id = v.getS();
                    }
                    ids.add(id);
                } catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                }
            }
        } while(result.getLastEvaluatedKey() != null);
         
       // System.out.println("Result size: " + ids.size());
//        for (String string : ids) {
//			System.out.println(string);
//		}
        return ids;
    }
    
    
    ///////////////////////////////////////////////////////////////////// Put Item
    /**
     * Method to put an Item in DynamoDB Database
     * 
     * @param attributes
     * @param values
     */
    public static void putItem(ArrayList<String> attributes,ArrayList<String> values){
    	PutItemRequest addItem = null;
    	PutItemResult putItemResult = null;

		Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
    	try{
    		if(attributes.size()==values.size()){
    			System.out.println("Creating A Record");
        		for (int i=0;i<values.size();i++) {
    				if(attributes.get(i).contains("Id")){
    					//System.out.println(" ID ->"+values.get(i)+"L "+values.get(i).length());
    					
    					item.put("Id", new AttributeValue().withN(values.get(i)));
    				}
    				else{
    					//System.out.println(" Attribute :> "+attributes.get(i)+" Value->  "+values.get(i));
        				item.put(attributes.get(i), new AttributeValue(values.get(i)));
        			}
    			}
        	}
    		addItem = new PutItemRequest(tableName, item);  	
    		putItemResult = client.putItem(addItem);
        	
    	}catch(Exception e){
    		 System.err.println("Create items failed.");
             System.err.println(e.getMessage());
    	}
    }
    
    ///////////////////////////////////////////////////////////////////// Put Item
    
    /**
     * 
     * 
     * @param id
     * @param attributeName
     * @param value
     */
    public static void updateItem(int id, String attributeName , String value){
    	
    	Table table = dynamoDB.getTable(tableName);

        try {

            // Specify the desired price (25.00) and also the condition (price =
            // 20.00)
        	
        	//String exp = ":"+attributeName+"= : "+value;
        	
        	String exp = ":"+attributeName;
        	
            UpdateItemSpec updateItemSpec = new UpdateItemSpec()
            .withPrimaryKey("Id", id)
            .withUpdateExpression("set #p = :val1")
            .withNameMap(new NameMap()
            		.with("#p", attributeName))
            .withValueMap(new ValueMap().withString(":val1", value));

            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);

            // Check the response.
           // System.out
            //.println("Printing item after conditional update to new attribute...");
        //    System.out.println(outcome.getItem().toJSONPretty());

        } catch (Exception e) {
            System.err.println("Error updating item in " + tableName);
            System.err.println(e.getMessage());
        }
    	
    }
    
    
    /**
     * 
     * put or Create items in the DynamoDB
     * 
     */
    private static void createItems() {

        Table table = dynamoDB.getTable(tableName);
        DataLoader loader = new DataLoader();
        System.out.println("Creating Items");
        ArrayList<Product> items =  loader.getProducts();
        try {
        	
        	PutItemRequest addItem = null;
        	PutItemResult putItemResult = null;
        	for (Product product : items) {
        		Map<String, AttributeValue> item = createItem(product);
        		addItem = new PutItemRequest(tableName, item);  	
        		putItemResult = client.putItem(addItem);
        		System.out.println("Item Created with ID: > " + product.getName());
			}
        
        } catch (Exception e) {
            System.err.println("Create items failed.");
            System.err.println(e.getMessage());

        }
    }

    
    private static Map<String, AttributeValue> createItem(Product p){
    	
    	Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
    	item.put("Id", new AttributeValue().withN(Integer.toString(p.getUniqueId())));
    	item.put("Name", new AttributeValue(p.getName()));
    	item.put("Price", new AttributeValue(p.getPrice()));
    	p.addDescription();
    	ArrayList<String> descriptionNames = p.getDescriptions();
    	ArrayList<String> descTitles = p.getDescriptionTitles();
    	
    	for(int i = 0; i < p.getDescCount();i++ ){
    		item.put(descriptionNames.get(i), new AttributeValue(descTitles.get(i)));
    	}
    	return item;
    }


	private static Map<String, AttributeValue> createNewItem(String uniqueid, String title, String cost, String description){
		Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
		item.put("uniqueId_Of_Product", new AttributeValue(uniqueid));
		item.put("title", new AttributeValue(title));
		item.put("quotedPrice", new AttributeValue(cost));
		item.put("stringDescription", new AttributeValue(description));
		return item;
	}

    /**
	 * Adding items to Cart.
	 *
	 * @return  userDetails
	 */
	private static Map<String, AttributeValue> addItemToCart(String username, String password, String _firstName,
			String _lastname, String id, String boughtItems) {
		Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
		item.put("userid", new AttributeValue(username));
		item.put("password", new AttributeValue(password));
		item.put("firstname", new AttributeValue(_firstName));
		item.put("lastname", new AttributeValue(_lastname));
		item.put("emailID", new AttributeValue(id));
		item.put("itemsPurchased", new AttributeValue(boughtItems));
		return item;
	}

    /**
     * This Method will create the Tables
     *
     */
    static void createUserTable() {

        try {

            ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
            attributeDefinitions.add(new AttributeDefinition()
                .withAttributeName("Id")
                .withAttributeType("N"));

            ArrayList<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
            keySchema.add(new KeySchemaElement()
                .withAttributeName("Id")
                .withKeyType(KeyType.HASH)); //Partition key

            CreateTableRequest request = new CreateTableRequest()
                .withTableName(tableName)
                .withKeySchema(keySchema)
                .withAttributeDefinitions(attributeDefinitions)
                .withProvisionedThroughput(new ProvisionedThroughput()
                    .withReadCapacityUnits(10L)
                    .withWriteCapacityUnits(10L));

            System.out.println("Issuing CreateTable request for " + tableName);
            Table table = dynamoDB.createTable(request);

            System.out.println("Waiting for " + tableName
                + " to be created...this may take a while...");
            table.waitForActive();

            getTableInformation();

        } catch (Exception e) {
            System.err.println("CreateTable request failed for " + tableName);
            System.err.println(e.getMessage());
        }

    }

    static void listMyTables() {

        TableCollection<ListTablesResult> tables = dynamoDB.listTables();
        Iterator<Table> iterator = tables.iterator();

        System.out.println("Listing table names");

        while (iterator.hasNext()) {
            Table table = iterator.next();
            System.out.println(table.getTableName());
        }
    }

    static void getTableInformation() {

        System.out.println("Describing " + tableName);

        TableDescription tableDescription = dynamoDB.getTable(tableName).describe();
        System.out.format("Name: %s:\n" + "Status: %s \n"
                + "Provisioned Throughput (read capacity units/sec): %d \n"
                + "Provisioned Throughput (write capacity units/sec): %d \n",
        tableDescription.getTableName(),
        tableDescription.getTableStatus(),
        tableDescription.getProvisionedThroughput().getReadCapacityUnits(),
        tableDescription.getProvisionedThroughput().getWriteCapacityUnits());
    }

    static void updateExampleTable() {

        Table table = dynamoDB.getTable(tableName);
        System.out.println("Modifying provisioned throughput for " + tableName);

        try {
            table.updateTable(new ProvisionedThroughput()
                .withReadCapacityUnits(6L).withWriteCapacityUnits(7L));

            table.waitForActive();
        } catch (Exception e) {
            System.err.println("UpdateTable request failed for " + tableName);
            System.err.println(e.getMessage());
        }
    }

    static void deleteUserTable() {

        Table table = dynamoDB.getTable(tableName);
        try {
            System.out.println("Issuing DeleteTable request for " + tableName);
            table.delete();

            System.out.println("Waiting for " + tableName
                + " to be deleted...this may take a while...");

            table.waitForDelete();
        } catch (Exception e) {
            System.err.println("DeleteTable request failed for " + tableName);
            System.err.println(e.getMessage());
        }
    }


    /**
     * Creates a NewUser in the UserTable
     *
     *
     * @param user_id
     * @param password
     * @param firstname
     * @param lastname
     * @param email_id
     * @return
     */
	public boolean registerUser(String user_id, String password, String firstname, String lastname, String email_id) {
			boolean check = true;
			try{
				Map<String, AttributeValue> item =
						newItem(user_id, password,firstname, lastname,email_id);
				PutItemRequest putItemRequest = new PutItemRequest(tableName, item);
				PutItemResult putItemResult = client.putItem(putItemRequest);
			}
			catch(Exception e ){
				check = false;
			}
//			System.out.println("register : " + flagRegister);
			return check;

		}


	private Map<String, AttributeValue> newItem(String user_id, String password, String firstname, String lastname,
			String email_id) {
		// TODO Auto-generated method stub
		return null;
	}



}
