package fitnessapp.config;

import fitnessapp.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {

    @Bean
    public UserService getUserService(){
        return new UserService();
    }

}
