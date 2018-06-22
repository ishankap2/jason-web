package spring;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "obstacles")
public class Obstacle {
	
	private String obstacle;
	private String side;
	
	public String getObstacle() {
		return obstacle;
	}
	public void setObstacle(String obstacle) {
		this.obstacle = obstacle;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	
}