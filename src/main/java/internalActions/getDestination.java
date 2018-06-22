// Internal action code for project project

package internalActions;

import initagent.stepStack;
import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class getDestination extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
    	try{
			
			return un.unifies(args[0],new StringTermImpl("katubedda"));
		}catch(Exception e){
			System.out.println(e);
			return un;
		}
    }
}
