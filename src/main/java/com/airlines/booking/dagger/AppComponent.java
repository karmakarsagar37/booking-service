package com.airlines.booking.dagger;

import com.airlines.booking.dagger.modules.DaoModule;
import com.airlines.booking.dagger.modules.DbConfigurationModule;
import com.airlines.booking.dagger.modules.ServiceModule;
import com.airlines.booking.dao.impl.UserDaoImpl;
import com.airlines.booking.services.implementation.UserServiceImplementation;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class, DbConfigurationModule.class, ServiceModule.class})
public interface AppComponent {
    UserDaoImpl getUserDaoImpl();
    UserServiceImplementation getUserServiceImplementation();
}
