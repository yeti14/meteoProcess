package cat.meteo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import cat.meteo.AppConfig;
import cat.meteo.domain.DadesMeteo;
import static org.junit.Assert.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.hamcrest.Matchers;


@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from the static inner ContextConfiguration class
@ContextConfiguration(classes = AppConfig.class)
public class MeteoServiceTest {

    @Configuration
    static class ContextConfiguration {

        // this bean will be injected into the OrderServiceTest class
        @Bean
        public MeteoService meteoService() {
            MeteoService meteoService = new MeteoServiceImpl();
            // set properties, etc.
            return meteoService;
        }
    }

    @Autowired
    private MeteoService meteoService;

    @Test
    public void testMeteoServiceCercaPerLloc() {
        // test the orderService
    	List<DadesMeteo> dades = meteoService.cercaPerLloc("S1");
    	
    	assertThat(dades.size(),Matchers.greaterThan(0));
    
    }
    
    @Test
    public void testMeteoServiceCercaPerRang() {
        // test the orderService
       	
    	List<DadesMeteo> dades = meteoService.cercaPerRang(new GregorianCalendar(2015,4,6,20,24,56).getTime(), Calendar.getInstance().getTime());
    	assertThat(dades.size(),Matchers.greaterThan(0));
    }
    
    @Test
    public void testMeteoServiceCerca() {
        // test the orderService
       	
    	List<DadesMeteo> dades = meteoService.cerca(new GregorianCalendar(2015,4,6,20,24,56).getTime(), Calendar.getInstance().getTime(),"S1");
    	assertThat(dades.size(),Matchers.greaterThan(0));
    }
    
    @Test
    public void testMeteServiceGravaRegistre() {
    	
    	DadesMeteo dades = new DadesMeteo();
    	Date dataActual = Calendar.getInstance().getTime();
    	List<DadesMeteo> result = meteoService.cercaPerLloc("S1");
    	
    	dades.setData(dataActual);
    	dades.setPressio(1024);
    	dades.setTemperatura((float)29.5);
    	dades.setZona("S1");
    	meteoService.gravaRegistre(dades);
    	
    	List<DadesMeteo> resultAfterAdd = meteoService.cercaPerLloc("S1");
    	
    	   	
    	assertThat(resultAfterAdd.size(),Matchers.is(result.size()+1));
    	
    	meteoService.eliminaRegistre(dades);
    	
    	List<DadesMeteo> resultAfterDelete = meteoService.cercaPerLloc("S1");
    	
    	assertThat(resultAfterDelete.size(),Matchers.is(result.size()));
    	
    }}