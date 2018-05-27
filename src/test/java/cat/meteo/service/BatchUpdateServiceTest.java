package cat.meteo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cat.meteo.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BatchUpdateServiceTest {

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
    private BatchUpdateService batchUpdateService;
    
    @Test
    public void registraDadesSensorTest() {
    	
    	batchUpdateService.registraDadesSensor();    	
    	
    }
    
    
}
