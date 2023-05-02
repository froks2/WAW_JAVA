package base;

import java.time.LocalDateTime;

/**
 * Klasa implementująca bazowe pola dla encji (abstrakcyjnego bytu w systemie).
 * Poniższa klasa będzie wykorzystawana do rozszerzania innych klas o poniższe pola.
 */
public class Entity {
    /**
     * ID - identyfikator encji
     */
    public long ID;

    /**
     * Data utworzenia
     */
    public LocalDateTime CreatedAt;

    /**
     * ID użytkownika, który utworzył encję
     */
    public long CreatedBy;

    /**
     * Data usunięcia
     */
    public LocalDateTime DeletedAt;

    /**
     * ID użytkownika, który usunął encję
     */
    public long DeletedBy;

    /**
     * Data zaktualizowania
     */
    public LocalDateTime UpdatedAt;

    /**
     * ID użytkownika, który zaktualizował encję
     */
    public long UpdatedBy;

    /**
     * Metoda wykorzystywana podczas usuwania encji.
     * Uzupełnia kto i kiedy usunął encję.
     * @param deletedBy ID użytkownika, który usunął encję.
     */
    public void Delete(long deletedBy) {
        this.DeletedBy = deletedBy;
        this.DeletedAt = LocalDateTime.now();
    }

    /**
     * Metoda wykorzystywana podczas aktualizowania encji.
     * Uzupełnia kto i kiedy zaktualizował encję.
     * @param updatedBy ID użytkownika, który zaktualizował encję.
     */
    public void Update(long updatedBy) {
        this.UpdatedBy = updatedBy;
        this.UpdatedAt = LocalDateTime.now();
    }

    /**
     * Metoda wykorzystywana podczas tworzenia encji.
     * Uzupełnia kto i kiedy utworzył encję.
     * @param createdBy ID użytkownika, który utworzył encję.
     */
    public void Create(long createdBy) {
        this.CreatedBy = createdBy;
        this.CreatedAt = LocalDateTime.now();
    }
}
