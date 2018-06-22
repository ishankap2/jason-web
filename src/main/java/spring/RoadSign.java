package spring;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roadsigns")
public class RoadSign {
	
	private String roadsign;

	public String getRoadsign() {
		return roadsign;
	}

	public void setRoadsign(String roadsign) {
		this.roadsign = roadsign;
	}
}
