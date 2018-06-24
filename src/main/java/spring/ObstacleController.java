package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repository.ObstacleRepository;

@RestController
public class ObstacleController {
	
	@Autowired
	ObstacleRepository obstacleRepo;
	
	@RequestMapping("/insertob")
	public void create(@RequestBody Obstacle ob) {
		System.out.println("Obstacle Received");
		obstacleRepo.save(ob);
	}
	
}


//@RequestMapping(value = "/insertob", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//public String InsertObstacle(@ModelAttribute Obstacle obstacle) throws JSONException {
//
//	Obstacle save = ObstacleRepository.save(obstacle);
//
//	System.out.println(obstacle);
//	if(obstacles.count()==0) {
//		JSONObject job = new JSONObject(obstacle);
//		Document document = new org.bson.Document(obstacle);
//		obstacles.insertOne(document);
//	}else {
//		String ob = obstacles.find().first().toJson();
//		JSONObject obo = new JSONObject(ob);
//		
//		String id =(String) obo.get("_id");
//		System.out.println(id);
//	}
//	
//	mc.close();
//	return "obstacle inserted";
