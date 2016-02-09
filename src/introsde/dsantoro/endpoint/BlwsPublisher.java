package introsde.dsantoro.endpoint;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.net.InetAddress;
import java.net.MalformedURLException;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;

import introsde.dsantoro.storagews.Storagews;
import introsde.dsantoro.storagews.StoragewsService;


public class BlwsPublisher {
	public static Storagews storagews;
	public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
	{
		String PROTOCOL = "http://";
		String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
		if (HOSTNAME.equals("127.0.0.1"))
		{
			HOSTNAME = "localhost";
		}
		String PORT = "6906";
		String BASE_URL = "/ws/blws";

		if (String.valueOf(System.getenv("PORT")) != "null"){
			PORT=String.valueOf(System.getenv("PORT"));
		}

		System.out.println("Starting business logic Service...");

		// Check south-bound services
		storagews = getStoragewsHandle();

		if ( (storagews != null) ) {
				// Proceed with startup
				URI BASE_URI = new URI(PROTOCOL + HOSTNAME + ":" + PORT + BASE_URL);	        
				JdkHttpServerFactory.createHttpServer(BASE_URI, new BlwsConfig());
				System.out.println("--> Published. Check out "+BASE_URI);	
			}
			else {
				// Cannot start dependent services
				System.out.println("--> ERROR: Not published. Check out dependent services:");
				System.out.println("----> storagews: " + storagews);        	
			}
		}

		private static Storagews getStoragewsHandle() throws MalformedURLException {
			final String STORAGEWS_ENDPOINT = System.getenv("STORAGEWS_ENDPOINT");
			final String STORAGEWS_PORT = System.getenv("STORAGEWS_PORT");
			String storagewsURL = "http://"+STORAGEWS_ENDPOINT+":"+STORAGEWS_PORT+"/ws/storagews?wsdl";
			StoragewsService storagewsService = new StoragewsService(new URL(storagewsURL));		
			Storagews storagews = storagewsService.getStoragewsImplPort();
			System.out.println("Storagews config: Got a valid endpoint: " + storagewsURL);
			return storagews;		
		}
	}