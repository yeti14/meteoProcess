package cat.meteo.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.meteo.domain.DadesMeteo;
import cat.meteo.ws.client.MeteoPiRestClient;

@Service("batchUpdateService")
@Transactional
public class BatchUpdateServiceImpl implements BatchUpdateService {

	MeteoPiRestClient piClient = new MeteoPiRestClient();
	
	final static Logger logger = Logger.getLogger(BatchUpdateServiceImpl.class);
	
	@Autowired
	MeteoService meteoService;
	
	public void registraDadesSensor() {
		// TODO Auto-generated method stub
		logger.debug("Inici BatchUpdateServiceImpl registraDadesSensor()"); 
		
		try {
		DadesMeteo response = piClient.getSensorReading();		
		meteoService.gravaRegistre(response);
		logger.debug("Fi BatchUpdateServiceImpl registraDadesSensor()");
		
		} catch (Exception e) {
		logger.error("BatchUpdateServiceImpl registraDadesSensor() ERROR: ",e);
		}
	}

}
