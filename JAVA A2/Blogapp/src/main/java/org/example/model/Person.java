package com.blogapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.jackson.Jacksonized;

/** Represents a person with an ID, name, age, and gender.*/

@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
public class Person {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String gender;

    @JsonCreator
    public Person(@JsonProperty("id") String id,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("age") Integer age,
                  @JsonProperty("gender") String gender) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID cannot be null or blank.");
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("First Name cannot be null or blank.");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last Name cannot be null or blank.");
        if (age != null && age < 0) throw new IllegalArgumentException("Age cannot be negative.");

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
}
