package initagent;
// Environment code for project testenv

import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;

public class AgentEnv extends Environment {
	
	String destination = "6.795497,79.899331";

    private Logger logger = Logger.getLogger("project.mas2j."+AgentEnv.class.getName());

    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {  
//    	GoogleAPI.source = LocationStack.pop();
//    	System.out.println("Init Agent.. current Location : "+GoogleAPI.source);
//    	
//    	new GoogleAPI().GetDirections(destination);
//    	addPercept(Literal.parseLiteral("source("+GoogleAPI.source+")."));
//    	addPercept(Literal.parseLiteral("destination("+ new StringTermImpl(destination)+")."));
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
      if (action.getFunctor().equals("burn")) {
        addPercept(Literal.parseLiteral("fire"));
        return true;
      } else {
        logger.info("executing: "+action+", but not implemented!");
        return false;
      }
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
      super.stop();
    }
}
