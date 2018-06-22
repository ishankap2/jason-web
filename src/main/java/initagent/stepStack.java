  package initagent;

import java.awt.JobAttributes;
import java.util.List;

import org.json.JSONObject;

public class stepStack {
	
	public static List stepsList;
	private int capacity = stepsList.size();
	private static int top = 0;
	public static String step;
	public static Double endLat;
	public static Double endLng;
	
	public static String pop() {
		JSONObject obj = (JSONObject) stepsList.get(top++);
//		
		try {
			step = obj.getString("step");
			JSONObject endObj = obj.getJSONObject("end"); 
			String lat = endObj.get("lat").toString();
			endLat = Double.parseDouble(lat);
			String lng = endObj.get("lng").toString();
			endLng = Double.parseDouble(lng);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return step;
	}

	public static JSONObject peek() {
		return (JSONObject) stepsList.get(top);
	}

	public static boolean isEmpty() {
		return (top == stepsList.size()- 1);
	}

}
