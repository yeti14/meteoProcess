package cat.meteo.ws.client;

import org.junit.Test;


public class MeteoPiRestClientTest {
	
	@Test
	public void getSensorReading() {
		
		try {
		MeteoPiRestClient rsClient = new MeteoPiRestClient();
		rsClient.getSensorReading();
		
		
		
		} catch (Exception e) {
			
		}
		
	}
	

}
