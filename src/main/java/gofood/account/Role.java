package gofood.account;

public enum Role {
    ADMIN("admin"),
    USER("user");

    public final String name;

    private Role(String name) {
        this.name = name;
    }
}
