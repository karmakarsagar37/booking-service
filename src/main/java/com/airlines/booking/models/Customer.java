package com.airlines.booking.models;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Value
@Document(collection="customer")
public class Customer {
    @Id
    String id;
    String name;
    String email;
    String password;
    String gender;
}
