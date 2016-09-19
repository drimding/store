package org.dreamcatcher.shop.enums;

/**
 * Created by dreamcatcher on 18/09/16.
 */
public enum Errors {
    DATABASE(1, "A database error has occured."),
    DUPLICATE_USER(5007, "This user already exists."),
    ok(200, "ok");

    private final int id;
    private final String message;

    Errors(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() { return id; }
    public String getMessage() { return message; }
}
