// Internal action code for project project

package internalActions;

import javax.xml.transform.Source;

import initagent.GoogleAPI;
import initagent.LocationStack;
import initagent.PrologQuery;
import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class getSuggestion extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
    	
    	GoogleAPI.source = LocationStack.pop();
    	
    	try{
    		if(GoogleAPI.IsReached()) {
    			return un.unifies(args[0],new StringTermImpl("over"));
    		}
    		
    		String suggestion = new PrologQuery().getDetails();
    		System.out.println("Current Location of User "+GoogleAPI.source);
			return un.unifies(args[0],new StringTermImpl(suggestion));
		}catch(Exception e){
			System.out.println(e);
			return un;
		}
    }
}
