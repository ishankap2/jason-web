// Internal action code for project project

package internalActions;

import java.util.ArrayList;

import initagent.GoogleAPI;
import initagent.stepStack;
import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class getCurrentStep extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        // execute the internal action
    	try{
			// represent string in jason using StringTermImpl
    		String data = stepStack.pop();
			System.out.println("Curent step:"+data);
			return un.unifies(args[0],new StringTermImpl(data));
		}catch(Exception e){
			System.out.println(e);
			return un;
		}
    }
}
