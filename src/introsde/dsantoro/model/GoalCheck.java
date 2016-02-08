package introsde.dsantoro.model;

import java.io.Serializable;
import java.net.URI;
import java.util.Collection;

import javax.ws.rs.core.Link;

//import org.glassfish.jersey.linking.InjectLink;

import introsde.dsantoro.resources.GoalCheckResource;

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
}
