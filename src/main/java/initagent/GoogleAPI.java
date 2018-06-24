package initagent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.*;
import java.lang.*;
import java.io.*;

import org.json.*;
import org.jsoup.*;

public class GoogleAPI {

	public static String source = LocationStack.pop();
	public static String destination;
	public static String tempEnd = "";
	public static double len;
	public static int increment;
	private final String USER_AGENT = "Mozilla/5.0";

	public String nameConvention(String name) {
		name = name.toLowerCase();
		name = name.replace(' ', '+');
		return name;
	}

	public void GetDirections() {

		List list = new ArrayList<JSONObject>();

		try {

			String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + source + "&destination="
					+ destination + "&mode=walking&key=AIzaSyDxbvgDoxTfJVxxSVzzjVbzB2NFrZS-i_k";

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();

			JSONObject jobj = new JSONObject(response.toString());
//			System.out.println(response.toString());
			JSONObject legs = jobj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0);
			JSONArray steps = legs.getJSONArray("steps");

			for (int i = 0; i < steps.length(); i++) {
				
				String step = steps.getJSONObject(i).get("html_instructions").toString();
				step = Jsoup.parse(step).text();
				
				JSONObject data = new JSONObject();
				data.put("step",step);
				data.put("end",steps.getJSONObject(i).get("end_location"));
				list.add(data);
			}
			
//			mongodb md = new mongodb();
//			md.insertSteps(list);
			
			stepStack.stepsList = list;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static String IsReached() {

		String [] s = source.split(",");
		String [] d = tempEnd.split(",");
		
		double lat1 = Double.parseDouble(s[0]);
		double lon1 = Double.parseDouble(s[1]);
		
		
		double lat2 = stepStack.endLat; 
		double lon2 = stepStack.endLng;
		
		final double R= 6371.16; // Radius of the earth 6.800149, 79.901062
		String isreached="ok";
		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters
//		
		if(len<distance) {
			increment++;
		}
		System.out.println(increment+" "+len+" "+distance);
		if(distance<10) {
			isreached = "reached";
		}
		else if(increment>5) {
			isreached = "wrong";
		}
		
		len = distance;
//		else {
//			isreached = "ok";
//		}
		return isreached;
	}

}
