package tests;

import entities.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void IsAdult_Should_Return_True_When_Person_Is_Adult() {
        var person = new Person("Kacper", "Kossakowski", 21, "Polska", 1);
        assertEquals(true, person.IsAdult());
    }

    @Test
    void IsAdult_Should_Return_False_When_Person_Is_Not_Adult() {
        var person = new Person("Kacper", "Kossakowski", 17, "Polska", 1);
        assertEquals(false, person.IsAdult());
    }

    @Test
    void On_Create_Should_Fill_Up_Create_Properties() {
        var person = new Person("Kacper", "Kossakowski", 21, "Polska", 1);
        assertEquals(1, person.CreatedBy);
        assertNotEquals(null, person.CreatedAt);
    }

    @Test
    void On_Update_Should_Update_Properties() {
        var person = new Person("Kacper", "Kossakowski", 22, "Polska", 1);

        person.Update("KacperUPDATE", "KossakowskiUPDATE", 21, "PolskaUPDATE", 2);

        assertEquals("KacperUPDATE", person.Firstname);
        assertEquals("KossakowskiUPDATE", person.Surname);
        assertEquals(21, person.Age);
        assertEquals("PolskaUPDATE", person.Nationality);
        assertEquals(2, person.UpdatedBy);
    }
}