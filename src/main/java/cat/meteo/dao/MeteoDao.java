package cat.meteo.dao;

import java.util.Date;
import java.util.List;

import cat.meteo.domain.DadesMeteo;

public interface MeteoDao {
	
	    void gravaRegistre(DadesMeteo dadesMeteo);	 
	    void eliminaRegistre(DadesMeteo dadesMeteo);
	    List<DadesMeteo> cercaPerRang(Date dataInici, Date dataFi);	
	    float cercaMaximaPerRang(Date dataInici, Date dataFi);
	    float cercaMinimaPerRang(Date dataInici, Date dataFi);
	    List<DadesMeteo> cercaPerLloc(String lloc);
	    List<DadesMeteo> cerca(Date dataInici, Date dataFi,String lloc);
	

}
