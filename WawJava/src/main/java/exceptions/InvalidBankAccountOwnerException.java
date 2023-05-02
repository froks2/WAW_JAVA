package exceptions;

/**
 * Klasa opisująca wyjątek związany z niepoprawnym właścicielem konta bankowego.
 */
public class InvalidBankAccountOwnerException extends Exception {
    public final String CODE = "inv_bank_acc_owner";

    @Override
    public String getMessage() {
        return "Konto bankowe posiada niepoprawnego właściciela!";
    }
}
