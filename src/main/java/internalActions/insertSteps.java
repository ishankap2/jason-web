// Internal action code for project project

package internalActions;

import initagent.GoogleAPI;
import initagent.LocationStack;
import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class insertSteps extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        
    	GoogleAPI.source = LocationStack.pop();
    	System.out.println("Init Agent.. current Location : "+GoogleAPI.source);
    	
    	new GoogleAPI().GetDirections();

        // everything ok, so returns true
        return true;
    }
}
