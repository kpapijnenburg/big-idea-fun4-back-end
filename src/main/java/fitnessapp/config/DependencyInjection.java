package fitnessapp.config;

import fitnessapp.model.Exercise;
import fitnessapp.service.*;
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

    @Bean
    public ExerciseService getExerciseService(){
        return new ExerciseService();
    }

    @Bean
    public CategoryService getCategoryService(){
        return new CategoryService();
    }

}
