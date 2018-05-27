package cat.meteo.ws.client;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import cat.meteo.domain.DadesMeteo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
 
/**
 * @author Crunchify
 * 
 */
 
public class MeteoPiRestClient {
 
	final static Logger logger = Logger.getLogger(MeteoPiRestClient.class);
	
	public DadesMeteo getSensorReading() throws ParseException {
		
		DadesMeteo dades = new DadesMeteo();
		
 
			Client client = Client.create();
			WebResource webResource = client.resource("http://192.168.1.132:5000/meteo-api");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			JSONObject json = new JSONObject(output);
			dades.setPressio((float)json.getDouble("pressure"));
			dades.setTemperatura((float)json.getDouble("temperature"));
			dades.setZona("S1");
			String timestamp = json.getString("timestamp");
			DateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.ENGLISH);
			Date date = format.parse(timestamp);
			dades.setData(date);
			
			logger.debug("MeteoPiRestClient getSensorReading(): "+dades.getTemperatura()+" "+dades.getPressio());
			
			
		
		
		
		return dades;
	
	}
	
}
