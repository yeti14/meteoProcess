package cat.meteo.service;

import java.util.Date;
import java.util.List;

import cat.meteo.domain.DadesMeteo;


public interface MeteoService {
	
	public List<DadesMeteo> cercaPerRang (Date dataInici, Date dataFi);
	public List<DadesMeteo> cercaPerLloc(String lloc);
	public List<DadesMeteo> cerca(Date dataInici, Date dataFi,String lloc);
	public float cercaMaximaPerRang(Date dataInici, Date dataFi);
	public float cercaMinimaPerRang(Date dataInici, Date dataFi);
	public void gravaRegistre(DadesMeteo registre);
	public void eliminaRegistre(DadesMeteo registre);
	public DadesMeteo getDadesSensor();
}
