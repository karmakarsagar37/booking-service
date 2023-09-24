package com.airlines.booking.dagger;

import com.airlines.booking.dagger.modules.DaoModule;
import com.airlines.booking.dagger.modules.DbConfigurationModule;
import com.airlines.booking.dagger.modules.EnvironmentModule;
import com.airlines.booking.dagger.modules.ServiceModule;
import com.airlines.booking.dao.impl.UserDaoImpl;
import com.airlines.booking.services.implementation.UserServiceImplementation;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {EnvironmentModule.class, DbConfigurationModule.class, DaoModule.class, ServiceModule.class, })
public interface AppComponent {
    UserDaoImpl getUserDaoImpl();
    UserServiceImplementation getUserServiceImplementation();
}
