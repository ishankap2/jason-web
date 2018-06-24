// Internal action code for project project

package internalActions;

import java.util.ArrayList;

import initagent.GoogleAPI;
import initagent.mongodb;
import initagent.stepStack;
import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class getCurrentStep extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
    	
    	GoogleAPI.increment =0;
        // execute the internal action
    	String step = "over";
    	try{
			// represent string in jason using StringTermImpl
    		if(!stepStack.isEmpty()) {
    			step = stepStack.pop();	
    			mongodb m = new mongodb();
    			m.insertSuuggestion(step);
    		}
    		
			System.out.println("Curent step:"+step);
			
			return un.unifies(args[0],new StringTermImpl(step));
		}catch(Exception e){
			System.out.println(e);
			return un;
		}
    }
}
