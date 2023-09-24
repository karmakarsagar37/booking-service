package com.airlines.booking.dagger.modules;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dagger.Module;
import dagger.Provides;
import jakarta.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Module(includes = EnvironmentModule.class)
public class DbConfigurationModule {
    @Provides
    @Singleton
    @Named("databaseName")
    public String provideDatabaseName(@Named("Environment")Environment environment) {
        System.out.println("[ENVIRONMENT]" + environment.getProperty("DB_NAME"));
        return environment.getProperty("DB_NAME");
    }

    @Provides
    @Singleton
    @Named("mongoClient")
    public MongoClient provideMongoClient(@Named("Environment") @NotNull Environment environment) {
        System.out.println("[ENVIRONMENT]" + environment.getProperty("MONGODB_URL"));
        ConnectionString connectionString = new ConnectionString(environment.getProperty("MONGODB_URL"));
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }


    @Provides
    @Singleton
    public Collection getMappingBasePackages() {
        return Collections.singleton("com.sagar");
    }

    @Provides
    @Singleton
    @Named("MongoTemplate")
    public MongoTemplate provideMongoTemplate(@Named("mongoClient") MongoClient mongoClient, @Named("databaseName") String database) {
        return new MongoTemplate(mongoClient, database);
    }
}
