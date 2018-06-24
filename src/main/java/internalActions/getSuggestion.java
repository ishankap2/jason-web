// Internal action code for project project

package internalActions;

import javax.xml.transform.Source;

import initagent.GoogleAPI;
import initagent.LocationStack;
import initagent.PrologQuery;
import initagent.WrongLocationStack;
import initagent.mongodb;
import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class getSuggestion extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
    	
    	String suggestion;
//    	if(!WrongLocationStack.isEmpty()) {
//    		GoogleAPI.source = WrongLocationStack.pop();	
//    	}
    	
    	if(!LocationStack.isEmpty()) {
    		GoogleAPI.source = LocationStack.pop();	
    	}
    	
    	try{
    		suggestion = new PrologQuery().getDetails();
    		mongodb m = new mongodb();
    		
    		String isResched = GoogleAPI.IsReached();
    		
    		if(isResched=="reached") {
    			suggestion = "reached";
    			return un.unifies(args[0],new StringTermImpl("over"));
    		}
    		else if(isResched=="wrong") {
    			suggestion="wrong path";
    			return un.unifies(args[0],new StringTermImpl("wrong path"));
    		}
    		
    		
    		m.insertSuuggestion(suggestion);
    		
    		System.out.println("Current Location of User "+GoogleAPI.source);
			return un.unifies(args[0],new StringTermImpl(suggestion));
		}catch(Exception e){
			System.out.println(e);
			return un;
		}
    }
}
