package introsde.dsantoro.dao;

import introsde.dsantoro.model.GoalCheck;
import introsde.dsantoro.model.GoalEval;

public class GoalStore {
	private GoalCheck goalCheck;
	private GoalEval goalEval;
	
	public GoalStore() {
		
	}
	
	public GoalStore(GoalCheck goalCheck, GoalEval goalEval) {
		this.goalCheck = goalCheck;
		this.goalEval = goalEval;
	}
	
	public GoalStore(GoalCheck goalCheck) {
		this.goalCheck = goalCheck;
	}
	
	public GoalStore(GoalEval goalEval) {
		this.goalEval = goalEval;
	}

	public GoalCheck getGoalCheck() {
		return goalCheck;
	}

	public void setGoalCheck(GoalCheck goalCheck) {
		this.goalCheck = goalCheck;
	}

	public GoalEval getGoalEval() {
		return goalEval;
	}

	public void setGoalEval(GoalEval goalEval) {
		this.goalEval = goalEval;
	}
}
