package cat.meteo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;


@Configuration 
@ComponentScan("cat.meteo.service") 
public class QuartzConfiguration {
	
	@Autowired
	private Environment environment;

	
	@Bean
	public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
		obj.setTargetBeanName("batchUpdateService");
		obj.setTargetMethod("registraDadesSensor");
		return obj;
	}
	
	//Job  is scheduled for 3+1 times with the interval of 30 seconds
	@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
		SimpleTriggerFactoryBean stFactory = new SimpleTriggerFactoryBean();
		stFactory.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
		stFactory.setStartDelay(10000);
		stFactory.setRepeatInterval(1800000);
		return stFactory;
	}
	
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		scheduler.setTriggers(simpleTriggerFactoryBean().getObject());
		scheduler.setAutoStartup(true);
		return scheduler;
	}
} 