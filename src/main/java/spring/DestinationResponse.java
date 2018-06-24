package spring;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import initagent.mongodb;
import repository.SuggestionRepository;

@RestController
public class DestinationResponse {
	
	@Autowired
	SuggestionRepository suggestionRepo;
	
	@RequestMapping(value="/suggestion", method = RequestMethod.GET)
	@ResponseBody
	public String getName() throws JSONException {
		mongodb m = new mongodb();
		String suggestion = m.currentSuggestion();
        return suggestion;
	}

}
