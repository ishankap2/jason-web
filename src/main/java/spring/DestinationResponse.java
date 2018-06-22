package spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DestinationResponse {
	
	@RequestMapping(value="/destination", method = RequestMethod.GET)
	@ResponseBody
	public String getName() {
		
        return "";

	}

}
