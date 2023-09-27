package com.airlines.booking.dagger.modules;

import com.airlines.booking.models.User;
import com.airlines.booking.repo.UserRepo;
import dagger.Module;
import dagger.Provides;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.support.MappingMongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Module(includes = DbConfigurationModule.class)
public class RepositoryModule {
    @Provides
    @Singleton
    public UserRepo provideYourEntityRepository(@Named("MongoTemplate") MongoTemplate mongoTemplate) {
//        return new UserRepo(new MappingMongoEntityInformation<>(), mongoTemplate);
        return new MongoRepositoryFactory(mongoTemplate).getRepository(UserRepo.class);
    }
}
