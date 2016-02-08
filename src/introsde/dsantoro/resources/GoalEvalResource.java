package introsde.dsantoro.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import introsde.dsantoro.model.GoalCheck;
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
		public GoalCheck getGoalEval(@PathParam("goalCheckId") String goalCheckId) {
			// Get from in-memory db and return
			return null;
		}
		
		@GET		
		@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public List<GoalEval> getGoalEvals() {
			// Get list from in-memory db and return
			return null;
		}
	}

