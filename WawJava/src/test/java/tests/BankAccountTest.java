package tests;

import entities.BankAccount;
import entities.Person;
import exceptions.InvalidBankAccountOwnerException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void IsValid_Should_Return_True_When_Bank_Account_Has_Valid_Account_Number() throws InvalidBankAccountOwnerException {
        var person = new Person("Kacper", "Kossakowski", 21, "Polska", 1);
        var bankAccount = new BankAccount("Konto1", "98248011685528318489806317", person, 1);

        assertEquals(true, bankAccount.IsValid());
    }

    @Test
    void IsValid_Should_Return_False_When_Bank_Account_Has_Invalid_Account_Number() throws InvalidBankAccountOwnerException {
        var person = new Person("Kacper", "Kossakowski", 21, "Polska", 1);
        var bankAccount = new BankAccount("Konto1", "nieporpawny", person, 1);

        assertEquals(false, bankAccount.IsValid());
    }

    @Test
    void On_Create_Should_Fill_Up_Create_Properties() throws InvalidBankAccountOwnerException {
        var person = new Person("Kacper", "Kossakowski", 21, "Polska", 1);
        var bankAccount = new BankAccount("Konto1", "98248011685528318489806317", person, 1);

        assertEquals("Konto1", bankAccount.Name);
        assertEquals("98248011685528318489806317", bankAccount.AccountNumber);
        assertEquals(person, bankAccount.Owner);
    }

    @Test
    void On_Update_Should_Update_Properties() throws InvalidBankAccountOwnerException {
        var person = new Person("Kacper", "Kossakowski", 22, "Polska", 1);

        var bankAccount = new BankAccount("Konto1", "98248011685528318489806317", person, 1);
        bankAccount.Update("Konto1UPDATE", "12348011685528318489806317", 2);

        assertEquals("Konto1UPDATE", bankAccount.Name);
        assertEquals("12348011685528318489806317", bankAccount.AccountNumber);
        assertEquals(2, bankAccount.UpdatedBy);
    }

    @Test
    void On_Create_With_Invalid_Owner_Should_Throw_InvalidBankAccountOwnerException() throws InvalidBankAccountOwnerException {
        assertThrows(InvalidBankAccountOwnerException.class, () -> {
            new BankAccount("Konto1", "98248011685528318489806317", null, 1);
        });
    }
}