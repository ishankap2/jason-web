package initagent;

import org.json.JSONObject;

import com.mongodb.util.JSON;

import jason.stdlib.foreach;

public class TestMain {

	public static void main(String[] args) {
//		PrologQuery pq = new PrologQuery();
//		System.out.println(pq.getDetails());
//		String res = new QuoteClient().getCurrentLocation();
//    	System.out.println(pq.getDetails());
		
//		GoogleAPI g = new GoogleAPI();
//		g.source = LocationStack.pop();6.795619, 79.898238 // 6.795603, 79.898325
//		g.GetDirections("Katubadda");
//		Boolean b = g.IsReached(6.795603,6.795619,79.898325,79.898238);
//		System.out.println("");
//		g.GetDistance();
		
//		try {
//			mongodb m = new mongodb();
//			String [] data = m.getInputs();
//			System.out.println(data[0]+" "+data[1]+" "+data[2]);
////			System.out.println(m.currentSuggestion());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		String location = new QuoteClient().getCurrentLocation();
		System.out.println(location);
    	
	}
}

