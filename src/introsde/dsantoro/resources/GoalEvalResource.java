package introsde.dsantoro.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import introsde.dsantoro.dao.GoalStore;
import introsde.dsantoro.dao.GoalStoreDao;
import introsde.dsantoro.model.GoalEval;

@Path("goaleval")
public class GoalEvalResource {
	
		// Allows to insert contextual objects into the class,
		// e.g. ServletContext, Request, Response, UriInfo
		@Context
		UriInfo uriInfo;
		@Context
		Request request;
		
		@GET
		@Path("{goalCheckId}")
		@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public GoalEval getGoalEval(@PathParam("goalCheckId") Long goalCheckId) {
			HashMap<Long, GoalStore> map = GoalStoreDao.INSTANCE.getDataProvider();
			GoalStore goalStore = map.get(goalCheckId);
			if (goalStore != null) {
				return goalStore.getGoalEval();
			}
			else {
				return null;
			}
		}
		
		@GET		
		@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public Collection<GoalEval> getGoalEvals() {
			HashMap<Long, GoalStore> map = GoalStoreDao.INSTANCE.getDataProvider();
			
			if (!map.isEmpty()) {
				ArrayList<GoalEval> goalEvalList = new ArrayList<GoalEval>();
				Iterator<GoalStore> i = map.values().iterator();
				while(i.hasNext()){
					goalEvalList.add(i.next().getGoalEval());
				}			
				return goalEvalList;
			}
			else {
				return null;
			}
		}
	}

