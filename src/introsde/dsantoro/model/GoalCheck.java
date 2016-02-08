package introsde.dsantoro.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import javax.ws.rs.core.Link;

public class GoalCheck implements Serializable {
//	@InjectLink(resource=GoalCheckResource.class)
    //URI u;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<Integer> calBurned;
	private Collection<Integer> calTaken;	
	private Link link;
	
	public Link getLink() {
		return link;
	}

	public void setLink(Link link1) {
		this.link = link1;
	}

	public GoalCheck() {
	}

	private Integer todayGoal;
	
	public Collection<Integer> getCalBurned() {
		return calBurned;
	}

	public void setCalBurned(Collection<Integer> calBurned) {
		this.calBurned = calBurned;
	}

	public Collection<Integer> getCalTaken() {
		return calTaken;
	}

	public void setCalTaken(Collection<Integer> calTaken) {
		this.calTaken = calTaken;
	}

	public Integer getTodayGoal() {
		return todayGoal;
	}

	public void setTodayGoal(Integer todayGoal) {
		this.todayGoal = todayGoal;
	}

	public GoalEval evaluate() {
		GoalEval goalEval = new GoalEval();
		Integer sumBurned = 0;
		Integer sumTaken = 0;
				
		if (calBurned != null) {
			Iterator<Integer> i = calBurned.iterator();
			while(i.hasNext()){
				sumBurned += i.next();
			}
		}
		
		if (calTaken != null) {
			Iterator<Integer> i = calTaken.iterator();
			while(i.hasNext()){
				sumTaken += i.next();
			}
		}
		
		Integer deltaCalories = sumTaken - sumBurned;
		goalEval.setCaloriesTaken(deltaCalories);
		if (deltaCalories <= todayGoal) {
			goalEval.setEvalMsg("GOOD, You are below (or equal) your goal limit");
		}
		else {
			goalEval.setEvalMsg("BAD, You are above your goal limit");
		}
		Double g = new Double(todayGoal);
		Double d = 100/g;
		Double goalTot = Math.abs(deltaCalories) * d;
		if (goalTot <= 100) {
			goalEval.setGoalSatisfaction(100 - goalTot);	
		}
		else {
			goalEval.setGoalSatisfaction(goalTot*-1);
		}
		
		
		return goalEval;
	}
}
