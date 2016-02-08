package introsde.dsantoro.model;

import java.io.Serializable;
import java.util.Collection;

public class GoalCheck implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<Integer> calBurned;
	private Collection<Integer> calTaken;
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
}
