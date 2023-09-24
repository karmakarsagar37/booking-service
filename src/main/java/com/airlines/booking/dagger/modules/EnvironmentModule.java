package com.airlines.booking.dagger.modules;

import dagger.Module;
import dagger.Provides;
import org.springframework.core.env.Environment;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class EnvironmentModule {
    private final Environment environment;

    public EnvironmentModule(Environment environment) {
        this.environment = environment;
    }
    @Provides
    @Singleton
    @Named("Environment")
    public Environment provideEnvironment() {
        return this.environment;
    }
}
