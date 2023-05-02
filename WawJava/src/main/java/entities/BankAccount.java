package entities;

import base.Entity;
import exceptions.InvalidBankAccountOwnerException;

import java.math.MathContext;
import java.util.regex.Pattern;

/**
 * Klasa opisująca konto bankowe
 */
public class BankAccount extends Entity {
    /**
     * Nazwa konta
     */
    public String Name;

    /**
     * Nr konta - nr rachunku
     */
    public String AccountNumber;

    /**
     * Właściciel konta bankowego
     */
    public Person Owner;

    /**
     * Metoda tworzy konto bankowe
     * @param name Nazwa konta
     * @param accountNumber Nr konta
     * @param owner Właściciel
     * @param createdBy ID użytkownika, który utworzył konto bankowe
     * @return Nowo utworzony obiekt
     * @throws InvalidBankAccountOwnerException Gdy podany właściciel jest niepoprawny
     */
    public BankAccount Create(String name, String accountNumber, Person owner, long createdBy) throws InvalidBankAccountOwnerException {
        if (owner == null) {
            throw new InvalidBankAccountOwnerException();
        }

        var bankAccount = new BankAccount(name, accountNumber, owner);
        Create(createdBy);

        return bankAccount;
    }

    /**
     * Metoda aktualizuje konto bankowe
     * @param name Nazwa konta
     * @param accountNumber Nr konta
     * @param updatedBy ID użytkownika, który zaktualizował konto bankowe
     */
    public void Update(String name, String accountNumber, long updatedBy) {
        this.Name = name;
        this.AccountNumber = accountNumber;

        Update(updatedBy);
    }

    /**
     * Metoda sprawdzająca czy konto bankowe ma poprawny numer konta.
     * @return <c>true</c> gdy jest poprawne w innym przypadku <c>false</c>
     */
    public Boolean IsValid() {
        final var PATTERN = Pattern.compile("^\\d{26}$", Pattern.CASE_INSENSITIVE);
        var matcher = PATTERN.matcher(this.AccountNumber);

        return matcher.find();
    }

    private BankAccount(String name, String accountNumber, Person owner) {
        this.Name = name;
        this.AccountNumber = accountNumber;
        this.Owner = owner;
    }
}
