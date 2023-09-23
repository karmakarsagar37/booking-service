package com.airlines.booking.dagger.modules;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dagger.Module;
import dagger.Provides;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.Collections;

@Module
public class DbConfigurationModule {
    @Provides
    @Singleton
    @Named("databaseName")
    protected String provideDatabaseName() {
        return "bookings";
    }

    @Provides
    @Singleton
    @Named("mongoClient")
    public MongoClient provideMongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://sagar:sagar12345@cluster0.ryfnwqt.mongodb.net/?retryWrites=true&w=majority");
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
