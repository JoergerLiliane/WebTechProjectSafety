package com.example.Safety.api.config;

import com.example.Safety.api.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    //Inspo Github von Herrn Wider
    @Test
    void testToString() {
        //Actual
        String firstName = "Karla";
        String lastName = "Jörger";
        int phoneNumber = 123;


        //Under test: Add and Change the userId
        User user = new User(firstName, lastName,phoneNumber);
        user.setId(200L);

        //Expected
        String expected = "User{id=200, firstName='Karla', lastName='Jörger', phonNumber=123}";

        //Result
        String actual = user.toString();

        //Comparing Actual with Expected
        assertEquals(expected, actual);
    }
}
