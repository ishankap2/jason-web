package initagent;

import com.mongodb.MongoClient;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;



public class mongodb {

	public String [] getInputs() throws InterruptedException, JSONException {
		
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE); 

		String [] returnStr = new String [3];
		
		MongoClient mc = new MongoClient("localhost", 27017);
		
		MongoDatabase db = mc.getDatabase("googlesteps");
		
		MongoCollection<Document> collrdsign = db.getCollection("roadsigns");
		MongoCollection<Document> collobstacles = db.getCollection("obstacles");
		
		
		String ob = collobstacles.find().first().toJson();
		JSONObject obo = new JSONObject(ob);
		
		if (!obo.equals(null)) {
			returnStr[0] = (String) obo.get("obstacle");
			returnStr[1] = (String) obo.get("side");
		}
		
		String rd = collrdsign.find().first().toJson();
		JSONObject rdo = new JSONObject(rd);
		
		if (!rdo.equals(null)) {
			returnStr[2] = rdo.get("roadsign").toString();
		}
		
		mc.close();
		return returnStr;
	}
	
	public void insertObstacles(JSONObject job) throws InterruptedException {

		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("googlesteps");

		MongoCollection<Document> coll = db.getCollection("data");

		Document d = coll.findOneAndDelete(null);
		Document document = new org.bson.Document("obstacle",job);
		coll.insertOne(document);
		mc.close();
	}

}
