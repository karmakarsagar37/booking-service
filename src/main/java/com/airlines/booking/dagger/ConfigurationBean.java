package com.airlines.booking.dagger;

import com.airlines.booking.dagger.modules.EnvironmentModule;
import com.airlines.booking.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.inject.Singleton;

@Configuration
public class ConfigurationBean {
    @Autowired
    Environment environment;
    @Bean
    @Singleton
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    @Singleton
    public AppComponent getDaggerComponent() {
        AppComponent component = DaggerAppComponent.builder().environmentModule(new EnvironmentModule(this.environment)).build();
        return component;
    }
    @Bean
    @Singleton
    UserService getUserService(){
        AppComponent appComponent = getDaggerComponent();
        return appComponent.getUserServiceImplementation();
    }
}
