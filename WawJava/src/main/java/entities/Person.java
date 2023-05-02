package entities;

import base.Entity;

/**
 * Klasa opisująca osobę
 */
public class Person extends Entity {
    /**
     * Imię
     */
    public String Firstname;

    /**
     * Nazwisko
     */
    public String Surname;

    /**
     * Wiek
     */
    public int Age;

    /**
     * Kraj pochodzenia
     */
    public String Nationality;

    /**
     * Metoda sprawdzająca czy osoba jest pełnoletnia czy nie
     * @return <c>true</c> jeśli osoba jest pełnoletnia, w innym przypadku <c>false</c>
     */
    public Boolean isAdult() {
        return this.Age >= 18;
    }

    /**
     * Metoda aktualizująca osobę.
     * @param firstname Imię
     * @param surname Nazwisko
     * @param age Wiek
     * @param nationality Kraj pochodzenia
     * @param updatedBy ID użytkownika, który aktualizuje encję
     */
    public void Update(String firstname, String surname, int age, String nationality, long updatedBy) {
        this.Firstname = firstname;
        this.Surname = surname;
        this.Age = age;
        this.Nationality = nationality;

        Update(updatedBy);
    }

    /**
     * Metoda tworzy i zwraca nowo utworzoną osobę.
     * @param firstname Imię
     * @param surname Nazwisko
     * @param age Wiek
     * @param nationality Kraj pochodzenia
     * @param createdBy ID użytkownika, który tworzy encję
     * @return Nowo utworzony obiekt osoby.
     */
    public Person Create(String firstname, String surname, int age, String nationality, long createdBy) {
        var person = new Person(firstname, surname, age, nationality);
        Create(createdBy);

        return person;
    }

    private Person(String firstname, String surname, int age, String nationality) {
        this.Firstname = firstname;
        this.Surname = surname;
        this.Age = age;
        this.Nationality = nationality;
    }
}
