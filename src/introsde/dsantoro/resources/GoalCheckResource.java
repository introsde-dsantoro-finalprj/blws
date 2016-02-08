package introsde.dsantoro.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import introsde.dsantoro.dao.GoalStore;
import introsde.dsantoro.dao.GoalStoreDao;
import introsde.dsantoro.model.GoalCheck;
import introsde.dsantoro.model.GoalEval; 

@Path("goalcheck")
public class GoalCheckResource {
	
	private final String BASE_URL = "/ws/blws";

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	@Context
	Response response;
	
	@GET
	@Path("{goalCheckId}")	
	@Produces({MediaType.APPLICATION_JSON})
	public GoalCheck getGoalCheck(@PathParam("goalCheckId") Long goalCheckId) throws URISyntaxException {
		
		HashMap<Long, GoalStore> map = GoalStoreDao.INSTANCE.getDataProvider();
		GoalStore goalStore = map.get(goalCheckId);
		if (goalStore != null) {
			return goalStore.getGoalCheck();
		}
		else {
			return null;			
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Collection<GoalCheck> getAllGoalCheck(@PathParam("goalCheckId") Long goalCheckId) throws URISyntaxException {
		
		HashMap<Long, GoalStore> map = GoalStoreDao.INSTANCE.getDataProvider();
			
		if (!map.isEmpty()) {
			ArrayList<GoalCheck> goalCheckList = new ArrayList<GoalCheck>();
			Iterator<GoalStore> i = map.values().iterator();
			while(i.hasNext()){
				goalCheckList.add(i.next().getGoalCheck());
			}			
			return goalCheckList;
		}
		else {
			return null;
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertGoalCheck(GoalCheck goalCheck) {		
		// Insert into in-memory DB the goalCheck, giving an ID, and calculate goalEval returning its link		
		Long goalId = new Date().getTime();
		GoalEval goalEval = goalCheck.evaluate();
		goalCheck.setLink(Link.fromUri(BASE_URL + "/goaleval/" + goalId)
				.rel("goaleval")
				.build());
		GoalStoreDao.INSTANCE.getDataProvider().put(goalId,new GoalStore(goalCheck, goalEval));
		URI createdUri = URI.create(BASE_URL + "/goalcheck/" + goalId);				  
		return Response.created(createdUri).build();
	}
}
