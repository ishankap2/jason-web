package initagent;

import java.util.ArrayList;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPSyntaxErrorException;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

public class PrologQuery {

	public String getDetails() {
		int number;
		String suggestion ="";
		JIPEngine jip = new JIPEngine();
		JIPTerm queryTerm = null;
		
		try {
			mongodb m = new mongodb();
			String [] data = m.getInputs();
			jip.consultFile("KB.pl");
			queryTerm = jip.getTermParser().parseTerm("status(" + data[0] + "," + data[1] + "," + data[2] + ",S)");

		} catch (JIPSyntaxErrorException ex) {
			
		} catch (Exception ex) {
		}
		JIPQuery jipQuery = jip.openSynchronousQuery(queryTerm);
		JIPTerm solution;
		
		
		// Loop while there is another solution
		while (jipQuery.hasMoreChoicePoints()) {
			solution = jipQuery.nextSolution();
			if (solution != null) {
				JIPVariable[] vars = solution.getVariables();
				
				number = Integer.parseInt(vars[0].toString());
				suggestion = vars[0].toString();
				
//				for(JIPVariable var: vars) {
//					if (!var.isAnonymous()) {
//						number = Integer.parseInt(var.toString());
//						suggestion = var.toString();
//					}
//				}
				
			} else {
				break;
			}

		}
		
		return suggestion;
	}
}
