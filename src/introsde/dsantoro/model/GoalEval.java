package introsde.dsantoro.model;

import java.io.Serializable;

public class GoalEval implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer caloriesTaken;
	private String evalMsg;
	private Double goalSatisfaction;
	
	
	public GoalEval() {
	}


	public Integer getCaloriesTaken() {
		return caloriesTaken;
	}


	public void setCaloriesTaken(Integer caloriesTaken) {
		this.caloriesTaken = caloriesTaken;
	}


	public String getEvalMsg() {
		return evalMsg;
	}


	public void setEvalMsg(String evalMsg) {
		this.evalMsg = evalMsg;
	}


	public Double getGoalSatisfaction() {
		return goalSatisfaction;
	}


	public void setGoalSatisfaction(Double goalSatisfaction) {
		this.goalSatisfaction = goalSatisfaction;
	}
}
