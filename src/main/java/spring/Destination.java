package spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import initagent.GoogleAPI;
import jason.JasonException;
import jason.infra.centralised.RunCentralisedMAS;

@RestController
public class Destination extends RunCentralisedMAS{
	
	@RequestMapping(value="/destination", method = RequestMethod.GET)
	@ResponseBody
	public String getName(@RequestParam("destination") String dest) {
		
		GoogleAPI.destination = dest;
		
		this.init(new String[]{"project.mas2j"});  // get the mas2j file from the directory 
		try {
			this.create(); // create the mas2j project with all agents
			this.startAgs();
		} catch (JasonException e) {
			// TODO Auto-generated catch block\
			e.printStackTrace();
		}
        return "Dest: "+dest;

	}
}
