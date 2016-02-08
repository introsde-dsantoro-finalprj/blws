package introsde.dsantoro.model;

import java.io.Serializable;

public class GoalEval implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer deltaCalories;
	private String evalMsg;
	private Integer percentTaken;
	
	
	public GoalEval() {
	}


	public Integer getDeltaCalories() {
		return deltaCalories;
	}


	public void setDeltaCalories(Integer deltaCalories) {
		this.deltaCalories = deltaCalories;
	}


	public String getEvalMsg() {
		return evalMsg;
	}


	public void setEvalMsg(String evalMsg) {
		this.evalMsg = evalMsg;
	}


	public Integer getPercentTaken() {
		return percentTaken;
	}


	public void setPercentTaken(Integer percentTaken) {
		this.percentTaken = percentTaken;
	}
}
