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

		String [] returnStr = {"none","none","none"};
		
		MongoClient mc = new MongoClient("localhost", 27017);
		
		MongoDatabase db = mc.getDatabase("googlesteps");
		
		MongoCollection<Document> collrdsign = db.getCollection("roadsigns");
		MongoCollection<Document> collobstacles = db.getCollection("obstacles");
		
		if(collobstacles.count()!=0) {
			Document obd = collobstacles.findOneAndDelete(null);
			String ob = obd.toJson().toString();
			JSONObject obo = new JSONObject(ob);
			
			returnStr[0] = (String) obo.get("obstacle");
			returnStr[1] = (String) obo.get("side");	
		}
		
		if(collrdsign.count()!=0) {
			Document obr = collrdsign.findOneAndDelete(null);
			String ob = obr.toJson().toString();
			JSONObject rdo = new JSONObject(ob);
			returnStr[2] = rdo.get("roadsign").toString();	
		}
		
		mc.close();
		return returnStr;
	}
	
	public void insertSuuggestion(String sugesstion) throws InterruptedException {

		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("googlesteps");

		MongoCollection<Document> coll = db.getCollection("suggestions");

//		Document d = coll.findOneAndDelete(null);
		Document document = new org.bson.Document("suggestion",sugesstion);
		coll.insertOne(document);
		mc.close();
	}
	
	public String currentSuggestion() throws JSONException {
		
		String suggestion = "none";
		
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase db = mc.getDatabase("googlesteps");

		MongoCollection<Document> sug = db.getCollection("suggestions");

		if(sug.count()!=0) {
		Document d = sug.findOneAndDelete(null);
		suggestion = d.toJson().toString();
		}else {
		JSONObject job = new JSONObject();
		job.put("suggestion", "none");
		suggestion = job.toString();
		}
		mc.close();
		return suggestion;
	}

}
