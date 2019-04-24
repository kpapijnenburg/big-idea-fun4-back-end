package fitnessapp.config;

import fitnessapp.service.SetService;
import fitnessapp.service.UserService;
import fitnessapp.service.WorkOutService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {

    @Bean
    public UserService getUserService(){
        return new UserService();
    }

    @Bean
    public WorkOutService getWorkOutService(){
        return new WorkOutService();
    }

    @Bean
    public SetService getSetService(){
        return new SetService();
    }

}
