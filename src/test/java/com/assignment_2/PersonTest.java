package com.assignment_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testValidPersonCreation() {
        Person person = Person.builder()
                .id("0930287")
                .firstName("Eshwar")
                .lastName("Noola")
                .age(24)
                .gender("Male")
                .build();
        assertNotNull(person);
        assertEquals("Eshwar", person.getFirstName());
    }

    @Test
    void testInvalidPersonCreationWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .firstName("Eshwar")
                .lastName("Noola")
                .age(24)
                .gender("Male")
                .build());
    }

    @Test
    void testInvalidPersonCreationWithEmptyFirstName() {
        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .id("0930287")
                .firstName("")
                .lastName("Noola")
                .age(24)
                .gender("Male")
                .build());
    }

    @Test
    void testInvalidPersonCreationWithNegativeAge() {
        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .id("0930287")
                .firstName("Eshwar")
                .lastName("Noola")
                .age(-5)
                .gender("Male")
                .build());
    }
}