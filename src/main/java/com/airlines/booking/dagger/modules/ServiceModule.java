package com.airlines.booking.dagger.modules;

import com.airlines.booking.dao.impl.UserDaoImpl;
import com.airlines.booking.services.implementation.UserServiceImplementation;
import dagger.Module;
import dagger.Provides;
import org.modelmapper.ModelMapper;

import javax.inject.Singleton;

@Module(includes = DaoModule.class)
public class ServiceModule {
    @Provides
    @Singleton
    ModelMapper provideModelMapper() {
        return new ModelMapper();
    }

    @Provides
    @Singleton
    UserServiceImplementation provideUserServiceImplementation(UserDaoImpl userDao, ModelMapper modelMapper) {
        return new UserServiceImplementation(modelMapper, userDao);
    }
}
