//initial goal for taker

/* Plans */
!start.

+!start : true <- -over(all); -over(step); !getdestination.

+!getdestination <- internalActions.getDestination(D); +destination(D); .print("Destination is: ",D) !insertsteps.

+!insertsteps : true <- .print("Insert Steps"); internalActions.insertSteps(X); !execall.

+!execall: not over(all) <- .print("Get the step"); internalActions.getCurrentStep(X); if(X =="over" ){
																	+over(all)}!guidance(X).
+!execall: over(all) <- .print("Reached the destination"); -over(all).

+!execstep : not over(step) <- internalActions.getSuggestion(X); if(X =="over" ){
																	+over(step)
																}.wait(5000); !guidance(X).
																
+!execstep : over(step) <- .print("Reached one Destination");.wait(4000); -over(step); !execall.

+!guidance(X) <- .print("Suggestion ", X); .wait(5000); !execstep.