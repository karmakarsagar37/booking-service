package com.airlines.booking;

import com.airlines.booking.dagger.AppComponent;
import com.airlines.booking.dagger.DaggerAppComponent;
import com.airlines.booking.services.UserService;
import dagger.Component;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.airlines.booking.dagger"})
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

}
