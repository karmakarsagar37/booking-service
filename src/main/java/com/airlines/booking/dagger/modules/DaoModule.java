package com.airlines.booking.dagger.modules;

import com.airlines.booking.dao.impl.UserDaoImpl;
import com.airlines.booking.repo.UserRepo;
import dagger.Module;
import dagger.Provides;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.inject.Named;
import javax.inject.Singleton;

@Module(includes = {DbConfigurationModule.class, RepositoryModule.class})
public class DaoModule {
    @Provides
    @Singleton
    UserDaoImpl provideUserDaoImpl(UserRepo userRepo) {
        return new UserDaoImpl(userRepo);
    }
}
