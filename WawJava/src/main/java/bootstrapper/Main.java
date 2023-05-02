package bootstrapper;

import entities.BankAccount;
import entities.Person;
import exceptions.InvalidBankAccountOwnerException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println("Witamy w naszym systemie. Przedstaw sie:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Imie: ");
            var firstname = br.readLine();

            System.out.println("Nazwisko: ");
            var surname = br.readLine();

            System.out.println("Wiek: ");
            var age = Integer.parseInt(br.readLine());

            var person = new Person(firstname, surname, age, "Polska", 1);
            if (person.IsAdult()) {
                System.out.println("Podaj dane do konta bankowego:");

                System.out.println("Nazwa: ");
                var name = br.readLine();

                System.out.println("Numer konta: ");
                var accountNumber = br.readLine();

                /**
                 * Celowe wrzucenie wartości "null" w parametrze "owner",
                 * aby wymusić wywołanie wyjątku "InvalidBankAccountOwnerException".
                 */
                var bankAccount = new BankAccount(name, accountNumber, null, 1);

                System.out.println("Podsumowanie: \n" + bankAccount.toString());
            }
        } catch (InvalidBankAccountOwnerException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error("Blad przy podawaniu danych");
        } finally {
            System.out.println("Dziekujemy za skorzystanie z naszego systemu :)");
        }
    }
}