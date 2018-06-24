package spring;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suggestions")
public class Suggestion {
	
	private String suggestion;

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

}
