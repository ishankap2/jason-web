package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repository.RoadSignRepository;

@RestController
public class RoadSignController {
	
	@Autowired
	RoadSignRepository obstacleRepo;
	
	@RequestMapping("/insertrs")
	public void create(@RequestBody RoadSign rs) {
		obstacleRepo.save(rs);
	}

}
