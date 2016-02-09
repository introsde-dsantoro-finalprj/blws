package introsde.dsantoro.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Link;

import introsde.dsantoro.dbws.Meal;
import introsde.dsantoro.endpoint.BlwsPublisher;
import introsde.dsantoro.storagews.Storagews;

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
	private Integer todayGoal;

	public GoalCheck() {
	}

	public void setLink(Link link1) {
		this.link = link1;
	}

	public Link getLink() {
		return link;
	}

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
		
		
		// No list of burned taken provided
		if ( (todayGoal == 0) ){
			goalEval.setEvalMsg("Goal not provided, cannot evaluate results.");
			goalEval.setGoalSatisfaction(0D);
			return goalEval;
		}
		
		// 
		if (deltaCalories <= todayGoal) {
			goalEval.setEvalMsg("GOOD, You are below (or equal) your goal limit");
			setSuggestedMeals(goalEval);
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

	private void setSuggestedMeals(GoalEval goalEval) {
		Storagews storagews = BlwsPublisher.storagews;
		int start = (int) Math.round(Math.floor(Math.random()*60)+1);
		int seed = (int) Math.round(Math.floor(Math.random()*5)+1);
		if (seed == 1){
			List<Meal> suggestedMeals = storagews.searchMeals("orange juice", start, 3);
			goalEval.setMeals(suggestedMeals);
		}
		else if (seed == 2) {
			List<Meal> suggestedMeals = storagews.searchMeals("pasta", start, 3);
			goalEval.setMeals(suggestedMeals);
		}
		else if (seed == 3) {
			List<Meal> suggestedMeals = storagews.searchMeals("pizza", start, 3);
			goalEval.setMeals(suggestedMeals);
		}
		else if (seed == 4) {
			List<Meal> suggestedMeals = storagews.searchMeals("fish", start, 3);
			goalEval.setMeals(suggestedMeals);
		}
		else {
			List<Meal> suggestedMeals = storagews.searchMeals("soup", start, 3);
			goalEval.setMeals(suggestedMeals);
		}				
	}
}
