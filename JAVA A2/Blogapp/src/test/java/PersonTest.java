package com.blogapp;

import com.blogapp.model.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Unit tests for the Person class.*/
class PersonTest {

    @Test
    void testValidPersonCreation() {
        Person person = Person.builder()
                .id("C0931")
                .firstName("Mahedi")
                .lastName("Sunasra")
                .age(30)
                .gender("Male")
                .build();
        assertNotNull(person);
    }

    @Test
    void testInvalidPersonCreation_NullID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Person.builder().id(null).firstName("Tasnim").lastName("Ali").age(25).gender("Female").build());
        assertEquals("ID cannot be null or blank.", exception.getMessage());
    }
}

