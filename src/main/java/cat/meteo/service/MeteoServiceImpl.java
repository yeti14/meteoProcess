package cat.meteo.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.meteo.dao.MeteoDao;
import cat.meteo.domain.DadesMeteo;
import cat.meteo.ws.client.MeteoPiRestClient;

@Service
@Transactional
public class MeteoServiceImpl implements MeteoService {

	@Autowired
	private MeteoDao meteoDao;
	
	MeteoPiRestClient piClient = new MeteoPiRestClient();

	
	public List<DadesMeteo> cercaPerLloc(String lloc) {
		return meteoDao.cercaPerLloc(lloc);
	}

	
	public List<DadesMeteo> cercaPerRang(Date dataInici, Date dataFi) {
		return meteoDao.cercaPerRang(dataInici, dataFi);
	}

	public List<DadesMeteo> cerca(Date dataInici, Date dataFi,String lloc) {
		return meteoDao.cerca(dataInici, dataFi,lloc);
	}
	
	
	
	
	public void gravaRegistre(DadesMeteo registre) {
		meteoDao.gravaRegistre(registre);

	}
	
	public void eliminaRegistre(DadesMeteo registre) {
		meteoDao.eliminaRegistre(registre);

	}
	
	public DadesMeteo getDadesSensor() {
		DadesMeteo meteo = new DadesMeteo();
		try {
			meteo =  piClient.getSensorReading();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return meteo;
	}


	@Override
	public float cercaMaximaPerRang(Date dataInici, Date dataFi) {
		// TODO Auto-generated method stub
		return meteoDao.cercaMaximaPerRang(dataInici, dataFi);
	}


	@Override
	public float cercaMinimaPerRang(Date dataInici, Date dataFi) {
		// TODO Auto-generated method stub
		return meteoDao.cercaMinimaPerRang(dataInici, dataFi);
	}
}
