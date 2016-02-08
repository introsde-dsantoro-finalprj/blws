package introsde.dsantoro.endpoint;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("ws/blws")
public class BlwsConfig extends ResourceConfig {
	public BlwsConfig () {
		packages("introsde.dsantoro.resources"); // Jersey will load all the resources under this package
	}
}

