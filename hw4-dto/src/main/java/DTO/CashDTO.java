package DTO;

/**
 * Created by olya on 15.04.15.
 */
public class CashDTO {
    private final long id;
    private final UserDTO owner;

    public CashDTO(long id, UserDTO owner) {
        this.id = id;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public UserDTO getOwner() {
        return owner;
    }
}
