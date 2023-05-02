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
    public Boolean IsAdult() {
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
     * Konstruktor tworzący osobe.
     * @param firstname Imię
     * @param surname Nazwisko
     * @param age Wiek
     * @param nationality Kraj pochodzenia
     * @param createdBy ID użytkownika, który tworzy encję
     */
    public Person(String firstname, String surname, int age, String nationality, long createdBy) {
        this.Firstname = firstname;
        this.Surname = surname;
        this.Age = age;
        this.Nationality = nationality;

        Create(createdBy);
    }
}
